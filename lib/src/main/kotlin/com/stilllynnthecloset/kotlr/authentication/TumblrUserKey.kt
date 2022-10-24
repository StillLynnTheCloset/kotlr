package com.stilllynnthecloset.kotlr.authentication

/**
 * TumblrUserKey - An extension of [TumblrAppKey] that also includes user specific credentials.
 *
 * Acquire this data by using an [OAuthFlow], but this constructor is public, so you can rebuild this from a persistent datastore.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 *
 * @param apiKey Tumblr calls this the "OAuth Consumer Key". The OAuth standard calls this "Consumer Key".
 * @param apiSecret Tumblr calls this the "Secret Key". The OAuth standard calls this "Consumer Secret".
 * @param userKey The OAuth standard calls this "Access Secret".
 * @param userSecret The OAuth standard calls this "Access Secret".
 */
public data class TumblrUserKey constructor(
    override val apiKey: String,
    override val apiSecret: String,
    val userKey: String,
    val userSecret: String,
) : TumblrAppKey(
    apiKey,
    apiSecret,
) {
    public constructor(appKey: TumblrAppKey, userKey: String, userSecret: String) : this(
        appKey.apiKey,
        appKey.apiSecret,
        userKey,
        userSecret,
    )
}
