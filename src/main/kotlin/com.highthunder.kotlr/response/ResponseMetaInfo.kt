package com.highthunder.kotlr.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseMetaInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 *
 * @param status TODO: Documentation
 * @param msg TODO: Documentation
 * @param contentRating TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class ResponseMetaInfo constructor(
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "msg")
    val msg: String? = null,
    @Json(name = "x_tumblr_content_rating")
    val contentRating: String? = null,
    val rateLimitMetaData: RateLimitMetaData? = null
)
