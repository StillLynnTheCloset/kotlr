package com.highthunder.kotlr.request.type.blog

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.Request
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers
import com.highthunder.kotlr.response.type.blog.ResponseBlogInfo
import kotlin.reflect.KClass

/**
 * RequestBlogFollowers - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestBlogFollowers(
    private val identifier: String,
    private val limit: Int? = null,
    private val offset: Int? = null
) : Request<ResponseBlogFollowers.Body> {

    companion object {
        const val BASE_PATH = "blog/"
    }

    override val responseClass: KClass<out ResponseInterface<ResponseBlogFollowers.Body>> = ResponseBlogFollowers.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH$identifier/followers"

    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
            var previous = false
            limit?.also {
                append("?")
                append("limit=")
                append(it)
                previous = true
            }
            offset?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("offset=")
                append(it)
                previous = true
            }
        }.toString()
    }

}
