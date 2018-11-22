package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.json.qualifier.HexColorOctothorpe
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Color
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.content.TextFormat.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * TextFormatAmalgamation - A class to hold every possible field for [TextFormat] so that Mochi can
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
internal data class TextFormatAmalgamation constructor(
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
    @HexColorOctothorpe var hex: Color? = null,
    @Json(name = "size")
    var size: TextFormat.Size.Option? = null
) {

    constructor(format: TextFormat.Bold) : this(format.start, format.end)
    constructor(format: TextFormat.Italic) : this(format.start, format.end)
    constructor(format: TextFormat.StrikeThrough) : this(format.start, format.end)
    constructor(format: TextFormat.Link) : this(format.start, format.end, url = format.url)
    constructor(format: TextFormat.Mention) : this(format.start, format.end, blog = format.blog)
    constructor(format: TextFormat.Color) : this(format.start, format.end, hex = format.hex)
    constructor(format: TextFormat.Size) : this(format.start, format.end, size = format.size)

    /**
     * TODO: Documentation
     */
    fun toBold(): TextFormat.Bold = TextFormat.Bold(start, end)

    /**
     * TODO: Documentation
     */
    fun toItalic(): TextFormat.Italic = TextFormat.Italic(start, end)

    /**
     * TODO: Documentation
     */
    fun toStrikeThrough(): TextFormat.StrikeThrough = TextFormat.StrikeThrough(start, end)

    /**
     * TODO: Documentation
     */
    fun toLink(): TextFormat.Link = TextFormat.Link(start, end, url)

    /**
     * TODO: Documentation
     */
    fun toMention(): TextFormat.Mention = TextFormat.Mention(start, end, blog)

    /**
     * TODO: Documentation
     */
    fun toColor(): TextFormat.Color = TextFormat.Color(start, end, hex)

    /**
     * TODO: Documentation
     */
    fun toSize(): TextFormat.Size = TextFormat.Size(start, end, size)

}
