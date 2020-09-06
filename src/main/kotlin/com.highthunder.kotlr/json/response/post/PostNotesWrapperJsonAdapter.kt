package com.highthunder.kotlr.json.response.post

import com.highthunder.kotlr.adapter
import com.highthunder.kotlr.listAdapter
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.response.type.post.ResponsePostNotes
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
 * PostNotesWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponsePostNotes].
 *
 * @author highthunder
 * @since 2019-12-01
 */
internal class PostNotesWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<ResponsePostNotes.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponsePostNotes.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponsePostNotes.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponsePostNotes.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponsePostNotes.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponsePostNotes.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponsePostNotes.Wrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponsePostNotes.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
