package com.highthunder.kotlr.response.type

import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.WrapperInterface
import com.squareup.moshi.Json

/**
 *
 */
open class BlahResponse<out T>(
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
