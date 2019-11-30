package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import com.highthunder.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface KotlrBlogApi {
    @GET("blog/{identifier}/avatar")
    suspend fun getBlogAvatarHelper(
        @Path("identifier", encoded = true)
        identifier: String
    ): Response<ResponseBlogAvatar.Response>

    @GET("blog/{identifier}/avatar/{size}")
    suspend fun getBlogAvatarHelper(
        @Path("identifier", encoded = true)
        identifier: String,
        @Path("size")
        size: Int
    ): Response<ResponseBlogAvatar.Response>

    @GET("blog/{identifier}/posts/draft")
    suspend fun getBlogDraftsHelper(
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
    ): Response<ResponseBlogDrafts.Response>

    @GET("blog/{identifier}/followers")
    suspend fun getBlogFollowersHelper(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("limit")
        limit: Int? = null,
        @Query("offset")
        offset: Int? = null
    ): Response<ResponseBlogFollowers.Response>

    @GET("blog/{identifier}/following")
    suspend fun getBlogFollowingHelper(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("limit")
        limit: Int? = null,
        @Query("offset")
        offset: Int? = null
    ): Response<ResponseBlogFollowing.Response>

    @GET("blog/{identifier}/info")
    suspend fun getBlogInfoHelper(
        @Path("identifier", encoded = true)
        identifier: String
    ): Response<ResponseBlogInfo.Response>

    @GET("blog/{identifier}/likes")
    suspend fun getBlogLikesHelper(
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
    ): Response<ResponseBlogLikes.Response>

    @GET("blog/{identifier}/posts")
    suspend fun getBlogPostsHelper(
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
    ): Response<ResponseBlogPosts.Response>

    @GET("blog/{identifier}/posts/queue")
    suspend fun getBlogQueueHelper(
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
    ): Response<ResponseBlogQueue.Response>

    @GET("blog/{identifier}/posts/submission")
    suspend fun getBlogSubmissionsHelper(
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
    ): Response<ResponseBlogSubmissions.Response>
}
