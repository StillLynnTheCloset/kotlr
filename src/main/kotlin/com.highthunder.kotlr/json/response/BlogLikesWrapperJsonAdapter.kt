package com.highthunder.kotlr.json.response

import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.squareup.moshi.*

/**
 * BlogLikesWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class BlogLikesWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
            moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseBlogLikes.Body> =
            moshi.adapter<ResponseBlogLikes.Body>(ResponseBlogLikes.Body::class.java, kotlin.collections.emptySet(), null)

    @FromJson
    fun fromJson(reader: JsonReader): ResponseBlogLikes.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseBlogLikes.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseBlogLikes.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.NULL -> ResponseBlogLikes.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseBlogLikes.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
