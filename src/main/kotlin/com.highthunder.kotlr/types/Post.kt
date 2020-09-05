package com.highthunder.kotlr.types

import com.highthunder.kotlr.json.PolymorphicJsonAdapterFactory
import com.highthunder.kotlr.types.content.AskBlockLayout
import com.highthunder.kotlr.types.content.AudioContent
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.LinkContent
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.TextContent
import com.highthunder.kotlr.types.content.VideoContent
import com.highthunder.kotlr.types.legacy.AnswerPost
import com.highthunder.kotlr.types.legacy.AudioPost
import com.highthunder.kotlr.types.legacy.ChatPost
import com.highthunder.kotlr.types.legacy.LinkPost
import com.highthunder.kotlr.types.legacy.PhotoPost
import com.highthunder.kotlr.types.legacy.QuotePost
import com.highthunder.kotlr.types.legacy.TextPost
import com.highthunder.kotlr.types.legacy.VideoPost
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Post - The base information about a post.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
public interface Post {
    public companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(Post::class.java, "type")
            // .withDefaultValue() // TODO: Add a default post object
            .withMissingLabelType(BlockPost::class.java)

            .withSubtype(AnswerPost::class.java, Type.Answer.key)
            .withSubtype(AudioPost::class.java, Type.Audio.key)
            .withSubtype(BlockPost::class.java, Type.Block.key)
            .withSubtype(ChatPost::class.java, Type.Chat.key)
            .withSubtype(LinkPost::class.java, Type.Link.key)
            .withSubtype(PhotoPost::class.java, Type.Photo.key)
            .withSubtype(QuotePost::class.java, Type.Quote.key)
            .withSubtype(TextPost::class.java, Type.Text.key)
            .withSubtype(VideoPost::class.java, Type.Video.key)
    }

    /**
     * The type of post that this is.
     */
    public val type: Type

    // region Defaults

    /**
     * The short name used to uniquely identify a blog.
     */
    public val blogName: String?

    /**
     * The post's unique ID.
     */
    public val id: Long?

    /**
     * The post's unique ID formatted as a string to prevent loss of precision on platforms that lack true 64-bit integers.
     */
    public val idString: String?

    /**
     * A standard API-formatted "short blog info" object.
     */
    public val blog: Blog?

    /**
     * The location of the post.
     */
    public val postUrl: String?

    /**
     * The time of the post, in seconds since the epoch.
     */
    public val timestamp: Long?

    /**
     * The GMT date and time of the post, as a string.
     */
    public val date: String?

    /**
     * The post format: html, raw, or markdown.
     */
    public val format: PostFormat?

    /**
     * The key used to reblog this post.
     */
    public val reblogKey: String?

    /**
     * Tags applied to the post.
     */
    public val tags: List<String>?

    /**
     * Indicates whether the post was created via the Tumblr bookmarklet.
     */
    public val isBookmarklet: Boolean?

    /**
     * Indicates whether the post was created via mobile/email publishing.
     */
    public val isMobile: Boolean?

    /**
     * The URL for the source of the content (for quotes, reblogs, etc.).
     */
    public val sourceUrl: String?

    /**
     * The title of the source site.
     */
    public val sourceTitle: String?

    /**
     * Indicates if a user has already liked a post or not.
     */
    public val isLiked: Boolean?

    /**
     * Indicates the current state of the post.
     */
    public val state: State?

    /**
     * Was this post made anonymously.
     */
    public val anonymous: Boolean?

    // endregion

    // region Situational Fields

    /**
     * The array of content that constitutes the body of a post in the Neue Post Format(NPF).
     */
    public val content: List<PostContent>?

    /**
     * The previous Posts in the reblog trail. In order of oldest (the root Post) to the newest (the parent Post).
     */
    public val trail: List<Trail>?

    /**
     * The layouts of the blocks in this post.
     */
    public val layout: List<BlockLayout>?

    /**
     * The id of the author of the post.
     */
    public val postAuthor: String?

    /**
     * The short URL for this post.
     */
    public val shortUrl: String?

    /**
     * A short description of this post.
     */
    public val summary: String?

    /**
     * Indicates whether or not this post is using the new block format(NPF).
     */
    public val isBlocksFormat: Boolean?

    /**
     * The timestamp of when this post was liked.
     */
    public val likedTimestamp: Long?

    /**
     * The slug. This is a short string (with spaces replaced with "-") that is added to urls to give a simple overview of the post content.
     */
    public val slug: String?

    /**
     * The note count for this post.
     */
    public val noteCount: Long?

    /**
     * The source of a recommended post.
     */
    public val recommendedSource: String?

    /**
     * The recommended color for styling this post.
     */
    public val recommendedColor: String?

    /**
     * Indicates whether or not the author of this post is an adult only blog.
     */
    public val postAuthorIsAdult: Boolean?

    /**
     * Indicates whether or not this post is a submission.
     */
    public val isSubmission: Boolean?

    /**
     * Indicates whether or not the current user can like this post.
     */
    public val canLike: Boolean?

    /**
     * Indicates whether or not the current user can reblog this post.
     */
    public val canReblog: Boolean?

    /**
     * Indicates whether or not this post can be sent in a message.
     */
    public val canSendInMessage: Boolean?

    /**
     * Indicates whether or not the current user can reply to this post.
     */
    public val canReply: Boolean?

    /**
     * Indicates whether or not the poster's avatar should be shown with this post.
     */
    public val displayAvatar: Boolean?

    /**
     * Indicates whether or not the current user follows the author of this post.
     */
    public val followed: Boolean?

    /**
     * The reblog content of this post.
     */
    public val reblogData: ReblogData?

    /**
     * The ID of the post that this post reblogged.
     */
    public val rebloggedFromId: Long?

    /**
     * The URL of the post that this post reblogged.
     */
    public val rebloggedFromUrl: String?

    /**
     * The name of the blog that this post reblogged.
     */
    public val rebloggedFromName: String?

    /**
     * The title of the blog that made the post that this post reblogged.
     */
    public val rebloggedFromTitle: String?

    /**
     * The blog uuid of the post that this post reblogged.
     */
    public val rebloggedFromUuid: String?

    /**
     * Whether or not you can message the blog that made the post that this post reblogged.
     */
    public val rebloggedFromCanMessage: Boolean?

    /**
     * Whether or not you are following the blog that made the post that this post reblogged.
     */
    public val rebloggedFromFollowing: Boolean?

    /**
     * The ID of the root post that this post reblogged.
     */
    public val rebloggedRootId: Long?

    /**
     * The URL of the root post that this post reblogged.
     */
    public val rebloggedRootUrl: String?

    /**
     * The name of the blog that this post reblogged.
     */
    public val rebloggedRootName: String?

    /**
     * The title of the blog that made the root post that this post reblogged.
     */
    public val rebloggedRootTitle: String?

    /**
     * The blog uuid of the root post that this post reblogged.
     */
    public val rebloggedRootUuid: String?

    /**
     * Whether or not you can message the blog that made the root post that this post reblogged.
     */
    public val rebloggedRootCanMessage: Boolean?

    /**
     * Whether or not you are following the blog that made the root post that this post reblogged.
     */
    public val rebloggedRootFollowing: Boolean?

    /**
     * A list of all of the notes objects attached to this post.
     */
    public val notes: List<NoteData>?

    /**
     * Returned on queued posts, the time that this post is scheduled to be posted.
     */
    public val publishTime: Long?

    /**
     * The current queue state of this post.
     */
    public val queueState: QueueState?

    /**
     * TODO: Documentation
     */
    public val shouldOpenInLegacy: Boolean?

    /**
     * TODO: Documentation
     */
    public val muted: Boolean?

    /**
     * TODO: Documentation
     */
    public val objectType: ObjectType?

    /**
     * The UUID of the blog that made this post.
     */
    public val blogUUID: String?

    /**
     * The id of the post that this post was a response to.
     */
    public val parentPostId: Long?

    /**
     * The UUID of the blog that made the parent post.
     */
    public val parentBlogUUID: String?

    /**
     * Are the images in this post blurred (a NSFW thing I guess?)
     */
    public val isBlurredImages: Boolean?

    // endregion

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
         * This post has been queued, it is scheduled to be posted in the future.
         */
        @Json(name = "queued")
        Queue,

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
        Submission
    }

    /**
     * Enum of valid post types.
     *
     * @param key The string that Tumblr uses to reference each type of post.
     */
    @JsonClass(generateAdapter = false)
    public enum class Type constructor(public val key: String) {
        /**
         * An answer post, also known as an Ask post. [AnswerPost]
         */
        @Json(name = "answer")
        Answer("answer"),

        /**
         * An audio post. [AudioPost]
         */
        @Json(name = "audio")
        Audio("audio"),

        /**
         * A chat post, also know as a dialog post. [ChatPost]
         */
        @Json(name = "chat")
        Chat("chat"),

        /**
         * A link post. [LinkPost]
         */
        @Json(name = "link")
        Link("link"),

        /**
         * A photo or photoset post. [PhotoPost]
         */
        @Json(name = "photo")
        Photo("photo"),

        /**
         * A quote post. [QuotePost]
         */
        @Json(name = "quote")
        Quote("quote"),

        /**
         * A text post. [TextPost]
         */
        @Json(name = "text")
        Text("text"),

        /**
         * A video post. [VideoPost]
         */
        @Json(name = "video")
        Video("video"),

        /**
         * A block post, also known as a NPF post. [BlockPost]
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
     * PostVersion - The api version of the post.
     *
     * @param key The string that Tumblr uses to reference each type of post.
     */
    @JsonClass(generateAdapter = false)
    public enum class PostVersion constructor(public val key: String) {
        /**
         * This is an NPF post that uses a [BlockPost] and post content is encoded with [PostContent] json objects.
         */
        @Json(name = "npf")
        NPF("npf"),

        /**
         * This is a legacy post that uses each of the different post types and post content is encoded as HTML.
         */
        @Json(name = "legacy")
        Legacy("legacy"),
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
     * ObjectType - TODO: Figure out what this is.
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
