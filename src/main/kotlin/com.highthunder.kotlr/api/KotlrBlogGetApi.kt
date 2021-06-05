package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogBlocks
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowedBy
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogNotifications
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import com.highthunder.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface KotlrBlogGetApi {
    @GET("blog/{identifier}/avatar")
    suspend fun getBlogAvatar(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
    ): Response<ResponseBlogAvatar.Response>

    @GET("blog/{identifier}/avatar/{size}")
    suspend fun getBlogAvatar(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Path("size")
        size: Int,
    ): Response<ResponseBlogAvatar.Response>

    @GET("blog/{identifier}/posts/draft")
    suspend fun getBlogDrafts(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
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
    ): Response<ResponseBlogDrafts.Response>

    @GET("blog/{identifier}/followers")
    suspend fun getBlogFollowers(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("limit")
        pagingLimit: Int? = null,
        @Query("offset")
        pagingOffset: Long? = null,
    ): Response<ResponseBlogFollowers.Response>

    @GET("blog/{identifier}/following")
    suspend fun getBlogFollowing(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("limit")
        pagingLimit: Int? = null,
        @Query("offset")
        pagingOffset: Long? = null,
    ): Response<ResponseBlogFollowing.Response>

    @GET("blog/{identifier}/followed_by")
    suspend fun getBlogFollowedBy(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("query")
        query: String,
    ): Response<ResponseBlogFollowedBy.Response>

    @GET("blog/{identifier}/info")
    suspend fun getBlogInfo(
        @Path("identifier", encoded = true)
        blogIdentifier: String
    ): Response<ResponseBlogInfo.Response>

    @GET("blog/{identifier}/likes")
    suspend fun getBlogLikes(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
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
    ): Response<ResponseBlogLikes.Response>

    @GET("blog/{identifier}/posts")
    suspend fun getBlogPosts(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
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
    ): Response<ResponseBlogPosts.Response>

    @GET("blog/{identifier}/posts/queue")
    suspend fun getBlogQueue(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
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
    ): Response<ResponseBlogQueue.Response>

    @GET("blog/{identifier}/posts/submission")
    suspend fun getBlogSubmissions(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
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
    ): Response<ResponseBlogSubmissions.Response>

    @GET("blog/{identifier}/blocks")
    suspend fun getBlogBlocks(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("limit")
        pagingLimit: Int? = null,
        @Query("offset")
        pagingOffset: Long? = null,
    ): Response<ResponseBlogBlocks.Response>

    @GET("blog/{identifier}/notifications")
    suspend fun getNotifications(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("before")
        before: Long? = null,
        @Query("types")
        types: List<String>? = null,
    ): Response<ResponseBlogNotifications.Response>
}
