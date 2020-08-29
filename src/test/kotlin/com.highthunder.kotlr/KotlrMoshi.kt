package com.highthunder.kotlr

import com.jakewharton.shimo.ObjectOrderRandomizer
import com.squareup.moshi.Moshi

/**
 * A lazily constructed instance of the Moshi JSON parser that is setup to parse all of our data types.
 *
 * This is a copy of the same val in the non-test source set, but this one includes Shimo's [ObjectOrderRandomizer].
 */
internal val moshi: Moshi by lazy {
    return@lazy Moshi
        .Builder()
        .add(ObjectOrderRandomizer.create())
        .addKotlrTypes()
        .build()
}
