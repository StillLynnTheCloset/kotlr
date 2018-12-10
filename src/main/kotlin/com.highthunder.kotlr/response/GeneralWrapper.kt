package com.highthunder.kotlr.response

/**
 *
 */
open class GeneralWrapper<out T> (
    internal val error: String? = null,
    internal val response: T? = null
) : WrapperInterface<T> {
    override fun getError(): String? = error
    override fun getBody(): T? = response
}
