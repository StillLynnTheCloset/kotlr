package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.types.BlogTheme

/**
 * ThemeWrapper - A class to wrap around both a single [BlogTheme] object and a list of them.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 *
 * @param singleTheme A single theme held in this wrapper.
 * @param listOfThemes A list of themes held in this wrapper.
 */
@JsonClass(generateAdapter = false)
public data class ThemeWrapper constructor(
    val singleTheme: BlogTheme? = null,
    val listOfThemes: List<BlogTheme>? = null,
)
