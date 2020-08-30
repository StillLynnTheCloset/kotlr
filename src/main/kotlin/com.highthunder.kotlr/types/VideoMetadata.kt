package com.highthunder.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * VideoMetadata - Additional meta data associated with a video.
 *
 * @author highthunder
 * @since 2020-08-30
 * @version 1.0.0
 *
 * @param id An identifier.
 */
@JsonClass(generateAdapter = true)
public data class VideoMetadata constructor(
    val id: String? = null
)
