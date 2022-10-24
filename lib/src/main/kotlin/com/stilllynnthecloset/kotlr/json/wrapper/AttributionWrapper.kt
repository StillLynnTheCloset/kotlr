package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.types.AttributionList
import com.stilllynnthecloset.kotlr.types.content.Attribution
import com.stilllynnthecloset.kotlr.types.content.ImageContent

/**
 * AttributionWrapper - A class to wrap around both a single [Attribution] object and a list of them.
 *
 * This is needed because sometimes [ImageContent] will return either the key-value-pair:
 * "attribution": { ... attribution object ... }
 * or the key-value-pair:
 * "attribution": [ { ... attribution object ... }, { ... attribution object ... } ]
 * depending on the content.
 *
 * @author StillLynnTheCloset
 * @since 2020-03-21
 *
 * @param singleAttribution The single attribution object, if it was returned.
 * @param listAttribution A list of attribution objects, if they were returned, or a list containing only singleAttribution.
 */
@JsonClass(generateAdapter = false)
internal data class AttributionWrapper constructor(
    val singleAttribution: Attribution? = null,
    val listAttribution: List<Attribution> = listOfNotNull(singleAttribution),
) : AttributionList(), List<Attribution> by listAttribution
