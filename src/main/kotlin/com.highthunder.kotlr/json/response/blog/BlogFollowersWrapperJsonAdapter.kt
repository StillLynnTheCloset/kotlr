package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.squareup.moshi.*

/**
 * BlogFollowersWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class BlogFollowersWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseBlogFollowers.Body> =
        moshi.adapter<ResponseBlogFollowers.Body>(
            ResponseBlogFollowers.Body::class.java,
            kotlin.collections.emptySet(),
            null
        ).failOnUnknown()

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(
            Types.newParameterizedType(List::class.java, Any::class.java),
            kotlin.collections.emptySet(),
            null
        ).failOnUnknown()

    @FromJson
    fun fromJson(reader: JsonReader): ResponseBlogFollowers.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseBlogFollowers.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseBlogFollowers.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseBlogFollowers.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseBlogFollowers.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseBlogFollowers.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
