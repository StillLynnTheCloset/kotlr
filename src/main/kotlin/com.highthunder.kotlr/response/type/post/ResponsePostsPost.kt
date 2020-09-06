package com.highthunder.kotlr.response.type.post

import com.highthunder.kotlr.json.response.post.PostsPostWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Post
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponsePostsPost - TODO: Documentation
 *
 * Tumblr decided to make this one request special and put the post object directly as the value in `response` instead
 * of nesting it in another object like all of the other API responses.
 *
 * @author highthunder
 * @since 2019-12-01
 */
public interface ResponsePostsPost {
    /**
     * TODO: Documentation
     *
     * @param meta TODO: Documentation
     * @param response TODO: Documentation
     * @param errors TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    public data class Response constructor(
        @Json(name = "meta")
        override val meta: ResponseMetaInfo,
        @Json(name = "response")
        override val response: WrapperInterface<Post>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null
    ) : TumblrResponse<Post>

    /**
     * Adapter is [PostsPostWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    public data class Wrapper constructor(
        override val error: String? = null,
        override val body: Post? = null
    ) : WrapperInterface<Post>
}
