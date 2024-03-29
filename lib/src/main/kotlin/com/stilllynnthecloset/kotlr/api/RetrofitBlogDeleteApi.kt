package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RetrofitBlogDeleteApi {
    @DELETE("blog/{identifier}/blocks")
    suspend fun unblockBlog(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Query("blocked_tumblelog")
        blogToUnblock: String,
    ): Response<ResponseBlogBlocks.Response>

    @DELETE("blog/{identifier}/blocks?anonymous_only=true")
    suspend fun unblockAllAnonymousBlogs(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
    ): Response<ResponseBlogBlocks.Response>
}
