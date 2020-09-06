package com.highthunder.kotlr.response.type.user

import com.highthunder.kotlr.json.response.user.UserLikesWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.RequestLinks
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseUserLikes - TODO: Documentation
 *
 * @author highthunder
 * @since 2018-11-06
 */
public interface ResponseUserLikes {
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
     * Adapter is [UserLikesWrapperJsonAdapter].
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
     * @param links TODO: Documentation
     * @param posts TODO: Documentation
     * @param totalLiked TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "_links")
        val links: RequestLinks? = null,
        @Json(name = "liked_posts")
        val posts: List<Post>? = null,
        @Json(name = "liked_count")
        val totalLiked: Long? = null
    )
}
