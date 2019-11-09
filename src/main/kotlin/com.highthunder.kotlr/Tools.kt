package com.highthunder.kotlr

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

internal inline fun <reified T> Moshi.adapter(): JsonAdapter<T> = adapter(T::class.java)
internal inline fun <reified T> Moshi.listAdapter(): JsonAdapter<List<T>> = adapter(Types.newParameterizedType(List::class.java, T::class.java))
internal inline fun <reified K, reified V> Moshi.mapAdapter(): JsonAdapter<Map<K, V>> = adapter(Types.newParameterizedType(List::class.java, K::class.java, V::class.java))

internal inline fun justTry(block: () -> Unit) {
    try {
        block()
    } catch (e: Throwable) {
        e.printStackTrace()
    }
}

internal inline fun <reified T> tryOrNull(block: () -> T): T? {
    return try {
        block()
    } catch (e: Throwable) {
        e.printStackTrace()
        null
    }
}
