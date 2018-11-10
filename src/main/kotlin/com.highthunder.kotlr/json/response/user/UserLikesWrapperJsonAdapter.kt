package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import com.squareup.moshi.*

/**
 * UserLikesWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class UserLikesWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
            moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseUserLikes.Body> =
            moshi.adapter<ResponseUserLikes.Body>(ResponseUserLikes.Body::class.java, kotlin.collections.emptySet(), null).failOnUnknown()

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), kotlin.collections.emptySet(), null).failOnUnknown()

    @FromJson
    fun fromJson(reader: JsonReader): ResponseUserLikes.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseUserLikes.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseUserLikes.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseUserLikes.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseUserLikes.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseUserLikes.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
