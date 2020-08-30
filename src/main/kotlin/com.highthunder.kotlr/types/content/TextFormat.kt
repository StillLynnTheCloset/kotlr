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
public sealed class TextFormat {
    internal companion object {
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

    public abstract val start: Int?
    public abstract val end: Int?
    internal abstract val type: String
}

/**
 * UnknownTextFormat - Placeholder that is generated when a TextFormat with an unknown [type] is encountered.
 */
@JsonClass(generateAdapter = true)
public class UnknownTextFormat : TextFormat() {
    internal companion object {
        internal const val KEY: String = "unknown"
    }

    override val start: Int? = null
    override val end: Int? = null
    override val type: String = KEY
}

/**
 * BoldTextFormat - A text format to allow bolding text.
 */
@JsonClass(generateAdapter = true)
public data class BoldTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "bold"
    }
}

/**
 * ItalicTextFormat - A text format to allow italicising text.
 */
@JsonClass(generateAdapter = true)
public data class ItalicTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "italic"
    }
}

/**
 * StrikeThroughTextFormat - A text format to allow striking out text.
 */
@JsonClass(generateAdapter = true)
public data class StrikeThroughTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "strikethrough"
    }
}

/**
 * LinkTextFormat - A text format to allow marking the formatted text as an arbitrary link.
 *
 * @param url The link's URL!
 */
@JsonClass(generateAdapter = true)
public data class LinkTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    val url: String? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "link"
    }
}

/**
 * MentionTextFormat - A text format to allow marking the formatted text as a link to a blog.
 *
 * @param blog An object with a uuid field, which is the mentioned blog's UUID.
 */
@JsonClass(generateAdapter = true)
public data class MentionTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    val blog: Blog? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "mention"
    }
}

/**
 * ColorTextFormat - A text format to allow changing the foreground color of the formatted text.
 *
 * @param hex The color to use, in standard hex format, with leading '#'.
 */
@JsonClass(generateAdapter = true)
public data class ColorTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    @HexColorOctothorpe val hex: Color? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "color"
    }
}

/**
 * SizeTextFormat - A deprecated mechanism for altering the size of text in a post.
 *
 * @param size The text size for this particular range of text, one of 'small' or 'big'.
 */
@Deprecated(
    message = "This was removed from the Tumblr API spec and is unsupported when creating posts.",
    replaceWith = ReplaceWith("SmallTextFormat()")
)
@JsonClass(generateAdapter = true)
public data class SizeTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    val size: Option? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "size"
    }

    /**
     * Option - The size option used.
     */
    @Deprecated(
        message = "This was removed from the Tumblr API spec and is unsupported when creating posts.",
        replaceWith = ReplaceWith("SmallTextFormat()")
    )
    @JsonClass(generateAdapter = false)
    public enum class Option {
        /**
         * Smaller than normal text.
         */
        @Json(name = "small")
        Small,

        /**
         * Bigger than normal text.
         */
        @Json(name = "big")
        Big
    }
}

/**
 * SmallTextFormat - Format the specified range of text to be smaller.
 *
 * Note: small refers to one-text-size smaller by default.
 * https://developer.mozilla.org/en-US/docs/Web/HTML/Element/small
 *
 * These formats should not compound, if there are multiple overlapping [SmallTextFormat]s in a post, the covered text
 * should still only be one size smaller than normal.
 * https://github.com/tumblr/docs/issues/16#issuecomment-657631209
 */
@JsonClass(generateAdapter = true)
public data class SmallTextFormat constructor(
    override val start: Int? = null,
    override val end: Int? = null,
    override val type: String = KEY,
) : TextFormat() {
    internal companion object {
        internal const val KEY: String = "small"
    }
}
