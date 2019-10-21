package com.highthunder.kotlr

import com.highthunder.kotlr.exception.KotlrNetworkException
import com.highthunder.kotlr.exception.KotlrParsingException
import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse
import kotlinx.coroutines.Dispatchers
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
    @Throws(KotlrNetworkException::class, KotlrParsingException::class)
    suspend fun <T> process(request: TumblrRequest<T>): TumblrResponse<T>

    /**
     * Convert [request] into a [TumblrResponse]
     *
     * @param request The request to perform.
     * @return The response to that request.
     *
     * @throws KotlrNetworkException If an error occurs when performing the network operation.
     * @throws KotlrParsingException If an error occurs while parsing the response.
     */
    @Throws(KotlrNetworkException::class, KotlrParsingException::class)
    fun <T> processBlocking(request: TumblrRequest<T>): TumblrResponse<T> = runBlocking(Dispatchers.IO) { process(request) }
}
