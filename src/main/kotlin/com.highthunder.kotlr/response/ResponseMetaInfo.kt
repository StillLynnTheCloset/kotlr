package com.highthunder.kotlr.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseMetaInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class ResponseMetaInfo(
        @Json(name = "status")
        var status: Int? = null,
        @Json(name = "msg")
        var msg: String? = null,
        @Json(name = "x_tumblr_content_rating")
        var contentRating: String? = null
)
