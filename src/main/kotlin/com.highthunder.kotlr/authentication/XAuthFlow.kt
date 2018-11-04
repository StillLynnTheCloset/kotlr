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
        private const val X_AUTH_ENDPOINT = "https://www.tumblr.com/oauth/access_token"
    }

    private fun getService(appKey: TumblrAppKey): OAuth10aService {
        return ServiceBuilder(appKey.apiKey)
                .apiSecret(appKey.apiSecret)
                .build(TumblrApi.instance())
    }

    private fun constructXAuthPost(email: String, password: String): OAuthRequest {
        val request = OAuthRequest(Verb.POST, X_AUTH_ENDPOINT)
        request.addBodyParameter("x_auth_username", email)
        request.addBodyParameter("x_auth_password", password)
        request.addBodyParameter("x_auth_mode", "client_auth")
        return request
    }

    private fun parseXAuthResponse(response: Response): OAuth1AccessToken {
        response.body?.let { responseStr ->
            // Response is received in the format "oauth_token=value&oauth_token_secret=value".
            var extractedToken: String? = null
            var extractedSecret: String? = null
            val values = responseStr.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (value in values) {
                val kvp = value.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (kvp.size == 2) {
                    if (kvp[0] == "oauth_token") {
                        extractedToken = kvp[1]
                    } else if (kvp[0] == "oauth_token_secret") {
                        extractedSecret = kvp[1]
                    }
                }
            }
            if (extractedToken != null && extractedSecret != null) {
                return OAuth1AccessToken(extractedToken, extractedSecret)
            }
        }
        // No good
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

    fun getUserKey(appKey: TumblrAppKey, email: String, password: String): TumblrUserKey {
        val token = postXAuth(appKey, email, password)
        return TumblrUserKey(appKey, token.token, token.tokenSecret)
    }

}
