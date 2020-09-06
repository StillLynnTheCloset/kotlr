package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Media - Many content blocks and their components include media objects which link directly
 * to media assets.
 *
 * Media objects are used for image blocks, all kinds of posters (GIF, video, etc), native audio,
 * native video, and some trusted third-party content. All media objects returned from the API
 * should contain type and url, and any video and image media objects should always contain a
 * width and height.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param type The MIME type of this media, or the closest fit.
 * @param url The location of the resource backing this piece of media.
 * @param width The width of this piece of media, only applies to photo and video media.
 * @param height The height of this piece of media, only applies to photo and video media.
 * @param originalDimensionsMissing Indicates that the dimensions of this media are unknown so [width] and [height] contain default values.
 * @param hd Indicates if Tumblr considers this media to be in High Definition.
 * @param poster Usually a still image to represent this media while loading.
 * @param mediaKey A key to identify this media object.
 * @param cropped Indicates if this media has been cropped.
 * @param hasOriginalDimensions Indicates if this media includes a version with the original dimensions.
 * @param colors A colors object containing the main colors in this media.
 */
@JsonClass(generateAdapter = true)
public data class Media constructor(
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "width")
    val width: Int? = null,
    @Json(name = "height")
    val height: Int? = null,
    @Json(name = "original_dimensions_missing")
    val originalDimensionsMissing: Boolean? = null,
    @Json(name = "hd")
    val hd: Boolean? = null,
    @Json(name = "poster")
    val poster: Media? = null,
    @Json(name = "media_key")
    val mediaKey: String? = null,
    @Json(name = "cropped")
    val cropped: Boolean? = null,
    @Json(name = "has_original_dimensions")
    val hasOriginalDimensions: Boolean? = null,
    @Json(name = "colors")
    val colors: Colors? = null,
)
