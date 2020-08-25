package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Tag - A tag object represents a tag
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 *
 * @param tagText The tag name
 * @param thumbnailUrl An image (75x75) associated with the tag; may be null
 * @param isTracked Indicates whether the requesting user is tracking this tag
 * @param featured Indicates whether the tag is a featured tag
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
    val featured: Boolean? = null
)
