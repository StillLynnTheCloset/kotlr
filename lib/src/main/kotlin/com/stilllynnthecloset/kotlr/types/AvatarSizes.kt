package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * AvatarSizes - TODO: Documentation
 * TODO: Make this not garbage, maybe make a json adapter that converts this to a [MediaList]?
 */
@JsonClass(generateAdapter = true)
public data class AvatarSizes constructor(
    val `64`: String? = null,
    val `128`: String? = null,
)
