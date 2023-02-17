package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.polls.ResponsePollsResults

public interface KotlrPollsGetApi {
    /**
     * Retrieve a Blog Avatar.
     *
     * This uses the default size of 64x64.
     *
     * @param blogIdentifier A blog identifier.
     */
    public suspend fun getPollResults(
        blogIdentifier: String,
        postId: Long,
        pollUuid: String,
    ): ResponsePollsResults.Response?
}
