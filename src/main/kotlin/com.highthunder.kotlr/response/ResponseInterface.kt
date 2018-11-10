package com.highthunder.kotlr.response

/**
 * ResponseInterface - A generic response from the Tumblr API.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface ResponseInterface<out T> {
    fun getError(): List<TumblrError>?
    fun getMetaInfo(): ResponseMetaInfo?
    fun getWrapper(): WrapperInterface<T>?
    fun getBody(): T? {
        return getWrapper()?.getBody()
    }
}
