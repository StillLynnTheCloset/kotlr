package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.postbody.FilteredContentPostBody
import com.stilllynnthecloset.kotlr.postbody.FollowPostBody
import com.stilllynnthecloset.kotlr.postbody.LikePostBody
import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollow
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLike

internal class KotlrUserPostApiImpl constructor(
    private val userPostApi: RetrofitUserPostApi,
) : KotlrUserPostApi {
    override suspend fun followBlog(
        url: String?,
        email: String?,
    ): ResponseUserFollow.Response? {
        validateUrlAndEmail(url, email)

        val retrofitResponse = userPostApi.followBlog(
            followPostBody = FollowPostBody(url, email),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun unfollowBlog(
        url: String?,
        email: String?,
    ): ResponseUserFollow.Response? {
        validateUrlAndEmail(url, email)

        val retrofitResponse = userPostApi.unfollowBlog(
            followPostBody = FollowPostBody(url, email),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun likePost(
        postId: Long,
        reblogKey: String,
    ): ResponseUserLike.Response? {
        validatePostId(postId)
        validateReblogKey(reblogKey)

        val retrofitResponse = userPostApi.likePost(
            likePostBody = LikePostBody(postId, reblogKey),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun unlikePost(
        id: Long,
        reblogKey: String,
    ): ResponseUserLike.Response? {
        validatePostId(id)
        validateReblogKey(reblogKey)

        val retrofitResponse = userPostApi.unlikePost(
            likePostBody = LikePostBody(id, reblogKey),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun addContentFilter(
        contentFilter: String,
    ): ResponseUserLike.Response? {
        validateContentFilter(contentFilter)

        val body = FilteredContentPostBody(contentFilter)

        val retrofitResponse = userPostApi.addContentFilter(
            filteredContent = body,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun addContentFilters(
        contentFilters: Iterable<String>,
    ): ResponseUserLike.Response? {
        contentFilters.forEach { validateContentFilter(it) }

        val body = FilteredContentPostBody(contentFilters)

        val retrofitResponse = userPostApi.addContentFilter(
            filteredContent = body,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun addContentFilters(
        vararg contentFilters: String,
    ): ResponseUserLike.Response? {
        return addContentFilters(contentFilters.toList())
    }
}
