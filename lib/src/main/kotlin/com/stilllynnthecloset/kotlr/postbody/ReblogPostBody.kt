package com.stilllynnthecloset.kotlr.postbody

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.qualifier.CommaSeparatedString
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.content.BlockLayout
import com.stilllynnthecloset.kotlr.types.content.PostContent

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
 * @param parentTumblelogUuid The unique public identifier of the Tumblelog that's being reblogged from.
 * @param parentPostId The unique public post ID being reblogged.
 * @param reblogKey The unique per-post hash validating that this is a genuine reblog action.
 * @param hideTrail Whether or not to hide the reblog trail with this new post. Defaults to false.
 * @param excludeTrailItems Instead of [hideTrail], use this to specify an array of specific reblog trail item indexes to _exclude_ from your reblog.
 *
 * @author highthunder
 * @since 2019-12-01
 */
@JsonClass(generateAdapter = true)
public data class ReblogPostBody constructor(
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
    @Json(name = "parent_tumblelog_uuid")
    val parentTumblelogUuid: String,
    @Json(name = "parent_post_id")
    val parentPostId: Long,
    @Json(name = "reblog_key")
    val reblogKey: String,
    @Json(name = "hide_trail")
    val hideTrail: Boolean? = null,
    @Json(name = "exclude_trail_items")
    val excludeTrailItems: List<Int>? = null,
) {
    init {
        tags?.forEach { tag ->
            tag.takeIf { it.contains(',') }
                ?.also { println("Tag `$it` contains comma(s). Tumblr will interpret this as a delimiter.") }
        }
    }

    public constructor(
        postToReblog: Post,
        content: List<PostContent>,
        layout: List<BlockLayout>? = null,
        state: Post.State? = null,
        publishOn: String? = null,
        tags: List<String>? = null,
        sourceUrl: String? = null,
        sendToTwitter: Boolean? = null,
        sendToFacebook: Boolean? = null,
        hideTrail: Boolean? = null,
        excludeTrailItems: List<Int>? = null,
    ) : this(
        content = content,
        layout = layout,
        state = state,
        publishOn = publishOn,
        tags = tags,
        sourceUrl = sourceUrl,
        sendToTwitter = sendToTwitter,
        sendToFacebook = sendToFacebook,
        parentTumblelogUuid = postToReblog.blogUUID ?: postToReblog.blog?.uuid
            ?: throw IllegalArgumentException("Post must have a parentBlogId"),
        parentPostId = postToReblog.id ?: throw IllegalArgumentException("Post must have an id"),
        reblogKey = postToReblog.reblogKey ?: throw IllegalArgumentException("Post must have a reblog key"),
        hideTrail = hideTrail,
        excludeTrailItems = excludeTrailItems,
    )
}
