package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.json.PolymorphicJsonAdapterFactory
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * BlockLayout - To lay out the blocks of a Post in a way that's different than the default
 * vertical stack, you can use the optional layout block alongside the content block array.
 * The layout block holds an array of layouts. Each layout object requires a type field,
 * just like content blocks.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class BlockLayout {
    companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(BlockLayout::class.java, "type")
            .withDefaultValue(UnknownBlockLayout())
            .withMissingLabelType(VerticalBlockLayout::class.java)

            .withSubtype(VerticalBlockLayout::class.java, VerticalBlockLayout.KEY)
            .withSubtype(RowBlockLayout::class.java, RowBlockLayout.KEY)
            .withSubtype(CondensedBlockLayout::class.java, CondensedBlockLayout.KEY)
            .withSubtype(AskBlockLayout::class.java, AskBlockLayout.KEY)
            .withSubtype(UnknownBlockLayout::class.java, UnknownBlockLayout.KEY)
    }

    internal abstract val type: String
}

/**
 * UnknownBlockLayout - Placeholder that is generated when a Layout with an unknown [type] is encountered.
 */
@JsonClass(generateAdapter = true)
class UnknownBlockLayout : BlockLayout() {
    companion object {
        const val KEY: String = "unknown"
    }

    override val type: String = KEY
}

/**
 * Vertical Layout - The default layout type, each content block should be placed below the
 * previous block.
 */
@JsonClass(generateAdapter = true)
data class VerticalBlockLayout constructor(
    override val type: String = KEY
) : BlockLayout() {
    companion object {
        const val KEY: String = "vertical"
    }
}

/**
 * Row Layout - The most basic type of layout block is "rows", which allows you to organize content blocks in rows, with variable elements per row.
 *
 * Each rows layout object requires a display object under the display key.
 * This display object is an array of dictionaries containing both the array of blocks to be used in the row as well
 * as an optional mode dictionary with a specified type. The default display mode is weighted. The display mode type
 * does not need to be specified when creating a Post with NPF content. each one representing a different row to be
 * rendered with the given content blocks.
 *
 * @param rows This is an array of the rows and block indices per row, for basic row layouts.
 * @param display This is an array of display objects per row, see [RowBlockLayout.Display].
 * @param truncateAfter The last block to display before the Read More signifier.
 */
@JsonClass(generateAdapter = true)
data class RowBlockLayout constructor(
    val rows: List<List<Int>>? = null,
    val display: List<Display>? = null,
    @Json(name = "truncate_after")
    val truncateAfter: Int? = null,
    override val type: String = KEY
) : BlockLayout() {
    companion object {
        const val KEY: String = "rows"
    }

    /**
     *  TODO: Documentation
     *
     * @param blocks TODO: Documentation
     * @param mode TODO: Documentation
     */
    @JsonClass(generateAdapter = true)
    data class Display constructor(
        @Json(name = "blocks")
        val blocks: List<Int>? = null,
        @Json(name = "mode")
        val mode: Mode? = Mode.Weighted()
    ) {

        /**
         *  TODO: Documentation
         */
        sealed class Mode {
            companion object {
                internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
                    .of(Mode::class.java, "type")
                    .withDefaultValue(Unknown())
                    .withMissingLabelType(Weighted::class.java)

                    .withSubtype(Weighted::class.java, Weighted.KEY)
                    .withSubtype(Carousel::class.java, Carousel.KEY)
                    .withSubtype(Unknown::class.java, Unknown.KEY)
            }

            internal abstract val type: String

            @JsonClass(generateAdapter = true)
            class Unknown : Mode() {
                companion object {
                    const val KEY: String = "Unknown"
                }

                override val type: String = KEY
            }

            @JsonClass(generateAdapter = true)
            data class Weighted constructor(
                override val type: String = KEY
            ) : Mode() {
                companion object {
                    const val KEY: String = "weighted"
                }
            }

            @JsonClass(generateAdapter = true)
            data class Carousel constructor(
                override val type: String = KEY
            ) : Mode() {
                companion object {
                    const val KEY: String = "carousel"
                }
            }
        }
    }
}

/**
 * Condensed Layout - The condensed layout is deprecated and replaced by the truncate_after property in the rows layout.
 *
 * Please use the rows layout to get or set a recommended truncation index.
 * If a post is created with a condensed layout, it will be ignored by the backend.
 * In other words, a read-more will not show up in the post.
 *
 * Another type of layout is the condensed layout.
 * The condensed layout describes how the content should be truncated given a Post with a legacy "read more" signifier.
 * It contains a truncate_after property that specifies the last block that should be displayed in the truncated view of the post.
 *
 * If any blocks exist after the condensed layout's truncate_after index, they should be ignored when displaying the truncated view of the Post.
 *
 * Note that there are certain contexts where the condensed layout should not be displayed
 * (namely a permalink revealing the full Post), but the server will return this condensed layout for all contexts;
 * this means it is up to the client to determine whether to actually use it.
 * It is expected that the client should use it in every context (a dashboard, via search, etc)
 * except viewing the blog or Post directly.
 *
 * @param blocks Deprecated by Tumblr. This is an array of block indices that are a part of the truncated version of the Post. Required if truncate_after is not supplied. Must be sequential, not empty, and begin with 0.
 * @param truncateAfter The last block to display before the Read More signifier. Required if blocks is not supplied. The truncate_after property will replace the blocks property in future versions of the Tumblr API. The blocks property consists of a blocks integer array that specifies the block indices that should be displayed as the truncated view of the Post. During the transition period, API responses will contain both the truncate_after and blocks properties
 */
@Deprecated("Use a [RowBlockLayout] with truncateAfter instead.")
@JsonClass(generateAdapter = true)
data class CondensedBlockLayout constructor(
    @Deprecated("Use truncateAfter instead.")
    val blocks: List<Int>? = null,
    @Json(name = "truncate_after")
    val truncateAfter: Int? = null,
    override val type: String = KEY
) : BlockLayout() {
    companion object {
        const val KEY: String = "condensed"
    }
}

/**
 * Ask Layout - When a Post has Ask/Answer content in it,
 * we use a layout object of type "ask" to specify which block indices are part of the "ask",
 * as well as what blog (if any) should be attributed as sending the ask.
 * Any blocks not specified in the blocks array should be considered a part of the ask's "answer" content.
 * Clients are expected to visually separate these two groups of blocks.
 *
 * In the below example, blocks at index 0 and 1 are a part of @cyle's ask.
 * Any remaining blocks are a part of the posting blog's answer.
 * If no attribution object exists, then the ask is anonymous.
 *
 * @param blocks This is an array of block indices that are a part of the ask content of the Post.
 * @param attribution If the ask is not anonymous, this will include information about the blog that submitted the ask.
 */
@JsonClass(generateAdapter = true)
data class AskBlockLayout constructor(
    val blocks: List<Int>? = null,
    val attribution: Attribution? = null,
    override val type: String = KEY
) : BlockLayout() {
    companion object {
        const val KEY: String = "ask"
    }
}
