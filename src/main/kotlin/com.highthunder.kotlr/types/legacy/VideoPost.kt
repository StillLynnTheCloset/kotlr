package com.highthunder.kotlr.types.legacy

import com.highthunder.kotlr.types.*
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent

/**
 * VideoPost - A legacy video post.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * Post
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
 * @param isBlocksFormat Whether or not this post is using the new block format(NPF).
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
 *
 * Video Post
 * @param player The list of [Video]s in this post.
 * @param caption The user-supplied caption.
 * @param videoUrl A direct link to the video file.
 * @param html5Capable Indicates if this video is HTML5.
 * @param thumbnailUrl The location of the thumbnail of this video.
 * @param thumbnailWidth The width of the thumbnail.
 * @param thumbnailHeight The height of the thumbnail.
 * @param duration The length of this video in seconds.
 * @param videoType The source of this video (tumblr, youtube, instagram, vimeo, vine(rip), etc.).
 */
class VideoPost(
        blogName: String? = null,
        id: Long? = null,
        blog: Blog? = null,
        postUrl: String? = null,
        timestamp: Long? = null,
        date: String? = null,
        format: String? = null,
        reblogKey: String? = null,
        tags: List<String>? = null,
        isBookmarklet: Boolean? = null,
        isMobile: Boolean? = null,
        sourceUrl: String? = null,
        sourceTitle: String? = null,
        isLiked: Boolean? = null,
        state: State? = null,
        totalPosts: Int? = null,
        anonymous: Boolean? = null,
        content: List<PostContent>? = null,
        trail: List<Trail>? = null,
        layout: List<BlockLayout>? = null,
        postAuthor: String? = null,
        shortUrl: String? = null,
        summary: String? = null,
        isBlocksFormat: Boolean? = null,
        likedTimestamp: Long? = null,
        slug: String? = null,
        noteCount: Long? = null,
        recommendedSource: String? = null,
        recommendedColor: String? = null,
        postAuthorIsAdult: Boolean? = null,
        isSubmission: Boolean? = null,
        canLike: Boolean? = null,
        canReblog: Boolean? = null,
        canSendInMessage: Boolean? = null,
        canReply: Boolean? = null,
        displayAvatar: Boolean? = null,
        followed: Boolean? = null,
        reblogData: ReblogData? = null,
        rebloggedFromId: Long? = null,
        reblogged_from_url: String? = null,
        rebloggedFromName: String? = null,
        reblogged_from_title: String? = null,
        reblogged_from_uuid: String? = null,
        reblogged_from_can_message: Boolean? = null,
        reblogged_from_following: Boolean? = null,
        reblogged_root_id: Long? = null,
        reblogged_root_url: String? = null,
        reblogged_root_name: String? = null,
        reblogged_root_title: String? = null,
        reblogged_root_uuid: String? = null,
        reblogged_root_can_message: Boolean? = null,
        reblogged_root_following: Boolean? = null,
        notes: List<NoteData>? = null,
        var player: List<Video>? = null,
        var caption: String? = null,
        var videoUrl: String? = null,
        var html5Capable: Boolean? = null,
        val thumbnailUrl: String? = null,
        val thumbnailWidth: Int? = null,
        val thumbnailHeight: Int? = null,
        var duration: Double? = null,
        var videoData: Any? = null,
        var permalinkUrl: String? = null,
        var videoType: String? = null
) : Post(blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags, isBookmarklet,
        isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts, anonymous, content, trail,
        layout, postAuthor, shortUrl, summary, isBlocksFormat, likedTimestamp, slug, noteCount,
        recommendedSource, recommendedColor, postAuthorIsAdult, isSubmission, canLike, canReblog,
        canSendInMessage, canReply, displayAvatar, followed, reblogData, rebloggedFromId,
        reblogged_from_url, rebloggedFromName, reblogged_from_title, reblogged_from_uuid,
        reblogged_from_can_message, reblogged_from_following, reblogged_root_id,
        reblogged_root_url, reblogged_root_name, reblogged_root_title, reblogged_root_uuid,
        reblogged_root_can_message, reblogged_root_following, notes)
