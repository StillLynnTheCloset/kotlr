package com.highthunder.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * PostId - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 *
 * @param id TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class PostId constructor(
    val id: Long? = null
)
