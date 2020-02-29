package com.highthunder.kotlr

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.content.PostContent
import org.junit.Assert
import org.junit.Test

class TumblrNpfSamplesTests {
    @Test
    fun postIdentification() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.postIdentification)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlocks1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlocks1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlocks2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlocks2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlocks3() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlocks3)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun mediaObjects() {
        val adapter = moshi.adapter<Media>().failOnUnknown()

        val content: Media? = adapter.fromJson(TumblrNpfSamples.mediaObjects)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_leadingTrailingEmptyBlocks_before() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_leadingTrailingEmptyBlocks_before)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_leadingTrailingEmptyBlocks_after() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_leadingTrailingEmptyBlocks_after)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_subtypes1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_subtypes1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_subtypes2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_subtypes2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_subtypes3() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_subtypes3)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_subtypes4() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_subtypes4)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_formatting1() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_formatting1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_formatting2() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_formatting2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_formatting3() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_formatting3)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_formatting4() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_formatting4)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeText_formatting5() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeText_formatting5)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeImage1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeImage1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeImage2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeImage2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeImage3() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeImage3)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeImage_gifPosters() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeImage_gifPosters)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeLink1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeLink1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeLink2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeLink2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeAudio1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeAudio1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeAudio2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeAudio2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeVideo1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeVideo1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun contentBlockTypeVideo2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.contentBlockTypeVideo2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeRows1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeRows1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeRows2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeRows2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeRows3() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeRows3)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeRows_displayModeCarousel() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeRows_displayModeCarousel)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeCondensed1() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeCondensed1)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeCondensed2() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeCondensed2)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun layoutBlockTypeAsk() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.layoutBlockTypeAsk)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun reblogTrail() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.reblogTrail)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun reblogTrail_brokenTrailItems() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.reblogTrail_brokenTrailItems)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun attributionTypePost() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.attributionTypePost)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun attributionTypeLink() {
        val adapter = moshi.adapter<PostContent>().failOnUnknown()

        val content: PostContent? = adapter.fromJson(TumblrNpfSamples.attributionTypeLink)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun attributionTypeBlog() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.attributionTypeBlog)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }

    @Test
    fun attributionTypeApp() {
        val adapter = moshi.adapter<Post>().failOnUnknown()

        val content: Post? = adapter.fromJson(TumblrNpfSamples.attributionTypeApp)

        val json = adapter.toJson(content)
        println(json)
        Assert.assertNotNull(json)
    }
}
