package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Media
import com.squareup.moshi.*

/**
 * MediaWrapperJsonAdapter - An adapter to help Moshi convert [MediaWrapper] objects to and
 * from either a single [Media] object, or a list of them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class MediaWrapperJsonAdapter(moshi: Moshi): JsonAdapter<MediaWrapper>() {

    private val mediaAdapter: JsonAdapter<Media?> =
            moshi.adapter(Media::class.java, kotlin.collections.emptySet(), null)

    private val listOfMediaAdapter: JsonAdapter<List<Media>> =
            moshi.adapter<List<Media>>(Types.newParameterizedType(List::class.java, Media::class.java), kotlin.collections.emptySet(), null)

    @FromJson
    override fun fromJson(reader: JsonReader): MediaWrapper {
        return when (reader.peek()) {
            JsonReader.Token.BEGIN_ARRAY -> MediaWrapper(listMedia = listOfMediaAdapter.fromJson(reader))
            JsonReader.Token.BEGIN_OBJECT -> MediaWrapper(singleMedia = mediaAdapter.fromJson(reader))
            JsonReader.Token.NULL -> MediaWrapper()
            else -> throw JsonDataException("Expected a field of type List or Media but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: MediaWrapper?) {
        if (value?.singleMedia != null) {
            mediaAdapter.toJson(writer, value.singleMedia)
        } else {
            listOfMediaAdapter.toJson(writer, value?.listMedia ?: listOf())
        }
    }

}
