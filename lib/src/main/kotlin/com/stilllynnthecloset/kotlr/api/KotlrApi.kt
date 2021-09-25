package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.getApi

/**
 * KotlrApi - The main class for performing requests to the Tumblr API.
 *
 * Get an instance by calling [getApi].
 */
public interface KotlrApi :
    KotlrUserGetApi,
    KotlrUserPostApi,
    KotlrUserDeleteApi,
    KotlrBlogGetApi,
    KotlrBlogPostApi,
    KotlrBlogDeleteApi,
    KotlrPostsGetApi
