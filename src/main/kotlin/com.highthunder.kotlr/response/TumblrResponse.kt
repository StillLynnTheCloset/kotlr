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
    val errors: List<TumblrError>?

    /**
     * Get the meta information block from this request.
     * This contains the HTTP response code and message as well as
     * the potential for other flags from Tumblr.
     */
    val meta: ResponseMetaInfo

    /**
     * TODO: Documentation
     */
    val response: WrapperInterface<T>

    /**
     * A helper function to directly access the response body.
     */
    fun getBody(): T? = response.body

    /**
     * A helper function to directly access the response body and assert that it is not null.
     */
    fun getBodyOrThrow(): T = response.body ?: throw KotlrException("Unable to get body of response: $this")

}
