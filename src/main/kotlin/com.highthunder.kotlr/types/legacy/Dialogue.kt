package com.highthunder.kotlr.types.legacy

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Dialogue - A legacy dialogue object, part of legacy chat posts.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param name Name of the speaker.
 * @param label Label of the speaker.
 * @param phrase The text being spoken.
 */
@JsonClass(generateAdapter = true)
public data class Dialogue constructor(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "label")
    val label: String? = null,
    @Json(name = "phrase")
    val phrase: String? = null,
)
