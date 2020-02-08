package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.type.post.ResponsePostsPost
import com.highthunder.kotlr.response.type.post.ResponsePostsTagged
import com.highthunder.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KotlrPostsGetApi {
    @GET("tagged")
    suspend fun getTaggedPosts(
        @Query("tag")
        tag: String,
        @Query("before")
        before: Long? = null,
        @Query("limit")
        limit: Long? = null,
        @Query("filter")
        filter: String? = null
    ): Response<ResponsePostsTagged.Response>

    @GET("blog/{identifier}/posts/{postId}")
    suspend fun getPost(
        @Path("identifier", encoded = true)
        identifier: String,
        @Path("postId", encoded = true)
        postId: Long,
        @Query("post_format")
        postFormat: Post.PostVersion? = null
    ): Response<ResponsePostsPost.Response>
}
