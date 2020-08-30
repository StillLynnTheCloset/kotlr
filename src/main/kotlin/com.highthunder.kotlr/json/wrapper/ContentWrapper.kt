package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.JsonClass

/**
 * ContentWrapper - A wrapper class to handle the fact that when not using NPF, Tumblr will return the "content" property of
 * a [Trail] object as a string. Otherwise it will be returned as a list of PostContent objects.
 *
 * @author highthunder
 * @since 2019-11-04
 * @version 1.0.0
 *
 * @param contentString The contents as a string (usually HTML).
 * @param contentList The contents as a list of content blocks.
 */
@JsonClass(generateAdapter = false)
public data class ContentWrapper constructor(
    val contentString: String? = null,
    val contentList: List<PostContent>? = null
)
