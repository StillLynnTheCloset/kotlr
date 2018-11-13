package com.highthunder.kotlr.types

/**
 * NoteData - TODO: Documentation
 *
 * @author highthunder
 * @since 11/3/18
 * @version 1.0.0
 */
sealed class NoteData(
    var timestamp: Long? = null,
    var blogName: String? = null,
    var blogUuid: String? = null,
    var blogUrl: String? = null,
    var blogFollowed: Boolean? = null,
    var avatarShape: String? = null
) {

    class Like(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            const val KEY: String = "like"
        }
    }

    class Posted(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            const val KEY: String = "posted"
        }
    }

    class Reblog(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null,
        var postId: String? = null,
        var reblogParentBlogName: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            const val KEY: String = "reblog"
        }
    }

    class Reply(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null,
        var reply_text: String? = null,
        var formatting: List<Boolean>? = null,
        var can_block: Boolean? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            const val KEY: String = "reply"
        }
    }

    class Attribution(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            const val KEY: String = "post_attribution"
        }
    }

}
