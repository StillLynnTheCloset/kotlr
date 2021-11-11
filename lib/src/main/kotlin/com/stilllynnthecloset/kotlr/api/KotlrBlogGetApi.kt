package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogAvatar
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogDrafts
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowedBy
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowers
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowing
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogInfo
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogLikes
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogNotifications
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogPosts
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogQueue
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogSubmissions
import com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPost
import com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPostNotes
import com.stilllynnthecloset.kotlr.types.Post

public interface KotlrBlogGetApi {
    /**
     * Retrieve a Blog Avatar.
     *
     * This uses the default size of 64x64.
     *
     * @param blogIdentifier A blog identifier.
     */
    public suspend fun getBlogAvatar(
        blogIdentifier: String,
    ): ResponseBlogAvatar.Response?

    /**
     * Retrieve a Blog Avatar.
     *
     * You can get a blog's avatar in 9 different sizes. The default size is 64x64.
     *
     * @param blogIdentifier A blog identifier.
     * @param size The size of the avatar (square, one value for both length and width). Must be one of the values: 16, 24, 30, 40, 48, 64, 96, 128, 512.
     */
    public suspend fun getBlogAvatar(
        blogIdentifier: String,
        size: Int,
    ): ResponseBlogAvatar.Response?

    /**
     * Retrieve a Blog's Followers.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive.
     * @param pagingOffset Optional. Followed blog index to start at.
     */
    public suspend fun getBlogFollowers(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseBlogFollowers.Response?

    /**
     * Retrieve Blog's following.
     *
     * This method can be used to retrieve the publicly exposed list of blogs that a blog follows, in order from most
     * recently-followed to first.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive.
     * @param pagingOffset Optional. Followed blog index to start at.
     */
    public suspend fun getBlogFollowing(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseBlogFollowing.Response?

    /**
     * Check If Followed By Blog.
     *
     * This method can be used to check if one of your blogs is followed by another blog.
     *
     * @param blogIdentifier An identifier for your blog to check.
     * @param query The name of the blog that may be following your blog.
     */
    public suspend fun getBlogFollowedBy(
        blogIdentifier: String,
        query: String,
    ): ResponseBlogFollowedBy.Response?

    /**
     * Retrieve Blog Info.
     *
     * This method returns general information about the blog, such as the title, number of posts, and other high-level data.
     *
     * @param blogIdentifier An identifier for the blog.
     */
    public suspend fun getBlogInfo(
        blogIdentifier: String,
    ): ResponseBlogInfo.Response?

    /**
     * Retrieve Blog's Likes.
     *
     * This method can be used to retrieve the publicly exposed likes from a blog.
     *
     * Notes
     *  You can only provide either before, after, or offset. If you provide more than one of these options together you will get an error.
     *  You can still use limit with any of those three options to limit your result set.
     *  When using the offset parameter the maximum limit on the offset is 1000. If you would like to get more results than that use either before or after.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogLikes(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
    ): ResponseBlogLikes.Response?

    /**
     * Retrieve Published Posts.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     * @param type Optional. The type of post to return. Specify one of the following: text, photo, quote, link, chat, audio, video, answer
     */
    public suspend fun getBlogPosts(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        tags: List<String>? = null,
        pageNumber: Int? = null,
        type: Post.Type? = null,
    ): ResponseBlogPosts.Response?

    /**
     * Retrieve Draft Posts.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogDrafts(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
    ): ResponseBlogDrafts.Response?

    /**
     * Retrieve Queued Posts.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogQueue(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
    ): ResponseBlogQueue.Response?

    /**
     * Retrieve Submission Posts.
     *
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogSubmissions(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
    ): ResponseBlogSubmissions.Response?

    /**
     * Retrieve blogs that have been blocked by the given blog.
     *
     * @param blogIdentifier An identifier for the blog that you are using.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive.
     * @param pagingOffset Optional. Post number to start at.
     */
    public suspend fun getBlogBlocks(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseBlogBlocks.Response?

    /**
     * Retrieve notifications for the given blog.
     *
     * @param blogIdentifier An identifier for the blog that you are using.
     */
    public suspend fun getNotifications(
        blogIdentifier: String,
        before: Long? = null,
        types: List<String>? = null,
    ): ResponseBlogNotifications.Response?

    /**
     * Fetch a single post.
     *
     * @param blogIdentifier A blog identifier of the blog that posted the desired post.
     * @param postId The id of the desired post.
     */
    public suspend fun getPost(
        blogIdentifier: String,
        postId: Long,
    ): ResponseBlogPost.Response?

    /**
     * Fetch the notes of a single post.
     *
     * @param blogIdentifier A blog identifier of the blog that posted the desired post.
     * @param postId The id of the desired post.
     * @param beforeTimestamp Optional. Fetch notes created before this timestamp, for pagination. This is a unix timestamp in seconds precision, but microsecond precision for conversation mode.
     * @param mode The response formatting mode.
     */
    public suspend fun getPostNotes(
        blogIdentifier: String,
        postId: Long,
        beforeTimestamp: Long? = null,
        mode: Post.NotesMode? = null,
    ): ResponseBlogPostNotes.Response?
}
