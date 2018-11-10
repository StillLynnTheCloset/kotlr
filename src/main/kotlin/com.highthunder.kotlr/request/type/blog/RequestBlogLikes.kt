package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.RequestPosts
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import kotlin.reflect.KClass

/**
 * RequestBlogLikes - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class RequestBlogLikes(
        postLimit: Int? = null,
        postOffset: Long? = null,
        afterPostId: Long? = null,
        beforePostId: Long? = null,
        afterTime: Long? = null,
        beforeTime: Long? = null,
        getReblogFields: Boolean? = null,
        getNotesHistory: Boolean? = null,
        useNeuePostFormat: Boolean? = null,
        private var identifier: String
) : RequestPosts<ResponseBlogLikes.Body>(postLimit, postOffset, afterPostId, beforePostId, afterTime, beforeTime, getReblogFields, getNotesHistory, useNeuePostFormat) {

    companion object {
        const val BASE_PATH = "blog/"
    }

    override val responseClass: KClass<out ResponseInterface<ResponseBlogLikes.Body>> = ResponseBlogLikes.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/likes"

    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
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
