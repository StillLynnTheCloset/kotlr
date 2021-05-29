package com.highthunder.kotlr.types.legacy

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.ReblogData
import com.highthunder.kotlr.types.RecommendationReason
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ChatPost - A legacy chat post.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param blogName The short name used to uniquely identify a blog.
 * @param id The post's unique ID.
 * @param blog A standard API-formatted "short blog info" object.
 * @param postUrl The location of the post.
 * @param timestamp The time of the post, in seconds since the epoch.
 * @param date The GMT date and time of the post, as a string.
 * @param format The post format: html, raw, or markdown.
 * @param reblogKey The key used to reblog this post.
 * @param tags Tags applied to the post.
 * @param isBookmarklet Indicates whether the post was created via the Tumblr bookmarklet.
 * @param isMobile Indicates whether the post was created via mobile/email publishing.
 * @param sourceUrl The URL for the source of the content (for quotes, reblogs, etc.).
 * @param sourceTitle The title of the source site.
 * @param isLiked Indicates if a user has already liked a post or not.
 * @param state Indicates the current state of the post.
 * @param anonymous Was this post made anonymously.
 * @param content The array of content that constitutes the body of a post in the Neue Post Format(NPF).
 * @param trail The previous Posts in the reblog trail. In order of oldest (the root Post) to the newest (the parent Post).
 * @param layout The layouts of the blocks in this post.
 * @param postAuthor The id of the author of the post.
 * @param shortUrl The short URL for this post.
 * @param summary A short description of this post.
 * @param isBlocksFormat Indicates whether or not this post is using the new block format(NPF).
 * @param likedTimestamp The timestamp of when this post was liked.
 * @param slug The slug.
 * @param rebloggedFromId The ID of the post that this post reblogged.
 * @param rebloggedFromName The name of the blog that this post reblogged.
 * @param noteCount The note count for this post.
 * @param recommendedSource The source of a recommended post.
 * @param recommendedColor The recommended color for styling this post.
 * @param postAuthorIsAdult Indicates whether or not the author of this post is an adult only blog.
 * @param isSubmission Indicates whether or not this post is a submission.
 * @param canLike Indicates whether or not the current user can like this post.
 * @param canReblog Indicates whether or not the current user can reblog this post.
 * @param canSendInMessage Indicates whether or not this post can be sent in a message.
 * @param canReply Indicates whether or not the current user can reply to this post.
 * @param displayAvatar Indicates whether or not the poster's avatar should be shown with this post.
 * @param followed Indicates whether or not the current user follows the author of this post.
 * @param reblogData The reblog content of this post.
 * @param rebloggedFromId The ID of the post that this post reblogged.
 * @param rebloggedFromUrl The URL of the post that this post reblogged.
 * @param rebloggedFromName The name of the blog that this post reblogged.
 * @param rebloggedFromTitle The title of the blog that made the post that this post reblogged.
 * @param rebloggedFromUuid The blog uuid of the post that this post reblogged.
 * @param rebloggedFromCanMessage Whether or not you can message the blog that made the post that this post reblogged.
 * @param rebloggedFromFollowing Whether or not you are following the blog that made the post that this post reblogged.
 * @param rebloggedRootId The ID of the root post that this post reblogged.
 * @param rebloggedRootUrl The URL of the root post that this post reblogged.
 * @param rebloggedRootName The name of the blog that this post reblogged.
 * @param rebloggedRootTitle The title of the blog that made the root post that this post reblogged.
 * @param rebloggedRootUuid The blog uuid of the root post that this post reblogged.
 * @param rebloggedRootCanMessage Whether or not you can message the blog that made the root post that this post reblogged.
 * @param rebloggedRootFollowing Whether or not you are following the blog that made the root post that this post reblogged.
 * @param notes A list of all of the notes objects attached to this post.
 * @param publishTime Returned on queued posts, the time that this post is scheduled to be posted.
 * @param queueState The current queue state of this post.
 * @param shouldOpenInLegacy TODO: Documentation
 * @param muted TODO: Documentation
 * @param objectType TODO: Documentation
 * @param blogUUID The UUID of the blog that made this post.
 * @param parentPostId The id of the post that this post was a response to.
 * @param parentBlogUUID The UUID of the blog that made the parent post.
 * @param isBlurredImages Are the images in this post blurred (a NSFW thing I guess?)
 * @param recommendationReason TODO: Documentation
 * @param dismissal TODO: Documentation
 * @param serveId TODO: Documentation
 * @param genesisPostId TODO: Documentation
 * @param isPinned TODO: Documentation
 *
 * Chat Post
 * @param type The type of this post. This is provided as a constructor parameter to make Moshi happy. If you override this, you'll get bad data.
 * @param title The optional title of the post.
 * @param body The full chat body.
 * @param dialogue List of dialog objects describing the chat in detail.
 */
@JsonClass(generateAdapter = true)
public data class ChatPost constructor(
    @Json(name = "blog_name")
    override val blogName: String? = null,
    override val id: Long? = null,
    @Json(name = "id_string")
    override val idString: String? = null,
    override val blog: Blog? = null,
    @Json(name = "post_url")
    override val postUrl: String? = null,
    override val timestamp: Long? = null,
    override val date: String? = null,
    override val format: Post.PostFormat? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    override val tags: List<String>? = null,
    @Json(name = "bookmarklet")
    override val isBookmarklet: Boolean? = null,
    @Json(name = "mobile")
    override val isMobile: Boolean? = null,
    @Json(name = "source_url")
    override val sourceUrl: String? = null,
    @Json(name = "source_title")
    override val sourceTitle: String? = null,
    @Json(name = "liked")
    override val isLiked: Boolean? = null,
    override val state: Post.State? = null,
    @Json(name = "is_anonymous")
    override val anonymous: Boolean? = null,
    override val content: List<PostContent>? = null,
    override val trail: List<Trail>? = null,
    override val layout: List<BlockLayout>? = null,
    @Json(name = "post_author")
    override val postAuthor: String? = null,
    @Json(name = "short_url")
    override val shortUrl: String? = null,
    override val summary: String? = null,
    @Json(name = "is_blocks_post_format")
    override val isBlocksFormat: Boolean? = null,
    @Json(name = "liked_timestamp")
    override val likedTimestamp: Long? = null,
    override val slug: String? = null,
    @Json(name = "note_count")
    override val noteCount: Long? = null,
    @Json(name = "recommended_source")
    override val recommendedSource: String? = null,
    @Json(name = "recommended_color")
    override val recommendedColor: String? = null,
    @Json(name = "post_author_is_adult")
    override val postAuthorIsAdult: Boolean? = null,
    @Json(name = "is_submission")
    override val isSubmission: Boolean? = null,
    @Json(name = "can_like")
    override val canLike: Boolean? = null,
    @Json(name = "can_reblog")
    override val canReblog: Boolean? = null,
    @Json(name = "can_send_in_message")
    override val canSendInMessage: Boolean? = null,
    @Json(name = "can_reply")
    override val canReply: Boolean? = null,
    @Json(name = "display_avatar")
    override val displayAvatar: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "reblog")
    override val reblogData: ReblogData? = null,
    @Json(name = "reblogged_from_id")
    override val rebloggedFromId: Long? = null,
    @Json(name = "reblogged_from_url")
    override val rebloggedFromUrl: String? = null,
    @Json(name = "reblogged_from_name")
    override val rebloggedFromName: String? = null,
    @Json(name = "reblogged_from_title")
    override val rebloggedFromTitle: String? = null,
    @Json(name = "reblogged_from_uuid")
    override val rebloggedFromUuid: String? = null,
    @Json(name = "reblogged_from_can_message")
    override val rebloggedFromCanMessage: Boolean? = null,
    @Json(name = "reblogged_from_following")
    override val rebloggedFromFollowing: Boolean? = null,
    @Json(name = "reblogged_root_id")
    override val rebloggedRootId: Long? = null,
    @Json(name = "reblogged_root_url")
    override val rebloggedRootUrl: String? = null,
    @Json(name = "reblogged_root_name")
    override val rebloggedRootName: String? = null,
    @Json(name = "reblogged_root_title")
    override val rebloggedRootTitle: String? = null,
    @Json(name = "reblogged_root_uuid")
    override val rebloggedRootUuid: String? = null,
    @Json(name = "reblogged_root_can_message")
    override val rebloggedRootCanMessage: Boolean? = null,
    @Json(name = "reblogged_root_following")
    override val rebloggedRootFollowing: Boolean? = null,
    override val notes: List<NoteData>? = null,
    @Json(name = "scheduled_publish_time")
    override val publishTime: Long? = null,
    @Json(name = "queued_state")
    override val queueState: Post.QueueState? = null,
    @Json(name = "should_open_in_legacy")
    override val shouldOpenInLegacy: Boolean? = null,
    override val muted: Boolean? = null,
    @Json(name = "object_type")
    override val objectType: Post.ObjectType? = null,
    @Json(name = "tumblelog_uuid")
    override val blogUUID: String? = null,
    @Json(name = "parent_post_id")
    override val parentPostId: Long? = null,
    @Json(name = "parent_tumblelog_uuid")
    override val parentBlogUUID: String? = null,
    @Json(name = "is_blurred_images")
    override val isBlurredImages: Boolean? = null,
    @Json(name = "recommendation_reason")
    override val recommendationReason: RecommendationReason? = null,
    @Json(name = "dismissal")
    override val dismissal: String? = null,
    @Json(name = "serve_id")
    override val serveId: String? = null,
    @Json(name = "genesis_post_id")
    override val genesisPostId: String? = null,
    @Json(name = "is_pinned")
    override val isPinned: Boolean? = null,
    val title: String? = null,
    val body: String? = null,
    val dialogue: List<Dialogue>? = null,
    @Json(name = "type")
    override val type: Post.Type = Post.Type.Chat,
) : Post
