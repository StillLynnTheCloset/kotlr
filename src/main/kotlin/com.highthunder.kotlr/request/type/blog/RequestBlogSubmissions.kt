package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.RequestPosts
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions
import kotlin.reflect.KClass

/**
 * RequestBlogSubmissions - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class RequestBlogSubmissions(
    postLimit: Int? = null,
    postOffset: Long? = null,
    getReblogFields: Boolean? = null,
    getNotesHistory: Boolean? = null,
    useNeuePostFormat: Boolean? = null,
    private var identifier: String
) : RequestPosts<ResponseBlogSubmissions.Body>(
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

    override val responseClass: KClass<out ResponseInterface<ResponseBlogSubmissions.Body>> =
        ResponseBlogSubmissions.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/posts/submission"

}
