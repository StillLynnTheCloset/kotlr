package com.highthunder.kotlr.api

import retrofit2.http.POST
import retrofit2.http.Query

internal interface KotlrUserPostApi {

    /**
     * Follow a blog.
     *
     * @param identifier The URL of the blog to follow.
     */
    @POST("user/follow")
    suspend fun followBlog(
        @Query("url")
        identifier: String
    )

    /**
     * Unfollow a blog.
     *
     * @param identifier The URL of the blog to unfollow.
     */
    @POST("user/unfollow")
    suspend fun unfollowBlog(
        @Query("url")
        identifier: String
    )

    /**
     * Like a Post.
     *
     * @param postId The ID of the post to like.
     * @param reblogKey The reblog key for the post id.
     */
    @POST("user/like")
    suspend fun likePost(
        @Query("id")
        postId: Long,
        @Query("reblog_key")
        reblogKey: String
    )

    /**
     * Unlike a Post.
     *
     * @param postId The ID of the post to unlike.
     * @param reblogKey The reblog key for the post id.
     */
    @POST("user/unlike")
    suspend fun unlikePost(
        @Query("id")
        postId: Long,
        @Query("reblog_key")
        reblogKey: String
    )
}
