package com.stilllynnthecloset.kotlr

import com.stilllynnthecloset.kotlr.types.Color
import org.junit.Assert.assertEquals
import org.junit.Test

internal class ColorsTest {
    @Test
    internal fun testConversion() {
        val color = Color(-15654349)
        assertEquals(-15654349, color.asInt())
        assertEquals("FF112233", color.asString())
        assertEquals("#FF112233", color.asOctothorpeString())
    }

    // region String Parsing

    @Test
    internal fun testParsing_zeroAlpha() {
        val color = Color("#00112233")
        assertEquals(1122867, color.asInt())
        assertEquals("00112233", color.asString())
        assertEquals("#00112233", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_withFullAlpha() {
        val color = Color("#FF112233")
        assertEquals(-15654349, color.asInt())
        assertEquals("FF112233", color.asString())
        assertEquals("#FF112233", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_noAlpha() {
        val color = Color("#112233")
        assertEquals(-15654349, color.asInt())
        assertEquals("FF112233", color.asString())
        assertEquals("#FF112233", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_noOctothorpe() {
        val color = Color("112233")
        assertEquals(-15654349, color.asInt())
        assertEquals("FF112233", color.asString())
        assertEquals("#FF112233", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_noOctothorpeFourDigit() {
        val color = Color("F123")
        assertEquals(-15654349, color.asInt())
        assertEquals("FF112233", color.asString())
        assertEquals("#FF112233", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_noOctothorpeThreeDigit() {
        val color = Color("123")
        assertEquals(-15654349, color.asInt())
        assertEquals("FF112233", color.asString())
        assertEquals("#FF112233", color.asOctothorpeString())
    }

    // endregion String Parsing

    // region String Parsing Invalid

    @Test
    internal fun testParsing_invalid_character() {
        val color = Color("ffz")
        assertEquals(0, color.asInt())
        assertEquals("00000000", color.asString())
        assertEquals("#00000000", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_invalidTooShort() {
        val color = Color("ff")
        assertEquals(0, color.asInt())
        assertEquals("00000000", color.asString())
        assertEquals("#00000000", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_invalidTooLong() {
        val color = Color("fffffffff")
        assertEquals(0, color.asInt())
        assertEquals("00000000", color.asString())
        assertEquals("#00000000", color.asOctothorpeString())
    }

    @Test
    internal fun testParsing_invalidBadLength() {
        val color = Color("fffff")
        assertEquals(0, color.asInt())
        assertEquals("00000000", color.asString())
        assertEquals("#00000000", color.asOctothorpeString())
    }

    // endregion String Parsing Invalid
}
