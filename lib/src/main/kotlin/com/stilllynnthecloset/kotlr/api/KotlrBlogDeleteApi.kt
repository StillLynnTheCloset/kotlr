package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks

public interface KotlrBlogDeleteApi {
    /**
     * Use this method to unblock a known blog.
     *
     * @param blogIdentifier The identifier that is doing the blocking.
     * @param blogToUnblock The identifier of the blog that is being unblocked.
     */
    public suspend fun unblockBlog(
        blogIdentifier: String,
        blogToUnblock: String,
    ): ResponseBlogBlocks.Response?

    /**
     * Use this method to unblock all currently blocked anonymous blogs.
     *
     * @param blogIdentifier The identifier that is doing the blocking.
     */
    public suspend fun unblockAllAnonymousBlogs(
        blogIdentifier: String,
    ): ResponseBlogBlocks.Response?
}
