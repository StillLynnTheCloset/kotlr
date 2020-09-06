package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ReblogData - An object that is returned on [Post] objects, when not using NPF.
 *
 * This is only returned when a post is a reblog.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param comment The new text that was added during the reblog, but only sometimes?
 * @param tree The full post's HTML.
 */
@JsonClass(generateAdapter = true)
public data class ReblogData constructor(
    @Json(name = "comment")
    val comment: String? = null,
    @Json(name = "tree_html")
    val tree: String? = null,
)
