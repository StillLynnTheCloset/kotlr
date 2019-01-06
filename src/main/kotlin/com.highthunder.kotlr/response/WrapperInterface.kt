package com.highthunder.kotlr.response

/**
 * WrapperInterface - A wrapper class around the response to a given request.
 *
 * This is required because in some situations Tumblr returns a string instead of an
 * object as the response body so we need to be able to account for that.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface WrapperInterface<out T> {

    /**
     * Get the error message form of the response body.
     *
     * This will be null under normal conditions, but some error states will return a string
     * for the body, which can be accessed here.
     *
     * @return An optional string of the error message, if any.
     */
    val error: String?

    /**
     * Get the standard body form of the response body.
     *
     * This will only be null if an error is returned by Tumblr, and in that case [error]
     * should contain whatever error message Tumblr provided.
     *
     * @return An optional response body object, if any.
     */
    val body: T?

}
