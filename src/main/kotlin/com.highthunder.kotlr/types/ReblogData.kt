package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ReblogData - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param comment TODO: Documentation
 * @param tree TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class ReblogData constructor(
    @Json(name = "comment")
    val comment: String? = null,
    @Json(name = "tree_html")
    val tree: String? = null,
)
