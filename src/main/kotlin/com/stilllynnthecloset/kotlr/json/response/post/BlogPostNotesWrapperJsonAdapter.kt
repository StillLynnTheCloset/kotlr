package com.stilllynnthecloset.kotlr.json.response.post

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
import com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPostNotes

/**
 * PostNotesWrapperJsonAdapter - An adapter to (de-)serialize the response wrapper object for a [ResponseBlogPostNotes].
 *
 * @author highthunder
 * @since 2019-12-01
 */
internal class BlogPostNotesWrapperJsonAdapter(moshi: Moshi) :
    JsonAdapter<WrapperInterface<ResponseBlogPostNotes.Body>>() {
    private val stringAdapter: JsonAdapter<String?> = moshi.adapter()
    private val responseBlogAdapter: JsonAdapter<ResponseBlogPostNotes.Body> = moshi.adapter()
    private val listOfAnyAdapter: JsonAdapter<List<Any>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): WrapperInterface<ResponseBlogPostNotes.Body> {
        return when (reader.peek()) {
            BEGIN_OBJECT -> ResponseBlogPostNotes.Wrapper(body = responseBlogAdapter.fromJson(reader))
            STRING -> ResponseBlogPostNotes.Wrapper(error = stringAdapter.fromJson(reader))
            BEGIN_ARRAY -> ResponseBlogPostNotes.Wrapper(error = listOfAnyAdapter.fromJson(reader).toString())
            NULL -> ResponseBlogPostNotes.Wrapper()
            else -> throw JsonDataException(
                "Expected a field of type Object, String, List, or null but got ${reader.peek()}"
            )
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: WrapperInterface<ResponseBlogPostNotes.Body>?) {
        if (value?.error != null) {
            stringAdapter.toJson(writer, value.error)
        } else {
            responseBlogAdapter.toJson(writer, value?.body)
        }
    }
}
