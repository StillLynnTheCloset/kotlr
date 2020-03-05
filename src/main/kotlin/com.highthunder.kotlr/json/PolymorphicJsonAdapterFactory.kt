package com.highthunder.kotlr.json

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException
import java.lang.reflect.Type
import java.util.ArrayList

/**
 * A JsonAdapter factory for objects that include type information in the JSON. When decoding JSON
 * Moshi uses this type information to determine which class to decode to. When encoding Moshi uses
 * the object’s class to determine what type information to include.
 *
 * <p>Suppose we have an interface, its implementations, and a class that uses them:
 *
 * <pre> {@code
 *
 *   interface HandOfCards {
 *   }
 *
 *   class BlackjackHand extends HandOfCards {
 *     Card hidden_card;
 *     List<Card> visible_cards;
 *   }
 *
 *   class HoldemHand extends HandOfCards {
 *     Set<Card> hidden_cards;
 *   }
 *
 *   class Player {
 *     String name;
 *     HandOfCards hand;
 *   }
 * }</pre>
 *
 * <p>We want to decode the following JSON into the player model above:
 *
 * <pre> {@code
 *
 *   {
 *     "name": "Jesse",
 *     "hand": {
 *       "hand_type": "blackjack",
 *       "hidden_card": "9D",
 *       "visible_cards": ["8H", "4C"]
 *     }
 *   }
 * }</pre>
 *
 * <p>Left unconfigured, Moshi would incorrectly attempt to decode the hand object to the abstract
 * {@code HandOfCards} interface. We configure it to use the appropriate subtype instead:
 *
 * <pre> {@code
 *
 *   Moshi moshi = new Moshi.Builder()
 *       .add(PolymorphicJsonAdapterFactory.of(HandOfCards.class, "hand_type")
 *           .withSubtype(BlackjackHand.class, "blackjack")
 *           .withSubtype(HoldemHand.class, "holdem"))
 *       .build();
 * }</pre>
 *
 * <p>This class imposes strict requirements on its use:
 *
 * <ul>
 *   <li>Base types may be classes or interfaces.
 *   <li>Subtypes must encode as JSON objects.
 *   <li>Type information must be in the encoded object. Each message must have a type label like
 *       {@code hand_type} whose value is a string like {@code blackjack} that identifies which type
 *       to use.
 *   <li>Each type identifier must be unique.
 * </ul>
 *
 * <p>For best performance type information should be the first field in the object. Otherwise Moshi
 * must reprocess the JSON stream once it knows the object's type.
 *
 * <p>If an unknown subtype is encountered when decoding, this will throw a {@link
 * JsonDataException}. If an unknown type is encountered when encoding, this will throw an {@link
 * IllegalArgumentException}. If the same subtype has multiple labels the first one is used when
 * encoding.
 *
 * <p>If you want to specify a custom unknown fallback for decoding, you can do so via
 * {@link #withDefaultValue(Object)}. This instance should be immutable, as it is shared.
 */
class PolymorphicJsonAdapterFactory<T> internal constructor(
    private val baseType: Class<T>,
    private val labelKey: String,
    private val labels: List<String>,
    private val subtypes: List<Type>,
    private val defaultValue: T?,
    private val defaultValueSet: Boolean,
    private val missingLabelType: Type?
) : JsonAdapter.Factory {
    companion object {
        /**
         * @param baseType The base type for which this factory will create adapters. Cannot be Object.
         * @param labelKey The key in the JSON object whose value determines the type to which to map the
         * JSON object.
         */
        fun <T> of(baseType: Class<T>, labelKey: String): PolymorphicJsonAdapterFactory<T> {
            return PolymorphicJsonAdapterFactory(
                baseType,
                labelKey, emptyList(), emptyList(),
                null,
                false,
                null
            )
        }
    }

    /**
     * Returns a new factory that decodes instances of `subtype`. When an unknown type is found
     * during encoding an [IllegalArgumentException] will be thrown. When an unknown label
     * is found during decoding a [JsonDataException] will be thrown.
     */
    fun withSubtype(subtype: Class<out T>, label: String): PolymorphicJsonAdapterFactory<T> {
        require(!labels.contains(label)) { "Labels must be unique." }
        val newLabels: MutableList<String> = ArrayList(labels)
        newLabels.add(label)
        val newSubtypes: MutableList<Type> = ArrayList(subtypes)
        newSubtypes.add(subtype)
        return PolymorphicJsonAdapterFactory(
            baseType,
            labelKey,
            newLabels,
            newSubtypes,
            defaultValue,
            defaultValueSet,
            missingLabelType
        )
    }

    /**
     * Returns a new factory that will default to [defaultValue] upon decoding of unrecognized
     * labels. The default value should be immutable.
     */
    fun withDefaultValue(defaultValue: T?): PolymorphicJsonAdapterFactory<T> {
        return PolymorphicJsonAdapterFactory(
            baseType,
            labelKey,
            labels,
            subtypes,
            defaultValue,
            true,
            missingLabelType
        )
    }

    /**
     * Returns a new factory that will attempt to decode values as type [missingLabelType] if [labelKey] is missing.
     */
    fun withMissingLabelType(missingLabelType: Class<out T>): PolymorphicJsonAdapterFactory<T> {
        return PolymorphicJsonAdapterFactory(
            baseType,
            labelKey,
            labels,
            subtypes,
            defaultValue,
            defaultValueSet,
            missingLabelType
        )
    }

    override fun create(
        type: Type,
        annotations: Set<Annotation?>,
        moshi: Moshi
    ): JsonAdapter<*>? {
        if (Types.getRawType(type) != baseType || annotations.isNotEmpty()) {
            return null
        }
        val jsonAdapters: MutableList<JsonAdapter<Any>> =
            ArrayList(subtypes.size)
        var i = 0
        val size = subtypes.size
        while (i < size) {
            jsonAdapters.add(moshi.adapter(subtypes[i]))
            i++
        }
        val missingLabelAdapter: JsonAdapter<Any>? = if (missingLabelType != null) {
            moshi.adapter(missingLabelType)
        } else {
            null
        }
        return PolymorphicJsonAdapter(
            labelKey,
            labels,
            subtypes,
            jsonAdapters,
            defaultValue,
            defaultValueSet,
            missingLabelAdapter
        ).nullSafe()
    }

    internal class PolymorphicJsonAdapter(
        private val labelKey: String,
        private val labels: List<String>,
        private val subtypes: List<Type>,
        private val jsonAdapters: List<JsonAdapter<Any>>,
        private val defaultValue: Any?,
        private val defaultValueSet: Boolean,
        private val missingLabelAdapter: JsonAdapter<Any>?
    ) : JsonAdapter<Any?>() {

        /** Single-element options containing the label's key only.  */
        private val labelKeyOptions: JsonReader.Options = JsonReader.Options.of(labelKey)

        /** Corresponds to subtypes.  */
        private val labelOptions: JsonReader.Options = JsonReader.Options.of(*labels.toTypedArray())

        @Throws(IOException::class)
        override fun fromJson(reader: JsonReader): Any? {
            val peeked = reader.peekJson()
            peeked.setFailOnUnknown(false)
            val labelIndex: Int = peeked.use { labelIndex(it) }
            if (labelIndex == -1) {
                reader.skipValue()
                return defaultValue
            }
            if (labelIndex == -2 && missingLabelAdapter != null) {
                return missingLabelAdapter.fromJson(reader)
            }
            return jsonAdapters[labelIndex].fromJson(reader)
        }

        @Throws(IOException::class)
        private fun labelIndex(reader: JsonReader): Int {
            reader.beginObject()
            while (reader.hasNext()) {
                if (reader.selectName(labelKeyOptions) == -1) {
                    reader.skipName()
                    reader.skipValue()
                    continue
                }
                val labelIndex = reader.selectString(labelOptions)
                if (labelIndex == -1 && !defaultValueSet) {
                    throw JsonDataException(
                        "Expected one of $labels for key '$labelKey' but found '${reader.nextString()}'. Register a subtype for this label."
                    )
                }
                return labelIndex
            }
            return if (missingLabelAdapter != null) {
                -2
            } else {
                throw JsonDataException("Missing label for $labelKey")
            }
        }

        @Throws(IOException::class)
        override fun toJson(writer: JsonWriter, value: Any?) {
            val type: Class<*> = value!!.javaClass
            val labelIndex = subtypes.indexOf(type)
            require(labelIndex != -1) {
                "Expected one of $subtypes but found $value, a ${value.javaClass}. Register this subtype."
            }
            val adapter = jsonAdapters[labelIndex]
            writer.beginObject()
            writer.name(labelKey).value(labels[labelIndex])
            val flattenToken = writer.beginFlatten()
            adapter.toJson(writer, value)
            writer.endFlatten(flattenToken)
            writer.endObject()
        }

        override fun toString(): String {
            return "CustomPolymorphicJsonAdapter($labelKey)"
        }
    }
}
