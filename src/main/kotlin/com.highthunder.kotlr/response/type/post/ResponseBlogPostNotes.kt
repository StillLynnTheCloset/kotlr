package com.highthunder.kotlr.response.type.post

import com.highthunder.kotlr.json.response.post.BlogPostNotesWrapperJsonAdapter
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.RequestLinks
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * ResponseBlogPostNotes - The response to a request for a post's notes.
 *
 * @author highthunder
 * @since 2019-12-01
 */
public interface ResponseBlogPostNotes {
    /**
     * Response - The top level object returned from Tumblr.
     *
     * @param meta An object containing any meta data returned from Tumblr, as well as some data returned in response headers.
     * @param response The actual response to the request, as a wrapper object to handle some types of errors from Tumblr.
     * @param errors An array of error objects, which are returned when some types of errors occur.
     */
    @JsonClass(generateAdapter = true)
    public data class Response constructor(
        @Json(name = "meta")
        override val meta: ResponseMetaInfo,
        @Json(name = "response")
        override val response: WrapperInterface<Body>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null,
    ) : TumblrResponse<Body>

    /**
     * Adapter is [BlogPostNotesWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    public data class Wrapper constructor(
        override val error: String? = null,
        override val body: Body? = null,
    ) : WrapperInterface<Body>

    /**
     * Body - The actual body of a successful response.
     *
     * @param links Additional links that you might be interested in.
     * @param notes An array of note objects, which may be formatted differently based on the mode and note type.
     * @param rollupNotes In "conversation" mode, this contains notes not listed in the notes array.
     * @param totalNotes The total notes, which can change depending on the mode.
     * @param totalLikes The total likes, when mode is conversation.
     * @param totalReblogs The total reblogs, when mode is conversation.
     * @param isSubscribed Whether or not the current user is subscribed to this post.
     * @param canSubscribe Whether or not the current user can subscribe to this post.
     * @param canHideOrDeleteNotes Whether or not the current user can edit notes on this post.
     * @param conversationalNotificationsEnabled Whether or not the current user has notifications enabled for this post.
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "_links")
        val links: RequestLinks? = null,
        val notes: List<NoteData>? = null,
        @Json(name = "rollup_notes")
        val rollupNotes: List<NoteData>? = null,
        @Json(name = "total_notes")
        val totalNotes: Long? = null,
        @Json(name = "total_likes")
        val totalLikes: Long? = null,
        @Json(name = "total_reblogs")
        val totalReblogs: Long? = null,
        @Json(name = "is_subscribed")
        val isSubscribed: Boolean? = null,
        @Json(name = "can_subscribe")
        val canSubscribe: Boolean? = null,
        @Json(name = "can_hide_or_delete_notes")
        val canHideOrDeleteNotes: Boolean? = null,
        @Json(name = "conversational_notifications_enabled")
        val conversationalNotificationsEnabled: Boolean? = null,
    )
}
