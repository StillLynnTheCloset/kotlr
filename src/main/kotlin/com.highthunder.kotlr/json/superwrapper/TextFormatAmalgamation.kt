package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.json.qualifier.HexColorOctothorpe
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Color
import com.highthunder.kotlr.types.content.BoldTextFormat
import com.highthunder.kotlr.types.content.ColorTextFormat
import com.highthunder.kotlr.types.content.ItalicTextFormat
import com.highthunder.kotlr.types.content.LinkTextFormat
import com.highthunder.kotlr.types.content.MentionTextFormat
import com.highthunder.kotlr.types.content.SizeTextFormat
import com.highthunder.kotlr.types.content.StrikeThroughTextFormat
import com.highthunder.kotlr.types.content.TextFormat
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
 * [LinkTextFormat]
 * @param url The link's URL!
 *
 * [MentionTextFormat]
 * @param blog An object with a uuid field, which is the mentioned blog's UUID.
 *
 * [ColorTextFormat]
 * @param hex The color to use, in standard hex format, with leading '#'.
 *
 * [SizeTextFormat]
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
    var size: SizeTextFormat.Option? = null
) {
    constructor(format: BoldTextFormat) : this(format.start, format.end)
    constructor(format: ItalicTextFormat) : this(format.start, format.end)
    constructor(format: StrikeThroughTextFormat) : this(format.start, format.end)
    constructor(format: LinkTextFormat) : this(format.start, format.end, url = format.url)
    constructor(format: MentionTextFormat) : this(format.start, format.end, blog = format.blog)
    constructor(format: ColorTextFormat) : this(format.start, format.end, hex = format.hex)
    constructor(format: SizeTextFormat) : this(format.start, format.end, size = format.size)

    fun toBold(): BoldTextFormat = BoldTextFormat(start, end)
    fun toItalic(): ItalicTextFormat = ItalicTextFormat(start, end)
    fun toStrikeThrough(): StrikeThroughTextFormat = StrikeThroughTextFormat(start, end)
    fun toLink(): LinkTextFormat = LinkTextFormat(start, end, url)
    fun toMention(): MentionTextFormat = MentionTextFormat(start, end, blog)
    fun toColor(): ColorTextFormat = ColorTextFormat(start, end, hex)
    fun toSize(): SizeTextFormat = SizeTextFormat(start, end, size)
}
