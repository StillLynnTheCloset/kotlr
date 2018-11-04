package com.highthunder.kotlr.types.content

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * BlockLayout - To lay out the blocks of a Post in a way that's different than the default
 * vertical stack, you can use the optional layout block alongside the content block array.
 * The layout block holds an array of layouts. Each layout object requires a type field,
 * just like content blocks.
 *TODO: Documentation
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class BlockLayout {

    /**
     * Vertical Layout - The default layout type, each content block should be placed below the
     * previous block.
     */
    class Vertical : BlockLayout() {
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
    class Row(
            var rows: List<List<Int>>? = null,
            var display: List<Display>? = null
    ) : BlockLayout() {

        companion object {
            const val KEY: String = "rows"
        }

        @JsonClass(generateAdapter = true)
        data class Display(
                @Json(name = "blocks")
                var blocks: List<Int>? = null,
                @Json(name = "mode")
                var mode: Mode? = Mode.Weighted()
        ) {

            sealed class Mode {

                class Weighted : Mode() {
                    companion object {
                        const val KEY: String = "weighted"
                    }
                }

                class Carousel : Mode() {
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
     * @param blocks This is an array of block indices that are a part of the truncated version of the Post.
     */
    class Condensed(
            var blocks: List<Int>? = null
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
    class Ask(
            var blocks: List<Int>? = null,
            var attribution: Attribution? = null
    ) : BlockLayout() {
        companion object {
            const val KEY: String = "ask"
        }
    }

}
