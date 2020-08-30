package com.highthunder.kotlr.authentication

/**
 * TumblrApiKey - A simple class to hold the two strings that make up an application token.
 *
 * These strings are provided by Tumblr after you have registered your application.
 * See: https://www.tumblr.com/oauth/apps
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 *
 * @param apiKey Tumblr calls this the "OAuth Consumer Key". The OAuth standard calls this "Consumer Key".
 * @param apiSecret Tumblr calls this the "Secret Key". The OAuth standard calls this "Consumer Secret".
 */
public open class TumblrAppKey constructor(
    public open val apiKey: String,
    public open val apiSecret: String,
)
