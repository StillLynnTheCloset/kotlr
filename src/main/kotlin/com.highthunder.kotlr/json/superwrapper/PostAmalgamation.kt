package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.json.wrapper.PlayerWrapper
import com.highthunder.kotlr.types.*
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.legacy.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * PostAmalgamation - A class to hold every possible field for [Post] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * [Post]
 * @param type The type of the post.
 * @param blogName The short name used to uniquely identify a blog.
 * @param id The post's unique ID.
 * @param blog A standard API-formatted "short blog info" object.
 * @param postUrl The location of the post.
 * @param timestamp The time of the post, in seconds since the epoch.
 * @param date The GMT date and time of the post, as a string.
 * @param format The post format: html, raw, or markdown.
 * @param reblogKey The key used to reblog this post.
 * @param tags Tags applied to the post.
 * @param isBookmarklet Indicates whether the post was created via the Tumblr bookmarklet.
 * @param isMobile Indicates whether the post was created via mobile/email publishing.
 * @param sourceUrl The URL for the source of the content (for quotes, reblogs, etc.).
 * @param sourceTitle The title of the source site.
 * @param isLiked Indicates if a user has already liked a post or not.
 * @param state Indicates the current state of the post.
 * @param totalPosts The total number of post available for this request, useful for paginating through results.
 * @param anonymous TODO: Documentation
 * @param content The array of content that constitutes the body of a post in the Neue Post Format(NPF).
 * @param trail The previous Posts in the reblog trail. In order of oldest (the root Post) to the newest (the parent Post).
 * @param layout The layouts of the blocks in this post.
 * @param postAuthor The id of the author of the post.
 * @param shortUrl The short URL for this post.
 * @param summary A short description of this post.
 * @param isBlocksFormat Whether or not this post is using the new block format(NPF).
 * @param likedTimestamp The timestamp of when this post was liked.
 * @param slug The slug.
 * @param noteCount The note count for this post.
 * @param recommendedSource The source of a recommended post.
 * @param recommendedColor The recommended color for styling this post.
 * @param postAuthorIsAdult Indicates whether or not the author of this post is an adult only blog.
 * @param isSubmission Indicates whether or not this post is a submission.
 * @param canLike Indicates whether or not the current user can like this post.
 * @param canReblog Indicates whether or not the current user can reblog this post.
 * @param canSendInMessage Indicates whether or not this post can be sent in a message.
 * @param canReply Indicates whether or not the current user can reply to this post.
 * @param displayAvatar Indicates whether or not the poster's avatar should be shown with this post.
 * @param followed Indicates whether or not the current user follows the author of this post.
 * @param reblogData TODO: Documentation
 * @param rebloggedFromId The ID of the post that this post reblogged.
 * @param rebloggedFromUrl TODO: Documentation
 * @param rebloggedFromName The name of the blog that this post reblogged.
 * @param rebloggedFromTitle TODO: Documentation
 * @param rebloggedFromUuid TODO: Documentation
 * @param rebloggedFromCanMessage TODO: Documentation
 * @param rebloggedFromFollowing TODO: Documentation
 * @param rebloggedRootId The ID of the post that this post reblogged.
 * @param rebloggedRootUrl TODO: Documentation
 * @param rebloggedRootName The name of the blog that this post reblogged.
 * @param rebloggedRootTitle TODO: Documentation
 * @param rebloggedRootUuid TODO: Documentation
 * @param rebloggedRootCanMessage TODO: Documentation
 * @param rebloggedRootFollowing TODO: Documentation
 * @param notes TODO: Documentation
 * @param publishTime TODO: Documentation
 * @param queueState TODO: Documentation
 *
 * [AnswerPost]
 * @param askingName The blog that sent this ask, or answered it if it was privately answered.
 * @param askingUrl The blog URL that sent this ask, or answered it if it was privately answered.
 * @param question The question being asked.
 * @param answer The answer given.
 * @param answerAbstract TODO: Documentation
 *
 * [AudioPost]
 * @param caption The user-supplied caption.
 *      NOTE: Duplicated by [photoPost,videoPost]
 * @param captionAbstract TODO: Documentation
 * @param embed HTML for embedding the audio player.
 * @param audio_url The url of the audio file.
 * @param plays Number of times the audio post has been played.
 * @param album_art Location of the audio file's ID3 album art image.
 * @param artist The audio file's ID3 artist value.
 * @param album The audio file's ID3 album value.
 * @param trackName The audio file's ID3 title value.
 * @param trackNumber The audio file's ID3 track value.
 * @param track TODO: Documentation
 * @param year The audio file's ID3 year value.
 * @param audioSourceUrl TODO: Documentation
 * @param audioType TODO: Documentation
 * @param external TODO: Documentation
 * @param providerUrl TODO: Documentation
 *
 * [ChatPost]
 * @param title The optional title of the post.
 *      NOTE: Duplicated by [linkPost, textPost]
 * @param body The full chat body.
 *      NOTE: Duplicated by [textPost,]
 * @param dialogue List of dialog objects describing the chat in detail.
 *
 * [LinkPost]
 * @param title The title of the page the link points to.
 *      NOTE: Duplicated from ChatPost
 * @param description A user-supplied description.
 * @param url The link!
 * @param author The author of the article the link points to.
 * @param linkAuthor TODO: Documentation
 * @param linkImage TODO: Documentation
 * @param linkImageDimensions TODO: Documentation
 * @param excerpt An excerpt from the article the link points to.
 * @param publisher The publisher of the article the link points to.
 * @param photos Photos to give a preview of the article that the link points to.
 *      NOTE: Duplicated by [photoPost,]
 * @param body The full post body.
 *      NOTE: Duplicated from ChatPost
 *
 * [PhotoPost]
 * @param caption The user-supplied caption.
 *      NOTE: Duplicated from AudioPost
 * @param width The width of the photo or photoset.
 * @param height The height of the photo or photoset.
 * @param photos The photos in this post.
 *      NOTE: Duplicated from LinkPost
 * @param imagePermalink A link to this image.
 * @param linkUrl TODO: Documentation
 * @param photosetLayout TODO: Documentation
 * @param panorama TODO: Documentation
 *
 * [QuotePost]
 * @param text The text of the quote (can be modified by the user when posting).
 * @param source Full HTML for the source of the quote Example: <a href="...">Steve Jobs</a>.
 *
 * [TextPost]
 * @param title The optional title of the post.
 *      NOTE: Duplicated from ChatPost
 * @param body The full post body.
 *      NOTE: Duplicated from ChatPost
 * @param abstract TODO: Documentation
 *
 * [VideoPost]
 * @param player The list of [Video]s in this post.
 * @param caption The user-supplied caption.
 *      NOTE: Duplicated from AudioPost
 * @param videoUrl A direct link to the video file.
 * @param html5Capable Indicates if this video is HTML5.
 * @param thumbnailUrl The location of the thumbnail of this video.
 * @param thumbnailWidth The width of the thumbnail.
 * @param thumbnailHeight The height of the thumbnail.
 * @param duration The length of this video in seconds.
 * @param videoType The source of this video (tumblr, youtube, instagram, vimeo, vine(rip), etc.).
 * @param videoData TODO: Documentation
 * @param permalinkUrl TODO: Documentation
 */
@JsonClass(generateAdapter = true)
data class PostAmalgamation(

    // region Defaults

    @Json(name = "type")
    var type: Post.Type? = null,
    @Json(name = "blog_name")
    var blogName: String? = null,
    @Json(name = "id")
    var id: Long? = null,
    @Json(name = "blog")
    var blog: Blog? = null,
    @Json(name = "post_url")
    var postUrl: String? = null,
    @Json(name = "timestamp")
    var timestamp: Long? = null,
    @Json(name = "date")
    var date: String? = null,
    @Json(name = "format")
    var format: Post.PostFormat? = null,
    @Json(name = "reblog_key")
    var reblogKey: String? = null,
    @Json(name = "tags")
    var tags: List<String>? = null,
    @Json(name = "bookmarklet")
    var isBookmarklet: Boolean? = null,
    @Json(name = "mobile")
    var isMobile: Boolean? = null,
    @Json(name = "source_url")
    var sourceUrl: String? = null,
    @Json(name = "source_title")
    var sourceTitle: String? = null,
    @Json(name = "liked")
    var isLiked: Boolean? = null,
    @Json(name = "state")
    var state: Post.State? = null,
    @Json(name = "total_posts")
    var totalPosts: Int? = null,
    @Json(name = "is_anonymous")
    var anonymous: Boolean? = null,

    // endregion

    // region Situational Fields

    @Json(name = "content")
    var content: List<PostContent>? = null,
    @Json(name = "trail")
    var trail: List<Trail>? = null,
    @Json(name = "layout")
    var layout: List<BlockLayout>? = null,
    @Json(name = "post_author")
    var postAuthor: String? = null,
    @Json(name = "short_url")
    var shortUrl: String? = null,
    @Json(name = "summary")
    var summary: String? = null,
    @Json(name = "is_blocks_post_format")
    var isBlocksFormat: Boolean? = null,
    @Json(name = "liked_timestamp")
    var likedTimestamp: Long? = null,
    @Json(name = "slug")
    var slug: String? = null,
    @Json(name = "note_count")
    var noteCount: Long? = null,
    @Json(name = "recommended_source")
    var recommendedSource: String? = null,
    @Json(name = "recommended_color")
    var recommendedColor: String? = null,
    @Json(name = "post_author_is_adult")
    var postAuthorIsAdult: Boolean? = null,
    @Json(name = "is_submission")
    var isSubmission: Boolean? = null,
    @Json(name = "can_like")
    var canLike: Boolean? = null,
    @Json(name = "can_reblog")
    var canReblog: Boolean? = null,
    @Json(name = "can_send_in_message")
    var canSendInMessage: Boolean? = null,
    @Json(name = "can_reply")
    var canReply: Boolean? = null,
    @Json(name = "display_avatar")
    var displayAvatar: Boolean? = null,
    @Json(name = "followed")
    var followed: Boolean? = null,
    @Json(name = "reblog")
    var reblogData: ReblogData? = null,
    @Json(name = "reblogged_from_id")
    var rebloggedFromId: Long? = null,
    @Json(name = "reblogged_from_url")
    var rebloggedFromUrl: String? = null,
    @Json(name = "reblogged_from_name")
    var rebloggedFromName: String? = null,
    @Json(name = "reblogged_from_title")
    var rebloggedFromTitle: String? = null,
    @Json(name = "reblogged_from_uuid")
    var rebloggedFromUuid: String? = null,
    @Json(name = "reblogged_from_can_message")
    var rebloggedFromCanMessage: Boolean? = null,
    @Json(name = "reblogged_from_following")
    var rebloggedFromFollowing: Boolean? = null,
    @Json(name = "reblogged_root_id")
    var rebloggedRootId: Long? = null,
    @Json(name = "reblogged_root_url")
    var rebloggedRootUrl: String? = null,
    @Json(name = "reblogged_root_name")
    var rebloggedRootName: String? = null,
    @Json(name = "reblogged_root_title")
    var rebloggedRootTitle: String? = null,
    @Json(name = "reblogged_root_uuid")
    var rebloggedRootUuid: String? = null,
    @Json(name = "reblogged_root_can_message")
    var rebloggedRootCanMessage: Boolean? = null,
    @Json(name = "reblogged_root_following")
    var rebloggedRootFollowing: Boolean? = null,
    @Json(name = "notes")
    var notes: List<NoteData>? = null,
    @Json(name = "scheduled_publish_time")
    var publishTime: Long? = null,
    @Json(name = "queued_state")
    var queueState: Post.QueueState? = null,

    // endregion

    // region Answer Post

    @Json(name = "asking_name")
    var askingName: String? = null,
    @Json(name = "asking_url")
    var askingUrl: String? = null,
    @Json(name = "question")
    var question: String? = null,
    @Json(name = "answer")
    var answer: String? = null,
    @Json(name = "answer_abstract")
    var answerAbstract: String? = null,

    // endregion

    // region Audio Post

    @Json(name = "caption")
    var caption: String? = null,
    @Json(name = "caption_abstract")
    var captionAbstract: String? = null,
    @Json(name = "embed")
    var embed: String? = null,
    @Json(name = "audio_url")
    var audio_url: String? = null,
    @Json(name = "plays")
    var plays: Int? = null,
    @Json(name = "album_art")
    var album_art: String? = null,
    @Json(name = "artist")
    var artist: String? = null,
    @Json(name = "album")
    var album: String? = null,
    @Json(name = "track_name")
    var trackName: String? = null,
    @Json(name = "track_number")
    var trackNumber: Int? = null,
    @Json(name = "track")
    var track: String? = null,
    @Json(name = "year")
    var year: Int? = null,
    @Json(name = "audio_source_url")
    var audioSourceUrl: String? = null,
    @Json(name = "audio_type")
    var audioType: String? = null,
    @Json(name = "is_external")
    var external: Boolean? = null,
    @Json(name = "provider_uri")
    var providerUrl: String? = null,

    // endregion

    // region Chat Post

    @Json(name = "title")
    var title: String? = null,
    @Json(name = "body")
    var body: String? = null,
    @Json(name = "dialogue")
    var dialogue: List<Dialogue>? = null,

    // endregion

    // region Link Post

    @Json(name = "description")
    var description: String? = null,
    @Json(name = "url")
    var url: String? = null,
    @Json(name = "author")
    var author: String? = null,
    @Json(name = "link_author")
    var linkAuthor: String? = null,
    @Json(name = "link_image")
    var linkImage: String? = null,
    @Json(name = "link_image_dimensions")
    var linkImageDimensions: PhotoSize? = null,
    @Json(name = "excerpt")
    var excerpt: String? = null,
    @Json(name = "publisher")
    var publisher: String? = null,
    @Json(name = "photos")
    var photos: List<Photo>? = null,

    // endregion

    // region Photo Post

    @Json(name = "width")
    var width: Int? = null,
    @Json(name = "height")
    var height: Int? = null,
    @Json(name = "image_permalink")
    var imagePermalink: String? = null,
    @Json(name = "link_url")
    var linkUrl: String? = null,
    @Json(name = "photoset_layout")
    var photosetLayout: String? = null,
    @Json(name = "is_panorama")
    var panorama: Boolean? = null,

    // endregion

    // region Quote Post

    @Json(name = "text")
    var text: String? = null,
    @Json(name = "source")
    var source: String? = null,

    // endregion

    // region Text Post

    @Json(name = "body_abstract")
    var abstract: String? = null,

    // endregion

    // region Video Post

    @Json(name = "player")
    var player: PlayerWrapper? = null,
    @Json(name = "video_url")
    var videoUrl: String? = null,
    @Json(name = "html5_capable")
    var html5Capable: Boolean? = null,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String? = null,
    @Json(name = "thumbnail_width")
    val thumbnailWidth: Int? = null,
    @Json(name = "thumbnail_height")
    val thumbnailHeight: Int? = null,
    @Json(name = "duration")
    var duration: Double? = null,
    @Json(name = "video_type")
    var videoType: String? = null,
    @Json(name = "video")// TODO: Figure out how to parse this one
    var videoData: Any? = null,
    @Json(name = "permalink_url")
    var permalinkUrl: String? = null

    // endregion

) {

    // region Answer Constructor

    constructor(post: AnswerPost) : this(
        type = Post.Type.Answer,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        askingName = post.askingName,
        askingUrl = post.askingUrl,
        question = post.question,
        answer = post.answer,
        answerAbstract = post.answerAbstract
    )

    // endregion

    // region Audio Constructor

    constructor(post: AudioPost) : this(
        type = Post.Type.Audio,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        caption = post.caption,
        captionAbstract = post.captionAbstract,
        player = PlayerWrapper(contentString = post.player),
        audio_url = post.audioUrl,
        plays = post.plays,
        album_art = post.album_art,
        artist = post.artist,
        album = post.album,
        trackName = post.trackName,
        trackNumber = post.trackNumber,
        track = post.track,
        year = post.year,
        external = post.external,
        providerUrl = post.providerUrl,
        audioSourceUrl = post.audioSourceUrl,
        audioType = post.audioType,
        embed = post.embed
    )

    // endregion

    // region Chat Constructor

    constructor(post: ChatPost) : this(
        type = Post.Type.Chat,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        title = post.title,
        body = post.body,
        dialogue = post.dialogue
    )

    // endregion

    // region Link Constructor

    constructor(post: LinkPost) : this(
        type = Post.Type.Link,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        title = post.title,
        description = post.description,
        url = post.url,
        author = post.author,
        linkAuthor = post.linkAuthor,
        linkImage = post.linkImage,
        linkImageDimensions = post.linkImageDimensions,
        excerpt = post.excerpt,
        publisher = post.publisher,
        photos = post.photos,
        body = post.body
    )

    // endregion

    // region Photo Constructor

    constructor(post: PhotoPost) : this(
        type = Post.Type.Photo,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        caption = post.caption,
        captionAbstract = post.captionAbstract,
        width = post.width,
        height = post.height,
        photos = post.photos,
        linkUrl = post.linkUrl,
        imagePermalink = post.imagePermalink,
        panorama = post.panorama,
        photosetLayout = post.photosetLayout
    )

    // endregion

    // region Quote Constructor

    constructor(post: QuotePost) : this(
        type = Post.Type.Quote,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        text = post.text,
        source = post.source
    )

    // endregion

    // region Text Constructor

    constructor(post: TextPost) : this(
        type = Post.Type.Text,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        title = post.title,
        abstract = post.abstract,
        body = post.body
    )

    // endregion

    // region Video Constructor

    constructor(post: VideoPost) : this(
        type = Post.Type.Video,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState,
        player = PlayerWrapper(contentList = post.player),
        caption = post.caption,
        videoUrl = post.videoUrl,
        html5Capable = post.html5Capable,
        thumbnailUrl = post.thumbnailUrl,
        thumbnailWidth = post.thumbnailWidth,
        thumbnailHeight = post.thumbnailHeight,
        duration = post.duration,
        videoData = post.videoData,
        permalinkUrl = post.permalinkUrl,
        videoType = post.videoType
    )

    // endregion

    // region Block Constructor

    constructor(post: BlockPost) : this(
        type = Post.Type.Block,
        blogName = post.blogName,
        id = post.id,
        blog = post.blog,
        postUrl = post.postUrl,
        timestamp = post.timestamp,
        date = post.date,
        format = post.format,
        reblogKey = post.reblogKey,
        tags = post.tags,
        isBookmarklet = post.isBookmarklet,
        isMobile = post.isMobile,
        sourceUrl = post.sourceUrl,
        sourceTitle = post.sourceTitle,
        isLiked = post.isLiked,
        state = post.state,
        totalPosts = post.totalPosts,
        anonymous = post.anonymous,
        content = post.content,
        trail = post.trail,
        layout = post.layout,
        postAuthor = post.postAuthor,
        shortUrl = post.shortUrl,
        summary = post.summary,
        isBlocksFormat = post.isBlocksFormat,
        likedTimestamp = post.likedTimestamp,
        slug = post.slug,
        noteCount = post.noteCount,
        recommendedSource = post.recommendedSource,
        recommendedColor = post.recommendedColor,
        postAuthorIsAdult = post.postAuthorIsAdult,
        isSubmission = post.isSubmission,
        canLike = post.canLike,
        canReblog = post.canReblog,
        canSendInMessage = post.canSendInMessage,
        canReply = post.canReply,
        displayAvatar = post.displayAvatar,
        followed = post.followed,
        reblogData = post.reblogData,
        rebloggedFromId = post.rebloggedFromId,
        rebloggedFromUrl = post.rebloggedFromUrl,
        rebloggedFromName = post.rebloggedFromName,
        rebloggedFromTitle = post.rebloggedFromTitle,
        rebloggedFromUuid = post.rebloggedFromUuid,
        rebloggedFromCanMessage = post.rebloggedFromCanMessage,
        rebloggedFromFollowing = post.rebloggedFromFollowing,
        rebloggedRootId = post.rebloggedRootId,
        rebloggedRootUrl = post.rebloggedRootUrl,
        rebloggedRootName = post.rebloggedRootName,
        rebloggedRootTitle = post.rebloggedRootTitle,
        rebloggedRootUuid = post.rebloggedRootUuid,
        rebloggedRootCanMessage = post.rebloggedRootCanMessage,
        rebloggedRootFollowing = post.rebloggedRootFollowing,
        notes = post.notes,
        publishTime = post.publishTime,
        queueState = post.queueState
    )

    // endregion

    /**
     * TODO: Documentation
     */
    fun toAnswerPost(): AnswerPost {
        return AnswerPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            askingName, askingUrl, question, answer, answerAbstract
        )
    }

    /**
     * TODO: Documentation
     */
    fun toAudioPost(): AudioPost {
        return AudioPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            caption, captionAbstract, player?.contentString, audio_url, plays, album_art,
            artist, album, trackName, trackNumber, track, year, external, providerUrl,
            audioSourceUrl, audioType, embed
        )
    }

    /**
     * TODO: Documentation
     */
    fun toChatPost(): ChatPost {
        return ChatPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            title, body, dialogue
        )
    }

    /**
     * TODO: Documentation
     */
    fun toLinkPost(): LinkPost {
        return LinkPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            title, description, url, author, linkAuthor, linkImage, linkImageDimensions,
            excerpt, publisher, photos, body
        )
    }

    /**
     * TODO: Documentation
     */
    fun toPhotoPost(): PhotoPost {
        return PhotoPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            caption, captionAbstract, width, height, photos, linkUrl, imagePermalink, panorama, photosetLayout
        )
    }

    /**
     * TODO: Documentation
     */
    fun toQuotePost(): QuotePost {
        return QuotePost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            text, source
        )
    }

    /**
     * TODO: Documentation
     */
    fun toTextPost(): TextPost {
        return TextPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            title, abstract, body
        )
    }

    /**
     * TODO: Documentation
     */
    fun toVideoPost(): VideoPost {
        return VideoPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState,

            player?.contentList, caption, videoUrl, html5Capable, thumbnailUrl, thumbnailWidth,
            thumbnailHeight, duration, videoData, permalinkUrl, videoType
        )
    }

    /**
     * TODO: Documentation
     */
    fun toBlockPost(): BlockPost {
        return BlockPost(
            blogName, id, blog, postUrl, timestamp, date, format, reblogKey, tags,
            isBookmarklet, isMobile, sourceUrl, sourceTitle, isLiked, state, totalPosts,
            anonymous, content, trail, layout, postAuthor, shortUrl, summary, isBlocksFormat,
            likedTimestamp, slug, noteCount, recommendedSource, recommendedColor,
            postAuthorIsAdult, isSubmission, canLike, canReblog, canSendInMessage, canReply,
            displayAvatar, followed, reblogData, rebloggedFromId, rebloggedFromUrl,
            rebloggedFromName, rebloggedFromTitle, rebloggedFromUuid,
            rebloggedFromCanMessage, rebloggedFromFollowing, rebloggedRootId,
            rebloggedRootUrl, rebloggedRootName, rebloggedRootTitle, rebloggedRootUuid,
            rebloggedRootCanMessage, rebloggedRootFollowing, notes, publishTime, queueState
        )
    }

}
