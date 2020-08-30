package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.AttributionList
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * AttributionListJsonAdapter - An adapter to help Moshi convert [AttributionList] objects to and
 * from either a [AttributionWrapper] object.
 *
 * @author highthunder
 * @since 2020-03-21
 * @version 1.0.0
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
