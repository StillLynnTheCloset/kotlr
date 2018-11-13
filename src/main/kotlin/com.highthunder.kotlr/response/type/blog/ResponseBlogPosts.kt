package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogPostsWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.RequestLink
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseBlogPosts - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface ResponseBlogPosts {

    @JsonClass(generateAdapter = true)
    data class Response(
        @Json(name = "meta")
        var meta: ResponseMetaInfo? = null,
        @Json(name = "response")
        var response: Wrapper? = null,
        @Json(name = "errors")
        var errors: List<TumblrError>? = null
    ) : ResponseInterface<Body> {
        override fun getError(): List<TumblrError>? = errors
        override fun getMetaInfo(): ResponseMetaInfo? = meta
        override fun getWrapper(): WrapperInterface<Body>? = response
    }

    /**
     * Adapter is [BlogPostsWrapperJsonAdapter].
     */
    data class Wrapper(
        var error: String? = null,
        var response: Body? = null
    ) : WrapperInterface<Body> {
        override fun getMessage(): String? = error
        override fun getBody(): Body? = response
    }

    @JsonClass(generateAdapter = true)
    data class Body(
        @Json(name = "_links")
        var links: Map<String, RequestLink>? = null, // TODO: Get rid of map.
        @Json(name = "blog")
        var blog: Blog? = null,
        @Json(name = "posts")
        var posts: List<Post>? = null,
        @Json(name = "total_posts")
        var totalPosts: Long? = null
    )

}
