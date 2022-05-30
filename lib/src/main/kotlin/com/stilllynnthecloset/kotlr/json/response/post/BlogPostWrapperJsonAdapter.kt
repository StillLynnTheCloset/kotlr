package com.stilllynnthecloset.kotlr.json.response.post

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
import com.stilllynnthecloset.kotlr.adapter
import com.stilllynnthecloset.kotlr.listAdapter
import com.stilllynnthecloset.kotlr.response.WrapperInterface
import com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPost
import com.stilllynnthecloset.kotlr.types.Post

/**
 * PostsPostWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseBlogPost].
 *
 * Tumblr decided to make this one request special and put the post object directly as the value in `response` instead
 * of nesting it in another object like all of the other API responses.
 *
 * @author highthunder
 * @since 2019-12-01
 */
internal class BlogPostWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<Post>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<Post> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<Post> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseBlogPost.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseBlogPost.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseBlogPost.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseBlogPost.Wrapper()
            else -> throw JsonDataException(
                "Expected a field of type Object, String, List, or null but got ${reader.peek()}",
            )
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
