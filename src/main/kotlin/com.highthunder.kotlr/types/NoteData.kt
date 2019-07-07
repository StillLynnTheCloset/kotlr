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
    abstract var timestamp: Long?
    abstract var blogName: String?
    abstract var blogUuid: String?
    abstract var blogUrl: String?
    abstract var blogFollowed: Boolean?
    abstract var avatarShape: String?
}

/**
 * TODO: Documentation
 */
data class LikeNote constructor(
    override var timestamp: Long? = null,
    override var blogName: String? = null,
    override var blogUuid: String? = null,
    override var blogUrl: String? = null,
    override var blogFollowed: Boolean? = null,
    override var avatarShape: String? = null
) : NoteData() {
    companion object {
        const val KEY: String = "like"
    }
}

/**
 * TODO: Documentation
 */
data class PostedNote constructor(
    override var timestamp: Long? = null,
    override var blogName: String? = null,
    override var blogUuid: String? = null,
    override var blogUrl: String? = null,
    override var blogFollowed: Boolean? = null,
    override var avatarShape: String? = null
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
    override var timestamp: Long? = null,
    override var blogName: String? = null,
    override var blogUuid: String? = null,
    override var blogUrl: String? = null,
    override var blogFollowed: Boolean? = null,
    override var avatarShape: String? = null,
    var postId: String? = null,
    var reblogParentBlogName: String? = null
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
    override var timestamp: Long? = null,
    override var blogName: String? = null,
    override var blogUuid: String? = null,
    override var blogUrl: String? = null,
    override var blogFollowed: Boolean? = null,
    override var avatarShape: String? = null,
    var replyText: String? = null,
    var formatting: List<TextFormat>? = null,
    var canBlock: Boolean? = null
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
    override var timestamp: Long? = null,
    override var blogName: String? = null,
    override var blogUuid: String? = null,
    override var blogUrl: String? = null,
    override var blogFollowed: Boolean? = null,
    override var avatarShape: String? = null,
    var postAttributionType: String? = null,
    var postAttributionTypeName: String? = null,
    var photoUrl: String? = null,
    var photoWidth: Int? = null,
    var photoHeight: Int? = null
) : NoteData() {
    companion object {
        const val KEY: String = "post_attribution"
    }
}
