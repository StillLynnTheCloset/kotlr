package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent

/**
 * BlockPost - TODO: Documentation
 *
 * @author highthunder
 * @since 11/3/18
 * @version 1.0.0
 */
class BlockPost(
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
        notes: List<NoteData>? = null
) : Post(blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags, isBookmarklet,
        isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts, anonymous, content, trail,
        layout, postAuthor, shortUrl, summary, isBlocksFormat, likedTimestamp, slug, noteCount,
        recommendedSource, recommendedColor, postAuthorIsAdult, isSubmission, canLike, canReblog,
        canSendInMessage, canReply, displayAvatar, followed, reblogData, rebloggedFromId,
        reblogged_from_url, rebloggedFromName, reblogged_from_title, reblogged_from_uuid,
        reblogged_from_can_message, reblogged_from_following, reblogged_root_id,
        reblogged_root_url, reblogged_root_name, reblogged_root_title, reblogged_root_uuid,
        reblogged_root_can_message, reblogged_root_following, notes)
