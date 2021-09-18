package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RequestLink - Links describe an in-app or navigation behavior.
 *
 * A response may contain one or more of these contained under the _links response object key.
 * An object in the _links hash will always contain type and href keys.
 * A navigation link will only contain a href to which the user should be directed.
 * An action type link will contain details on what request method as well as what query or body parameters
 * should be used to take the action.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param linkType The type of link that this is, see [Type].
 * @param httpMethod The HTTP Verb that should be used when making a request from this link.
 * @param fullLink The full href of this link (this included any query parameters).
 * @param queryParams The query parameters that are a part of this link.
 */
@JsonClass(generateAdapter = true)
public data class RequestLink constructor(
    @Json(name = "type")
    val linkType: Type? = null,
    @Json(name = "method")
    val httpMethod: String? = null,
    @Json(name = "href")
    val fullLink: String? = null,
    @Json(name = "query_params")
    val queryParams: RequestQueryParameters? = null,
) {
    /**
     * A _links object may be of several types.
     */
    @JsonClass(generateAdapter = false)
    public enum class Type {
        /**
         * navigation - A reference to some external URI to which the user can go.
         */
        @Json(name = "navigation")
        Navigation,

        /**
         * action - A reference to some internal client state change in the application. The most common example would be to open a different view.
         */
        @Json(name = "action")
        Action,

        /**
         * Web - A reference to some internet URL.
         */
        @Json(name = "web")
        Web,
    }
}
