package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import com.squareup.moshi.*

/**
 * UserInfoWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class UserInfoWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseUserInfo.Body> =
        moshi.adapter<ResponseUserInfo.Body>(ResponseUserInfo.Body::class.java, kotlin.collections.emptySet(), null)
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
    fun fromJson(reader: JsonReader): WrapperInterface<ResponseUserInfo.Body> {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseUserInfo.Wrapper(body = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseUserInfo.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseUserInfo.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseUserInfo.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseUserInfo.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }

}
