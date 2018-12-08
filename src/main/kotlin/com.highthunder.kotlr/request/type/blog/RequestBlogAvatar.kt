package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import kotlin.reflect.KClass

/**
 * RequestBlogAvatar - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestBlogAvatar(
    private val identifier: String,
    private val size: Int? = null
) : TumblrRequest<ResponseBlogAvatar.Body> {

    companion object {
        /**
         * TODO: Documentation
         */
        const val BASE_PATH: String = "blog/"
    }

    override val responseClass: KClass<out TumblrResponse<ResponseBlogAvatar.Body>> =
        ResponseBlogAvatar.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/avatar"

    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
            if (size != null) {
                append("/")
                append(size)
            }
        }.toString()
    }

}
