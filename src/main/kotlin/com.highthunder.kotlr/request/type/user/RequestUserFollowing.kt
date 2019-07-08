package com.highthunder.kotlr.request.type.user

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.type.user.ResponseUserFollowing
import kotlin.reflect.KClass

/**
 * RequestUserFollowing - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestUserFollowing constructor(
    private val limit: Int? = null,
    private val offset: Long? = null
) : TumblrRequest<ResponseUserFollowing.Body> {

    companion object {
        /**
         * TODO: Documentation
         */
        const val BASE_PATH: String = "user/following"
    }

    override val responseClass: KClass<out TumblrResponse<ResponseUserFollowing.Body>> =
        ResponseUserFollowing.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = true
    override val improvedByOAuth: Boolean = false

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH"

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
