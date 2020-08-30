package com.highthunder.kotlr.types

import com.highthunder.kotlr.json.wrapper.ContentWrapper
import com.highthunder.kotlr.types.content.BlockLayout
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Trail - Alongside the content and layout keys at the Post object's root level, there can be an optional trail key
 * that holds a reblog trail if the Post is a reblog and the user kept the trail attached. The contents of the trail
 * array are the previous Posts in the reblog trail, in order of oldest (the root Post) to the newest (the parent Post).
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param blog An object with information about the Post's blog in the reblog trail; contains at least a uuid field. This won't be available for "broken" trail items.
 * @param post An object with information about the Post in the reblog trail; contains at least an id field. This won't be available for "broken" trail items.
 * @param contentRaw TODO: Documentation
 * @param content The content of the Post in the trail.
 * @param abstract TODO: Documentation
 * @param currentItem TODO: Documentation
 * @param rootItem TODO: Documentation
 * @param layout The layout to use for the content of the Post in the trail.
 * @param brokenBlogName The name of the blog from a broken trail item; see "broken" trail items.
 * @param brokenBlog TODO: Documentation
 */
@JsonClass(generateAdapter = true)
public data class Trail constructor(
    @Json(name = "blog")
    val blog: Blog? = null,
    @Json(name = "post")
    val post: Post? = null,
    @Json(name = "content_raw")
    val contentRaw: String? = null,
    @Json(name = "content")
    val content: ContentWrapper? = null,
    @Json(name = "content_abstract")
    val abstract: String? = null,
    @Json(name = "is_current_item")
    val currentItem: Boolean? = null,
    @Json(name = "is_root_item")
    val rootItem: Boolean? = null,
    @Json(name = "layout")
    val layout: List<BlockLayout>? = null,
    @Json(name = "broken_blog_name")
    val brokenBlogName: String? = null,
    @Json(name = "broken_blog")
    val brokenBlog: Blog? = null,
)
