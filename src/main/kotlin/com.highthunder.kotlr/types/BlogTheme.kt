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
    var url: String = "",
    avatarImage: String? = null,
    headerImage: String? = null,
    @Json(name = "header_full_width")
    var headerFullWidth: Int? = null,
    @Json(name = "header_full_height")
    var headerFullHeight: Int? = null,
    @Json(name = "header_focus_width")
    var headerFocusWidth: Int? = null,
    @Json(name = "header_focus_height")
    var headerFocusHeight: Int? = null,
    @Json(name = "avatar_shape")
    var avatarShape: String? = null,
    @Json(name = "background_color")
    @HexColorOctothorpe
    var backgroundColor: Color? = null,
    @Json(name = "body_font")
    var bodyFont: String? = null,
    @Json(name = "header_bounds")
    var headerBounds: String? = null,
    @Json(name = "header_image_focused")
    var headerImageFocused: String? = null,
    @Json(name = "header_image_scaled")
    var headerImageScaled: String? = null,
    @Json(name = "link_color")
    @HexColorOctothorpe
    var linkColor: Color? = null,
    @Json(name = "title_color")
    @HexColorOctothorpe
    var titleColor: Color? = null,
    @Json(name = "title_font")
    var titleFont: String? = null,
    @Json(name = "title_font_weight")
    var titleFontWeight: String? = null,
    @Json(name = "header_stretch")
    var headerStretch: Boolean? = null,
    @Json(name = "show_avatar")
    var showAvatar: Boolean? = null,
    @Json(name = "show_description")
    var showDescription: Boolean? = null,
    @Json(name = "show_header_image")
    var showHeaderImage: Boolean? = null,
    @Json(name = "show_title")
    var showTitle: Boolean? = null
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
