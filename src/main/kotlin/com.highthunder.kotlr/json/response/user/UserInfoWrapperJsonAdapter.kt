package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.adapter
import com.highthunder.kotlr.listAdapter
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
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
 * UserInfoWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseUserInfo].
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
internal class UserInfoWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<ResponseUserInfo.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponseUserInfo.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseUserInfo.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseUserInfo.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseUserInfo.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseUserInfo.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseUserInfo.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseUserInfo.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
