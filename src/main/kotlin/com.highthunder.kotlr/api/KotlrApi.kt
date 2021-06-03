package com.highthunder.kotlr.api

import com.highthunder.kotlr.getApi
import com.highthunder.kotlr.postbody.CreateNewPostBody
import com.highthunder.kotlr.postbody.FilteredContentPostBody
import com.highthunder.kotlr.postbody.FollowPostBody
import com.highthunder.kotlr.postbody.LikePostBody
import com.highthunder.kotlr.postbody.ReblogPostBody
import com.highthunder.kotlr.response.RateLimitMetaData
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowedBy
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import com.highthunder.kotlr.response.type.post.ResponseCreatePost
import com.highthunder.kotlr.response.type.post.ResponsePostNotes
import com.highthunder.kotlr.response.type.post.ResponsePostsPost
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.response.type.user.ResponseUserFilteredContent
import com.highthunder.kotlr.response.type.user.ResponseUserFollow
import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import com.highthunder.kotlr.response.type.user.ResponseUserLike
import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import com.highthunder.kotlr.types.Post
import okhttp3.MultipartBody

/**
 * KotlrApi - The main class for performing requests to the Tumblr API.
 *
 * Get an instance by calling [getApi].
 */
public class KotlrApi internal constructor(
    private val userGetApi: KotlrUserGetApi,
    private val blogGetApi: KotlrBlogGetApi,
    private val userPostApi: KotlrUserPostApi,
    private val blogPostApi: KotlrBlogPostApi,
    private val userDeleteApi: KotlrUserDeleteApi,
    private val postsGetApi: KotlrPostsGetApi,
) {
    private companion object {
        private val validAvatarSizes = listOf(16, 24, 30, 40, 48, 64, 96, 128, 512)
    }

    // region User GETs

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
    ): ResponseUserLikes.Response? {
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = userGetApi.getUserLikesHelper(
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
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
    ): ResponseUserDashboard.Response? {
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = userGetApi.getUserDashHelper(
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
            type = type,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to retrieve the blogs followed by the user whose OAuth credentials are submitted with the request.
     *
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive
     * @param pagingOffset Optional. Result number to start at
     */
    public suspend fun getUserFollowing(
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseUserFollowing.Response? {
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = userGetApi.getUserFollowingHelper(
            pagingLimit,
            pagingOffset,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to retrieve the content filtering strings of the user whose OAuth credentials are submitted with the request.
     */
    public suspend fun getContentFilters(): ResponseUserFilteredContent.Response? {
        val retrofitResponse = userGetApi.getContentFilters()

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseUserFollow.Response? {
        validateUrlAndEmail(url, email)

        val retrofitResponse = userPostApi.followBlog(
            followPostBody = FollowPostBody(url, email)
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to unfollow a blog.
     *
     * @param url The url of the blog.
     * @param email The email of the blog if the user has enabled "allow people to find this blog by email"
     */
    public suspend fun unfollowBlog(
        url: String? = null,
        email: String? = null,
    ): ResponseUserFollow.Response? {
        validateUrlAndEmail(url, email)

        val retrofitResponse = userPostApi.unfollowBlog(
            followPostBody = FollowPostBody(url, email)
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to like a post.
     *
     * @param id The postId of the post to like.
     * @param reblogKey The reblogKey of the post to like.
     */
    public suspend fun likePost(
        id: Long,
        reblogKey: String,
    ): ResponseUserLike.Response? {
        validatePostId(id)
        validateReblogKey(reblogKey)

        val retrofitResponse = userPostApi.likePost(
            likePostBody = LikePostBody(id, reblogKey)
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to unlike a post.
     *
     * @param id The postId of the post to unlike.
     * @param reblogKey The reblogKey of the post to unlike.
     */
    public suspend fun unlikePost(
        id: Long,
        reblogKey: String,
    ): ResponseUserLike.Response? {
        validatePostId(id)
        validateReblogKey(reblogKey)

        val retrofitResponse = userPostApi.unlikePost(
            likePostBody = LikePostBody(id, reblogKey)
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to add a content filter.
     *
     * @param contentFilter The text that a filter filters on.
     */
    public suspend fun addContentFilter(
        contentFilter: String,
    ): ResponseUserLike.Response? {
        validateContentFilter(contentFilter)

        val body = FilteredContentPostBody(contentFilter)

        val retrofitResponse = userPostApi.addContentFilter(
            filteredContent = body
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to add a group of content filters.
     *
     * @param contentFilters The text that a filter filters on.
     */
    public suspend fun addContentFilters(
        contentFilters: Iterable<String>,
    ): ResponseUserLike.Response? {
        contentFilters.forEach { validateContentFilter(it) }

        val body = FilteredContentPostBody(contentFilters)

        val retrofitResponse = userPostApi.addContentFilter(
            filteredContent = body
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Use this method to add a group of content filters.
     *
     * @param contentFilters The text that a filter filters on.
     */
    public suspend fun addContentFilters(
        vararg contentFilters: String,
    ): ResponseUserLike.Response? {
        return addContentFilters(contentFilters.toList())
    }

    // endregion User POSTs

    // region User DELETEs

    /**
     * Use this method to remove a content filter.
     *
     * @param contentFilter The text that a filter filters on.
     */
    public suspend fun deleteContentFilter(
        contentFilter: String,
    ): ResponseUserFilteredContent.Response? {
        validateContentFilter(contentFilter)

        val retrofitResponse = userDeleteApi.filterContent(
            filteredContent = contentFilter
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseBlogAvatar.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogGetApi.getBlogAvatarHelper(
            blogIdentifier,
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
     * @param blogIdentifier A blog identifier.
     * @param size The size of the avatar (square, one value for both length and width). Must be one of the values: 16, 24, 30, 40, 48, 64, 96, 128, 512.
     */
    public suspend fun getBlogAvatar(
        blogIdentifier: String,
        size: Int,
    ): ResponseBlogAvatar.Response? {
        validateBlogIdentifier(blogIdentifier)
        validateAvatarSize(size)

        val retrofitResponse = blogGetApi.getBlogAvatarHelper(
            blogIdentifier,
            size,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseBlogFollowers.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = blogGetApi.getBlogFollowersHelper(
            blogIdentifier,
            pagingLimit,
            pagingOffset,
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
     * @param blogIdentifier An identifier for the blog.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive.
     * @param pagingOffset Optional. Followed blog index to start at.
     */
    public suspend fun getBlogFollowing(
        blogIdentifier: String,
        pagingLimit: Int? = null,
        pagingOffset: Long? = null,
    ): ResponseBlogFollowing.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)

        val retrofitResponse = blogGetApi.getBlogFollowingHelper(
            blogIdentifier,
            pagingLimit,
            pagingOffset,
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
     * @param blogIdentifier An identifier for your blog to check.
     * @param query The name of the blog that may be following your blog.
     */
    public suspend fun getBlogFollowedBy(
        blogIdentifier: String,
        query: String,
    ): ResponseBlogFollowedBy.Response? {
        validateBlogIdentifier(blogIdentifier)
        validateBlogIdentifier(query)

        val retrofitResponse = blogGetApi.getBlogFollowedByHelper(
            blogIdentifier,
            query,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    /**
     * Retrieve Blog Info.
     *
     * This method returns general information about the blog, such as the title, number of posts, and other high-level data.
     *
     * @param blogIdentifier An identifier for the blog.
     */
    public suspend fun getBlogInfo(
        blogIdentifier: String,
    ): ResponseBlogInfo.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogGetApi.getBlogInfoHelper(
            blogIdentifier,
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
    ): ResponseBlogLikes.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogLikesHelper(
            identifier = blogIdentifier,
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseBlogPosts.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogPostsHelper(
            identifier = blogIdentifier,
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
            type = type,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseBlogDrafts.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogDraftsHelper(
            identifier = blogIdentifier,
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseBlogQueue.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogQueueHelper(
            identifier = blogIdentifier,
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseBlogSubmissions.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePagingLimit(pagingLimit)
        validatePagingOffset(pagingOffset)
        validatePostId(afterPostId)
        validatePostId(beforePostId)
        validateTimestamp(afterTime)
        validateTimestamp(beforeTime)
        validateReblogsAndNotes(getReblogFields, getNotesHistory)
        validateTag(tag)
        validatePageNumber(pageNumber)

        val retrofitResponse = blogGetApi.getBlogSubmissionsHelper(
            identifier = blogIdentifier,
            postLimit = pagingLimit,
            postOffset = pagingOffset,
            afterPostId = afterPostId,
            beforePostId = beforePostId,
            afterTime = afterTime,
            beforeTime = beforeTime,
            getReblogFields = getReblogFields,
            getNotesHistory = getNotesHistory,
            useNeuePostFormat = true,
            tag = tag,
            pageNumber = pageNumber,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.createNewPost(
            blogIdentifier = blogIdentifier,
            createBody = createBody,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.createNewPostWithContentFiles(
            blogIdentifier = blogIdentifier,
            createBody = createBody,
            contentFiles = contentFiles,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.reblogPost(
            blogIdentifier = blogIdentifier,
            reblogBody = reblogBody,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponseCreatePost.Response? {
        validateBlogIdentifier(blogIdentifier)

        val retrofitResponse = blogPostApi.reblogPostWithContentFiles(
            blogIdentifier = blogIdentifier,
            reblogBody = reblogBody,
            contentFiles = contentFiles,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion Blog POSTs

    // region Post GETs

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
    //         filter,
    //     )
    //
    //     val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
    //     val response = retrofitResponse.body()
    //     return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    // }

    /**
     * Fetch a single post.
     *
     * @param blogIdentifier A blog identifier of the blog that posted the desired post.
     * @param postId The id of the desired post.
     */
    public suspend fun getPost(
        blogIdentifier: String,
        postId: Long,
    ): ResponsePostsPost.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePostId(postId)

        val retrofitResponse = postsGetApi.getPost(
            identifier = blogIdentifier,
            postId = postId,
            postFormat = "npf",
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

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
    ): ResponsePostNotes.Response? {
        validateBlogIdentifier(blogIdentifier)
        validatePostId(postId)
        validateTimestamp(beforeTimestamp)

        val retrofitResponse = postsGetApi.getPostNotes(
            blogIdentifier,
            postId,
            beforeTimestamp,
            mode,
        )

        val rateLimitMetaData = RateLimitMetaData(retrofitResponse.headers())
        val response = retrofitResponse.body()
        return response?.copy(meta = response.meta.copy(rateLimitMetaData = rateLimitMetaData))
    }

    // endregion Post GETs

    // region Argument Validation

    private fun validateBlogIdentifier(blogIdentifier: String) {
        require(blogIdentifier.isNotBlank()) { "Blog identifiers must not be blank." }
    }

    private fun validatePostId(postId: Long?) {
        require(postId == null || postId >= 0) { "Post ids must not be less than 0." }
    }

    private fun validatePagingLimit(limit: Int?) {
        require(limit == null || limit in 1..50) { "Paging limit must be in the range [1,50]." }
    }

    private fun validatePagingOffset(offset: Long?) {
        require(offset == null || offset >= 0) { "Paging offset must be non-negative." }
    }

    private fun validatePageNumber(pageNumber: Int?) {
        require(pageNumber == null || pageNumber >= 0) { "Page number must be non-negative." }
    }

    private fun validateReblogKey(reblogKey: String?) {
        require(reblogKey == null || reblogKey.isNotBlank()) { "Reblog key must not be blank." }
    }

    private fun validateReblogsAndNotes(reblogFields: Boolean?, notesHistory: Boolean?) {
        require(reblogFields == null || notesHistory == null || reblogFields xor notesHistory) {
            "Only one of reblog fields or notes history can be provided."
        }
    }

    private fun validateUrlAndEmail(url: String?, email: String?) {
        require((url.isNullOrBlank()) xor (email.isNullOrBlank())) { "Only one of url or email can be provided." }
    }

    private fun validateTag(tag: String?) {
        require(tag == null || tag.isNotBlank()) { "Tags must not be blank." }
    }

    private fun validateContentFilter(contentFilter: String?) {
        require(contentFilter == null || contentFilter.isNotBlank()) {
            "Content filters must not be blank."
        }
        require(contentFilter == null || contentFilter.length <= 250) {
            "Content filters must not be more than 250 characters in length."
        }
    }

    private fun validateTimestamp(timestamp: Long?) {
        // TODO: Decide if there is any reasonable validation for times.
    }

    private fun validateAvatarSize(size: Int?) {
        require(size == null || size in validAvatarSizes) { "Size must be one of $validAvatarSizes." }
    }

    // endregion Argument Validation
}
