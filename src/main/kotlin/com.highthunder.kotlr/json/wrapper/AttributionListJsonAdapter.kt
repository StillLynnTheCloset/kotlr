package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.AttributionList
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class AttributionListJsonAdapter {
    @ToJson
    fun toJson(attributionList: AttributionList): AttributionWrapper = if (attributionList is AttributionWrapper) {
        attributionList
    } else {
        AttributionWrapper(listAttribution = attributionList.attributions)
    }

    @FromJson
    fun fromJson(attributionWrapper: AttributionWrapper): AttributionList = attributionWrapper
}
