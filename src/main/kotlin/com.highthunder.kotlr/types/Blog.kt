package com.highthunder.kotlr.types

import com.highthunder.kotlr.json.wrapper.ThemeWrapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Blog - A simple tumblog.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param name The short name of the blog.
 * @param url The URL of the blog.
 * @param title The title of the blog.
 * @param primary Indicates if this is the user's primary blog.
 * @param followers The total count of followers for this blog.
 * @param tweet Indicates if posts are tweeted auto, Y, N.
 * @param facebook Indicates if posts are sent to facebook Y, N.
 * @param type Indicates whether a blog is public or private.
 * @param updated The time of the most recent post, in seconds since the epoch.
 * @param description The description of the blog.
 * @param ask Indicates whether the blog allows questions.
 * @param askAnon Indicates whether the blog allows anonymous questions.
 * @param posts The total number of posts on this blog.
 * @param likes Number of likes for this user.
 * @param isBlockedFromPrimary Indicates whether this blog has been blocked by the calling user's primary blog.
 * @param uuid A unique identifier for this blog.
 * @param askPageTitle The title to display on this blog's ask page, often a prompt.
 * @param submissionPageTitle The title to display on this blog's submission page, often a prompt.
 * @param active Indicates whether or not this blog is active, i.e. the owner has not deactivated it.
 * @param canSubmit Indicates whether or not this blog accepts submissions.
 * @param isNsfw Indicates whether or not this blog features adult content.
 * @param sharesLikes Indicates whether or not this blog publicly shares its liked posts.
 * @param subscribed Indicates whether or not the current user is subscribed to this blog.
 * @param canSubscribe Indicates whether or not the current user can subscribe to this blog.
 * @param following Indicates whether or not the current user follows this blog.
 * @param canSendFanMail Indicates whether or not this blog accepts fan mail.
 * @param theme The theme for this blog, there is currently no good way to actually query this.
 * @param admin Indicates whether or not the current user is an admin of this blog.
 * @param drafts Indicates the current number of drafts for this blog.
 * @param messages Indicates the current number of messages for this blog.
 * @param queue Indicates the current number of queued posts for this blog.
 * @param facebookOpenGraphEnabled Unknown.
 * @param twitterEnabled Unknown.
 * @param twitterSend Unknown.
 * @param isOptOutAds Unknown.
 *
 * @param submissionTerms TODO: Documentation
 * @param followed TODO: Documentation
 * @param totalPosts TODO: Documentation
 * @param shareFollowing TODO: Documentation
 * @param canBeFollowed TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class Blog constructor(
    @Json(name = "name")
    var name: String = "",
    @Json(name = "url")
    var url: String = "",
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "primary")
    var primary: Boolean? = null,
    @Json(name = "followers")
    var followers: Int? = null,
    @Json(name = "tweet")
    var tweet: String? = null,
    @Json(name = "facebook")
    var facebook: String? = null,
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "updated")
    var updated: Long? = null,
    @Json(name = "description")
    var description: String? = null,
    @Json(name = "ask")
    var ask: Boolean? = null,
    @Json(name = "ask_anon")
    var askAnon: Boolean? = null,
    @Json(name = "posts")
    var posts: Int? = null,
    @Json(name = "likes")
    var likes: Int? = null,
    @Json(name = "is_blocked_from_primary")
    var isBlockedFromPrimary: Boolean? = null,
    @Json(name = "uuid")
    var uuid: String? = null,
    @Json(name = "ask_page_title")
    var askPageTitle: String? = null,
    @Json(name = "submission_page_title")
    var submissionPageTitle: String? = null,
    @Json(name = "active")
    var active: Boolean? = null,
    @Json(name = "can_submit")
    var canSubmit: Boolean? = null,
    @Json(name = "is_nsfw")
    var isNsfw: Boolean? = null,
    @Json(name = "share_likes")
    var sharesLikes: Boolean? = null,
    @Json(name = "subscribed")
    var subscribed: Boolean? = null,
    @Json(name = "can_subscribe")
    var canSubscribe: Boolean? = null,
    @Json(name = "following")
    var following: Boolean? = null,
    @Json(name = "can_send_fan_mail")
    var canSendFanMail: Boolean? = null,
    @Json(name = "theme")
    var theme: ThemeWrapper? = null,
    @Json(name = "admin")
    var admin: Boolean? = null,
    @Json(name = "drafts")
    var drafts: Int? = null,
    @Json(name = "messages")
    var messages: Int? = null,
    @Json(name = "queue")
    var queue: Int? = null,
    @Json(name = "facebook_opengraph_enabled")
    var facebookOpenGraphEnabled: String? = null,
    @Json(name = "twitter_enabled")
    var twitterEnabled: Boolean? = null,
    @Json(name = "twitter_send")
    var twitterSend: Boolean? = null,
    @Json(name = "is_optout_ads")
    var isOptOutAds: Boolean? = null,
    @Json(name = "submission_terms")
    var submissionTerms: SubmissionTerms? = null,
    @Json(name = "followed")
    var followed: Boolean? = null,
    @Json(name = "total_posts")
    var totalPosts: Int? = null,
    @Json(name = "share_following")
    var shareFollowing: Boolean? = null,
    @Json(name = "can_be_followed")
    var canBeFollowed: Boolean? = null,
    @Json(name = "can_chat")
    var canChat: Boolean? = null
)
