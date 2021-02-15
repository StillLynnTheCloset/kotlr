package com.highthunder.kotlr.postbody

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * LikePostBody - The body of a post payload to like or unlike a post.
 * @param id The postId of the post.
 * @param reblogKey The reblog key of the post.
 */
@JsonClass(generateAdapter = true)
public data class LikePostBody constructor(
    @Json(name = "id")
    val id: Long,
    @Json(name = "reblog_key")
    val reblogKey: String?,
)
