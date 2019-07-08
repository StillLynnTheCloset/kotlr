package com.highthunder.kotlr.types

import com.github.scribejava.core.model.Verb
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
    var linkType: Type? = null,
    @Json(name = "method")
    var httpMethod: Verb? = null,
    @Json(name = "href")
    var fullLink: String? = null,
    @Json(name = "query_params")
    var queryParams: Map<String, String>? = null
) {
    /**
     * TODO: Documentation
     */
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
