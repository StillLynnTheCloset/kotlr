package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class PollAnswer constructor(
    @Json(name = "answer_text")
    val answerText: String? = null,
    @Json(name = "client_id")
    val clientId: String? = null,
)
