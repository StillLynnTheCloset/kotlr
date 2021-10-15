package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RequestQueryParameters - A class to encode the various request query parameters that are included in [RequestLink] objects.
 *
 * TODO: Break this up to be unique per response.
 *
 * @author highthunder
 * @since 2020-08-30
 *
 * @param limit The number of results to return.
 * @param before The id of the result before which additional results should be returned.
 * @param after The id of the result after which additional results should be returned.
 * @param offset The offset of results to return.
 * @param npf Whether results should be returned in NPF.
 * @param pageNumber The page offset to return.
 * @param reblogInfo Whether reblog info should be returned.
 * @param notesInfo Whether note info should be returned.
 * @param mode The request mode for post notes.
 * @param id The post Id that was requested.
 * @param beforeTimestamp The timestamp that the request occurred before.
 * @param beforeId The post Id that was before the requested post(s).
 * @param types The types of notifications requested.
 * @param tumblelog The name of the blog requested.
 */
@JsonClass(generateAdapter = true)
public data class RequestQueryParameters constructor(
    val limit: String? = null,
    val before: String? = null,
    val after: String? = null,
    val offset: String? = null,
    val npf: String? = null,
    @Json(name = "page_number")
    val pageNumber: String? = null,
    @Json(name = "reblog_info")
    val reblogInfo: String? = null,
    @Json(name = "notes_info")
    val notesInfo: String? = null,
    val mode: String? = null,
    val id: String? = null,
    @Json(name = "before_timestamp")
    val beforeTimestamp: String? = null,
    @Json(name = "before_id")
    val beforeId: String? = null,
    val types: String? = null,
    val tumblelog: String? = null,
)
