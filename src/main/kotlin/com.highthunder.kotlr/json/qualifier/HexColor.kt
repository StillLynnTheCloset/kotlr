package com.highthunder.kotlr.json.qualifier

import com.highthunder.kotlr.types.Color
import com.squareup.moshi.JsonQualifier

/**
 * HexColor - An internal JSON annotation to tell Moshi that the annotated property is a [Color] that should be
 * serialized as a string (without octothorpe).
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
internal annotation class HexColor
