package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonReader.Token.STRING
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types
import com.stilllynnthecloset.kotlr.types.content.PostContent

/**
 * ContentWrapperJsonAdapter - A custom adapter to help Moshi parse [PostContent] either as a string of HTML or as a list of content objects.
 *
 * @author highthunder
 * @since 2018-11-04
 */
internal class ContentWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<ContentWrapper>() {

    private val stringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, emptySet())

    private val listOfContentAdapter: JsonAdapter<List<PostContent>> =
        moshi.adapter(Types.newParameterizedType(List::class.java, PostContent::class.java), emptySet())

    @FromJson
    override fun fromJson(reader: JsonReader): ContentWrapper {
        return when (reader.peek()) {
            BEGIN_ARRAY -> ContentWrapper(contentList = listOfContentAdapter.fromJson(reader))
            STRING -> ContentWrapper(contentString = stringAdapter.fromJson(reader))
            NULL -> ContentWrapper()
            else -> throw JsonDataException("Expected a field of type List or String but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: ContentWrapper?) {
        if (value?.contentString != null) {
            stringAdapter.toJson(writer, value.contentString)
        } else {
            listOfContentAdapter.toJson(writer, value?.contentList.orEmpty())
        }
    }
}
