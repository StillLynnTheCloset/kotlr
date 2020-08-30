package com.highthunder.kotlr.authentication

import com.highthunder.kotlr.getOAuthConsumer
import com.highthunder.kotlr.getOAuthProvider

/**
 * OAuthFlow - A helper object to guide you through the process of acquiring OAuth credentials from Tumblr.
 *
 * Example use (also in README.md):
 * <pre>
 * println("Enter your consumer key:")
 * val apiKey: String = Scanner(System.`in`).nextLine()
 *
 * println("Enter your consumer secret:")
 * val apiSecret: String = Scanner(System.`in`).nextLine()
 *
 * // Create an authentication flow.
 * val flow = OAuthFlow(TumblrAppKey(apiKey, apiSecret))
 *
 * // Get the request url, you'll have to open this in a browser or webview.
 * // It will then ask you to login to Tumblr and authorize your app to access your account.
 * // Since we aren't using a web based application, the callbackUrl doesn't really matter, so let's
 * // just make it example.com.
 * val requestUrl: String? = flow.getRequestUrl("example.com")
 *
 * // We'll just print this to the console so you can copy and paste it.
 * println("Open this url in your browser and sign in")
 * println(requestUrl)
 *
 * // Once you've signed in and been redirected, copy that new url from
 * // the browser and drop it into the console.
 * println("Enter the url you were re-directed to:")
 * val redirectedUrl: String = Scanner(System.`in`).nextLine()
 *
 * // Now we just parse that url and use it to complete the authentication process.
 * val userKey: TumblrUserKey = flow.parseResponseUrl(redirectedUrl)
 * println(userKey.toString())
 *
 * // Print out information about the newly logged in user.
 * println(getApi(userKey).getUserInfo())
 * </pre>
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
     * Get the URL that the user needs to visit in order to login to Tumblr.
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
     * Check that the given [url] is a Tumblr Verifier URL.
     */
    private fun isVerifierUrl(url: String): Boolean = url.contains(URL_FILTER)

    /**
     * Retrieve a User Token based on the given verifier [url].
     *
     * @throws IllegalStateException if you had not previously called [getRequestUrl]
     * (and that requestURL had not already been consumed by calling this function.)
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
