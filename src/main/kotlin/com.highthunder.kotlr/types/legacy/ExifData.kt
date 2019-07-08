package com.highthunder.kotlr.types.legacy

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ExifData - TODO: Documentation
 *
 * @author highthunder
 * @since 11/3/18
 * @version 1.0.0
 *
 * @param camera TODO: Documentation
 * @param iso TODO: Documentation
 * @param aperture TODO: Documentation
 * @param exposure TODO: Documentation
 * @param focalLength TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class ExifData constructor(
    @Json(name = "Camera")
    var camera: String? = null,
    @Json(name = "ISO")
    var iso: Int? = null,
    @Json(name = "Aperture")
    var aperture: String? = null,
    @Json(name = "Exposure")
    var exposure: String? = null,
    @Json(name = "FocalLength")
    var focalLength: String? = null
)
