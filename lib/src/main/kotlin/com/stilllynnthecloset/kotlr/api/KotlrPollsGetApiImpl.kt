package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.polls.ResponsePollsResults

internal class KotlrPollsGetApiImpl constructor(
    private val pollsGetApi: RetrofitPollsGetApi,
) : KotlrPollsGetApi {
    override suspend fun getPollResults(
        blogIdentifier: String,
        postId: Long,
        pollUuid: String,
    ): ResponsePollsResults.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = pollsGetApi.getPollResults(
            blogIdentifier,
            postId,
            pollUuid,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
