package com.highthunder.kotlr.response.type.user

import com.highthunder.kotlr.json.response.user.UserFollowingWrapperJsonAdapter
import com.highthunder.kotlr.response.*
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.RequestLink
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseUserFollowing - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
interface ResponseUserFollowing {

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
     * Adapter is [UserFollowingWrapperJsonAdapter].
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
     * @param blogs TODO: Documentation
     * @param totalFollowed TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Body(
        @Json(name = "_links")
        var links: Map<String, RequestLink>? = null, // TODO: Get rid of map.
        @Json(name = "blogs")
        var blogs: List<Blog>? = null,
        @Json(name = "total_blogs")
        var totalFollowed: Long? = null
    )

}
