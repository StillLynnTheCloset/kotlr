package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class Action constructor(
    val type: String? = null,
    val action: String? = null,
    val meta: ActionMeta? = null,
)
