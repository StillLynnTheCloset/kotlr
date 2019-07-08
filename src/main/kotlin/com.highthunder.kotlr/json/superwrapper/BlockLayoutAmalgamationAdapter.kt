package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.AskBlockLayout
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.CondensedBlockLayout
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.VerticalBlockLayout
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
internal class BlockLayoutAmalgamationAdapter {
    @FromJson
    fun toLayout(input: BlockLayoutAmalgamation?): BlockLayout {
        return when (input?.type) {
            VerticalBlockLayout.KEY -> input.toVerticalLayout()
            RowBlockLayout.KEY -> input.toRowLayout()
            CondensedBlockLayout.KEY -> input.toCondensedLayout()
            AskBlockLayout.KEY -> input.toAskLayout()
            else -> VerticalBlockLayout()
        }
    }

    @ToJson
    fun fromLayout(input: BlockLayout): BlockLayoutAmalgamation? {
        return when (input) {
            is VerticalBlockLayout -> BlockLayoutAmalgamation(input)
            is RowBlockLayout -> BlockLayoutAmalgamation(input)
            is CondensedBlockLayout -> BlockLayoutAmalgamation(input)
            is AskBlockLayout -> BlockLayoutAmalgamation(input)
        }
    }
}
