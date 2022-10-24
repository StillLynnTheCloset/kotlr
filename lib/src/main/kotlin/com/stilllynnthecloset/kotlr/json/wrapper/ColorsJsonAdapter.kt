package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.types.Color
import com.stilllynnthecloset.kotlr.types.Colors

/**
 * ColorsJsonAdapter - A custom adapter to help Moshi parse [Colors] objects.
 *
 * This helps convert the property names from "c1", "c2" to the numbers 1, 2, etc.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-18
 */
internal class ColorsJsonAdapter(moshi: Moshi) : JsonAdapter<Colors>() {

    private val nullableColorAdapter: JsonAdapter<Color?> =
        moshi.adapter(Color::class.java, emptySet(), null)

    override fun toString(): String = "JsonAdapter(Colors)"

    @FromJson
    override fun fromJson(reader: JsonReader): Colors {
        val colors: MutableMap<Int, Color> = mutableMapOf()
        reader.beginObject()
        while (reader.hasNext()) {
            val number = reader.nextName().drop(1).toInt()
            when (reader.peek()) {
                JsonReader.Token.STRING -> colors[number] = Color(reader.nextString())
                JsonReader.Token.NUMBER -> colors[number] = Color(reader.nextInt())
                else -> throw JsonDataException("Expected string or int while parsing colors, but got ${reader.peek()}")
            }
        }
        reader.endObject()
        return Colors(colors)
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Colors?) {
//        if (value == null) {
//            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
//        }
        writer.beginObject()
        value?.colors?.entries?.sortedBy(Map.Entry<Int, Color>::key)?.forEach {
            writer.name("c${it.key}")
            nullableColorAdapter.toJson(writer, it.value)
        }
        writer.endObject()
    }
}
