package com.highthunder.kotlr.types.content

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.PostId
import com.highthunder.kotlr.types.content.Attribution.Link
import com.highthunder.kotlr.types.content.Attribution.Blog
import com.highthunder.kotlr.types.content.Attribution.Post
import com.highthunder.kotlr.types.content.Attribution.App
import com.highthunder.kotlr.types.Blog as RealBlog

/**
 * Attribution - Content blocks and layout blocks can have an attribution object containing a
 * [Link], [Blog], [Post], or [App] type attribution. Like most objects in NPF,
 * attributions only require the type field, and other fields are required based on the given type.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
sealed class Attribution {

    /**
     * Post Attribution
     *
     * @param url The URL of the Post to be attributed.
     * @param post A Post object with at least an id field.
     * @param blog A Tumblelog object with at least a uuid field.
     */
    class Post(
        var url: String? = null,
        var post: PostId? = null,
        var blog: RealBlog? = null
    ) : Attribution() {
        companion object {
            /**
             *  TODO: Documentation
             */
            const val KEY: String = "post"
        }
    }

    /**
     * Link Attribution
     *
     * @param url The URL to be attributed for the content.
     */
    class Link(
        var url: String? = null
    ) : Attribution() {
        companion object {
            /**
             *  TODO: Documentation
             */
            const val KEY: String = "link"
        }
    }

    /**
     * Blog Attribution
     *
     * @param blog A Tumblelog object with at least a uuid field.
     */
    class Blog(
        var blog: RealBlog? = null
    ) : Attribution() {
        companion object {
            /**
             *  TODO: Documentation
             */
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
    class App(
        var url: String? = null,
        var appName: String? = null,
        var displayText: String? = null,
        var logo: Media? = null
    ) : Attribution() {
        companion object {
            /**
             *  TODO: Documentation
             */
            const val KEY: String = "app"
        }
    }
}
