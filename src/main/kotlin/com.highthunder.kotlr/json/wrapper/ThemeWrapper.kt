package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.BlogTheme
import com.squareup.moshi.JsonClass

/**
 * ThemeWrapper - A class to wrap around both a single [BlogTheme] object and a list of them.
 *
 * @author highthunder
 * @since 2018-11-04
 * @version 1.0.0
 *
 * @param singleTheme A single theme held in this wrapper.
 * @param listOfThemes A list of themes held in this wrapper.
 */
@JsonClass(generateAdapter = false)
public data class ThemeWrapper constructor(
    val singleTheme: BlogTheme? = null,
    val listOfThemes: List<BlogTheme>? = null
)
