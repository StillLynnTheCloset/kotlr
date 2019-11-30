package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import com.highthunder.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface KotlrUserApi {
    @GET("user/info")
    suspend fun getUserInfoHelper(): Response<ResponseUserInfo.Response>

    @GET("user/likes")
    suspend fun getUserLikesHelper(
        @Query("limit")
        postLimit: Int? = null,
        @Query("offset")
        postOffset: Long? = null,
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
        pageNumber: Int? = null
    ): Response<ResponseUserLikes.Response>

    @GET("user/dashboard")
    suspend fun getUserDashHelper(
        @Query("limit")
        postLimit: Int? = null,
        @Query("offset")
        postOffset: Long? = null,
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
        type: Post.Type? = null
    ): Response<ResponseUserDashboard.Response>

    @GET("user/following")
    suspend fun getUserFollowingHelper(
        @Query("limit")
        limit: Int? = null,
        @Query("offset")
        offset: Long? = null
    ): Response<ResponseUserFollowing.Response>
}
