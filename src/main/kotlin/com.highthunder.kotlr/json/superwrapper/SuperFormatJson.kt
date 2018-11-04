package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.content.TextFormat.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * SuperFormatJson - A class to hold every possible field for [TextFormat] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param start The starting index of the formatting range (inclusive).
 * @param end The ending index of the formatting range (exclusive).
 * @param type The type of formatting range.
 *
 * [Link]
 * @param url The link's URL!
 *
 * [Mention]
 * @param blog An object with a uuid field, which is the mentioned blog's UUID.
 *
 * [Color]
 * @param hex The color to use, in standard hex format, with leading '#'.
 *
 * [Size]
 * @param size The text size for this particular range of text, one of 'small' or 'big'.
 */
@JsonClass(generateAdapter = true)
data class SuperFormatJson constructor(
        @Json(name = "start")
        var start: Int? = null,
        @Json(name = "end")
        var end: Int? = null,
        @Json(name = "type")
        var type: String? = null,
        @Json(name = "url")
        var url: String? = null,
        @Json(name = "blog")
        var blog: Blog? = null,
        @Json(name = "hex")
        var hex: String? = null,
        @Json(name = "size")
        var size: TextFormat.Size.Option? = null) {

    constructor(format: TextFormat.Bold) : this(format.start, format.end)
    constructor(format: TextFormat.Italic) : this(format.start, format.end)
    constructor(format: TextFormat.StrikeThrough) : this(format.start, format.end)
    constructor(format: TextFormat.Link) : this(format.start, format.end, url = format.url)
    constructor(format: TextFormat.Mention) : this(format.start, format.end, blog = format.blog)
    constructor(format: TextFormat.Color) : this(format.start, format.end, hex = format.hex)
    constructor(format: TextFormat.Size) : this(format.start, format.end, size = format.size)

    fun toBold(): TextFormat.Bold {
        return TextFormat.Bold(start, end)
    }

    fun toItalic(): TextFormat.Italic {
        return TextFormat.Italic(start, end)
    }

    fun toStrikeThrough(): TextFormat.StrikeThrough {
        return TextFormat.StrikeThrough(start, end)
    }

    fun toLink(): TextFormat.Link {
        return TextFormat.Link(start, end, url)
    }

    fun toMention(): TextFormat.Mention {
        return TextFormat.Mention(start, end, blog)
    }

    fun toColor(): TextFormat.Color {
        return TextFormat.Color(start, end, hex)
    }

    fun toSize(): TextFormat.Size {
        return TextFormat.Size(start, end, size)
    }

}
