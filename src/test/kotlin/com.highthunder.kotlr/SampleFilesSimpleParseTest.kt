package com.highthunder.kotlr

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.User
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.Video
import okio.buffer
import okio.source
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

class SampleFilesSimpleParseTest {

    companion object {
        private var totalFilesInSamples = 0
        private var filesParsedInDirectories = 0

        private fun countFilesInDirRecursive(directory: File): Int {
            var count = 0
            if (!directory.exists() || !directory.isDirectory) {
                throw IllegalArgumentException("directory must be a directory")
            }
            directory.listFiles()?.forEach { file ->
                if (file.isDirectory) {
                    count += countFilesInDirRecursive(file)
                } else {
                    count++
                }
            }
            return count
        }

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            filesParsedInDirectories = 0
            totalFilesInSamples = countFilesInDirRecursive(File("samples"))
            println("Expecting to test $totalFilesInSamples files")
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            // Make sure that we tested every file.
            assertEquals(totalFilesInSamples, filesParsedInDirectories)
        }

        private inline fun <reified T> parseAllFilesInDirectory(directoryName: String) {
            val directory = File(directoryName)
            if (!directory.exists() || !directory.isDirectory) {
                throw IllegalArgumentException("directoryName must be the name of a directory")
            }
            directory.listFiles()?.forEach { file ->
                val bufferedSource = file.source().buffer()
                val parsedValue = moshi.adapter<T>().failOnUnknown().fromJson(bufferedSource)
                assertNotNull(parsedValue)
                println(parsedValue)
                filesParsedInDirectories++
            }
            println("$filesParsedInDirectories parsed in directories so far")
        }
    }


    // region Integration Test Cases

    @Test
    fun testIntegration_posts() {
        parseAllFilesInDirectory<Post>("samples/integrationTest")
    }

    // endregion Integration Tests

    // region Manufactured Test Cases

    @Test
    fun testManufacturedSamples_colors() {
        parseAllFilesInDirectory<Colors>("samples/manufactured/colors")
    }

    @Test
    fun testManufacturedSamples_media() {
        parseAllFilesInDirectory<Media>("samples/manufactured/media")
    }

    // endregion Manufactured Tests

    // region Official NPF Samples Test Cases

    @Test
    fun testNPFSampleAttributions() {
        parseAllFilesInDirectory<Attribution>("samples/officialNPFSamples/attribution")
    }

    @Test
    fun testNPFSampleContents() {
        parseAllFilesInDirectory<PostContent>("samples/officialNPFSamples/content")
    }

    @Test
    fun testNPFSampleLayouts() {
        parseAllFilesInDirectory<BlockLayout>("samples/officialNPFSamples/layout")
    }

    @Test
    fun testNPFSampleMedia() {
        parseAllFilesInDirectory<Media>("samples/officialNPFSamples/media")
    }

    @Test
    fun testNPFSamplePosts() {
        parseAllFilesInDirectory<Post>("samples/officialNPFSamples/post")
    }

    @Test
    fun testNPFSampleRowBlockDisplay() {
        parseAllFilesInDirectory<RowBlockLayout.Display>("samples/officialNPFSamples/rowBlockDisplay")
    }

    @Test
    fun testNPFSampleTextFormat() {
        parseAllFilesInDirectory<TextFormat>("samples/officialNPFSamples/textFormat")
    }

    // endregion Official NPF Samples Test Cases

    // region Once Failed Test Cases

    @Test
    fun testBadBlogs() {
        parseAllFilesInDirectory<Blog>("samples/onceFailed/blog")
    }

    @Test
    fun testBadContents() {
        parseAllFilesInDirectory<PostContent>("samples/onceFailed/content")
    }

    @Test
    fun testBadLegacyPosts() {
        parseAllFilesInDirectory<Post>("samples/onceFailed/legacyPost")
    }

    @Test
    fun testBadMedia() {
        parseAllFilesInDirectory<Media>("samples/onceFailed/media")
    }

    @Test
    fun testBadNotes() {
        parseAllFilesInDirectory<NoteData>("samples/onceFailed/note")
    }

    @Test
    fun testBadPhoto() {
        parseAllFilesInDirectory<Photo>("samples/onceFailed/photo")
    }

    @Test
    fun testBadPosts() {
        parseAllFilesInDirectory<Post>("samples/onceFailed/posts")
    }

    @Test
    fun testBadUsers() {
        parseAllFilesInDirectory<User>("samples/onceFailed/user")
    }

    @Test
    fun testBadVideo() {
        parseAllFilesInDirectory<Video>("samples/onceFailed/video")
    }

    // endregion Once Failed Test Cases

    // region Response Bodies Test Cases

    @Test
    fun testResponseSamples_blogAvatar() {
        parseAllFilesInDirectory<ResponseBlogAvatar.Response>("samples/responseBodies/blogAvatar")
    }

    @Test
    fun testResponseSamples_blogLikes() {
        parseAllFilesInDirectory<ResponseBlogLikes.Response>("samples/responseBodies/blogLikes")
    }

    @Test
    fun testResponseSamples_userDash() {
        parseAllFilesInDirectory<ResponseUserDashboard.Response>("samples/responseBodies/userDash")
    }

    // endregion Response Bodies Test Cases
}
