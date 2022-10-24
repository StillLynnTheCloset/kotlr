package com.stilllynnthecloset.kotlr.postbody

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author StillLynnTheCloset
 * @since 2021-06-04
 *
 * @param postId The queued post to move
 * @param insertAfter The post to move it after in the queue, or 0 to make it first.
 */
@JsonClass(generateAdapter = true)
public data class ReorderQueuePostBody constructor(
    @Json(name = "post_id")
    val postId: Long,
    @Json(name = "insert_after")
    val insertAfter: Long,
)
