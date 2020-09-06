package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.adapter
import com.highthunder.kotlr.listAdapter
import com.highthunder.kotlr.types.Media
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson

/**
 * MediaWrapperJsonAdapter - An adapter to help Moshi convert [MediaWrapper] objects to and
 * from either a single [Media] object, or a list of them.
 *
 * @author highthunder
 * @since 2018-11-04
 */
internal class MediaWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<MediaWrapper>() {

    private val mediaAdapter: JsonAdapter<Media?> = moshi.adapter()

    private val listOfMediaAdapter: JsonAdapter<List<Media>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): MediaWrapper? {
        return when (reader.peek()) {
            BEGIN_ARRAY -> MediaWrapper(listMedia = listOfMediaAdapter.fromJson(reader).orEmpty())
            BEGIN_OBJECT -> MediaWrapper(singleMedia = mediaAdapter.fromJson(reader))
            NULL -> null
            else -> throw JsonDataException("Expected a field of type List or Media but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: MediaWrapper?) {
        when {
            value == null -> mediaAdapter.toJson(writer, null)
            value.singleMedia != null -> mediaAdapter.toJson(writer, value.singleMedia)
            value.listMedia.isNotEmpty() -> listOfMediaAdapter.toJson(writer, value.listMedia)
            else -> mediaAdapter.toJson(writer, null)
        }
    }
}
