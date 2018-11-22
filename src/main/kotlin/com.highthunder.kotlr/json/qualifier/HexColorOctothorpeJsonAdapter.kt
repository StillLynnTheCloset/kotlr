package com.highthunder.kotlr.json.qualifier

import com.highthunder.kotlr.types.Color
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * HexColorOctothorpeJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
internal class HexColorOctothorpeJsonAdapter {

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(@HexColorOctothorpe rgb: Color): String = rgb.asOctothorpeString()

    /**
     * TODO: Documentation
     */
    @FromJson
    @HexColorOctothorpe
    fun fromJson(rgb: String): Color = Color(rgb)

}
