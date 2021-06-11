package com.highthunder.kotlr

import com.highthunder.kotlr.api.KotlrApi
import com.highthunder.kotlr.api.KotlrBlogDeleteApi
import com.highthunder.kotlr.api.KotlrBlogGetApi
import com.highthunder.kotlr.api.KotlrBlogPostApi
import com.highthunder.kotlr.api.KotlrPostsGetApi
import com.highthunder.kotlr.api.KotlrUserDeleteApi
import com.highthunder.kotlr.api.KotlrUserGetApi
import com.highthunder.kotlr.api.KotlrUserPostApi
import com.highthunder.kotlr.authentication.TumblrAppKey
import com.highthunder.kotlr.authentication.TumblrUserKey
import com.highthunder.kotlr.json.qualifier.CommaSeparatedStringJsonAdapter
import com.highthunder.kotlr.json.qualifier.HexColorJsonAdapter
import com.highthunder.kotlr.json.qualifier.HexColorOctothorpeJsonAdapter
import com.highthunder.kotlr.json.wrapper.AttributionListJsonAdapter
import com.highthunder.kotlr.json.wrapper.ColorJsonAdapter
import com.highthunder.kotlr.json.wrapper.MediaListJsonAdapter
import com.highthunder.kotlr.json.wrapper.RecommendationReasonJsonAdapter
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Notification
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.OkHttpOAuthProvider
import se.akerfeldt.okhttp.signpost.SigningInterceptor

/**
 * Helper function to add support for all Kotlr data types to the given Moshi Builder
 */
public fun Moshi.Builder.addKotlrTypes(): Moshi.Builder = this
    .add(PostContent.jsonAdapterFactory)
    .add(Attribution.jsonAdapterFactory)
    .add(TextFormat.jsonAdapterFactory)
    .add(BlockLayout.jsonAdapterFactory)
    .add(RowBlockLayout.Display.Mode.jsonAdapterFactory)
    .add(NoteData.jsonAdapterFactory)
    .add(Notification.jsonAdapterFactory)
    .add(CommaSeparatedStringJsonAdapter())
    .add(ColorJsonAdapter())
    .add(HexColorJsonAdapter())
    .add(MediaListJsonAdapter())
    .add(AttributionListJsonAdapter())
    .add(HexColorOctothorpeJsonAdapter())
    .add(RecommendationReasonJsonAdapter())
    .add(KotlrJsonAdapterFactory)

private const val API_BASE_URL = "https://api.tumblr.com/v2/"
private const val O_AUTH_BASE_URL = "https://www.tumblr.com/oauth/"
private const val AUTHORIZE_URL = "${O_AUTH_BASE_URL}authorize"
private const val REQUEST_TOKEN_RESOURCE = "${O_AUTH_BASE_URL}request_token"
private const val ACCESS_TOKEN_RESOURCE = "${O_AUTH_BASE_URL}access_token"

// Tumblr returns the HTTP response code inside of the response body,
// so we tell OkHTTP/Retrofit to treat every response as a 200 and we'll handle correctly parsing the error responses.
private val treatAs200ResponseInterceptor: Interceptor = Interceptor { chain: Interceptor.Chain ->
    return@Interceptor chain.proceed(chain.request())
        .newBuilder()
        .code(200)
        .build()
}

internal fun getOAuthConsumer(appKey: TumblrAppKey): OkHttpOAuthConsumer =
    OkHttpOAuthConsumer(appKey.apiKey, appKey.apiSecret)

private fun getOAuthConsumer(userKey: TumblrUserKey): OkHttpOAuthConsumer =
    OkHttpOAuthConsumer(userKey.apiKey, userKey.apiSecret).also {
        it.setTokenWithSecret(userKey.userKey, userKey.userSecret)
    }

internal fun getOAuthProvider(okHttpOAuthConsumer: OkHttpOAuthConsumer): OkHttpOAuthProvider =
    OkHttpOAuthProvider(
        REQUEST_TOKEN_RESOURCE,
        ACCESS_TOKEN_RESOURCE,
        AUTHORIZE_URL,
        getHttpClient(okHttpOAuthConsumer)
    )

private fun getHttpClient(consumer: OkHttpOAuthConsumer, debug: Boolean = false): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = if (debug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    return OkHttpClient.Builder()
        .followRedirects(false)
        .retryOnConnectionFailure(false)
        .addInterceptor(SigningInterceptor(consumer))
        .addInterceptor(treatAs200ResponseInterceptor)
        .addNetworkInterceptor(logging)
        .build()
}

private fun getRetrofit(
    consumer: OkHttpOAuthConsumer,
    debug: Boolean = false,
    strict: Boolean = false,
    useShimo: Boolean = false,
): Retrofit {
    val moshiFactory = MoshiConverterFactory.create(if (useShimo) shimo else moshi).let { factory ->
        if (strict) {
            factory.failOnUnknown()
        } else {
            factory
        }
    }

    return Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(moshiFactory)
        .client(getHttpClient(consumer, debug))
        .build()
}

/**
 * Get a Kotlr API client.
 *
 * This allows you to perform requests to the Tumblr API.
 *
 * @param userKey The User key to be used to authenticate the requests.
 * @param debug Controls whether or not requests are made in debug mode (prints extra connection debugging information.)
 * @param strict Controls whether or not parsing is performed in strict mode (throws an error if Tumblr returns unexpected data.)
 * @param useShimo Controls whether or not Shimo is added to Moshi, randomizing the order of properties. This breaks many interactions with Tumblr, still investigating who's fault that is.
 */
public fun getApi(
    userKey: TumblrUserKey,
    debug: Boolean = false,
    strict: Boolean = false,
    useShimo: Boolean = false,
): KotlrApi {
    val client = getRetrofit(getOAuthConsumer(userKey), debug = debug, strict = strict, useShimo = useShimo)
    val userGetApi: KotlrUserGetApi = client.create()
    val userPostApi: KotlrUserPostApi = client.create()
    val userDeleteApi: KotlrUserDeleteApi = client.create()
    val blogGetApi: KotlrBlogGetApi = client.create()
    val blogPostApi: KotlrBlogPostApi = client.create()
    val blogDeleteApi: KotlrBlogDeleteApi = client.create()
    val postsGetApi: KotlrPostsGetApi = client.create()
    return KotlrApi(userGetApi, userPostApi, userDeleteApi, blogGetApi, blogPostApi, blogDeleteApi, postsGetApi)
}
