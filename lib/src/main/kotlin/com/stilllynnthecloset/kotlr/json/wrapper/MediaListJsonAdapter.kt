package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.types.MediaList

/**
 * MediaListJsonAdapter - An adapter to help Moshi convert [MediaList] objects to and
 * from either a [MediaWrapper] object.
 *
 * @author StillLynnTheCloset
 * @since 2020-03-04
 */
internal class MediaListJsonAdapter {
    @ToJson
    fun toJson(mediaList: MediaList): MediaWrapper = if (mediaList is MediaWrapper) {
        mediaList
    } else {
        MediaWrapper(listMedia = mediaList)
    }

    @FromJson
    fun fromJson(mediaWrapper: MediaWrapper): MediaList = mediaWrapper
}
