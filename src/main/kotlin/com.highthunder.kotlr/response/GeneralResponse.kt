package com.highthunder.kotlr.response

import com.squareup.moshi.Json

/**
 *
 */
open class GeneralResponse<out T>(
    @Json(name = "meta")
    internal val meta: ResponseMetaInfo,
    @Json(name = "response")
    internal val response: WrapperInterface<T>,
    @Json(name = "errors")
    internal val errors: List<TumblrError>? = null
) : TumblrResponse<T> {
    override fun getError(): List<TumblrError>? = errors
    override fun getMetaInfo(): ResponseMetaInfo = meta
    override fun getWrapper(): WrapperInterface<T> = response
}
