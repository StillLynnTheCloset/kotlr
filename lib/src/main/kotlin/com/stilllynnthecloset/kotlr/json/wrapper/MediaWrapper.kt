package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.types.Media
import com.stilllynnthecloset.kotlr.types.MediaList
import com.stilllynnthecloset.kotlr.types.content.VideoContent

/**
 * MediaWrapper - A class to wrap around both a single Media object and a list of them.
 *
 * This is needed because sometimes [VideoContent] will return either the key-value-pair:
 * "filmstrip": { ... media object ... }
 * or the key-value-pair:
 * "filmstrip": [ { ... media object ... }, { ... media object ... } ]
 * depending on the content.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 *
 * @param singleMedia The single media object, if it was returned.
 * @param listMedia A list of media objects, if they were returned.
 */
@JsonClass(generateAdapter = false)
internal data class MediaWrapper constructor(
    val singleMedia: Media? = null,
    val listMedia: List<Media> = listOfNotNull(singleMedia),
) : MediaList(), List<Media> by listMedia
