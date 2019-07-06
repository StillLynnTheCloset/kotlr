package com.highthunder.kotlr.json.qualifier

import com.highthunder.kotlr.types.Color
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * HexColorJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
internal class HexColorJsonAdapter {

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(@HexColor rgb: Color): String = rgb.asString()

    /**
     * TODO: Documentation
     */
    @FromJson
    @HexColor
    fun fromJson(rgb: String): Color = Color(rgb)
}
