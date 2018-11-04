package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * FormatJsonAdapter - An adapter to help Moshi convert [SuperFormatJson] objects to and
 * from individual subclasses of [TextFormat].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class FormatJsonAdapter {

    @FromJson
    fun toFormat(input: SuperFormatJson?): TextFormat {
        return when (input?.type) {
            TextFormat.Bold.KEY -> input.toBold()
            TextFormat.Italic.KEY -> input.toItalic()
            TextFormat.StrikeThrough.KEY -> input.toStrikeThrough()
            TextFormat.Link.KEY -> input.toLink()
            TextFormat.Mention.KEY -> input.toMention()
            TextFormat.Color.KEY -> input.toColor()
            TextFormat.Size.KEY -> input.toSize()
            else -> throw JsonDataException("Expected a field of type SuperFormatJson but got $input")
        }
    }

    @ToJson
    fun fromFormat(input: TextFormat): SuperFormatJson? {
        return when (input) {
            is TextFormat.Bold -> SuperFormatJson(input)
            is TextFormat.Italic -> SuperFormatJson(input)
            is TextFormat.StrikeThrough -> SuperFormatJson(input)
            is TextFormat.Link -> SuperFormatJson(input)
            is TextFormat.Mention -> SuperFormatJson(input)
            is TextFormat.Color -> SuperFormatJson(input)
            is TextFormat.Size -> SuperFormatJson(input)
        }
    }
}
