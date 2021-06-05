package com.highthunder.kotlr.postbody

import com.highthunder.kotlr.json.qualifier.CommaSeparatedString
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @param content An array of NPF content blocks to be used to make the post.
 * @param layout An array of NPF layout objects to be used to lay out the post content.
 * @param state The initial state of the new post, such as "published" or "queued".
 * @param publishOn The exact date and time (ISO 8601 format) to publish the post, if desired. This parameter will be ignored unless the state parameter is "queue".
 * @param date The exact date and time (ISO 8601 format) in the past to _backdate_ the post, if desired. This backdating does not apply to when the post shows up in the Dashboard.
 * @param tags A list of tags to associate with the post. Note: Any commas included in these strings will be interpreted by Tumblr as a delimiter.
 * @param sourceUrl A source attribution for the post content.
 * @param sendToFacebook Whether or not to share this via any connected Facebook account on post publish. Defaults to the blog's global setting.
 * @param sendToTwitter Whether or not to share this via any connected Twitter account on post publish. Defaults to the blog's global setting.
 * @param isPrivate Whether this should be a private answer, if this is an answer.
 * @param slug A custom URL slug to use in the post's permalink URL.
 *
 * @author highthunder
 * @since 2019-12-01
 */
@JsonClass(generateAdapter = true)
public data class CreateNewPostBody constructor(
    val content: List<PostContent>,
    val layout: List<BlockLayout>? = null,
    val state: Post.State? = null,
    @Json(name = "publish_on")
    val publishOn: String? = null,
    val date: String? = null,
    @CommaSeparatedString
    val tags: List<String>? = null,
    @Json(name = "source_url")
    val sourceUrl: String? = null,
    @Json(name = "send_to_twitter")
    val sendToTwitter: Boolean? = null,
    @Json(name = "send_to_facebook")
    val sendToFacebook: Boolean? = null,
    @Json(name = "is_private")
    val isPrivate: Boolean? = null,
    val slug: Boolean? = null,
) {
    init {
        tags?.forEach { tag ->
            tag
                .takeIf { it.contains(',') }
                ?.also { println("Tag `$it` contains comma(s). Tumblr will interpret this as a delimiter.") }
        }

        tags
            ?.flatMap { it.split(",") }
            ?.map(String::trim)
            ?.also { println("Tumblr will interpret tags as: $tags") }
    }
}
