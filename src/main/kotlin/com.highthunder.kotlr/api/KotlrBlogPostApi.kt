package com.highthunder.kotlr.api

import com.highthunder.kotlr.postbody.BlockBlogPostBody
import com.highthunder.kotlr.postbody.CreateNewPostBody
import com.highthunder.kotlr.postbody.ReblogPostBody
import com.highthunder.kotlr.response.type.blog.ResponseBlogBlocks
import com.highthunder.kotlr.response.type.post.ResponseCreatePost
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

internal interface KotlrBlogPostApi {
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
}
