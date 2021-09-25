package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.postbody.BlockBlogPostBody
import com.stilllynnthecloset.kotlr.postbody.CreateNewPostBody
import com.stilllynnthecloset.kotlr.postbody.ReblogPostBody
import com.stilllynnthecloset.kotlr.postbody.ReorderQueuePostBody
import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogQueue
import com.stilllynnthecloset.kotlr.response.type.post.ResponseCreatePost
import okhttp3.MultipartBody

internal class KotlrBlogPostApiImpl constructor(
    private val blogPostApi: RetrofitBlogPostApi,
) : KotlrBlogPostApi {
    override suspend fun createNewPost(
        blogIdentifier: String,
        createBody: CreateNewPostBody,
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.createNewPost(
            blogIdentifier = blogIdentifier,
            createBody = createBody,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun createNewPostWithContentFiles(
        blogIdentifier: String,
        createBody: CreateNewPostBody,
        contentFiles: List<MultipartBody.Part>, // TODO: Don't expose okhttp
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.createNewPostWithContentFiles(
            blogIdentifier = blogIdentifier,
            createBody = createBody,
            contentFiles = contentFiles,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun reblogPost(
        blogIdentifier: String,
        reblogBody: ReblogPostBody,
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.reblogPost(
            blogIdentifier = blogIdentifier,
            reblogBody = reblogBody,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun reblogPostWithContentFiles(
        blogIdentifier: String,
        reblogBody: ReblogPostBody,
        contentFiles: List<MultipartBody.Part>, // TODO: Don't expose okhttp
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.reblogPostWithContentFiles(
            blogIdentifier = blogIdentifier,
            reblogBody = reblogBody,
            contentFiles = contentFiles,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun blockBlog(
        blogIdentifier: String,
        blogToBlock: String,
    ): ResponseBlogBlocks.Response? {
        validateBlogIdentifier(blogIdentifier)
        validateBlogIdentifier(blogToBlock)

        val retrofitResponse = blogPostApi.blockBlog(
            blogIdentifier = blogIdentifier,
            blockBody = BlockBlogPostBody(blogIdentifier = blogToBlock),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun blockBlog(
        blogIdentifier: String,
        postId: Long,
    ): ResponseBlogBlocks.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePostId(postId)

        val retrofitResponse = blogPostApi.blockBlog(
            blogIdentifier = blogIdentifier,
            blockBody = BlockBlogPostBody(postId = postId),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun reorderQueue(
        blogIdentifier: String,
        postId: Long,
        insertAfter: Long,
    ): ResponseBlogQueue.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePostId(postId)
        validatePostId(insertAfter)

        val retrofitResponse = blogPostApi.reorderQueue(
            blogIdentifier = blogIdentifier,
            reorderBody = ReorderQueuePostBody(postId = postId, insertAfter = insertAfter),
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun shuffleQueue(
        blogIdentifier: String,
    ): ResponseBlogQueue.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.shuffleQueue(
            blogIdentifier = blogIdentifier,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
