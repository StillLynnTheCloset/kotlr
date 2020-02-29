package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonReader.Token.STRING
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

/**
 * PlayerWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class PlayerWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<PlayerWrapper>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val listOfVideoAdapter: JsonAdapter<List<Video>> =
        moshi.adapter<List<Video>>(
            Types.newParameterizedType(List::class.java, Video::class.java),
            kotlin.collections.emptySet(),
            null
        )

    /**
     * TODO: Documentation
     */
    @FromJson
    override fun fromJson(reader: JsonReader): PlayerWrapper? {
        return when (reader.peek()) {
            BEGIN_ARRAY -> PlayerWrapper(contentList = listOfVideoAdapter.fromJson(reader))
            STRING -> PlayerWrapper(contentString = stringAdapter.fromJson(reader))
            NULL -> null
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    override fun toJson(writer: JsonWriter, value: PlayerWrapper?) {
        when {
            value == null -> stringAdapter.toJson(writer, null)
            value.contentString != null -> stringAdapter.toJson(writer, value.contentString)
            value.contentList != null && value.contentList.isNotEmpty() -> listOfVideoAdapter.toJson(
                writer,
                value.contentList
            )
            else -> stringAdapter.toJson(writer, null)
        }
    }
}
