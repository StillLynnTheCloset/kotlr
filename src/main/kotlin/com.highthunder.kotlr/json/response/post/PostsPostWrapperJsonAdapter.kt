package com.highthunder.kotlr.json.response.post

import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.post.ResponsePostsPost
import com.highthunder.kotlr.types.Post
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonReader.Token.STRING
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

/**
 * PostsPostWrapperJsonAdapter - TODO: Documentation
 *
 * Tumblr decided to make this one request special and put the post object directly as the value in `response` instead
 * of nesting it in another object like all of the other API responses.
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class PostsPostWrapperJsonAdapter(moshi: Moshi) :
    JsonAdapter<WrapperInterface<Post>>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, emptySet(), null)

    private val responseAdapter: JsonAdapter<Post> =
        moshi.adapter<Post>(
            Post::class.java, emptySet(), null)
            .failOnUnknown()

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), emptySet(), null)
            .failOnUnknown()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<Post> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponsePostsPost.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponsePostsPost.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponsePostsPost.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponsePostsPost.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<Post>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
