package com.stilllynnthecloset.kotlr.json.response.user

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
import com.stilllynnthecloset.kotlr.adapter
import com.stilllynnthecloset.kotlr.listAdapter
import com.stilllynnthecloset.kotlr.response.WrapperInterface
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLikes

/**
 * UserLikesWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseUserLikes].
 *
 * @author StillLynnTheCloset
 * @since 2018-11-10
 */
internal class UserLikesWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<WrapperInterface<ResponseUserLikes.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponseUserLikes.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseUserLikes.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseUserLikes.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponseUserLikes.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseUserLikes.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseUserLikes.Wrapper()
            else -> throw JsonDataException(
                "Expected a field of type Object, String, List, or null but got ${reader.peek()}",
            )
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseUserLikes.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
