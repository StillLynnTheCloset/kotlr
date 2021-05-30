package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.adapter
import com.highthunder.kotlr.listAdapter
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
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

/**
 * BlogInfoWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseBlogInfo].
 *
 * @author highthunder
 * @since 2018-11-10
 */
internal class BlogInfoWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<ResponseBlogInfo.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponseBlogInfo.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseBlogInfo.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseBlogInfo.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseBlogInfo.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseBlogInfo.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseBlogInfo.Wrapper()
            else -> throw JsonDataException(
                "Expected a field of type Object, String, List, or null but got ${reader.peek()}"
            )
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseBlogInfo.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
