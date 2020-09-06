package com.highthunder.kotlr.response.type.user

import com.highthunder.kotlr.json.response.user.UserInfoWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseUserInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 2018-11-04
 */
public interface ResponseUserInfo {
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
        override val response: WrapperInterface<Body>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null
    ) : TumblrResponse<Body>

    /**
     * Adapter is [UserInfoWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    public data class Wrapper constructor(
        override val error: String? = null,
        override val body: Body? = null
    ) : WrapperInterface<Body>

    /**
     * TODO: Documentation
     *
     * @param user TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "user")
        val user: User? = null
    )
}
