package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.json.PolymorphicJsonAdapterFactory
import com.highthunder.kotlr.types.AttributionList
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.MediaList
import com.highthunder.kotlr.types.VideoMetadata
import com.highthunder.kotlr.types.content.TextContent.SubType
import com.highthunder.kotlr.types.legacy.ExifData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * PostContent - A super class for all types of content blocks
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = false)
public sealed class PostContent {
    internal companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(PostContent::class.java, "type")
            .withDefaultValue(UnknownContent())

            .withSubtype(AudioContent::class.java, AudioContent.KEY)
            .withSubtype(ImageContent::class.java, ImageContent.KEY)
            .withSubtype(LinkContent::class.java, LinkContent.KEY)
            .withSubtype(TextContent::class.java, TextContent.KEY)
            .withSubtype(VideoContent::class.java, VideoContent.KEY)
            .withSubtype(UnknownContent::class.java, UnknownContent.KEY)
    }

    internal abstract val type: String
}

/**
 * UnknownContent - Placeholder that is generated when a Content with an unknown [type] is encountered.
 */
@JsonClass(generateAdapter = true)
public class UnknownContent : PostContent() {
    internal companion object {
        internal const val KEY: String = "Unknown"
    }

    override val type: String = KEY
}

/**
 * AudioContent - An audio block represents a playable track.
 *
 * At a minimum, the [provider] field must be present, and either the [media] field or [url] field must
 * be present. The [provider] field will indicate which embed provider is being used, whether it's
 * tumblr for Tumblr native audio content, or a trusted third party like Spotify or Bandcamp.
 * Optionally, an audio block may include the track's [title], [artist], and/or [album].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param provider The provider of the audio source, whether it's tumblr for native audio or a trusted third party.
 * @param url The URL to use for the audio block, if no [media] is present.
 * @param media The Media Object to use for the audio block, if no [url] is present.
 * @param title The title of the audio asset.
 * @param artist The artist of the audio asset.
 * @param album The album from which the audio asset originated.
 * @param poster An image media object to use as a "poster" for the audio track, usually album art.
 * @param embedHtml HTML code that could be used to embed this audio track into a webpage.
 * @param embedUrl A URL to the embeddable content to use as an iframe.
 * @param metadata Optional provider-specific metadata about the audio track.
 * @param attribution Optional attribution information about where the audio track came from.
 */
@JsonClass(generateAdapter = true)
public data class AudioContent constructor(
    val provider: String? = null,
    val url: String? = null,
    val media: Media? = null,
    val title: String? = null,
    val artist: String? = null,
    val album: String? = null,
    val poster: List<Media>? = null,
    @Json(name = "embed_html")
    val embedHtml: String? = null,
    @Json(name = "embed_url")
    val embedUrl: String? = null,
    val metadata: Any? = null,
    val attribution: AttributionList? = null,
    override val type: String = KEY,
) : PostContent() {
    internal companion object {
        internal const val KEY: String = "audio"
    }
}

/**
 * ImageContent - For image blocks, the only required field is a media array, which contains
 * objects per-image-size. Each image media object contains fields for type, url, width,
 * and height; see the [Media] section for more details.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param media An array of Media Objects which represent different available sizes of this image asset.
 * @param feedbackToken A feedback token to use when this image block is a GIF Search result.
 * @param colors Colors used in the image.
 * @param poster For GIFs, this is a single-frame "poster".
 * @param attribution See the [Attribution] for details about these objects.
 * @param exif Extra properties extracted from the Exif data of the photo.
 */
@JsonClass(generateAdapter = true)
public data class ImageContent constructor(
    val media: List<Media>? = null,
    @Json(name = "feedback_token")
    val feedbackToken: String? = null,
    val colors: Colors? = null,
    val poster: List<Media>? = null,
    val attribution: AttributionList? = null,
    @Json(name = "alt_text")
    val altText: String? = null,
    val exif: ExifData? = null,
    override val type: String = KEY,
) : PostContent() {
    internal companion object {
        internal const val KEY: String = "image"
    }
}

/**
 * LinkContent - In addition to the inline link format, there is a standalone Link content block,
 * which contains metadata about the link.
 *
 * All link type blocks must have at least a url field. title, description, author, site_name,
 * and poster are all optional, depending on their availability. The title, description, author,
 * and site_name fields are limited to 140 characters when fetching a link's OpenGraph data
 * server-side. The site_name field will either have the site name pulled from OpenGraph data or
 * will have the host name as depicted in the example response below. A display_url field is given
 * for display only. The poster field is expected to be an array of image MediaObjects with
 * alternate sizes.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param url The URL to use for the link block.
 * @param title The title of where the link goes.
 * @param description The description of where the link goes.
 * @param author The author of the link's content.
 * @param siteName The name of the site being linked to.
 * @param displayUrl Supplied on NPF Post consumption, ignored during NPF Post creation.
 * @param poster An image media object to use as a "poster" for the link.
 */
@JsonClass(generateAdapter = true)
public data class LinkContent constructor(
    val url: String? = null,
    val title: String? = null,
    val description: String? = null,
    val author: String? = null,
    @Json(name = "site_name")
    val siteName: String? = null,
    @Json(name = "display_url")
    val displayUrl: String? = null,
    val poster: List<Media>? = null,
    override val type: String = KEY,
) : PostContent() {
    internal companion object {
        internal const val KEY: String = "link"
    }
}

/**
 * TextContent - A text block represents a single paragraph of text.
 *
 * At its simplest, it simply wraps a plaintext string.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param text The text to use inside this block.
 * @param subType The [SubType] of text block.
 * @param formatting A list of special formatting instructions.
 */
@JsonClass(generateAdapter = true)
public data class TextContent constructor(
    val text: String? = null,
    @Json(name = "subtype")
    val subType: SubType? = null,
    val formatting: List<TextFormat>? = null,
    @Json(name = "indent_level")
    val indentLevel: Int? = null,
    override val type: String = KEY,
) : PostContent() {
    internal companion object {
        internal const val KEY: String = "text"
    }

    /**
     * SubType - Text blocks can also have a subtype field that specifies a semantic meaning to the text block, which
     * can also be used by the clients to render the entire block of text differently.
     */
    @JsonClass(generateAdapter = false)
    public enum class SubType {
        /**
         * Intended for Post headings.
         */
        @Json(name = "heading1")
        Heading1,
        /**
         * Intended for section subheadings.
         */
        @Json(name = "heading2")
        Heading2,
        /**
         * Tumblr Official clients display this with a large cursive font.
         */
        @Json(name = "quirky")
        Quirky,
        /**
         * Intended for short quotations, official Tumblr clients display this with a large serif font.
         */
        @Json(name = "quote")
        Quote,
        /**
         * Intended for longer quotations or photo captions, official Tumblr clients indent this text block.
         */
        @Json(name = "indented")
        Indented,
        /**
         * Intended to mimic the behavior of the Chat Post type, official Tumblr clients display this with a monospace font.
         */
        @Json(name = "chat")
        Chat,
        /**
         * Intended to be an ordered list item prefixed by a number, see next section.
         */
        @Json(name = "ordered-list-item")
        OrderedListItem,
        /**
         * Intended to be an unordered list item prefixed with a bullet, see next section.
         */
        @Json(name = "unordered-list-item")
        UnorderedListItem,
    }
}

/**
 * VideoContent - A video block represents a playable video. At a minimum, the [provider] field must
 * be present, and either the [media] field or [url] field must be present. The [provider] field will
 * indicate which embed provider is being used, whether it's tumblr for Tumblr native video
 * content, or a trusted third party like youtube or vimeo.
 *
 * A video block may have a canonical [url] specified which, when visited in a web browser,
 * will allow the video to be played. If the video can be embedded on a web page, then the block
 * will have an [embedHtml] field present and, optionally, the [embedUrl].
 *
 * If the video is playable using the client's native player (such as an iOS or Android
 * application), then the block will have a [media] object present. This media object contains
 * fields for type and url; see the Media Objects section for more information.
 *
 * Optionally, a video block may include a [poster] array of image objects to display. Optionally,
 * depending on the provider, there may be additional metadata inside a [metadata] object.
 *
 * Optionally, the content block may contain an [attribution] object with more information about the
 * app or blog it came from. See the section on Attribution for more info.
 *
 * Based on the provider, the waterfall the client should attempt to follow looks like:
 * 1. If there is a [media] object present, simply use the client's native player.
 * 2. If there is a client-side SDK for the given provider, use the given [metadata] object with
 *      the client-side SDK.
 * 3. If there is an [embedHtml] and/or [embedUrl] field present, render [embedHtml] or show [embedUrl] in an iframe.
 * 4. If all else fails, just show a link to [url].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param url The URL to use for the video block, if no media is present.
 * @param media The Media Object to use for the video block, if no url is present.
 * @param provider The provider of the video, whether it's tumblr for native video or a trusted third party.
 * @param embedHtml HTML code that could be used to embed this video into a webpage.
 * @param embedUrl A URL to the embeddable content to use as an iframe.
 * @param poster An image media object to use as a "poster" for the video, usually a single frame.
 * @param metadata Optional provider-specific metadata about the video.
 * @param attribution Optional attribution information about where the video came from.
 * @param canAutoPlayOnCellular Whether this video can be played on a cellular connection.
 * @param filmStrip A series of images taken from throughout this video.
 * @param iframe An HTML string for embedding this video in an IFrame.
 */
@JsonClass(generateAdapter = true)
public data class VideoContent constructor(
    val url: String? = null,
    val media: Media? = null,
    val provider: String? = null,
    @Json(name = "embed_html")
    val embedHtml: String? = null,
    @Json(name = "embed_url")
    val embedUrl: String? = null,
    val poster: List<Media>? = null,
    val metadata: VideoMetadata? = null,
    val attribution: AttributionList? = null,
    @Json(name = "can_autoplay_on_cellular")
    val canAutoPlayOnCellular: Boolean? = null,
    @Json(name = "filmstrip")
    val filmStrip: MediaList? = null,
    @Json(name = "embed_iframe")
    val iframe: Media? = null,
    override val type: String = KEY,
) : PostContent() {
    internal companion object {
        internal const val KEY: String = "video"
    }
}
