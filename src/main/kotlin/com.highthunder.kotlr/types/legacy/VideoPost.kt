package com.highthunder.kotlr.types.legacy

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.ReblogData
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent

/**
 * VideoPost - A legacy video post.
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
 * @param anonymous TODO: Documentation
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
 * @param reblogData TODO: Documentation
 * @param rebloggedFromId The ID of the post that this post reblogged.
 * @param rebloggedFromUrl TODO: Documentation
 * @param rebloggedFromName The name of the blog that this post reblogged.
 * @param rebloggedFromTitle TODO: Documentation
 * @param rebloggedFromUuid TODO: Documentation
 * @param rebloggedFromCanMessage TODO: Documentation
 * @param rebloggedFromFollowing TODO: Documentation
 * @param rebloggedRootId The ID of the post that this post reblogged.
 * @param rebloggedRootUrl TODO: Documentation
 * @param rebloggedRootName The name of the blog that this post reblogged.
 * @param rebloggedRootTitle TODO: Documentation
 * @param rebloggedRootUuid TODO: Documentation
 * @param rebloggedRootCanMessage TODO: Documentation
 * @param rebloggedRootFollowing TODO: Documentation
 * @param notes TODO: Documentation
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
 * @param videoData TODO: Documentation
 * @param permalinkUrl TODO: Documentation
 * @param videoType The source of this video (tumblr, youtube, instagram, vimeo, vine(rip), etc.).
 */
data class VideoPost(
    override var blogName: String? = null,
    override val id: Long? = null,
    override val blog: Blog? = null,
    override val postUrl: String? = null,
    override val timestamp: Long? = null,
    override val date: String? = null,
    override var format: Post.PostFormat? = null,
    override val reblogKey: String? = null,
    override var tags: List<String>? = null,
    override var isBookmarklet: Boolean? = null,
    override var isMobile: Boolean? = null,
    override var sourceUrl: String? = null,
    override var sourceTitle: String? = null,
    override val isLiked: Boolean? = null,
    override var state: Post.State? = null,
    override val totalPosts: Int? = null,
    override var anonymous: Boolean? = null,
    override var content: List<PostContent>? = null,
    override var trail: List<Trail>? = null,
    override var layout: List<BlockLayout>? = null,
    override var postAuthor: String? = null,
    override var shortUrl: String? = null,
    override var summary: String? = null,
    override var isBlocksFormat: Boolean? = null,
    override val likedTimestamp: Long? = null,
    override var slug: String? = null,
    override var noteCount: Long? = null,
    override val recommendedSource: String? = null,
    override val recommendedColor: String? = null,
    override val postAuthorIsAdult: Boolean? = null,
    override var isSubmission: Boolean? = null,
    override var canLike: Boolean? = null,
    override var canReblog: Boolean? = null,
    override var canSendInMessage: Boolean? = null,
    override var canReply: Boolean? = null,
    override val displayAvatar: Boolean? = null,
    override val followed: Boolean? = null,
    override var reblogData: ReblogData? = null,
    override val rebloggedFromId: Long? = null,
    override val rebloggedFromUrl: String? = null,
    override val rebloggedFromName: String? = null,
    override val rebloggedFromTitle: String? = null,
    override val rebloggedFromUuid: String? = null,
    override val rebloggedFromCanMessage: Boolean? = null,
    override val rebloggedFromFollowing: Boolean? = null,
    override val rebloggedRootId: Long? = null,
    override val rebloggedRootUrl: String? = null,
    override val rebloggedRootName: String? = null,
    override val rebloggedRootTitle: String? = null,
    override val rebloggedRootUuid: String? = null,
    override val rebloggedRootCanMessage: Boolean? = null,
    override val rebloggedRootFollowing: Boolean? = null,
    override val notes: List<NoteData>? = null,
    override val publishTime: Long?,
    override val queueState: Post.QueueState?,
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
) : Post
