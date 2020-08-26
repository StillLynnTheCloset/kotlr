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
     * The total number of post available for this request, useful for paginating through results.
     */
    public val totalPosts: Int?
    /**
     * TODO: Documentation
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
     * The slug. TODO: Documentation
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
     * TODO: Documentation
     */
    public val reblogData: ReblogData?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromId: Long?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromUrl: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromName: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromTitle: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromUuid: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromCanMessage: Boolean?
    /**
     * TODO: Documentation
     */
    public val rebloggedFromFollowing: Boolean?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootId: Long?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootUrl: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootName: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootTitle: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootUuid: String?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootCanMessage: Boolean?
    /**
     * TODO: Documentation
     */
    public val rebloggedRootFollowing: Boolean?
    /**
     * TODO: Documentation
     */
    public val notes: List<NoteData>?
    /**
     * TODO: Documentation
     */
    public val publishTime: Long?
    /**
     * TODO: Documentation
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
    public val objectType: String?
    /**
     * TODO: Documentation
     */
    public val blogUUID: String?
    /**
     * TODO: Documentation
     */
    public val parentPostId: Long?
    /**
     * TODO: Documentation
     */
    public val parentBlogUUID: String?
    /**
     * TODO: Documentation
     */
    public val isBlurredImages: Boolean?

    // endregion

    /**
     * Enum of valid post states.
     */
    @JsonClass(generateAdapter = false)
    public enum class State {
        /**
         * TODO: Documentation
         */
        @Json(name = "draft")
        Draft,
        /**
         * TODO: Documentation
         */
        @Json(name = "queued")
        Queue,
        /**
         * TODO: Documentation
         */
        @Json(name = "published")
        Published,
        /**
         * TODO: Documentation
         */
        @Json(name = "private")
        Private,
        /**
         * TODO: Documentation
         */
        @Json(name = "submission")
        Submission
    }

    /**
     * Enum of valid post types.
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    public enum class Type constructor(public val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "answer")
        Answer("answer"),
        /**
         * TODO: Documentation
         */
        @Json(name = "audio")
        Audio("audio"),
        /**
         * TODO: Documentation
         */
        @Json(name = "chat")
        Chat("chat"),
        /**
         * TODO: Documentation
         */
        @Json(name = "link")
        Link("link"),
        /**
         * TODO: Documentation
         */
        @Json(name = "photo")
        Photo("photo"),
        /**
         * TODO: Documentation
         */
        @Json(name = "quote")
        Quote("quote"),
        /**
         * TODO: Documentation
         */
        @Json(name = "text")
        Text("text"),
        /**
         * TODO: Documentation
         */
        @Json(name = "video")
        Video("video"),
        /**
         * TODO: Documentation
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
        Conversation("conversation")
    }

    /**
     * TODO: Documentation
     *
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    public enum class PostFormat constructor(public val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "html")
        HTML("html"),
        /**
         * TODO: Documentation
         */
        @Json(name = "text")
        Plain("text"),
        /**
         * TODO: Documentation
         */
        @Json(name = "raw")
        Raw("raw"),
        /**
         * TODO: Documentation
         */
        @Json(name = "markdown")
        Markdown("markdown"),
    }

    /**
     * TODO: Documentation
     *
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    public enum class PostVersion constructor(public val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "npf")
        NPF("npf"),
        /**
         * TODO: Documentation
         */
        @Json(name = "legacy")
        Legacy("legacy")
    }

    /**
     * TODO: Documentation
     *
     * @param key TODO: Documentation
     */
    @JsonClass(generateAdapter = false)
    public enum class QueueState constructor(public val key: String) {
        /**
         * TODO: Documentation
         */
        @Json(name = "queued")
        Queued("queued")
    }

    /**
     * https://www.tumblr.com/docs/npf#mapping-npf-post-content-to-legacy-post-types
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
