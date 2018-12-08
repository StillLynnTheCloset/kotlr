package com.highthunder.kotlr

import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse

/**
 * KotlrRequestProcessor - TODO: Documentation
 *
 * @author highthunder
 * @since 11/28/18
 * @version 1.0.0
 */
interface KotlrRequestProcessor {

    /**
     * TODO: Documentation
     */
    fun <T> process(request: TumblrRequest<T>): TumblrResponse<T>

}
