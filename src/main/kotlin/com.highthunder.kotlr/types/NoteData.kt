package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.TextFormat

/**
 * NoteData - TODO: Documentation
 *
 * @author highthunder
 * @since 11/3/18
 * @version 1.0.0
 *
 * @param timestamp TODO: Documentation
 * @param blogName TODO: Documentation
 * @param blogUuid TODO: Documentation
 * @param blogUrl TODO: Documentation
 * @param blogFollowed TODO: Documentation
 * @param avatarShape TODO: Documentation
 */
sealed class NoteData {
    abstract val timestamp: Long?
    abstract val blogName: String?
    abstract val blogUuid: String?
    abstract val blogUrl: String?
    abstract val blogFollowed: Boolean?
    abstract val avatarShape: String?
}

/**
 * TODO: Documentation
 */
data class LikeNote constructor(
    override val timestamp: Long? = null,
    override val blogName: String? = null,
    override val blogUuid: String? = null,
    override val blogUrl: String? = null,
    override val blogFollowed: Boolean? = null,
    override val avatarShape: String? = null
) : NoteData() {
    companion object {
        const val KEY: String = "like"
    }
}

/**
 * TODO: Documentation
 */
data class PostedNote constructor(
    override val timestamp: Long? = null,
    override val blogName: String? = null,
    override val blogUuid: String? = null,
    override val blogUrl: String? = null,
    override val blogFollowed: Boolean? = null,
    override val avatarShape: String? = null
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
data class ReblogNote constructor(
    override val timestamp: Long? = null,
    override val blogName: String? = null,
    override val blogUuid: String? = null,
    override val blogUrl: String? = null,
    override val blogFollowed: Boolean? = null,
    override val avatarShape: String? = null,
    val postId: String? = null,
    val reblogParentBlogName: String? = null
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
data class ReplyNote constructor(
    override val timestamp: Long? = null,
    override val blogName: String? = null,
    override val blogUuid: String? = null,
    override val blogUrl: String? = null,
    override val blogFollowed: Boolean? = null,
    override val avatarShape: String? = null,
    val replyText: String? = null,
    val formatting: List<TextFormat>? = null,
    val canBlock: Boolean? = null
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
data class AttributionNote constructor(
    override val timestamp: Long? = null,
    override val blogName: String? = null,
    override val blogUuid: String? = null,
    override val blogUrl: String? = null,
    override val blogFollowed: Boolean? = null,
    override val avatarShape: String? = null,
    val postAttributionType: String? = null,
    val postAttributionTypeName: String? = null,
    val photoUrl: String? = null,
    val photoWidth: Int? = null,
    val photoHeight: Int? = null
) : NoteData() {
    companion object {
        const val KEY: String = "post_attribution"
    }
}
