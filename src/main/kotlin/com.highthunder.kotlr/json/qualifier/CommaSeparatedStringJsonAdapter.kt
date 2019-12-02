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
internal class CommaSeparatedStringJsonAdapter {
    @ToJson
    fun toJson(@CommaSeparatedString stringList: List<String>): String = stringList.joinToString()

    @FromJson
    @CommaSeparatedString
    fun fromJson(commaSeparatedString: String): List<String> = commaSeparatedString.split(",")
}
