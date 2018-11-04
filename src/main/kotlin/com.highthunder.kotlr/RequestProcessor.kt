package com.highthunder.kotlr

import com.github.scribejava.apis.TumblrApi
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model.OAuth1AccessToken
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.oauth.OAuth10aService
import com.highthunder.kotlr.authentication.TumblrUserKey
import com.highthunder.kotlr.request.Request
import com.highthunder.kotlr.response.Response
import com.squareup.moshi.Moshi

/**
 * RequestProcessor - TODO: Documentation
 *
 * @author highthunder
 * @since 10/28/18
 * @version 1.0.0
 */
class RequestProcessor(private val key: TumblrUserKey) {

    companion object {
        private val moshi: Moshi = Kotlr.getMoshi()
    }

    private val service: OAuth10aService = ServiceBuilder(key.apiKey).let {
        it.apiSecret(key.apiSecret)
        return@let it.build(TumblrApi.instance())
    }

    fun <T> process(request: Request<T>): Response<T>? {
        val url = request.getUrl(key.apiKey)

        val oAuthRequest = OAuthRequest(request.verb, url)

        val token = OAuth1AccessToken(key.userKey, key.userSecret)
        service.signRequest(token, oAuthRequest)

        val response = service.execute(oAuthRequest)
        System.out.println(response.body)

        val adapter = moshi.adapter(request.responseClass.java).failOnUnknown()

        val parsed: Response<T>? = adapter.fromJson(response.body)
        return parsed
    }

}
