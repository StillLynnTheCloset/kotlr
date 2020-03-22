package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.MediaList
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

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
