package com.highthunder.kotlr.request

/**
 * RequestPosts - TODO: Documentation
 *
 * @author highthunder
 * @since 11/4/18
 * @version 1.0.0
 */
abstract class RequestPosts<out T>(
    private val postLimit: Int? = null,
    private val postOffset: Long? = null,
    private val afterPostId: Long? = null,
    private val beforePostId: Long? = null,
    private val afterTime: Long? = null,
    private val beforeTime: Long? = null,
    private val getReblogFields: Boolean? = null,
    private val getNotesHistory: Boolean? = null,
    private val useNeuePostFormat: Boolean? = null,
    private val tag: String? = null
) : Request<T> {

    init {
        if (getNotesHistory != null && getReblogFields != null) {
            throw ConflictingParametersException("You may only specify one of {notes, reblog}")
        }
        var positions = 0
        positions += if (beforePostId != null) 1 else 0
        positions += if (afterPostId != null) 1 else 0
        positions += if (postOffset != null) 1 else 0
        positions += if (afterTime != null) 1 else 0
        positions += if (beforeTime != null) 1 else 0
        if (positions > 1) {
            throw ConflictingParametersException("You may only specify one of {beforePostId, afterPostId, postOffset, afterTime, beforeTime}")
        }
    }

    /**
     *  TODO: Documentation
     */
    override fun getUrlParameters(apiKey: String): String {
        return StringBuilder().apply {
            var previous = false
            postLimit?.also {
                append("?")
                append("limit=")
                append(it)
                previous = true
            }
            postOffset?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("offset=")
                append(it)
                previous = true
            }
            afterPostId?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("since_id=")
                append(it)
                previous = true
            }
            beforePostId?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("before_id=")
                append(it)
                previous = true
            }
            afterTime?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("after=")
                append(it)
                previous = true
            }
            beforeTime?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("before=")
                append(it)
                previous = true
            }
            getReblogFields?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("reblog_info=")
                append(it)
                previous = true
            }
            getNotesHistory?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("notes_info=")
                append(it)
                previous = true
            }
            useNeuePostFormat?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("npf=")
                append(it)
                previous = true
            }
            tag?.also {
                if (previous) {
                    append("&")
                } else {
                    append("?")
                }
                append("tag=")
                append(it.replace(" ", "+"))
                previous = true
            }
        }.toString()
    }

}
