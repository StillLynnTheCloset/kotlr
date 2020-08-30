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
 * @param panoramaSize TODO: Documentation
 * @param caption A user supplied caption for the individual photo.
 * @param captionAbstract TODO: Documentation
 * @param altSizes Alternate photo sizes.
 * @param exif TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class Photo constructor(
    @Json(name = "original_size")
    val originalSize: PhotoSize? = null,
    @Json(name = "panorama_size")
    val panoramaSize: PhotoSize? = null,
    @Json(name = "caption")
    val caption: String? = null,
    @Json(name = "caption_abstract")
    val captionAbstract: String? = null,
    @Json(name = "alt_sizes")
    val altSizes: List<PhotoSize>? = null,
    @Json(name = "exif")
    val exif: ExifData? = null,
)
