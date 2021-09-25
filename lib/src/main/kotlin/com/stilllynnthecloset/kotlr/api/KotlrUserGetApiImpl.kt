package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollowing
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserInfo
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLikes
import com.stilllynnthecloset.kotlr.types.Post

internal class KotlrUserGetApiImpl constructor(
    private val userGetApi: RetrofitUserGetApi,
) : KotlrUserGetApi {
    override suspend fun getUserInfo(): ResponseUserInfo.Response? {
        val retrofitResponse = userGetApi.getUserInfo()
        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getUserLikes(
        pagingLimit: Int?,
        pagingOffset: Long?,
        afterPostId: Long?,
        beforePostId: Long?,
        afterTime: Long?,
        beforeTime: Long?,
        getReblogFields: Boolean?,
        getNotesHistory: Boolean?,
        tag: String?,
        pageNumber: Int?,
    ): ResponseUserLikes.Response? {
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = userGetApi.getUserLikes(
            pagingLimit = pagingLimit,
            pagingOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getUserDash(
        pagingLimit: Int?,
        pagingOffset: Long?,
        afterPostId: Long?,
        beforePostId: Long?,
        afterTime: Long?,
        beforeTime: Long?,
        getReblogFields: Boolean?,
        getNotesHistory: Boolean?,
        tag: String?,
        pageNumber: Int?,
        type: Post.Type?,
    ): ResponseUserDashboard.Response? {
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = userGetApi.getUserDash(
            pagingLimit = pagingLimit,
            pagingOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
            type = type,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getUserFollowing(
        pagingLimit: Int?,
        pagingOffset: Long?,
    ): ResponseUserFollowing.Response? {
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = userGetApi.getUserFollowing(
            pagingLimit,
            pagingOffset,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getContentFilters(): ResponseUserFilteredContent.Response? {
        val retrofitResponse = userGetApi.getContentFilters()

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
