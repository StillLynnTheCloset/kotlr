package com.highthunder.kotlr

import com.highthunder.kotlr.json.superwrapper.PostJsonAdapter
import com.highthunder.kotlr.json.superwrapper.SuperPostJson
import com.highthunder.kotlr.types.*
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.PostContent.*
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.JsonAdapter
import org.junit.Assert
import org.junit.Test

/**
 * TumblrTest - A bunch of simple json parsing test cases.
 *
 * TODO: Flesh out the test cases, actually check that inner objects were parsed correctly.
 * TODO: Simplify the samples to limit what is being tested.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class TumblrTest {

    private val a = PostJsonAdapter()

    // region Attribution Tests

    @Test
    fun parseAttributionPostTest() {
        val adapter = Kotlr.getMoshi().adapter(Attribution::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.Post? = adapter.fromJson(Sample.postAttribution) as? Attribution.Post
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.url)
        Assert.assertNotNull(attribution?.post)
        Assert.assertNotNull(attribution?.post?.id)
        Assert.assertNotNull(attribution?.blog)
        Assert.assertNotNull(attribution?.blog?.uuid)
        Assert.assertNotNull(attribution?.blog?.name)
        Assert.assertNotNull(attribution?.blog?.url)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseAttributionLinkTest() {
        val adapter = Kotlr.getMoshi().adapter(Attribution::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.Link? = adapter.fromJson(Sample.linkAttribution) as? Attribution.Link
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.url)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseAttributionBlogTest() {
        val adapter = Kotlr.getMoshi().adapter(Attribution::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.Blog? = adapter.fromJson(Sample.blogAttribution) as? Attribution.Blog
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.blog)
        Assert.assertNotNull(attribution?.blog?.uuid)
        Assert.assertNotNull(attribution?.blog?.name)
        Assert.assertNotNull(attribution?.blog?.url)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseAttributionAppTest() {
        val adapter = Kotlr.getMoshi().adapter(Attribution::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Attribution>)

        val attribution: Attribution.App? = adapter.fromJson(Sample.appAttribution) as? Attribution.App
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.url)
        Assert.assertNotNull(attribution?.appName)
        Assert.assertNotNull(attribution?.displayText)
        Assert.assertNotNull(attribution?.logo)
        Assert.assertNotNull(attribution?.logo?.url)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Post Content Tests

    @Test
    fun parseAudioTumblrTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: AudioContent? = adapter.fromJson(Sample.audioContentTumblr) as? AudioContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.media)
        Assert.assertNotNull(content?.poster)
        Assert.assertNull(content?.attribution)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseAudioSoundCloudTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: AudioContent? = adapter.fromJson(Sample.audioContentSoundCloud) as? AudioContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.media)
        Assert.assertNotNull(content?.poster)
        Assert.assertNull(content?.attribution)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseImageTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: ImageContent? = adapter.fromJson(Sample.imageContent) as? ImageContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.media)
        Assert.assertEquals(3, content?.media?.size)
        Assert.assertNull(content?.colors)
        Assert.assertNull(content?.poster)
        Assert.assertNull(content?.attribution)
        Assert.assertNull(content?.feedbackToken)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseImageWithFeedbackTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: ImageContent? = adapter.fromJson(Sample.imageContentFeedback) as? ImageContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.feedbackToken)
        Assert.assertNotNull(content?.media)
        Assert.assertEquals(1, content?.media?.size)
        Assert.assertNull(content?.colors)
        Assert.assertNull(content?.poster)
        Assert.assertNull(content?.attribution)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLinkReadTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: LinkContent? = adapter.fromJson(Sample.linkContentRead) as? LinkContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.title)
        Assert.assertNotNull(content?.url)
        Assert.assertNotNull(content?.author)
        Assert.assertNotNull(content?.siteName)
        Assert.assertNotNull(content?.displayUrl)
        Assert.assertNotNull(content?.description)
        Assert.assertNotNull(content?.poster)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLinkCreateTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: LinkContent? = adapter.fromJson(Sample.linkContentCreate) as? LinkContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.title)
        Assert.assertNotNull(content?.url)
        Assert.assertNotNull(content?.author)
        Assert.assertNotNull(content?.description)
        Assert.assertNotNull(content?.poster)
        Assert.assertNull(content?.siteName)
        Assert.assertNull(content?.displayUrl)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseVideoTumblrTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: VideoContent? = adapter.fromJson(Sample.videoContentTumblr) as? VideoContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.media)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseVideoYoutubeTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: VideoContent? = adapter.fromJson(Sample.videoContentYoutube) as? VideoContent
        Assert.assertNotNull(content)
        Assert.assertNull(content?.media)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseVideoContentIFrame() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val post: PostContent? = adapter.fromJson(Sample.videoContentIFrame)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Text Subtypes Tests

    @Test
    fun parseTextSimpleTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentSimple) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertNull(content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextChatTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentChat) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertNotNull(content?.formatting)
        Assert.assertEquals(TextContent.SubType.Chat, content?.subType)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextQuirkyTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentQuirky) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertEquals(TextContent.SubType.Quirky, content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextHeading1Test() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentHeading1) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertEquals(TextContent.SubType.Heading1, content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextHeading2Test() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentHeading2) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertEquals(TextContent.SubType.Heading2, content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextQuoteTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentQuote) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertEquals(TextContent.SubType.Quote, content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextOrderedItemTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentOrderedList) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertEquals(TextContent.SubType.OrderedListItem, content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseTextUnorderedItemTest() {
        val adapter = Kotlr.getMoshi().adapter(PostContent::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostContent>)

        val content: TextContent? = adapter.fromJson(Sample.textContentUnorderedList) as? TextContent
        Assert.assertNotNull(content)
        Assert.assertNotNull(content?.text)
        Assert.assertEquals(TextContent.SubType.UnorderedListItem, content?.subType)
        Assert.assertNull(content?.formatting)
        val json = adapter.toJson(content)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Text Format Tests

    @Test
    fun parseFormatColorTest() {
        val adapter = Kotlr.getMoshi().adapter(TextFormat::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: TextFormat.Color? = adapter.fromJson(Sample.textFormatColor) as? TextFormat.Color
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.start)
        Assert.assertNotNull(attribution?.end)
        Assert.assertNotNull(attribution?.hex)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseFormatMentionTest() {
        val adapter = Kotlr.getMoshi().adapter(TextFormat::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: TextFormat.Mention? = adapter.fromJson(Sample.textFormatMention) as? TextFormat.Mention
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.start)
        Assert.assertNotNull(attribution?.end)
        Assert.assertNotNull(attribution?.blog)
        Assert.assertNotNull(attribution?.blog?.uuid)
        Assert.assertNotNull(attribution?.blog?.name)
        Assert.assertNotNull(attribution?.blog?.url)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseFormatSizeTest() {
        val adapter = Kotlr.getMoshi().adapter(TextFormat::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<TextFormat>)

        val attribution: TextFormat.Size? = adapter.fromJson(Sample.textFormatSize) as? TextFormat.Size
        Assert.assertNotNull(attribution)
        Assert.assertNotNull(attribution?.start)
        Assert.assertNotNull(attribution?.end)
        Assert.assertNotNull(attribution?.size)
        Assert.assertEquals(attribution?.size, TextFormat.Size.Option.Small)
        val json = adapter.toJson(attribution)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Content Layout Tests

    @Test
    fun parseLayoutNullTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Vertical? = adapter.fromJson(Sample.layoutNull) as? BlockLayout.Vertical
        Assert.assertNull(layout)
        val json = adapter.toJson(layout)
        Assert.assertNotNull(json)
        Assert.assertEquals("null", json)
    }

    @Test
    fun parseLayoutVerticalTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Vertical? = adapter.fromJson(Sample.layoutVertical) as? BlockLayout.Vertical
        Assert.assertNotNull(layout)
        val json = adapter.toJson(layout)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLayoutRowTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Row? = adapter.fromJson(Sample.layoutRow) as? BlockLayout.Row
        Assert.assertNotNull(layout)
        Assert.assertNotNull(layout?.rows)
        Assert.assertNull(layout?.display)
        val json = adapter.toJson(layout)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLayoutRowDisplayModeTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Row? = adapter.fromJson(Sample.layoutRowDisplayMode) as? BlockLayout.Row
        Assert.assertNotNull(layout)
        Assert.assertNotNull(layout?.display)
        Assert.assertNull(layout?.rows)
        val json = adapter.toJson(layout)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLayoutCondensedTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Condensed? = adapter.fromJson(Sample.layoutCondensed) as? BlockLayout.Condensed
        Assert.assertNotNull(layout)
        Assert.assertNotNull(layout?.blocks)
        val json = adapter.toJson(layout)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLayoutAskTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout>)

        val layout: BlockLayout.Ask? = adapter.fromJson(Sample.layoutAsk) as? BlockLayout.Ask
        Assert.assertNotNull(layout)
        Assert.assertNotNull(layout?.blocks)
        Assert.assertNotNull(layout?.attribution)
        val json = adapter.toJson(layout)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Row Display Tests

    @Test
    fun parseDisplayWeightedTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout.Row.Display::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout.Row.Display>)

        val display: BlockLayout.Row.Display? = adapter.fromJson(Sample.displayModeWeighted)
        Assert.assertNotNull(display)
        Assert.assertNotNull(display?.blocks)
        Assert.assertNotNull(display?.mode)
        Assert.assertTrue(display?.mode is BlockLayout.Row.Display.Mode.Weighted)
        val json = adapter.toJson(display)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseDisplayCarouselTest() {
        val adapter = Kotlr.getMoshi().adapter(BlockLayout.Row.Display::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<BlockLayout.Row.Display>)

        val display: BlockLayout.Row.Display? = adapter.fromJson(Sample.displayModeCarousel)
        Assert.assertNotNull(display)
        Assert.assertNotNull(display?.blocks)
        Assert.assertNotNull(display?.mode)
        Assert.assertTrue(display?.mode is BlockLayout.Row.Display.Mode.Carousel)
        val json = adapter.toJson(display)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Media Object Tests

    @Test
    fun parseMediaJpegTest() {
        val adapter = Kotlr.getMoshi().adapter(Media::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Media>)

        val media: Media? = adapter.fromJson(Sample.mediaContentJpeg)
        Assert.assertNotNull(media)
        Assert.assertNotNull(media?.type)
        Assert.assertNotNull(media?.url)
        Assert.assertNotNull(media?.width)
        Assert.assertNotNull(media?.height)
        val json = adapter.toJson(media)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseMediaMp4Test() {
        val adapter = Kotlr.getMoshi().adapter(Media::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Media>)

        val media: Media? = adapter.fromJson(Sample.mediaContentMp4)
        Assert.assertNotNull(media)
        Assert.assertNotNull(media?.type)
        Assert.assertNotNull(media?.url)
        Assert.assertNotNull(media?.width)
        Assert.assertNotNull(media?.height)
        val json = adapter.toJson(media)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseMediaGifTest() {
        val adapter = Kotlr.getMoshi().adapter(Media::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Media>)

        val media: Media? = adapter.fromJson(Sample.mediaContentGif)
        Assert.assertNotNull(media)
        Assert.assertNotNull(media?.type)
        Assert.assertNotNull(media?.url)
        Assert.assertNotNull(media?.width)
        Assert.assertNotNull(media?.height)
        Assert.assertNotNull(media?.poster)
        Assert.assertNotNull(media?.poster?.url)
        val json = adapter.toJson(media)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Legacy Posts Tests

    @Test
    fun parseLegacyAnswerTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.answerPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAnswerAbstractTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.answerPostWithAbstract)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.audioPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioTrackTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.audioPostWithTrack)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioTrackOfTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.audioPostWithTrackOf)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioProviderTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.audioPostWithProvider)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioExternalTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.audioPostWithExternal)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyChatTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.chatPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyChat2Test() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.chat2Post)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyLinkTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.linkPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyLinkImageTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.linkPostWithImage)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyLinkAuthorTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.linkPostWithAuthor)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.photoPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoPanoramaTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.photoPostWithPanorama)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoAbstractTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.photoPostWithCaptionAbstract)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoSubmissionTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.submission)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoLayoutTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.photoPostWithLayout)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoLinkUrlTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.photoPostWithLinkUrl)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyQuoteTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.quotePost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyTextTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.textPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyTextAbstractTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.textPostWithAbstract)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoPostTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.videoPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoVideoTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.videoPostWithVideoObject)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoPermaLinkTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.videoPostWithPermaLink)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoFloatTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.videoPostWithFloatDuration)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoBooleanEmbedTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.videoPostWithBooleanEmbed)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parsePostWithNotesTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.postWithNotesData)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parsePostWithReblogTest() {
        val adapter = Kotlr.getMoshi().adapter(SuperPostJson::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<SuperPostJson>)

        val post: SuperPostJson? = adapter.fromJson(Sample.postWithReblogData)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
                post.toString().replace(",", "\n"),
                parsed.toString().replace(",", "\n"))
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Legacy Data Tests

    @Test
    fun parsePhotoWithExifTest() {
        val adapter = Kotlr.getMoshi().adapter(Photo::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Photo>)

        val post: Photo? = adapter.fromJson(Sample.photoWithExit)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoTest() {
        val adapter = Kotlr.getMoshi().adapter(Video::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Video>)

        val post: Video? = adapter.fromJson(Sample.video)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    // endregion

    // region User Tests

    @Test
    fun parseUserOtherTest() {
        val adapter = Kotlr.getMoshi().adapter(User::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<User>)

        val user: User? = adapter.fromJson(Sample.userOther)
        Assert.assertNotNull(user)
        val json = adapter.toJson(user)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseUserSelfTest() {
        val adapter = Kotlr.getMoshi().adapter(User::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<User>)

        val user: User? = adapter.fromJson(Sample.userSelf)
        Assert.assertNotNull(user)
        val json = adapter.toJson(user)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Blog Tests

    @Test
    fun parseBlogOtherTest() {
        val adapter = Kotlr.getMoshi().adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogOther)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogSubmissionsTest() {
        val adapter = Kotlr.getMoshi().adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogSubmission)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogNsfwTest() {
        val adapter = Kotlr.getMoshi().adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogNsfw)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogAuthTest() {
        val adapter = Kotlr.getMoshi().adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogAuth)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogSelfTest() {
        val adapter = Kotlr.getMoshi().adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogSelf)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Neue Post Format Tests

    @Test
    fun parseRealPostTest() {
        val adapter = Kotlr.getMoshi().adapter(Post::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Post>)

        val post: Post? = adapter.fromJson(Sample.npfAnouncementPost)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Note Data Tests

    @Test
    fun parseNoteLikeTest() {
        val adapter = Kotlr.getMoshi().adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteLike)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNotePostedTest() {
        val adapter = Kotlr.getMoshi().adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.notePosted)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteAttributionTest() {
        val adapter = Kotlr.getMoshi().adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.notePostAttribution)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteReblogTest() {
        val adapter = Kotlr.getMoshi().adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteReblogWithAddedText)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteReplyTest() {
        val adapter = Kotlr.getMoshi().adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteWithResponseText)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteReplyFormattedReblogTest() {
        val adapter = Kotlr.getMoshi().adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteWithFormatting)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    // endregion

}
