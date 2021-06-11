package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.types.RecommendationReason

/**
 * RecommendationReasonJsonAdapter - An adapter to help Moshi convert [RecommendationReason] objects to and
 * from a [RecommendationReasonWrapper] object.
 *
 * @author highthunder
 * @since 2021-05-29
 */
internal class RecommendationReasonJsonAdapter {
    @ToJson
    fun toJson(recommendationReason: RecommendationReason): RecommendationReasonWrapper =
        RecommendationReasonWrapper(recommendationObject = recommendationReason)

    @FromJson
    fun fromJson(recommendationReasonWrapper: RecommendationReasonWrapper): RecommendationReason =
        recommendationReasonWrapper.recommendationObject
            ?: RecommendationReason(text = recommendationReasonWrapper.recommendationString)
}
