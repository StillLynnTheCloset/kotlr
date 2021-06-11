package com.stilllynnthecloset.kotlr

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

internal inline fun <reified T> Moshi.adapter(): JsonAdapter<T> =
    adapter(T::class.java)

internal inline fun <reified T> Moshi.listAdapter(): JsonAdapter<List<T>> =
    adapter(Types.newParameterizedType(List::class.java, T::class.java))

internal inline fun justTry(silent: Boolean = false, block: () -> Unit) {
    try {
        block()
    } catch (e: Throwable) {
        if (!silent) {
            e.printStackTrace()
        }
    }
}

internal inline fun <reified T> tryOrNull(silent: Boolean = false, block: () -> T): T? {
    return try {
        block()
    } catch (e: Throwable) {
        if (!silent) {
            e.printStackTrace()
        }
        null
    }
}
