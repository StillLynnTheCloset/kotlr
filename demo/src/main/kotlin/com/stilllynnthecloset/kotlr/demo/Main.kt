package com.stilllynnthecloset.kotlr.demo

import com.stilllynnthecloset.kotlr.SampleUserKey
import com.stilllynnthecloset.kotlr.api.KotlrApi
import com.stilllynnthecloset.kotlr.getApi
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.ReblogNote
import com.stilllynnthecloset.kotlr.types.content.PollContent
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // TODO: In order to run this demo, replace this with your own user key.
    val userKey = SampleUserKey
    val api = getApi(userKey, debug = true, strict = true)

    // Find the X most recent original posts on a blog and rank them by popularity
    findMostPopularPosts(api, "kotlr-development", 50)
        .forEach {
            println("${it.first.slug}, ${it.first.date}, ${it.first.id}, ${it.second}")
        }

    // Find out exact results of the famous Bug Race! Make sure to use the blogname and post ID of the original post that contained the poll.
    getPollResults(api, "crankyteapot", 706810846972706816)

    // Run a full test suite on current tumblr data to hopefully catch any new properties or changes to existing apis.
    runIntegrationTests(api)
}

private suspend fun runIntegrationTests(api: KotlrApi) {
    val doNotesAndReblogs = true
    val postsPerRequest = 50
    val maxPostsPerLooper = 1000

    runAllTests(
        api,
        "kotlr-development",
        doNotesAndReblogs,
        postsPerRequest,
        maxPostsPerLooper,
    )
    runAllTests(
        api,
        "cyle",
        doNotesAndReblogs,
        postsPerRequest,
        maxPostsPerLooper,
    )
    println("Done running test API calls")
}

private suspend fun getPollResults(api: KotlrApi, blogName: String, postId: Long) {
    api
        .getPost(blogName, postId)
        ?.getBody()
        ?.also { post ->
            post.content
                ?.filterIsInstance<PollContent>()
                ?.forEach { content ->
                    val options = content.answers.orEmpty()
                    val resultBody = api.getPollResults(
                        blogIdentifier = post.blog?.name.orEmpty(),
                        postId = post.id ?: 0L,
                        pollUuid = content.clientId.orEmpty(),
                    )?.getBody()
                    println("Poll results as of ${resultBody?.timestamp} unixtime")
                    val mappedResults = resultBody?.results?.mapKeys { (key, value) ->
                        options.firstOrNull { it.clientId == key }?.answerText
                    }
                    println(content.question)
                    val totalVotes = mappedResults?.map { it.value }.orEmpty().sum().toDouble()
                    mappedResults?.forEach {
                        println("${it.key} : ${it.value} - ${it.value / totalVotes * 100}%")
                    }
                }
        }
}

/**
 * Finds the [postCount] most recent original posts on [blogName], pairs them with the number of reblogs they have and
 * returns them in descending order by that number of reblogs.
 */
private suspend fun findMostPopularPosts(api: KotlrApi, blogName: String, postCount: Int): List<Pair<Post, Int>> {
    val originalPosts = mutableListOf<Post>()
    loopBlogPosts(api, blogName, 50) { post ->
        if (post.trail.isNullOrEmpty()) {
            originalPosts.add(post)
            println(post.slug)
        }
        originalPosts.size < postCount
    }

    return originalPosts.map { it to getPopularityOfPost(it) }.sortedByDescending { it.second }
}

private fun getPopularityOfPost(post: Post): Int = post.notes.orEmpty().count {
    it is ReblogNote
}

internal suspend fun loopBlogPosts(
    api: KotlrApi,
    blogName: String,
    postsPerRequest: Int,
    block: (Post) -> Boolean
): List<Post> {
    var lastTime: Long = Long.MAX_VALUE
    var posts: List<Post>?
    val allPosts: MutableList<Post> = mutableListOf()
    var offset = 0L

    do {
        val response = api.getBlogPosts(
            blogIdentifier = blogName,
            pagingLimit = postsPerRequest,
            beforeTime = lastTime,
            getNotesHistory = true,
        )
        val body = response?.getBody()
        posts = body?.posts.orEmpty()
        if (posts.isEmpty()) {
            println("Found no posts")
            return emptyList()
        }
        posts.forEach { post ->
            val ts = post.timestamp ?: Long.MAX_VALUE
            if (ts < lastTime) {
                lastTime = ts - 1 // Subtract 1 ms so we don't get an overlap
            }
        }
        val keepGoing = posts.isNotEmpty() && posts.all(block)
        offset += postsPerRequest
        posts.also(allPosts::addAll)
    } while (keepGoing)
    return allPosts
}
