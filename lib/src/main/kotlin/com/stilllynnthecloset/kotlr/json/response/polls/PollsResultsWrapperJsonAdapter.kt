package com.stilllynnthecloset.kotlr.json.response.polls

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonReader.Token.STRING
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.adapter
import com.stilllynnthecloset.kotlr.response.WrapperInterface
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogAvatar
import com.stilllynnthecloset.kotlr.response.type.polls.ResponsePollsResults

/**
 * BlogAvatarWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseBlogAvatar].
 *
 * @author StillLynnTheCloset
 * @since 2018-11-10
 */
internal class PollsResultsWrapperJsonAdapter(moshi: Moshi) :
    JsonAdapter<WrapperInterface<ResponsePollsResults.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseAdapter: JsonAdapter<ResponsePollsResults.Body> = moshi.adapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponsePollsResults.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponsePollsResults.Wrapper(body = responseAdapter.fromJson(reader))
            STRING -> ResponsePollsResults.Wrapper(error = stringAdapter.fromJson(reader))
            NULL -> ResponsePollsResults.Wrapper()
            else -> throw JsonDataException(
                "Expected a field of type Object, String, List, or null but got ${reader.peek()}",
            )
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponsePollsResults.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseAdapter.toJson(writer, value?.body)
        }
    }
}
