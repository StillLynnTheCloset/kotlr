package com.highthunder.kotlr.json.qualifier

import com.highthunder.kotlr.types.Color
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * HexColorJsonAdapter - An adapter to (de-)serialize properties annotated with [HexColor].
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
internal class HexColorJsonAdapter {
    @ToJson
    fun toJson(@HexColor rgb: Color): String = rgb.asString()

    @FromJson
    @HexColor
    fun fromJson(rgb: String): Color = Color(rgb)
}
