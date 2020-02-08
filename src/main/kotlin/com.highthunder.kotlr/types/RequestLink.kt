package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RequestLink - TODO: Documentation
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 *
 * @param linkType TODO: Documentation
 * @param httpMethod TODO: Documentation
 * @param fullLink TODO: Documentation
 * @param queryParams TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class RequestLink constructor(
    @Json(name = "type")
    val linkType: Type? = null,
    @Json(name = "method")
    val httpMethod: String? = null,
    @Json(name = "href")
    val fullLink: String? = null,
    @Json(name = "query_params")
    val queryParams: Map<String, String>? = null
) {
    /**
     * TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    enum class Type {
        /**
         * TODO: Documentation
         */
        @Json(name = "navigation")
        Navigation,
        /**
         * TODO: Documentation
         */
        @Json(name = "action")
        Action
    }
}
