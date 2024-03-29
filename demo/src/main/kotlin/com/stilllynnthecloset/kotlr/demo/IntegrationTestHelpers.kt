/* ktlint-disable max-line-length */
/* ktlint-disable parameter-list-wrapping */
package com.stilllynnthecloset.kotlr.demo

import com.stilllynnthecloset.kotlr.SampleUserKey
import com.stilllynnthecloset.kotlr.api.KotlrApi
import com.stilllynnthecloset.kotlr.authentication.OAuthFlow
import com.stilllynnthecloset.kotlr.authentication.TumblrAppKey
import com.stilllynnthecloset.kotlr.authentication.TumblrUserKey
import com.stilllynnthecloset.kotlr.getApi
import com.stilllynnthecloset.kotlr.postbody.CreateNewPostBody
import com.stilllynnthecloset.kotlr.postbody.ReblogPostBody
import com.stilllynnthecloset.kotlr.response.ResponseMetaInfo
import com.stilllynnthecloset.kotlr.response.TumblrResponse
import com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogLikes
import com.stilllynnthecloset.kotlr.types.Media
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.RequestLinks
import com.stilllynnthecloset.kotlr.types.content.ImageContent
import com.stilllynnthecloset.kotlr.types.content.RowBlockLayout
import com.stilllynnthecloset.kotlr.types.content.SmallTextFormat
import com.stilllynnthecloset.kotlr.types.content.TextContent
import kotlinx.coroutines.runBlocking

/**
 * A set of functions to make it easy to implement a full suite of flaky (live) integration tests.
 *
 * Just add a <pre>{@code
 * fun main(): Unit = runBlocking { }
 * }</pre>
 * And add a call to [runAllTests] with your own user key and blog name (and any other parameters you want to tweak).
 */

// region Integration Test Helpers

internal fun Any?.clean(): String = this.toString().replace("\n", "")
internal fun <T> TumblrResponse<T>?.checkError(expectFailure: Boolean = false): TumblrResponse<T>? =
    if (expectFailure xor (this?.meta?.status != null && this.meta.status!! >= 400)) {
        throw IllegalStateException("Response was an error: $this")
    } else {
        this
    }

// Uses (if (doNotesAndReblogs) 8 else 4) requests.
internal suspend fun runUserTests(api: KotlrApi, postsPerRequest: Int, doNotesAndReblogs: Boolean) {
    println("Calling `getUserInfo()`")
    println(api.getUserInfo().checkError().clean())

    println("Calling `getUserLikes()`")
    println(api.getUserLikes(pagingLimit = postsPerRequest).checkError().clean())
    if (doNotesAndReblogs) {
        println(
            api.getUserLikes(pagingLimit = postsPerRequest, getReblogFields = true).checkError().clean(),
        )
        println(
            api.getUserLikes(pagingLimit = postsPerRequest, getNotesHistory = true).checkError().clean(),
        )
    }

    println("Calling `getUserDash()`")
    println(api.getUserDash(pagingLimit = postsPerRequest).checkError().clean())
    if (doNotesAndReblogs) {
        println(
            api.getUserDash(pagingLimit = postsPerRequest, getReblogFields = true).checkError().clean(),
        )
        println(
            api.getUserDash(pagingLimit = postsPerRequest, getNotesHistory = true).checkError().clean(),
        )
    }

    println("Calling `likePost()`")
    println(api.likePost(232, "jaHD5AfB").checkError().clean())

    println("Calling `unlikePost()`")
    println(api.unlikePost(232, "jaHD5AfB").checkError().clean())

    println("Calling `followBlog()`")
    println(api.followBlog("https://demo.tumblr.com/").checkError().clean())

    println("Calling `unfollowBlog()`")
    println(api.unfollowBlog("https://demo.tumblr.com/").checkError().clean())

    println("Calling `getUserFollowing()`")
    println(api.getUserFollowing().checkError().clean())
}

// Uses (if (doNotesAndReblogs) 22 else 12) requests.
internal suspend fun runBlogTests(
    api: KotlrApi,
    blogName: String,
    postsPerRequest: Int,
    doNotesAndReblogs: Boolean,
    expectError: Boolean = false,
) {
    println("Calling `getBlogAvatar()`")
    println(api.getBlogAvatar(blogIdentifier = blogName).checkError(expectError).clean())
    println(api.getBlogAvatar(blogIdentifier = blogName, size = 16).checkError(expectError).clean())
    println(api.getBlogAvatar(blogIdentifier = blogName, size = 512).checkError(expectError).clean())

    println("Calling `getBlogFollowers()`")
    println(api.getBlogFollowers(blogIdentifier = blogName).checkError(expectError).clean())

    println("Calling `getBlogFollowing()`")
    println(api.getBlogFollowing(blogIdentifier = blogName).checkError(expectError).clean())

    println("Calling `getBlogInfo()`")
    println(api.getBlogInfo(blogIdentifier = blogName).checkError(expectError).clean())

    println("Calling `getBlogFollowedBy()`")
    println(api.getBlogFollowedBy(blogIdentifier = blogName, query = "demo").checkError(expectError).clean())

    println("Calling `getBlogLikes()``")
    println(
        api.getBlogLikes(blogIdentifier = blogName, pagingLimit = postsPerRequest).checkError(expectError).clean(),
    )
    if (doNotesAndReblogs) {
        println(
            api.getBlogLikes(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getReblogFields = true,
            ).checkError(expectError).clean(),
        )
        println(
            api.getBlogLikes(
                blogName,
                pagingLimit = postsPerRequest,
                getNotesHistory = true,
            ).checkError(expectError).clean(),
        )
    }

    println("Calling `getBlogPosts()`")
    println(
        api.getBlogPosts(blogName, pagingLimit = postsPerRequest).checkError(expectError).clean(),
    )
    if (doNotesAndReblogs) {
        println(
            api.getBlogPosts(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getReblogFields = true,
            ).checkError(expectError).clean(),
        )
        println(
            api.getBlogPosts(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getNotesHistory = true,
            ).checkError(expectError).clean(),
        )
    }

    println("Calling `getBlogDrafts()`")
    println(
        api.getBlogDrafts(blogName, pagingLimit = postsPerRequest).checkError(expectError).clean(),
    )
    if (doNotesAndReblogs) {
        println(
            api.getBlogDrafts(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getReblogFields = true,
            ).checkError(expectError).clean(),
        )
        println(
            api.getBlogDrafts(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getNotesHistory = true,
            ).checkError(expectError).clean(),
        )
    }

    println("Calling `getBlogQueue()`")
    println(
        api.getBlogQueue(blogName, pagingLimit = postsPerRequest).checkError(expectError).clean(),
    )
    if (doNotesAndReblogs) {
        println(
            api.getBlogQueue(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getReblogFields = true,
            ).checkError(expectError).clean(),
        )
        println(
            api.getBlogQueue(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getNotesHistory = true,
            ).checkError(expectError).clean(),
        )
    }

    println("Calling `getBlogSubmissions()`")
    println(
        api.getBlogSubmissions(blogIdentifier = blogName, pagingLimit = postsPerRequest).checkError(
            expectError,
        ).clean(),
    )
    if (doNotesAndReblogs) {
        println(
            api.getBlogSubmissions(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getReblogFields = true,
            ).checkError(expectError).clean(),
        )
        println(
            api.getBlogSubmissions(
                blogIdentifier = blogName,
                pagingLimit = postsPerRequest,
                getNotesHistory = true,
            ).checkError(expectError).clean(),
        )
    }

    println("Calling `getPost()`")
    println(
        api.getPost(blogIdentifier = "demo", postId = 232).checkError().clean(),
    )

    println("Calling `getPostNotes()`")
    println(api.getPostNotes(blogIdentifier = "demo", postId = 232).checkError().clean())

    println(api.getNotifications(blogIdentifier = blogName).checkError(expectError).clean())
    println(api.getNotifications(blogIdentifier = blogName, types = listOf("like")).checkError(expectError).clean())
    println(api.shuffleQueue(blogIdentifier = blogName).checkError(expectError).clean())
}

// Uses (3) requests.
internal suspend fun runPostTests(api: KotlrApi) {
    println(api.getTaggedPosts("lol").checkError().clean())

    // Check the results of BUG RACE.
    println(api.getPollResults("crankyteapot", 706810846972706816, "05898443-8e9b-4618-97ed-6e54b0443475").checkError().clean())

    // Figure out how much vanilla to add to your cake.
    println(api.getPollResults("relientk", 708263093485076480, "60e0b849-5c0c-43ca-a334-bba8b7f924e2").checkError().clean())
}

// Uses up to (ceiling(postsToLoop / postsPerRequest)) requests. (depends if there are enough posts on the given blog)
internal suspend fun loopBlogPosts(api: KotlrApi, blogName: String, postsPerRequest: Int, postsToLoop: Int): List<Post> {
    var lastTime: Long = Long.MAX_VALUE
    var posts: List<Post>?
    val allPosts: MutableList<Post> = mutableListOf()
    var offset = 0L

    do {
        val response = api.getBlogPosts(
            blogIdentifier = blogName,
            pagingLimit = postsPerRequest,
            beforeTime = lastTime,
        )
        println(response.checkError().clean())
        val body = response?.getBody()
        posts = body?.posts
        posts?.forEach { post ->
            val ts = post.timestamp ?: Long.MAX_VALUE
            if (ts < lastTime) {
                lastTime = ts - 1 // Subtract 1 ms so we don't get an overlap
            }
        }
        offset += postsPerRequest
        posts?.also(allPosts::addAll)
    } while (!posts.isNullOrEmpty() && offset < postsToLoop)
    return allPosts
}

// Uses up to (ceiling(postsToLoop / postsPerRequest)) requests. (depends if there are enough likes on your account)
internal suspend fun loopLikes(api: KotlrApi, postsPerRequest: Int, postsToLoop: Int): List<Post> {
    var lastTime: Long = Long.MAX_VALUE
    var posts: List<Post>?
    val allPosts: MutableList<Post> = mutableListOf()
    var offset = 0L

    do {
        val response = api.getUserLikes(
            pagingLimit = postsPerRequest,
            beforeTime = lastTime,
        )
        println(response.checkError().clean())
        val body = response?.getBody()
        posts = body?.posts
        posts?.forEach { post ->
            val ts = post.timestamp ?: Long.MAX_VALUE
            if (ts < lastTime) {
                lastTime = ts - 1 // Subtract 1 ms so we don't get an overlap
            }
        }
        posts?.also(allPosts::addAll)
        offset += postsPerRequest
    } while (!posts.isNullOrEmpty() && offset < postsToLoop)
    return allPosts
}

// Uses up to (1 + ceiling(postsToLoop / postsPerRequest)) requests. (depends if there are enough posts on your dash)
internal suspend fun loopDashboard(api: KotlrApi, postsPerRequest: Int, postsToLoop: Int): List<Post> {
    var posts: List<Post>?
    val allPosts: MutableList<Post> = mutableListOf()
    var offset = 0L
    // Get a first post, which can then be used to call [getUserDash] with a beforePostId
    var beforeId = api.getUserDash(
        pagingLimit = 1,
    )?.getBody()?.posts?.firstOrNull()?.id!!
    do {
        val response = api.getUserDash(
            pagingLimit = postsPerRequest,
            beforePostId = beforeId,
        )
        println(response.checkError().clean())
        val body = response?.getBody()
        posts = body?.posts
        posts?.also(allPosts::addAll)
        beforeId = posts?.lastOrNull()?.id!!
        offset += posts.size
    } while (!posts.isNullOrEmpty() && offset < postsToLoop)
    return allPosts
}

// Uses (2) requests.
internal suspend fun testReblog(api: KotlrApi, blogName: String) {
    api.getBlogPosts(blogName).also { println(it.checkError().clean()) }?.getBody()?.posts?.firstOrNull()?.also {
        println(it.clean())
        val postId = it.id
        val reblogKey = it.reblogKey
        val parentId = it.blog?.uuid
        println("postId $postId, reblogKey $reblogKey, parentId $parentId")
        if (postId == null || reblogKey == null || parentId == null) {
            return@also
        }

        val reblogBody = ReblogPostBody(
            postToReblog = it,
            content = listOf(
                TextContent(
                    text = "Test Reblog",
                    subType = TextContent.SubType.Heading1,
                ),
                TextContent(
                    text = "This is a test reblog",
                ),
            ),
            state = Post.State.Draft,
            tags = listOf("Tag1", "Tag2", "Tag3, Tag4 , Tag5"),
        )
        val reblogResponse = api.reblogPost(
            blogIdentifier = blogName,
            reblogBody = reblogBody,
        )
        println(reblogResponse)
    }
}

// Uses (1) request.
internal suspend fun testCreate(api: KotlrApi, blogName: String) {
    val response = api.createNewPost(
        blogIdentifier = blogName,
        createBody = CreateNewPostBody(
            content = listOf(
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.Heading1,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.Heading2,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.Indented,
                    indentLevel = 16,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.Chat,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.OrderedListItem,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.OrderedListItem,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.UnorderedListItem,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.OrderedListItem,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.Quirky,
                ),
                TextContent(
                    text = "Test",
                    subType = TextContent.SubType.Quote,
                ),
                TextContent(
                    text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
                    formatting = listOf(
                        SmallTextFormat(1, 55),
                        SmallTextFormat(2, 54),
                        SmallTextFormat(3, 53),
                        SmallTextFormat(4, 52),
                        SmallTextFormat(5, 51),
                        SmallTextFormat(6, 50),
                        SmallTextFormat(7, 49),
                        SmallTextFormat(8, 48),
                        SmallTextFormat(9, 47),
                        SmallTextFormat(10, 46),
                        SmallTextFormat(11, 45),
                        SmallTextFormat(12, 44),
                        SmallTextFormat(13, 43),
                        SmallTextFormat(14, 42),
                        SmallTextFormat(15, 41),
                        SmallTextFormat(16, 40),
                        SmallTextFormat(17, 39),
                        SmallTextFormat(18, 38),
                        SmallTextFormat(19, 37),
                        SmallTextFormat(20, 36),
                        SmallTextFormat(21, 35),
                        SmallTextFormat(22, 34),
                        SmallTextFormat(23, 33),
                        SmallTextFormat(24, 32),
                        SmallTextFormat(25, 31),
                        SmallTextFormat(26, 30),
                        SmallTextFormat(27, 29),
                    ),
                ),
                ImageContent(
                    media = listOf(
                        Media(
                            url = "https://assets.tumblr.com/images/default_avatar/cube_closed_64.png",
                        ),
                    ),
                ),
            ),
            layout = listOf(
                RowBlockLayout(
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
                        RowBlockLayout.Display(
                            blocks = listOf(7),
                        ),
                        RowBlockLayout.Display(
                            blocks = listOf(8),
                        ),
                        RowBlockLayout.Display(
                            blocks = listOf(9),
                        ),
                        RowBlockLayout.Display(
                            blocks = listOf(10),
                        ),
                        RowBlockLayout.Display(
                            blocks = listOf(11),
                        ),
                    ),
                ),
            ),
            state = Post.State.Draft,
            tags = listOf("Tag1", "Tag2", "Tag3, Tag4， Tag5‚ Tag6, Tag7"),
        ),
    )
    println(response)
}

// Uses (13) requests.
internal suspend fun testFilteredContent(api: KotlrApi) {
    println(api.getContentFilters().checkError().clean())

    println(api.addContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere1").checkError().clean())
    println(api.addContentFilters(contentFilters = listOf("testContentFilterThatWon'tAppearAnywhere1")).checkError().clean())
    println(api.addContentFilters(contentFilters = listOf("testContentFilterThatWon'tAppearAnywhere1", "testContentFilterThatWon'tAppearAnywhere2")).checkError().clean())
    println(api.addContentFilters("testContentFilterThatWon'tAppearAnywhere1", "testContentFilterThatWon'tAppearAnywhere2").checkError().clean())

    println(api.getContentFilters().checkError().clean())

    println(api.deleteContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere1").checkError().clean())
    println(api.deleteContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere1").checkError().clean())
    println(api.deleteContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere1").checkError().clean())
    println(api.deleteContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere1").checkError().clean())
    println(api.deleteContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere2").checkError().clean())
    println(api.deleteContentFilter(contentFilter = "testContentFilterThatWon'tAppearAnywhere2").checkError().clean())

    println(api.getContentFilters().checkError().clean())
}

// Uses (5) requests.
internal suspend fun testBlogBlocks(api: KotlrApi, blogIdentifier: String) {
    println(api.getBlogBlocks(blogIdentifier = blogIdentifier).checkError().clean())
    println(api.blockBlog(blogIdentifier = blogIdentifier, blogToBlock = "staff").checkError().clean())
    println(api.getBlogBlocks(blogIdentifier = blogIdentifier).checkError().clean())
    println(api.unblockBlog(blogIdentifier = blogIdentifier, blogToUnblock = "staff").checkError().clean())
    println(api.getBlogBlocks(blogIdentifier = blogIdentifier).checkError().clean())
}

// Uses ((if (doNotesAndReblogs) 54 else 40) + 3 * ceiling(postsToLoop / postsPerRequest)) requests
// Default = 220 = 40 + 3*60
internal suspend fun runAllTests(
    api: KotlrApi,
    blogName: String,
    doNotesAndReblogs: Boolean = false,
    postsPerRequest: Int = 50,
    maxPostsPerLooper: Int = 3000,
) {
    println("Test all of the User related api calls")
    runUserTests(api, postsPerRequest, doNotesAndReblogs)

    println("Test all of the Blog related api calls")
    runBlogTests(api, blogName, postsPerRequest, doNotesAndReblogs)

    println("Test all of the Post related api calls")
    runPostTests(api)

    println("Loop through a bunch of the most recent posts on your dashboard")
    loopDashboard(api, postsPerRequest, maxPostsPerLooper)

    println("Loop through a bunch of the most recent posts that you liked")
    loopLikes(api, postsPerRequest, maxPostsPerLooper)

    println("Loop through a bunch of the most recent posts on your blog")
    loopBlogPosts(api, blogName, postsPerRequest, maxPostsPerLooper)

    println("Test what happens if you call for a blog that (probably) doesn't exist")
    runBlogTests(api, blogName + "asdfasdfasdfasdf", postsPerRequest, doNotesAndReblogs, expectError = true)

    println("Draft a reblog of the most recent post")
    testReblog(api, blogName)

    println("Draft a test post")
    testCreate(api, blogName)

    println("Filter content")
    testFilteredContent(api)

    println("Blocking")
    testBlogBlocks(api, blogName)
}

// endregion Integration Test Helpers

// region README Examples

@Suppress("unused")
internal fun minimalExampleExplained() = runBlocking {
    // Class for holding API keys and secrets.
    // You can get your API key and secret from https://www.tumblr.com/oauth/apps and clicking on "Register Application"
    // They will be called "OAuth Consumer Key" and "Secret Key"
    // User key and user secret have to be acquired through OAuth, see the `oAuthExample` to find how to get them.
    val key = TumblrUserKey("apiKey", "apiSecret", "userKey", "userSecret")

    // The client which performs all requests, this is similar to Jumblr's `JumblrClient`.
    val service: KotlrApi = getApi(key)

    // Perform the request.
    val response: ResponseBlogLikes.Response? = service.getBlogLikes(blogIdentifier = "cyle")

    // Check out any of the meta information that Tumblr returns such as HTTP success codes.
    val meta: ResponseMetaInfo? = response?.meta
    println(meta)

    // Get the main meat of the response.
    val body: ResponseBlogLikes.Body? = response?.getBody()

    // And now we can access Tumblr's actual response, which in this case is composed of
    // a list of some liked posts, a count of the total number of liked posts, and potentially
    // a map of RequestLinks which can encode some generic actions that Tumblr thinks you
    // might like to perform based on the content of this request.
    val totalLikedPosts: Long? = body?.totalLiked
    println(totalLikedPosts)
    val requestLinks: RequestLinks? = body?.links
    println(requestLinks)
    val postUrl: String? = body?.posts?.firstOrNull()?.postUrl
    println(postUrl)
}

@Suppress("unused")
internal fun minimalExample() = runBlocking {
    println(
        getApi(SampleUserKey)
            .getBlogLikes(blogIdentifier = "cyle")
            ?.getBody()
            ?.posts
            ?.firstOrNull()
            ?.postUrl,
    )
}

@Suppress("unused")
internal fun oAuthExample() = runBlocking {
    // Kotlr also makes the process of getting OAuth keys easy.

    println("Enter your consumer key:")
    val apiKey: String = readln()

    println("Enter your consumer secret:")
    val apiSecret: String = readln()

    // Create an authentication flow.
    val flow = OAuthFlow(TumblrAppKey(apiKey, apiSecret))

    // Get the request url, you'll have to open this in a browser or webview.
    // It will then ask you to login to Tumblr and authorize your app to access your account.
    // Since we aren't using a web based application, the callbackUrl doesn't really matter, so let's
    // just make it example.com.
    val requestUrl: String? = flow.getRequestUrl("example.com")

    // We'll just print this to the console, so you can copy and paste it.
    println("Open this url in your browser and sign in")
    println(requestUrl)

    // Once you've signed in and been redirected, copy that new url from
    // the browser and drop it into the console.
    println("Enter the url you were re-directed to:")
    val redirectedUrl: String = readln()

    // Now we just parse that url and use it to complete the authentication process.
    val userKey: TumblrUserKey = flow.parseResponseUrl(redirectedUrl)
    println(userKey.toString())

    // Print out information about the newly logged-in user.
    println(getApi(userKey).getUserInfo())
}

// endregion README Examples
