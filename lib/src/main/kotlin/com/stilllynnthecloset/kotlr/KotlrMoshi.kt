package com.stilllynnthecloset.kotlr

import com.jakewharton.shimo.ObjectOrderRandomizer
import com.squareup.moshi.Moshi

/**
 * A lazily constructed instance of the Moshi JSON parser that is set up to parse all of our data types.
 */
internal val moshi: Moshi by lazy {
    return@lazy Moshi
        .Builder()
        .addKotlrTypes()
        .build()
}

/**
 * A lazily constructed instance of the Moshi JSON parser that is set up to parse all of our data types.
 *
 * This version, however, also includes Shimo's [ObjectOrderRandomizer] for use when testing.
 */
internal val shimo: Moshi by lazy {
    return@lazy Moshi
        .Builder()
        .add(ObjectOrderRandomizer.create())
        .addKotlrTypes()
        .build()
}
