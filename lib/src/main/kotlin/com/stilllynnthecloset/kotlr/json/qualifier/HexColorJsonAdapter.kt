package com.stilllynnthecloset.kotlr.json.qualifier

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.types.Color

/**
 * HexColorJsonAdapter - An adapter to (de-)serialize properties annotated with [HexColor].
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 */
internal class HexColorJsonAdapter {
    @ToJson
    fun toJson(@HexColor rgb: Color): String = rgb.asString()

    @FromJson
    @HexColor
    fun fromJson(rgb: String): Color = Color(rgb)
}
