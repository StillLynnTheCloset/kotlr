package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.*

/**
 * PlayerWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class PlayerWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<PlayerWrapper>() {

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
            JsonReader.Token.BEGIN_ARRAY -> PlayerWrapper(contentList = listOfVideoAdapter.fromJson(reader))
            JsonReader.Token.STRING -> PlayerWrapper(contentString = stringAdapter.fromJson(reader))
            JsonReader.Token.NULL -> null
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
            value.contentList != null && value.contentList?.size != 0 -> listOfVideoAdapter.toJson(
                writer,
                value.contentList ?: listOf()
            )
            else -> stringAdapter.toJson(writer, null)
        }
    }

}
