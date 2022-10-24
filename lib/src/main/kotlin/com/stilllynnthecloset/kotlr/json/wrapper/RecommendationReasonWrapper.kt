package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.types.RecommendationReason

/**
 * RecommendationReasonWrapper - A class to wrap around a recommendation either as a string or an object.
 *
 * @author StillLynnTheCloset
 * @since 2021-05-29
 */
@JsonClass(generateAdapter = false)
internal data class RecommendationReasonWrapper constructor(
    val recommendationObject: RecommendationReason? = null,
    val recommendationString: String? = null,
)
