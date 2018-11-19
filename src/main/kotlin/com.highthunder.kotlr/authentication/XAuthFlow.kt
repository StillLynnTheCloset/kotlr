package com.highthunder.kotlr.authentication

import com.github.scribejava.apis.TumblrApi
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model.OAuth1AccessToken
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.model.Response
import com.github.scribejava.core.model.Verb
import com.github.scribejava.core.oauth.OAuth10aService
import com.highthunder.kotlr.KotlrException

/**
 * XAuthFlow - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
class XAuthFlow {

    companion object {
        private const val X_AUTH_ENDPOINT: String = "https://www.tumblr.com/oauth/access_token"
        private const val BODY_PARAMETER_KEY_USERNAME: String = "x_auth_username"
        private const val BODY_PARAMETER_KEY_PASSWORD: String = "x_auth_password"
        private const val BODY_PARAMETER_KEY_AUTHMODE: String = "x_auth_mode"
        private const val BODY_PARAMETER_AUTHMODE_CLIENT: String = "client_auth"
        private const val RESPONSE_PARAMETER_KEY_TOKEN: String = "oauth_token"
        private const val RESPONSE_PARAMETER_KEY_SECRET: String = "oauth_token_secret"
    }

    private fun getService(appKey: TumblrAppKey): OAuth10aService {
        return ServiceBuilder(appKey.apiKey)
            .apiSecret(appKey.apiSecret)
            .build(TumblrApi.instance())
    }

    private fun constructXAuthPost(email: String, password: String): OAuthRequest {
        val request = OAuthRequest(Verb.POST, X_AUTH_ENDPOINT)
        request.addBodyParameter(BODY_PARAMETER_KEY_USERNAME, email)
        request.addBodyParameter(BODY_PARAMETER_KEY_PASSWORD, password)
        request.addBodyParameter(BODY_PARAMETER_KEY_AUTHMODE, BODY_PARAMETER_AUTHMODE_CLIENT)
        return request
    }

    private fun parseXAuthResponse(response: Response): OAuth1AccessToken {
        response.body?.let { responseStr ->
            // Response is received in the format "oauth_token=value&oauth_token_secret=value".
            var extractedToken: String? = null
            var extractedSecret: String? = null
            val values = responseStr.split("&".toRegex()).dropLastWhile(String::isEmpty)
            values
                .map { value -> value.split("=".toRegex()).dropLastWhile(String::isEmpty) }
                .filter { it.size == 2 }
                .forEach {
                    if (it[0] == RESPONSE_PARAMETER_KEY_TOKEN) {
                        extractedToken = it[1]
                    } else if (it[0] == RESPONSE_PARAMETER_KEY_SECRET) {
                        extractedSecret = it[1]
                    }
                }
            if (extractedToken != null && extractedSecret != null) {
                return OAuth1AccessToken(extractedToken, extractedSecret)
            }
        }
        // No good token received
        throw KotlrException(response)
    }

    private fun clearXAuth(response: Response): OAuth1AccessToken {
        return if (response.code == 200 || response.code == 201) {
            parseXAuthResponse(response)
        } else {
            throw KotlrException(response)
        }
    }

    private fun postXAuth(appKey: TumblrAppKey, email: String, password: String): OAuth1AccessToken {
        val service = getService(appKey)
        val request = constructXAuthPost(email, password)
        // Empty token is required for Scribe to execute XAuth.
        service.signRequest(OAuth1AccessToken("", ""), request)
        return clearXAuth(service.execute(request))
    }

    /**
     *  TODO: Documentation
     */
    fun getUserKey(appKey: TumblrAppKey, email: String, password: String): TumblrUserKey {
        val token = postXAuth(appKey, email, password)
        return TumblrUserKey(appKey, token.token, token.tokenSecret)
    }

}
