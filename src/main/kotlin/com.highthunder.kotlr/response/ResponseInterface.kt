package com.highthunder.kotlr.response

/**
 * ResponseInterface - A generic response from the Tumblr API.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface ResponseInterface<out T> {

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
     * TODO: Documentation
     */
    fun getBody(): T? = getWrapper()?.getBody()

}
