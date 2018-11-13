package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.PostId
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.Attribution.App
import com.highthunder.kotlr.types.content.Attribution.Link
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * SuperAttributionJson - A class to hold every possible field for [Attribution] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The type of this attribution.
 *
 * [Post]
 * @param url The URL of the Post to be attributed.
 * @param post A Post object with at least an id field.
 * @param blog A Tumblelog object with at least a uuid field.
 *
 * [Link]
 * @param url The URL to be attributed for the content.
 *
 * [Blog]
 * @param blog A Tumblelog object with at least a uuid field.
 *
 * [App]
 * @param url The canonical URL to the source content in the third-party app.
 * @param appName The name of the application to be attributed.
 * @param displayText Any display text that the client should use with the attribution.
 * @param logo A specific logo Media Object that the client should use with the third-party app attribution.
 */
@JsonClass(generateAdapter = true)
data class SuperAttributionJson(
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

    constructor(attribution: Attribution.Post) : this(
        url = attribution.url,
        post = attribution.post, blog = attribution.blog
    )

    constructor(attribution: Attribution.App) : this(
        url = attribution.url,
        appName = attribution.appName, displayText = attribution.displayText,
        logo = attribution.logo
    )

    constructor(attribution: Attribution.Link) : this(url = attribution.url)
    constructor(attribution: Attribution.Blog) : this(blog = attribution.blog)

    fun toPostAttribution(): Attribution.Post {
        return Attribution.Post(url, post, blog)
    }

    fun toAppAttribution(): Attribution.App {
        return Attribution.App(url, appName, displayText, logo)
    }

    fun toLinkAttribution(): Attribution.Link {
        return Attribution.Link(url)
    }

    fun toBlogAttribution(): Attribution.Blog {
        return Attribution.Blog(blog)
    }

}
