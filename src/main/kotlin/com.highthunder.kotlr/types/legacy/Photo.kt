package com.highthunder.kotlr.types.legacy

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Photo - A legacy class containing multiple sizes of a picture along with a caption.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param originalSize The photo at its original size.
 * @param caption A user supplied caption for the individual photo.
 * @param altSizes Alternate photo sizes.
 * TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class Photo(
    @Json(name = "original_size")
    var originalSize: PhotoSize? = null,
    @Json(name = "panorama_size")
    var panoramaSize: PhotoSize? = null,
    @Json(name = "caption")
    var caption: String? = null,
    @Json(name = "caption_abstract")
    var captionAbstract: String? = null,
    @Json(name = "alt_sizes")
    var altSizes: List<PhotoSize>? = null,
    @Json(name = "exif")
    var exif: ExifData? = null
)
