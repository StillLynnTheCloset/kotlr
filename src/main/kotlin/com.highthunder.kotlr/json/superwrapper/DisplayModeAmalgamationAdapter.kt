package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.BlockLayout.Row.Display.Mode
import com.highthunder.kotlr.types.content.BlockLayout.Row.Display.Mode.Carousel
import com.highthunder.kotlr.types.content.BlockLayout.Row.Display.Mode.Weighted
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * DisplayModeAmalgamationAdapter - An adapter to help Moshi convert [DisplayModeAmalgamation] objects to and
 * from individual subclasses of [BlockLayout.Row.Display.Mode].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class DisplayModeAmalgamationAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toDisplayMode(input: DisplayModeAmalgamation?): Mode {
        return when (input?.type) {
            Weighted.KEY -> input.toWeighted()
            Carousel.KEY -> input.toCarousel()
            else -> Weighted()
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromDisplayMode(input: Mode): DisplayModeAmalgamation? {
        return when (input) {
            is Weighted -> DisplayModeAmalgamation(input)
            is Carousel -> DisplayModeAmalgamation(input)
        }
    }

}
