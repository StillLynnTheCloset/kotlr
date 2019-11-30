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
 * @param totalFollowing The number of blogs the user is following.
 * @param isUserFollowed Does the current signed in user follow this user's main blog.
 * @param url The URL of the user's primary blog.
 * @param updated The time of the user's most recent post, in seconds since the epoch.
 * @param likes The total count of the user's likes.
 * @param defaultPostFormat The user's default posting format - html, markdown, or raw.
 */
@JsonClass(generateAdapter = false)
data class User constructor(
    @Json(name = "blogs")
    val blogs: List<Blog>? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "following")
    val totalFollowing: Int? = null,
    @Json(name = "following")
    val isUserFollowed: Boolean? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "updated")
    val updated: Long? = null,
    @Json(name = "likes")
    val likes: Int? = null,
    @Json(name = "default_post_format")
    val defaultPostFormat: Post.PostFormat? = null
)
