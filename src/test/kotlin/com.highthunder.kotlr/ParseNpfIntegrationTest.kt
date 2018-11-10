package com.highthunder.kotlr

import com.highthunder.kotlr.types.Post
import com.squareup.moshi.JsonAdapter
import org.junit.Assert.*
import org.junit.Test

class ParseNpfIntegrationTest {

    // region Neue Post Format Tests

    @Test
    fun parseRealPostTest() {
        val adapter = Kotlr.getMoshi().adapter(Post::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Post>)

        val post: Post? = adapter.fromJson(Sample.npfAnouncementPost)
        assertNotNull(post)
        val json = adapter.toJson(post)
        assertNotNull(json)
    }

    // endregion

}