package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.types.AttributionList

/**
 * AttributionListJsonAdapter - An adapter to help Moshi convert [AttributionList] objects to and
 * from either a [AttributionWrapper] object.
 *
 * @author StillLynnTheCloset
 * @since 2020-03-21
 */
internal class AttributionListJsonAdapter {
    @ToJson
    fun toJson(attributionList: AttributionList): AttributionWrapper = if (attributionList is AttributionWrapper) {
        attributionList
    } else {
        AttributionWrapper(listAttribution = attributionList)
    }

    @FromJson
    fun fromJson(attributionWrapper: AttributionWrapper): AttributionList = attributionWrapper
}
