package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RequestLink - TODO: Documentation
 *
 * @author highthunder
 * @since 10/24/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class RequestLink(
    @Json(name = "type")
    var linkType: Type? = null,
    @Json(name = "method")
    var httpMethod: String? = null,
    @Json(name = "href")
    var fullLink: String? = null,
    @Json(name = "query_params")
    var queryParams: Map<String, Any>? = null
) {
    enum class Type {
        @Json(name = "navigation")
        Navigation,
        @Json(name = "action")
        Action
    }
}
