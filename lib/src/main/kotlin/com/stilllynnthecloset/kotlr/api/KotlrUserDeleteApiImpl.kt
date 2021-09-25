package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent

internal class KotlrUserDeleteApiImpl constructor(
    private val userDeleteApi: RetrofitUserDeleteApi,
) : KotlrUserDeleteApi {
    override suspend fun deleteContentFilter(
        contentFilter: String,
    ): ResponseUserFilteredContent.Response? {
        validateContentFilter(contentFilter)

        val retrofitResponse = userDeleteApi.filterContent(
            filteredContent = contentFilter
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
