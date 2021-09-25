package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollow
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLike

public interface KotlrUserPostApi {
    /**
     * Use this method to follow a blog.
     *
     * @param url The url of the blog.
     * @param email The email of the blog if the user has enabled "allow people to find this blog by email"
     */
    public suspend fun followBlog(
        url: String? = null,
        email: String? = null,
    ): ResponseUserFollow.Response?

    /**
     * Use this method to unfollow a blog.
     *
     * @param url The url of the blog.
     * @param email The email of the blog if the user has enabled "allow people to find this blog by email"
     */
    public suspend fun unfollowBlog(
        url: String? = null,
        email: String? = null,
    ): ResponseUserFollow.Response?

    /**
     * Use this method to like a post.
     *
     * @param postId The postId of the post to like.
     * @param reblogKey The reblogKey of the post to like.
     */
    public suspend fun likePost(
        postId: Long,
        reblogKey: String,
    ): ResponseUserLike.Response?

    /**
     * Use this method to unlike a post.
     *
     * @param id The postId of the post to unlike.
     * @param reblogKey The reblogKey of the post to unlike.
     */
    public suspend fun unlikePost(
        id: Long,
        reblogKey: String,
    ): ResponseUserLike.Response?

    /**
     * Use this method to add a content filter.
     *
     * @param contentFilter The text that a filter filters on.
     */
    public suspend fun addContentFilter(
        contentFilter: String,
    ): ResponseUserLike.Response?

    /**
     * Use this method to add a group of content filters.
     *
     * @param contentFilters The text that a filter filters on.
     */
    public suspend fun addContentFilters(
        contentFilters: Iterable<String>,
    ): ResponseUserLike.Response?

    /**
     * Use this method to add a group of content filters.
     *
     * @param contentFilters The text that a filter filters on.
     */
    public suspend fun addContentFilters(
        vararg contentFilters: String,
    ): ResponseUserLike.Response?
}
