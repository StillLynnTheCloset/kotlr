package com.highthunder.kotlr.request.type.user

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import kotlin.reflect.KClass

/**
 * RequestUserInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestUserInfo : TumblrRequest<ResponseUserInfo.Body> {

    companion object {
        /**
         * TODO: Documentation
         */
        const val BASE_PATH: String = "user/info"
    }

    override val responseClass: KClass<out TumblrResponse<ResponseUserInfo.Body>> = ResponseUserInfo.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = true
    override val improvedByOAuth: Boolean = false

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH"

    override fun getUrlParameters(apiKey: String): String = ""
}
