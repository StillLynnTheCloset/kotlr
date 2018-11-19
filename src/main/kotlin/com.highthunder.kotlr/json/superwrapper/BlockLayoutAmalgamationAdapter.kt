package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.BlockLayout
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * BlockLayoutAmalgamationAdapter - An adapter to help Moshi convert [BlockLayoutAmalgamation] objects to and
 * from individual subclasses of [BlockLayout].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class BlockLayoutAmalgamationAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toLayout(input: BlockLayoutAmalgamation?): BlockLayout {
        return when (input?.type) {
            BlockLayout.Vertical.KEY -> input.toVerticalLayout()
            BlockLayout.Row.KEY -> input.toRowLayout()
            BlockLayout.Condensed.KEY -> input.toCondensedLayout()
            BlockLayout.Ask.KEY -> input.toAskLayout()
            else -> BlockLayout.Vertical()
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromLayout(input: BlockLayout): BlockLayoutAmalgamation? {
        return when (input) {
            is BlockLayout.Vertical -> BlockLayoutAmalgamation(input)
            is BlockLayout.Row -> BlockLayoutAmalgamation(input)
            is BlockLayout.Condensed -> BlockLayoutAmalgamation(input)
            is BlockLayout.Ask -> BlockLayoutAmalgamation(input)
        }
    }

}
