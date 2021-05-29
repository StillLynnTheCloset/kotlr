package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.RecommendationReason
import com.squareup.moshi.JsonClass

/**
 * RecommendationReasonWrapper - A class to wrap around a recommendation either as a string or an object.
 *
 * @author highthunder
 * @since 2021-05-29
 */
@JsonClass(generateAdapter = false)
internal data class RecommendationReasonWrapper constructor(
    val recommendationObject: RecommendationReason? = null,
    val recommendationString: String? = null,
)
