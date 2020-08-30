package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.adapter
import com.highthunder.kotlr.listAdapter
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
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
 * BlogQueueWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseBlogQueue].
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class BlogQueueWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<ResponseBlogQueue.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponseBlogQueue.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseBlogQueue.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseBlogQueue.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseBlogQueue.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseBlogQueue.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseBlogQueue.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseBlogQueue.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
