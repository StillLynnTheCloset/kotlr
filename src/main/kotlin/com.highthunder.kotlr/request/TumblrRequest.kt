package com.highthunder.kotlr.request

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.response.TumblrResponse
import kotlin.reflect.KClass

/**
 * TumblrRequest - A generic request to the Tumblr API.
 *
 * Each type of request to the Tumblr API implements this interface.
 *
 * TODO: Expand to support multipart form uploads.
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
interface TumblrRequest<out T> {

    /**
     * TODO: Documentation
     */
    fun getBaseUrl(): String

    /**
     * TODO: Documentation
     */
    fun getUrlParameters(apiKey: String): String

    /**
     * TODO: Documentation
     */
    fun getUrl(apiKey: String): String = "${getBaseUrl()}${getUrlParameters(apiKey)}"

    /**
     * TODO: Documentation
     */
    val responseClass: KClass<out TumblrResponse<T>>

    /**
     * TODO: Documentation
     */
    val verb: Verb

    /**
     * TODO: Documentation
     */
    val requiresOAuth: Boolean

    /**
     * TODO: Documentation
     */
    val improvedByOAuth: Boolean

    /**
     * TODO: Documentation
     */
    val apiRootPath: String
        get() = "https://api.tumblr.com/v2/"

}
