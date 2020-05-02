package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Color
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

/**
 * TODO: Documentation
 */
internal class ColorJsonAdapter() : JsonAdapter<Color>() {

    override fun toString(): String = "JsonAdapter(Colors)"

    /**
     * TODO: Documentation
     */
    @FromJson
    override fun fromJson(reader: JsonReader): Color {
        return when (reader.peek()) {
            JsonReader.Token.STRING -> Color(reader.nextString())
            JsonReader.Token.NUMBER -> Color(reader.nextInt())
            else -> throw JsonDataException("Expected string or int while parsing color, but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    override fun toJson(writer: JsonWriter, value: Color?) {
//        if (value == null) {
//            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
//        }
        writer.value(value?.asString())
    }
}
