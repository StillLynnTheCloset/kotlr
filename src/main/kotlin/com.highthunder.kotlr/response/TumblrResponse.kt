package com.highthunder.kotlr.response

import com.highthunder.kotlr.KotlrException

/**
 * TumblrResponse - A generic response from the Tumblr API.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface TumblrResponse<out T> {

    /**
     * TODO: Documentation
     */
    fun getError(): List<TumblrError>?

    /**
     * TODO: Documentation
     */
    fun getMetaInfo(): ResponseMetaInfo?

    /**
     * TODO: Documentation
     */
    fun getWrapper(): WrapperInterface<T>?

    /**
     * A helper function to directly access the response body.
     */
    fun getBody(): T? = getWrapper()?.getBody()

    /**
     * TODO: Documentation
     */
    fun getBodyOrThrow(): T = getWrapper()?.getBody() ?: throw KotlrException("Unable to get body of response: $this")

}
