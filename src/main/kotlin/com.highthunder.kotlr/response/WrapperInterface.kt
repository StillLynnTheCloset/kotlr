package com.highthunder.kotlr.response

/**
 * WrapperInterface - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface WrapperInterface<out T> {
    fun getMessage(): String?
    fun getBody(): T?
}
