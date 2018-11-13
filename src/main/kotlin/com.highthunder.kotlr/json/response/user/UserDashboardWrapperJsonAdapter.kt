package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.squareup.moshi.*

/**
 * UserDashboardWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class UserDashboardWrapperJsonAdapter(moshi: Moshi) {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, kotlin.collections.emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseUserDashboard.Body> =
        moshi.adapter<ResponseUserDashboard.Body>(
            ResponseUserDashboard.Body::class.java,
            kotlin.collections.emptySet(),
            null
        ).failOnUnknown()

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(
            Types.newParameterizedType(List::class.java, Any::class.java),
            kotlin.collections.emptySet(),
            null
        ).failOnUnknown()

    @FromJson
    fun fromJson(reader: JsonReader): ResponseUserDashboard.Wrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> ResponseUserDashboard.Wrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> ResponseUserDashboard.Wrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> ResponseUserDashboard.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> ResponseUserDashboard.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: ResponseUserDashboard.Wrapper?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.response)
        }
    }

}
