package com.stilllynnthecloset.kotlr.response.type.user

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.response.user.UserDashboardWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.response.ResponseMetaInfo
import com.stilllynnthecloset.kotlr.response.TumblrError
import com.stilllynnthecloset.kotlr.response.TumblrResponse
import com.stilllynnthecloset.kotlr.response.WrapperInterface
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.RequestLinks

/**
 * ResponseUserDashboard - The response to a request for a User's dashboard posts.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 */
public interface ResponseUserDashboard {
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
     * Adapter is [UserDashboardWrapperJsonAdapter].
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
     * @param links Additional links that you might be interested in.
     * @param posts A list of posts from this user's dashboard.
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "_links")
        val links: RequestLinks? = null,
        @Json(name = "posts")
        val posts: List<Post>? = null,
    )
}
