package com.highthunder.kotlr.response.type.user

import com.highthunder.kotlr.json.response.user.UserInfoWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseUserInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
interface ResponseUserInfo {

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
     * Adapter is [UserInfoWrapperJsonAdapter].
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
            @Json(name = "user")
            var user: User? = null
    )

}
