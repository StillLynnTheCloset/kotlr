package com.stilllynnthecloset.kotlr.response.type.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.response.user.UserFilteredContentWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.response.ResponseMetaInfo
import com.stilllynnthecloset.kotlr.response.TumblrError
import com.stilllynnthecloset.kotlr.response.TumblrResponse
import com.stilllynnthecloset.kotlr.response.WrapperInterface

/**
 * ResponseUserFilteredContent - The response to a request for a user's content filters.
 *
 * @author StillLynnTheCloset
 * @since 2021-05-29
 */
public interface ResponseUserFilteredContent {
    /**
     * Response - The top level object returned from Tumblr.
     *
     * @param meta An object containing any metadata returned from Tumblr, as well as some data returned in response headers.
     * @param response The actual response to the request, as a wrapper object to handle some types of errors from Tumblr.
     * @param errors An array of error objects, which are returned when some types of errors occur.
     */
    @JsonClass(generateAdapter = true)
    public data class Response constructor(
        @Json(name = "meta")
        override val meta: ResponseMetaInfo,
        @Json(name = "response")
        override val response: WrapperInterface<Body>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null,
    ) : TumblrResponse<Body>

    /**
     * Adapter is [UserFilteredContentWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    public data class Wrapper constructor(
        override val error: String? = null,
        override val body: Body? = null,
    ) : WrapperInterface<Body>

    /**
     * Body - The actual body of a successful response.
     *
     * @param contentFilters The content filters returned by Tumblr.
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "filtered_content")
        val contentFilters: List<String>? = null,
    )
}
