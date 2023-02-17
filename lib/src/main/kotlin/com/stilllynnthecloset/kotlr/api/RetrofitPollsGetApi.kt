package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.polls.ResponsePollsResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RetrofitPollsGetApi {
    @GET("polls/{identifier}/{id}/{uuid}/results")
    suspend fun getPollResults(
        @Path("identifier", encoded = true)
        blogIdentifier: String,
        @Path("id")
        postId: Long,
        @Path("uuid", encoded = true)
        pollUuid: String,
    ): Response<ResponsePollsResults.Response>
}
