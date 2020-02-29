package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.RateLimitMetaData
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import com.highthunder.kotlr.response.type.post.ResponsePostsPost
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import com.highthunder.kotlr.types.Post

class KotlrApi internal constructor(
    private val userGetApi: KotlrUserGetApi,
    private val blogGetApi: KotlrBlogGetApi,
    private val userPostApi: KotlrUserPostApi,
    private val blogPostApi: KotlrBlogPostApi,
    private val postsGetApi: KotlrPostsGetApi
) : KotlrUserPostApi by userPostApi, KotlrBlogPostApi by blogPostApi {
    // region User Getters

    suspend fun getUserInfo(): ResponseUserInfo.Response? {
        val retrofitResponse = userGetApi.getUserInfoHelper()
        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getUserLikes(
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseUserLikes.Response? {
        val retrofitResponse = userGetApi.getUserLikesHelper(
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getUserDash(
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
        type: Post.Type? = null
    ): ResponseUserDashboard.Response? {
        val retrofitResponse = userGetApi.getUserDashHelper(
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber,
            type
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getUserFollowing(
        limit: Int? = null,
        offset: Long? = null
    ): ResponseUserFollowing.Response? {
        val retrofitResponse = userGetApi.getUserFollowingHelper(
            limit,
            offset
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion User Getters

    // region Blog Getters

    suspend fun getBlogAvatar(
        identifier: String
    ): ResponseBlogAvatar.Response? {
        val retrofitResponse = blogGetApi.getBlogAvatarHelper(
            identifier
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogAvatar(
        identifier: String,
        size: Int
    ): ResponseBlogAvatar.Response? {
        val retrofitResponse = blogGetApi.getBlogAvatarHelper(
            identifier,
            size
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogDrafts(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogDrafts.Response? {
        val retrofitResponse = blogGetApi.getBlogDraftsHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogFollowers(
        identifier: String,
        limit: Int? = null,
        offset: Int? = null
    ): ResponseBlogFollowers.Response? {
        val retrofitResponse = blogGetApi.getBlogFollowersHelper(
            identifier,
            limit,
            offset
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogFollowing(
        identifier: String,
        limit: Int? = null,
        offset: Int? = null
    ): ResponseBlogFollowing.Response? {
        val retrofitResponse = blogGetApi.getBlogFollowingHelper(
            identifier,
            limit,
            offset
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogInfo(
        identifier: String
    ): ResponseBlogInfo.Response? {
        val retrofitResponse = blogGetApi.getBlogInfoHelper(
            identifier
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogLikes(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogLikes.Response? {
        val retrofitResponse = blogGetApi.getBlogLikesHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogPosts(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
        type: Post.Type? = null
    ): ResponseBlogPosts.Response? {
        val retrofitResponse = blogGetApi.getBlogPostsHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber,
            type
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogQueue(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogQueue.Response? {
        val retrofitResponse = blogGetApi.getBlogQueueHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    suspend fun getBlogSubmissions(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogSubmissions.Response? {
        val retrofitResponse = blogGetApi.getBlogSubmissionsHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion Blog Getters

    // region Post Getters

    // suspend fun getTaggedPosts(
    //     tag: String,
    //     before: Long? = null,
    //     limit: Long? = null,
    //     filter: String? = null
    // ): ResponsePostsTagged.Response? {
    //     TODO("The get tagged posts api requires special parsing that I don't feel like implementing")
    //     val retrofitResponse = postsGetApi.getTaggedPosts(
    //         tag,
    //         before,
    //         limit,
    //         filter
    //     )
    //
    //     val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
    //     val response = retrofitResponse.body()
    //     return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    // }

    suspend fun getPost(
        identifier: String,
        postId: Long,
        postFormat: Post.PostVersion? = null
    ): ResponsePostsPost.Response? {
        val retrofitResponse = postsGetApi.getPost(
            identifier,
            postId,
            postFormat
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion Post Getters
}
