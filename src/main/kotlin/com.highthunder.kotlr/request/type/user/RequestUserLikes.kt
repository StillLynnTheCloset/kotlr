package com.highthunder.kotlr.request.type.user

import com.github.scribejava.core.model.Verb
import com.highthunder.kotlr.request.RequestPosts
import com.highthunder.kotlr.response.ResponseInterface
import com.highthunder.kotlr.response.type.user.ResponseUserLikes
import kotlin.reflect.KClass

/**
 * RequestUserLikes - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
class RequestUserLikes(
    postLimit: Int? = null,
    postOffset: Long? = null,
    afterPostId: Long? = null,
    beforePostId: Long? = null,
    afterTime: Long? = null,
    beforeTime: Long? = null,
    getReblogFields: Boolean? = null,
    getNotesHistory: Boolean? = null,
    useNeuePostFormat: Boolean? = null,
    tag: String? = null
) : RequestPosts<ResponseUserLikes.Body>(
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
        const val BASE_PATH: String = "user/likes/"
    }

    override val responseClass: KClass<out ResponseInterface<ResponseUserLikes.Body>> =
        ResponseUserLikes.Response::class
    override val verb: Verb = Verb.GET
    override val requiresOAuth: Boolean = false
    override val improvedByOAuth: Boolean = true

    override fun getBaseUrl(): String = "$apiRootPath$BASE_PATH"

}
