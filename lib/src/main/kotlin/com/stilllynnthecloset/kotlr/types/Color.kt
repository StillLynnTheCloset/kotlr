package com.stilllynnthecloset.kotlr.types

/**
 * Color - A representation of a color.
 *
 * Can either be created from an int, or a string of the forms:
 * #rgb
 * #argb
 * #rrggbb
 * #aarrggbb
 * rgb
 * argb
 * rrggbb
 * aarrggbb
 * and can then be output either as an int, AARRGGBB, or #AARRGGBB
 *
 * @author highthunder
 * @since 2018-11-19
 */
public data class Color constructor(
    private val c: Int,
) {
    private companion object {
        private const val DEFAULT_COLOR: String = "00000000"
        private val validCharactersRegex = Regex("[0-9A-Fa-f]+")

        private fun String.normalizeTo8DigitString(): String =
            removePrefix("#")
                .takeIf { it.matches(validCharactersRegex) }
                ?.toUpperCase()
                ?.let {
                    return@let when (it.length) {
                        8 -> it
                        6 -> "FF$it"
                        4 -> "${it[0]}${it[0]}${it[1]}${it[1]}${it[2]}${it[2]}${it[3]}${it[3]}"
                        3 -> "FF${it[0]}${it[0]}${it[1]}${it[1]}${it[2]}${it[2]}"
                        else -> null
                    }
                } ?: DEFAULT_COLOR
    }

    public constructor(s: String) : this(
        s.normalizeTo8DigitString()
            .toLong(16)
            .toInt(),
    )

    /**
     * Return the value of this Color as an AARRGGBB integer, useful on platforms like Android that use integer color values.
     */
    public fun asInt(): Int = c

    /**
     * Return the value of this Color as a hexadecimal AARRGGBB string, with no leading octothorpe.
     */
    public fun asString(): String = String.format("%08X", c)

    /**
     * Return the value of this Color as a hexadecimal AARRGGBB string, with a leading octothorpe.
     */
    public fun asOctothorpeString(): String = String.format("#%08X", c)
}
