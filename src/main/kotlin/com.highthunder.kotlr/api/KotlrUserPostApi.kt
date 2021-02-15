package com.highthunder.kotlr.api

import com.highthunder.kotlr.postbody.FollowPostBody
import com.highthunder.kotlr.postbody.LikePostBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

internal interface KotlrUserPostApi {
    /**
     * Follow a blog.
     *
     * @param followPostBody The request body.
     */
    @POST("user/follow")
    suspend fun followBlog(
        @Body
        followPostBody: FollowPostBody,
    )

    /**
     * Unfollow a blog.
     *
     * @param followPostBody The request body.
     */
    @POST("user/unfollow")
    suspend fun unfollowBlog(
        @Body
        followPostBody: FollowPostBody,
    )

    /**
     * Like a Post.
     *
     * @param likePostBody The request body.
     */
    @POST("user/like")
    suspend fun likePost(
        @Body
        likePostBody: LikePostBody,
    )

    /**
     * Unlike a Post.
     *
     * @param likePostBody The request body.
     */
    @POST("user/unlike")
    suspend fun unlikePost(
        @Body
        likePostBody: LikePostBody,
    )
}
