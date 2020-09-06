package com.highthunder.kotlr.response

import com.squareup.moshi.JsonClass

/**
 * TumblrError - A specific error message from the Tumblr API.
 *
 * The error codes here are the HTTP statuses that'll be returned in error states, the error subcodes are the specific
 * subcodes also returned in some situations. The response should have an errors array at the top level alongside meta,
 * containing what error(s) occurred.
 *
 * 400 Bad Request when the request has not provided the required data.
 * 400.8001 when an NPF JSON parameter is invalid or a bad format.
 * 400.8002 when the reblog parent post and/or blog is invalid or cannot be found.
 * 400.8005 when the uploaded media is an invalid format we cannot accept.
 * 400.8016 when there is something invalid about the format of the answer content or layout.
 * 401 Unauthorized when the requester is an unauthorized client.
 * 403 Forbidden when the requester is not allowed to reblog the parent post they specified.
 * 403.8004 when the requesting user cannot upload more media today.
 * 403.8008 when trying to upload a video in reblog content, which is not allowed.
 * 403.8010 when there is a video upload still transcoding, so you can't upload another video yet.
 * 403.8011 when the requesting user cannot upload more videos today.
 * 403.8022 when the blog's queue limit has been reached.
 * 403.8023 when the blog's daily posting limit has been reached.
 * 404 Not Found when the request is not HTTPS.
 * 404 Not Found when the Tumblelog identifier in the path does not resolve to an existing blog.
 * 404 Not Found when the given post ID for editing/fetching doesn't exist.
 * 500 Internal Server Error when something has gone very wrong.
 * 500.8006 when there was an unknown upload error (not video related).
 * 500.8009 when there was an unknown upload error (video related).
 * 503 Service Unavailable when all posting, or posting via the API, is disabled.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param title An explanation of the error that occurred.
 * @param code An error code that provides more detail than the HTTP response code.
 * @param detail A "user friendly" error message. AKA "Oops something went wrong".
 */
@JsonClass(generateAdapter = true)
public data class TumblrError constructor(
    val title: String? = null,
    val code: Int? = null,
    val detail: String? = null,
)
