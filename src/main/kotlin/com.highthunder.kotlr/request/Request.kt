package com.highthunder.kotlr.request

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.response.ResponseInterface
import kotlin.reflect.KClass

/**
 * Request - A generic request to the Tumblr API.
 *
 * Each type of request to the Tumblr API implements this interface.
 *
 * TODO: Expand to support multipart form uploads.
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
interface Request<out T> {
    fun getBaseUrl(): String
    fun getUrlParameters(apiKey: String): String
    fun getUrl(apiKey: String): String = "${getBaseUrl()}${getUrlParameters(apiKey)}"
    val responseClass: KClass<out ResponseInterface<T>>
    val verb: Verb
    val requiresOAuth: Boolean
    val improvedByOAuth: Boolean
    val apiRootPath: String
        get() = "https://api.tumblr.com/v2/"
}
