package com.highthunder.kotlr.authentication

/**
 * TumblrUserKey - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
data class TumblrUserKey(
    override val apiKey: String,
    override val apiSecret: String,
    val userKey: String,
    val userSecret: String
) : TumblrAppKey(
    apiKey,
    apiSecret
) {
    constructor(appKey: TumblrAppKey, userKey: String, userSecret: String) : this(
        appKey.apiKey,
        appKey.apiSecret,
        userKey,
        userSecret
    )
}
