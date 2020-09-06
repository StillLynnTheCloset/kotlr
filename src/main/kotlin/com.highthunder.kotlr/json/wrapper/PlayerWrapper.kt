package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.JsonClass

/**
 * PlayerWrapper - A class to wrap around both a list of [Video] objects or a string.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param contentString An HTML string representing the video content
 * @param contentList A list of [Video] objects.
 */
@JsonClass(generateAdapter = false)
internal data class PlayerWrapper constructor(
    val contentString: String? = null,
    val contentList: List<Video>? = null,
)
