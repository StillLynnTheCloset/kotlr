package com.highthunder.kotlr.json.qualifier

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * HexColorOctothorpeJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class HexColorOctothorpeJsonAdapter {

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(@HexColorOctothorpe rgb: Int): String = String.format("#%06x", rgb)

    /**
     * TODO: Documentation
     */
    @FromJson
    @HexColorOctothorpe
    fun fromJson(rgb: String): Int = Integer.parseInt(rgb.substring(1), 16)

}
