package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogFollowersWrapperJsonAdapter
import com.highthunder.kotlr.response.*
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
    class Response(
        @Json(name = "meta")
        meta: ResponseMetaInfo,
        @Json(name = "response")
        response: WrapperInterface<Body>,
        @Json(name = "errors")
        errors: List<TumblrError>? = null
    ) : GeneralResponse<Body>(meta, response, errors)

    /**
     * Adapter is [BlogFollowersWrapperJsonAdapter].
     *
     * @param response TODO: Documentation
     * @param error TODO: Documentation
     */
    class Wrapper(
        error: String? = null,
        response: Body? = null
    ) : GeneralWrapper<Body>(error, response)

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
