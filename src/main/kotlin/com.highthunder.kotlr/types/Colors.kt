package com.highthunder.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * Colors - TODO: Documentation
 *
 * TODO: Figure out how to use an adapter to back this with an array.
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class Colors(
        var c0: String? = null,
        var c1: String? = null,
        var c2: String? = null,
        var c3: String? = null,
        var c4: String? = null,
        var c5: String? = null,
        var c6: String? = null,
        var c7: String? = null,
        var c8: String? = null,
        var c9: String? = null
)
