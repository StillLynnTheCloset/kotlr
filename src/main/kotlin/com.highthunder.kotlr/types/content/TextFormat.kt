package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.json.PolymorphicJsonAdapterFactory
import com.highthunder.kotlr.json.qualifier.HexColorOctothorpe
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Color
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * TextFormat - In addition to subtypes at the Text block level, the text within a Text block
 * can have inline styles like bold, italic, external links, blog mentions, and colors.
 *
 * Inline formatting ranges (start and end) are zero-indexed and count each character as 1.
 * Ranges are inclusive at the start and exclusive at the end.
 *
 * A single unicode character is also treated as one character in this indexing, despite
 * possibly being multiple bytes. For example, ø and 🌳 are both counted as single characters in
 * NPF. However, a composite emoji like 👨‍👨‍👦 is five characters, as it is made up of
 * five unicode codepoints.
 *
 * Overlapping ranges of the same type should be combined or separated into non-overlapping ranges.
 * Overlapping ranges of different types should all be applied to the text, although it is up to
 * the Tumblr API to reconcile the ranges as needed to display correctly, just like
 * when nesting HTML.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @property start The starting index of the formatting range (inclusive).
 * @property end The ending index of the formatting range (exclusive).
 * @property type The subtype label for each subtype, only used during (de)serialization.
 */
sealed class TextFormat {
    companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(TextFormat::class.java, "type")
            .withDefaultValue(UnknownTextFormat())

            .withSubtype(BoldTextFormat::class.java, BoldTextFormat.KEY)
            .withSubtype(ItalicTextFormat::class.java, ItalicTextFormat.KEY)
            .withSubtype(StrikeThroughTextFormat::class.java, StrikeThroughTextFormat.KEY)
            .withSubtype(LinkTextFormat::class.java, LinkTextFormat.KEY)
            .withSubtype(MentionTextFormat::class.java, MentionTextFormat.KEY)
            .withSubtype(ColorTextFormat::class.java, ColorTextFormat.KEY)
            .withSubtype(SizeTextFormat::class.java, SizeTextFormat.KEY)
            .withSubtype(SmallTextFormat::class.java, SmallTextFormat.KEY)
            .withSubtype(UnknownTextFormat::class.java, UnknownTextFormat.KEY)
    }

    abstract val start: Int?
    abstract val end: Int?
    internal abstract val type: String
}

/**
 * UnknownTextFormat - Placeholder that is generated when a TextFormat with an unknown [type] is encountered.
 */
@JsonClass(generateAdapter = true)
class UnknownTextFormat : TextFormat() {
    companion object {
        const val KEY: String = "unknown"
    }

    override val start: Int? = null
    override val end: Int? = null
    override val type: String = KEY
}

/**
 * BoldTextFormat - TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class BoldTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "bold"
    }
}

/**
 * ItalicTextFormat- TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class ItalicTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "italic"
    }
}

/**
 * StrikeThroughTextFormat- TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class StrikeThroughTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "strikethrough"
    }
}

/**
 * LinkTextFormat - TODO: Documentation
 *
 * @param url The link's URL!
 */
@JsonClass(generateAdapter = true)
data class LinkTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    val url: String? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "link"
    }
}

/**
 * MentionTextFormat - TODO: Documentation
 *
 * @param blog An object with a uuid field, which is the mentioned blog's UUID.
 */
@JsonClass(generateAdapter = true)
data class MentionTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    val blog: Blog? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "mention"
    }
}

/**
 * ColorTextFormat - TODO: Documentation
 *
 * @param hex The color to use, in standard hex format, with leading '#'.
 */
@JsonClass(generateAdapter = true)
data class ColorTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    @HexColorOctothorpe val hex: Color? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "color"
    }
}

/**
 * SizeTextFormat - TODO: Documentation
 *
 * @param size The text size for this particular range of text, one of 'small' or 'big'.
 */
@Deprecated("This was removed from the Tumblr API spec and is unsupported when creating posts.")
@JsonClass(generateAdapter = true)
data class SizeTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    val size: Option? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "size"
    }

    /**
     * TODO: Documentation
     */
    @Deprecated("This was removed from the Tumblr API spec and is unsupported when creating posts.")
    @JsonClass(generateAdapter = false)
    enum class Option() {
        /**
         * TODO: Documentation
         */
        @Json(name = "small")
        Small,
        /**
         * TODO: Documentation
         */
        @Json(name = "big")
        Big
    }
}

/**
 * SmallTextFormat - Format the specified range of text to be smaller
 *
 * Note: small refers to one-text-size smaller by default.
 * https://developer.mozilla.org/en-US/docs/Web/HTML/Element/small
 */
@JsonClass(generateAdapter = true)
data class SmallTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY
) : TextFormat() {
    companion object {
        const val KEY: String = "small"
    }
}
