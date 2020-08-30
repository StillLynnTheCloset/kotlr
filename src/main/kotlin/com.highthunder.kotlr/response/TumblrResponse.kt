package com.highthunder.kotlr.response

/**
 * TumblrResponse - A generic response from the Tumblr API.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
public interface TumblrResponse<out T> {

    /**
     * Get the list of error messages sent with this response.
     * This will be null under normal circumstances when no errors are sent.
     */
    public val errors: List<TumblrError>?

    /**
     * Get the meta information block from this request.
     * This contains the HTTP response code and message as well as
     * the potential for other flags from Tumblr.
     */
    public val meta: ResponseMetaInfo

    /**
     * The actual body of the response, this can either be the body promised by the API, or a string containing an
     * error message.
     */
    public val response: WrapperInterface<T>

    /**
     * A helper function to directly access the response body.
     */
    public fun getBody(): T? = response.body

    /**
     * A helper function to directly access the response body and assert that it is not null.
     */
    public fun getBodyOrThrow(): T = response.body
        ?: throw IllegalStateException("Unable to get body of response: $this")
}
