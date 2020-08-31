package com.highthunder.kotlr

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.RequestLink
import com.highthunder.kotlr.types.RequestLinks
import com.highthunder.kotlr.types.User
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.JsonAdapter
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
            assertEquals(allFileNames, parsedFileNames)
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

    // region Official LPF Samples Test Cases

    @Test
    internal fun testOfficialLPF_blog() {
        parseAllFilesInDirectory<Blog>("samples/officialLPFSamples/blog")
    }

    @Test
    internal fun testOfficialLPF_links() {
        parseAllFilesInDirectory<RequestLinks>("samples/officialLPFSamples/links")
    }

    @Test
    internal fun testOfficialLPF_post() {
        parseAllFilesInDirectory<Post>("samples/officialLPFSamples/post")
    }

    @Test
    internal fun testOfficialLPF_user() {
        parseAllFilesInDirectory<User>("samples/officialLPFSamples/user")
    }

    // endregion Official LPF Samples Test Cases

    // region Official NPF Samples Test Cases

    @Test
    internal fun testNPFSampleAttributions() {
        parseAllFilesInDirectory<Attribution>("samples/officialNPFSamples/attribution")
    }

    @Test
    internal fun testNPFSampleContents() {
        parseAllFilesInDirectory<PostContent>("samples/officialNPFSamples/content")
    }

    @Test
    internal fun testNPFSampleLayouts() {
        parseAllFilesInDirectory<BlockLayout>("samples/officialNPFSamples/layout")
    }

    @Test
    internal fun testNPFSampleMedia() {
        parseAllFilesInDirectory<Media>("samples/officialNPFSamples/media")
    }

    @Test
    internal fun testNPFSamplePosts() {
        parseAllFilesInDirectory<Post>("samples/officialNPFSamples/post")
    }

    @Test
    internal fun testNPFSampleRowBlockDisplay() {
        parseAllFilesInDirectory<RowBlockLayout.Display>("samples/officialNPFSamples/rowBlockDisplay")
    }

    @Test
    internal fun testNPFSampleTextFormat() {
        parseAllFilesInDirectory<TextFormat>("samples/officialNPFSamples/textFormat")
    }

    // endregion Official NPF Samples Test Cases

    // region Once Failed Test Cases

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
    internal fun testBadLegacyPosts() {
        parseAllFilesInDirectory<Post>("samples/onceFailed/legacyPost")
    }

    // region Links

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
    internal fun testBadPhoto() {
        parseAllFilesInDirectory<Photo>("samples/onceFailed/photo")
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

    @Test
    internal fun testBadVideo() {
        parseAllFilesInDirectory<Video>("samples/onceFailed/video")
    }

    // endregion Once Failed Test Cases

    // region Response Bodies Test Cases

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
