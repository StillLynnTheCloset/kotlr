package com.highthunder.kotlr.response

/**
 * Response - A generic response from the Tumblr API.
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface Response<out T> {
    fun getError(): List<TumblrError>?
    fun getMetaInfo(): ResponseMetaInfo?
    fun getWrapper(): Wrapper<T>?
    fun getBody(): T? {
        return getWrapper()?.getBody()
    }
}
