package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * SubmissionTerms - An object that is included in some [Blog]s. Defines any restrictions and guidelines for the blog's "Submit" page.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 *
 * @param tags A set of tags that submitters may choose from.
 * @param title The title of the "Submit" page.
 * @param guidelines A user generated paragraph providing any additional text.
 * @param acceptedTypes The types of post that are allowed to be submitted.
 */
@JsonClass(generateAdapter = true)
public data class SubmissionTerms constructor(
    val tags: List<String>? = null,
    val title: String? = null,
    val guidelines: String? = null,
    @Json(name = "accepted_types")
    val acceptedTypes: List<Post.Type>? = null,
)
