package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.JsonClass

/**
 * ContentWrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 *
 * @param contentString TODO: Documentation
 * @param contentList TODO: Documentation
 */
@JsonClass(generateAdapter = false)
data class ContentWrapper(
    val contentString: String? = null,
    val contentList: List<PostContent>? = null
)
