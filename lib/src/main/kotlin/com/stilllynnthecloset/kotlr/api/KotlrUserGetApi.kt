package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollowing
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserInfo
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLikes
import com.stilllynnthecloset.kotlr.types.Post

public interface KotlrUserGetApi {
    /**
     * Use this method to retrieve the user's account information that matches the OAuth credentials submitted with the request.
     */
    public suspend fun getUserInfo(): ResponseUserInfo.Response?

    /**
     * Use this method to retrieve the liked posts that match the OAuth credentials submitted with the request.
     *
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts liked after the specified timestamp.
     * @param beforeTime Optional. Retrieve posts liked before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getUserLikes(
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
    ): ResponseUserLikes.Response?

    /**
     * Use this method to retrieve the dashboard that matches the OAuth credentials submitted with the request.
     *
     * ⚠️ Note: Please don't re-implement the Dashboard, and don't recreate complete Tumblr functions or clients on a
     * platform where Tumblr already has an official client. See our API policies here.
     *
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     * @param type Optional. The type of post to return. Specify one of the following: text, photo, quote, link, chat, audio, video, answer
     */
    public suspend fun getUserDash(
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
        type: Post.Type? = null,
    ): ResponseUserDashboard.Response?

    /**
     * Use this method to retrieve the blogs followed by the user whose OAuth credentials are submitted with the request.
     *
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Result number to start at
     */
    public suspend fun getUserFollowing(
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseUserFollowing.Response?

    /**
     * Use this method to retrieve the content filtering strings of the user whose OAuth credentials are submitted with the request.
     */
    public suspend fun getContentFilters(): ResponseUserFilteredContent.Response?
}
