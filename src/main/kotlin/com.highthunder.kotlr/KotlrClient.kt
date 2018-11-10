package com.highthunder.kotlr

import com.github.scribejava.apis.TumblrApi
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model.OAuth1AccessToken
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.oauth.OAuth10aService
import com.github.scribejava.httpclient.okhttp.OkHttpHttpClientConfig
import com.highthunder.kotlr.authentication.TumblrUserKey
import com.highthunder.kotlr.request.Request
import com.highthunder.kotlr.response.ResponseInterface
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient

/**
 * KotlrClient - TODO: Documentation
 *
 * @author highthunder
 * @since 10/28/18
 * @version 1.0.0
 */
class KotlrClient(private val key: TumblrUserKey) {

    companion object {
        private val moshi: Moshi = Kotlr.getMoshi()
    }

    private val service: OAuth10aService = ServiceBuilder(key.apiKey).let { serviceBuilder ->
        serviceBuilder.apiSecret(key.apiSecret)
        // Use a specific HTTP Client so we can force Scribe to not follow redirects.
        // This is necessary because for blog avatar requests, Tumblr returns a redirect response,
        // and if we followed that redirect we would just read the PNG data directly, instead of getting it's url.
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.followRedirects(false)
        val config = OkHttpHttpClientConfig(clientBuilder)
        serviceBuilder.httpClientConfig(config)
        return@let serviceBuilder.build(TumblrApi.instance())
    }

    fun <T> process(request: Request<T>): ResponseInterface<T>? {
        val url = request.getUrl(key.apiKey)
        System.out.println(url)

        val oAuthRequest = OAuthRequest(request.verb, url)

        val token = OAuth1AccessToken(key.userKey, key.userSecret)
        service.signRequest(token, oAuthRequest)

        val response = service.execute(oAuthRequest)
        System.out.println(response.body)

        val adapter = moshi.adapter(request.responseClass.java).failOnUnknown()

        return adapter.fromJson(response.body)
    }

}
