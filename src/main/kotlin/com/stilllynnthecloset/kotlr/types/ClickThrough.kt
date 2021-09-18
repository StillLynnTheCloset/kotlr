package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class ClickThrough constructor(
    @Json(name = "web_url")
    val webUrl: String? = null,
    @Json(name = "deeplink_url")
    val deepLinkUrl: String? = null,
)
