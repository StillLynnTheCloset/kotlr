package com.highthunder.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * Colors - Image blocks may contain a color field which provides the dominant colors stored for the image in the Post
 * metadata. The value is an object with string fields where the key starts with a c and ends with a number, eg.
 * c0, c1, c9. The values are a string of three or six characters representing an RGB hex value. These values are
 * typically used for creating a placeholder gradient while images are loading. The colors represented for an image
 * are the same for every size of that image.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 *
 * @param colors A map from the numeric part of the name to the string representation of the color.
 */
@JsonClass(generateAdapter = false)
data class Colors(
    val colors: Map<Int, Color>? = null
)
