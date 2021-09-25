package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.post.ResponsePostsTagged
import com.stilllynnthecloset.kotlr.types.Post

public interface KotlrPostsGetApi {
    /**
     * Fetch posts with a given tag.
     *
     * @param tag The tag on the posts you'd like to retrieve.
     * @param beforeTimestamp Optional. The timestamp of when you'd like to see posts before. If the Tag is a "featured" tag, use the "featured_timestamp" on the post object for pagination.
     * @param pagingLimit Optional. The number of results to return: 1–50, inclusive.
     * @param filter Optional. Specifies the post format to return, other than HTML: text – Plain text, no HTML; raw – As entered by the user (no post-processing); if the user writes in Markdown, the Markdown will be returned rather than HTML.
     */
    public suspend fun getTaggedPosts(
        tag: String,
        beforeTimestamp: Long? = null,
        pagingLimit: Long? = null,
        filter: Post.PostFormat? = null,
    ): ResponsePostsTagged.Response?
}
