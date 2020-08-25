package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.BlogTheme
import com.squareup.moshi.JsonClass

/**
 * ThemeWrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 *
 * @param singleTheme TODO: Documentation
 * @param listOfThemes TODO: Documentation
 */
@JsonClass(generateAdapter = false)
public data class ThemeWrapper constructor(
    val singleTheme: BlogTheme? = null,
    val listOfThemes: List<BlogTheme>? = null
)
