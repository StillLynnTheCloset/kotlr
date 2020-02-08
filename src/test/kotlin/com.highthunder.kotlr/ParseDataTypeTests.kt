package com.highthunder.kotlr

import com.highthunder.kotlr.types.Color
import com.highthunder.kotlr.types.Colors
import com.squareup.moshi.JsonAdapter
import org.junit.Assert
import org.junit.Test

class ParseDataTypeTests {

    // region Colors

    @Test
    fun parseColorsTest() {
        val adapter = moshi.adapter(Colors::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Colors>)

        val colors: Colors? = adapter.fromJson(Sample.colorsSample)
        Assert.assertNotNull(colors)
        Assert.assertEquals(Color("#a24615"), colors?.colors?.get(0))
        Assert.assertEquals(Color("#f70"), colors?.colors?.get(1))
        Assert.assertEquals(Color("#f70"), colors?.colors?.get(2))
        Assert.assertEquals(Color("#a24615"), colors?.colors?.get(3))
        val json = adapter.toJson(colors)
        println(json)
        Assert.assertNotNull(json)
    }

    // endregion Colors
}
