package com.highthunder.kotlr

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.content.AppAttribution
import com.highthunder.kotlr.types.content.AskBlockLayout
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.AudioContent
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.BlogAttribution
import com.highthunder.kotlr.types.content.ColorTextFormat
import com.highthunder.kotlr.types.content.CondensedBlockLayout
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.LinkAttribution
import com.highthunder.kotlr.types.content.LinkContent
import com.highthunder.kotlr.types.content.MentionTextFormat
import com.highthunder.kotlr.types.content.PostAttribution
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.SizeTextFormat
import com.highthunder.kotlr.types.content.TextContent
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.content.VerticalBlockLayout
import com.highthunder.kotlr.types.content.VideoContent
import com.squareup.moshi.JsonAdapter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ParseNpfUnitTest {

    // region Post Content Tests

    @Test
    fun parseAudioTumblrTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: AudioContent? =
            adapter.fromJson(Sample.audioContentTumblr) as? AudioContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertNotNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseAudioSoundCloudTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: AudioContent? =
            adapter.fromJson(Sample.audioContentSoundCloud) as? AudioContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertNotNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseImageTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: ImageContent? = adapter.fromJson(Sample.imageContent) as? ImageContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertEquals(3, content?.media?.size)
        assertNull(content?.colors)
        assertNull(content?.poster)
        assertNull(content?.attribution)
        assertNull(content?.feedbackToken)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseImageWithFeedbackTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: ImageContent? = adapter.fromJson(Sample.imageContentFeedback) as? ImageContent
        assertNotNull(content)
        assertNotNull(content?.feedbackToken)
        assertNotNull(content?.media)
        assertEquals(1, content?.media?.size)
        assertNull(content?.colors)
        assertNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseImageWithColorsTest() {
        val expectedInts = arrayOf(10634773, 16743424)
        val expectedStrings = arrayOf("a24615", "ff7c00")
        val expectedOctothorpeStrings = arrayOf("#a24615", "#ff7c00")

        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: ImageContent? = adapter.fromJson(Sample.imageContentColors) as? ImageContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertNotNull(content?.colors)
        assertEquals(2, content?.colors?.colors?.size)
        content?.colors?.colors?.forEach { index, color ->
            assertEquals(expectedInts[index], color.asInt())
            assertTrue(expectedStrings[index].contentEquals(color.asString()))
            assertEquals(expectedOctothorpeStrings[index], color.asOctothorpeString())
        }
        assertNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseLinkReadTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: LinkContent? = adapter.fromJson(Sample.linkContentRead) as? LinkContent
        assertNotNull(content)
        assertNotNull(content?.title)
        assertNotNull(content?.url)
        assertNotNull(content?.author)
        assertNotNull(content?.siteName)
        assertNotNull(content?.displayUrl)
        assertNotNull(content?.description)
        assertNotNull(content?.poster)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseLinkCreateTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: LinkContent? = adapter.fromJson(Sample.linkContentCreate) as? LinkContent
        assertNotNull(content)
        assertNotNull(content?.title)
        assertNotNull(content?.url)
        assertNotNull(content?.author)
        assertNotNull(content?.description)
        assertNotNull(content?.poster)
        assertNull(content?.siteName)
        assertNull(content?.displayUrl)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseVideoTumblrTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: VideoContent? = adapter.fromJson(Sample.videoContentTumblr) as? VideoContent
        assertNotNull(content)
        assertNotNull(content?.media)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseVideoYoutubeTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: VideoContent? = adapter.fromJson(Sample.videoContentYoutube) as? VideoContent
        assertNotNull(content)
        assertNull(content?.media)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseVideoContentIFrame() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val post: PostContent? = adapter.fromJson(Sample.videoContentIFrame)
        assertNotNull(post)
        val json = adapter.toJson(post)
        assertNotNull(json)
    }

    // endregion

    // region Attribution Tests

    @Test
    fun parseAttributionPostTest() {
        val adapter = moshi.adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: PostAttribution? = adapter.fromJson(Sample.postAttribution) as? PostAttribution
        assertNotNull(attribution)
        assertNotNull(attribution?.url)
        assertNotNull(attribution?.post)
        assertNotNull(attribution?.post?.id)
        assertNotNull(attribution?.blog)
        assertNotNull(attribution?.blog?.uuid)
        assertNotNull(attribution?.blog?.name)
        assertNotNull(attribution?.blog?.url)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseAttributionLinkTest() {
        val adapter = moshi.adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: LinkAttribution? = adapter.fromJson(Sample.linkAttribution) as? LinkAttribution
        assertNotNull(attribution)
        assertNotNull(attribution?.url)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseAttributionBlogTest() {
        val adapter = moshi.adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: BlogAttribution? = adapter.fromJson(Sample.blogAttribution) as? BlogAttribution
        assertNotNull(attribution)
        assertNotNull(attribution?.blog)
        assertNotNull(attribution?.blog?.uuid)
        assertNotNull(attribution?.blog?.name)
        assertNotNull(attribution?.blog?.url)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseAttributionAppTest() {
        val adapter = moshi.adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: AppAttribution? = adapter.fromJson(Sample.appAttribution) as? AppAttribution
        assertNotNull(attribution)
        assertNotNull(attribution?.url)
        assertNotNull(attribution?.appName)
        assertNotNull(attribution?.displayText)
        assertNotNull(attribution?.logo)
        assertNotNull(attribution?.logo?.url)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    // endregion

    // region Text Subtypes Tests

    @Test
    fun parseTextSimpleTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentSimple) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertNull(content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextChatTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentChat) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertNotNull(content?.formatting)
        assertEquals(TextContent.SubType.Chat, content?.subType)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextQuirkyTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentQuirky) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(TextContent.SubType.Quirky, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextHeading1Test() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentHeading1) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(TextContent.SubType.Heading1, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextHeading2Test() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentHeading2) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(TextContent.SubType.Heading2, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextQuoteTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentQuote) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(TextContent.SubType.Quote, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextOrderedItemTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentOrderedList) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(TextContent.SubType.OrderedListItem, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextUnorderedItemTest() {
        val adapter = moshi.adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? =
            adapter.fromJson(Sample.textContentUnorderedList) as? TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(TextContent.SubType.UnorderedListItem, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    // endregion

    // region Text Format Tests

    @Test
    fun parseFormatColorTest() {
        val adapter = moshi.adapter(TextFormat::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: ColorTextFormat? = adapter.fromJson(Sample.textFormatColor) as? ColorTextFormat
        assertNotNull(attribution)
        assertNotNull(attribution?.start)
        assertNotNull(attribution?.end)
        assertNotNull(attribution?.hex)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseFormatMentionTest() {
        val adapter = moshi.adapter(TextFormat::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: MentionTextFormat? = adapter.fromJson(Sample.textFormatMention) as? MentionTextFormat
        assertNotNull(attribution)
        assertNotNull(attribution?.start)
        assertNotNull(attribution?.end)
        assertNotNull(attribution?.blog)
        assertNotNull(attribution?.blog?.uuid)
        assertNotNull(attribution?.blog?.name)
        assertNotNull(attribution?.blog?.url)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseFormatSizeTest() {
        val adapter = moshi.adapter(TextFormat::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: SizeTextFormat? = adapter.fromJson(Sample.textFormatSize) as? SizeTextFormat
        assertNotNull(attribution)
        assertNotNull(attribution?.start)
        assertNotNull(attribution?.end)
        assertNotNull(attribution?.size)
        assertEquals(attribution?.size, SizeTextFormat.Option.Small)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    // endregion

    // region Content Layout Tests

    @Test
    fun parseLayoutNullTest() {
        val adapter = moshi.adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: VerticalBlockLayout? = adapter.fromJson(Sample.layoutNull) as? VerticalBlockLayout
        assertNull(layout)
        val json = adapter.toJson(layout)
        assertNotNull(json)
        assertEquals("null", json)
    }

    @Test
    fun parseLayoutVerticalTest() {
        val adapter = moshi.adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: VerticalBlockLayout? = adapter.fromJson(Sample.layoutVertical) as? VerticalBlockLayout
        assertNotNull(layout)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutRowTest() {
        val adapter = moshi.adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: RowBlockLayout? = adapter.fromJson(Sample.layoutRow) as? RowBlockLayout
        assertNotNull(layout)
        assertNotNull(layout?.rows)
        assertNull(layout?.display)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutRowDisplayModeTest() {
        val adapter = moshi.adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: RowBlockLayout? = adapter.fromJson(Sample.layoutRowDisplayMode) as? RowBlockLayout
        assertNotNull(layout)
        assertNotNull(layout?.display)
        assertNull(layout?.rows)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutCondensedTest() {
        val adapter = moshi.adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: CondensedBlockLayout? = adapter.fromJson(Sample.layoutCondensed) as? CondensedBlockLayout
        assertNotNull(layout)
        assertNotNull(layout?.blocks)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutAskTest() {
        val adapter = moshi.adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: AskBlockLayout? = adapter.fromJson(Sample.layoutAsk) as? AskBlockLayout
        assertNotNull(layout)
        assertNotNull(layout?.blocks)
        assertNotNull(layout?.attribution)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    // endregion

    // region Row Display Tests

    @Test
    fun parseDisplayWeightedTest() {
        val adapter = moshi.adapter(RowBlockLayout.Display::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<RowBlockLayout.Display>)

        val display: RowBlockLayout.Display? = adapter.fromJson(Sample.displayModeWeighted)
        assertNotNull(display)
        assertNotNull(display?.blocks)
        assertNotNull(display?.mode)
        assertTrue(display?.mode is RowBlockLayout.Display.Mode.Weighted)
        val json = adapter.toJson(display)
        assertNotNull(json)
    }

    @Test
    fun parseDisplayCarouselTest() {
        val adapter = moshi.adapter(RowBlockLayout.Display::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<RowBlockLayout.Display>)

        val display: RowBlockLayout.Display? = adapter.fromJson(Sample.displayModeCarousel)
        assertNotNull(display)
        assertNotNull(display?.blocks)
        assertNotNull(display?.mode)
        assertTrue(display?.mode is RowBlockLayout.Display.Mode.Carousel)
        val json = adapter.toJson(display)
        assertNotNull(json)
    }

    // endregion

    // region Media Object Tests

    @Test
    fun parseMediaJpegTest() {
        val adapter = moshi.adapter(Media::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Media>)

        val media: Media? = adapter.fromJson(Sample.mediaContentJpeg)
        assertNotNull(media)
        assertNotNull(media?.type)
        assertNotNull(media?.url)
        assertNotNull(media?.width)
        assertNotNull(media?.height)
        val json = adapter.toJson(media)
        assertNotNull(json)
    }

    @Test
    fun parseMediaMp4Test() {
        val adapter = moshi.adapter(Media::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Media>)

        val media: Media? = adapter.fromJson(Sample.mediaContentMp4)
        assertNotNull(media)
        assertNotNull(media?.type)
        assertNotNull(media?.url)
        assertNotNull(media?.width)
        assertNotNull(media?.height)
        val json = adapter.toJson(media)
        assertNotNull(json)
    }

    @Test
    fun parseMediaGifTest() {
        val adapter = moshi.adapter(Media::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Media>)

        val media: Media? = adapter.fromJson(Sample.mediaContentGif)
        assertNotNull(media)
        assertNotNull(media?.type)
        assertNotNull(media?.url)
        assertNotNull(media?.width)
        assertNotNull(media?.height)
        assertNotNull(media?.poster)
        assertNotNull(media?.poster?.url)
        val json = adapter.toJson(media)
        assertNotNull(json)
    }

    // endregion
}
