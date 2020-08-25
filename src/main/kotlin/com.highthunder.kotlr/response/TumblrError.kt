package com.highthunder.kotlr.response

import com.squareup.moshi.JsonClass

/**
 * TumblrError - A specific error message from the Tumblr API.
 *
 * @author highthunder
 * @since 10/29/18
 * @version 1.0.0
 *
 * @param title TODO: Documentation
 * @param code TODO: Documentation
 * @param detail TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class TumblrError constructor(
    val title: String? = null,
    val code: Int? = null,
    val detail: String? = null
)
