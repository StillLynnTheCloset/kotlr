package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.JsonClass

/**
 * PlayerWrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = false)
data class PlayerWrapper(
    var contentString: String? = null,
    var contentList: List<Video>? = null
)
