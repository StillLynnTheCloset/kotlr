package com.highthunder.kotlr

import com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar
import com.highthunder.kotlr.response.type.blog.ResponseBlogLikes
import com.highthunder.kotlr.response.type.blog.ResponseBlogQueue
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.squareup.moshi.JsonAdapter
import org.junit.Assert
import org.junit.Test

/**
 * ParseResponseTest - TODO: Documentation
 *
 * @author highthunder
 * @since 10/25/18
 * @version 1.0.0
 */
class ParseResponseTest {

    @Test
    fun parseBlogLikesResponseTest() {
        val adapter =
            moshi.adapter<ResponseBlogLikes.Response>(ResponseBlogLikes.Response::class.java).failOnUnknown()

        val response: ResponseBlogLikes.Response? = adapter.fromJson(Sample.blogLikesResponseGood)
        Assert.assertNotNull(response)
        Assert.assertNotNull(response?.getWrapper())
        Assert.assertTrue(response?.getWrapper() is ResponseBlogLikes.Wrapper)
        Assert.assertNull(response?.getWrapper()?.getMessage())
        Assert.assertNotNull(response?.getBody())
        Assert.assertNotNull(response?.getWrapper()?.getBody())
        Assert.assertTrue(response?.getBody() is ResponseBlogLikes.Body)
        Assert.assertNotNull(response?.getBody()?.links)
        Assert.assertEquals(202L, response?.getBody()?.totalLiked)
        Assert.assertNotNull(response?.getBody()?.posts)
        Assert.assertEquals(1, response?.getBody()?.posts?.size)
        Assert.assertNotNull(response?.getBody()?.posts?.firstOrNull())
        Assert.assertNotNull(response?.getBody()?.posts?.firstOrNull()?.trail?.get(1)?.post?.id)
        val json = adapter.toJson(response)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogLikesResponseBadTest() {
        val adapter =
            moshi.adapter<ResponseBlogLikes.Response>(ResponseBlogLikes.Response::class.java).failOnUnknown()

        val response: ResponseBlogLikes.Response? = adapter.fromJson(Sample.blogLikesUnauthorized)
        Assert.assertNotNull(response)
        Assert.assertNotNull(response?.getWrapper())
        Assert.assertTrue(response?.getWrapper() is ResponseBlogLikes.Wrapper)
        Assert.assertNotNull(response?.getWrapper()?.getMessage())
        Assert.assertNull(response?.getBody())
        val json = adapter.toJson(response)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseUnauthorizedErrorTest() {
        val adapter = moshi.adapter(ResponseUserDashboard.Response::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<ResponseUserDashboard.Response>)

        val post: ResponseUserDashboard.Response? = adapter.fromJson(Sample.dashUnauthorized)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseDashResponseTest() {
        val adapter =
            moshi.adapter<ResponseUserDashboard.Response>(ResponseUserDashboard.Response::class.java)
                .failOnUnknown()

        val response: ResponseUserDashboard.Response? = adapter.fromJson(DashSample.dashResult)

        val json = adapter.toJson(response)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseDashNeueResponseTest() {
        val adapter =
            moshi.adapter<ResponseUserDashboard.Response>(ResponseUserDashboard.Response::class.java)
                .failOnUnknown()

        val response: ResponseUserDashboard.Response? = adapter.fromJson(DashSample.neueSample)

        val json = adapter.toJson(response)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseDashAudioEmbedResponseTest() {
        val adapter =
            moshi.adapter<ResponseUserDashboard.Response>(ResponseUserDashboard.Response::class.java)
                .failOnUnknown()

        val response: ResponseUserDashboard.Response? = adapter.fromJson(DashSample.legacyAudioEmbedPost)

        val json = adapter.toJson(response)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogAvatarTest() {
        val adapter = moshi.adapter(ResponseBlogAvatar.Response::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<ResponseBlogAvatar.Response>)

        val post: ResponseBlogAvatar.Response? = adapter.fromJson(Sample.blogAvatarResponse)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseBlogAvatarErrorTest() {
        val adapter = moshi.adapter(ResponseBlogAvatar.Response::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<ResponseBlogAvatar.Response>)

        val post: ResponseBlogAvatar.Response? = adapter.fromJson(Sample.blogAvatarError)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

    @Test
    fun parseQueuedTest() {
        val adapter = moshi.adapter(ResponseBlogQueue.Response::class.java).failOnUnknown()
        Assert.assertTrue(adapter is JsonAdapter<ResponseBlogQueue.Response>)

        val post: ResponseBlogQueue.Response? = adapter.fromJson(Sample.queuedPostsResponse)
        Assert.assertNotNull(post)
        val json = adapter.toJson(post)
        Assert.assertNotNull(json)
    }

}
