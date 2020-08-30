package com.highthunder.kotlr.api

import com.highthunder.kotlr.response.RateLimitMetaData
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import com.highthunder.kotlr.response.type.post.ResponsePostsPost
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import com.highthunder.kotlr.types.Post

public class KotlrApi internal constructor(
    private val userGetApi: KotlrUserGetApi,
    private val blogGetApi: KotlrBlogGetApi,
    private val userPostApi: KotlrUserPostApi,
    private val blogPostApi: KotlrBlogPostApi,
    private val postsGetApi: KotlrPostsGetApi
) : KotlrUserPostApi by userPostApi, KotlrBlogPostApi by blogPostApi {
    // region User Getters

    /**
     * Use this method to retrieve the user's account information that matches the OAuth credentials submitted with the request.
     */
    public suspend fun getUserInfo(): ResponseUserInfo.Response? {
        val retrofitResponse = userGetApi.getUserInfoHelper()
        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to retrieve the liked posts that match the OAuth credentials submitted with the request.
     *
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts liked after the specified timestamp.
     * @param beforeTime Optional. Retrieve posts liked before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getUserLikes(
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseUserLikes.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = userGetApi.getUserLikesHelper(
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to retrieve the dashboard that matches the OAuth credentials submitted with the request.
     *
     * ⚠️ Note: Please don't re-implement the Dashboard, and don't recreate complete Tumblr functions or clients on a
     * platform where Tumblr already has an official client. See our API policies here.
     *
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     * @param type Optional. The type of post to return. Specify one of the following: text, photo, quote, link, chat, audio, video, answer
     */
    public suspend fun getUserDash(
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
        type: Post.Type? = null
    ): ResponseUserDashboard.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = userGetApi.getUserDashHelper(
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber,
            type
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to retrieve the blogs followed by the user whose OAuth credentials are submitted with the request.
     *
     * @param limit Optional. The number of results to return: 1–50, inclusive
     * @param offset Optional. Result number to start at
     */
    public suspend fun getUserFollowing(
        limit: Int? = null,
        offset: Long? = null
    ): ResponseUserFollowing.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = userGetApi.getUserFollowingHelper(
            limit,
            offset
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion User Getters

    // region Blog Getters

    /**
     * Retrieve a Blog Avatar.
     *
     * This uses the default size of 64x64.
     *
     * @param identifier A blog identifier.
     */
    public suspend fun getBlogAvatar(
        identifier: String
    ): ResponseBlogAvatar.Response? {
        val retrofitResponse = blogGetApi.getBlogAvatarHelper(
            identifier
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve a Blog Avatar.
     *
     * You can get a blog's avatar in 9 different sizes. The default size is 64x64.
     *
     * @param identifier A blog identifier.
     * @param size The size of the avatar (square, one value for both length and width). Must be one of the values: 16, 24, 30, 40, 48, 64, 96, 128, 512.
     */
    public suspend fun getBlogAvatar(
        identifier: String,
        size: Int
    ): ResponseBlogAvatar.Response? {
        val validSizes = listOf(16, 24, 30, 40, 48, 64, 96, 128, 512)
        require(size in validSizes) { "Size must be one of $validSizes" }

        val retrofitResponse = blogGetApi.getBlogAvatarHelper(
            identifier,
            size
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve a Blog's Followers.
     *
     * @param identifier An identifier for the blog.
     * @param limit Optional. The number of results to return: 1–50, inclusive.
     * @param offset Optional. Followed blog index to start at.
     */
    public suspend fun getBlogFollowers(
        identifier: String,
        limit: Int? = null,
        offset: Int? = null
    ): ResponseBlogFollowers.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogFollowersHelper(
            identifier,
            limit,
            offset
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve Blog's following.
     *
     * This method can be used to retrieve the publicly exposed list of blogs that a blog follows, in order from most
     * recently-followed to first.
     *
     * @param identifier An identifier for the blog.
     * @param limit Optional. The number of results to return: 1–50, inclusive.
     * @param offset Optional. Followed blog index to start at.
     */
    public suspend fun getBlogFollowing(
        identifier: String,
        limit: Int? = null,
        offset: Int? = null
    ): ResponseBlogFollowing.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogFollowingHelper(
            identifier,
            limit,
            offset
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Check If Followed By Blog.
     *
     * This method can be used to check if one of your blogs is followed by another blog.
     *
     * @param identifier An identifier for your blog to check.
     * @param query The name of the blog that may be following your blog.
     */
    public suspend fun getFollowedBy(
        identifier: String,
        query: String
    ): ResponseBlogFollowing.Response? {
        TODO("Implement")
    }

    /**
     * Retrieve Blog Info.
     *
     * This method returns general information about the blog, such as the title, number of posts, and other high-level data.
     *
     * @param identifier An identifier for the blog.
     */
    public suspend fun getBlogInfo(
        identifier: String
    ): ResponseBlogInfo.Response? {
        val retrofitResponse = blogGetApi.getBlogInfoHelper(
            identifier
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
     * @param identifier An identifier for the blog.
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogLikes(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogLikes.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogLikesHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve Published Posts.
     *
     * @param identifier An identifier for the blog.
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     * @param type Optional. The type of post to return. Specify one of the following: text, photo, quote, link, chat, audio, video, answer
     */
    public suspend fun getBlogPosts(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null,
        type: Post.Type? = null
    ): ResponseBlogPosts.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogPostsHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber,
            type
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve Draft Posts.
     *
     * @param identifier An identifier for the blog.
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogDrafts(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogDrafts.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogDraftsHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve Queued Posts.
     *
     * @param identifier An identifier for the blog.
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogQueue(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogQueue.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogQueueHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve Submission Posts.
     *
     * @param identifier An identifier for the blog.
     * @param postLimit Optional. The number of results to return: 1–50, inclusive
     * @param postOffset Optional. Post number to start at
     * @param afterPostId Optional. Return posts that have appeared after this ID; Use this parameter to page through the results: first get a set of posts, and then get posts since the last ID of the previous set.
     * @param beforePostId Optional. Return posts that have appeared before this ID; Use this parameter to page through the results: first get a set of posts, and then get posts before the first ID of the previous set.
     * @param afterTime Optional. Retrieve posts after the specified timestamp
     * @param beforeTime Optional. Retrieve posts before the specified timestamp.
     * @param getReblogFields Optional. Indicates whether to return reblog information (specify true or false). Returns the various reblogged_ fields.
     * @param getNotesHistory Optional. Indicates whether to return notes information (specify true or false). Returns note count and note metadata.
     * @param useNeuePostFormat Optional. Returns posts' content in NPF format instead of the legacy format.
     * @param tag Optional.
     * @param pageNumber Optional.
     */
    public suspend fun getBlogSubmissions(
        identifier: String,
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        tag: String? = null,
        pageNumber: Int? = null
    ): ResponseBlogSubmissions.Response? {
        // TODO: Validate arguments.
        val retrofitResponse = blogGetApi.getBlogSubmissionsHelper(
            identifier,
            postLimit,
            postOffset,
            afterPostId,
            beforePostId,
            afterTime,
            beforeTime,
            getReblogFields,
            getNotesHistory,
            useNeuePostFormat,
            tag,
            pageNumber
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion Blog Getters

    // region Post Getters

    // /**
    //  * Fetch posts with a given tag.
    //  *
    //  * @param tag The tag on the posts you'd like to retrieve.
    //  * @param before Optional. The timestamp of when you'd like to see posts before. If the Tag is a "featured" tag, use the "featured_timestamp" on the post object for pagination.
    //  * @param limit Optional. The number of results to return: 1–50, inclusive.
    //  * @param filter Optional. Specifies the post format to return, other than HTML: text – Plain text, no HTML; raw – As entered by the user (no post-processing); if the user writes in Markdown, the Markdown will be returned rather than HTML.
    //  */
    // suspend fun getTaggedPosts(
    //     tag: String,
    //     before: Long? = null,
    //     limit: Long? = null,
    //     filter: PostFormat? = null
    // ): ResponsePostsTagged.Response? {
    //     TODO("The get tagged posts api requires special parsing that I don't feel like implementing")
    //     val retrofitResponse = postsGetApi.getTaggedPosts(
    //         tag,
    //         before,
    //         limit,
    //         filter
    //     )
    //
    //     val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
    //     val response = retrofitResponse.body()
    //     return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    // }

    /**
     * Fetch a single post.
     *
     * @param identifier A blog identifier of the blog that posted the desired post.
     * @param postId The id of the desired post.
     * @param postFormat Optional. The format to serve the post as, either [Post.PostVersion.Legacy] or [Post.PostVersion.NPF].
     */
    public suspend fun getPost(
        identifier: String,
        postId: Long,
        postFormat: Post.PostVersion? = null
    ): ResponsePostsPost.Response? {
        val retrofitResponse = postsGetApi.getPost(
            identifier,
            postId,
            postFormat
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion Post Getters
}
