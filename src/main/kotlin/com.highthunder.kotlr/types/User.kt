package com.highthunder.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * User - A Tumblr user/account.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param blogs The blogs to which the user can post.
 * @param name The user's tumblr short name.
 * @param following The number of blogs the user is following.
 * @param url The URL of the user's primary blog.
 * @param updated The time of the user's most recent post, in seconds since the epoch.
 * @param likes The total count of the user's likes.
 * @param defaultPostFormat The default posting format - html, markdown, or raw.
 */
@JsonClass(generateAdapter = true)
data class User(
        @Json(name = "blogs")
        var blogs: List<Blog>? = null,
        @Json(name = "name")
        var name: String? = null,
        @Json(name = "following")
        var following: Int? = null,
        @Json(name = "url")
        var url: String? = null,
        @Json(name = "updated")
        var updated: Long? = null,
        @Json(name = "likes")
        var likes: Int? = null,
        @Json(name = "default_post_format")
        var defaultPostFormat: String? = null // TODO: Make this an enum
)
