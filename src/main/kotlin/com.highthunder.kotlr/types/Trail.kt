package com.highthunder.kotlr.types

import com.highthunder.kotlr.json.wrapper.ContentWrapper
import com.highthunder.kotlr.types.content.BlockLayout
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Trail - TODO: Documentation
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@JsonClass(generateAdapter = true)
data class Trail(
        @Json(name = "blog")
        val blog: Blog? = null,
        @Json(name = "post")
        val post: PostId? = null,
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
        val brokenBlog: Blog? = null
)
