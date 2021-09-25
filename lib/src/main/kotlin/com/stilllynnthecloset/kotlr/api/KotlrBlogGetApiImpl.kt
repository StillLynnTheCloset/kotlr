package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogAvatar
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogDrafts
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowedBy
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowers
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowing
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogInfo
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogLikes
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogNotifications
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogPosts
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogQueue
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogSubmissions
import com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPost
import com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPostNotes
import com.stilllynnthecloset.kotlr.types.Post

internal class KotlrBlogGetApiImpl constructor(
    private val blogGetApi: RetrofitBlogGetApi,
) : KotlrBlogGetApi {
    override suspend fun getBlogAvatar(
        blogIdentifier: String,
    ): ResponseBlogAvatar.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogGetApi.getBlogAvatar(
            blogIdentifier,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getBlogAvatar(
        blogIdentifier: String,
        size: Int,
    ): ResponseBlogAvatar.Response? {
        validateBlogIdentifier(blogIdentifier)
        validateAvatarSize(size)

        val retrofitResponse = blogGetApi.getBlogAvatar(
            blogIdentifier,
            size,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getBlogFollowers(
        blogIdentifier: String,
        pagingLimit: Int?,
        pagingOffset: Long?,
    ): ResponseBlogFollowers.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = blogGetApi.getBlogFollowers(
            blogIdentifier,
            pagingLimit,
            pagingOffset,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getBlogFollowing(
        blogIdentifier: String,
        pagingLimit: Int?,
        pagingOffset: Long?,
    ): ResponseBlogFollowing.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = blogGetApi.getBlogFollowing(
            blogIdentifier,
            pagingLimit,
            pagingOffset,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getBlogFollowedBy(
        blogIdentifier: String,
        query: String,
    ): ResponseBlogFollowedBy.Response? {
        validateBlogIdentifier(blogIdentifier)
        validateBlogIdentifier(query)

        val retrofitResponse = blogGetApi.getBlogFollowedBy(
            blogIdentifier,
            query,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getBlogInfo(
        blogIdentifier: String,
    ): ResponseBlogInfo.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogGetApi.getBlogInfo(
            blogIdentifier,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getBlogLikes(
        blogIdentifier: String,
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
    ): ResponseBlogLikes.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogLikes(
            blogIdentifier = blogIdentifier,
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

    override suspend fun getBlogPosts(
        blogIdentifier: String,
        pagingLimit: Int?,
        pagingOffset: Long?,
        afterPostId: Long?,
        beforePostId: Long?,
        afterTime: Long?,
        beforeTime: Long?,
        getReblogFields: Boolean?,
        getNotesHistory: Boolean?,
        tag: String?,
        tags: List<String>?,
        pageNumber: Int?,
        type: Post.Type?,
    ): ResponseBlogPosts.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogPosts(
            blogIdentifier = blogIdentifier,
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

    override suspend fun getBlogDrafts(
        blogIdentifier: String,
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
    ): ResponseBlogDrafts.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogDrafts(
            blogIdentifier = blogIdentifier,
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

    override suspend fun getBlogQueue(
        blogIdentifier: String,
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
    ): ResponseBlogQueue.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogQueue(
            blogIdentifier = blogIdentifier,
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

    override suspend fun getBlogSubmissions(
        blogIdentifier: String,
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
    ): ResponseBlogSubmissions.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogSubmissions(
            blogIdentifier = blogIdentifier,
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

    override suspend fun getBlogBlocks(
        blogIdentifier: String,
        pagingLimit: Int?,
        pagingOffset: Long?,
    ): ResponseBlogBlocks.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = blogGetApi.getBlogBlocks(
            blogIdentifier = blogIdentifier,
            pagingLimit = pagingLimit,
            pagingOffset = pagingOffset,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getNotifications(
        blogIdentifier: String,
        before: Long?,
        types: List<String>?,
    ): ResponseBlogNotifications.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogGetApi.getNotifications(
            blogIdentifier = blogIdentifier,
            before = before,
            types = types,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getPost(
        blogIdentifier: String,
        postId: Long,
    ): ResponseBlogPost.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePostId(postId)

        val retrofitResponse = blogGetApi.getPost(
            blogIdentifier = blogIdentifier,
            postId = postId,
            postFormat = "npf",
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun getPostNotes(
        blogIdentifier: String,
        postId: Long,
        beforeTimestamp: Long?,
        mode: Post.NotesMode?,
    ): ResponseBlogPostNotes.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePostId(postId)
        validateTimestamp(beforeTimestamp)

        val retrofitResponse = blogGetApi.getPostNotes(
            blogIdentifier,
            postId,
            beforeTimestamp,
            mode,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
