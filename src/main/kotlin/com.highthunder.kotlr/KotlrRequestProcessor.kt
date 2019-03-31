package com.highthunder.kotlr

import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse
import kotlinx.coroutines.runBlocking

/**
 * KotlrRequestProcessor - A generic interface for processing [TumblrRequest]s and turning them into [TumblrResponse]s.
 *
 * @author highthunder
 * @since 11/28/18
 * @version 1.0.0
 */
interface KotlrRequestProcessor {

    /**
     * Convert [request] into a [TumblrResponse]
     *
     * @param request The request to perform.
     * @return The response to that request.
     *
     * @throws KotlrNetworkException If an error occurs when performing the network operation.
     * @throws KotlrParsingException If an error occurs while parsing the response.
     */
    suspend fun <T> process(request: TumblrRequest<T>): TumblrResponse<T>

    fun <T> processBlocking(request: TumblrRequest<T>): TumblrResponse<T> {
        return runBlocking {
            process(request)
        }
    }
}
