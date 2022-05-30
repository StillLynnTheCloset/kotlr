package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class QueueState constructor(
    val paused: Boolean? = null,
)
