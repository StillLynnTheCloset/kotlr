package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.content.Attribution
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

/**
 * MediaWrapperJsonAdapter - An adapter to help Moshi convert [MediaWrapper] objects to and
 * from either a single [Media] object, or a list of them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class AttributionWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<AttributionWrapper>() {

    private val attributionAdapter: JsonAdapter<Attribution?> =
        moshi.adapter(Attribution::class.java, emptySet(), null)

    private val listOfAttributionAdapter: JsonAdapter<List<Attribution>> =
        moshi.adapter<List<Attribution>>(
            Types.newParameterizedType(List::class.java, Attribution::class.java),
            emptySet(),
            null
        )

    /**
     * TODO: Documentation
     */
    @FromJson
    override fun fromJson(reader: JsonReader): AttributionWrapper? {
        return when (reader.peek()) {
            BEGIN_ARRAY -> AttributionWrapper(listAttribution = listOfAttributionAdapter.fromJson(reader))
            BEGIN_OBJECT -> AttributionWrapper(singleAttribution = attributionAdapter.fromJson(reader))
            NULL -> null
            else -> throw JsonDataException("Expected a field of type List or Attribution but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    override fun toJson(writer: JsonWriter, value: AttributionWrapper?) {
        when {
            value == null -> attributionAdapter.toJson(writer, null)
            value.singleAttribution != null -> attributionAdapter.toJson(writer, value.singleAttribution)
            value.listAttribution != null && value.listAttribution.isNotEmpty() -> listOfAttributionAdapter.toJson(
                writer,
                value.listAttribution
            )
            else -> attributionAdapter.toJson(writer, null)
        }
    }
}
