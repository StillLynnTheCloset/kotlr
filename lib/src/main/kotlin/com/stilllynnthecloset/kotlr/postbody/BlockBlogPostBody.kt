package com.stilllynnthecloset.kotlr.postbody

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @param blogIdentifier The tumblelog to block, specified by any blog identifier
 * @param postId The anonymous post ID (asks, submissions) to block
 *
 * @author highthunder
 * @since 2021-06-02
 */
@JsonClass(generateAdapter = true)
public data class BlockBlogPostBody constructor(
    @Json(name = "blocked_tumblelog")
    val blogIdentifier: String? = null,
    @Json(name = "post_id")
    val postId: Long? = null,
) {
    init {
        require((blogIdentifier == null) xor (postId == null)) {
            "Exactly one of blogIdentifier or postId must be provided"
        }
    }
}
