package com.highthunder.kotlr

import com.squareup.moshi.Moshi

/**
 * A lazily constructed instance of the Moshi JSON parser that is setup to parse all of our data types.
 */
internal val moshi: Moshi by lazy {
    return@lazy Moshi
        .Builder()
        .addKotlrTypes()
        .build()
}
