package com.highthunder.kotlr.types

import com.highthunder.kotlr.json.qualifier.HexColorOctothorpe
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * BlogTheme - A blog's user customizable theme.
 *
 * This is currently only accessible due to an acknowledged bug on Tumblr's end where they return
 * the theme inside of Blog objects inside of the posts in a post's trail.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * TODO: Documentation
 *
 * @param url TODO: Documentation
 * @param avatarImage TODO: Documentation
 * @param headerImage TODO: Documentation
 * @param headerFullWidth TODO: Documentation
 * @param headerFullHeight TODO: Documentation
 * @param headerFocusWidth TODO: Documentation
 * @param headerFocusHeight TODO: Documentation
 * @param avatarShape TODO: Documentation
 * @param backgroundColor TODO: Documentation
 * @param bodyFont TODO: Documentation
 * @param headerBounds TODO: Documentation
 * @param headerImageFocused TODO: Documentation
 * @param headerImageScaled TODO: Documentation
 * @param linkColor TODO: Documentation
 * @param titleColor TODO: Documentation
 * @param titleFont TODO: Documentation
 * @param titleFontWeight TODO: Documentation
 * @param headerStretch TODO: Documentation
 * @param showAvatar TODO: Documentation
 * @param showDescription TODO: Documentation
 * @param showHeaderImage TODO: Documentation
 * @param showTitle TODO: Documentation
 */
@JsonClass(generateAdapter = true)
class BlogTheme constructor(
    @Json(name = "url")
    val url: String = "",
    avatarImage: String? = null,
    headerImage: String? = null,
    @Json(name = "header_full_width")
    val headerFullWidth: Int? = null,
    @Json(name = "header_full_height")
    val headerFullHeight: Int? = null,
    @Json(name = "header_focus_width")
    val headerFocusWidth: Int? = null,
    @Json(name = "header_focus_height")
    val headerFocusHeight: Int? = null,
    @Json(name = "avatar_shape")
    val avatarShape: String? = null,
    @Json(name = "background_color")
    @HexColorOctothorpe
    val backgroundColor: Color? = null,
    @Json(name = "body_font")
    val bodyFont: String? = null,
    @Json(name = "header_bounds")
    val headerBounds: String? = null,
    @Json(name = "header_image_focused")
    val headerImageFocused: String? = null,
    @Json(name = "header_image_scaled")
    val headerImageScaled: String? = null,
    @Json(name = "link_color")
    @HexColorOctothorpe
    val linkColor: Color? = null,
    @Json(name = "title_color")
    @HexColorOctothorpe
    val titleColor: Color? = null,
    @Json(name = "title_font")
    val titleFont: String? = null,
    @Json(name = "title_font_weight")
    val titleFontWeight: String? = null,
    @Json(name = "header_stretch")
    val headerStretch: Boolean? = null,
    @Json(name = "show_avatar")
    val showAvatar: Boolean? = null,
    @Json(name = "show_description")
    val showDescription: Boolean? = null,
    @Json(name = "show_header_image")
    val showHeaderImage: Boolean? = null,
    @Json(name = "show_title")
    val showTitle: Boolean? = null
) {
    companion object {

        /**
         * TODO: Documentation
         */
        const val DEFAULT_AVATAR: String =
            "https://secure.assets.tumblr.com/images/default_avatar/sphere_open_64.png"

        /**
         * TODO: Documentation
         */
        const val DEFAULT_HEADER: String =
            "https://secure.assets.tumblr.com/images/default_header/optica_pattern_08.png"

        /**
         * TODO: Documentation
         */
        const val DEFAULT_SHAPE: String = "Square"

        /**
         * TODO: Documentation
         */
        const val DEFAULT_BACKGROUND_COLOR: String = ""

        /**
         * TODO: Documentation
         */
        const val DEFAULT_BODY_FONT: String = ""

        /**
         * TODO: Documentation
         */
        const val DEFAULT_LINK_COLOR: String = ""
    }

    /**
     * TODO: Documentation
     */
    @Json(name = "avatar_image")
    var avatarImage: String? = null
        set(value) {
            field = value?.replace("http://", "https://")
        }

    /**
     * TODO: Documentation
     */
    @Json(name = "header_image")
    var headerImage: String? = null
        set(value) {
            field = value?.replace("http://", "https://")
        }

    init {
        this.avatarImage = avatarImage
        this.headerImage = headerImage
    }
}
