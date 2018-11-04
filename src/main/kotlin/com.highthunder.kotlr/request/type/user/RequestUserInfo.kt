package com.highthunder.kotlr.request.type.user

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.Request
import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import kotlin.reflect.KClass

/**
 * RequestUserInfo - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestUserInfo: Request<ResponseUserInfo.Body> {

    companion object {
        const val base = "https://api.tumblr.com/v2/user/info"
    }

    override fun getBaseUrl(): String = base

    override fun getUrlParameters(apiKey: String): String = ""

    override val responseClass: KClass<ResponseUserInfo.Response> = ResponseUserInfo.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = true
    override val improvedByOAuth: Boolean = false

}
