package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.RowBlockLayout.Display.Mode
import com.highthunder.kotlr.types.content.RowBlockLayout.Display.Mode.Carousel
import com.highthunder.kotlr.types.content.RowBlockLayout.Display.Mode.Weighted
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * DisplayModeAmalgamationAdapter - An adapter to help Moshi convert [DisplayModeAmalgamation] objects to and
 * from individual subclasses of [RowBlockLayout.Display.Mode].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class DisplayModeAmalgamationAdapter {
    @FromJson
    fun toDisplayMode(input: DisplayModeAmalgamation?): Mode {
        return when (input?.type) {
            Weighted.KEY -> input.toWeighted()
            Carousel.KEY -> input.toCarousel()
            else -> Weighted()
        }
    }

    @ToJson
    fun fromDisplayMode(input: Mode): DisplayModeAmalgamation? {
        return when (input) {
            is Weighted -> DisplayModeAmalgamation(input)
            is Carousel -> DisplayModeAmalgamation(input)
        }
    }
}
