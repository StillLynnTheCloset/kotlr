package com.stilllynnthecloset.kotlr.demo

import com.stilllynnthecloset.kotlr.SampleUserKey
import com.stilllynnthecloset.kotlr.api.KotlrApi
import com.stilllynnthecloset.kotlr.getApi
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.ReblogNote
import com.stilllynnthecloset.kotlr.types.content.PollContent
import kotlinx.coroutines.runBlocking
import kotlin.math.abs

fun main(): Unit = runBlocking {
    // TODO: In order to run this demo, replace this with your own user key.
    val userKey = SampleUserKey
    val api = getApi(userKey, debug = true, strict = true)

    // Find the X most recent original posts on a blog and rank them by popularity
    findMostPopularPosts(api, "kotlr-development", 5)
        .forEach {
            println("${it.first.slug}, ${it.first.date}, ${it.first.id}, ${it.second}")
        }

    // Find out exact results of the famous Bug Race! Make sure to use the blogname and post ID of the original post that contained the poll.
    getPollResults(api, "crankyteapot", 706810846972706816)

    // Run a full test suite on current tumblr data to hopefully catch any new properties or changes to existing apis.
    runIntegrationTests(
        api = api,
        blogName = "kotlr-development",
        isSideBlog = true,
        isBlogOwned = false,
    )
}

private suspend fun runIntegrationTests(api: KotlrApi, blogName: String, isSideBlog: Boolean, isBlogOwned: Boolean) {
    val doNotesAndReblogs = true
    val postsPerRequest = 50
    val maxPostsPerLooper = 1000

    runAllTests(
        api = api,
        blogName = blogName,
        isSideblog = isSideBlog,
        isBlogOwned = isBlogOwned,
        doNotesAndReblogs = doNotesAndReblogs,
        postsPerRequest = postsPerRequest,
        maxPostsPerLooper = maxPostsPerLooper,
    )
    runAllTests(
        api = api,
        blogName = "cyle",
        isSideblog = false,
        isBlogOwned = false,
        doNotesAndReblogs = doNotesAndReblogs,
        postsPerRequest = postsPerRequest,
        maxPostsPerLooper = maxPostsPerLooper,
    )
    println("Done running test API calls")
}

/**
 * This is super messy because it's just supposed to be a fun little thing.
 * I did a bunch of fun little Kotlin things, and make a whole bunch of assumptions about null values, and have 0 error handling.
 * So this is not an example of how you should write code, but it works, for now.
 * I don't do any pretty time formatting because I don't feel like importing a time library into this demo module.
 */
private suspend fun getPollResults(api: KotlrApi, blogName: String, postId: Long) {
    api
        .getPost(blogName, postId)
        ?.getBody()
        ?.also { post ->
            // Check the whole trail for poll contents
            (post.content.orEmpty() + post.trail?.flatMap { it.content?.contentList.orEmpty() }.orEmpty())
                .filterIsInstance<PollContent>()
                .forEach { content ->
                    val options = content.answers.orEmpty()
                    val resultBody = api.getPollResults(
                        blogIdentifier = post.blog?.name.orEmpty(),
                        postId = post.id ?: 0L,
                        pollUuid = content.clientId.orEmpty(),
                    )?.getBody()

                    val mappedResults = resultBody?.results?.map { (key, value) ->
                        Triple(options.firstOrNull { it.clientId == key }?.answerText, value, key)
                    }
                    println(content.question)
                    val totalVotes = mappedResults?.map { it.second }.orEmpty().sum().toDouble()
                    val table = mappedResults?.map {
                        listOf(
                            Cell("    ${it.first}", false),
                            Cell("${it.second} votes", true),
                            Cell("${String.format("%01.6f", it.second / totalVotes * 100)}%", true),
                            Cell("${it.third}", true),
                        )
                    }.orEmpty()
                    printTable(table)
                    val mappedVotes = resultBody
                        ?.userVotes
                        ?.map { vote ->
                            options
                                .firstOrNull { it.clientId == vote }
                                ?.answerText
                        }
                    if (mappedVotes.isNullOrEmpty()) {
                        println("You did not vote")
                    } else {
                        println("You voted for: $mappedVotes")
                    }
                    val pollDuration = content.settings?.expireAfter ?: 0
                    val postTimestamp = post.timestamp ?: 0
                    val pollClosesAfter = (pollDuration) + (postTimestamp)
                    val timestamp = resultBody?.timestamp ?: 0
                    val remainingTime = pollClosesAfter - timestamp
                    println("Voting is ${if (remainingTime <= 0) "not" else "still"} open")
                    if (remainingTime > 0) {
                        println("There are approximately $remainingTime seconds left to vote")
                    } else {
                        println("Poll has been closed for approximately ${abs(remainingTime)} seconds")
                    }
                    println("Poll results as of ${resultBody?.timestamp} unixtime")
                }
        }
    println()
}

private fun printTable(table: List<List<Cell>>, divider: String = " | ") {
    var foundColumn = true
    var column = 0
    val columnWidths = mutableListOf<Int>()
    while (foundColumn) {
        foundColumn = false
        val maxLength = table.mapNotNull {
            if (it.size > column) {
                foundColumn = true
                it[column].test.length
            } else {
                null
            }
        }.maxOrNull()
        if (maxLength != null) {
            columnWidths += maxLength
        }
        column++
    }
    table.forEach { row ->
        row.forEachIndexed { index, cell ->
            if (cell.padStart) {
                print(cell.test.padStart(columnWidths[index]))
            } else {
                print(cell.test.padEnd(columnWidths[index]))
            }
            if (index != row.lastIndex) {
                print(divider)
            }
        }
        println()
    }
}

private data class Cell constructor(val test: String, val padStart: Boolean)

/**
 * Finds the [postCount] most recent original posts on [blogName], pairs them with the number of reblogs they have and
 * returns them in descending order by that number of reblogs.
 */
private suspend fun findMostPopularPosts(api: KotlrApi, blogName: String, postCount: Int): List<Pair<Post, Int>> {
    val originalPosts = mutableListOf<Post>()
    loopBlogPosts(api, blogName, 50, postState = Post.State.Published) { post ->
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
    postState: Post.State,
    tag: String? = null,
    maxPosts: Int = 1000,
    block: (Post) -> Boolean = { true },
): List<Post> {
    var lastTime: Long = Long.MAX_VALUE
    var posts: List<Post>?
    val allPosts: MutableList<Post> = mutableListOf()
    var lastPostId: Long? = null
    var offset = 0L

    do {

        posts = when (postState) {
            Post.State.Draft -> {
                if (tag != null) {
                    throw IllegalArgumentException("Draft posts don't support searching by tags")
                }
                val response = api.getBlogDrafts(
                    blogIdentifier = blogName,
                    pagingLimit = postsPerRequest,
                    beforePostId = lastPostId,
                    getReblogFields = true,
                )
                val body = response?.getBody()
                body?.posts.orEmpty()
            }
            Post.State.Queue,
            Post.State.Queued -> {
                if (tag != null) {
                    throw IllegalArgumentException("Queued posts don't support searching by tags")
                }
                val response = api.getBlogQueue(
                    blogIdentifier = blogName,
                    pagingLimit = postsPerRequest,
                    pagingOffset = offset,
                    getReblogFields = true,
                )
                val body = response?.getBody()
                body?.posts.orEmpty()
            }
            Post.State.Published -> {
                val response = api.getBlogPosts(
                    blogIdentifier = blogName,
                    pagingLimit = postsPerRequest,
                    beforeTime = lastTime,
                    tag = tag,
                    getReblogFields = true,
                )
                val body = response?.getBody()
                body?.posts.orEmpty()
            }
            Post.State.Private -> TODO()
            Post.State.Submission -> TODO()
            Post.State.Unapproved -> TODO()
        }
        if (posts.isEmpty()) {
            println("Found no posts")
            return allPosts
        }
        posts.forEach { post ->
            val ts = post.timestamp ?: Long.MAX_VALUE
            if (ts < lastTime) {
                lastTime = ts - 1 // Subtract 1 ms so we don't get an overlap
            }
        }
        lastPostId = posts.last().id
        offset += postsPerRequest
        posts.also(allPosts::addAll)
        println(posts.map { it.id })
        val keepGoing = posts.isNotEmpty() && posts.all(block) && offset < maxPosts
    } while (keepGoing)
    return allPosts
}
