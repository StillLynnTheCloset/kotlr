package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.BlockLayout
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * LayoutJsonAdapter - An adapter to help Moshi convert [SuperLayoutJson] objects to and
 * from individual subclasses of [BlockLayout].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class LayoutJsonAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toLayout(input: SuperLayoutJson?): BlockLayout {
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
    fun fromLayout(input: BlockLayout): SuperLayoutJson? {
        return when (input) {
            is BlockLayout.Vertical -> SuperLayoutJson(input)
            is BlockLayout.Row -> SuperLayoutJson(input)
            is BlockLayout.Condensed -> SuperLayoutJson(input)
            is BlockLayout.Ask -> SuperLayoutJson(input)
        }
    }

}
