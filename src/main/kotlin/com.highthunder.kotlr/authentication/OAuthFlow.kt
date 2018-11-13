package com.highthunder.kotlr.authentication

import com.github.scribejava.apis.TumblrApi
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model.OAuth1RequestToken
import com.github.scribejava.core.oauth.OAuth10aService

/**
 * OAuthFlow - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
class OAuthFlow {

    companion object {
        val URL_FILTER = "oauth_verifier=".toRegex()
        val URL_REGEX = "(.*oauth_verifier=)(([a-zA-Z0-9])+)(.*)".toRegex()
        const val URL_REPLACEMENT = "$2"
    }

    private lateinit var appKey: TumblrAppKey
    private lateinit var requestToken: OAuth1RequestToken
    private lateinit var oAuthService: OAuth10aService
    private lateinit var requestUrl: String

    private var isWaitingForResponse: Boolean = false

    private fun getService(appKey: TumblrAppKey, callbackUrl: String): OAuth10aService {
        return ServiceBuilder(appKey.apiKey)
            .apiSecret(appKey.apiSecret)
            .callback(callbackUrl)
            .debug()
            .build(TumblrApi.instance())
    }

    fun getRequestUrl(appKey: TumblrAppKey, callbackUrl: String): String? {

        this.appKey = appKey
        return try {
            oAuthService = getService(appKey, callbackUrl)
            // Obtain the Request Token
            requestToken = oAuthService.requestToken
            requestUrl = oAuthService.getAuthorizationUrl(requestToken)
            isWaitingForResponse = true

            requestUrl
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    }

    fun isVerifierUrl(url: String): Boolean = url.contains(URL_FILTER)

    fun parseResponseUrl(url: String): TumblrUserKey {

        return if (isWaitingForResponse) {
            val verificationString = url.replace(URL_REGEX, URL_REPLACEMENT)
            val accessToken = oAuthService.getAccessToken(requestToken, verificationString)
            isWaitingForResponse = false
            TumblrUserKey(appKey, accessToken.token, accessToken.tokenSecret)
        } else {
            throw IllegalStateException("Was not waiting for a response when parseResponseUrl was called")
        }

    }

}
