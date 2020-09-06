package com.highthunder.kotlr.json.qualifier

import com.highthunder.kotlr.types.Color
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * HexColorOctothorpeJsonAdapter - An adapter to (de-)serialize properties annotated with [HexColorOctothorpe].
 *
 * @author highthunder
 * @since 2018-11-04
 */
internal class HexColorOctothorpeJsonAdapter {
    @ToJson
    fun toJson(@HexColorOctothorpe rgb: Color): String = rgb.asOctothorpeString()

    @FromJson
    @HexColorOctothorpe
    fun fromJson(rgb: String): Color = Color(rgb)
}
