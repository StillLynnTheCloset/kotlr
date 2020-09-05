package com.highthunder.kotlr
// Disable line length checking because there are a lot of long string literals in here.
/* ktlint-disable max-line-length parameter-list-wrapping */

import com.highthunder.kotlr.json.wrapper.AttributionWrapper
import com.highthunder.kotlr.json.wrapper.ContentWrapper
import com.highthunder.kotlr.json.wrapper.MediaWrapper
import com.highthunder.kotlr.response.ResponseMetaInfo
import com.highthunder.kotlr.response.TumblrError
import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.types.AttributionNote
import com.highthunder.kotlr.types.BlockPost
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Color
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.LikeNote
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.PostedNote
import com.highthunder.kotlr.types.ReblogNote
import com.highthunder.kotlr.types.ReplyNote
import com.highthunder.kotlr.types.RequestLink
import com.highthunder.kotlr.types.RequestLinks
import com.highthunder.kotlr.types.RequestQueryParameters
import com.highthunder.kotlr.types.SubmissionTerms
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.User
import com.highthunder.kotlr.types.VideoMetadata
import com.highthunder.kotlr.types.YoutubeVideoMetadata
import com.highthunder.kotlr.types.content.AppAttribution
import com.highthunder.kotlr.types.content.AskBlockLayout
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.AudioContent
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.BlogAttribution
import com.highthunder.kotlr.types.content.BoldTextFormat
import com.highthunder.kotlr.types.content.ColorTextFormat
import com.highthunder.kotlr.types.content.CondensedBlockLayout
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.ItalicTextFormat
import com.highthunder.kotlr.types.content.LinkAttribution
import com.highthunder.kotlr.types.content.LinkContent
import com.highthunder.kotlr.types.content.LinkTextFormat
import com.highthunder.kotlr.types.content.MentionTextFormat
import com.highthunder.kotlr.types.content.PostAttribution
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.SizeTextFormat
import com.highthunder.kotlr.types.content.SmallTextFormat
import com.highthunder.kotlr.types.content.StrikeThroughTextFormat
import com.highthunder.kotlr.types.content.TextContent
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.content.VerticalBlockLayout
import com.highthunder.kotlr.types.content.VideoContent
import com.highthunder.kotlr.types.legacy.AnswerPost
import com.highthunder.kotlr.types.legacy.AudioPost
import com.highthunder.kotlr.types.legacy.ChatPost
import com.highthunder.kotlr.types.legacy.Dialogue
import com.highthunder.kotlr.types.legacy.ExifData
import com.highthunder.kotlr.types.legacy.LinkPost
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.PhotoPost
import com.highthunder.kotlr.types.legacy.PhotoSize
import com.highthunder.kotlr.types.legacy.QuotePost
import com.highthunder.kotlr.types.legacy.TextPost
import com.highthunder.kotlr.types.legacy.Video
import com.highthunder.kotlr.types.legacy.VideoPost
import com.squareup.moshi.JsonAdapter
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
            parseFile(fileName, shimo.adapter<T>().failOnUnknown())

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
        val post = parseFile<BlockPost>("samples/integrationTest/npfAnnouncementPost.json")
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

    // region Official LPF Samples Test Cases

    // region Blog

    @Test
    internal fun testOfficialLPF_blog_getBlog() {
        val blog = parseFile<Blog>("samples/officialLPFSamples/blog/getBlog.json")
        val expected = Blog(
            title = "David's Log",
            posts = 3456,
            name = "david",
            url = "https://david.tumblr.com/",
            updated = 1308953007,
            description = "<p><strong>Mr. Karp</strong> is tall and skinny, with unflinching blue eyes a mop of brown hair.\r\n He speaks incredibly fast and in complete paragraphs.</p>",
            ask = true,
            askAnon = false,
            likes = 12345
        )
        assertEquals(expected, blog)
    }

    @Test
    internal fun testOfficialLPF_blog_getFollowing() {
        val blog = parseFile<Blog>("samples/officialLPFSamples/blog/getFollowing.json")
        val expected = Blog(
            title = "David’s Log",
            name = "david",
            url = "https://www.davidslog.com",
            updated = 1308781073,
            description = "“Mr. Karp is tall and skinny, with unflinching blue eyes and a mop of brown hair. He speaks incredibly fast and in complete paragraphs.” – NY Observer"
        )
        assertEquals(expected, blog)
    }

    // endregion Blog

    // region Links

    @Test
    internal fun testOfficialLPF_links_links() {
        val linkMap = parseFile<RequestLinks>("samples/officialLPFSamples/links/links.json")
        val expected = RequestLinks(
            prev = RequestLink(
                linkType = RequestLink.Type.Action,
                httpMethod = "GET",
                fullLink = "https://api.tumblr.com/v2/endpoint",
                queryParams = RequestQueryParameters(
                    pageNumber = "1.0"
                )
            ),
            next = RequestLink(
                linkType = RequestLink.Type.Action,
                httpMethod = "GET",
                fullLink = "https://api.tumblr.com/v2/endpoint",
                queryParams = RequestQueryParameters(
                    pageNumber = "3.0"
                )
            ),
            termsOfService = RequestLink(
                linkType = RequestLink.Type.Navigation,
                fullLink = "https://www.tumblr.com/policy/terms-of-service"
            )
        )

        assertEquals(expected, linkMap)
    }

    // endregion Links

    // region Post

    @Test
    internal fun testOfficialLPF_post_answerPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/answerPost.json")
        val expected = AnswerPost(
            blogName = "david",
            id = 7504154594,
            idString = "7504154594",
            postUrl = "https://www.davidslog.com/7504154594",
            date = "2011-07-11 20:24:14 GMT",
            timestamp = 1310415854,
            format = Post.PostFormat.HTML,
            reblogKey = "HNvqLd5G",
            tags = emptyList(),
            askingName = "aperfectfacade",
            askingUrl = "https://aperfectfacade.tumblr.com/",
            question = "I thought Tumblr started in 2007, yet you have posts from 2006?",
            answer = "<p>Good catch! Tumblr <strong>launched</strong> in February 2007. We were testing it for a few months before then.</p>\n<p><strong>Tumblr Trivia:</strong> Before Tumblr, my blog (davidslog.com) was a manually edited, single page, HTML tumblelog.</p>"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_audioPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/audioPost.json")
        val expected = AudioPost(
            blogName = "derekg",
            id = 5578378101,
            idString = "5578378101",
            postUrl = "http://derekg.org/post/5578378101/otis-redding",
            date = "2011-05-17 16:21:05 GMT",
            timestamp = 1305649265,
            format = Post.PostFormat.HTML,
            reblogKey = "Wa65rR5l",
            tags = emptyList(),
            noteCount = 3,
            sourceUrl = "http://soundcloud.com/mariam-cabal/otis-redding",
            sourceTitle = "SoundCloud / Mariam Caballero",
            trackName = "Otis Redding - Cigarettes And Coffee",
            caption = "<p>Otis Redding never fails me. </p>",
            embed = "<iframe class=\"tumblr_audio_player tumblr_audio_player_5578378101\" src=\"http://derekg.org/post/5578378101/otis-redding/audio_player_iframe\" frameborder=\"0\" allowtransparency=\"true\" scrolling=\"no\" width=\"540\" height=\"85\"></iframe>",
            plays = 1576
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_chatPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/chatPost.json")
        val expected = ChatPost(
            blogName = "david",
            id = 5845345725,
            idString = "5845345725",
            postUrl = "https://www.davidslog.com/5845345725/if-youre-okay-with-it-destroying-tumblr",
            date = "2011-05-25 22:32:00 GMT",
            timestamp = 1306362720,
            format = Post.PostFormat.HTML,
            reblogKey = "wlxAsElf",
            tags = emptyList(),
            noteCount = 114,
            title = null,
            body = "David: https://staff.tumblr.com/post/5845153911 [draft] Topherchris: are you freaking serious\r\n David: If you're okay with it - I'd love to :)\r\nTopherchris: i'm okay with it, if you're okay with it destroying tumblr",
            dialogue = listOf(
                Dialogue(
                    name = "David",
                    label = "David:",
                    phrase = "https://staff.tumblr.com/post/5845153911 [draft]\r"
                ),
                Dialogue(
                    name = "Topherchris",
                    label = "Topherchris:",
                    phrase = "are you freaking serious\r"
                ),
                Dialogue(
                    name = "David",
                    label = "David:",
                    phrase = "If you're okay with it - I'd love to :)"
                ),
                Dialogue(
                    name = "Topherchris",
                    label = "Topherchris:",
                    phrase = "i'm okay with it, if you're okay with it destroying tumblr"
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_linkPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/linkPost.json")
        val expected = LinkPost(
            blogName = "travellingcameraclub",
            id = 688472164,
            idString = "688472164",
            postUrl = "https://travellingcameraclub.com/post/688472164",
            date = "2010-06-11 23:17:08 GMT",
            timestamp = 1276298228,
            format = Post.PostFormat.HTML,
            reblogKey = "RWhJJWia",
            tags = emptyList(),
            noteCount = 9,
            title = "Esther Aarts Illustration | News and Blog: Faq: How doyou make those marker doodles?",
            url = "https://blog.estadiezijn.nl/post/459075181/faq-how-do-you-make-those-marker-doodles",
            author = "Ester Aarts",
            excerpt = "How I make marker doodles",
            publisher = "blog.estadiezijn.nl",
            photos = listOf(
                Photo(
                    caption = "",
                    originalSize = PhotoSize(
                        width = 500,
                        height = 500,
                        url = "https://40.media.tumblr.com/1393850e5c331da2e3c9fb478a30310d/tumblr_inline_nm3lwntw8k1rplry2_500.jpg"
                    ),
                    altSizes = emptyList()
                )
            ),
            description = "<blockquote>\n<p>On my Ipad, of course!</p><p>Nothing better than the latest technology to get the job done. Look at all my apps!</p> <p><img height=\"555\" width=\"500\"src=\"http://farm5.static.flickr.com/4006/4445161463_31da0327c2_o.jpg\" alt=\"my iPad\"/></p><p>My favourite markers are an Edding 400, a Sharpie and a Copic Ciao. The white gouache is from Dr Martins and does a decent job covering up whatever needs to be covered up, and flows.</p></blockquote>"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_photoPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/photoPost.json")
        val expected = PhotoPost(
            blogName = "derekg",
            id = 7431599279,
            idString = "7431599279",
            postUrl = "https://derekg.org/post/7431599279",
            date = "2011-07-09 22:09:47 GMT",
            timestamp = 1310249387,
            format = Post.PostFormat.HTML,
            reblogKey = "749amggU",
            tags = emptyList(),
            noteCount = 18,
            caption = "<p>my arm is getting tired.</p>",
            photos = listOf(
                Photo(
                    caption = "",
                    altSizes = listOf(
                        PhotoSize(
                            width = 1280,
                            height = 722,
                            url = "https://derekg.org/photo/1280/7431599279/1/tumblr_lo36wbWqqq1qanqww"
                        ),
                        PhotoSize(
                            width = 500,
                            height = 282,
                            url = "https://30.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_500.jpg"
                        ),
                        PhotoSize(
                            width = 400,
                            height = 225,
                            url = "https://29.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_400.jpg"
                        ),
                        PhotoSize(
                            width = 250,
                            height = 141,
                            url = "https://26.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_250.jpg"
                        ),
                        PhotoSize(
                            width = 100,
                            height = 56,
                            url = "https://24.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_100.jpg"
                        ),
                        PhotoSize(
                            width = 75,
                            height = 75,
                            url = "https://30.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_75sq.jpg"
                        )
                    )
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_quotePost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/quotePost.json")
        val expected = QuotePost(
            blogName = "museumsandstuff",
            id = 4742980381,
            idString = "4742980381",
            postUrl = "https://museumsandstuff.tumblr.com/post/4742980381",
            date = "2011-04-19 08:52:34 GMT",
            timestamp = 1303203154,
            format = Post.PostFormat.HTML,
            reblogKey = "KLA85e6c",
            tags = emptyList(),
            noteCount = 23,
            sourceUrl = "http://museumtwo.blogspot.com/2011/04/guest-post-convivial-museum-photo-essay.html",
            sourceTitle = "museumtwo.blogspot.com",
            text = "Why do visitors still report discomfort, confusion, elitism, exclusion?",
            source = "<a href=\"http://museumtwo.blogspot.com/2011/04/guest-post-convivial-museum-photo-essay.html\"target=\"_blank\">Museum 2.0: Guest Post: The Convivial Museum Photo Essay</a> (via <a href=\"http://www.joshrobinson.org/\"target=\"_blank\">joshrobinsonblog</a>)"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_textPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/textPost.json")
        val expected = TextPost(
            blogName = "citriccomics",
            id = 3507845453,
            idString = "3507845453",
            postUrl = "https://citriccomics.tumblr.com/post/3507845453",
            date = "2011-02-25 20:27:00 GMT",
            timestamp = 1298665620,
            state = Post.State.Published,
            format = Post.PostFormat.HTML,
            reblogKey = "b0baQtsl",
            tags = listOf(
                "tumblrize",
                "milky dog",
                "mini comic"
            ),
            noteCount = 14,
            title = "Milky Dog",
            body = "<p><img src=\"https://media.tumblr.com/tumblr_lh6x8d7LBB1qa6gy3.jpg\"/><a href=\"http://citriccomics.com/blog/?p=487\" target=\"_blank\">TO READ THE REST CLICK HERE</a><br/>\n\nMilky Dog was inspired by something <a href=\"http://gunadie.com/naomi\" target=\"_blank\">Naomi Gee</a> wrote on twitter, I really liked the hash tag <a href=\"https://twitter.com/ search?q=%23MILKYDOG\" target=\"_blank\">#milkydog</a> and quickly came up with a little comic about it. You can (and should) follow Naomi on twitter <a href=\"https://twitter.com/ngun\" target=\"_blank\">@ngun</a> I'm on twitter as well <a href=\"https://twitter.com/weflewairplanes\"target=\"_blank\">@weflewairplanes</a> </p>\n\nAlso, if youâ€™re a Reddit user (or even if you're not) I submitted this there, if you could up vote it I'd be super grateful just <a href=\"http://tinyurl.com/5wj3tqz\" target=\"_blank\">CLICK HERE</a>"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun testOfficialLPF_post_videoPost() {
        val post = parseFile<Post>("samples/officialLPFSamples/post/videoPost.json")
        val expected = VideoPost(
            blogName = "john",
            id = 6522991678,
            idString = "6522991678",
            postUrl = "http://john.io/post/6522991678",
            date = "2011-06-14 15:51:21 GMT",
            timestamp = 1308066681,
            format = Post.PostFormat.HTML,
            reblogKey = "sWRdVJrI",
            tags = emptyList(),
            noteCount = 17,
            sourceUrl = "http://www.WatchMojo.com",
            sourceTitle = "WatchMojo.com",
            caption = "<p><a href=\"https://foreverneilyoung.tumblr.com/post/6522738445\" target=\"_blank\">foreverneilyoung</a>:</p>\n<blockquote>\n<p><a href=\"https://watchmojo.tumblr.com/post/6521201320\" target=\"_blank\">watchmojo</a>:</p>\n<blockquote>\n<p>Neil Young\u2019s live album \u201cA Treasure\u201d is available today. To celebrate, we take a look at the life and career of the Canadian singer-songwriter.</p>\n</blockquote>\n<p>Neil 101 for you new fans out there.</p>\n</blockquote>\n<p><strong>If you don't know/appreciate Neil Young's impressive body of work, this will help</strong></p>",
            player = listOf(
                Video(
                    width = 250,
                    embedCode = "<object width=\"248\" height=\"169\"><param name=\"movie\" value=\"http://www.youtube.com/v/4Q1aI7xPo0Y&rel=0&egm=0&showinfo=0&fs=1\"></param><param name=\"wmode\"value=\"transparent\"></param><param name=\"allowFullScreen\" value=\"true\"></param><embedsrc=\"http://www.youtube.com/v/4Q1aI7xPo0Y&rel=0&egm=0&showinfo=0&fs=1\" type=\"application/x-shockwave-flash\"width=\"248\" height=\"169\" allowFullScreen=\"true\"wmode=\"transparent\"></embed></object>"
                ),
                Video(
                    width = 400,
                    embedCode = "<object width=\"400\" height=\"251\"><param name=\"movie\" value=\"http://www.youtube.com/v/4Q1aI7xPo0Y&rel=0&egm=0&showinfo=0&fs=1\"></param><param name=\"wmode\" value=\"transparent\"></param><param name=\"allowFullScreen\" value=\"true\"></param><embed src=\"http://www.youtube.com/v/4Q1aI7xPo0Y&rel=0&egm=0&showinfo=0&fs=1\" type=\"application/x-shockwave-flash\" width=\"400\" height=\"251\"allowFullScreen=\"true\" wmode=\"transparent\"></embed></object>"
                ),
                Video(
                    width = 500,
                    embedCode = "<object width=\"500\" height=\"305\"><param name=\"movie\" value=\"http://www.youtube.com/v/4Q1aI7xPo0Y&rel=0&egm=0&showinfo=0&fs=1\"></param><param name=\"wmode\"value=\"transparent\"></param><param name=\"allowFullScreen\" value=\"true\"></param><embedsrc=\"http://www.youtube.com/v/4Q1aI7xPo0Y&rel=0&egm=0&showinfo=0&fs=1\"type=\"application/x-shockwave-flash\" width=\"500\"height=\"305\" allowFullScreen=\"true\"wmode=\"transparent\"></embed></object>"
                )
            )
        )
        assertEquals(expected, post)
    }

    // endregion Post

    // region User

    @Test
    internal fun testOfficialLPF_user_getFollower() {
        val user = parseFile<User>("samples/officialLPFSamples/user/getFollower.json")
        val expected = User(
            name = "david",
            url = "https://www.davidslog.com",
            updated = 1308781073,
            isUserFollowed = true
        )
        assertEquals(expected, user)
    }

    @Test
    fun testOfficialLPF_user_getUser() {
        val user = parseFile<User>("samples/officialLPFSamples/user/getUser.json")
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
                    followers = 33004929
                ),
                Blog(
                    name = "ihatehipstrz",
                    title = "I Hate Hipstrz"
                )
            )
        )
        assertEquals(expected, user)
    }

    // endregion User

    // endregion Official LPF Samples Test Cases

    // region Official NPF Samples Test Cases

    // region Attribution

    @Test
    internal fun testOfficialNPF_attributionTypeApp() {
        val attribution = parseFile<Attribution>("samples/officialNPFSamples/attribution/attributionTypeApp.json")
        val expected = AppAttribution(
            url = "https://www.instagram.com/p/BVZyxTklQWX/",
            appName = "Instagram",
            displayText = "tibbythecorgi - Very Cute",
            logo = Media(
                url = "https://scontent.cdninstagram.com/path/to/logo.jpg",
                type = "image/jpeg",
                width = 64,
                height = 64
            )
        )
        assertEquals(expected, attribution)
    }

    @Test
    internal fun testOfficialNPF_attributionTypeBlog() {
        val attribution = parseFile<Attribution>("samples/officialNPFSamples/attribution/attributionTypeBlog.json")
        val expected = BlogAttribution(
            url = "https://randerson.tumblr.com",
            blog = Blog()
        )
        assertEquals(expected, attribution)
    }

    @Test
    internal fun testOfficialNPF_attributionTypeLink() {
        val attribution = parseFile<Attribution>("samples/officialNPFSamples/attribution/attributionTypeLink.json")
        val expected = LinkAttribution(
            url = "http://shahkashani.com/"
        )
        assertEquals(expected, attribution)
    }

    @Test
    internal fun testOfficialNPF_attributionTypePost() {
        val attribution = parseFile<Attribution>("samples/officialNPFSamples/attribution/attributionTypePost.json")
        val expected = PostAttribution(
            url = "http://www.davidslog.com/153957802620/five-years-of-working-with-this-awesome-girl",
            post = BlockPost(
                id = 1234567890
            ),
            blog = Blog(
                uuid = "t:123456abcdf",
                name = "david",
                url = "https://davidslog.com/"
            )

        )
        assertEquals(expected, attribution)
    }

    // endregion Attribution

    // region Content

    @Test
    internal fun testOfficialNPF_contentBlockTypeAudio1() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeAudio1.json")
        val expected = AudioContent(
            provider = "tumblr",
            title = "Track Title",
            artist = "Track Artist",
            album = "Track Album",
            media = Media(
                type = "audio/mp3",
                url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp3"
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeAudio2() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeAudio2.json")
        val expected = AudioContent(
            provider = "soundcloud",
            title = "Mouth Sounds",
            artist = "neilcic",
            url = "https://soundcloud.com/neilcic/mouth-sounds",
            embedHtml = "<iframe width=\"100%\" height=\"450\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true\"></iframe>",
            embedUrl = "https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true",
            media = Media(
                type = "audio/mp3",
                url = "https://soundcloud.com/neilcic/mouth-sounds.mp3"
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeImage1() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeImage1.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                    width = 1280,
                    height = 1073
                ),
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_540.jpg",
                    width = 540,
                    height = 400
                ),
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_250.jpg",
                    width = 250,
                    height = 150
                )
            ),
            altText = "Sonic the Hedgehog and friends"
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeImage2() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeImage2.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/gif",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_250.gif",
                    width = 250,
                    height = 200
                )
            ),
            feedbackToken = "abcdef123456"
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeImage3() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeImage3.json")
        val expected = ImageContent(
            media = listOf(
                Media(
                    type = "image/jpeg",
                    url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                    width = 1280,
                    height = 1073
                )
            ),
            colors = Colors(
                0 to Color("a24615"),
                1 to Color("ff7c00")
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeImage_gifPoster() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeImage_gifPosters.json")
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
                        height = 400
                    )
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeLink1() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeLink1.json")
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
                    height = 549
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeLink2() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeLink2.json")
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
                    height = 549
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText.json")
        val expected = TextContent(
            text = "Hello world!"
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_formatting1() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_formatting1.json")
        val expected = TextContent(
            text = "supercalifragilisticexpialidocious",
            formatting = listOf(
                BoldTextFormat(
                    start = 0,
                    end = 20
                ),
                ItalicTextFormat(
                    start = 9,
                    end = 34
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_formatting2() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_formatting2.json")
        val expected = TextContent(
            text = "some bold and italic text",
            formatting = listOf(
                BoldTextFormat(
                    start = 5,
                    end = 9
                ),
                ItalicTextFormat(
                    start = 14,
                    end = 20
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_formatting3() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_formatting3.json")
        val expected = TextContent(
            text = "Found this link for you",
            formatting = listOf(
                LinkTextFormat(
                    start = 6,
                    end = 10,
                    url = "https://www.nasa.gov"
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_formatting4() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_formatting4.json")
        val expected = TextContent(
            text = "Shout out to @david",
            formatting = listOf(
                MentionTextFormat(
                    start = 13,
                    end = 19,
                    blog = Blog(
                        uuid = "t:123456abcdf",
                        name = "david",
                        url = "https://davidslog.com/"
                    )
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_formatting5() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_formatting5.json")
        val expected = TextContent(
            text = "Celebrate Pride Month",
            formatting = listOf(
                ColorTextFormat(
                    start = 10,
                    end = 15,
                    hex = Color("#ff492f")
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeChat() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeChat.json")
        val expected = TextContent(
            text = "cyle: ello",
            subType = TextContent.SubType.Chat,
            formatting = listOf(
                BoldTextFormat(
                    start = 0,
                    end = 5
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeHeading1() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeHeading1.json")
        val expected = TextContent(
            text = "New Post Forms Manifesto",
            subType = TextContent.SubType.Heading1
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeHeading2() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeHeading2.json")
        val expected = TextContent(
            text = "what a great conversation",
            subType = TextContent.SubType.Heading2
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeIndented() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeIndented.json")
        val expected = TextContent(
            text = "A few years ago, when I was living in the hous. ",
            subType = TextContent.SubType.Indented
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeOrderedList() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeOrderedList.json")
        val expected = TextContent(
            text = "Sword",
            subType = TextContent.SubType.OrderedListItem
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeQuirky() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeQuirky.json")
        val expected = TextContent(
            text = "Oh, worm?",
            subType = TextContent.SubType.Quirky
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeQuote() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeQuote.json")
        val expected = TextContent(
            text = "Genius without education is like silver in the mine.",
            subType = TextContent.SubType.Quote
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeText_subtypeUnorderedList() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeText_subtypeUnorderedList.json")
        val expected = TextContent(
            text = "Death, which is uncountable on this list.",
            subType = TextContent.SubType.UnorderedListItem
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeVideo1() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeVideo1.json")
        val expected = VideoContent(
            media = Media(
                type = "video/mp4",
                url = "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp4",
                height = 640,
                width = 480,
                hd = false
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400
                )
            ),
            filmStrip = MediaWrapper(
                listMedia = listOf(
                    Media(
                        type = "image/jpeg",
                        url = "https://66.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame1.jpg",
                        width = 200,
                        height = 125
                    ),
                    Media(
                        type = "image/jpeg",
                        url = "https://66.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame2.jpg",
                        width = 200,
                        height = 125
                    )
                )
            ),
            canAutoPlayOnCellular = true
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_contentBlockTypeVideo2() {
        val content = parseFile<PostContent>("samples/officialNPFSamples/content/contentBlockTypeVideo2.json")
        val expected = VideoContent(
            provider = "youtube",
            url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            embedHtml = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" frameborder=\"0\" allowfullscreen></iframe>",
            embedUrl = "https://www.youtube.com/embed/dQw4w9WgXcQ",
            metadata = VideoMetadata(
                id = "dQw4w9WgXcQ"
            ),
            poster = listOf(
                Media(
                    type = "image/jpeg",
                    url = "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    width = 500,
                    height = 400
                )
            )
        )
        assertEquals(expected, content)
    }

    // endregion Content

    // region Layout

    @Test
    internal fun testOfficialNPF_layoutBlockTypeAsk() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeAsk.json")
        val expected = AskBlockLayout(
            blocks = listOf(0, 1),
            attribution = BlogAttribution(
                url = "https://cyle.tumblr.com",
                blog = Blog()
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeCondensed1() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeCondensed1.json")
        val expected = CondensedBlockLayout(
            truncateAfter = 1
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeCondensed2() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeCondensed2.json")
        val expected = CondensedBlockLayout(
            truncateAfter = 3,
            blocks = listOf(0, 1, 2, 3)
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeRows1() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeRows1.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0, 1)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(2)
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeRows2() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeRows2.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(1, 2)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(3)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(4, 5, 6)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(7)
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeRows3() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeRows3.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(2, 0, 1)
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeRows_displayModeCarousel() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeRows_displayModeCarousel.json")
        val expected = RowBlockLayout(
            display = listOf(
                RowBlockLayout.Display(
                    blocks = listOf(0)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(1, 2)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(3)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(4, 5, 6),
                    mode = RowBlockLayout.Display.Mode.Carousel()
                ),
                RowBlockLayout.Display(
                    blocks = listOf(7)
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_layoutBlockTypeVertical() {
        val content = parseFile<BlockLayout>("samples/officialNPFSamples/layout/layoutBlockTypeVertical.json")
        val expected = VerticalBlockLayout()
        assertEquals(expected, content)
    }

    // endregion Layout

    // region Media

    @Test
    internal fun testOfficialNPF_mediaObjects() {
        val content = parseFile<Media>("samples/officialNPFSamples/media/mediaObjects.json")
        val expected = Media(
            url = "https://69.media.tumblr.com/path/to/image.jpg",
            type = "image/jpg",
            width = 540,
            height = 405
        )
        assertEquals(expected, content)
    }

    // endregion Media

    // region Post

    @Test
    internal fun testOfficialNPF_post_contentBlocks1() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/contentBlocks1.json")
        val expected = BlockPost(
            id = 1234,
            blog = Blog(),
            content = emptyList()
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_contentBlocks2() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/contentBlocks2.json")
        val expected = BlockPost(
            content = listOf(
                TextContent(
                    text = "Hello world!"
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_contentBlocks3() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/contentBlocks3.json")
        val expected = BlockPost(
            content = listOf(
                TextContent(
                    text = "Hello world!"
                ),
                TextContent(
                    text = "This is a second paragraph below the first."
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_contentBlocks_emptyContent_before() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/contentBlockTypeText_leadingTrailingEmptyBlocks_before.json")
        val expected = BlockPost(
            content = listOf(
                TextContent(
                    text = ""
                ),
                TextContent(
                    text = "ello!"
                ),
                TextContent(
                    text = ""
                ),
                TextContent(
                    text = "my name is cyle!"
                ),
                TextContent(
                    text = ""
                ),
                TextContent(
                    text = ""
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_contentBlocks_emptyContent_after() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/contentBlockTypeText_leadingTrailingEmptyBlocks_after.json")
        val expected = BlockPost(
            content = listOf(
                TextContent(
                    text = "ello!"
                ),
                TextContent(
                    text = ""
                ),
                TextContent(
                    text = "my name is cyle!"
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_postIdentification() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/postIdentification.json")
        val expected = BlockPost(
            id = 1234567891234567,
            blog = Blog()
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_reblogTrail() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/reblogTrail.json")
        val expected = BlockPost(
            trail = listOf(
                Trail(
                    post = BlockPost(id = 1234),
                    blog = Blog(),
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the root Post"
                            )
                        )
                    ),
                    layout = emptyList()
                ),
                Trail(
                    post = BlockPost(id = 3456),
                    blog = Blog(),
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the parent Post"
                            ),
                            TextContent(
                                text = "this is another text block in the parent Post"
                            )
                        )
                    ),
                    layout = listOf(
                        RowBlockLayout(
                            rows = listOf(
                                listOf(1, 0)
                            )
                        )
                    )
                )
            ),
            content = listOf(
                TextContent(
                    text = "lol, this is the content i am adding in my reblog of the parent Post"
                )
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_post_reblogTrail_brokenTrailItems() {
        val content = parseFile<Post>("samples/officialNPFSamples/post/reblogTrail_brokenTrailItems.json")
        val expected = BlockPost(
            trail = listOf(
                Trail(
                    brokenBlogName = "old-broken-blog",
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the root Post, which is broken"
                            )
                        )
                    ),
                    layout = emptyList()
                ),
                Trail(
                    brokenBlogName = "another-broken-blog",
                    content = ContentWrapper(
                        contentList = listOf(
                            TextContent(
                                text = "this is the parent Post, which is also broken"
                            ),
                            TextContent(
                                text = "this is another text block in the broken parent Post"
                            )
                        )
                    ),
                    layout = emptyList()
                )
            )
        )
        assertEquals(expected, content)
    }

    // endregion Post

    // region Row Block Display

    @Test
    internal fun testOfficialNPF_rowBlockDisplay_carousel() {
        val content = parseFile<RowBlockLayout.Display>("samples/officialNPFSamples/rowBlockDisplay/carousel.json")
        val expected = RowBlockLayout.Display(
            blocks = listOf(4, 5, 6),
            mode = RowBlockLayout.Display.Mode.Carousel()
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_rowBlockDisplay_weighted() {
        val content = parseFile<RowBlockLayout.Display>("samples/officialNPFSamples/rowBlockDisplay/weighted.json")
        val expected = RowBlockLayout.Display(
            blocks = listOf(1, 2)
        )
        assertEquals(expected, content)
    }

    // endregion Row Block Display

    // region Text Format

    @Test
    internal fun testOfficialNPF_textFormat_bold() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/bold.json")
        val expected = BoldTextFormat(
            start = 0,
            end = 20
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_color() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/color.json")
        val expected = ColorTextFormat(
            start = 10,
            end = 15,
            hex = Color("#ff492f")
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_italic() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/italic.json")
        val expected = ItalicTextFormat(
            start = 9,
            end = 34
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_link() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/link.json")
        val expected = LinkTextFormat(
            start = 6,
            end = 10,
            url = "https://www.nasa.gov"
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_mention() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/mention.json")
        val expected = MentionTextFormat(
            start = 13,
            end = 19,
            blog = Blog(
                uuid = "t:123456abcdf",
                name = "david",
                url = "https://davidslog.com/"
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_sizeBig() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/sizeBig.json")
        val expected = SizeTextFormat(
            start = 10,
            end = 15,
            size = SizeTextFormat.Option.Big
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_sizeSmall() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/sizeSmall.json")
        val expected = SizeTextFormat(
            start = 10,
            end = 15,
            size = SizeTextFormat.Option.Small
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun testOfficialNPF_textFormat_strikethrough() {
        val content = parseFile<TextFormat>("samples/officialNPFSamples/textFormat/strikethrough.json")
        val expected = StrikeThroughTextFormat(
            start = 4,
            end = 9
        )
        assertEquals(expected, content)
    }

    // endregion Text Format

    // endregion Official NPF Samples Test Cases

    // region Once Failed Test Cases

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
                accepted_types = listOf(
                    "text",
                    "photo",
                    "quote",
                    "link",
                    "video"
                ),
                tags = emptyList(),
                title = "Submit a post",
                guidelines = ""
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
            isOptOutAds = true
        )
        assertEquals(expected, blog)
    }

    @Test
    internal fun onceFailed_blog_asksAllowMedia() {
        val blog = parseFile<Blog>("samples/onceFailed/blog/asksAllowMedia.json")
        val expected = Blog(
            asksAllowMedia = true
        )
        assertEquals(expected, blog)
    }

    // endregion Blog

    // region Content

    @Test
    internal fun onceFailed_content_imageContent_exif() {
        val content = parseFile<PostContent>("samples/onceFailed/content/imageContent_exif.json")
        val expected = ImageContent(
            exif = ExifData(
                time = 1598724932,
                focalLength = "4.0",
                focalLength35mmEquivalent = "4.0",
                aperture = "1.8",
                exposureTime = "0.03333333333333333",
                iso = 1000,
                cameraMake = "Apple",
                cameraModel = "iPhone 11 Pro",
                lens = "4mm",
                sensorWidthMM = "4.0"
            )
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_listOfAttribution() {
        val content = parseFile<PostContent>("samples/onceFailed/content/listOfAttribution.json")
        val expected = ImageContent(
            attribution = AttributionWrapper(listAttribution = emptyList())
        )
        assertEquals(expected, content)
    }

    @Test
    internal fun onceFailed_content_textContent_indentLevel() {
        val content = parseFile<PostContent>("samples/onceFailed/content/textContent_indentLevel.json")
        val expected = TextContent(
            text = "Test",
            subType = TextContent.SubType.Indented,
            indentLevel = 1
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
                height = 304
            )
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
                    height = 112
                )
            )
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
                    blocks = listOf(0)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(1)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(2)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(3)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(4)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(5)
                ),
                RowBlockLayout.Display(
                    blocks = listOf(6)
                )
            ),
            truncateAfter = 5
        )
        assertEquals(expected, content)
    }

    // endregion Layout

    // region Legacy Post

    @Test
    internal fun onceFailed_legacyPost_answerPost() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/answerPost.json")
        val expected = AnswerPost(
            askingName = "Anonymous",
            askingUrl = null,
            question = "ukIuGYR_Jcdm60j7Nb95dg",
            answer = "<p>ukIuGYR_Jcdm60j7Nb95dg</p>"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_answerPost_abstract() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/answerPost_abstract.json")
        val expected = AnswerPost(
            askingName = "Anonymous",
            askingUrl = null,
            question = "ukIuGYR_Jcdm60j7Nb95dg",
            answer = "ukIuGYR_Jcdm60j7Nb95dg",
            answerAbstract = "ukIuGYR_Jcdm60j7Nb95dg"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_audioPost() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/audioPost.json")
        val expected = AudioPost(
            sourceUrl = "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/8675309",
            sourceTitle = "ukIuGYR_Jcdm60j7Nb95dg",
            artist = "ukIuGYR_Jcdm60j7Nb95dg",
            trackName = "ukIuGYR_Jcdm60j7Nb95dg",
            album_art = "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.png",
            caption = "ukIuGYR_Jcdm60j7Nb95dg",
            player = "ukIuGYR_Jcdm60j7Nb95dg",
            embed = "ukIuGYR_Jcdm60j7Nb95dg",
            plays = 1876,
            audioUrl = "https://a.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.mp3",
            audioSourceUrl = "https://a.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.mp3",
            audioType = "tumblr"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_audioPost_embed() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/audioPost_embed.json")
        val expected = AudioPost(
            embed = "ukIuGYR_Jcdm60j7Nb95dg"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_audioPost_external() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/audioPost_external.json")
        val expected = AudioPost(
            audioUrl = "https://bandcamp.com/stream_redirect?enc=mp3-ukIuGYR_Jcdm60j7Nb95dg",
            audioSourceUrl = "https://bandcamp.com/stream_redirect?enc=mp3-ukIuGYR_Jcdm60j7Nb95dg",
            external = true,
            audioType = "bandcamp"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_audioPost_provider() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/audioPost_provider.json")
        val expected = AudioPost(
            audioUrl = "https://open.spotify.com/track/ukIuGYR_Jcdm60j7Nb95dg",
            audioSourceUrl = "https://open.spotify.com/track/ukIuGYR_Jcdm60j7Nb95dg",
            providerUrl = "spotify:track:ukIuGYR_Jcdm60j7Nb95dg?si=ukIuGYR_Jcdm60j7Nb95dg",
            external = true,
            audioType = "spotify"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_audioPost_track() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/audioPost_track.json")
        val expected = AudioPost(
            track = "7"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_audioPost_trackOf() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/audioPost_trackOf.json")
        val expected = AudioPost(
            track = "12 of 13"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_chatPost() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/chatPost.json")
        val expected = ChatPost(
            sourceUrl = "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/8675309/ukIuGYR_Jcdm60j7Nb95dg",
            sourceTitle = "ukIuGYR_Jcdm60j7Nb95dg",
            title = null,
            body = "lots of html"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_linkPost() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/linkPost.json")
        val expected = LinkPost(
            sourceUrl = "url",
            sourceTitle = "text",
            title = null,
            body = "lots of html"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_linkPost_author() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/linkPost_author.json")
        val expected = LinkPost(
            sourceUrl = "url",
            sourceTitle = "text",
            title = "text",
            url = "url",
            author = "author",
            linkAuthor = "link author",
            excerpt = "text",
            publisher = "text",
            description = "text"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_linkPost_image() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/linkPost_image.json")
        val expected = LinkPost(
            linkImage = "url.jpg",
            linkImageDimensions = PhotoSize(
                width = 540,
                height = 440
            ),
            photos = listOf(
                Photo(
                    caption = "",
                    originalSize = PhotoSize(),
                    altSizes = emptyList()
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_photoPost_captionAbstract() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/photoPost_captionAbstract.json")
        val expected = PhotoPost(
            caption = "text",
            captionAbstract = "text"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_photoPost_imagePermalink() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/photoPost_imagePermalink.json")
        val expected = PhotoPost(
            sourceUrl = "url",
            sourceTitle = "text",
            caption = "text",
            imagePermalink = "url",
            photos = emptyList()
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_photoPost_layout() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/photoPost_layout.json")
        val expected = PhotoPost(
            photosetLayout = "2",
            photos = listOf(
                Photo(
                    caption = "",
                    originalSize = PhotoSize(),
                    altSizes = emptyList()
                ),
                Photo(
                    caption = "",
                    originalSize = PhotoSize(),
                    altSizes = emptyList()
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_photoPost_linkUrl() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/photoPost_linkUrl.json")
        val expected = PhotoPost(
            linkUrl = "url"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_photoPost_panorama() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/photoPost_panorama.json")
        val expected = PhotoPost(
            photos = listOf(
                Photo(
                    caption = "",
                    originalSize = PhotoSize(),
                    altSizes = emptyList(),
                    panoramaSize = PhotoSize(
                        url = "url.jpg",
                        width = 2288,
                        height = 500
                    )
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_photoPost_submitted() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/submittedPost.json")
        val expected = PhotoPost(
            isSubmission = true
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_textPost_abstract() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/textPost_abstract.json")
        val expected = TextPost(
            body = "text",
            abstract = "lots of html"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_videoPost_booleanEmbed() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/videoPost_booleanEmbed.json")
        val expected = VideoPost(
            player = listOf(
                Video(
                    width = 250,
                    embedCode = null
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_videoPost_floatDuration() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/videoPost_floatDuration.json")
        val expected = VideoPost(
            duration = 105.22999999999999
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_videoPost_html5() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/videoPost_html5.json")
        val expected = VideoPost(
            html5Capable = true
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_videoPost_permalink() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/videoPost_permalink.json")
        val expected = VideoPost(
            permalinkUrl = "url"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_legacyPost_videoPost_videoObject() {
        val post = parseFile<Post>("samples/onceFailed/legacyPost/videoPost_videoObject.json")
        val expected = VideoPost(
            videoData = VideoMetadata(
                youtube = YoutubeVideoMetadata(
                    videoId = "ukIuGYR_Jcdm60j7Nb95dg",
                    width = 540,
                    height = 304,
                )
            )
        )
        assertEquals(expected, post)
    }

    // endregion Legacy Post

    // region Links

    @Test
    internal fun onceFailed_links_realExample() {
        val post = parseFile<RequestLink>("samples/onceFailed/links/realExample.json")
        val expected = RequestLink(
            fullLink = "/v2/user/following?offset=20",
            httpMethod = "GET",
            queryParams = RequestQueryParameters(
                offset = "20"
            )
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
                height = 985
            )
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
            hasOriginalDimensions = true
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
            hd = false
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
            avatarShape = "circle"
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
            photoHeight = 225
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
            avatarShape = "circle"
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
            canBlock = true
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
                        uuid = "t:ukIuGYR_Jcdm60j7Nb95dg"
                    )
                )
            ),
            canBlock = true
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
            canBlock = true
        )
        assertEquals(expected, note)
    }

    // endregion Note

    // region Photo

    @Test
    internal fun onceFailed_photo_photoWithExif() {
        val photo = parseFile<Photo>("samples/onceFailed/photo/photoWithExif.json")
        val expected = Photo(
            caption = "",
            originalSize = PhotoSize(
                url = "https://66.media.tumblr.com/foto_1280.jpg",
                width = 1280,
                height = 1707
            ),
            altSizes = emptyList(),
            exif = ExifData(
                camera = "Google Pixel 5XL",
                iso = 94,
                aperture = "f/2",
                exposure = "1/30th",
                focalLength = "3mm"
            )
        )
        assertEquals(expected, photo)
    }

    // endregion Photo

    // region Posts

    @Test
    internal fun onceFailed_posts_blockPost_isBlurredImages() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_isBlurredImages.json")
        val expected = BlockPost(
            isBlurredImages = true
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType.json")
        val expected = BlockPost(
            originalType = Post.Type.Photo
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType_conversation() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType_conversation.json")
        val expected = BlockPost(
            originalType = Post.Type.Conversation
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType_note() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType_note.json")
        val expected = BlockPost(
            originalType = Post.Type.Note
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPost_originalType_regular() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPost_originalType_regular.json")
        val expected = BlockPost(
            originalType = Post.Type.Regular
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_blockPostWithAskFields() {
        val post = parseFile<Post>("samples/onceFailed/posts/blockPostWithAskFields.json")
        val expected = BlockPost(
            askingName = "ukIuGYR_Jcdm60j7Nb95dg",
            askingUrl = "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/"
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_markdownFormat() {
        val post = parseFile<Post>("samples/onceFailed/posts/markdownFormat.json")
        val expected = PhotoPost(
            id = 8675309,
            format = Post.PostFormat.Markdown
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_postWithNotesData() {
        val post = parseFile<Post>("samples/onceFailed/posts/postWithNotesData.json")
        val expected = QuotePost(
            notes = listOf(
                LikeNote(
                    timestamp = 1541225157,
                    blogName = "ukIuGYR_Jcdm60j7Nb95dg",
                    blogUuid = "t:ukIuGYR_Jcdm60j7Nb95dg",
                    blogUrl = "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
                    blogFollowed = false,
                    avatarShape = "circle"
                )
            )
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_postWithReblogData() {
        val post = parseFile<Post>("samples/onceFailed/posts/postWithReblogData.json")
        val expected = PhotoPost(
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
            rebloggedRootFollowing = false
        )
        assertEquals(expected, post)
    }

    @Test
    internal fun onceFailed_posts_textPost_isBlurredImages() {
        val post = parseFile<Post>("samples/onceFailed/posts/textPost_isBlurredImages.json")
        val expected = TextPost(
            isBlurredImages = true
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
            end = 60
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
                    primary = true
                ),
                Blog(
                    primary = false
                ),
                Blog(
                    primary = false
                )
            )
        )
        assertEquals(expected, user)
    }

    // endregion User

    // region Video

    @Test
    internal fun onceFailed_video_videoWithEmbed() {
        val video = parseFile<Video>("samples/onceFailed/video/videoWithEmbed.json")
        val expected = Video(
            width = 250,
            embedCode = "\n<video  id='embed-ukIuGYR_Jcdm60j7Nb95dg' class='crt-video crt-skin-default' width='250' height='250' poster='https://66.media.tumblr.com/tumblr_ukIuGYR_Jcdm60j7Nb95dg_smart1.jpg' preload='none' muted data-crt-video data-crt-options='{\"autoheight\":null,\"duration\":58,\"hdUrl\":false,\"filmstrip\":{\"url\":\"https://78.media.tumblr.com/previews/tumblr_ukIuGYR_Jcdm60j7Nb95dg_filmstrip.jpg\",\"width\":\"200\",\"height\":\"200\"}}' >\n    <source src=\"https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/video_file/t:ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg/480\" type=\"video/mp4\">\n</video>\n"
        )
        assertEquals(expected, video)
    }

    // endregion Video

    // endregion Once Failed Test Cases

    // region Response Bodies Test Cases

    // region BlogAvatar

    @Test
    internal fun responseBodies_blogAvatar_error() {
        val response = parseFile<ResponseBlogAvatar.Response>("samples/responseBodies/blogAvatar/error.json")
        val expected = ResponseBlogAvatar.Response(
            meta = ResponseMetaInfo(
                status = 404,
                msg = "Not Found"
            ),
            response = ResponseBlogAvatar.Wrapper(
                error = "[]"
            ),
            errors = listOf(
                TumblrError(
                    title = "Not Found",
                    code = 0,
                    detail = "Tumblr went thud. Try again."
                )
            )
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_blogAvatar_good() {
        val response = parseFile<ResponseBlogAvatar.Response>("samples/responseBodies/blogAvatar/good.json")
        val expected = ResponseBlogAvatar.Response(
            meta = ResponseMetaInfo(
                status = 302,
                msg = "Found"
            ),
            response = ResponseBlogAvatar.Wrapper(
                body = ResponseBlogAvatar.Body(
                    url = "https://66.media.tumblr.com/avatar_19fe3de0d7fb_512.png"
                )
            )
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
                msg = "OK"
            ),
            response = ResponseBlogLikes.Wrapper(
                body = ResponseBlogLikes.Body(
                    posts = listOf(BlockPost()),
                    totalLiked = 202,
                    links = RequestLinks(
                        next = RequestLink(
                            fullLink = "/v2/blog/kotlr-development.tumblr.com/likes?limit=1&before=1539817301",
                            httpMethod = "GET",
                            queryParams = RequestQueryParameters(
                                limit = "1",
                                before = "1539817301"
                            )
                        ),
                        prev = RequestLink(
                            fullLink = "/v2/blog/kotlr-development.tumblr.com/likes?limit=1&after=1539817301",
                            httpMethod = "GET",
                            queryParams = RequestQueryParameters(
                                limit = "1",
                                after = "1539817301"
                            )
                        )
                    )
                )
            )
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_blogLikes_error() {
        val response = parseFile<ResponseBlogLikes.Response>("samples/responseBodies/blogLikes/unauthorized.json")
        val expected = ResponseBlogLikes.Response(
            meta = ResponseMetaInfo(
                status = 403,
                msg = "Forbidden"
            ),
            response = ResponseBlogLikes.Wrapper(
                error = "Not authorized."
            )
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
                msg = "OK"
            ),
            response = ResponseUserDashboard.Wrapper(
                body = ResponseUserDashboard.Body(
                    posts = listOf(BlockPost())
                )
            )
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_userDash_error() {
        val response = parseFile<ResponseUserDashboard.Response>("samples/responseBodies/userDash/unauthorized.json")
        val expected = ResponseUserDashboard.Response(
            meta = ResponseMetaInfo(
                status = 401,
                msg = "Unauthorized"
            ),
            response = ResponseUserDashboard.Wrapper(
                error = "[]"
            ),
            errors = listOf(
                TumblrError(
                    title = "Unauthorized",
                    code = 1016,
                    detail = "Unable to authorize"
                )
            )
        )
        assertEquals(expected, response)
    }

    @Test
    internal fun responseBodies_userDash_limitExceeded() {
        val response = parseFile<ResponseUserDashboard.Response>("samples/responseBodies/userDash/limitExceeded.json")
        val expected = ResponseUserDashboard.Response(
            meta = ResponseMetaInfo(
                status = 429,
                msg = "Limit Exceeded"
            ),
            response = ResponseUserDashboard.Wrapper(
                error = "[]"
            ),
            errors = listOf(
                TumblrError(
                    title = "Limit Exceeded",
                    code = 0,
                    detail = "Minor hiccup. Try again."
                )
            )
        )
        assertEquals(expected, response)
    }

    // endregion UserDash

    // endregion Response Bodies Test Cases
}
