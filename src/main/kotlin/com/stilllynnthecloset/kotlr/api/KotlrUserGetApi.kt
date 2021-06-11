package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollowing
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserInfo
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLikes
import com.stilllynnthecloset.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface KotlrUserGetApi {
    @GET("user/info")
    suspend fun getUserInfo(): Response<ResponseUserInfo.Response>

    @GET("user/likes")
    suspend fun getUserLikes(
        @Query("limit")
        pagingLimit: Int? = null,
        @Query("offset")
        pagingOffset: Long? = null,
        @Query("since_id")
        afterPostId: Long? = null,
        @Query("before_id")
        beforePostId: Long? = null,
        @Query("after")
        afterTime: Long? = null,
        @Query("before")
        beforeTime: Long? = null,
        @Query("reblog_info")
        getReblogFields: Boolean? = null,
        @Query("notes_info")
        getNotesHistory: Boolean? = null,
        @Query("npf")
        useNeuePostFormat: Boolean? = null,
        @Query("tag")
        tag: String? = null,
        @Query("page_number")
        pageNumber: Int? = null,
    ): Response<ResponseUserLikes.Response>

    @GET("user/dashboard")
    suspend fun getUserDash(
        @Query("limit")
        pagingLimit: Int? = null,
        @Query("offset")
        pagingOffset: Long? = null,
        @Query("since_id")
        afterPostId: Long? = null,
        @Query("before_id")
        beforePostId: Long? = null,
        @Query("after")
        afterTime: Long? = null,
        @Query("before")
        beforeTime: Long? = null,
        @Query("reblog_info")
        getReblogFields: Boolean? = null,
        @Query("notes_info")
        getNotesHistory: Boolean? = null,
        @Query("npf")
        useNeuePostFormat: Boolean? = null,
        @Query("tag")
        tag: String? = null,
        @Query("page_number")
        pageNumber: Int? = null,
        @Query("type")
        type: Post.Type? = null,
    ): Response<ResponseUserDashboard.Response>

    @GET("user/following")
    suspend fun getUserFollowing(
        @Query("limit")
        pagingLimit: Int? = null,
        @Query("offset")
        pagingOffset: Long? = null,
    ): Response<ResponseUserFollowing.Response>

    /**
     * Get the current user's content filtering.
     */
    @GET("user/filtered_content")
    suspend fun getContentFilters(): Response<ResponseUserFilteredContent.Response>
}
