package com.highthunder.kotlr

import com.highthunder.kotlr.authentication.TumblrAppKey
import com.highthunder.kotlr.authentication.TumblrUserKey
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.OkHttpOAuthProvider
import se.akerfeldt.okhttp.signpost.SigningInterceptor

class RetrofitClient {
    companion object {
        private var retrofit: Retrofit? = null

        private const val API_BASE_URL = "https://www.tumblr.com/oauth/"
        private const val AUTHORIZE_URL = "${API_BASE_URL}authorize"
        private const val REQUEST_TOKEN_RESOURCE = "${API_BASE_URL}request_token"
        private const val ACCESS_TOKEN_RESOURCE = "${API_BASE_URL}access_token"

        inline fun <reified S> Retrofit.create(): S = this.create(S::class.java)

        fun getConsumer(appKey: TumblrAppKey): OkHttpOAuthConsumer =
            OkHttpOAuthConsumer(appKey.apiKey, appKey.apiSecret)

        fun getConsumer(userKey: TumblrUserKey): OkHttpOAuthConsumer =
            OkHttpOAuthConsumer(userKey.apiKey, userKey.apiSecret).also {
                it.setTokenWithSecret(userKey.userKey, userKey.userSecret)
            }

        fun getProvider(okHttpOAuthConsumer: OkHttpOAuthConsumer): OkHttpOAuthProvider = OkHttpOAuthProvider(
            REQUEST_TOKEN_RESOURCE,
            ACCESS_TOKEN_RESOURCE,
            AUTHORIZE_URL,
            getHttpClient(okHttpOAuthConsumer)
        )

        fun getHttpClient(consumer: OkHttpOAuthConsumer, debug: Boolean = false): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            if (debug) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.NONE
            }

            val httpClient = OkHttpClient.Builder()
//            httpClient.connectTimeout(60000, TimeUnit.SECONDS)
//            httpClient.writeTimeout(120000, TimeUnit.SECONDS)
//            httpClient.readTimeout(120000, TimeUnit.SECONDS)
            httpClient.followRedirects(false)
            httpClient.retryOnConnectionFailure(false)
            httpClient.addInterceptor(SigningInterceptor(consumer))
//            httpClient.addInterceptor { chain ->
//                val request = chain.request()
//                val requestBuilder = request.newBuilder()
////                    .header(HEADER_CONTENT_TYPE_KEY, PreferenceHandler.getContentType())
////                    .header(HEADER_ACCEPT_KEY, PreferenceHandler.getAcceptType())
////                    .header(HEADER_CACHE_CONTROL_KEY, PreferenceHandler.getCacheControl())
//                val modifiedRequest = requestBuilder.build()
//                chain.proceed(modifiedRequest)
//            }

            httpClient.addNetworkInterceptor(logging)
            return httpClient.build()
        }

        fun getClient(consumer: OkHttpOAuthConsumer): Retrofit = retrofit ?: Retrofit.Builder()
            .baseUrl("https://api.tumblr.com/v2/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(getHttpClient(consumer))
            .build().also { retrofit = it }
    }
}
