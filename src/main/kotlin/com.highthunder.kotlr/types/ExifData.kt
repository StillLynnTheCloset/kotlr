package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ExifData - Extra data included in the Exif headers of a photo.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param camera The name/model/brand of the camera that took this picture.
 * @param cameraMake The brand of the camera that took this picture.
 * @param cameraModel The model of the camera that took this picture.
 * @param iso The ISO, or film sensitivity, that was used to take this picture.
 * @param aperture The size of the aperture used to take this picture.
 * @param exposure The length of the exposure used to take this picture.
 * @param exposureTime The length of the exposure used to take this picture.
 * @param focalLength The focal length used to take this picture.
 * @param focalLength35mmEquivalent The focal length used to take this picture (converted to be equivalent to a 35mm lens.
 * @param time The time that this picture was taken.
 * @param lens The length of the lens used to take this picture.
 * @param sensorWidthMM The size of the sensor used to take this picture.
 */
@JsonClass(generateAdapter = true)
public data class ExifData constructor(
    @Json(name = "Camera")
    val camera: String? = null,
    @Json(name = "CameraMake")
    val cameraMake: String? = null,
    @Json(name = "CameraModel")
    val cameraModel: String? = null,
    @Json(name = "ISO")
    val iso: Int? = null,
    @Json(name = "Aperture")
    val aperture: String? = null,
    @Json(name = "Exposure")
    val exposure: String? = null,
    @Json(name = "ExposureTime")
    val exposureTime: String? = null,
    @Json(name = "FocalLength")
    val focalLength: String? = null,
    @Json(name = "FocalLength35mmEquiv")
    val focalLength35mmEquivalent: String? = null,
    @Json(name = "Time")
    val time: Long? = null,
    @Json(name = "Lens")
    val lens: String? = null,
    @Json(name = "SensorWidthMM")
    val sensorWidthMM: String? = null,
)
