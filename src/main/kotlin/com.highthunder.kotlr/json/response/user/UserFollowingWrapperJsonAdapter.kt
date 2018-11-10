package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import com.squareup.moshi.*

/**
 * UserFollowingWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class UserFollowingWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
            moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseUserFollowing.Body> =
            moshi.adapter<ResponseUserFollowing.Body>(ResponseUserFollowing.Body::class.java, kotlin.collections.emptySet(), null)

    @FromJson
    fun fromJson(reader: JsonReader): ResponseUserFollowing.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseUserFollowing.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseUserFollowing.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.NULL -> ResponseUserFollowing.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseUserFollowing.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
