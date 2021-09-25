package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.postbody.BlockBlogPostBody
import com.stilllynnthecloset.kotlr.postbody.CreateNewPostBody
import com.stilllynnthecloset.kotlr.postbody.ReblogPostBody
import com.stilllynnthecloset.kotlr.postbody.ReorderQueuePostBody
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogQueue
import com.stilllynnthecloset.kotlr.response.type.post.ResponseCreatePost
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

internal interface RetrofitBlogPostApi {
    // region Create NPF Post

    @POST("blog/{identifier}/posts")
    suspend fun createNewPost(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Body
        createBody: CreateNewPostBody,
    ): Response<ResponseCreatePost.Response>

    @Multipart
    @POST("blog/{identifier}/posts")
    suspend fun createNewPostWithContentFiles(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Part
        createBody: CreateNewPostBody,
        @Part
        contentFiles: List<MultipartBody.Part>,
    ): Response<ResponseCreatePost.Response>

    // endregion Create NPF Post

    // region Reblog NPF Post

    @POST("blog/{identifier}/posts")
    suspend fun reblogPost(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Body
        reblogBody: ReblogPostBody,
    ): Response<ResponseCreatePost.Response>

    @Multipart
    @POST("blog/{identifier}/posts")
    suspend fun reblogPostWithContentFiles(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Part
        reblogBody: ReblogPostBody,
        @Part
        contentFiles: List<MultipartBody.Part>,
    ): Response<ResponseCreatePost.Response>

    // endregion Reblog NPF Post

    @POST("blog/{identifier}/blocks")
    suspend fun blockBlog(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Body
        blockBody: BlockBlogPostBody,
    ): Response<ResponseBlogBlocks.Response>

    @POST("blog/{identifier}/posts/queue/reorder")
    suspend fun reorderQueue(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Body
        reorderBody: ReorderQueuePostBody,
    ): Response<ResponseBlogQueue.Response>

    @POST("blog/{identifier}/posts/queue/shuffle")
    suspend fun shuffleQueue(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
    ): Response<ResponseBlogQueue.Response>
}
