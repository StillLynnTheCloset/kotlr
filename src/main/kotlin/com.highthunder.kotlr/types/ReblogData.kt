package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ReblogData - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class ReblogData(
    @Json(name = "comment")
    var comment: String? = null,
    @Json(name = "tree_html")
    var tree: String? = null
)
