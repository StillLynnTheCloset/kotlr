package com.highthunder.kotlr.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseMetaInfo - An object to hold meta data about the response.
 *
 * This includes meta-data explicitly returned in the response by Tumblr, and data that was extracted from various HTTP
 * headers on the response.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param status The 3-digit HTTP Status-Code code of the response.
 * @param msg The HTTP Reason-Phrase of the response.
 * @param contentRating Extracted from Tumblr's headers. Informs whether or not the content in this response is adult rated.
 * @param rateLimitMetaData Extracted from Tumblr's headers. Contains information about the current state of your rate limits.
 */
@JsonClass(generateAdapter = true)
public data class ResponseMetaInfo constructor(
    @Json(name = "status")
    val status: Int? = null,
    @Json(name = "msg")
    val msg: String? = null,
    @Json(name = "x_tumblr_content_rating")
    val contentRating: String? = null,
    val rateLimitMetaData: RateLimitMetaData? = null,
)
