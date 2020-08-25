@file:Suppress("unused")

package com.highthunder.kotlr

import com.highthunder.kotlr.authentication.TumblrAppKey
import com.highthunder.kotlr.authentication.TumblrUserKey

/*
 * SampleKeys - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */

/**
 * TODO: Documentation
 */
public val SampleAppKey: TumblrAppKey = TumblrAppKey(
    apiKey = "apiKey aka ConsumerKey",
    apiSecret = "apiSecret aka ConsumerSecret"
)

/**
 * TODO: Documentation
 */
public val SampleUserKey: TumblrUserKey = TumblrUserKey(
    appKey = SampleAppKey,
    userKey = "userKey aka Token",
    userSecret = "userSecret aka TokenSecret"
)
