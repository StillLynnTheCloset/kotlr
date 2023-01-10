package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class BlogAccessories constructor(
    @Json(name = "blue_checkmark_count")
    val blueCheckmarkCount: Int? = null,
)
