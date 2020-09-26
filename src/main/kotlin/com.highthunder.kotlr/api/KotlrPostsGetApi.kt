package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.type.post.ResponsePostNotes
import com.highthunder.kotlr.response.type.post.ResponsePostsPost
import com.highthunder.kotlr.response.type.post.ResponsePostsTagged
import com.highthunder.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface KotlrPostsGetApi {
    @GET("tagged")
    suspend fun getTaggedPosts(
        @Query("tag")
        tag: String,
        @Query("before")
        before: Long? = null,
        @Query("limit")
        limit: Long? = null,
        @Query("filter")
        filter: Post.PostFormat? = null,
    ): Response<ResponsePostsTagged.Response>

    @GET("blog/{identifier}/posts/{postId}")
    suspend fun getPost(
        @Path("identifier", encoded = true)
        identifier: String,
        @Path("postId", encoded = true)
        postId: Long,
        @Query("post_format")
        postFormat: String? = null,
    ): Response<ResponsePostsPost.Response>

    @GET("blog/{identifier}/notes")
    suspend fun getPostNotes(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("id")
        postId: Long,
        @Query("before_timestamp")
        beforeTimestamp: Long? = null,
        @Query("mode")
        mode: Post.NotesMode? = null,
    ): Response<ResponsePostNotes.Response>
}
