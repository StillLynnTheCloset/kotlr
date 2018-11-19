package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogFollowersWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.RequestLink
import com.highthunder.kotlr.types.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseBlogFollowers - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
interface ResponseBlogFollowers {

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
    ) : ResponseInterface<Body> {
        override fun getError(): List<TumblrError>? = errors
        override fun getMetaInfo(): ResponseMetaInfo? = meta
        override fun getWrapper(): WrapperInterface<Body>? = response
    }

    /**
     * Adapter is [BlogFollowersWrapperJsonAdapter].
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
     * @param users TODO: Documentation
     * @param total TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Body(
        @Json(name = "_links")
        var links: Map<String, RequestLink>? = null, // TODO: Get rid of map.
        @Json(name = "users")
        var users: List<User>? = null,
        @Json(name = "total_users")
        var total: Int? = null
    )

}
