package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.JsonClass

/**
 * ContentWrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = false)
data class ContentWrapper(
        var contentString: String? = null,
        var contentList: List<PostContent>? = null
)
