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
val SampleAppKey = TumblrAppKey (
    apiKey = "apiKeyAkaConsumerKey",
    apiSecret = "apiSecretAkaConsumerSecret"
)

@Suppress("SpellCheckingInspection")
val SampleUserKey = TumblrUserKey(
        appKey = MyAppKey,
        userKey = "userKeyAkaToken",
        userSecret = "userSecretAkaTokenSecret"
)
