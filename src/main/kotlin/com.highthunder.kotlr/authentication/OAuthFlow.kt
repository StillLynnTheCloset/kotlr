package com.highthunder.kotlr.authentication

import com.highthunder.kotlr.getOAuthConsumer
import com.highthunder.kotlr.getOAuthProvider

/**
 * OAuthFlow - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
public class OAuthFlow constructor(private val appKey: TumblrAppKey) {
    private companion object {
        private val URL_FILTER: Regex = "oauth_verifier=".toRegex()
        private val URL_REGEX: Regex = "(.*oauth_verifier=)(([a-zA-Z0-9])+)(.*)".toRegex()
        private const val URL_REPLACEMENT: String = "$2"
    }

    private lateinit var requestUrl: String

    private val consumer = getOAuthConsumer(appKey)
    private val provider = getOAuthProvider(consumer)

    private var isWaitingForResponse: Boolean = false

    /**
     * TODO: Documentation
     */
    public fun getRequestUrl(callbackUrl: String): String? {
        return try {
            requestUrl = provider.retrieveRequestToken(consumer, callbackUrl)
            isWaitingForResponse = true
            requestUrl
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * TODO: Documentation
     */
    private fun isVerifierUrl(url: String): Boolean = url.contains(URL_FILTER)

    /**
     * TODO: Documentation
     */
    public fun parseResponseUrl(url: String): TumblrUserKey {
        return if (isWaitingForResponse && isVerifierUrl(url)) {
            isWaitingForResponse = false
            val verificationString = url.replace(URL_REGEX, URL_REPLACEMENT)
            provider.retrieveAccessToken(consumer, verificationString)
            TumblrUserKey(appKey, consumer.token, consumer.tokenSecret)
        } else {
            throw IllegalStateException("Was not waiting for a response when parseResponseUrl was called")
        }
    }
}
