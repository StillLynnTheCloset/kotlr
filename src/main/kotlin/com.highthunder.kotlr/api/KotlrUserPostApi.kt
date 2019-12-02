package com.highthunder.kotlr.api

import retrofit2.http.POST
import retrofit2.http.Query

interface KotlrUserPostApi {

    @POST("user/follow")
    suspend fun followBlog(
        @Query("url")
        identifier: String
    )

    @POST("user/unfollow")
    suspend fun unfollowBlog(
        @Query("url")
        identifier: String
    )

    @POST("user/like")
    suspend fun likePost(
        @Query("id")
        postId: Long,
        @Query("reblog_key")
        reblogKey: String
    )

    @POST("user/unlike")
    suspend fun unlikePost(
        @Query("id")
        postId: Long,
        @Query("reblog_key")
        reblogKey: String
    )
}
