package com.highthunder.kotlr

import com.github.scribejava.apis.TumblrApi
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model.OAuth1AccessToken
import com.github.scribejava.core.model.OAuthRequest
import com.github.scribejava.core.model.Response
import com.github.scribejava.core.oauth.OAuth10aService
import com.github.scribejava.httpclient.okhttp.OkHttpHttpClientConfig
import com.highthunder.kotlr.authentication.TumblrUserKey
import com.highthunder.kotlr.request.TumblrRequest
import com.highthunder.kotlr.response.TumblrResponse
import okhttp3.OkHttpClient
import java.io.IOException
import java.util.concurrent.ExecutionException

/**
 * KotlrAuthenticatedClient - This is Kotlr's equivalent of Jumblr's JumblrClient.
 *
 * It is used to perform any interactions with the Tumblr API. This client requires
 * a valid user key, i.e. it only performs actions as an authenticated user. In the future
 * another client could be made that would only require an app key, which would perform
 * actions as an unauthenticated user.
 *
 * Unlike JumblrClient, this class does not contain any request specific logic, it
 * only knows how to send a request to the Tumblr API and receive the response.
 * Instead, the knowledge of how to format each request and parse the responses
 * is delegated to the subclasses of [TumblrRequest] and [TumblrResponse].
 *
 * TODO: Create extension functions to create an API that is more similar to that of JumblrClient.
 *
 * @param key The user key to use when signing all requests to the Tumblr API.
 *
 * @author highthunder
 * @since 10/28/18
 * @version 1.0.0
 */
class KotlrAuthenticatedClient(private val key: TumblrUserKey) : KotlrRequestProcessor {

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

    override suspend fun <T> process(request: TumblrRequest<T>): TumblrResponse<T> {
        val url = request.getUrl(key.apiKey)
        System.out.println(url)

        val oAuthRequest = OAuthRequest(request.verb, url)

        val token = OAuth1AccessToken(key.userKey, key.userSecret)
        service.signRequest(token, oAuthRequest)

        val response: Response
        try {
            response = service.execute(oAuthRequest)
            System.out.println(response.body)
        } catch (e: InterruptedException) {
            throw KotlrNetworkException("Network operation interrupted")
        } catch (e: ExecutionException) {
            throw KotlrNetworkException("Network operation failed to execute")
        } catch (e: IOException) {
            throw KotlrNetworkException("Network operation failed")
        }

        val adapter = moshi.adapter(request.responseClass.java).failOnUnknown()

        return adapter.fromJson(response.body)
            ?: throw KotlrParsingException("Failed to parse response body: ${response.body}")
    }

}
