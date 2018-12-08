package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.RequestPosts
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.type.blog.ResponseBlogPosts
import com.highthunder.kotlr.types.Post
import kotlin.reflect.KClass

/**
 * RequestBlogPosts - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class RequestBlogPosts(
    postLimit: Int? = null,
    postOffset: Long? = null,
    afterPostId: Long? = null,
    beforePostId: Long? = null, // exclusive
    afterTime: Long? = null,
    beforeTime: Long? = null, // inclusive
    getReblogFields: Boolean? = null,
    getNotesHistory: Boolean? = null,
    useNeuePostFormat: Boolean? = null,
    tag: String? = null,
    pageNumber: Int? = null,
    private val identifier: String,
    private val type: Post.Type? = null
) : RequestPosts<ResponseBlogPosts.Body>(
    postLimit = postLimit,
    postOffset = postOffset,
    afterPostId = afterPostId,
    beforePostId = beforePostId,
    afterTime = afterTime,
    beforeTime = beforeTime,
    getReblogFields = getReblogFields,
    getNotesHistory = getNotesHistory,
    useNeuePostFormat = useNeuePostFormat,
    tag = tag,
    pageNumber = pageNumber
) {

    companion object {
        /**
         * TODO: Documentation
         */
        const val BASE_PATH: String = "blog/"
    }

    override val responseClass: KClass<out TumblrResponse<ResponseBlogPosts.Body>> =
        ResponseBlogPosts.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/posts"

    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
            if (type != null) {
                append("/${type.key}")
            }
            var previous = false
            val parent = super.getUrlParameters(apiKey)
            if (parent.isNotBlank()) {
                append(parent)
                previous = true
            }
            apiKey.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("api_key=")
                append(it)
                previous = true
            }
        }.toString()
    }

}
