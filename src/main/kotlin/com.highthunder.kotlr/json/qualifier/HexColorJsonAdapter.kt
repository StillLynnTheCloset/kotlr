package com.highthunder.kotlr.json.qualifier

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * HexColorJsonAdapter - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class HexColorJsonAdapter {

    /**
     * TODO: Documentation
     */
    @ToJson
    fun toJson(@HexColor rgb: Int): String = String.format("%06x", rgb)

    /**
     * TODO: Documentation
     */
    @FromJson
    @HexColor
    fun fromJson(rgb: String): Int = Integer.parseInt(rgb, 16)

}
