package com.highthunder.kotlr.response

/**
 * Wrapper - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
interface Wrapper<out T> {
    fun getMessage(): String?
    fun getBody(): T?
}
