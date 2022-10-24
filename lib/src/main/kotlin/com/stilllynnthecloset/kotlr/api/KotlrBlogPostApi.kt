package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.postbody.CreateNewPostBody
import com.stilllynnthecloset.kotlr.postbody.ReblogPostBody
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogQueue
import com.stilllynnthecloset.kotlr.response.type.post.ResponseCreatePost
import okhttp3.MultipartBody

public interface KotlrBlogPostApi {
    /**
     * Create/Reblog a Post
     *
     * This method allows you to create posts using the Neue Post Format.
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
    public suspend fun createNewPost(
        blogIdentifier: String,
        createBody: CreateNewPostBody,
    ): ResponseCreatePost.Response?

    /**
     * Create a Post
     *
     * This method allows you to create posts using the Neue Post Format.
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
    public suspend fun createNewPostWithContentFiles(
        blogIdentifier: String,
        createBody: CreateNewPostBody,
        contentFiles: List<MultipartBody.Part>, // TODO: Don't expose okhttp
    ): ResponseCreatePost.Response?

    /**
     * Reblog a Post
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
    public suspend fun reblogPost(
        blogIdentifier: String,
        reblogBody: ReblogPostBody,
    ): ResponseCreatePost.Response?

    /**
     * Reblog a Post
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
    public suspend fun reblogPostWithContentFiles(
        blogIdentifier: String,
        reblogBody: ReblogPostBody,
        contentFiles: List<MultipartBody.Part>, // TODO: Don't expose okhttp
    ): ResponseCreatePost.Response?

    /**
     * Use this method to block a known blog.
     *
     * @param blogIdentifier The identifier that is doing the blocking.
     * @param blogToBlock The identifier of the blog that is being blocked.
     */
    public suspend fun blockBlog(
        blogIdentifier: String,
        blogToBlock: String,
    ): ResponseBlogBlocks.Response?

    /**
     * Use this method to block an anonymous blog.
     *
     * @param blogIdentifier The identifier that is doing the blocking.
     * @param postId The postId of the ask or submission by the blog that you want to block.
     */
    public suspend fun blockBlog(
        blogIdentifier: String,
        postId: Long,
    ): ResponseBlogBlocks.Response?

    /**
     * Use this method to move a post within your blog's queue.
     *
     * @param blogIdentifier The identifier of the blog whose queue needs reordering.
     * @param postId The postId of the queued post that you want to move.
     * @param insertAfter The postId of the queued post that the post should be moved after, or 0 to move it to the front of the queue.
     */
    public suspend fun reorderQueue(
        blogIdentifier: String,
        postId: Long,
        insertAfter: Long,
    ): ResponseBlogQueue.Response?

    /**
     * Use this method to randomly shuffle your blog's queue.
     *
     * @param blogIdentifier The identifier of the blog whose queue needs shuffling.
     */
    public suspend fun shuffleQueue(
        blogIdentifier: String,
    ): ResponseBlogQueue.Response?
}
