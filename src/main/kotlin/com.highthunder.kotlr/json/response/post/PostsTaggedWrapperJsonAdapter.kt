package com.highthunder.kotlr.json.response.post

import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.post.ResponsePostsTagged
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
 * UserDashboardWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class PostsTaggedWrapperJsonAdapter(moshi: Moshi) :
    JsonAdapter<WrapperInterface<ResponsePostsTagged.Body>>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponsePostsTagged.Body> =
        moshi.adapter<ResponsePostsTagged.Body>(
            ResponsePostsTagged.Body::class.java, emptySet(), null)

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), emptySet(), null)

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponsePostsTagged.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponsePostsTagged.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponsePostsTagged.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponsePostsTagged.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponsePostsTagged.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponsePostsTagged.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
