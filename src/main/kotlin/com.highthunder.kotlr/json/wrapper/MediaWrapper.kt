package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.content.PostContent.ImageContent
import com.squareup.moshi.JsonClass

/**
 * MediaWrapper - A class to wrap around both a single Media object and a list of them.
 *
 * This is needed because for some types of content(most of them) Tumblr returns the key-value-pair:
 * "media": { ... media object ... }
 * and sometimes([ImageContent]) returns the key-value-pair:
 * "media": [ { ... media object ... }, { ... media object ... } ]
 * TODO: Documentation
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param singleMedia TODO: Documentation
 * @param listMedia TODO: Documentation
 */
@JsonClass(generateAdapter = false)
data class MediaWrapper(
    var singleMedia: Media? = null,
    var listMedia: List<Media>? = null
)
