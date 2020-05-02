package com.highthunder.kotlr.types

/**
 * Color - A representation of a color.
 *
 * Can either be created from an int, or a string of the forms:
 * #rgb
 * #rrggbb
 * rgb
 * rrggbb
 * and can then be output either as an int, rrggbb, or #rrggbb
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
data class Color constructor(
    private val c: Int
) {
    companion object {
        private fun String.normalizeTo6DigitString(): String? =
            dropWhile { it == '#' }.takeIf(String::isNotBlank)?.let {
                return@let when (it.length) {
                    6 -> it
                    3 -> "${it[0]}${it[0]}${it[1]}${it[1]}${it[2]}${it[2]}"
                    else -> null
                }
            }
    }

    constructor(s: String) : this(
        Integer.parseInt(
            s.normalizeTo6DigitString() ?: throw NumberFormatException("Color string '$s' is not a valid color"), 16
        )
    )

    /**
     * Return the value of this Color as an rgb integer, useful on platforms like Android that use integer color values.
     */
    fun asInt(): Int = c

    /**
     * Return the value of this Color as a hexadecimal string, with no leading octothorpe.
     */
    fun asString(): String = String.format("%06x", c)

    /**
     * Return the value of this Color as a hexadecimal string, with a leading octothorpe.
     */
    fun asOctothorpeString(): String = String.format("#%06x", c)
}
