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
            .withDefaultValue(UnknownBlockLayout)
            .withMissingLabelType(VerticalBlockLayout::class.java)

            .withSubtype(VerticalBlockLayout::class.java, VerticalBlockLayout.KEY)
            .withSubtype(RowBlockLayout::class.java, RowBlockLayout.KEY)
            .withSubtype(CondensedBlockLayout::class.java, CondensedBlockLayout.KEY)
            .withSubtype(AskBlockLayout::class.java, AskBlockLayout.KEY)
    }

    internal abstract val type: String
}

object UnknownBlockLayout : BlockLayout() {
    override val type: String = "unknown"
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
 * Row Layout
 *
 * @param rows This is an array of the rows and block indices per row, for basic row layouts.
 * @param display This is an array of display objects per row, see [RowBlockLayout.Display].
 */
@JsonClass(generateAdapter = true)
data class RowBlockLayout constructor(
    val rows: List<List<Int>>? = null,
    val display: List<Display>? = null,
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
                    .withDefaultValue(Unknown)
                    .withMissingLabelType(Weighted::class.java)

                    .withSubtype(Weighted::class.java, Weighted.KEY)
                    .withSubtype(Carousel::class.java, Carousel.KEY)
            }

            internal abstract val type: String

            object Unknown : Mode() {
                override val type: String = "Unknown"
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
 * Condensed Layout
 *
 * @param blocks Deprecated by Tumblr. This is an array of block indices that are a part of the truncated version of the Post. Required if truncate_after is not supplied. Must be sequential, not empty, and begin with 0.
 * @param truncateAfter The last block to display before the Read More signifier. Required if blocks is not supplied. The truncate_after property will replace the blocks property in future versions of the Tumblr API. The blocks property consists of a blocks integer array that specifies the block indices that should be displayed as the truncated view of the Post. During the transition period, API responses will contain both the truncate_after and blocks properties
 */
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
 * Ask Layout
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
