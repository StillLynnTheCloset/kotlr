package com.highthunder.kotlr.types

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
 */
@JsonClass(generateAdapter = true)
class BlogTheme(
    @Json(name = "url")
    var url: String? = null,
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
    var backgroundColor: String? = null,
    @Json(name = "body_font")
    var bodyFont: String? = null,
    @Json(name = "header_bounds")
    var headerBounds: String? = null,
    @Json(name = "header_image_focused")
    var headerImageFocused: String? = null,
    @Json(name = "header_image_scaled")
    var headerImageScaled: String? = null,
    @Json(name = "link_color")
    var linkColor: String? = null,
    @Json(name = "title_color")
    var titleColor: String? = null,
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
        const val DEFAULT_AVATAR = "https://secure.assets.tumblr.com/images/default_avatar/sphere_open_64.png"
        const val DEFAULT_HEADER = "https://secure.assets.tumblr.com/images/default_header/optica_pattern_08.png"
        const val DEFAULT_SHAPE = "Square"
        const val DEFAULT_BACKGROUND_COLOR = ""
        const val DEFAULT_BODY_FONT = ""
        const val DEFAULT_LINK_COLOR = ""
    }

    @Json(name = "avatar_image")
    var avatarImage: String? = null
        set(value) {
            if (value != null) {
                if (!value.contains("http")) {
                    field = "https://api.tumblr.com/v2$value"
                }
                field = value.replace("http://", "https://")
            } else {
                field = null
            }
        }
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
