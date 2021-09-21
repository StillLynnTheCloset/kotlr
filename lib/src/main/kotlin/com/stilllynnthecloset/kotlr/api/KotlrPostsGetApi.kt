package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.post.ResponsePostsTagged
import com.stilllynnthecloset.kotlr.types.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface KotlrPostsGetApi {
    @GET("tagged")
    suspend fun getTaggedPosts(
        @Query("tag")
        tag: String,
        @Query("before")
        beforeTimestamp: Long? = null,
        @Query("limit")
        pagingLimit: Long? = null,
        @Query("filter")
        filter: Post.PostFormat? = null,
    ): Response<ResponsePostsTagged.Response>
}
