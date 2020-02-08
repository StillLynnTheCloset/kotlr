package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.JsonClass

/**
 * PlayerWrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param contentString TODO: Documentation
 * @param contentList TODO: Documentation
 */
@JsonClass(generateAdapter = false)
internal data class PlayerWrapper(
    val contentString: String? = null,
    val contentList: List<Video>? = null
)
