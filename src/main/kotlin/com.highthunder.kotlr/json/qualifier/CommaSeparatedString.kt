package com.highthunder.kotlr.json.qualifier

import com.squareup.moshi.JsonQualifier

/**
 * CommaSeparated - An internal JSON annotation to tell Moshi that the annotated property is a list of strings that
 * should be serialized as a comma separated string.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
internal annotation class CommaSeparatedString
