package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.BlogTheme
import com.squareup.moshi.JsonClass

/**
 * ThemeWrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = false)
data class ThemeWrapper(
    var singleTheme: BlogTheme? = null,
    var listOfThemes: List<BlogTheme>? = null
)
