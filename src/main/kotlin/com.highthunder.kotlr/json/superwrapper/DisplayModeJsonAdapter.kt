package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.BlockLayout.Row.Display.Mode
import com.highthunder.kotlr.types.content.BlockLayout.Row.Display.Mode.Carousel
import com.highthunder.kotlr.types.content.BlockLayout.Row.Display.Mode.Weighted
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * DisplayModeJsonAdapter - An adapter to help Moshi convert [SuperDisplayModeJson] objects to and
 * from individual subclasses of [BlockLayout.Row.Display.Mode].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class DisplayModeJsonAdapter {

    @FromJson
    fun toDisplayMode(input: SuperDisplayModeJson?): Mode {
        return when (input?.type) {
            Weighted.KEY -> input.toWeighted()
            Carousel.KEY -> input.toCarousel()
            else -> Weighted()
        }
    }

    @ToJson
    fun fromDisplayMode(input: Mode): SuperDisplayModeJson? {
        return when (input) {
            is Weighted -> SuperDisplayModeJson(input)
            is Carousel -> SuperDisplayModeJson(input)
        }
    }

}
