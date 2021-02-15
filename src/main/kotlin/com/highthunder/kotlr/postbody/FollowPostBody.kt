package com.highthunder.kotlr.postbody

import com.squareup.moshi.JsonClass

/**
 * FollowPostBody - The body of a post payload to follow or unfollow a blog.
 * @param url The url of the blog.
 * @param email The the email of the blog if the user has enabled "allow people to find this blog by email".
 */
@JsonClass(generateAdapter = true)
public data class FollowPostBody constructor(
    val url: String? = null,
    val email: String? = null,
) {
    init {
        check((url == null) xor (email == null)) { "Only one of url or email can be provided" }
    }
}
