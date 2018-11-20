package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Color
import com.highthunder.kotlr.types.Colors
import com.squareup.moshi.*

class ColorsJsonAdapter(moshi: Moshi) {

    private val nullableColorAdapter: JsonAdapter<Color?> =
        moshi.adapter(Color::class.java, kotlin.collections.emptySet(), null)

    override fun toString(): String = "JsonAdapter(Colors)"

    /**
     * TODO: Documentation
     */
    @FromJson
    fun fromJson(reader: JsonReader): Colors {
        val colors: MutableMap<Int, Color> = mutableMapOf()
        reader.beginObject()
        while (reader.hasNext()) {
            val number = reader.nextName().drop(1).toInt()
            when (reader.peek()) {
                JsonReader.Token.STRING -> colors[number] = Color(reader.nextString())
                JsonReader.Token.NUMBER -> colors[number] = Color(reader.nextInt())
                else -> throw JsonDataException("Expected string while parsing colors, but got ${reader.peek()}")
            }
        }
        reader.endObject()
        return Colors(colors)
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(writer: JsonWriter, value: Colors?) {
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