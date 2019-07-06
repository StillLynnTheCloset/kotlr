package com.highthunder.kotlr.types.legacy

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * PhotoSize - A legacy object containing a photo url and it's dimensions.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param width The width of the photo, in pixels.
 * @param height The height of the photo, in pixels.
 * @param url The location of the photo file (either a JPG, GIF, or PNG).
 */
@JsonClass(generateAdapter = true)
data class PhotoSize(
    @Json(name = "width")
    var width: Int? = null,
    @Json(name = "height")
    var height: Int? = null,
    @Json(name = "url")
    var url: String? = null
)
