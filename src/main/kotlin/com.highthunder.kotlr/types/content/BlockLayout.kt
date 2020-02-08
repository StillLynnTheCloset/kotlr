package com.highthunder.kotlr.types.content

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
sealed class BlockLayout

/**
 * Vertical Layout - The default layout type, each content block should be placed below the
 * previous block.
 */
class VerticalBlockLayout : BlockLayout() {
    companion object {
        const val KEY: String = "vertical"
    }
}

/**
 * Row Layout
 *
 * @param rows This is an array of the rows and block indices per row, for basic row layouts.
 * @param display This is an array of display objects per row, see [BlockLayout.Row.Display].
 */
data class RowBlockLayout constructor(
    val rows: List<List<Int>>? = null,
    val display: List<Display>? = null
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
            abstract val type: String
            class Weighted : Mode() {
                companion object {
                    const val KEY: String = "weighted"
                }
                override val type: String = KEY
            }
            class Carousel : Mode() {
                companion object {
                    const val KEY: String = "carousel"
                }
                override val type: String = KEY
            }
        }
    }
}

/**
 * Condensed Layout
 *
 * @param blocks This is an array of block indices that are a part of the truncated version of the Post.
 */
data class CondensedBlockLayout constructor(
    val blocks: List<Int>? = null
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
data class AskBlockLayout constructor(
    val blocks: List<Int>? = null,
    val attribution: Attribution? = null
) : BlockLayout() {
    companion object {
        const val KEY: String = "ask"
    }
}
