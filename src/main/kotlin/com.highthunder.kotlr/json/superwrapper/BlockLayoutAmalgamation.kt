package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.AskBlockLayout
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.CondensedBlockLayout
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.VerticalBlockLayout
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
 * [VerticalBlockLayout]
 * No params
 *
 * [RowBlockLayout]
 * @param rows This is an array of the rows and block indices per row, for basic row layouts.
 * @param display This is an array of display objects per row, see [RowBlockLayout.Display].
 *
 * [CondensedBlockLayout]
 * @param blocks This is an array of block indices that are a part of the truncated version of the Post.
 *
 * [AskBlockLayout]
 * @param blocks This is an array of block indices that are a part of the ask content of the Post.
 * @param attribution If the ask is not anonymous, this will include information about the blog that submitted the ask.
 */
@JsonClass(generateAdapter = true)
internal data class BlockLayoutAmalgamation constructor(
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "rows")
    var rows: List<List<Int>>? = null,
    @Json(name = "blocks")
    var blocks: List<Int>? = null,
    @Json(name = "display")
    var display: List<RowBlockLayout.Display>? = null,
    @Json(name = "attribution")
    var attribution: Attribution? = null
) {
    constructor(layout: VerticalBlockLayout) : this(
        VerticalBlockLayout.KEY
    )

    constructor(layout: RowBlockLayout) : this(
        RowBlockLayout.KEY,
        rows = layout.rows,
        display = layout.display
    )

    constructor(layout: CondensedBlockLayout) : this(
        CondensedBlockLayout.KEY,
        blocks = layout.blocks
    )

    constructor(layout: AskBlockLayout) : this(
        AskBlockLayout.KEY,
        blocks = layout.blocks,
        attribution = layout.attribution
    )

    fun toVerticalLayout(): VerticalBlockLayout = VerticalBlockLayout()

    fun toRowLayout(): RowBlockLayout = RowBlockLayout(rows, display)

    fun toCondensedLayout(): CondensedBlockLayout = CondensedBlockLayout(blocks)

    fun toAskLayout(): AskBlockLayout = AskBlockLayout(blocks, attribution)
}
