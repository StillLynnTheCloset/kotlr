package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.MediaList
import com.highthunder.kotlr.types.content.VideoContent
import com.squareup.moshi.JsonClass

/**
 * MediaWrapper - A class to wrap around both a single Media object and a list of them.
 *
 * This is needed because sometimes [VideoContent] will return either the key-value-pair:
 * "filmstrip": { ... media object ... }
 * or the key-value-pair:
 * "filmstrip": [ { ... media object ... }, { ... media object ... } ]
 * depending on the content.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param singleMedia The single media object, if it was returned.
 * @param listMedia A list of media objects, if they were returned.
 */
@JsonClass(generateAdapter = false)
internal data class MediaWrapper constructor(
    val singleMedia: Media? = null,
    val listMedia: List<Media> = listOfNotNull(singleMedia)
) : MediaList(), List<Media> by listMedia
