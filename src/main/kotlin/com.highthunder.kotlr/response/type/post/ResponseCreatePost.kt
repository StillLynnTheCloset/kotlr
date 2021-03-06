package com.highthunder.kotlr.response.type.post

import com.highthunder.kotlr.json.response.post.CreatePostWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Post
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseCreatePost - The response to a request to create a new post.
 *
 * @author highthunder
 * @since 2019-12-01
 */
public interface ResponseCreatePost {
    /**
     * Response - The top level object returned from Tumblr.
     *
     * @param meta An object containing any meta data returned from Tumblr, as well as some data returned in response headers.
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
     * Adapter is [CreatePostWrapperJsonAdapter].
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
     * @param postId The Id of the created post, as a string to prevent rounding errors.
     * @param state The state that the post was created in
     * @param displayText Some simple, user friendly text describing the result of the action.
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "id")
        val postId: String? = null,
        @Json(name = "state")
        val state: Post.State? = null,
        @Json(name = "display_text")
        val displayText: String? = null,
    )
}
