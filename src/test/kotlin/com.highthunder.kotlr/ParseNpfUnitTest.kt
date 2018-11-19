package com.highthunder.kotlr

import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.JsonAdapter
import org.junit.Assert.*
import org.junit.Test

class ParseNpfUnitTest {

    // region Post Content Tests

    @Test
    fun parseAudioTumblrTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.AudioContent? =
            adapter.fromJson(Sample.audioContentTumblr) as? PostContent.AudioContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertNotNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseAudioSoundCloudTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.AudioContent? =
            adapter.fromJson(Sample.audioContentSoundCloud) as? PostContent.AudioContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertNotNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseImageTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.ImageContent? = adapter.fromJson(Sample.imageContent) as? PostContent.ImageContent
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
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.ImageContent? =
            adapter.fromJson(Sample.imageContentFeedback) as? PostContent.ImageContent
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
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.ImageContent? =
            adapter.fromJson(Sample.imageContentColors) as? PostContent.ImageContent
        assertNotNull(content)
        assertNotNull(content?.media)
        assertNotNull(content?.colors)
        assertEquals(2, content?.colors?.colors?.size)
        assertNull(content?.poster)
        assertNull(content?.attribution)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseLinkReadTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.LinkContent? = adapter.fromJson(Sample.linkContentRead) as? PostContent.LinkContent
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
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.LinkContent? = adapter.fromJson(Sample.linkContentCreate) as? PostContent.LinkContent
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
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.VideoContent? =
            adapter.fromJson(Sample.videoContentTumblr) as? PostContent.VideoContent
        assertNotNull(content)
        assertNotNull(content?.media)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseVideoYoutubeTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.VideoContent? =
            adapter.fromJson(Sample.videoContentYoutube) as? PostContent.VideoContent
        assertNotNull(content)
        assertNull(content?.media)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseVideoContentIFrame() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
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
        val adapter = moshi().adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.Post? = adapter.fromJson(Sample.postAttribution) as? Attribution.Post
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
        val adapter = moshi().adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.Link? = adapter.fromJson(Sample.linkAttribution) as? Attribution.Link
        assertNotNull(attribution)
        assertNotNull(attribution?.url)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseAttributionBlogTest() {
        val adapter = moshi().adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.Blog? = adapter.fromJson(Sample.blogAttribution) as? Attribution.Blog
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
        val adapter = moshi().adapter(Attribution::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.App? = adapter.fromJson(Sample.appAttribution) as? Attribution.App
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
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? = adapter.fromJson(Sample.textContentSimple) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertNull(content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextChatTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? = adapter.fromJson(Sample.textContentChat) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertNotNull(content?.formatting)
        assertEquals(PostContent.TextContent.SubType.Chat, content?.subType)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextQuirkyTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? = adapter.fromJson(Sample.textContentQuirky) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(PostContent.TextContent.SubType.Quirky, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextHeading1Test() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? = adapter.fromJson(Sample.textContentHeading1) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(PostContent.TextContent.SubType.Heading1, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextHeading2Test() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? = adapter.fromJson(Sample.textContentHeading2) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(PostContent.TextContent.SubType.Heading2, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextQuoteTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? = adapter.fromJson(Sample.textContentQuote) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(PostContent.TextContent.SubType.Quote, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextOrderedItemTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? =
            adapter.fromJson(Sample.textContentOrderedList) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(PostContent.TextContent.SubType.OrderedListItem, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    @Test
    fun parseTextUnorderedItemTest() {
        val adapter = moshi().adapter(PostContent::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<PostContent>)

        val content: PostContent.TextContent? =
            adapter.fromJson(Sample.textContentUnorderedList) as? PostContent.TextContent
        assertNotNull(content)
        assertNotNull(content?.text)
        assertEquals(PostContent.TextContent.SubType.UnorderedListItem, content?.subType)
        assertNull(content?.formatting)
        val json = adapter.toJson(content)
        assertNotNull(json)
    }

    // endregion

    // region Text Format Tests

    @Test
    fun parseFormatColorTest() {
        val adapter = moshi().adapter(TextFormat::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: TextFormat.Color? = adapter.fromJson(Sample.textFormatColor) as? TextFormat.Color
        assertNotNull(attribution)
        assertNotNull(attribution?.start)
        assertNotNull(attribution?.end)
        assertNotNull(attribution?.hex)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    @Test
    fun parseFormatMentionTest() {
        val adapter = moshi().adapter(TextFormat::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: TextFormat.Mention? = adapter.fromJson(Sample.textFormatMention) as? TextFormat.Mention
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
        val adapter = moshi().adapter(TextFormat::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: TextFormat.Size? = adapter.fromJson(Sample.textFormatSize) as? TextFormat.Size
        assertNotNull(attribution)
        assertNotNull(attribution?.start)
        assertNotNull(attribution?.end)
        assertNotNull(attribution?.size)
        assertEquals(attribution?.size, TextFormat.Size.Option.Small)
        val json = adapter.toJson(attribution)
        assertNotNull(json)
    }

    // endregion

    // region Content Layout Tests

    @Test
    fun parseLayoutNullTest() {
        val adapter = moshi().adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Vertical? = adapter.fromJson(Sample.layoutNull) as? BlockLayout.Vertical
        assertNull(layout)
        val json = adapter.toJson(layout)
        assertNotNull(json)
        assertEquals("null", json)
    }

    @Test
    fun parseLayoutVerticalTest() {
        val adapter = moshi().adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Vertical? = adapter.fromJson(Sample.layoutVertical) as? BlockLayout.Vertical
        assertNotNull(layout)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutRowTest() {
        val adapter = moshi().adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Row? = adapter.fromJson(Sample.layoutRow) as? BlockLayout.Row
        assertNotNull(layout)
        assertNotNull(layout?.rows)
        assertNull(layout?.display)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutRowDisplayModeTest() {
        val adapter = moshi().adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Row? = adapter.fromJson(Sample.layoutRowDisplayMode) as? BlockLayout.Row
        assertNotNull(layout)
        assertNotNull(layout?.display)
        assertNull(layout?.rows)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutCondensedTest() {
        val adapter = moshi().adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Condensed? = adapter.fromJson(Sample.layoutCondensed) as? BlockLayout.Condensed
        assertNotNull(layout)
        assertNotNull(layout?.blocks)
        val json = adapter.toJson(layout)
        assertNotNull(json)
    }

    @Test
    fun parseLayoutAskTest() {
        val adapter = moshi().adapter(BlockLayout::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Ask? = adapter.fromJson(Sample.layoutAsk) as? BlockLayout.Ask
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
        val adapter = moshi().adapter(BlockLayout.Row.Display::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout.Row.Display>)

        val display: BlockLayout.Row.Display? = adapter.fromJson(Sample.displayModeWeighted)
        assertNotNull(display)
        assertNotNull(display?.blocks)
        assertNotNull(display?.mode)
        assertTrue(display?.mode is BlockLayout.Row.Display.Mode.Weighted)
        val json = adapter.toJson(display)
        assertNotNull(json)
    }

    @Test
    fun parseDisplayCarouselTest() {
        val adapter = moshi().adapter(BlockLayout.Row.Display::class.java).failOnUnknown()
        assertTrue(adapter is JsonAdapter<BlockLayout.Row.Display>)

        val display: BlockLayout.Row.Display? = adapter.fromJson(Sample.displayModeCarousel)
        assertNotNull(display)
        assertNotNull(display?.blocks)
        assertNotNull(display?.mode)
        assertTrue(display?.mode is BlockLayout.Row.Display.Mode.Carousel)
        val json = adapter.toJson(display)
        assertNotNull(json)
    }

    // endregion

    // region Media Object Tests

    @Test
    fun parseMediaJpegTest() {
        val adapter = moshi().adapter(Media::class.java).failOnUnknown()
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
        val adapter = moshi().adapter(Media::class.java).failOnUnknown()
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
        val adapter = moshi().adapter(Media::class.java).failOnUnknown()
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