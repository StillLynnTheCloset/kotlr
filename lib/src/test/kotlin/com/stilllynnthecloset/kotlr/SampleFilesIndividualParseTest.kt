package com.stilllynnthecloset.kotlr
// Disable line length checking because there are a lot of long string literals in here.
/* ktlint-disable max-line-length parameter-list-wrapping */

import com.squareup.moshi.JsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.AttributionWrapper
import com.stilllynnthecloset.kotlr.json.wrapper.ContentWrapper
import com.stilllynnthecloset.kotlr.json.wrapper.MediaWrapper
import com.stilllynnthecloset.kotlr.response.ResponseMetaInfo
import com.stilllynnthecloset.kotlr.response.TumblrError
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogAvatar
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogLikes
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard
import com.stilllynnthecloset.kotlr.types.AskNotification
import com.stilllynnthecloset.kotlr.types.AttributionNote
import com.stilllynnthecloset.kotlr.types.Blog
import com.stilllynnthecloset.kotlr.types.BlogAccessories
import com.stilllynnthecloset.kotlr.types.ClickThrough
import com.stilllynnthecloset.kotlr.types.Color
import com.stilllynnthecloset.kotlr.types.Colors
import com.stilllynnthecloset.kotlr.types.ExifData
import com.stilllynnthecloset.kotlr.types.FilteredReason
import com.stilllynnthecloset.kotlr.types.FollowerNotification
import com.stilllynnthecloset.kotlr.types.LikeNote
import com.stilllynnthecloset.kotlr.types.LikeNotification
import com.stilllynnthecloset.kotlr.types.Media
import com.stilllynnthecloset.kotlr.types.MilestonePostNotification
import com.stilllynnthecloset.kotlr.types.NoteData
import com.stilllynnthecloset.kotlr.types.PollAnswer
import com.stilllynnthecloset.kotlr.types.PollSettings
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.PostedNote
import com.stilllynnthecloset.kotlr.types.ReblogNote
import com.stilllynnthecloset.kotlr.types.ReblogWithContentNotification
import com.stilllynnthecloset.kotlr.types.ReblogWithoutContentNotification
import com.stilllynnthecloset.kotlr.types.RecommendationReason
import com.stilllynnthecloset.kotlr.types.ReplyNote
import com.stilllynnthecloset.kotlr.types.RequestLink
import com.stilllynnthecloset.kotlr.types.RequestLinks
import com.stilllynnthecloset.kotlr.types.RequestQueryParameters
import com.stilllynnthecloset.kotlr.types.SpamReportedNotification
import com.stilllynnthecloset.kotlr.types.SubmissionTerms
import com.stilllynnthecloset.kotlr.types.Trail
import com.stilllynnthecloset.kotlr.types.User
import com.stilllynnthecloset.kotlr.types.UserMentionNotification
import com.stilllynnthecloset.kotlr.types.VideoMetadata
import com.stilllynnthecloset.kotlr.types.content.AppAttribution
import com.stilllynnthecloset.kotlr.types.content.AskBlockLayout
import com.stilllynnthecloset.kotlr.types.content.Attribution
import com.stilllynnthecloset.kotlr.types.content.AudioContent
import com.stilllynnthecloset.kotlr.types.content.BlockLayout
import com.stilllynnthecloset.kotlr.types.content.BlogAttribution
import com.stilllynnthecloset.kotlr.types.content.BoldTextFormat
import com.stilllynnthecloset.kotlr.types.content.ColorTextFormat
import com.stilllynnthecloset.kotlr.types.content.CondensedBlockLayout
import com.stilllynnthecloset.kotlr.types.content.ImageContent
import com.stilllynnthecloset.kotlr.types.content.ItalicTextFormat
import com.stilllynnthecloset.kotlr.types.content.LinkAttribution
import com.stilllynnthecloset.kotlr.types.content.LinkContent
import com.stilllynnthecloset.kotlr.types.content.LinkTextFormat
import com.stilllynnthecloset.kotlr.types.content.MentionTextFormat
import com.stilllynnthecloset.kotlr.types.content.PollContent
import com.stilllynnthecloset.kotlr.types.content.PostAttribution
import com.stilllynnthecloset.kotlr.types.content.PostContent
import com.stilllynnthecloset.kotlr.types.content.RowBlockLayout
import com.stilllynnthecloset.kotlr.types.content.SizeTextFormat
import com.stilllynnthecloset.kotlr.types.content.SmallTextFormat
import com.stilllynnthecloset.kotlr.types.content.StrikeThroughTextFormat
import com.stilllynnthecloset.kotlr.types.content.TextContent
import com.stilllynnthecloset.kotlr.types.content.TextFormat
import com.stilllynnthecloset.kotlr.types.content.VerticalBlockLayout
import com.stilllynnthecloset.kotlr.types.content.VideoContent
import okio.buffer
import okio.source
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

internal class SampleFilesIndividualParseTest {
    internal companion object {
        private var allFileNames = mutableSetOf<String>()
        private val parsedFileNames = mutableSetOf<String>()

        private fun countFilesInDirRecursive(directory: File) {
            if (!directory.exists() || !directory.isDirectory) {
                throw IllegalArgumentException("directory must be a directory")
            }
            directory.listFiles()?.forEach { file ->
                if (file.isDirectory) {
                    countFilesInDirRecursive(file)
                } else {
                    allFileNames.add(file.path)
                }
            }
        }

        @BeforeClass
        @JvmStatic
        internal fun beforeClass() {
            parsedFileNames.clear()
            allFileNames.clear()
            countFilesInDirRecursive(File("samples"))
            println("Expecting to test ${allFileNames.size} files")
        }

        @AfterClass
        @JvmStatic
        internal fun afterClass() {
            // Make sure that we tested every file.
            println("Tested ${parsedFileNames.size} out of ${allFileNames.size} files")
            allFileNames.filter { it !in parsedFileNames }.sorted().forEach {
                println("Did not test file $it")
            }

            assertEquals(allFileNames, parsedFileNames)
        }

        private inline fun <reified T> parseFile(fileName: String): T? =
            parseFile(fileName, moshi.adapter<T>().failOnUnknown())

        private fun <T> parseFile(fileName: String, adapter: JsonAdapter<T>): T? {
            val file = File(fileName)
            if (!file.exists() || !file.isFile) {
                throw IllegalArgumentException("fileName must be the name of a file")
            }
            val bufferedSource = file.source().buffer()
            val safeAdapter = adapter
                .failOnUnknown()
                .nonNull()
            val result = safeAdapter.fromJson(bufferedSource)
            parsedFileNames.add(file.path)
            return result
        }
    }

    // region Integration Test Cases

    @Test
    internal fun testIntegration_npfAnnouncementPost() {
        val post = parseFile<Post>("samples/integrationTest/npfAnnouncementPost.json")
        assertNotNull(post)
    }

    // endregion Integration Test Cases

    // region Manufactured Test Cases

    @Test
    internal fun testManufactured_colors_allFormats() {
        val colors = parseFile<Colors>("samples/manufactured/colors/colorsSampleWithAllFormats.json")
        assertNotNull(colors)
        assertEquals("FFA24615", colors?.colors?.get(0)?.asString())
        assertEquals("FFFF7700", colors?.colors?.get(1)?.asString())
        assertEquals("FFFF7700", colors?.colors?.get(2)?.asString())
        assertEquals("FFA24615", colors?.colors?.get(3)?.asString())
    }

    @Test
    internal fun testManufactured_media_allProperties() {
        val media = parseFile<Media>("samples/manufactured/media/mediaAllProperties.json")
        assertNotNull(media)
        assertNotNull(media?.type)
        assertNotNull(media?.url)
        assertNotNull(media?.width)
        assertNotNull(media?.height)
        assertNotNull(media?.originalDimensionsMissing)
        assertNotNull(media?.hd)
        assertNotNull(media?.poster)
        assertNotNull(media?.mediaKey)
        assertNotNull(media?.cropped)
        assertNotNull(media?.hasOriginalDimensions)
        assertNotNull(media?.colors)
    }

    // endregion Manufactured Tests

    // region Official Samples Test Cases

    // region Blog

    @Test
    internal fun testOfficial_blog_getBlog() {
        val blog = parseFile<Blog>("samples/officialSamples/blog/getBlog.json")
        val expected = Blog(
            title = "David's Log",
            posts = 3456,
            name = "david",
            url = "https://david.tumblr.com/",
            updated = 1308953007,
            description = "<p><strong>Mr. Karp</strong> is tall and skinny, with unflinching blue eyes a mop of brown hair.\r\n He speaks incredibly fast and in complete paragraphs.</p>",
            ask = true,
            askAnon = false,
            likes = 12345,
        )
        assertEquals(expected, blog)
    }

    @Test
    internal fun testOfficial_blog_getFollowing() {
        val blog = parseFile<Blog>("samples/officialSamples/blog/getFollowing.json")
        val expected = Blog(
            title = "David’s Log",
            name = "david",
            url = "https://www.davidslog.com",
            updated = 1308781073,
            description = "“Mr. Karp is tall and skinny, with unflinching blue eyes and a mop of brown hair. He speaks incredibly fast and in complete paragraphs.” – NY Observer",
        )
        assertEquals(expected, blog)
    }

    // endregion Blog

    // region Links

    @Test
    internal fun testOfficial_links_links() {
        val linkMap = parseFile<RequestLinks>("samples/officialSamples/links/links.json")
        val expected = RequestLinks(
            prev = RequestLink(
                linkType = RequestLink.Type.Action,
                httpMethod = "GET",
                fullLink = "https://api.tumblr.com/v2/endpoint",
                queryParams = RequestQueryParameters(
                    pageNumber = "1",
                ),
            ),
            next = RequestLink(
                linkType = RequestLink.Type.Action,
                httpMethod = "GET",
                fullLink = "https://api.tumblr.com/v2/endpoint",
                queryParams = RequestQueryParameters(
                    pageNumber = "3",
                ),
            ),
            termsOfService = RequestLink(
                linkType = RequestLink.Type.Navigation,
                fullLink = "https://www.tumblr.com/policy/terms-of-service",
            ),
        )

        assertEquals(expected, linkMap)
    }

    // endregion Links

    // region User

    @Test
    internal fun testOfficial_user_getFollower() {
        val user = parseFile<User>("samples/officialSamples/user/getFollower.json")
        val expected = User(
            name = "david",
            url = "https://www.davidslog.com",
            updated = 1308781073,
            isUserFollowed = true,
        )
        assertEquals(expected, user)
    }

    @Test
    fun testOfficial_user_getUser() {
        val user = parseFile<User>("samples/officialSamples/user/getUser.json")
        val expected = User(
            totalFollowing = 263,
            defaultPostFormat = Post.PostFormat.HTML,
            name = "derekg",
            likes = 606,
            blogs = listOf(
                Blog(
                    name = "derekg",
                    title = "Derek Gottfrid",
                    url = "https://derekg.org/",
                    tweet = "auto",
                    primary = true,
                    followers = 33004929,
                ),
                Blog(
                    name = "ihatehipstrz",
                    title = "I Hate Hipstrz",
                ),
            ),
        )
        assertEquals(expected, user)
    }

    // endregion User

    // region Attribution

    @Test
    internal fun testOfficial_attributionTypeApp() {
        val attribution = parseFile<Attribution>("samples/officialSamples/attribution/attributionTypeApp.json")
        val expected = AppAttribution(
            url = "https://www.instagram.com/p/BVZyxTklQWX/",
            appName = "Instagram",
            displayText = "tibbythecorgi - Very Cute",
            logo = Media(
                url = "https://scontent.cdninstagram.com/path/to/logo.jpg",
                type = "image/jpeg",
                width = 64,
                height = 64,
            ),
        )
        assertEquals(expected, attribution)
    }

    @Test
    internal fun testOfficial_attributionTypeBlog() {
        val attribution = parseFile<Attribution>("samples/officialSamples/attribution/attributionTypeBlog.json")
        val expected = BlogAttribution(
            url = "https://randerson.tumblr.com",
            blog = Blog(),
        )
        assertEquals(expected, attribution)
    }

    @Test
    internal fun testOfficial_attributionTypeLink() {
        val attribution = parseFile<Attribution>("samples/officialSamples/attribution/attributionTypeLink.json")
        val expected = LinkAttribution(
            url = "http://shahkashani.com/",
        )
        assertEquals(expected, attribution)
    }

    @Test
    internal fun testOfficial_attributionTypePost() {
        val attribution = parseFile<Attribution>("samples/officialSamples/attribution/attributionTypePost.json")
        val expected = PostAttribution(
            url = "http://www.davidslog.com/153957802620/five-years-of-working-with-this-awesome-girl",
            post = Post(
                id = 1234567890,
            ),
            blog = Blog(
                uuid = "t:123456abcdf",
                name = "david",
                url = "https://davidslog.com/",
            ),

        )
        assertEquals(expected, attribution)
    }

    // endregion Attribution

    // region Content

    @Test
    internal fun testOfficial_contentBlockTypeAudio1() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeAudio1.json")
        val expected = AudioContent(
            provider = "tumblr",
            title = "Track Title",
            artist = "Track Artist",
            album = "Track Album",
            media = Media(
                type = "audio/mp3",
                url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp3",
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeAudio2() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeAudio2.json")
        val expected = AudioContent(
            provider = "soundcloud",
            title = "Mouth Sounds",
            artist = "neilcic",
            url = "https://soundcloud.com/neilcic/mouth-sounds",
            embedHtml = "<iframe width=\"100%\" height=\"450\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true\"></iframe>",
            embedUrl = "https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true",
            media = Media(
                type = "audio/mp3",
                url = "https://soundcloud.com/neilcic/mouth-sounds.mp3",
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeImage1() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeImage1.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                    width = 1280,
                    height = 1073,
                ),
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_540.jpg",
                    width = 540,
                    height = 400,
                ),
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_250.jpg",
                    width = 250,
                    height = 150,
                ),
            ),
            altText = "Sonic the Hedgehog and friends",
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeImage2() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeImage2.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/gif",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_250.gif",
                    width = 250,
                    height = 200,
                ),
            ),
            feedbackToken = "abcdef123456",
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeImage3() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeImage3.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                    width = 1280,
                    height = 1073,
                ),
            ),
            colors = Colors(
                0 to Color("a24615"),
                1 to Color("ff7c00"),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeImage_gifPoster() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeImage_gifPosters.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/gif",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.gif",
                    width = 500,
                    height = 400,
                    poster = Media(
                        type = "image/jpeg",
                        url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                        width = 500,
                        height = 400,
                    ),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeLink1() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeLink1.json")
        val expected = LinkContent(
            url = "https://www.nytimes.com/2017/06/15/us/politics/secrecy-surrounding-senate-health-bill-raises-alarms-in-both-parties.html",
            title = "Secrecy Surrounding Senate Health Bill Raises Alarms in Both Parties",
            description = "Senate leaders are writing legislation to repeal and replace the Affordable Care Act without a single hearing on the bill and without an open drafting session.",
            author = "Thomas Kaplan and Robert Pear",
            poster = listOf(
                Media(
                    url = "https://static01.nyt.com/images/2017/06/15/us/politics/15dchealth-2/15dchealth-2-facebookJumbo.jpg",
                    type = "image/jpeg",
                    width = 1050,
                    height = 549,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeLink2() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeLink2.json")
        val expected = LinkContent(
            url = "http://t.umblr.com/redirect?stuff-here",
            displayUrl = "https://www.nytimes.com/2017/06/15/us/politics/secrecy-surrounding-senate-health-bill-raises-alarms-in-both-parties.html",
            title = "Secrecy Surrounding Senate Health Bill Raises Alarms in Both Parties",
            description = "Senate leaders are writing legislation to repeal and replace the Affordable Care Act without a single hearing on the bill and without an open drafting session.",
            author = "Thomas Kaplan and Robert Pear",
            siteName = "nytimes.com",
            poster = listOf(
                Media(
                    url = "https://static01.nyt.com/images/2017/06/15/us/politics/15dchealth-2/15dchealth-2-facebookJumbo.jpg",
                    type = "image/jpeg",
                    width = 1050,
                    height = 549,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText.json")
        val expected = TextContent(
            text = "Hello world!",
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_formatting1() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText_formatting1.json")
        val expected = TextContent(
            text = "supercalifragilisticexpialidocious",
            formatting = listOf(
                BoldTextFormat(
                    start = 0,
                    end = 20,
                ),
                ItalicTextFormat(
                    start = 9,
                    end = 34,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_formatting2() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText_formatting2.json")
        val expected = TextContent(
            text = "some bold and italic text",
            formatting = listOf(
                BoldTextFormat(
                    start = 5,
                    end = 9,
                ),
                ItalicTextFormat(
                    start = 14,
                    end = 20,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_formatting3() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText_formatting3.json")
        val expected = TextContent(
            text = "Found this link for you",
            formatting = listOf(
                LinkTextFormat(
                    start = 6,
                    end = 10,
                    url = "https://www.nasa.gov",
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_formatting4() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText_formatting4.json")
        val expected = TextContent(
            text = "Shout out to @david",
            formatting = listOf(
                MentionTextFormat(
                    start = 13,
                    end = 19,
                    blog = Blog(
                        uuid = "t:123456abcdf",
                        name = "david",
                        url = "https://davidslog.com/",
                    ),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_formatting5() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText_formatting5.json")
        val expected = TextContent(
            text = "Celebrate Pride Month",
            formatting = listOf(
                ColorTextFormat(
                    start = 10,
                    end = 15,
                    hex = Color("#ff492f"),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeChat() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeText_subtypeChat.json")
        val expected = TextContent(
            text = "cyle: ello",
            subType = TextContent.SubType.Chat,
            formatting = listOf(
                BoldTextFormat(
                    start = 0,
                    end = 5,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeHeading1() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeHeading1.json",
        )
        val expected = TextContent(
            text = "New Post Forms Manifesto",
            subType = TextContent.SubType.Heading1,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeHeading2() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeHeading2.json",
        )
        val expected = TextContent(
            text = "what a great conversation",
            subType = TextContent.SubType.Heading2,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeIndented() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeIndented.json",
        )
        val expected = TextContent(
            text = "A few years ago, when I was living in the hous. ",
            subType = TextContent.SubType.Indented,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeOrderedList() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeOrderedList.json",
        )
        val expected = TextContent(
            text = "Sword",
            subType = TextContent.SubType.OrderedListItem,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeQuirky() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeQuirky.json",
        )
        val expected = TextContent(
            text = "Oh, worm?",
            subType = TextContent.SubType.Quirky,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeQuote() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeQuote.json",
        )
        val expected = TextContent(
            text = "Genius without education is like silver in the mine.",
            subType = TextContent.SubType.Quote,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeText_subtypeUnorderedList() {
        val content = parseFile<PostContent>(
            "samples/officialSamples/content/contentBlockTypeText_subtypeUnorderedList.json",
        )
        val expected = TextContent(
            text = "Death, which is uncountable on this list.",
            subType = TextContent.SubType.UnorderedListItem,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeVideo1() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeVideo1.json")
        val expected = VideoContent(
            media = Media(
                type = "video/mp4",
                url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp4",
                height = 640,
                width = 480,
                hd = false,
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400,
                ),
            ),
            filmStrip = MediaWrapper(
                listMedia = listOf(
                    Media(
                        type = "image/jpeg",
                        url = "https://66.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame1.jpg",
                        width = 200,
                        height = 125,
                    ),
                    Media(
                        type = "image/jpeg",
                        url = "https://66.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame2.jpg",
                        width = 200,
                        height = 125,
                    ),
                ),
            ),
            canAutoPlayOnCellular = true,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_contentBlockTypeVideo2() {
        val content = parseFile<PostContent>("samples/officialSamples/content/contentBlockTypeVideo2.json")
        val expected = VideoContent(
            provider = "youtube",
            url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            embedHtml = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" frameborder=\"0\" allowfullscreen></iframe>",
            embedUrl = "https://www.youtube.com/embed/dQw4w9WgXcQ",
            metadata = VideoMetadata(
                id = "dQw4w9WgXcQ",
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    // endregion Content

    // region Layout

    @Test
    internal fun testOfficial_layoutBlockTypeAsk() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeAsk.json")
        val expected = AskBlockLayout(
            blocks = listOf(0, 1),
            attribution = BlogAttribution(
                url = "https://cyle.tumblr.com",
                blog = Blog(),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeCondensed1() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeCondensed1.json")
        val expected = CondensedBlockLayout(
            truncateAfter = 1,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeCondensed2() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeCondensed2.json")
        val expected = CondensedBlockLayout(
            truncateAfter = 3,
            blocks = listOf(0, 1, 2, 3),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeRows1() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeRows1.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0, 1),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(2),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeRows2() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeRows2.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(1, 2),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(3),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(4, 5, 6),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(7),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeRows3() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeRows3.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(2, 0, 1),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeRows_displayModeCarousel() {
        val content = parseFile<BlockLayout>(
            "samples/officialSamples/layout/layoutBlockTypeRows_displayModeCarousel.json",
        )
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(1, 2),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(3),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(4, 5, 6),
                    mode = RowBlockLayout.Display.Mode.Carousel(),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(7),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_layoutBlockTypeVertical() {
        val content = parseFile<BlockLayout>("samples/officialSamples/layout/layoutBlockTypeVertical.json")
        val expected = VerticalBlockLayout()
        assertEquals(expected, content)
    }

    // endregion Layout

    // region Media

    @Test
    internal fun testOfficial_mediaObjects() {
        val content = parseFile<Media>("samples/officialSamples/media/mediaObjects.json")
        val expected = Media(
            url = "https://69.media.tumblr.com/path/to/image.jpg",
            type = "image/jpg",
            width = 540,
            height = 405,
        )
        assertEquals(expected, content)
    }

    // endregion Media

    // region Post

    @Test
    internal fun testOfficial_post_contentBlocks1() {
        val content = parseFile<Post>("samples/officialSamples/post/contentBlocks1.json")
        val expected = Post(
            id = 1234,
            blog = Blog(),
            content = emptyList(),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_contentBlocks2() {
        val content = parseFile<Post>("samples/officialSamples/post/contentBlocks2.json")
        val expected = Post(
            content = listOf(
                TextContent(
                    text = "Hello world!",
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_contentBlocks3() {
        val content = parseFile<Post>("samples/officialSamples/post/contentBlocks3.json")
        val expected = Post(
            content = listOf(
                TextContent(
                    text = "Hello world!",
                ),
                TextContent(
                    text = "This is a second paragraph below the first.",
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_contentBlocks_emptyContent_before() {
        val content = parseFile<Post>(
            "samples/officialSamples/post/contentBlockTypeText_leadingTrailingEmptyBlocks_before.json",
        )
        val expected = Post(
            content = listOf(
                TextContent(
                    text = "",
                ),
                TextContent(
                    text = "ello!",
                ),
                TextContent(
                    text = "",
                ),
                TextContent(
                    text = "my name is cyle!",
                ),
                TextContent(
                    text = "",
                ),
                TextContent(
                    text = "",
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_contentBlocks_emptyContent_after() {
        val content = parseFile<Post>(
            "samples/officialSamples/post/contentBlockTypeText_leadingTrailingEmptyBlocks_after.json",
        )
        val expected = Post(
            content = listOf(
                TextContent(
                    text = "ello!",
                ),
                TextContent(
                    text = "",
                ),
                TextContent(
                    text = "my name is cyle!",
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_postIdentification() {
        val content = parseFile<Post>("samples/officialSamples/post/postIdentification.json")
        val expected = Post(
            id = 1234567891234567,
            blog = Blog(),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_reblogTrail() {
        val content = parseFile<Post>("samples/officialSamples/post/reblogTrail.json")
        val expected = Post(
            trail = listOf(
                Trail(
                    post = Post(id = 1234),
                    blog = Blog(),
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the root Post",
                            ),
                        ),
                    ),
                    layout = emptyList(),
                ),
                Trail(
                    post = Post(id = 3456),
                    blog = Blog(),
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the parent Post",
                            ),
                            TextContent(
                                text = "this is another text block in the parent Post",
                            ),
                        ),
                    ),
                    layout = listOf(
                        RowBlockLayout(
                            rows = listOf(
                                listOf(1, 0),
                            ),
                        ),
                    ),
                ),
            ),
            content = listOf(
                TextContent(
                    text = "lol, this is the content i am adding in my reblog of the parent Post",
                ),
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_post_reblogTrail_brokenTrailItems() {
        val content = parseFile<Post>("samples/officialSamples/post/reblogTrail_brokenTrailItems.json")
        val expected = Post(
            trail = listOf(
                Trail(
                    brokenBlogName = "old-broken-blog",
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the root Post, which is broken",
                            ),
                        ),
                    ),
                    layout = emptyList(),
                ),
                Trail(
                    brokenBlogName = "another-broken-blog",
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the parent Post, which is also broken",
                            ),
                            TextContent(
                                text = "this is another text block in the broken parent Post",
                            ),
                        ),
                    ),
                    layout = emptyList(),
                ),
            ),
        )
        assertEquals(expected, content)
    }

    // endregion Post

    // region Row Block Display

    @Test
    internal fun testOfficial_rowBlockDisplay_carousel() {
        val content = parseFile<RowBlockLayout.Display>("samples/officialSamples/rowBlockDisplay/carousel.json")
        val expected = RowBlockLayout.Display(
            blocks = listOf(4, 5, 6),
            mode = RowBlockLayout.Display.Mode.Carousel(),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_rowBlockDisplay_weighted() {
        val content = parseFile<RowBlockLayout.Display>("samples/officialSamples/rowBlockDisplay/weighted.json")
        val expected = RowBlockLayout.Display(
            blocks = listOf(1, 2),
        )
        assertEquals(expected, content)
    }

    // endregion Row Block Display

    // region Text Format

    @Test
    internal fun testOfficial_textFormat_bold() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/bold.json")
        val expected = BoldTextFormat(
            start = 0,
            end = 20,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_color() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/color.json")
        val expected = ColorTextFormat(
            start = 10,
            end = 15,
            hex = Color("#ff492f"),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_italic() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/italic.json")
        val expected = ItalicTextFormat(
            start = 9,
            end = 34,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_link() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/link.json")
        val expected = LinkTextFormat(
            start = 6,
            end = 10,
            url = "https://www.nasa.gov",
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_mention() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/mention.json")
        val expected = MentionTextFormat(
            start = 13,
            end = 19,
            blog = Blog(
                uuid = "t:123456abcdf",
                name = "david",
                url = "https://davidslog.com/",
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_sizeBig() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/sizeBig.json")
        val expected = SizeTextFormat(
            start = 10,
            end = 15,
            size = SizeTextFormat.Option.Big,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_sizeSmall() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/sizeSmall.json")
        val expected = SizeTextFormat(
            start = 10,
            end = 15,
            size = SizeTextFormat.Option.Small,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficial_textFormat_strikethrough() {
        val content = parseFile<TextFormat>("samples/officialSamples/textFormat/strikethrough.json")
        val expected = StrikeThroughTextFormat(
            start = 4,
            end = 9,
        )
        assertEquals(expected, content)
    }

    // endregion Text Format

    // endregion Official Samples Test Cases

    // region Once Failed Test Cases

    // region Attribution

    @Test
    internal fun onceFailed_attribution_link_urlRedirect() {
        val blog = parseFile<Attribution>("samples/onceFailed/attribution/link_urlRedirect.json")
        val expected = LinkAttribution(
            url = "http://8675309.tumblr.com",
            urlRedirect = "https://t.umblr.com/redirect?z=8675309",
        )
        assertEquals(expected, blog)
    }

    // endregion Attribution

    // region Blog

    @Test
    internal fun onceFailed_blog_self() {
        val blog = parseFile<Blog>("samples/onceFailed/blog/self.json")
        val expected = Blog(
            admin = true,
            ask = true,
            askAnon = true,
            askPageTitle = "Ask me anything",
            canSendFanMail = true,
            canSubmit = true,
            canSubscribe = false,
            description = "Kotlr",
            drafts = 0,
            facebook = "N",
            facebookOpenGraphEnabled = "N",
            followed = false,
            followers = 0,
            isBlockedFromPrimary = false,
            isNsfw = false,
            messages = 2,
            name = "kotlr-development",
            posts = 47,
            primary = true,
            queue = 0,
            sharesLikes = false,
            submissionPageTitle = "Submit a post",
            submissionTerms = SubmissionTerms(
                acceptedTypes = listOf(
                    Post.Type.Text,
                    Post.Type.Photo,
                    Post.Type.Quote,
                    Post.Type.Link,
                    Post.Type.Video,
                ),
                tags = emptyList(),
                title = "Submit a post",
                guidelines = "",
            ),
            subscribed = false,
            title = "Kotlr",
            totalPosts = 0,
            tweet = "N",
            twitterEnabled = false,
            twitterSend = false,
            type = "public",
            updated = 1540056911,
            url = "https://kotlr-development.tumblr.com/",
            uuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            isOptOutAds = true,
        )
        assertEquals(expected, blog)
    }

    @Test
    internal fun onceFailed_blog_asksAllowMedia() {
        val blog = parseFile<Blog>("samples/onceFailed/blog/asksAllowMedia.json")
        val expected = Blog(
            asksAllowMedia = true,
        )
        assertEquals(expected, blog)
    }

    @Test
    internal fun onceFailed_blog_canShowBadges() {
        val blog = parseFile<Blog>("samples/onceFailed/blog/canShowBadges.json")
        val expected = Blog(
            canShowBadges = true,
        )
        assertEquals(expected, blog)
    }

    @Test
    internal fun onceFailed_blog_accessories() {
        val blog = parseFile<Blog>("samples/onceFailed/blog/accessories.json")
        val expected = Blog(
            tumbleMartAccessories = BlogAccessories(
                blueCheckmarkCount = 1,
            ),
        )
        assertEquals(expected, blog)
    }

    // endregion Blog

    // region Content

    @Test
    internal fun onceFailed_content_imageContent_caption() {
        val content = parseFile<PostContent>("samples/onceFailed/content/imageContent_caption.json")
        val expected = ImageContent(
            caption = "this is a caption",
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_imageContent_clickThrough() {
        val content = parseFile<PostContent>("samples/onceFailed/content/imageContent_clickThrough.json")
        val expected = ImageContent(
            clickThrough = ClickThrough(
                webUrl = "asdf",
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_imageContent_exif() {
        val content = parseFile<PostContent>("samples/onceFailed/content/imageContent_exif.json")
        val expected = ImageContent(
            exif = ExifData(
                time = 1598724932,
                focalLength = "4",
                focalLength35mmEquivalent = "4",
                aperture = "1.8",
                exposureTime = "0.03333333333333333",
                iso = 1000,
                cameraMake = "Apple",
                cameraModel = "iPhone 11 Pro",
                lens = "4mm",
                sensorWidthMM = "4",
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_listOfAttribution() {
        val content = parseFile<PostContent>("samples/onceFailed/content/listOfAttribution.json")
        val expected = ImageContent(
            attribution = AttributionWrapper(listAttribution = emptyList()),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_pollContent() {
        val content = parseFile<PostContent>("samples/onceFailed/content/pollContent.json")
        val expected = PollContent(
            clientId = "05898443-8e9b-4618-97ed-6e54b0443475",
            question = "BUG RACE",
            answers = listOf(
                PollAnswer(
                    answerText = "\uD83E\uDEB1",
                    clientId = "46d09e52-6213-411f-bf1b-e438f25baef4",
                ),
                PollAnswer(
                    answerText = "\uD83D\uDC0C",
                    clientId = "66c6650d-e9dc-482a-843f-869a9fb77a60",
                ),
                PollAnswer(
                    answerText = "\uD83D\uDC1B",
                    clientId = "27d238be-1544-4882-8bbe-59a4e839091f",
                ),
            ),
            settings = PollSettings(
                multipleChoice = false,
                closeStatus = "closed-after",
                expireAfter = 86400,
                source = "tumblr",
            ),
            createdAt = "2023-01-18 18:42:31 GMT",
            timestamp = 1674067351,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_textContent_indentLevel() {
        val content = parseFile<PostContent>("samples/onceFailed/content/textContent_indentLevel.json")
        val expected = TextContent(
            text = "Test",
            subType = TextContent.SubType.Indented,
            indentLevel = 1,
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_videoContent_embedIFrame() {
        val content = parseFile<PostContent>("samples/onceFailed/content/videoContent_embedIFrame.json")
        val expected = VideoContent(
            provider = "youtube",
            iframe = Media(
                url = "https://safe.txmblr.com/svc/embed/iframe/blogId/postId?w=540&h=304&media_id=HgbN8doxXxg#embed-ukIuGYR_Jcdm60j7Nb95dg",
                width = 540,
                height = 304,
            ),
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_videoContent_singleImageFilmstrip() {
        val content = parseFile<PostContent>("samples/onceFailed/content/videoContent_singleImageFilmstrip.json")
        val expected = VideoContent(
            provider = "tumblr",
            filmStrip = MediaWrapper(
                singleMedia = Media(
                    type = "image/jpeg",
                    url = "https://66.media.tumblr.com/previews/tumblr_ukIuGYR_Jcdm60j7Nb95dg_filmstrip.jpg",
                    width = 2000,
                    height = 112,
                ),
            ),
        )
        assertEquals(expected, content)
    }

    // endregion Content

    // region Layout

    @Test
    internal fun onceFailed_layout_rowLayout_truncateAfter() {
        val content = parseFile<BlockLayout>("samples/onceFailed/layout/rowLayout_truncateAfter.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(1),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(2),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(3),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(4),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(5),
                ),
                RowBlockLayout.Display(
                    blocks = listOf(6),
                ),
            ),
            truncateAfter = 5,
        )
        assertEquals(expected, content)
    }

    // endregion Layout

    // region Links

    @Test
    internal fun onceFailed_links_tumblelog() {
        val post = parseFile<RequestLink>("samples/onceFailed/links/links_tumblelog.json")
        val expected = RequestLink(
            fullLink = "asdf",
            queryParams = RequestQueryParameters(
                tumblelog = "asdf",
            ),
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_links_realExample() {
        val post = parseFile<RequestLink>("samples/onceFailed/links/realExample.json")
        val expected = RequestLink(
            fullLink = "/v2/user/following?offset=20",
            httpMethod = "GET",
            queryParams = RequestQueryParameters(
                offset = "20",
            ),
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_links_withType() {
        val post = parseFile<RequestLink>("samples/onceFailed/links/linksWithType.json")
        val expected = RequestLink(
            fullLink = "/v2/blog/asdfasdfasdfasdf/notifications?types=like&before=1622863424",
            httpMethod = "GET",
            queryParams = RequestQueryParameters(
                types = "like",
                before = "1622863424",
            ),
        )
        assertEquals(expected, post)
    }

    // endregion Links

    // region Media

    @Test
    internal fun onceFailed_media_mediaGif() {
        val media = parseFile<Media>("samples/onceFailed/media/mediaGif.json")
        val expected = Media(
            url = "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg_1280.gif",
            type = "image/gif",
            width = 1280,
            height = 985,
            poster = Media(
                url = "https://46.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg_1280.gif",
                type = "image/gif",
                width = 1280,
                height = 985,
            ),
        )
        assertEquals(expected, media)
    }

    @Test
    internal fun onceFailed_media_mediaKey() {
        val media = parseFile<Media>("samples/onceFailed/media/mediaKey.json")
        val expected = Media(
            mediaKey = "urlPart1:urlPart2",
            type = "image/png",
            width = 1579,
            height = 1200,
            url = "https://66.media.tumblr.com/urlPart1/urlPart2/s2048x3072/ukIuGYR_Jcdm60j7Nb95dg.png",
            hasOriginalDimensions = true,
        )
        assertEquals(expected, media)
    }

    @Test
    internal fun onceFailed_media_mediaMP4() {
        val media = parseFile<Media>("samples/onceFailed/media/mediaMP4.json")
        val expected = Media(
            type = "video/mp4",
            url = "http://69.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg.mp4",
            height = 640,
            width = 480,
            hd = false,
        )
        assertEquals(expected, media)
    }

    // endregion Media

    // region Note

    @Test
    internal fun onceFailed_note_noteLike() {
        val note = parseFile<NoteData>("samples/onceFailed/note/noteLike.json")
        val expected = LikeNote(
            timestamp = 1541225157,
            blogName = "kotlr-development",
            blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            blogUrl = "http://kotlr-development.tumblr.com/",
            blogFollowed = false,
            avatarShape = "circle",
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_note_notePostAttribution() {
        val note = parseFile<NoteData>("samples/onceFailed/note/notePostAttribution.json")
        val expected = AttributionNote(
            timestamp = 1541121830,
            blogName = "kotlr-development",
            blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            blogUrl = "https://kotlr-development.tumblr.com/",
            blogFollowed = false,
            avatarShape = "square",
            postId = "8675309",
            postAttributionType = "gif",
            postAttributionTypeName = "GIF",
            photoUrl = "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg_500.gif",
            photoWidth = 500,
            photoHeight = 225,
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_note_notePosted() {
        val note = parseFile<NoteData>("samples/onceFailed/note/notePosted.json")
        val expected = PostedNote(
            timestamp = 1541183549,
            blogName = "kotlr-development",
            blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            blogUrl = "http://kotlr-development.tumblr.com/",
            blogFollowed = true,
            avatarShape = "circle",
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_note_noteWithAddedText() {
        val note = parseFile<NoteData>("samples/onceFailed/note/noteWithAddedText.json")
        val expected = ReblogNote(
            timestamp = 1541254415,
            blogName = "kotlr-development",
            blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            blogUrl = "https://kotlr-development.tumblr.com/",
            blogFollowed = false,
            avatarShape = "square",
            addedText = "ukIuGYR_Jcdm60j7Nb95dg",
            postId = "8675309",
            reblogParentBlogName = "kotlr-development",
            canBlock = true,
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_note_noteWithFormatting() {
        val note = parseFile<NoteData>("samples/onceFailed/note/noteWithFormatting.json")
        val expected = ReplyNote(
            timestamp = 1541254204,
            blogName = "kotlr-development",
            blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            blogUrl = "http://kotlr-development.tumblr.com/",
            blogFollowed = false,
            avatarShape = "square",
            replyText = "ukIuGYR_Jcdm60j7Nb95dg",
            formatting = listOf(
                MentionTextFormat(
                    start = 0,
                    end = 13,
                    blog = Blog(
                        name = "kotlr-development",
                        url = "http://kotlr-development.tumblr.com/",
                        uuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
                    ),
                ),
            ),
            canBlock = true,
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_note_noteWithResponseText() {
        val note = parseFile<NoteData>("samples/onceFailed/note/noteWithResponseText.json")
        val expected = ReplyNote(
            timestamp = 1541238046,
            blogName = "kotlr-development",
            blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            blogUrl = "http://kotlr-development.tumblr.com/",
            blogFollowed = false,
            avatarShape = "square",
            replyText = "ukIuGYR_Jcdm60j7Nb95dg",
            formatting = emptyList(),
            canBlock = true,
        )
        assertEquals(expected, note)
    }

    // endregion Note

    // region Notification

    @Test
    internal fun onceFailed_notification_ask() {
        val note = parseFile<AskNotification>("samples/onceFailed/notification/ask.json")
        val expected = AskNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "1622863497",
            targetPostSummary = "asdf?",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            privateChannel = false,
            targetPostType = "note",
            postType = "answer",
            reblogKey = "asdf",
            isAnonymous = false,
            followed = false,
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_follower() {
        val note = parseFile<FollowerNotification>("samples/onceFailed/notification/follower.json")
        val expected = FollowerNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "",
            targetPostSummary = "",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            followed = false,
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_likeOriginal() {
        val note = parseFile<LikeNotification>("samples/onceFailed/notification/likeOriginal.json")
        val expected = LikeNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "1622863497",
            targetPostSummary = "asdf",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            followed = false,
            targetRootPostId = null,
            privateChannel = false,
            targetPostType = "regular",
            postType = "photo",
            reblogKey = "asdf",
            mediaUrl = "asdf",
            mediaUrlLarge = "asdf",
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_likeReblog() {
        val note = parseFile<LikeNotification>("samples/onceFailed/notification/likeReblog.json")
        val expected = LikeNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "1622863497",
            targetPostSummary = "asdf",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            followed = false,
            targetRootPostId = "1622863497",
            privateChannel = false,
            targetPostType = "regular",
            postType = "text",
            mediaUrl = null,
            mediaUrlLarge = null,
            reblogKey = "asdf",
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_milestonePost() {
        val note = parseFile<MilestonePostNotification>("samples/onceFailed/notification/milestonePost.json")
        val expected = MilestonePostNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "",
            targetPostSummary = "",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            milestone = 50,
            isAnonymous = false,
            editor = Post(
                content = listOf(
                    ImageContent(
                        media = listOf(
                            Media(
                                url = "https://assets.tumblr.com/images/milestones/posts/post_50.png",
                                type = "image/png",
                                width = 500,
                                height = 500,
                                hasOriginalDimensions = true,
                            ),
                        ),
                    ),
                    TextContent(
                        text = "50 posts!",
                    ),
                ),
                tags = listOf(
                    "50 posts",
                    "tumblr milestone",
                ),
            ),
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_reblogWithContent() {
        val note = parseFile<ReblogWithContentNotification>("samples/onceFailed/notification/reblogWithContent.json")
        val expected = ReblogWithContentNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "1622863497",
            targetPostSummary = "asdf",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            followed = false,
            targetRootPostId = null,
            privateChannel = false,
            targetPostType = "regular",
            postType = "photo",
            reblogKey = "asdf",
            mediaUrl = "asdf",
            mediaUrlLarge = "asdf",
            postId = "1622863497",
            addedText = "asdf",
            postTags = listOf(
                "testing",
            ),
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_reblogWithoutContent() {
        val note =
            parseFile<ReblogWithoutContentNotification>("samples/onceFailed/notification/reblogWithoutContent.json")
        val expected = ReblogWithoutContentNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "1622863497",
            targetPostSummary = "asdf",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            followed = false,
            targetRootPostId = null,
            privateChannel = false,
            targetPostType = "regular",
            postType = "photo",
            mediaUrl = "asdf",
            mediaUrlLarge = "asdf",
            reblogKey = "asdf",
            postId = "1622863497",
            postTags = listOf(
                "testing",
            ),
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_spamReported() {
        val note =
            parseFile<SpamReportedNotification>("samples/onceFailed/notification/spamReported.json")
        val expected = SpamReportedNotification(
            timestamp = 1622863497,
            before = 1622863497,
            targetPostId = "",
            targetPostSummary = "",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
        )
        assertEquals(expected, note)
    }

    @Test
    internal fun onceFailed_notification_userMention() {
        val note =
            parseFile<UserMentionNotification>("samples/onceFailed/notification/userMention.json")
        val expected = UserMentionNotification(
            type = "user_mention",
            timestamp = 1670294548,
            before = 1670294548,
            targetPostId = "",
            targetPostSummary = "",
            targetTumblelogName = "asdf",
            targetTumblelogUuid = "asdf",
            fromTumblelogName = "asdf",
            fromTumblelogUuid = "asdf",
            fromTumblelogIsAdult = false,
            followed = true,
            targetRootPostId = "",
            privateChannel = false,
            targetPostType = "regular",
            postType = "photo",
            mediaUrl = "asdf.jpg",
            mediaUrlLarge = "asdf.jpg",
            reblogKey = "asdf",
            postId = "",
            canReply = true,
        )
        assertEquals(expected, note)
    }

    // endregion Notification

    // region Posts

    @Test
    internal fun onceFailed_posts_blockPost_askingAvatar() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_askingAvatar.json")
        val expected = Post(
            askingAvatar = MediaWrapper(
                listMedia = listOf(
                    Media(
                        width = 512,
                        height = 512,
                        url = "https://assets.tumblr.com/images/default_avatar/cone_open_512.png",
                    ),
                    Media(
                        width = 128,
                        height = 128,
                        url = "https://assets.tumblr.com/images/default_avatar/cone_open_128.png",
                    ),
                    Media(
                        width = 96,
                        height = 96,
                        url = "https://assets.tumblr.com/images/default_avatar/cone_open_96.png",
                    ),
                    Media(
                        width = 64,
                        height = 64,
                        url = "https://assets.tumblr.com/images/default_avatar/cone_open_64.png",
                    ),
                ),
            ),
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_isBlurredImages() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_isBlurredImages.json")
        val expected = Post(
            isBlurredImages = true,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType.json")
        val expected = Post(
            originalType = Post.Type.Photo,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType_conversation() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType_conversation.json")
        val expected = Post(
            originalType = Post.Type.Conversation,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType_note() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType_note.json")
        val expected = Post(
            originalType = Post.Type.Note,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType_regular() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType_regular.json")
        val expected = Post(
            originalType = Post.Type.Regular,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPostWithAskFields() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPostWithAskFields.json")
        val expected = Post(
            askingName = "ukIuGYR_Jcdm60j7Nb95dg",
            askingUrl = "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_post_post_filtered() {
        val post = parseFile<Post>("samples/onceFailed/posts/post_filtered.json")
        val expected = Post(
            filteredReason = FilteredReason(tags = listOf("asdf")),
            postLinks = RequestLinks(
                revealFiltered = RequestLink(
                    linkType = RequestLink.Type.Web,
                    fullLink = "asdf",
                ),
            ),
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_post_postGenesisPostId() {
        val post = parseFile<Post>("samples/onceFailed/posts/postGenesisPostId.json")
        val expected = Post(
            genesisPostId = "1234784234687",
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_post_postIsPinned() {
        val post = parseFile<Post>("samples/onceFailed/posts/postIsPinned.json")
        val expected = Post(
            isPinned = true,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_post_recommendationReasonObject() {
        val post = parseFile<Post>("samples/onceFailed/posts/postRecommendationReasonObject.json")
        val expected = Post(
            recommendationReason = RecommendationReason(
                text = "Pinned Post",
                icon = "pin",
                loggingReason = "pin:t:kfDsDFSldgGjfsJFDLSL",
                color = Color("#00cf35"),
                links = emptyMap(),
            ),
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_postWithNoInteractability() {
        val post = parseFile<Post>("samples/onceFailed/posts/postWithNoInteractability.json")
        val expected = Post(
            canLike = true,
            canReblog = false,
            canSendInMessage = true,
            canReply = false,
            interactabilityReblog = Post.Interactability.NoOne,
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_postWithNotesData() {
        val post = parseFile<Post>("samples/onceFailed/posts/postWithNotesData.json")
        val expected = Post(
            notes = listOf(
                LikeNote(
                    timestamp = 1541225157,
                    blogName = "ukIuGYR_Jcdm60j7Nb95dg",
                    blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
                    blogUrl = "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
                    blogFollowed = false,
                    avatarShape = "circle",
                ),
            ),
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_postWithReblogData() {
        val post = parseFile<Post>("samples/onceFailed/posts/postWithReblogData.json")
        val expected = Post(
            rebloggedFromId = 8675309,
            rebloggedFromUrl = "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/8675309",
            rebloggedFromName = "ukIuGYR_Jcdm60j7Nb95dg",
            rebloggedFromTitle = "ukIuGYR_Jcdm60j7Nb95dg",
            rebloggedFromUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            rebloggedFromCanMessage = true,
            rebloggedFromFollowing = false,
            rebloggedRootId = 8675309,
            rebloggedRootUrl = "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/8675309",
            rebloggedRootName = "ukIuGYR_Jcdm60j7Nb95dg",
            rebloggedRootTitle = "ukIuGYR_Jcdm60j7Nb95dg",
            rebloggedRootUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
            rebloggedRootCanMessage = true,
            rebloggedRootFollowing = false,
        )
        assertEquals(expected, post)
    }

    // endregion Posts

    // region Text Format

    @Test
    internal fun onceFailed_textFormat_small() {
        val textFormat = parseFile<TextFormat>("samples/onceFailed/textFormat/small.json")
        val expected = SmallTextFormat(
            start = 0,
            end = 60,
        )
        assertEquals(expected, textFormat)
    }

    // endregion Text Format

    // region User

    @Test
    internal fun onceFailed_user_self() {
        val user = parseFile<User>("samples/onceFailed/user/self.json")
        val expected = User(
            name = "kotlr-development",
            likes = 202,
            totalFollowing = 28,
            defaultPostFormat = Post.PostFormat.HTML,
            blogs = listOf(
                Blog(
                    primary = true,
                ),
                Blog(
                    primary = false,
                ),
                Blog(
                    primary = false,
                ),
            ),
        )
        assertEquals(expected, user)
    }

    // endregion User

    // endregion Once Failed Test Cases

    // region Response Bodies Test Cases

    // region BlogAvatar

    @Test
    internal fun responseBodies_blockBlog_good() {
        val response = parseFile<ResponseBlogBlocks.Response>("samples/responseBodies/blockBlog/good.json")
        val expected = ResponseBlogBlocks.Response(
            meta = ResponseMetaInfo(
                status = 201,
                msg = "Created",
            ),
            response = ResponseBlogBlocks.Wrapper(
                body = ResponseBlogBlocks.Body(
                    alreadyBlocked = false,
                ),
            ),
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_blogAvatar_error() {
        val response = parseFile<ResponseBlogAvatar.Response>("samples/responseBodies/blogAvatar/error.json")
        val expected = ResponseBlogAvatar.Response(
            meta = ResponseMetaInfo(
                status = 404,
                msg = "Not Found",
            ),
            response = ResponseBlogAvatar.Wrapper(
                error = "[]",
            ),
            errors = listOf(
                TumblrError(
                    title = "Not Found",
                    code = 0,
                    detail = "Tumblr went thud. Try again.",
                ),
            ),
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_blogAvatar_good() {
        val response = parseFile<ResponseBlogAvatar.Response>("samples/responseBodies/blogAvatar/good.json")
        val expected = ResponseBlogAvatar.Response(
            meta = ResponseMetaInfo(
                status = 302,
                msg = "Found",
            ),
            response = ResponseBlogAvatar.Wrapper(
                body = ResponseBlogAvatar.Body(
                    url = "https://66.media.tumblr.com/avatar_19fe3de0d7fb_512.png",
                ),
            ),
        )
        assertEquals(expected, response)
    }

    // endregion BlogAvatar

    // region BlogLikes

    @Test
    internal fun responseBodies_blogLikes_good() {
        val response = parseFile<ResponseBlogLikes.Response>("samples/responseBodies/blogLikes/good.json")
        val expected = ResponseBlogLikes.Response(
            meta = ResponseMetaInfo(
                status = 200,
                msg = "OK",
            ),
            response = ResponseBlogLikes.Wrapper(
                body = ResponseBlogLikes.Body(
                    posts = listOf(Post()),
                    totalLiked = 202,
                    links = RequestLinks(
                        next = RequestLink(
                            fullLink = "/v2/blog/kotlr-development.tumblr.com/likes?limit=1&before=1539817301",
                            httpMethod = "GET",
                            queryParams = RequestQueryParameters(
                                limit = "1",
                                before = "1539817301",
                            ),
                        ),
                        prev = RequestLink(
                            fullLink = "/v2/blog/kotlr-development.tumblr.com/likes?limit=1&after=1539817301",
                            httpMethod = "GET",
                            queryParams = RequestQueryParameters(
                                limit = "1",
                                after = "1539817301",
                            ),
                        ),
                    ),
                ),
            ),
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_blogLikes_error() {
        val response = parseFile<ResponseBlogLikes.Response>("samples/responseBodies/blogLikes/unauthorized.json")
        val expected = ResponseBlogLikes.Response(
            meta = ResponseMetaInfo(
                status = 403,
                msg = "Forbidden",
            ),
            response = ResponseBlogLikes.Wrapper(
                error = "Not authorized.",
            ),
        )
        assertEquals(expected, response)
    }

    // endregion BlogAvatar

    // region UserDash

    @Test
    internal fun responseBodies_userDash_good() {
        val response = parseFile<ResponseUserDashboard.Response>("samples/responseBodies/userDash/good.json")
        val expected = ResponseUserDashboard.Response(
            meta = ResponseMetaInfo(
                status = 200,
                msg = "OK",
            ),
            response = ResponseUserDashboard.Wrapper(
                body = ResponseUserDashboard.Body(
                    posts = listOf(Post()),
                ),
            ),
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_userDash_error() {
        val response = parseFile<ResponseUserDashboard.Response>("samples/responseBodies/userDash/unauthorized.json")
        val expected = ResponseUserDashboard.Response(
            meta = ResponseMetaInfo(
                status = 401,
                msg = "Unauthorized",
            ),
            response = ResponseUserDashboard.Wrapper(
                error = "[]",
            ),
            errors = listOf(
                TumblrError(
                    title = "Unauthorized",
                    code = 1016,
                    detail = "Unable to authorize",
                ),
            ),
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_userDash_limitExceeded() {
        val response = parseFile<ResponseUserDashboard.Response>("samples/responseBodies/userDash/limitExceeded.json")
        val expected = ResponseUserDashboard.Response(
            meta = ResponseMetaInfo(
                status = 429,
                msg = "Limit Exceeded",
            ),
            response = ResponseUserDashboard.Wrapper(
                error = "[]",
            ),
            errors = listOf(
                TumblrError(
                    title = "Limit Exceeded",
                    code = 0,
                    detail = "Minor hiccup. Try again.",
                ),
            ),
        )
        assertEquals(expected, response)
    }

    // endregion UserDash

    // endregion Response Bodies Test Cases
}
