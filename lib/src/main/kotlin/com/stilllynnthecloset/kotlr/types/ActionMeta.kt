package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class ActionMeta constructor(
    @Json(name = "follow_tumblelog_name")
    val followTumblelogName: String? = null,
)
