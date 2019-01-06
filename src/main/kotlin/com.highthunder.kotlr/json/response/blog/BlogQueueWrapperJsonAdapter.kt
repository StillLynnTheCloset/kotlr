package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.squareup.moshi.*

/**
 * BlogQueueWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class BlogQueueWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseBlogQueue.Body> =
        moshi.adapter<ResponseBlogQueue.Body>(ResponseBlogQueue.Body::class.java, kotlin.collections.emptySet(), null)
            .failOnUnknown()

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(
            Types.newParameterizedType(List::class.java, Any::class.java),
            kotlin.collections.emptySet(),
            null
        ).failOnUnknown()

    /**
     * TODO: Documentation
     */
    @FromJson
    fun fromJson(reader: JsonReader): WrapperInterface<ResponseBlogQueue.Body> {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseBlogQueue.Wrapper(body = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseBlogQueue.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseBlogQueue.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseBlogQueue.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseBlogQueue.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }

}
