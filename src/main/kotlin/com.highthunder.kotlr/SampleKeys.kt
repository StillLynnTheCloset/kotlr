@file:Suppress("unused")

package com.highthunder.kotlr

import com.highthunder.kotlr.authentication.TumblrAppKey
import com.highthunder.kotlr.authentication.TumblrUserKey

/**
 * SampleKeys - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
@Suppress("SpellCheckingInspection")
val SampleAppKey: TumblrAppKey = TumblrAppKey(
    apiKey = "apiKeyAkaConsumerKey",
    apiSecret = "apiSecretAkaConsumerSecret"
)

/**
 *  TODO: Documentation
 */
@Suppress("SpellCheckingInspection")
val SampleUserKey: TumblrUserKey = TumblrUserKey(
    appKey = SampleAppKey,
    userKey = "userKeyAkaToken",
    userSecret = "userSecretAkaTokenSecret"
)
