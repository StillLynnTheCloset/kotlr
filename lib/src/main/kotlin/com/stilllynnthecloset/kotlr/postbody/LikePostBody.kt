package com.stilllynnthecloset.kotlr.postbody

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * LikePostBody - The body of a post payload to like or unlike a post.
 *
 * @param id The postId of the post.
 * @param reblogKey The reblog key of the post.
 *
 * @author StillLynnTheCloset
 * @since 2021-02-15
 */
@JsonClass(generateAdapter = true)
internal data class LikePostBody constructor(
    @Json(name = "id")
    val id: Long,
    @Json(name = "reblog_key")
    val reblogKey: String?,
)
