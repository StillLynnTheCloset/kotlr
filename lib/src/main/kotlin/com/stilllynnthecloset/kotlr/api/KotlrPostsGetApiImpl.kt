package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.RateLimitMetaData
import com.stilllynnthecloset.kotlr.response.type.post.ResponsePostsTagged
import com.stilllynnthecloset.kotlr.types.Post

internal class KotlrPostsGetApiImpl constructor(
    private val postsGetApi: RetrofitPostsGetApi,
) : KotlrPostsGetApi {
    override suspend fun getTaggedPosts(
        tag: String,
        beforeTimestamp: Long?,
        pagingLimit: Long?,
        filter: Post.PostFormat?,
    ): ResponsePostsTagged.Response? {
        val retrofitResponse = postsGetApi.getTaggedPosts(
            tag = tag,
            beforeTimestamp = beforeTimestamp,
            pagingLimit = pagingLimit,
            filter = filter,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }
}
