package com.highthunder.kotlr.types

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
sealed class NoteData(
    var timestamp: Long? = null,
    var blogName: String? = null,
    var blogUuid: String? = null,
    var blogUrl: String? = null,
    var blogFollowed: Boolean? = null,
    var avatarShape: String? = null
) {

    /**
     * TODO: Documentation
     */
    class Like(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            /**
             * TODO: Documentation
             */
            const val KEY: String = "like"
        }
    }

    /**
     * TODO: Documentation
     */
    class Posted(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            /**
             * TODO: Documentation
             */
            const val KEY: String = "posted"
        }
    }

    /**
     * TODO: Documentation
     *
     * @param postId TODO: Documentation
     * @param reblogParentBlogName TODO: Documentation
     */
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
            /**
             * TODO: Documentation
             */
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
    class Reply(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null,
        var replyText: String? = null,
        var formatting: List<Boolean>? = null,
        var canBlock: Boolean? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            /**
             * TODO: Documentation
             */
            const val KEY: String = "reply"
        }
    }

    /**
     * TODO: Documentation
     */
    class Attribution(
        timestamp: Long? = null,
        blogName: String? = null,
        blogUuid: String? = null,
        blogUrl: String? = null,
        blogFollowed: Boolean? = null,
        avatarShape: String? = null
    ) : NoteData(timestamp, blogName, blogUuid, blogUrl, blogFollowed, avatarShape) {
        companion object {
            /**
             * TODO: Documentation
             */
            const val KEY: String = "post_attribution"
        }
    }

}
