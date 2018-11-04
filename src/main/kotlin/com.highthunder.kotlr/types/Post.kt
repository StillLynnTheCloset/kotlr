package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.squareup.moshi.Json

/**
 * Post - The base information about a post.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
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
 * @param totalPosts The total number of post available for this request, useful for paginating through results.
 * @param content The array of content that constitutes the body of a post in the Neue Post Format(NPF).
 * @param trail The previous Posts in the reblog trail. In order of oldest (the root Post) to the newest (the parent Post).
 * @param layout The layouts of the blocks in this post.
 * @param postAuthor The id of the author of the post.
 * @param shortUrl The short URL for this post.
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
 */
abstract class Post(

        // region Defaults

        var blogName: String? = null,
        var id: Long? = null,
        var blog: Blog? = null,
        var postUrl: String? = null,
        var timestamp: Long? = null,
        var date: String? = null,
        var format: String? = null,
        var reblogKey: String? = null,
        var tags: List<String>? = null,
        var isBookmarklet: Boolean? = null,
        var isMobile: Boolean? = null,
        var sourceUrl: String? = null,
        var sourceTitle: String? = null,
        var isLiked: Boolean? = null,
        var state: State? = null,
        var totalPosts: Int? = null,
        var anonymous: Boolean? = null, // TODO: Documentation

        // endregion

        // region Situational Fields

        var content: List<PostContent>? = null,
        var trail: List<Trail>? = null,
        var layout: List<BlockLayout>? = null,
        var postAuthor: String? = null,
        var shortUrl: String? = null,
        var summary: String? = null,
        var isBlocksFormat: Boolean? = null,
        var likedTimestamp: Long? = null,
        var slug: String? = null,
        var noteCount: Long? = null,
        var recommendedSource: String? = null,
        var recommendedColor: String? = null,
        var postAuthorIsAdult: Boolean? = null,
        var isSubmission: Boolean? = null,
        var canLike: Boolean? = null,
        var canReblog: Boolean? = null,
        var canSendInMessage: Boolean? = null,
        var canReply: Boolean? = null,
        var displayAvatar: Boolean? = null,
        var followed: Boolean? = null,
        var reblogData: ReblogData? = null, // TODO: Documentation
        var rebloggedFromId: Long? = null, // TODO: Documentation
        var reblogged_from_url: String? = null, // TODO: Documentation
        var rebloggedFromName: String? = null, // TODO: Documentation
        var reblogged_from_title: String? = null, // TODO: Documentation
        var reblogged_from_uuid: String? = null, // TODO: Documentation
        var reblogged_from_can_message: Boolean? = null, // TODO: Documentation
        var reblogged_from_following: Boolean? = null, // TODO: Documentation
        var reblogged_root_id: Long? = null, // TODO: Documentation
        var reblogged_root_url: String? = null, // TODO: Documentation
        var reblogged_root_name: String? = null, // TODO: Documentation
        var reblogged_root_title: String? = null, // TODO: Documentation
        var reblogged_root_uuid: String? = null, // TODO: Documentation
        var reblogged_root_can_message: Boolean? = null, // TODO: Documentation
        var reblogged_root_following: Boolean? = null, // TODO: Documentation
        var notes: List<NoteData>? = null // TODO: Documentation

        // endregion

) {

    /**
     * Enum of valid post states.
     */
    enum class State {
        @Json(name = "draft")
        Draft,
        @Json(name = "queue")
        Queue,
        @Json(name = "published")
        Published,
        @Json(name = "private")
        Private,
        @Json(name = "submission")
        Submission
    }

    /**
     * Enum of valid post types.
     */
    enum class Type(val key: String) {
        @Json(name = "answer")
        Answer("answer"),
        @Json(name = "audio")
        Audio("audio"),
        @Json(name = "chat")
        Chat("chat"),
        @Json(name = "link")
        Link("link"),
        @Json(name = "photo")
        Photo("photo"),
        @Json(name = "quote")
        Quote("quote"),
        @Json(name = "text")
        Text("text"),
        @Json(name = "video")
        Video("video"),
        @Json(name = "blocks")
        Block("blocks")
    }

}
