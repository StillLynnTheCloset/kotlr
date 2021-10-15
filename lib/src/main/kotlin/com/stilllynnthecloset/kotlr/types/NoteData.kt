package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.PolymorphicJsonAdapterFactory
import com.stilllynnthecloset.kotlr.types.content.TextContent
import com.stilllynnthecloset.kotlr.types.content.TextFormat

/**
 * NoteData - Extra data that can be returned on a [Post] when the getNotesHistory argument is used in the request.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @property timestamp The time that this note was added to the post (seconds since the epoch.)
 * @property blogName The name of the blog that added this note.
 * @property blogUuid The UUID of the blog that added this note.
 * @property blogUrl The URL of the blog that added this note.
 * @property blogFollowed Whether you have followed the blog that added this note.
 * @property avatarShape The shape of the avatar icon of the blog that added this note.
 */
public sealed class NoteData {
    internal companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(NoteData::class.java, "type")
            .withDefaultValue(UnknownNote())
            .withSubtype(LikeNote::class.java, LikeNote.KEY)
            .withSubtype(PostedNote::class.java, PostedNote.KEY)
            .withSubtype(ReblogNote::class.java, ReblogNote.KEY)
            .withSubtype(ReplyNote::class.java, ReplyNote.KEY)
            .withSubtype(AttributionNote::class.java, AttributionNote.KEY)
            .withSubtype(UnknownNote::class.java, UnknownNote.KEY)
    }

    public abstract val timestamp: Long?
    public abstract val blogName: String?
    public abstract val blogUuid: String?
    public abstract val blogUrl: String?
    public abstract val blogFollowed: Boolean?
    public abstract val avatarShape: String?
    internal abstract val type: String
}

/**
 * UnknownNote - Placeholder that is generated when a Note with an unknown [type] is encountered.
 */
@JsonClass(generateAdapter = true)
public class UnknownNote : NoteData() {
    internal companion object {
        internal const val KEY: String = "Unknown"
    }

    override val timestamp: Long? = null
    override val blogName: String? = null
    override val blogUuid: String? = null
    override val blogUrl: String? = null
    override val blogFollowed: Boolean? = null
    override val avatarShape: String? = null
    override val type: String = KEY
}

/**
 * LikeNote - A note that is added when someone likes a post.
 */
@JsonClass(generateAdapter = true)
public data class LikeNote constructor(
    override val timestamp: Long? = null,
    @Json(name = "blog_name")
    override val blogName: String? = null,
    @Json(name = "blog_uuid")
    override val blogUuid: String? = null,
    @Json(name = "blog_url")
    override val blogUrl: String? = null,
    @Json(name = "followed")
    override val blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    override val avatarShape: String? = null,
    override val type: String = KEY,
) : NoteData() {
    internal companion object {
        internal const val KEY: String = "like"
    }
}

/**
 * PostedNote - A note that is added when the post is first posted.
 */
@JsonClass(generateAdapter = true)
public data class PostedNote constructor(
    override val timestamp: Long? = null,
    @Json(name = "blog_name")
    override val blogName: String? = null,
    @Json(name = "blog_uuid")
    override val blogUuid: String? = null,
    @Json(name = "blog_url")
    override val blogUrl: String? = null,
    @Json(name = "followed")
    override val blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    override val avatarShape: String? = null,
    override val type: String = KEY,
) : NoteData() {
    internal companion object {
        internal const val KEY: String = "posted"
    }
}

/**
 * ReblogNote - A note that is added when a post is reblogged.
 *
 * @param addedText A string containing the text that was added to the post when it was reblogged.
 * @param postId The post id of the reblog, i.e. the postId on the reblogger's blog that was created when they reblogged.
 * @param canBlock Whether you can block the blog that added this note.
 * @param reblogParentBlogName The name of the blog which this post was reblogged from (not the reblogger)
 */
@JsonClass(generateAdapter = true)
public data class ReblogNote constructor(
    override val timestamp: Long? = null,
    @Json(name = "blog_name")
    override val blogName: String? = null,
    @Json(name = "blog_uuid")
    override val blogUuid: String? = null,
    @Json(name = "blog_url")
    override val blogUrl: String? = null,
    @Json(name = "followed")
    override val blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    override val avatarShape: String? = null,
    @Json(name = "added_text")
    val addedText: String? = null,
    @Json(name = "post_id")
    val postId: String? = null,
    @Json(name = "can_block")
    val canBlock: Boolean? = null,
    @Json(name = "reblog_parent_blog_name")
    val reblogParentBlogName: String? = null,
    override val type: String = KEY,
) : NoteData() {
    internal companion object {
        internal const val KEY: String = "reblog"
    }
}

/**
 * ReplyNote - A note that is added when a user adds a message to a post.
 *
 * @param replyText The text that they added.
 * @param formatting Text formatting objects, just like [TextContent].
 * @param canBlock Whether you are able to block the user who added this reply.
 */
@JsonClass(generateAdapter = true)
public data class ReplyNote constructor(
    override val timestamp: Long? = null,
    @Json(name = "blog_name")
    override val blogName: String? = null,
    @Json(name = "blog_uuid")
    override val blogUuid: String? = null,
    @Json(name = "blog_url")
    override val blogUrl: String? = null,
    @Json(name = "followed")
    override val blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    override val avatarShape: String? = null,
    @Json(name = "reply_text")
    val replyText: String? = null,
    val formatting: List<TextFormat>? = null,
    @Json(name = "can_block")
    val canBlock: Boolean? = null,
    override val type: String = KEY,
) : NoteData() {
    internal companion object {
        internal const val KEY: String = "reply"
    }
}

/**
 * AttributionNote - TODO: Documentation
 *
 * @param postId TODO: Documentation
 * @param postAttributionType TODO: Documentation
 * @param postAttributionTypeName TODO: Documentation
 * @param photoUrl TODO: Documentation
 * @param photoWidth TODO: Documentation
 * @param photoHeight TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class AttributionNote constructor(
    override val timestamp: Long? = null,
    @Json(name = "blog_name")
    override val blogName: String? = null,
    @Json(name = "blog_uuid")
    override val blogUuid: String? = null,
    @Json(name = "blog_url")
    override val blogUrl: String? = null,
    @Json(name = "followed")
    override val blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    override val avatarShape: String? = null,
    @Json(name = "post_id")
    val postId: String? = null,
    @Json(name = "post_attribution_type")
    val postAttributionType: String? = null,
    @Json(name = "post_attribution_type_name")
    val postAttributionTypeName: String? = null,
    @Json(name = "photo_url")
    val photoUrl: String? = null,
    @Json(name = "photo_width")
    val photoWidth: Int? = null,
    @Json(name = "photo_height")
    val photoHeight: Int? = null,
    override val type: String = KEY,
) : NoteData() {
    internal companion object {
        internal const val KEY: String = "post_attribution"
    }
}
