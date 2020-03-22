package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.AttributionList
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.MediaList
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.VideoContent
import com.squareup.moshi.JsonClass

/**
 * AttributionWrapper - A class to wrap around both a single [Attribution] object and a list of them.
 *
 * This is needed because sometimes [ImageContent] will return either the key-value-pair:
 * "attribution": { ... attribution object ... }
 * or the key-value-pair:
 * "attribution": [ { ... attribution object ... }, { ... attribution object ... } ]
 * depending on the content.
 *
 * @author highthunder
 * @since 03/21/20
 * @version 1.0.0
 *
 * @param singleAttribution The single attribution object, if it was returned.
 * @param listAttribution A list of attribution objects, if they were returned, or a list containing only singleAttribution.
 */
@JsonClass(generateAdapter = false)
internal data class AttributionWrapper constructor(
    val singleAttribution: Attribution? = null,
    val listAttribution: List<Attribution> = listOfNotNull(singleAttribution)
) : AttributionList(), List<Attribution> by listAttribution
