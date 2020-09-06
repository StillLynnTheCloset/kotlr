package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * RequestQueryParameters - A class to encode the various request query parameters that are included in [RequestLink] objects.
 *
 * @author highthunder
 * @since 2020-08-30
 * @version 1.0.0
 *
 * @param limit The number of results to return.
 * @param before The id of the result before which additional results should be returned.
 * @param after The id of the result after which additional results should be returned.
 * @param offset The offset of results to return.
 * @param npf Whether or not results should be returned in NPF.
 * @param pageNumber The page offset to return.
 * @param reblogInfo Whether or not reblog info should be returned.
 * @param notesInfo Whether or not note info should be returned.
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
)
