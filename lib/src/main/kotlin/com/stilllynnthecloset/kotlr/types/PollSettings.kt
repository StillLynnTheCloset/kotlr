package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
public data class PollSettings constructor(
    @Json(name = "multiple_choice")
    val multipleChoice: Boolean? = null,
    @Json(name = "close_status")
    val closeStatus: String? = null,
    @Json(name = "expire_after")
    val expireAfter: Long? = null,
    @Json(name = "source")
    val source: String? = null,
)
