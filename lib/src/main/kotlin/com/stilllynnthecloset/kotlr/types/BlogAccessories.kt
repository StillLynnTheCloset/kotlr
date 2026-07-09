package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class BlogAccessories constructor(
    @Json(name = "blue_checkmark_count")
    val blueCheckmarkCount: Int? = null,
    @Json(name = "active_badges")
    val activeBadges: List<BlogAccessoryProduct>? = null,
    @Json(name = "badges")
    val badges: List<BlogAccessoryProduct>? = null,
)

@JsonClass(generateAdapter = true)
public data class BlogAccessoryProduct constructor(
    @Json(name = "product_group")
    val productGroup: BlogAccessoryProductGroup? = null,
    @Json(name = "urls")
    val urls: List<String>? = null,
    @Json(name = "destination_url")
    val destinationUrl: String? = null,
)

public enum class BlogAccessoryProductGroup {
    @Json(name = "blue-checkmark")
    BlueCheckmark,
    @Json(name = "netflix-one-piece-badge")
    OnePiece,
    @Json(name = "staff-member-badge")
    Staff,
}
