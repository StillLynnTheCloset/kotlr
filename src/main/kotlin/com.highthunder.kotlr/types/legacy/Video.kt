package com.highthunder.kotlr.types.legacy

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Video - A video in a legacy video post.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param width Width of video player, in pixels.
 * @param embedCode HTML for embedding the video player.
 */
@JsonClass(generateAdapter = false)
public data class Video constructor(
    @Json(name = "width")
    val width: Int? = null,
    @Json(name = "embed_code")
    val embedCode: String? = null
)
