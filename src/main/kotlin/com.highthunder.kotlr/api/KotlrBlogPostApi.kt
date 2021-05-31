package com.highthunder.kotlr.api

import com.highthunder.kotlr.postbody.CreateNewPostBody
import com.highthunder.kotlr.postbody.ReblogPostBody
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

    /**
     * Create/Reblog a Post (Neue Post Format)
     *
     * This method allows you to create posts (and reblogs) using the Neue Post Format.
     * Note about Post States
     *
     * Posts can be in the following "states" as indicated in requests to the post creation/editing endpoints:
     *
     * "published" means the post should be publicly published immediately.
     * "queue" means the post should be added to the end of the blog's post queue.
     * "draft" means the post should be saved as a draft.
     * "private" means the post should be privately published immediately.
     * "unapproved" means the post is a new submission.
     *
     * If omitted, the state parameter on a new post defaults to "published".
     *
     * @param blogIdentifier An identifier of the Blog that this post should be published to.
     * @param createBody The payload of this post.
     */
    @POST("blog/{identifier}/posts")
    // TODO: Add a wrapper function to remove the OKHTTP response type
    suspend fun createNewPost(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Body
        createBody: CreateNewPostBody,
    ): Response<ResponseCreatePost.Response>

    /**
     * Create/Reblog a Post (Neue Post Format)
     *
     * This method allows you to create posts (and reblogs) using the Neue Post Format.
     * Note about Post States
     *
     * Posts can be in the following "states" as indicated in requests to the post creation/editing endpoints:
     *
     * "published" means the post should be publicly published immediately.
     * "queue" means the post should be added to the end of the blog's post queue.
     * "draft" means the post should be saved as a draft.
     * "private" means the post should be privately published immediately.
     * "unapproved" means the post is a new submission.
     *
     * If omitted, the state parameter on a new post defaults to "published".
     *
     * @param blogIdentifier An identifier of the Blog that this post should be published to.
     * @param createBody The payload of this post.
     * @param contentFiles The content parts that should be uploaded with this post.
     */
    @Multipart
    @POST("blog/{identifier}/posts")
    // TODO: Add a wrapper function to remove the OKHTTP response type
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

    /**
     * Create/Reblog a Post (Neue Post Format)
     *
     * This method allows you to create posts (and reblogs) using the Neue Post Format.
     * Note about Post States
     *
     * Posts can be in the following "states" as indicated in requests to the post creation/editing endpoints:
     *
     * "published" means the post should be publicly published immediately.
     * "queue" means the post should be added to the end of the blog's post queue.
     * "draft" means the post should be saved as a draft.
     * "private" means the post should be privately published immediately.
     * "unapproved" means the post is a new submission.
     *
     * If omitted, the state parameter on a new post defaults to "published".
     *
     * @param blogIdentifier An identifier of the Blog that this post should be published to.
     * @param reblogBody The payload of this post.
     */
    @POST("blog/{identifier}/posts")
    // TODO: Add a wrapper function to remove the OKHTTP response type
    suspend fun reblogPost(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Body
        reblogBody: ReblogPostBody,
    ): Response<ResponseCreatePost.Response>

    /**
     * Create/Reblog a Post (Neue Post Format)
     *
     * This method allows you to create posts (and reblogs) using the Neue Post Format.
     * Note about Post States
     *
     * Posts can be in the following "states" as indicated in requests to the post creation/editing endpoints:
     *
     * "published" means the post should be publicly published immediately.
     * "queue" means the post should be added to the end of the blog's post queue.
     * "draft" means the post should be saved as a draft.
     * "private" means the post should be privately published immediately.
     * "unapproved" means the post is a new submission.
     *
     * If omitted, the state parameter on a new post defaults to "published".
     *
     * @param blogIdentifier An identifier of the Blog that this post should be published to.
     * @param reblogBody The payload of this post.
     * @param contentFiles The content parts that should be uploaded with this post.
     */
    @Multipart
    @POST("blog/{identifier}/posts")
    // TODO: Add a wrapper function to remove the OKHTTP response type
    suspend fun reblogPostWithContentFiles(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Part
        reblogBody: ReblogPostBody,
        @Part
        contentFiles: List<MultipartBody.Part>,
    ): Response<ResponseCreatePost.Response>

    // endregion Reblog NPF Post
}
