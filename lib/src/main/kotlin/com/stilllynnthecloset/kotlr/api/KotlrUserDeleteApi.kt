package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Query

internal interface KotlrUserDeleteApi {
    /**
     * Remove a content filter.
     *
     * @param filteredContent The string to remove from your filter.
     */
    @DELETE("user/filtered_content")
    suspend fun filterContent(
        @Query("filtered_content")
        filteredContent: String,
    ): Response<ResponseUserFilteredContent.Response>
}
