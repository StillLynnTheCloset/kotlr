package com.highthunder.kotlr.json.response.blog

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.squareup.moshi.*

/**
 * BlogAvatarWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class BlogAvatarWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
            moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseBlogAvatar.Body> =
            moshi.adapter<ResponseBlogAvatar.Body>(ResponseBlogAvatar.Body::class.java, kotlin.collections.emptySet(), null)

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
            moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), kotlin.collections.emptySet(), null)

    @FromJson
    fun fromJson(reader: JsonReader): ResponseBlogAvatar.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseBlogAvatar.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseBlogAvatar.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseBlogAvatar.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseBlogAvatar.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseBlogAvatar.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
