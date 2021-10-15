package com.stilllynnthecloset.kotlr.types

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.wrapper.ThemeWrapper

/**
 * Blog - A simple tumblog.
 *
 * @author highthunder
 * @since 2018-11-04
 *
 * @param name The short name of the blog.
 * @param url The URL of the blog.
 * @param title The title of the blog.
 * @param primary Whether this is the user's primary blog.
 * @param followers The total count of followers for this blog.
 * @param tweet Whether posts are tweeted auto, Y, N.
 * @param facebook Whether posts are sent to facebook Y, N.
 * @param type Whether a blog is public or private.
 * @param updated The time of the most recent post, in seconds since the epoch.
 * @param description The description of the blog.
 * @param ask Whether the blog allows questions.
 * @param askAnon Whether the blog allows anonymous questions.
 * @param posts The total number of posts on this blog.
 * @param likes Number of likes for this user.
 * @param isBlockedFromPrimary Whether this blog has been blocked by the calling user's primary blog.
 * @param uuid A unique identifier for this blog.
 * @param askPageTitle The title to display on this blog's ask page, often a prompt.
 * @param asksAllowMedia Whether asks allow uploading additional media.
 * @param submissionPageTitle The title to display on this blog's submission page, often a prompt.
 * @param active Whether this blog is active, i.e. the owner has not deactivated it.
 * @param canSubmit Whether this blog accepts submissions.
 * @param isNsfw Whether this blog features adult content.
 * @param sharesLikes Whether this blog publicly shares its liked posts.
 * @param subscribed Whether the current user is subscribed to this blog.
 * @param canSubscribe Whether the current user can subscribe to this blog.
 * @param following Whether the current user follows this blog.
 * @param canSendFanMail Whether this blog accepts fan mail.
 * @param theme The theme for this blog, there is currently no good way to actually query this.
 * @param admin Whether the current user is an admin of this blog.
 * @param drafts Indicates the current number of drafts for this blog.
 * @param messages Indicates the current number of messages for this blog.
 * @param queue Indicates the current number of queued posts for this blog.
 * @param facebookOpenGraphEnabled TODO: Documentation.
 * @param twitterEnabled TODO: Documentation.
 * @param twitterSend TODO: Documentation.
 * @param isOptOutAds TODO: Documentation.
 * @param submissionTerms Specification of requirements when submitting posts to this blog.
 * @param followed Whether you have followed this blog.
 * @param totalPosts The total number of posts that this blog has made.
 * @param shareFollowing Whether this blog shares who they are following.
 * @param canBeFollowed Whether you can follow this blog.
 * @param canChat Whether you can chat with this blog.
 * @param avatar A list of images representing the different sizes of this blog's avatar.
 * @param blockedTimestamp The time at which you blocked this blog.
 * @param timezone The blog's configured timezone, such as "US/Eastern". Only viewable by blog member.
 * @param timezoneOffset The blog's configured timezone as a GMT offset such as "GMT+0800". Only viewable by blog member.
 */
@JsonClass(generateAdapter = true)
public data class Blog constructor(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "url")
    val url: String = "",
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "primary")
    val primary: Boolean? = null,
    @Json(name = "followers")
    val followers: Int? = null,
    @Json(name = "tweet")
    val tweet: String? = null,
    @Json(name = "facebook")
    val facebook: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "updated")
    val updated: Long? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "ask")
    val ask: Boolean? = null,
    @Json(name = "ask_anon")
    val askAnon: Boolean? = null,
    @Json(name = "posts")
    val posts: Int? = null,
    @Json(name = "likes")
    val likes: Int? = null,
    @Json(name = "is_blocked_from_primary")
    val isBlockedFromPrimary: Boolean? = null,
    @Json(name = "uuid")
    val uuid: String? = null,
    @Json(name = "ask_page_title")
    val askPageTitle: String? = null,
    @Json(name = "asks_allow_media")
    val asksAllowMedia: Boolean? = null,
    @Json(name = "submission_page_title")
    val submissionPageTitle: String? = null,
    @Json(name = "active")
    val active: Boolean? = null,
    @Json(name = "can_submit")
    val canSubmit: Boolean? = null,
    @Json(name = "is_nsfw")
    val isNsfw: Boolean? = null,
    @Json(name = "share_likes")
    val sharesLikes: Boolean? = null,
    @Json(name = "subscribed")
    val subscribed: Boolean? = null,
    @Json(name = "can_subscribe")
    val canSubscribe: Boolean? = null,
    @Json(name = "following")
    val following: Boolean? = null,
    @Json(name = "can_send_fan_mail")
    val canSendFanMail: Boolean? = null,
    @Json(name = "theme")
    val theme: ThemeWrapper? = null,
    @Json(name = "admin")
    val admin: Boolean? = null,
    @Json(name = "drafts")
    val drafts: Int? = null,
    @Json(name = "messages")
    val messages: Int? = null,
    @Json(name = "queue")
    val queue: Int? = null,
    @Json(name = "facebook_opengraph_enabled")
    val facebookOpenGraphEnabled: String? = null,
    @Json(name = "twitter_enabled")
    val twitterEnabled: Boolean? = null,
    @Json(name = "twitter_send")
    val twitterSend: Boolean? = null,
    @Json(name = "is_optout_ads")
    val isOptOutAds: Boolean? = null,
    @Json(name = "submission_terms")
    val submissionTerms: SubmissionTerms? = null,
    @Json(name = "followed")
    val followed: Boolean? = null,
    @Json(name = "total_posts")
    val totalPosts: Int? = null,
    @Json(name = "share_following")
    val shareFollowing: Boolean? = null,
    @Json(name = "can_be_followed")
    val canBeFollowed: Boolean? = null,
    @Json(name = "can_chat")
    val canChat: Boolean? = null,
    @Json(name = "avatar")
    val avatar: List<Media>? = null,
    @Json(name = "blocked_timestamp")
    val blockedTimestamp: Long? = null,
    @Json(name = "timezone")
    val timezone: String? = null,
    @Json(name = "timezone_offset")
    val timezoneOffset: String? = null,
)
