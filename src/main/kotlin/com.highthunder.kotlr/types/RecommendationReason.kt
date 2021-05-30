package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RecommendationReason - An object that is returned on [Post] objects, when the post is recommended to the user.
 *
 * @author highthunder
 * @since 2021-05-29
 *
 * @param text TODO: Documentation.
 * @param icon TODO: Documentation.
 * @param loggingReason TODO: Documentation.
 * @param color TODO: Documentation.
 * @param links TODO: Documentation.
 */
@JsonClass(generateAdapter = true)
public data class RecommendationReason constructor(
    val text: String? = null,
    val icon: String? = null,
    @Json(name = "logging_reason")
    val loggingReason: String? = null,
    val color: Color? = null,
    @Json(name = "_links")
    val links: Map<String, Any?>? = null,
)
