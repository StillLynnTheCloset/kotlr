package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.BoldTextFormat
import com.highthunder.kotlr.types.content.ColorTextFormat
import com.highthunder.kotlr.types.content.ItalicTextFormat
import com.highthunder.kotlr.types.content.LinkTextFormat
import com.highthunder.kotlr.types.content.MentionTextFormat
import com.highthunder.kotlr.types.content.SizeTextFormat
import com.highthunder.kotlr.types.content.StrikeThroughTextFormat
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
internal class TextFormatAmalgamationAdapter {
    @FromJson
    fun toFormat(input: TextFormatAmalgamation?): TextFormat {
        return when (input?.type) {
            BoldTextFormat.KEY -> input.toBold()
            ItalicTextFormat.KEY -> input.toItalic()
            StrikeThroughTextFormat.KEY -> input.toStrikeThrough()
            LinkTextFormat.KEY -> input.toLink()
            MentionTextFormat.KEY -> input.toMention()
            ColorTextFormat.KEY -> input.toColor()
            SizeTextFormat.KEY -> input.toSize()
            else -> throw JsonDataException("Expected a field of type TextFormatAmalgamation but got $input")
        }
    }

    @ToJson
    fun fromFormat(input: TextFormat): TextFormatAmalgamation? {
        return when (input) {
            is BoldTextFormat -> TextFormatAmalgamation(input)
            is ItalicTextFormat -> TextFormatAmalgamation(input)
            is StrikeThroughTextFormat -> TextFormatAmalgamation(input)
            is LinkTextFormat -> TextFormatAmalgamation(input)
            is MentionTextFormat -> TextFormatAmalgamation(input)
            is ColorTextFormat -> TextFormatAmalgamation(input)
            is SizeTextFormat -> TextFormatAmalgamation(input)
        }
    }
}
