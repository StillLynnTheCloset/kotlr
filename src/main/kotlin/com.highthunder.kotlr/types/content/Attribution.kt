package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.json.PolymorphicJsonAdapterFactory
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.Post
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Attribution - Content blocks and layout blocks can have an attribution object containing a
 * [PostAttribution], [LinkAttribution], [BlogAttribution], or [AppAttribution] type attribution. Like most objects in NPF,
 * attributions only require the type field, and other fields are required based on the given type.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class Attribution {
    companion object {
        internal val jsonAdapterFactory = PolymorphicJsonAdapterFactory
            .of(Attribution::class.java, "type")
            .withDefaultValue(UnknownAttribution)

            .withSubtype(PostAttribution::class.java, PostAttribution.KEY)
            .withSubtype(LinkAttribution::class.java, LinkAttribution.KEY)
            .withSubtype(BlogAttribution::class.java, BlogAttribution.KEY)
            .withSubtype(AppAttribution::class.java, AppAttribution.KEY)
    }

    internal abstract val type: String
}

object UnknownAttribution : Attribution() {
    override val type: String = "Unknown"
}

/**
 * Post Attribution
 *
 * @param url The URL of the Post to be attributed.
 * @param post A Post object with at least an id field.
 * @param blog A Tumblelog object with at least a uuid field.
 */
@JsonClass(generateAdapter = true)
data class PostAttribution constructor(
    val url: String? = null,
    val post: Post? = null,
    val blog: Blog? = null,
    override val type: String = KEY
) : Attribution() {
    companion object {
        const val KEY: String = "post"
    }
}

/**
 * Link Attribution
 *
 * @param url The URL to be attributed for the content.
 */
@JsonClass(generateAdapter = true)
data class LinkAttribution constructor(
    val url: String? = null,
    override val type: String = KEY
) : Attribution() {
    companion object {
        const val KEY: String = "link"
    }
}

/**
 * Blog Attribution
 *
 * @param blog A Tumblelog object with at least a uuid field.
 * @param url The URL to be attributed for the content.
 */
@JsonClass(generateAdapter = true)
data class BlogAttribution constructor(
    val blog: Blog? = null,
    val url: String? = null,
    override val type: String = KEY
) : Attribution() {
    companion object {
        const val KEY: String = "blog"
    }
}

/**
 * App Attribution
 *
 * @param url The canonical URL to the source content in the third-party app.
 * @param appName The name of the application to be attributed.
 * @param displayText Any display text that the client should use with the attribution.
 * @param logo A specific logo Media Object that the client should use with the third-party app attribution.
 */
@JsonClass(generateAdapter = true)
data class AppAttribution constructor(
    val url: String? = null,
    @Json(name = "app_name")
    val appName: String? = null,
    @Json(name = "display_text")
    val displayText: String? = null,
    val logo: Media? = null,
    override val type: String = KEY
) : Attribution() {
    companion object {
        const val KEY: String = "app"
    }
}
