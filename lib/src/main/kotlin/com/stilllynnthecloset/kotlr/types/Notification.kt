package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.PolymorphicJsonAdapterFactory

public sealed class Notification {
    internal companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(Notification::class.java, "type")
            .withDefaultValue(UnknownNotification())
            .withSubtype(LikeNotification::class.java, LikeNotification.KEY)
            .withSubtype(ReplyNotification::class.java, ReplyNotification.KEY)
            .withSubtype(FollowerNotification::class.java, FollowerNotification.KEY)
            .withSubtype(MentionInReplyNotification::class.java, MentionInReplyNotification.KEY)
            .withSubtype(MentionInPostNotification::class.java, MentionInPostNotification.KEY)
            .withSubtype(ReblogWithoutContentNotification::class.java, ReblogWithoutContentNotification.KEY)
            .withSubtype(ReblogWithContentNotification::class.java, ReblogWithContentNotification.KEY)
            .withSubtype(AskNotification::class.java, AskNotification.KEY)
            .withSubtype(AnsweredAskNotification::class.java, AnsweredAskNotification.KEY)
            .withSubtype(NewGroupBlogMemberNotification::class.java, NewGroupBlogMemberNotification.KEY)
            .withSubtype(PostAttributionNotification::class.java, PostAttributionNotification.KEY)
            .withSubtype(PostFlaggedNotification::class.java, PostFlaggedNotification.KEY)
            .withSubtype(PostAppealAcceptedNotification::class.java, PostAppealAcceptedNotification.KEY)
            .withSubtype(PostAppealRejectedNotification::class.java, PostAppealRejectedNotification.KEY)
            .withSubtype(WhatYouMissedNotification::class.java, WhatYouMissedNotification.KEY)
            .withSubtype(ConversationalNoteNotification::class.java, ConversationalNoteNotification.KEY)
            .withSubtype(SpamReportedNotification::class.java, SpamReportedNotification.KEY)
            .withSubtype(UserMentionNotification::class.java, UserMentionNotification.KEY)
            .withSubtype(UnknownNotification::class.java, UnknownNotification.KEY)
    }

    internal abstract val type: String?
    internal abstract val timestamp: Long?
    internal abstract val before: Long?
    internal abstract val targetPostId: String?
    internal abstract val targetPostSummary: String?
    internal abstract val targetTumblelogName: String?
    internal abstract val targetTumblelogUuid: String?
}

public interface PostNotification {
    public val targetRootPostId: String?
    public val privateChannel: Boolean?
    public val targetPostType: String?
    public val postType: String?
    public val reblogKey: String?
    public val mediaUrl: String?
    public val mediaUrlLarge: String?
}

public interface FromBlogNotification {
    public val fromTumblelogName: String?
    public val fromTumblelogUuid: String?
    public val fromTumblelogIsAdult: Boolean?
    public val followed: Boolean?
}

@JsonClass(generateAdapter = true)
public data class LikeNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "like"
    }
}

@JsonClass(generateAdapter = true)
public data class ReplyNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "reply"
    }
}

@JsonClass(generateAdapter = true)
public data class FollowerNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "follower"
    }
}

@JsonClass(generateAdapter = true)
public data class MentionInReplyNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "mention_in_reply"
    }
}

@JsonClass(generateAdapter = true)
public data class MentionInPostNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "mention_in_post"
    }
}

@JsonClass(generateAdapter = true)
public data class ReblogWithoutContentNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
    @Json(name = "post_id")
    val postId: String? = null,
    @Json(name = "post_tags")
    val postTags: List<String>? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "reblog_naked"
    }
}

@JsonClass(generateAdapter = true)
public data class ReblogWithContentNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
    @Json(name = "post_id")
    val postId: String? = null,
    @Json(name = "added_text")
    val addedText: String? = null,
    @Json(name = "post_tags")
    val postTags: List<String>? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "reblog"
    }
}

@JsonClass(generateAdapter = true)
public data class AskNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "ask"
    }
}

@JsonClass(generateAdapter = true)
public data class AnsweredAskNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "answered_ask"
    }
}

@JsonClass(generateAdapter = true)
public data class NewGroupBlogMemberNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "new_group_blog_member"
    }
}

@JsonClass(generateAdapter = true)
public data class PostAttributionNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "post_attribution"
    }
}

@JsonClass(generateAdapter = true)
public data class PostFlaggedNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "post_flagged"
    }
}

@JsonClass(generateAdapter = true)
public data class PostAppealAcceptedNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "post_appeal_accepted"
    }
}

@JsonClass(generateAdapter = true)
public data class PostAppealRejectedNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "post_appeal_rejected"
    }
}

@JsonClass(generateAdapter = true)
public data class WhatYouMissedNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "what_you_missed"
    }
}

@JsonClass(generateAdapter = true)
public data class ConversationalNoteNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "conversational_note"
    }
}

@JsonClass(generateAdapter = true)
public data class SpamReportedNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
) : Notification(), FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "spam_reported"
    }
}

@JsonClass(generateAdapter = true)
public data class UserMentionNotification constructor(
    override val type: String = KEY,
    override val timestamp: Long? = null,
    override val before: Long? = null,
    @Json(name = "target_post_id")
    override val targetPostId: String? = null,
    @Json(name = "target_post_summary")
    override val targetPostSummary: String? = null,
    @Json(name = "target_tumblelog_name")
    override val targetTumblelogName: String? = null,
    @Json(name = "target_tumblelog_uuid")
    override val targetTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_name")
    override val fromTumblelogName: String? = null,
    @Json(name = "from_tumblelog_uuid")
    override val fromTumblelogUuid: String? = null,
    @Json(name = "from_tumblelog_is_adult")
    override val fromTumblelogIsAdult: Boolean? = null,
    override val followed: Boolean? = null,
    @Json(name = "target_root_post_id")
    override val targetRootPostId: String? = null,
    @Json(name = "private_channel")
    override val privateChannel: Boolean? = null,
    @Json(name = "target_post_type")
    override val targetPostType: String? = null,
    @Json(name = "post_type")
    override val postType: String? = null,
    @Json(name = "reblog_key")
    override val reblogKey: String? = null,
    @Json(name = "media_url")
    override val mediaUrl: String? = null,
    @Json(name = "media_url_large")
    override val mediaUrlLarge: String? = null,
    @Json(name = "post_id")
    val postId: String? = null,
    @Json(name = "can_reply")
    val canReply: Boolean? = null,
) : Notification(), PostNotification, FromBlogNotification {
    internal companion object {
        internal const val KEY: String = "user_mention"
    }
}

@JsonClass(generateAdapter = true)
public class UnknownNotification : Notification() {
    internal companion object {
        internal const val KEY: String = "unknown"
    }
    override val type: String = KEY
    override val timestamp: Long? = null
    override val before: Long? = null
    override val targetPostId: String? = null
    override val targetPostSummary: String? = null
    override val targetTumblelogName: String? = null
    override val targetTumblelogUuid: String? = null
}
