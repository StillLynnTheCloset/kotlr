package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.BlockLayout.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * BlockLayoutAmalgamation - A class to hold every possible field for [BlockLayout] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * All:
 * @param type TODO: Documentation
 *
 * [Vertical]
 * No params
 *
 * [Row]
 * @param rows This is an array of the rows and block indices per row, for basic row layouts.
 * @param display This is an array of display objects per row, see [BlockLayout.Row.Display].
 *
 * [Condensed]
 * @param blocks This is an array of block indices that are a part of the truncated version of the Post.
 *
 * [Ask]
 * @param blocks This is an array of block indices that are a part of the ask content of the Post.
 * @param attribution If the ask is not anonymous, this will include information about the blog that submitted the ask.
 */
@JsonClass(generateAdapter = true)
data class BlockLayoutAmalgamation(
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "rows")
    var rows: List<List<Int>>? = null,
    @Json(name = "blocks")
    var blocks: List<Int>? = null,
    @Json(name = "display")
    var display: List<BlockLayout.Row.Display>? = null,
    @Json(name = "attribution")
    var attribution: Attribution? = null
) {

    constructor(layout: BlockLayout.Vertical) : this(BlockLayout.Vertical.KEY)
    constructor(layout: BlockLayout.Row) : this(BlockLayout.Row.KEY, rows = layout.rows, display = layout.display)
    constructor(layout: BlockLayout.Condensed) : this(BlockLayout.Condensed.KEY, blocks = layout.blocks)
    constructor(layout: BlockLayout.Ask) : this(
        BlockLayout.Ask.KEY,
        blocks = layout.blocks,
        attribution = layout.attribution
    )

    /**
     * TODO: Documentation
     */
    fun toVerticalLayout(): BlockLayout.Vertical = BlockLayout.Vertical()

    /**
     * TODO: Documentation
     */
    fun toRowLayout(): BlockLayout.Row = BlockLayout.Row(rows, display)

    /**
     * TODO: Documentation
     */
    fun toCondensedLayout(): BlockLayout.Condensed = BlockLayout.Condensed(blocks)

    /**
     * TODO: Documentation
     */
    fun toAskLayout(): BlockLayout.Ask = BlockLayout.Ask(blocks, attribution)

}
