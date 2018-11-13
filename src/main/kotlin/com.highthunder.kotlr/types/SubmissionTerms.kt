package com.highthunder.kotlr.types

import com.squareup.moshi.JsonClass

/**
 * SubmissionTerms - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class SubmissionTerms(
    var tags: List<String>? = null,
    var title: String? = null,
    var guidelines: String? = null,
    var accepted_types: List<String>? = null
)