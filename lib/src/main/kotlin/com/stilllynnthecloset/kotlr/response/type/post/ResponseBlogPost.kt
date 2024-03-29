package com.stilllynnthecloset.kotlr.response.type.post

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.response.post.BlogPostWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.response.ResponseMetaInfo
import com.stilllynnthecloset.kotlr.response.TumblrError
import com.stilllynnthecloset.kotlr.response.TumblrResponse
import com.stilllynnthecloset.kotlr.response.WrapperInterface
import com.stilllynnthecloset.kotlr.types.Post

/**
 * ResponseBlogPost - The response to a request for a single post.
 *
 * Tumblr decided to make this one request special and put the post object directly as the value in `response` instead
 * of nesting it in another object like all the other API responses.
 *
 * @author StillLynnTheCloset
 * @since 2019-12-01
 */
public interface ResponseBlogPost {
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
        override val response: WrapperInterface<Post>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null,
    ) : TumblrResponse<Post>

    /**
     * Adapter is [BlogPostWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    public data class Wrapper constructor(
        override val error: String? = null,
        override val body: Post? = null,
    ) : WrapperInterface<Post>
}
