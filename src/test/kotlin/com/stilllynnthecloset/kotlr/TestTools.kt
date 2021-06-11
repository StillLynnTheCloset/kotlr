package com.stilllynnthecloset.kotlr

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

internal fun <Key, Value> assertMapEquals(message: String?, expected: Map<Key, Value>?, actual: Map<Key, Value>?) {
    if (expected == null && actual == null) {
        return
    } else if (expected != null && actual != null) {
        assertEquals(message, expected.keys.size, actual.keys.size)
        expected.keys.forEach { key ->
            assertEquals(message, expected[key], actual[key])
        }
        actual.keys.forEach { key ->
            assertEquals(message, expected[key], actual[key])
        }
    } else {
        assertTrue(message, false)
        return
    }
}

internal fun <Key, Value> assertMapEquals(expected: Map<Key, Value>?, actual: Map<Key, Value>?) {
    assertMapEquals(null, expected, actual)
}
