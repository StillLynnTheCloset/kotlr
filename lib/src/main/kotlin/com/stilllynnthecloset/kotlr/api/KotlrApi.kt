package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.getApi
import com.stilllynnthecloset.kotlr.postbody.CreateNewPostBody
import com.stilllynnthecloset.kotlr.postbody.ReblogPostBody
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
import com.stilllynnthecloset.kotlr.response.type.post.ResponseCreatePost
import com.stilllynnthecloset.kotlr.response.type.post.ResponsePostsTagged
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollow
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollowing
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserInfo
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLike
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLikes
import com.stilllynnthecloset.kotlr.types.Post
import okhttp3.MultipartBody

/**
 * KotlrApi - The main class for performing requests to the Tumblr API.
 *
 * Get an instance by calling [getApi].
 */
public interface KotlrApi {
    // region User GETs

    /**
     * Use this method to retrieve the user's account information that matches the OAuth credentials submitted with the request.
     */
    public suspend fun getUserInfo(): ResponseUserInfo.Response?

    /**
     * Use this method to retrieve the liked posts that match the OAuth credentials submitted with the request.
     *
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts liked after the specified timestamp.
     * @param beforeTime Optional. Retrieve posts liked before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getUserLikes(
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
    ): ResponseUserLikes.Response?

    /**
     * Use this method to retrieve the dashboard that matches the OAuth credentials submitted with the request.
     *
     * ⚠️ Note: Please don't re-implement the Dashboard, and don't recreate complete Tumblr functions or clients on a
     * platform where Tumblr already has an official client. See our API policies here.
     *
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
    public suspend fun getUserDash(
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
        type: Post.Type? = null,
    ): ResponseUserDashboard.Response?

    /**
     * Use this method to retrieve the blogs followed by the user whose OAuth credentials are submitted with the request.
     *
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Result number to start at
     */
    public suspend fun getUserFollowing(
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseUserFollowing.Response?

    /**
     * Use this method to retrieve the content filtering strings of the user whose OAuth credentials are submitted with the request.
     */
    public suspend fun getContentFilters(): ResponseUserFilteredContent.Response?

    // endregion User GETs

    // region User POSTs

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

    // endregion User POSTs

    // region User DELETEs

    /**
     * Use this method to remove a content filter.
     *
     * @param contentFilter The text that a filter filters on.
     */
    public suspend fun deleteContentFilter(
        contentFilter: String,
    ): ResponseUserFilteredContent.Response?

    // endregion User DELETEs

    // region Blog GETs

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

    // endregion Blog GETs

    // region Blog POSTs

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
     * @param blogIdentifier The identifier of the blog who's queue needs reordering.
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
     * @param blogIdentifier The identifier of the blog who's queue needs shuffling.
     */
    public suspend fun shuffleQueue(
        blogIdentifier: String,
    ): ResponseBlogQueue.Response?

    // endregion Blog POSTs

    // region Blog DELETEs

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

    // endregion Blog DELETEs

    // region Post GETs

    /**
     * Fetch posts with a given tag.
     *
     * @param tag The tag on the posts you'd like to retrieve.
     * @param beforeTimestamp Optional. The timestamp of when you'd like to see posts before. If the Tag is a "featured" tag, use the "featured_timestamp" on the post object for pagination.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive.
     * @param filter Optional. Specifies the post format to return, other than HTML: text – Plain text, no HTML; raw – As entered by the user (no post-processing); if the user writes in Markdown, the Markdown will be returned rather than HTML.
     */
    public suspend fun getTaggedPosts(
        tag: String,
        beforeTimestamp: Long? = null,
        pagingLimit: Long? = null,
        filter: Post.PostFormat? = null,
    ): ResponsePostsTagged.Response?

    // endregion Post GETs
}
