package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class CallToAction constructor(
    val label: String? = null,
    val action: Action? = null,
)
