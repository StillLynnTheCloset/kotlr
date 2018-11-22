package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.*

/**
 * ContentWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class ContentWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<ContentWrapper>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val listOfContentAdapter: JsonAdapter<List<PostContent>> =
        moshi.adapter<List<PostContent>>(
            Types.newParameterizedType(List::class.java, PostContent::class.java),
            kotlin.collections.emptySet(),
            null
        )

    /**
     * TODO: Documentation
     */
    @FromJson
    override fun fromJson(reader: JsonReader): ContentWrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_ARRAY -> ContentWrapper(contentList = listOfContentAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ContentWrapper(contentString = stringAdapter.fromJson(reader))
            JsonReader.Token.NULL -> ContentWrapper()
            else -> throw JsonDataException("Expected a field of type List or Media but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    override fun toJson(writer: JsonWriter, value: ContentWrapper?) {
        if (value?.contentString != null) {
            stringAdapter.toJson(writer, value.contentString)
        } else {
            listOfContentAdapter.toJson(writer, value?.contentList ?: listOf())
        }
    }

}
