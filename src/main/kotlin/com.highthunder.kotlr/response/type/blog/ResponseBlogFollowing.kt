package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogFollowingWrapperJsonAdapter
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.RequestLink
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseBlogFollowing - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
interface ResponseBlogFollowing {

    /**
     * TODO: Documentation
     *
     * @param meta TODO: Documentation
     * @param response TODO: Documentation
     * @param errors TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Response(
        @Json(name = "meta")
        var meta: ResponseMetaInfo? = null,
        @Json(name = "response")
        var response: Wrapper? = null,
        @Json(name = "errors")
        var errors: List<TumblrError>? = null
    ) : TumblrResponse<Body> {
        override fun getError(): List<TumblrError>? = errors
        override fun getMetaInfo(): ResponseMetaInfo? = meta
        override fun getWrapper(): WrapperInterface<Body>? = response
    }

    /**
     * Adapter is [BlogFollowingWrapperJsonAdapter].
     *
     * @param response TODO: Documentation
     * @param error TODO: Documentation
     */
    data class Wrapper(
        var error: String? = null,
        var response: Body? = null
    ) : WrapperInterface<Body> {
        override fun getMessage(): String? = error
        override fun getBody(): Body? = response
    }

    /**
     * TODO: Documentation
     *
     * @param links TODO: Documentation
     * @param blogs TODO: Documentation
     * @param total TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Body(
        @Json(name = "_links")
        var links: Map<String, RequestLink>? = null, // TODO: Get rid of map.
        @Json(name = "blogs")
        var blogs: List<Blog>? = null,
        @Json(name = "total_blogs")
        var total: Int? = null
    )

}
