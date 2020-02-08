package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
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
import com.squareup.moshi.Types

/**
 * UserDashboardWrapperJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class UserDashboardWrapperJsonAdapter(moshi: Moshi) :
    JsonAdapter<WrapperInterface<ResponseUserDashboard.Body>>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, emptySet(), null)

    private val responseAdapter: JsonAdapter<ResponseUserDashboard.Body> =
        moshi.adapter<ResponseUserDashboard.Body>(ResponseUserDashboard.Body::class.java, emptySet(), null)

    private val listOfAnyAdapter: JsonAdapter<List<Any>> =
        moshi.adapter<List<Any>>(Types.newParameterizedType(List::class.java, Any::class.java), emptySet(), null)

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseUserDashboard.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseUserDashboard.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseUserDashboard.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseUserDashboard.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseUserDashboard.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseUserDashboard.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
