package com.stilllynnthecloset.kotlr.json.qualifier

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.types.Color

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
