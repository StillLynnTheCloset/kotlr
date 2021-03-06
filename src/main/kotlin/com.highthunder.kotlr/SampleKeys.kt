@file:Suppress("unused")

package com.highthunder.kotlr

import com.highthunder.kotlr.authentication.TumblrAppKey
import com.highthunder.kotlr.authentication.TumblrUserKey

/*
 * SampleKeys - A sample usage of the credentials.
 *
 * @author highthunder
 * @since 2018-11-13
 */

/**
 * A sample AppKey.
 */
public val SampleAppKey: TumblrAppKey = TumblrAppKey(
    apiKey = "apiKey aka ConsumerKey",
    apiSecret = "apiSecret aka ConsumerSecret"
)

/**
 * A sample UserKey, built using [SampleAppKey].
 */
public val SampleUserKey: TumblrUserKey = TumblrUserKey(
    appKey = SampleAppKey,
    userKey = "userKey aka Token",
    userSecret = "userSecret aka TokenSecret"
)
