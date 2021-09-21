package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.qualifier.HexColorOctothorpe

/**
 * BlogTheme - A blog's user customizable theme.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param headerFullWidth TODO: Documentation
 * @param headerFullHeight TODO: Documentation
 * @param headerFocusWidth TODO: Documentation
 * @param headerFocusHeight TODO: Documentation
 * @param headerImage The URL of the blog's original, full header image. Note that this may be a default Tumblr header image.
 * @param avatarShape "circle" or "square", this is the shape of the mask over the user's avatar.
 * @param backgroundColor The intended hex color used for the blog's background color.
 * @param bodyFont The font that the blog has selected as their "body" font.
 * @param headerBounds If the blog's header should be cropped, this is a comma-separated list of top/right/bottom/left coordinates to use.
 * @param headerImageFocused If the blog cropped/repositioned their header image, this will be that version, which should be preferred over the original.
 * @param headerImagePoster The URL of a single-frame "poster" version of the blog's header image, if it's an animated image. Note that this may be an empty string if no poster could be made or is not needed.
 * @param headerImageScaled If the blog only scaled their header image, this will be that scaled version. Note that this may be a default Tumblr header image in the case that they scaled and repositioned it, in which case, use the _focused version.
 * @param linkColor The intended hex color of any links in the blog's description.
 * @param titleColor The intended hex color of the blog's title.
 * @param titleFont The intended font to use when displaying the blog's title.
 * @param titleFontWeight The intended font weight to use when displaying the blog's title.
 * @param headerStretch Whether or not the blog's header is meant to be stretched to aspect-fill any given space where it's used.
 * @param showAvatar Whether or not the blog's avatar should be displayed, even if it's given in the API payload.
 * @param showDescription Whether or not the blog's description should be displayed, even if it's given in the API payload.
 * @param showHeaderImage Whether or not the blog's header image should be displayed, even if it's given in the API payload.
 * @param showTitle Whether or not the blog's title should be displayed, even if it's given in the API payload.
 */
@JsonClass(generateAdapter = true)
public data class BlogTheme constructor(
    @Json(name = "header_image")
    val headerImage: String? = null,
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
    @Json(name = "header_image_poster")
    val headerImagePoster: String? = null,
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
    val showTitle: Boolean? = null,
)
