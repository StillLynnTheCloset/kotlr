package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.types.Blog
import com.squareup.moshi.Json

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
 * @param start The starting index of the formatting range (inclusive).
 * @param end The ending index of the formatting range (exclusive).
 *
 * LinkFormat
 * @param url The link's URL!
 *
 * MentionFormat
 * @param blog An object with a uuid field, which is the mentioned blog's UUID.
 *
 * ColorFormat
 * @param hex The color to use, in standard hex format, with leading '#'.
 *
 * SizeFormat
 * @param size The text size for this particular range of text, one of 'small' or 'big'.
 */
sealed class TextFormat(
        var start: Int?,
        var end: Int?) {

    class Bold(
            start: Int? = null,
            end: Int? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "bold"
        }
    }

    class Italic(
            start: Int? = null,
            end: Int? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "italic"
        }
    }

    class StrikeThrough(
            start: Int? = null,
            end: Int? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "strikethrough"
        }
    }

    class Link(
            start: Int? = null,
            end: Int? = null,
            var url: String? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "link"
        }
    }

    class Mention(
            start: Int? = null,
            end: Int? = null,
            var blog: Blog? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "mention"
        }
    }

    class Color(
            start: Int? = null,
            end: Int? = null,
            var hex: String? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "color"
        }
    }

    class Size(
            start: Int? = null,
            end: Int? = null,
            var size: Option? = null
    ) : TextFormat(start, end) {
        companion object {
            const val KEY: String = "size"
        }

        enum class Option {
            @Json(name = "small")
            Small,
            @Json(name = "big")
            Big
        }
    }

}
