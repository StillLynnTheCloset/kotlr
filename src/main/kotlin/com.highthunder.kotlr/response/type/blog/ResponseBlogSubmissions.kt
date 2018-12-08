package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogSubmissionsWrapperJsonAdapter
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.RequestLink
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseBlogSubmissions - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface ResponseBlogSubmissions {

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
     * Adapter is [BlogSubmissionsWrapperJsonAdapter].
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
     * @param posts TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Body(
        @Json(name = "_links")
        var links: Map<String, RequestLink>? = null, // TODO: Get rid of map.
        @Json(name = "posts")
        var posts: List<Post>? = null
    )

}
