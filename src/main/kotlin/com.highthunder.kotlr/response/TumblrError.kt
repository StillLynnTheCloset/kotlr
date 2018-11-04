package com.highthunder.kotlr.response

import com.squareup.moshi.JsonClass

/**
 * TumblrError - TODO: Documentation
 *
 * @author highthunder
 * @since 10/29/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class TumblrError(
        var title: String? = null,
        var code: Int? = null,
        var detail: String? = null
)
