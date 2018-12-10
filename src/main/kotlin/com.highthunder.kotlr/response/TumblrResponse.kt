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
     * Get the list of error messages sent with this response.
     * This will be null under normal circumstances when no errors are sent.
     */
    fun getError(): List<TumblrError>?

    /**
     * Get the meta information block from this request.
     * This contains the HTTP response code and message as well as
     * the potential for other flags from Tumblr.
     */
    fun getMetaInfo(): ResponseMetaInfo

    /**
     * TODO: Documentation
     */
    fun getWrapper(): WrapperInterface<T>

    /**
     * A helper function to directly access the response body.
     */
    fun getBody(): T? = getWrapper().getBody()

    /**
     * A helper function to directly access the response body and assert that it is not null.
     */
    fun getBodyOrThrow(): T = getWrapper().getBody() ?: throw KotlrException("Unable to get body of response: $this")

}
