package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.PostId
import com.highthunder.kotlr.types.content.AppAttribution
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlogAttribution
import com.highthunder.kotlr.types.content.LinkAttribution
import com.highthunder.kotlr.types.content.PostAttribution
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * AttributionAmalgamation - A class to hold every possible field for [Attribution] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The type of this attribution.
 *
 * [PostAttribution]
 * @param url The URL of the Post to be attributed.
 * @param post A Post object with at least an id field.
 * @param blog A Tumblelog object with at least a uuid field.
 *
 * [LinkAttribution]
 * @param url The URL to be attributed for the content.
 *
 * [BlogAttribution]
 * @param blog A Tumblelog object with at least a uuid field.
 *
 * [AppAttribution]
 * @param url The canonical URL to the source content in the third-party app.
 * @param appName The name of the application to be attributed.
 * @param displayText Any display text that the client should use with the attribution.
 * @param logo A specific logo Media Object that the client should use with the third-party app attribution.
 */
@JsonClass(generateAdapter = true)
internal data class AttributionAmalgamation constructor(
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "url")
    var url: String? = null,
    @Json(name = "post")
    var post: PostId? = null,
    @Json(name = "blog")
    var blog: Blog? = null,
    @Json(name = "app_name")
    var appName: String? = null,
    @Json(name = "display_text")
    var displayText: String? = null,
    @Json(name = "logo")
    var logo: Media? = null
) {

    constructor(attribution: PostAttribution) : this(
        url = attribution.url,
        post = attribution.post,
        blog = attribution.blog
    )

    constructor(attribution: AppAttribution) : this(
        url = attribution.url,
        appName = attribution.appName,
        displayText = attribution.displayText,
        logo = attribution.logo
    )

    constructor(attribution: LinkAttribution) : this(
        url = attribution.url
    )

    constructor(attribution: BlogAttribution) : this(
        blog = attribution.blog
    )

    fun toPostAttribution(): PostAttribution = PostAttribution(url, post, blog)

    fun toAppAttribution(): AppAttribution = AppAttribution(url, appName, displayText, logo)

    fun toLinkAttribution(): LinkAttribution = LinkAttribution(url)

    fun toBlogAttribution(): BlogAttribution = BlogAttribution(blog)
}
