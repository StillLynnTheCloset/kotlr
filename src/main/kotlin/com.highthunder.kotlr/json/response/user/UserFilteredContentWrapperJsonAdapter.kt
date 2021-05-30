package com.highthunder.kotlr.json.response.user

import com.highthunder.kotlr.adapter
import com.highthunder.kotlr.listAdapter
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.user.ResponseUserFilteredContent
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
 * UserFilteredContentWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseUserFilteredContent].
 *
 * @author highthunder
 * @since 2021-05-30
 */
internal class UserFilteredContentWrapperJsonAdapter(moshi: Moshi) :
    JsonAdapter<WrapperInterface<ResponseUserFilteredContent.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponseUserFilteredContent.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseUserFilteredContent.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseUserFilteredContent.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseUserFilteredContent.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseUserFilteredContent.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseUserFilteredContent.Wrapper()
            else -> throw JsonDataException(
                "Expected a field of type Object, String, List, or null but got ${reader.peek()}"
            )
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseUserFilteredContent.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
