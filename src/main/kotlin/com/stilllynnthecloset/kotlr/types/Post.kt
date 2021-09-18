package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.types.content.AskBlockLayout
import com.stilllynnthecloset.kotlr.types.content.AudioContent
import com.stilllynnthecloset.kotlr.types.content.BlockLayout
import com.stilllynnthecloset.kotlr.types.content.ImageContent
import com.stilllynnthecloset.kotlr.types.content.LinkContent
import com.stilllynnthecloset.kotlr.types.content.PostContent
import com.stilllynnthecloset.kotlr.types.content.TextContent
import com.stilllynnthecloset.kotlr.types.content.VideoContent

/**
 * Post - A block post, aka. NPF post, which is the only type of post now supported by Kotlr
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param blogName The short name used to uniquely identify a blog.
 * @param id The post's unique ID.
 * @param idString The post's ID as a string, this is only here for client libraries that don't support 64-bit integers. So it's only included here for completeness.
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
 * @param genesisPostId The "genesis" ID for a post is only available and different than its current ID if that post had been
 *                      drafted, queued, or scheduled, and is now published. In which case, the "genesis" ID will be the original
 *                      post ID generated when drafting, queuing, or scheduling that post. You cannot use this ID to look up the post
 *                      after it has been published, but it can be useful for tracking a post from its pre- to post-published state.
 * @param isPinned Whether or not this post is pinned to the current blog.
 * @param type The type of this post. This is provided as a constructor parameter to make Moshi happy. If you override this, you'll get bad data.
 * @param askingName The name of the blog that sent this ask (if this is an ask post.)
 * @param askingUrl The url of the blog that sent this ask (if this is an ask post.)
 * @param askingAvatar The avatar of the blog that sent this ask (if this is an ask post.)
 * @param originalType The original post type of this post before it was converted to a BlockPost.
 * @param filteredReason TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class Post constructor(
    @Json(name = "blog_name")
    val blogName: String? = null,
    @Json(name = "id")
    val id: Long? = null,
    @Json(name = "id_string")
    val idString: String? = null,
    @Json(name = "blog")
    val blog: Blog? = null,
    @Json(name = "post_url")
    val postUrl: String? = null,
    @Json(name = "timestamp")
    val timestamp: Long? = null,
    @Json(name = "date")
    val date: String? = null,
    @Json(name = "format")
    val format: PostFormat? = null,
    @Json(name = "reblog_key")
    val reblogKey: String? = null,
    @Json(name = "tags")
    val tags: List<String>? = null,
    @Json(name = "bookmarklet")
    val isBookmarklet: Boolean? = null,
    @Json(name = "mobile")
    val isMobile: Boolean? = null,
    @Json(name = "source_url")
    val sourceUrl: String? = null,
    @Json(name = "source_title")
    val sourceTitle: String? = null,
    @Json(name = "liked")
    val isLiked: Boolean? = null,
    @Json(name = "state")
    val state: State? = null,
    @Json(name = "is_anonymous")
    val anonymous: Boolean? = null,
    @Json(name = "content")
    val content: List<PostContent>? = null,
    @Json(name = "trail")
    val trail: List<Trail>? = null,
    @Json(name = "layout")
    val layout: List<BlockLayout>? = null,
    @Json(name = "post_author")
    val postAuthor: String? = null,
    @Json(name = "short_url")
    val shortUrl: String? = null,
    @Json(name = "summary")
    val summary: String? = null,
    @Json(name = "is_blocks_post_format")
    val isBlocksFormat: Boolean? = null,
    @Json(name = "liked_timestamp")
    val likedTimestamp: Long? = null,
    @Json(name = "slug")
    val slug: String? = null,
    @Json(name = "note_count")
    val noteCount: Long? = null,
    @Json(name = "recommended_source")
    val recommendedSource: String? = null,
    @Json(name = "recommended_color")
    val recommendedColor: String? = null,
    @Json(name = "post_author_is_adult")
    val postAuthorIsAdult: Boolean? = null,
    @Json(name = "is_submission")
    val isSubmission: Boolean? = null,
    @Json(name = "can_like")
    val canLike: Boolean? = null,
    @Json(name = "can_reblog")
    val canReblog: Boolean? = null,
    @Json(name = "can_send_in_message")
    val canSendInMessage: Boolean? = null,
    @Json(name = "can_reply")
    val canReply: Boolean? = null,
    @Json(name = "display_avatar")
    val displayAvatar: Boolean? = null,
    @Json(name = "followed")
    val followed: Boolean? = null,
    @Json(name = "reblog")
    val reblogData: ReblogData? = null,
    @Json(name = "reblogged_from_id")
    val rebloggedFromId: Long? = null,
    @Json(name = "reblogged_from_url")
    val rebloggedFromUrl: String? = null,
    @Json(name = "reblogged_from_name")
    val rebloggedFromName: String? = null,
    @Json(name = "reblogged_from_title")
    val rebloggedFromTitle: String? = null,
    @Json(name = "reblogged_from_uuid")
    val rebloggedFromUuid: String? = null,
    @Json(name = "reblogged_from_can_message")
    val rebloggedFromCanMessage: Boolean? = null,
    @Json(name = "reblogged_from_following")
    val rebloggedFromFollowing: Boolean? = null,
    @Json(name = "reblogged_root_id")
    val rebloggedRootId: Long? = null,
    @Json(name = "reblogged_root_url")
    val rebloggedRootUrl: String? = null,
    @Json(name = "reblogged_root_name")
    val rebloggedRootName: String? = null,
    @Json(name = "reblogged_root_title")
    val rebloggedRootTitle: String? = null,
    @Json(name = "reblogged_root_uuid")
    val rebloggedRootUuid: String? = null,
    @Json(name = "reblogged_root_can_message")
    val rebloggedRootCanMessage: Boolean? = null,
    @Json(name = "reblogged_root_following")
    val rebloggedRootFollowing: Boolean? = null,
    @Json(name = "notes")
    val notes: List<NoteData>? = null,
    @Json(name = "scheduled_publish_time")
    val publishTime: Long? = null,
    @Json(name = "queued_state")
    val queueState: QueueState? = null,
    @Json(name = "should_open_in_legacy")
    val shouldOpenInLegacy: Boolean? = null,
    @Json(name = "muted")
    val muted: Boolean? = null,
    @Json(name = "object_type")
    val objectType: ObjectType? = null,
    @Json(name = "tumblelog_uuid")
    val blogUUID: String? = null,
    @Json(name = "parent_post_id")
    val parentPostId: Long? = null,
    @Json(name = "parent_tumblelog_uuid")
    val parentBlogUUID: String? = null,
    @Json(name = "is_blurred_images")
    val isBlurredImages: Boolean? = null,
    @Json(name = "recommendation_reason")
    val recommendationReason: RecommendationReason? = null,
    @Json(name = "dismissal")
    val dismissal: String? = null,
    @Json(name = "serve_id")
    val serveId: String? = null,
    @Json(name = "genesis_post_id")
    val genesisPostId: String? = null,
    @Json(name = "is_pinned")
    val isPinned: Boolean? = null,
    @Json(name = "asking_name")
    val askingName: String? = null,
    @Json(name = "asking_url")
    val askingUrl: String? = null,
    @Json(name = "asking_avatar")
    val askingAvatar: MediaList? = null,
    @Json(name = "original_type")
    val originalType: Type? = null,
    @Json(name = "filtered")
    val filteredReason: FilteredReason? = null,
    @Json(name = "_links")
    val postLinks: RequestLinks? = null,
    @Json(name = "type")
    val type: Type = Type.Block,
) {

    /**
     * Enum of valid post states.
     */
    @JsonClass(generateAdapter = false)
    public enum class State {
        /**
         * This post is currently a draft. It has not been posted, or scheduled to be posted.
         */
        @Json(name = "draft")
        Draft,

        /**
         * This post should be queued, schedule it to be posted in the future.
         */
        @Json(name = "queue")
        Queue,

        /**
         * This post has been queued, it is scheduled to be posted in the future.
         */
        @Json(name = "queued")
        Queued,

        /**
         * The post has been publicly posted.
         */
        @Json(name = "published")
        Published,

        /**
         * This post has been privately posted.
         */
        @Json(name = "private")
        Private,

        /**
         * This post was submitted by another user, and has not been posted.
         */
        @Json(name = "submission")
        Submission,

        /**
         * This post is a new submission.
         */
        @Json(name = "unapproved")
        Unapproved,
    }

    /**
     * Enum of valid post types.
     *
     * @param key The string that Tumblr uses to reference each type of post.
     */
    @JsonClass(generateAdapter = false)
    public enum class Type constructor(public val key: String) {
        /**
         * An answer post, also known as an Ask post.
         */
        @Json(name = "answer")
        Answer("answer"),

        /**
         * An audio post.
         */
        @Json(name = "audio")
        Audio("audio"),

        /**
         * A chat post, also know as a dialog post.
         */
        @Json(name = "chat")
        Chat("chat"),

        /**
         * A link post.
         */
        @Json(name = "link")
        Link("link"),

        /**
         * A photo or photoset post.
         */
        @Json(name = "photo")
        Photo("photo"),

        /**
         * A quote post.
         */
        @Json(name = "quote")
        Quote("quote"),

        /**
         * A text post.
         */
        @Json(name = "text")
        Text("text"),

        /**
         * A video post.
         */
        @Json(name = "video")
        Video("video"),

        /**
         * A block post, also known as a NPF post.
         */
        @Json(name = "blocks")
        Block("blocks"),

        /**
         * TODO: Documentation
         */
        @Json(name = "regular")
        Regular("regular"),

        /**
         * TODO: Documentation
         */
        @Json(name = "note")
        Note("note"),

        /**
         * TODO: Documentation
         */
        @Json(name = "conversation")
        Conversation("conversation"),
    }

    /**
     * PostFormat - The different text formatting markups that a post can be encoded with.
     *
     * @param key The string that Tumblr uses to reference each type of format.
     */
    @JsonClass(generateAdapter = false)
    public enum class PostFormat constructor(public val key: String) {
        /**
         * Post content is rendered as HTML.
         */
        @Json(name = "html")
        HTML("html"),

        /**
         * Post content is rendered as plain text, no HTML.
         */
        @Json(name = "text")
        Plain("text"),

        /**
         * Post content is rendered as entered by the user (no post-processing).
         */
        @Json(name = "raw")
        Raw("raw"),

        /**
         * Post content is rendered as Markdown if the user writes in Markdown.
         */
        @Json(name = "markdown")
        Markdown("markdown"),
    }

    /**
     * QueueState - The current state of this post in the queue.
     *
     * @param key The string that Tumblr uses to reference each state of post.
     */
    @JsonClass(generateAdapter = false)
    public enum class QueueState constructor(public val key: String) {
        /**
         * This post is currently queued.
         */
        @Json(name = "queued")
        Queued("queued"),
    }

    /**
     * ObjectType - The timeline object type, always `post`.
     *
     * @param key The string that Tumblr uses to reference each type.
     */
    @JsonClass(generateAdapter = false)
    public enum class ObjectType constructor(public val key: String) {
        /**
         * The value returned on the single post returned when requesting a specific post.
         */
        @Json(name = "post")
        Post("post"),
    }

    /**
     * NotesMode - The mode of request to use when requesting all notes for a post.
     *
     * @param key The string that Tumblr uses to reference each mode.
     */
    @JsonClass(generateAdapter = false)
    public enum class NotesMode constructor(public val key: String) {
        /**
         * All - loads all notes for the post.
         */
        @Json(name = "all")
        All("all"),

        /**
         * Likes - loads only likes for the post.
         */
        @Json(name = "likes")
        Likes("likes"),

        /**
         * Conversation - loads only replies and reblogs with added text commentary, with the rest of the notes (likes, reblogs without commentary) in a rollup_notes field.
         */
        @Json(name = "conversation")
        Conversation("conversation"),

        /**
         * RollUp - loads only like and reblog notes for the post in the notes array.
         */
        @Json(name = "rollup")
        RollUp("rollup"),

        /**
         * ReblogsWithTags - loads only the reblog notes for the post, and each note object includes a tags array field (which may be empty).
         */
        @Json(name = "reblogs_with_tags")
        ReblogsWithTags("reblogs_with_tags"),
    }

    /**
     * A helper function to determine the legacy post type that a block post corresponds to.
     *
     * Based on the logic here: https://www.tumblr.com/docs/npf#mapping-npf-post-content-to-legacy-post-types
     */
    public fun getLegacyPostType(): Type {
        return when {
            layout?.any { it is AskBlockLayout } == true -> {
                Type.Answer
            }
            content?.any { it is VideoContent } == true -> {
                Type.Video
            }
            content?.any { it is ImageContent } == true -> {
                Type.Photo
            }
            content?.any { it is AudioContent } == true -> {
                Type.Audio
            }
            content?.any { it is TextContent && it.subType == TextContent.SubType.Quote } == true -> {
                Type.Quote
            }
            (content?.count { it is TextContent && it.subType == TextContent.SubType.Chat } ?: 0) > 1 -> {
                Type.Chat
            }
            content?.any { it is LinkContent } == true -> {
                Type.Link
            }
            else -> {
                Type.Text
            }
        }
    }
}
