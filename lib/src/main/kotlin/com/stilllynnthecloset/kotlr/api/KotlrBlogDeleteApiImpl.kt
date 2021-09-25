package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks

internal class KotlrBlogDeleteApiImpl constructor(
    private val blogDeleteApi: RetrofitBlogDeleteApi,
) : KotlrBlogDeleteApi {
    override suspend fun unblockBlog(
        blogIdentifier: String,
        blogToUnblock: String,
    ): ResponseBlogBlocks.Response? {
        validateBlogIdentifier(blogIdentifier)
        validateBlogIdentifier(blogToUnblock)

        val retrofitResponse = blogDeleteApi.unblockBlog(
            blogIdentifier = blogIdentifier,
            blogToUnblock = blogToUnblock,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    override suspend fun unblockAllAnonymousBlogs(
        blogIdentifier: String,
    ): ResponseBlogBlocks.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogDeleteApi.unblockAllAnonymousBlogs(
            blogIdentifier = blogIdentifier,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
