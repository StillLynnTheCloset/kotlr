package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.getApi

/**
 * KotlrApi - The main class for performing requests to the Tumblr API.
 *
 * Get an instance by calling [getApi].
 */
internal class KotlrApiImpl internal constructor(
    private val userGetApi: KotlrUserGetApi,
    private val userPostApi: KotlrUserPostApi,
    private val userDeleteApi: KotlrUserDeleteApi,
    private val blogGetApi: KotlrBlogGetApi,
    private val blogPostApi: KotlrBlogPostApi,
    private val blogDeleteApi: KotlrBlogDeleteApi,
    private val postsGetApi: KotlrPostsGetApi,
    private val pollsGetApi: KotlrPollsGetApi,
) :
    KotlrApi,
    KotlrUserGetApi by userGetApi,
    KotlrUserPostApi by userPostApi,
    KotlrUserDeleteApi by userDeleteApi,
    KotlrBlogGetApi by blogGetApi,
    KotlrBlogPostApi by blogPostApi,
    KotlrBlogDeleteApi by blogDeleteApi,
    KotlrPostsGetApi by postsGetApi,
    KotlrPollsGetApi by pollsGetApi
