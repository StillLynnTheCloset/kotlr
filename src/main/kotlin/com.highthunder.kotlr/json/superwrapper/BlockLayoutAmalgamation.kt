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
 * @param blocks This is an array of block indices that are a part of the truncated version of the Post. Required if truncate_after is not supplied. Must be sequential, not empty, and begin with 0.
 * @param truncateAfter The last block to display before the Read More signifier. Required if blocks is not supplied. The truncate_after property will replace the blocks property in future versions of the Tumblr API. The blocks property consists of a blocks integer array that specifies the block indices that should be displayed as the truncated view of the Post. During the transition period, API responses will contain both the truncate_after and blocks properties.
 *
 * [AskBlockLayout]
 * @param blocks This is an array of block indices that are a part of the ask content of the Post.
 * @param attribution If the ask is not anonymous, this will include information about the blog that submitted the ask.
 */
@JsonClass(generateAdapter = true)
internal data class BlockLayoutAmalgamation constructor(
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "rows")
    val rows: List<List<Int>>? = null,
    @Json(name = "blocks")
    val blocks: List<Int>? = null,
    @Json(name = "truncate_after")
    val truncateAfter: Int? = null,
    @Json(name = "display")
    val display: List<RowBlockLayout.Display>? = null,
    @Json(name = "attribution")
    val attribution: Attribution? = null
) {
    constructor(layout: VerticalBlockLayout) : this(
        VerticalBlockLayout.KEY
    )

    constructor(layout: RowBlockLayout) : this(
        type = RowBlockLayout.KEY,
        rows = layout.rows,
        display = layout.display
    )

    constructor(layout: CondensedBlockLayout) : this(
        type = CondensedBlockLayout.KEY,
        blocks = layout.blocks,
        truncateAfter = layout.truncateAfter
    )

    constructor(layout: AskBlockLayout) : this(
        type = AskBlockLayout.KEY,
        blocks = layout.blocks,
        attribution = layout.attribution
    )

    fun toVerticalLayout(): VerticalBlockLayout = VerticalBlockLayout()

    fun toRowLayout(): RowBlockLayout = RowBlockLayout(rows, display)

    fun toCondensedLayout(): CondensedBlockLayout = CondensedBlockLayout(blocks, truncateAfter)

    fun toAskLayout(): AskBlockLayout = AskBlockLayout(blocks, attribution)
}
