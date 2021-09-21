package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.postbody.FilteredContentPostBody
import com.stilllynnthecloset.kotlr.postbody.FollowPostBody
import com.stilllynnthecloset.kotlr.postbody.LikePostBody
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollow
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLike
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

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
    ): Response<ResponseUserFollow.Response>

    /**
     * Unfollow a blog.
     *
     * @param followPostBody The request body.
     */
    @POST("user/unfollow")
    suspend fun unfollowBlog(
        @Body
        followPostBody: FollowPostBody,
    ): Response<ResponseUserFollow.Response>

    /**
     * Like a Post.
     *
     * @param likePostBody The request body.
     */
    @POST("user/like")
    suspend fun likePost(
        @Body
        likePostBody: LikePostBody,
    ): Response<ResponseUserLike.Response>

    /**
     * Unlike a Post.
     *
     * @param likePostBody The request body.
     */
    @POST("user/unlike")
    suspend fun unlikePost(
        @Body
        likePostBody: LikePostBody,
    ): Response<ResponseUserLike.Response>

    /**
     * Add to your current post filters.
     *
     * @param filteredContent The string to filter.
     */
    @POST("user/filtered_content")
    suspend fun addContentFilter(
        @Body
        filteredContent: FilteredContentPostBody,
    ): Response<ResponseUserLike.Response>
}
