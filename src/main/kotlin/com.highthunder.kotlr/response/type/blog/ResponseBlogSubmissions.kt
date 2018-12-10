package com.highthunder.kotlr.response.type.blog

import com.highthunder.kotlr.json.response.blog.BlogSubmissionsWrapperJsonAdapter
import com.highthunder.kotlr.response.*
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
    class Response(
        @Json(name = "meta")
        meta: ResponseMetaInfo,
        @Json(name = "response")
        response: WrapperInterface<Body>,
        @Json(name = "errors")
        errors: List<TumblrError>? = null
    ) : GeneralResponse<Body>(meta, response, errors)

    /**
     * Adapter is [BlogSubmissionsWrapperJsonAdapter].
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
