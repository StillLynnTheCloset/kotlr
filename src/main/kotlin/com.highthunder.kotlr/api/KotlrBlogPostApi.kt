package com.highthunder.kotlr.api

import com.highthunder.kotlr.CreateNewPostBody
import com.highthunder.kotlr.ReblogPostBody
import com.highthunder.kotlr.response.type.post.ResponseCreatePost
import com.highthunder.kotlr.types.Post
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

internal interface KotlrBlogPostApi {
    // region Create New Legacy Post

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param title The optional title of the post, HTML entities must be escaped
     * @param body The full post body, HTML allowed
     */
    @POST("blog/{identifier}/post?type=text")
    suspend fun createPostLegacyText(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("title")
        title: String? = null,
        @Query("body")
        body: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption, HTML allowed
     * @param link The "click-through URL" for the photo
     * @param externalUrl The photo source URL
     */
    @POST("blog/{identifier}/post?type=photo")
    suspend fun createPostLegacyPhotoExternal(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("link")
        link: String? = null,
        @Query("source")
        externalUrl: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption, HTML allowed
     * @param link The "click-through URL" for the photo
     * @param data One or more image files (submit multiple times to create a slide show), limit 10MB
     */
    // TODO: Figure out how this works.
    @POST("blog/{identifier}/post?type=photo")
    suspend fun createPostLegacyPhotoDataBinary(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("link")
        link: String? = null,
        @Query("data")
        data: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption, HTML allowed
     * @param link The "click-through URL" for the photo
     * @param dataBase64Encoded The contents of an image file encoded using base64, limit 10MB
     */
    @POST("blog/{identifier}/post?type=photo")
    suspend fun createPostLegacyPhotoEncoded(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("link")
        link: String? = null,
        @Query("data64")
        dataBase64Encoded: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param quote The full text of the quote, HTML entities must be escaped
     * @param source Cited source, HTML allowed
     */
    @POST("blog/{identifier}/post?type=quote")
    suspend fun createPostLegacyQuote(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("quote")
        quote: String,
        @Query("source")
        source: String? = null,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param title The title of the page the link points to, HTML entities should be escaped
     * @param url The link
     * @param description A user-supplied description, HTML allowed
     * @param thumbnail The url of an image to use as a thumbnail for the post
     * @param excerpt An excerpt from the page the link points to, HTML entities should be escaped
     * @param author The name of the author from the page the link points to, HTML entities should be escaped
     */
    @POST("blog/{identifier}/post?type=link")
    suspend fun createPostLegacyLink(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("title")
        title: String? = null,
        @Query("url")
        url: String,
        @Query("description")
        description: String? = null,
        @Query("thumbnail")
        thumbnail: String? = null,
        @Query("excerpt")
        excerpt: String? = null,
        @Query("author")
        author: String? = null,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param title The title of the chat
     * @param conversation The text of the conversation/chat, with dialogue labels (no HTML)
     */
    @POST("blog/{identifier}/post?type=chat")
    suspend fun createPostLegacyChat(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("title")
        title: String? = null,
        @Query("conversation")
        conversation: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param externalUrl The URL of the site that hosts the audio file (not tumblr)
     */
    @POST("blog/{identifier}/post?type=audio")
    suspend fun createPostLegacyAudioExternal(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("external_url")
        externalUrl: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param dataBase64Encoded An audio file, limit 10MB
     */
    @POST("blog/{identifier}/post?type=audio")
    suspend fun createPostLegacyAudioEncoded(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("data")
        dataBase64Encoded: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param externalUrl HTML embed code for the video or a URI to the video. If you provide an unsupported service's URI you may receive a 400 response.
     */
    @POST("blog/{identifier}/post?type=video")
    suspend fun createPostLegacyVideoExternal(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("embed")
        externalUrl: String,
    )

    /**
     * Create a New Blog Post (Legacy).
     *
     * These legacy posting flows are still available, but we encourage you to use the Neue Post Format creation route.
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param dataBase64Encoded A video file, limit 100MB
     */
    @POST("blog/{identifier}/post?type=video")
    suspend fun createPostLegacyVideoEncoded(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: String? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: String? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("data")
        dataBase64Encoded: String,
    )

    // endregion Create New Legacy Post

    // region Edit Legacy Post

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param title The optional title of the post, HTML entities must be escaped
     * @param body The full post body, HTML allowed
     */
    @POST("blog/{identifier}/post/edit?type=text")
    suspend fun editPostLegacyText(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("title")
        title: String? = null,
        @Query("body")
        body: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption, HTML allowed
     * @param link The "click-through URL" for the photo
     * @param externalUrl The photo source URL
     */
    @POST("blog/{identifier}/post/edit?type=photo")
    suspend fun editPostLegacyPhotoExternal(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("link")
        link: String? = null,
        @Query("source")
        externalUrl: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption, HTML allowed
     * @param link The "click-through URL" for the photo
     * @param data One or more image files (submit multiple times to create a slide show), limit 10MB
     */
    // TODO: Figure out how this works.
    @POST("blog/{identifier}/post/edit?type=photo")
    suspend fun editPostLegacyPhotoDataBinary(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("link")
        link: String? = null,
        @Query("data")
        data: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption, HTML allowed
     * @param link The "click-through URL" for the photo
     * @param dataBase64Encoded The contents of an image file encoded using base64, limit 10MB
     */
    @POST("blog/{identifier}/post/edit?type=photo")
    suspend fun editPostLegacyPhotoEncoded(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("link")
        link: String? = null,
        @Query("data64")
        dataBase64Encoded: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param quote The full text of the quote, HTML entities must be escaped
     * @param source Cited source, HTML allowed
     */
    @POST("blog/{identifier}/post/edit?type=quote")
    suspend fun editPostLegacyQuote(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("quote")
        quote: String,
        @Query("source")
        source: String? = null,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param title The title of the page the link points to, HTML entities should be escaped
     * @param url The link
     * @param description A user-supplied description, HTML allowed
     * @param thumbnail The url of an image to use as a thumbnail for the post
     * @param excerpt An excerpt from the page the link points to, HTML entities should be escaped
     * @param author The name of the author from the page the link points to, HTML entities should be escaped
     */
    @POST("blog/{identifier}/post/edit?type=link")
    suspend fun editPostLegacyLink(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("title")
        title: String? = null,
        @Query("url")
        url: String,
        @Query("description")
        description: String? = null,
        @Query("thumbnail")
        thumbnail: String? = null,
        @Query("excerpt")
        excerpt: String? = null,
        @Query("author")
        author: String? = null,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param title The title of the chat
     * @param conversation The text of the conversation/chat, with dialogue labels (no HTML)
     */
    @POST("blog/{identifier}/post/edit?type=chat")
    suspend fun editPostLegacyChat(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("title")
        title: String? = null,
        @Query("conversation")
        conversation: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param externalUrl The URL of the site that hosts the audio file (not tumblr)
     */
    @POST("blog/{identifier}/post/edit?type=audio")
    suspend fun editPostLegacyAudioExternal(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("external_url")
        externalUrl: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param dataBase64Encoded An audio file, limit 10MB
     */
    @POST("blog/{identifier}/post/edit?type=audio")
    suspend fun editPostLegacyAudioEncoded(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("data")
        dataBase64Encoded: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param externalUrl HTML embed code for the video or a URI to the video. If you provide an unsupported service's URI you may receive a 400 response.
     */
    @POST("blog/{identifier}/post/edit?type=video")
    suspend fun editPostLegacyVideoExternal(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("embed")
        externalUrl: String,
    )

    /**
     * Edit a Blog Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param postId The id of the post to edit.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param caption The user-supplied caption
     * @param dataBase64Encoded A video file, limit 100MB
     */
    @POST("blog/{identifier}/post/edit?type=video")
    suspend fun editPostLegacyVideoEncoded(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("id")
        postId: Long,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("caption")
        caption: String? = null,
        @Query("data")
        dataBase64Encoded: String,
    )

    // endregion Edit Legacy Post

    // region Reblog Legacy Post

    /**
     * Reblog a Post (Legacy).
     *
     * @param identifier The identifier of the blog to post to.
     * @param state The state of the post. Specify one of the following: published, draft, queue, private
     * @param tags Comma-separated tags for this post
     * @param tweet Manages the autotweet (if enabled) for this post: set to off for no tweet, or enter text to override the default tweet
     * @param date The GMT date and time of the post, as a string
     * @param format Sets the format type of post. Supported formats are: html & markdown
     * @param slug Add a short text summary to the end of the post URL
     * @param nativeInlineImages Convert any external image URLs to Tumblr image URLs
     * @param postId The ID of the reblogged post on tumblelog.
     * @param reblogKey The reblog key for the reblogged post – get the reblog key with a /posts request
     * @param comment A comment added to the reblogged post
     */
    @POST("blog/{identifier}/post/reblog")
    suspend fun reblogPostLegacy(
        @Path("identifier", encoded = true)
        identifier: String,
        @Query("state")
        state: Post.State? = null,
        @Query("tags")
        tags: String? = null,
        @Query("tweet")
        tweet: String? = null,
        @Query("date")
        date: String? = null,
        @Query("format")
        format: Post.PostFormat? = null,
        @Query("slug")
        slug: String? = null,
        @Query("native_inline_images")
        nativeInlineImages: String? = null,
        @Query("id")
        postId: Long,
        @Query("reblog_key")
        reblogKey: Long,
        @Query("comment")
        comment: String? = null,
    )

    // endregion Reblog Legacy Post

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
     * @param identifier An identifier of the Blog that this post should be published to.
     * @param createBody The payload of this post.
     */
    @POST("blog/{identifier}/posts")
    suspend fun createNewPost(
        @Path("identifier", encoded = true)
        identifier: String,
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
     * @param identifier An identifier of the Blog that this post should be published to.
     * @param createBody The payload of this post.
     * @param contentFiles The content parts that should be uploaded with this post.
     */
    @Multipart
    @POST("blog/{identifier}/posts")
    suspend fun createNewPostWithContentFiles(
        @Path("identifier", encoded = true)
        identifier: String,
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
     * @param identifier An identifier of the Blog that this post should be published to.
     * @param reblogBody The payload of this post.
     */
    @POST("blog/{identifier}/posts")
    // TODO: Add a wrapper function to remove the OKHTTP response type
    suspend fun reblogPost(
        @Path("identifier", encoded = true)
        identifier: String,
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
     * @param identifier An identifier of the Blog that this post should be published to.
     * @param reblogBody The payload of this post.
     * @param contentFiles The content parts that should be uploaded with this post.
     */
    @Multipart
    @POST("blog/{identifier}/posts")
    suspend fun reblogPostWithContentFiles(
        @Path("identifier", encoded = true)
        identifier: String,
        @Part
        reblogBody: ReblogPostBody,
        @Part
        contentFiles: List<MultipartBody.Part>,
    ): Response<ResponseCreatePost.Response>

    // endregion Reblog NPF Post
}
