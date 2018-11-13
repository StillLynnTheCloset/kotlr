package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Tag - TODO: Documentation
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "tag")
    var tagText: String? = null,
    @Json(name = "thumb_url")
    var thumbnailUrl: String? = null,
    @Json(name = "is_tracked")
    var isTracked: Boolean? = null,
    @Json(name = "featured")
    var featured: Boolean? = null
)
