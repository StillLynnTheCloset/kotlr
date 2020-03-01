package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.content.ImageContent
import com.squareup.moshi.JsonClass

/**
 * MediaWrapper - A class to wrap around both a single Media object and a list of them.
 *
 * This is needed because for some types of content(most of them) Tumblr returns the key-value-pair:
 * "media": { ... media object ... }
 * and sometimes([ImageContent]) returns the key-value-pair:
 * "media": [ { ... media object ... }, { ... media object ... } ]
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
    val listMedia: List<Media>? = null
) {
    fun getAsList(): List<Media> = listMedia ?: singleMedia?.let { listOf(it) }.orEmpty()
}
