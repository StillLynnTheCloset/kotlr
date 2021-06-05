package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.type.post.ResponsePostsTagged
import com.highthunder.kotlr.types.Post
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
