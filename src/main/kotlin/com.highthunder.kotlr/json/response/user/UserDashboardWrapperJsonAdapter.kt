package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.response.GeneralWrapper
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.squareup.moshi.*

/**
 * UserDashboardWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class UserDashboardWrapperJsonAdapter(moshi: Moshi) {

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

    /**
     * TODO: Documentation
     */
    @FromJson
    fun fromJson(reader: JsonReader): WrapperInterface<ResponseUserDashboard.Body> {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_OBJECT -> GeneralWrapper(response = responseAdapter.fromJson(reader))
            JsonReader.Token.STRING -> GeneralWrapper(error = stringAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_ARRAY -> GeneralWrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            JsonReader.Token.NULL -> GeneralWrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseUserDashboard.Body>?) {
        if (value?.getError() != null) {
            stringAdapter.toJson(writer, value.getError())
        } else {
            responseAdapter.toJson(writer, value?.getBody())
        }
    }

}
