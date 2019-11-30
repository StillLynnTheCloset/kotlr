package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Tag - TODO: Documentation
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 *
 * @param tagText TODO: Documentation
 * @param thumbnailUrl TODO: Documentation
 * @param isTracked TODO: Documentation
 * @param featured TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class Tag constructor(
    @Json(name = "tag")
    val tagText: String? = null,
    @Json(name = "thumb_url")
    val thumbnailUrl: String? = null,
    @Json(name = "is_tracked")
    val isTracked: Boolean? = null,
    @Json(name = "featured")
    val featured: Boolean? = null
)
