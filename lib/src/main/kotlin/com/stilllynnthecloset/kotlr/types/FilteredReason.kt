package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class FilteredReason constructor(
    val tags: List<String>? = null,
)
