package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * VideoMetadata - Additional meta data associated with a video.
 *
 * @author StillLynnTheCloset
 * @since 2020-08-30
 *
 * @param id An identifier.
 * @param youtube An object containing YouTube-specific metadata.
 */
@JsonClass(generateAdapter = true)
public data class VideoMetadata constructor(
    val id: String? = null,
    val youtube: YoutubeVideoMetadata? = null,
)

/**
 * YoutubeVideoMetadata - Additional meta data associated with a YouTube video.
 *
 * @param videoId The YouTube video id.
 * @param width The width of this video.
 * @param height The height of this video.
 */
@JsonClass(generateAdapter = true)
public data class YoutubeVideoMetadata constructor(
    @Json(name = "video_id")
    val videoId: String? = null,
    val width: Int? = null,
    val height: Int? = null,
)
