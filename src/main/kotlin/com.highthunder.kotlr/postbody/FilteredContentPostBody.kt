package com.highthunder.kotlr.postbody

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @param filteredContent A new content string to filter out.
 *
 * @author highthunder
 * @since 2021-05-30
 */
@JsonClass(generateAdapter = true)
public data class FilteredContentPostBody constructor(
    @Json(name = "filtered_content")
    val filteredContent: List<String>
) {
    public constructor(
        filteredContent: String
    ) : this(
        filteredContent = listOf(filteredContent),
    )

    public constructor(
        filteredContent: Iterable<String>
    ) : this(
        filteredContent = filteredContent.toList(),
    )
}
