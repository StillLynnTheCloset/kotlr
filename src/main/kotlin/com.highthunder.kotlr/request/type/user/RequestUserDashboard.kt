package com.highthunder.kotlr.request.type.user

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.RequestPosts
import com.highthunder.kotlr.response.TumblrResponse
import com.highthunder.kotlr.response.type.user.ResponseUserDashboard
import com.highthunder.kotlr.types.Post
import kotlin.reflect.KClass

/**
 * RequestUserDashboard - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class RequestUserDashboard(
    postLimit: Int? = null,
    postOffset: Long? = null,
    afterPostId: Long? = null,
    beforePostId: Long? = null,
    afterTime: Long? = null,
    beforeTime: Long? = null,
    getReblogFields: Boolean? = null,
    getNotesHistory: Boolean? = null,
    useNeuePostFormat: Boolean? = null,
    tag: String? = null,
    private var type: Post.Type? = null
) : RequestPosts<ResponseUserDashboard.Body>(
    postLimit = postLimit,
    postOffset = postOffset,
    afterPostId = afterPostId,
    beforePostId = beforePostId,
    afterTime = afterTime,
    beforeTime = beforeTime,
    getReblogFields = getReblogFields,
    getNotesHistory = getNotesHistory,
    useNeuePostFormat = useNeuePostFormat,
    tag = tag
) {

    companion object {
        /**
         * TODO: Documentation
         */
        const val BASE_PATH: String = "user/dashboard"
    }

    override val responseClass: KClass<out TumblrResponse<ResponseUserDashboard.Body>> =
        ResponseUserDashboard.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = true
    override val improvedByOAuth: Boolean = false

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH"

    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
            var previous = false
            val parent = super.getUrlParameters(apiKey)
            if (parent.isNotBlank()) {
                append(parent)
                previous = true
            }
            type?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("type=")
                append(it.key)
                previous = true
            }
        }.toString()
    }

}
