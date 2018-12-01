package com.highthunder.kotlr

import com.highthunder.kotlr.request.Request
import com.highthunder.kotlr.response.ResponseInterface

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
    fun <T> process(request: Request<T>): ResponseInterface<T>?

}
