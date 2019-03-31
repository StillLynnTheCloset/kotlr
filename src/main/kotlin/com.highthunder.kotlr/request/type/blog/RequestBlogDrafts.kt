package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.RequestPosts
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts
import kotlin.reflect.KClass

/**
 * RequestBlogDrafts - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class RequestBlogDrafts(
    postLimit: Int? = null,
    postOffset: Long? = null,
    getReblogFields: Boolean? = null,
    getNotesHistory: Boolean? = null,
    useNeuePostFormat: Boolean? = null,
    private var identifier: String
) : RequestPosts<ResponseBlogDrafts.Body>(
    postLimit = postLimit,
    postOffset = postOffset,
    getReblogFields = getReblogFields,
    getNotesHistory = getNotesHistory,
    useNeuePostFormat = useNeuePostFormat
) {

    companion object {
        /**
         * TODO: Documentation
         */
        const val BASE_PATH: String = "blog/"
    }

    override val responseClass: KClass<out TumblrResponse<ResponseBlogDrafts.Body>> =
        ResponseBlogDrafts.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/posts/draft"
}
