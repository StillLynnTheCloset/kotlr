package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.squareup.moshi.*

/**
 * BlogDraftsWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class BlogDraftsWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
            moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseBlogDrafts.Body> =
            moshi.adapter<ResponseBlogDrafts.Body>(ResponseBlogDrafts.Body::class.java, kotlin.collections.emptySet(), null).failOnUnknown()

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
            moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), kotlin.collections.emptySet(), null).failOnUnknown()

    @FromJson
    fun fromJson(reader: JsonReader): ResponseBlogDrafts.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseBlogDrafts.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseBlogDrafts.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseBlogDrafts.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseBlogDrafts.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseBlogDrafts.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
