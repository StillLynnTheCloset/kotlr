package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Color
import com.highthunder.kotlr.types.Colors
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson

/**
 * TODO: Documentation
 */
internal class ColorsJsonAdapter(moshi: Moshi) : JsonAdapter<Colors>() {

    private val nullableColorAdapter: JsonAdapter<Color?> =
        moshi.adapter(Color::class.java, emptySet(), null)

    override fun toString(): String = "JsonAdapter(Colors)"

    /**
     * TODO: Documentation
     */
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

    /**
     * TODO: Documentation
     */
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
