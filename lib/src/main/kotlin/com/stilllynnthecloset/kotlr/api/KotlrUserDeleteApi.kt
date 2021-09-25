package com.stilllynnthecloset.kotlr.api

import com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent

public interface KotlrUserDeleteApi {
    /**
     * Use this method to remove a content filter.
     *
     * @param contentFilter The text that a filter filters on.
     */
    public suspend fun deleteContentFilter(
        contentFilter: String,
    ): ResponseUserFilteredContent.Response?
}
