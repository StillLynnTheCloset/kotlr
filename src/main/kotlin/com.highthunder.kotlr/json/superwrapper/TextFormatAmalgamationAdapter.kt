package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * TextFormatAmalgamationAdapter - An adapter to help Moshi convert [TextFormatAmalgamation] objects to and
 * from individual subclasses of [TextFormat].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class TextFormatAmalgamationAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toFormat(input: TextFormatAmalgamation?): TextFormat {
        return when (input?.type) {
            TextFormat.Bold.KEY -> input.toBold()
            TextFormat.Italic.KEY -> input.toItalic()
            TextFormat.StrikeThrough.KEY -> input.toStrikeThrough()
            TextFormat.Link.KEY -> input.toLink()
            TextFormat.Mention.KEY -> input.toMention()
            TextFormat.Color.KEY -> input.toColor()
            TextFormat.Size.KEY -> input.toSize()
            else -> throw JsonDataException("Expected a field of type TextFormatAmalgamation but got $input")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromFormat(input: TextFormat): TextFormatAmalgamation? {
        return when (input) {
            is TextFormat.Bold -> TextFormatAmalgamation(input)
            is TextFormat.Italic -> TextFormatAmalgamation(input)
            is TextFormat.StrikeThrough -> TextFormatAmalgamation(input)
            is TextFormat.Link -> TextFormatAmalgamation(input)
            is TextFormat.Mention -> TextFormatAmalgamation(input)
            is TextFormat.Color -> TextFormatAmalgamation(input)
            is TextFormat.Size -> TextFormatAmalgamation(input)
        }
    }
}
