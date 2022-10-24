package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Tag - A tag object represents a tag.
 *
 * This isn't used anywhere? TODO: Figure out why Tumblr defined this object.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 *
 * @param tagText The tag name
 * @param thumbnailUrl An image (75x75) associated with the tag; may be null
 * @param isTracked Whether the requesting user is tracking this tag
 * @param featured Whether the tag is a featured tag
 */
@JsonClass(generateAdapter = true)
public data class Tag constructor(
    @Json(name = "tag")
    val tagText: String? = null,
    @Json(name = "thumb_url")
    val thumbnailUrl: String? = null,
    @Json(name = "is_tracked")
    val isTracked: Boolean? = null,
    @Json(name = "featured")
    val featured: Boolean? = null,
)
