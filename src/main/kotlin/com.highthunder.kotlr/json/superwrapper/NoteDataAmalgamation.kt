package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.AttributionNote
import com.highthunder.kotlr.types.LikeNote
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.PostedNote
import com.highthunder.kotlr.types.ReblogNote
import com.highthunder.kotlr.types.ReplyNote
import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * NoteDataAmalgamation - A class to hold every possible field for [NoteData] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The type of this note.
 * @param timestamp TODO: Documentation
 * @param blogName TODO: Documentation
 * @param blogUuid TODO: Documentation
 * @param blogUrl TODO: Documentation
 * @param blogFollowed TODO: Documentation
 * @param avatarShape TODO: Documentation
 * @param addedText TODO: Documentation
 * @param postId TODO: Documentation
 * @param reblogParentBlogName TODO: Documentation
 * @param replyText TODO: Documentation
 * @param formatting TODO: Documentation
 * @param canBlock TODO: Documentation
 * @param postAttributionType TODO: Documentation
 * @param postAttributionTypeName TODO: Documentation
 * @param photoUrl TODO: Documentation
 * @param photoWidth TODO: Documentation
 * @param photoHeight TODO: Documentation
 */
@JsonClass(generateAdapter = true)
internal data class NoteDataAmalgamation constructor(
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "timestamp")
    val timestamp: Long? = null,
    @Json(name = "blog_name")
    val blogName: String? = null,
    @Json(name = "blog_uuid")
    val blogUuid: String? = null,
    @Json(name = "blog_url")
    val blogUrl: String? = null,
    @Json(name = "followed")
    val blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    val avatarShape: String? = null,
    @Json(name = "added_text")
    val addedText: String? = null,
    @Json(name = "post_id")
    val postId: String? = null,
    @Json(name = "reblog_parent_blog_name")
    val reblogParentBlogName: String? = null,
    @Json(name = "reply_text")
    val replyText: String? = null,
    @Json(name = "formatting")
    val formatting: List<TextFormat>? = null,
    @Json(name = "can_block")
    val canBlock: Boolean? = null,
    @Json(name = "post_attribution_type")
    val postAttributionType: String? = null,
    @Json(name = "post_attribution_type_name")
    val postAttributionTypeName: String? = null,
    @Json(name = "photo_url")
    val photoUrl: String? = null,
    @Json(name = "photo_width")
    val photoWidth: Int? = null,
    @Json(name = "photo_height")
    val photoHeight: Int? = null
) {

    constructor(note: LikeNote) : this(
        type = LikeNote.KEY,
        timestamp = note.timestamp,
        blogName = note.blogName,
        blogUuid = note.blogUuid,
        blogUrl = note.blogUrl,
        blogFollowed = note.blogFollowed,
        avatarShape = note.avatarShape
    )

    constructor(note: PostedNote) : this(
        type = PostedNote.KEY,
        timestamp = note.timestamp,
        blogName = note.blogName,
        blogUuid = note.blogUuid,
        blogUrl = note.blogUrl,
        blogFollowed = note.blogFollowed,
        avatarShape = note.avatarShape
    )

    constructor(note: ReblogNote) : this(
        type = ReblogNote.KEY,
        timestamp = note.timestamp,
        blogName = note.blogName,
        blogUuid = note.blogUuid,
        blogUrl = note.blogUrl,
        blogFollowed = note.blogFollowed,
        avatarShape = note.avatarShape,
        postId = note.postId,
        reblogParentBlogName = note.reblogParentBlogName
    )

    constructor(note: ReplyNote) : this(
        type = ReplyNote.KEY,
        timestamp = note.timestamp,
        blogName = note.blogName,
        blogUuid = note.blogUuid,
        blogUrl = note.blogUrl,
        blogFollowed = note.blogFollowed,
        avatarShape = note.avatarShape,
        replyText = note.replyText,
        formatting = note.formatting,
        canBlock = note.canBlock
    )

    constructor(note: AttributionNote) : this(
        type = AttributionNote.KEY,
        timestamp = note.timestamp,
        blogName = note.blogName,
        blogUuid = note.blogUuid,
        blogUrl = note.blogUrl,
        blogFollowed = note.blogFollowed,
        avatarShape = note.avatarShape,
        postAttributionType = note.postAttributionType,
        postAttributionTypeName = note.postAttributionTypeName,
        photoUrl = note.photoUrl,
        photoWidth = note.photoWidth,
        photoHeight = note.photoHeight
    )

    fun toLike(): LikeNote = LikeNote(
        timestamp,
        blogName,
        blogUuid,
        blogUrl,
        blogFollowed,
        avatarShape
    )

    fun toPosted(): PostedNote = PostedNote(
        timestamp,
        blogName,
        blogUuid,
        blogUrl,
        blogFollowed,
        avatarShape
    )

    fun toReblog(): ReblogNote = ReblogNote(
        timestamp,
        blogName,
        blogUuid,
        blogUrl,
        blogFollowed,
        avatarShape,
        postId,
        reblogParentBlogName
    )

    fun toReply(): ReplyNote = ReplyNote(
        timestamp,
        blogName,
        blogUuid,
        blogUrl,
        blogFollowed,
        avatarShape,
        replyText,
        formatting,
        canBlock
    )

    fun toAttribution(): AttributionNote = AttributionNote(
        timestamp,
        blogName,
        blogUuid,
        blogUrl,
        blogFollowed,
        avatarShape,
        postAttributionType,
        postAttributionTypeName,
        photoUrl,
        photoWidth,
        photoHeight
    )
}
