package com.stilllynnthecloset.kotlr.response.type.polls

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.stilllynnthecloset.kotlr.json.response.post.PostsTaggedWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.response.ResponseMetaInfo
import com.stilllynnthecloset.kotlr.response.TumblrError
import com.stilllynnthecloset.kotlr.response.TumblrResponse
import com.stilllynnthecloset.kotlr.response.WrapperInterface

/**
 * ResponsePollsResults - The response to a request for the results of a poll.
 *
 * @author StillLynnTheCloset
 * @since 2023-02-17
 */
public interface ResponsePollsResults {
    /**
     * Response - The top level object returned from Tumblr.
     *
     * @param meta An object containing any metadata returned from Tumblr, as well as some data returned in response headers.
     * @param response The actual response to the request, as a wrapper object to handle some types of errors from Tumblr.
     * @param errors An array of error objects, which are returned when some types of errors occur.
     */
    @JsonClass(generateAdapter = true)
    public data class Response constructor(
        @Json(name = "meta")
        override val meta: ResponseMetaInfo,
        @Json(name = "response")
        override val response: WrapperInterface<Body>,
        @Json(name = "errors")
        override val errors: List<TumblrError>? = null,
    ) : TumblrResponse<Body>

    /**
     * Adapter is [PostsTaggedWrapperJsonAdapter].
     *
     * @param body The body of this response.
     * @param error The error message if there is no body.
     */
    public data class Wrapper constructor(
        override val error: String? = null,
        override val body: Body? = null,
    ) : WrapperInterface<Body>

    /**
     * Body - The actual body of a successful response.
     *
     * @param results The results of the poll as a map from poll option UUID to vote count.
     * @param userVotes A list of poll UUIDs that the signed in user voted for.
     * @param timestamp A timestamp, assumed to be the time that the results were gathered?.
     */
    @JsonClass(generateAdapter = true)
    public data class Body constructor(
        @Json(name = "results")
        val results: Map<String, Long>,
        @Json(name = "user_votes")
        val userVotes: List<String>,
        @Json(name = "timestamp")
        val timestamp: Long,
    )
}
