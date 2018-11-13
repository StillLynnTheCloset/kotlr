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
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The MIME type of this media, or the closest fit.
 * @param url The location of the resource backing this piece of media.
 * @param width The width of this piece of media, only applies to photo and video media.
 * @param height The height of this piece of media, only applies to photo and video media.
 * @param originalDimensionsMissing Indicates that the dimensions of this media are unknown so [width] and [height] contain default values.
 * @param hd Indicates if Tumblr considers this media to be in High Definition.
 * @param poster Usually a still image to represent this media while loading.
 */
@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "url")
    var url: String? = null,
    @Json(name = "width")
    var width: Int? = null,
    @Json(name = "height")
    var height: Int? = null,
    @Json(name = "original_dimensions_missing")
    var originalDimensionsMissing: Boolean? = null,
    @Json(name = "hd")
    var hd: Boolean? = null,
    @Json(name = "poster")
    var poster: Media? = null
)
