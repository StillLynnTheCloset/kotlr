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

    constructor(s: String) : this(
        Integer.parseInt(s.dropWhile { it == '#' }.takeIf(String::isNotBlank)?.let {
            return@let when {
                it.length == 6 -> it
                it.length == 3 -> "${it[0]}${it[0]}${it[1]}${it[1]}${it[2]}${it[2]}"
                else -> null
            }
        } ?: throw IllegalArgumentException(""), 16)
    )

    /**
     * TODO: Documentation
     */
    fun asInt(): Int = c

    /**
     * TODO: Documentation
     */
    fun asString(): String = String.format("%06x", c)

    /**
     * TODO: Documentation
     */
    fun asOctothorpeString(): String = String.format("#%06x", c)
}
