package com.highthunder.kotlr

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import com.highthunder.kotlr.types.Post
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KotlrApi {
    @GET("user/info")
    suspend fun getUserInfo(): ResponseUserInfo.Response

    @GET("user/likes")
    suspend fun getUserLikes(
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
    ): ResponseUserLikes.Response

    @GET("user/dashboard")
    suspend fun getUserDash(
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
    ): ResponseUserDashboard.Response

    @GET("user/following")
    suspend fun getUserFollowing(
        @Query("limit")
        limit: Int? = null,
        @Query("offset")
        offset: Long? = null
    ): ResponseUserFollowing.Response

    @GET("blog/{identifier}/avatar")
    suspend fun getBlogAvatar(
        @Path("identifier", encoded = true)
        identifier: String
    ): ResponseBlogAvatar.Response

    @GET("blog/{identifier}/avatar/{size}")
    suspend fun getBlogAvatar(
        @Path("identifier", encoded = true)
        identifier: String,
        @Path("size")
        size: Int
    ): ResponseBlogAvatar.Response

    @GET("blog/{identifier}/posts/draft")
    suspend fun getBlogDrafts(
        @Path("identifier", encoded = true)
        identifier: String,
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
    ): ResponseBlogDrafts.Response

    @GET("blog/{identifier}/followers")
    suspend fun getBlogFollowers(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("limit")
        limit: Int? = null,
        @Query("offset")
        offset: Int? = null
    ): ResponseBlogFollowers.Response

    @GET("blog/{identifier}/following")
    suspend fun getBlogFollowing(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("limit")
        limit: Int? = null,
        @Query("offset")
        offset: Int? = null
    ): ResponseBlogFollowing.Response

    @GET("blog/{identifier}/info")
    suspend fun getBlogInfo(
        @Path("identifier", encoded = true)
        identifier: String
    ): ResponseBlogInfo.Response

    @GET("blog/{identifier}/likes")
    suspend fun getBlogLikes(
        @Path("identifier", encoded = true)
        identifier: String,
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
    ): ResponseBlogLikes.Response

    @GET("blog/{identifier}/posts")
    suspend fun getBlogPosts(
        @Path("identifier", encoded = true)
        identifier: String,
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
    ): ResponseBlogPosts.Response

    @GET("blog/{identifier}/posts/queue")
    suspend fun getBlogQueue(
        @Path("identifier", encoded = true)
        identifier: String,
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
    ): ResponseBlogQueue.Response

    @GET("blog/{identifier}/posts/submission")
    suspend fun getBlogSubmissions(
        @Path("identifier", encoded = true)
        identifier: String,
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
    ): ResponseBlogSubmissions.Response
}
