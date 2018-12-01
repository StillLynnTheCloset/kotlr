package com.highthunder.kotlr

import com.highthunder.kotlr.json.superwrapper.PostAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.PostAmalgamation
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.User
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.Video
import com.squareup.moshi.JsonAdapter
import org.junit.Assert
import org.junit.Test

/**
 * TumblrTest - A bunch of simple json parsing test cases.
 *
 * TODO: Flesh out the test cases, actually check that inner objects were parsed correctly.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class TumblrTest {

    private val a = PostAmalgamationAdapter()

    // region Legacy Posts Tests

    @Test
    fun parseLegacyAnswerTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.answerPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAnswerAbstractTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.answerPostWithAbstract)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.audioPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioTrackTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.audioPostWithTrack)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioTrackOfTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.audioPostWithTrackOf)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioProviderTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.audioPostWithProvider)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyAudioExternalTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.audioPostWithExternal)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyChatTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.chatPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyChat2Test() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.chat2Post)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyLinkTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.linkPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyLinkImageTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.linkPostWithImage)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyLinkAuthorTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.linkPostWithAuthor)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.photoPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoPanoramaTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.photoPostWithPanorama)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoAbstractTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.photoPostWithCaptionAbstract)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoSubmissionTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.submission)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoLayoutTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.photoPostWithLayout)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyPhotoLinkUrlTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.photoPostWithLinkUrl)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyQuoteTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.quotePost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyTextTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.textPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyTextAbstractTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.textPostWithAbstract)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoPostTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.videoPost)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoVideoTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.videoPostWithVideoObject)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoPermaLinkTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.videoPostWithPermaLink)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoFloatTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.videoPostWithFloatDuration)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoBooleanEmbedTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.videoPostWithBooleanEmbed)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parsePostWithNotesTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.postWithNotesData)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parsePostWithReblogTest() {
        val adapter = moshi.adapter(PostAmalgamation::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<PostAmalgamation>)

        val post: PostAmalgamation? = adapter.fromJson(Sample.postWithReblogData)
        Assert.assertNotNull(post)
        val parsed = a.fromPost(a.toPost(post))
        Assert.assertEquals(
            post.toString().replace(",", "\n"),
            parsed.toString().replace(",", "\n")
        )
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Legacy Data Tests

    @Test
    fun parsePhotoWithExifTest() {
        val adapter = moshi.adapter(Photo::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Photo>)

        val post: Photo? = adapter.fromJson(Sample.photoWithExit)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseLegacyVideoTest() {
        val adapter = moshi.adapter(Video::class.java).failOnUnknown()
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
        val adapter = moshi.adapter(User::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<User>)

        val user: User? = adapter.fromJson(Sample.userOther)
        Assert.assertNotNull(user)
        val json = adapter.toJson(user)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseUserSelfTest() {
        val adapter = moshi.adapter(User::class.java).failOnUnknown()
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
        val adapter = moshi.adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogOther)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogSubmissionsTest() {
        val adapter = moshi.adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogSubmission)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogNsfwTest() {
        val adapter = moshi.adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogNsfw)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogAuthTest() {
        val adapter = moshi.adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogAuth)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogSelfTest() {
        val adapter = moshi.adapter(Blog::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<Blog>)

        val blog: Blog? = adapter.fromJson(Sample.blogSelf)
        Assert.assertNotNull(blog)
        val json = adapter.toJson(blog)
        Assert.assertNotNull(json)
    }

    // endregion

    // region Note Data Tests

    @Test
    fun parseNoteLikeTest() {
        val adapter = moshi.adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteLike)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNotePostedTest() {
        val adapter = moshi.adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.notePosted)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteAttributionTest() {
        val adapter = moshi.adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.notePostAttribution)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteReblogTest() {
        val adapter = moshi.adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteReblogWithAddedText)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteReplyTest() {
        val adapter = moshi.adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteWithResponseText)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseNoteReplyFormattedReblogTest() {
        val adapter = moshi.adapter(NoteData::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<NoteData>)

        val note: NoteData? = adapter.fromJson(Sample.noteWithFormatting)
        Assert.assertNotNull(note)
        val json = adapter.toJson(note)
        Assert.assertNotNull(json)
    }

    // endregion

}
