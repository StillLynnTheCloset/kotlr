package com.highthunder.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * PostId - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class PostId(
    var id: Long? = null
)
