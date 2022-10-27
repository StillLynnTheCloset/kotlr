package com.stilllynnthecloset.kotlr

import com.squareup.moshi.JsonAdapter
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogAvatar
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogLikes
import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard
import com.stilllynnthecloset.kotlr.types.Blog
import com.stilllynnthecloset.kotlr.types.Colors
import com.stilllynnthecloset.kotlr.types.Media
import com.stilllynnthecloset.kotlr.types.NoteData
import com.stilllynnthecloset.kotlr.types.Notification
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.RequestLink
import com.stilllynnthecloset.kotlr.types.RequestLinks
import com.stilllynnthecloset.kotlr.types.User
import com.stilllynnthecloset.kotlr.types.content.Attribution
import com.stilllynnthecloset.kotlr.types.content.BlockLayout
import com.stilllynnthecloset.kotlr.types.content.PostContent
import com.stilllynnthecloset.kotlr.types.content.RowBlockLayout
import com.stilllynnthecloset.kotlr.types.content.TextFormat
import okio.buffer
import okio.source
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

internal class SampleFilesSimpleParseTest {

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
            println("Expecting to parse ${allFileNames.size} files")
        }

        @AfterClass
        @JvmStatic
        internal fun afterClass() {
            // Make sure that we tested every file.
            println("Parsed ${parsedFileNames.size} out of ${allFileNames.size} files")
            allFileNames.filter { it !in parsedFileNames }.sorted().forEach {
                println("Did not test file $it")
            }
            assertEquals(allFileNames.sorted(), parsedFileNames.sorted())
        }

        private inline fun <reified T> parseAllFilesInDirectory(directoryName: String) {
            parseAllFilesInDirectory(directoryName, moshi.adapter<T>().failOnUnknown())
        }

        private fun <T> parseAllFilesInDirectory(directoryName: String, adapter: JsonAdapter<T>) {
            val strictAdapter = adapter.failOnUnknown()
            val directory = File(directoryName)
            if (!directory.exists() || !directory.isDirectory) {
                throw IllegalArgumentException("directoryName `$directoryName` must be the name of a directory")
            }
            directory.listFiles()?.forEach { file ->
                val bufferedSource = file.source().buffer()
                val parsedValue = strictAdapter.fromJson(bufferedSource)
                assertNotNull(parsedValue)
                parsedFileNames.add(file.path)
            }
        }
    }

    // region Integration Test Cases

    @Test
    internal fun testIntegration_posts() {
        parseAllFilesInDirectory<Post>("samples/integrationTest")
    }

    // endregion Integration Tests

    // region Manufactured Test Cases

    @Test
    internal fun testManufacturedSamples_colors() {
        parseAllFilesInDirectory<Colors>("samples/manufactured/colors")
    }

    @Test
    internal fun testManufacturedSamples_media() {
        parseAllFilesInDirectory<Media>("samples/manufactured/media")
    }

    // endregion Manufactured Tests

    // region Official Samples Test Cases

    @Test
    internal fun testOfficial_blog() {
        parseAllFilesInDirectory<Blog>("samples/officialSamples/blog")
    }

    @Test
    internal fun testOfficial_links() {
        parseAllFilesInDirectory<RequestLinks>("samples/officialSamples/links")
    }

    @Test
    internal fun testOfficial_user() {
        parseAllFilesInDirectory<User>("samples/officialSamples/user")
    }

    @Test
    internal fun testNPFSampleAttributions() {
        parseAllFilesInDirectory<Attribution>("samples/officialSamples/attribution")
    }

    @Test
    internal fun testNPFSampleContents() {
        parseAllFilesInDirectory<PostContent>("samples/officialSamples/content")
    }

    @Test
    internal fun testNPFSampleLayouts() {
        parseAllFilesInDirectory<BlockLayout>("samples/officialSamples/layout")
    }

    @Test
    internal fun testNPFSampleMedia() {
        parseAllFilesInDirectory<Media>("samples/officialSamples/media")
    }

    @Test
    internal fun testNPFSamplePosts() {
        parseAllFilesInDirectory<Post>("samples/officialSamples/post")
    }

    @Test
    internal fun testNPFSampleRowBlockDisplay() {
        parseAllFilesInDirectory<RowBlockLayout.Display>("samples/officialSamples/rowBlockDisplay")
    }

    @Test
    internal fun testNPFSampleTextFormat() {
        parseAllFilesInDirectory<TextFormat>("samples/officialSamples/textFormat")
    }

    // endregion Official Samples Test Cases

    // region Once Failed Test Cases

    @Test
    internal fun testBadAttributions() {
        parseAllFilesInDirectory<Attribution>("samples/onceFailed/attribution")
    }

    @Test
    internal fun testBadBlogs() {
        parseAllFilesInDirectory<Blog>("samples/onceFailed/blog")
    }

    @Test
    internal fun testBadContents() {
        parseAllFilesInDirectory<PostContent>("samples/onceFailed/content")
    }

    @Test
    internal fun testBadLayouts() {
        parseAllFilesInDirectory<BlockLayout>("samples/onceFailed/layout")
    }

    @Test
    internal fun testBadLinks() {
        parseAllFilesInDirectory<RequestLink>("samples/onceFailed/links")
    }

    @Test
    internal fun testBadMedia() {
        parseAllFilesInDirectory<Media>("samples/onceFailed/media")
    }

    @Test
    internal fun testBadNotes() {
        parseAllFilesInDirectory<NoteData>("samples/onceFailed/note")
    }

    @Test
    internal fun testBadNotifications() {
        parseAllFilesInDirectory<Notification>("samples/onceFailed/notification")
    }

    @Test
    internal fun testBadPosts() {
        parseAllFilesInDirectory<Post>("samples/onceFailed/posts")
    }

    @Test
    internal fun testBadTextFormat() {
        parseAllFilesInDirectory<TextFormat>("samples/onceFailed/textFormat")
    }

    @Test
    internal fun testBadUsers() {
        parseAllFilesInDirectory<User>("samples/onceFailed/user")
    }

    // endregion Once Failed Test Cases

    // region Response Bodies Test Cases

    @Test
    internal fun testResponseSamples_blockBlog() {
        parseAllFilesInDirectory<ResponseBlogBlocks.Response>("samples/responseBodies/blockBlog")
    }

    @Test
    internal fun testResponseSamples_blogAvatar() {
        parseAllFilesInDirectory<ResponseBlogAvatar.Response>("samples/responseBodies/blogAvatar")
    }

    @Test
    internal fun testResponseSamples_blogLikes() {
        parseAllFilesInDirectory<ResponseBlogLikes.Response>("samples/responseBodies/blogLikes")
    }

    @Test
    internal fun testResponseSamples_userDash() {
        parseAllFilesInDirectory<ResponseUserDashboard.Response>("samples/responseBodies/userDash")
    }

    // endregion Response Bodies Test Cases
}
