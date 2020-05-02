package com.highthunder.kotlr.types

import com.highthunder.kotlr.json.PolymorphicJsonAdapterFactory
import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * NoteData - TODO: Documentation
 *
 * @author highthunder
 * @since 11/3/18
 * @version 1.0.0
 *
 * @property timestamp TODO: Documentation
 * @property blogName TODO: Documentation
 * @property blogUuid TODO: Documentation
 * @property blogUrl TODO: Documentation
 * @property blogFollowed TODO: Documentation
 * @property avatarShape TODO: Documentation
 */
sealed class NoteData {
    companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(NoteData::class.java, "type")
            .withDefaultValue(UnknownNote)

            .withSubtype(LikeNote::class.java, LikeNote.KEY)
            .withSubtype(PostedNote::class.java, PostedNote.KEY)
            .withSubtype(ReblogNote::class.java, ReblogNote.KEY)
            .withSubtype(ReplyNote::class.java, ReplyNote.KEY)
            .withSubtype(AttributionNote::class.java, AttributionNote.KEY)
    }

    abstract val timestamp: Long?
    abstract val blogName: String?
    abstract val blogUuid: String?
    abstract val blogUrl: String?
    abstract val blogFollowed: Boolean?
    abstract val avatarShape: String?
    internal abstract val type: String
}

object UnknownNote : NoteData() {
    override val timestamp: Long? = null
    override val blogName: String? = null
    override val blogUuid: String? = null
    override val blogUrl: String? = null
    override val blogFollowed: Boolean? = null
    override val avatarShape: String? = null
    override val type: String = "Unknown"
}

/**
 * TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class LikeNote constructor(
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
    override val type: String = KEY
) : NoteData() {
    companion object {
        const val KEY: String = "like"
    }
}

/**
 * TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class PostedNote constructor(
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
    override val type: String = KEY
) : NoteData() {
    companion object {
        const val KEY: String = "posted"
    }
}

/**
 * TODO: Documentation
 *
 * @param postId TODO: Documentation
 * @param reblogParentBlogName TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class ReblogNote constructor(
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
    override val type: String = KEY
) : NoteData() {
    companion object {
        const val KEY: String = "reblog"
    }
}

/**
 * TODO: Documentation
 *
 * @param replyText TODO: Documentation
 * @param formatting TODO: Documentation
 * @param canBlock TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class ReplyNote constructor(
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
    override val type: String = KEY
) : NoteData() {
    companion object {
        const val KEY: String = "reply"
    }
}

/**
 * TODO: Documentation
 *
 * @param postAttributionType TODO: Documentation
 * @param postAttributionTypeName TODO: Documentation
 * @param photoUrl TODO: Documentation
 * @param photoWidth TODO: Documentation
 * @param photoHeight TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class AttributionNote constructor(
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
    override val type: String = KEY
) : NoteData() {
    companion object {
        const val KEY: String = "post_attribution"
    }
}
