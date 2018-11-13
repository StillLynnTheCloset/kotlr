package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.NoteData.*
import com.highthunder.kotlr.types.content.TextFormat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * SuperNoteJson - A class to hold every possible field for [NoteData] so that Mochi can
 * deserialize them.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 *
 * @param type The type of this note.
 */
@JsonClass(generateAdapter = true)
data class SuperNoteJson(
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "timestamp")
    var timestamp: Long? = null,
    @Json(name = "blog_name")
    var blogName: String? = null,
    @Json(name = "blog_uuid")
    var blogUuid: String? = null,
    @Json(name = "blog_url")
    var blogUrl: String? = null,
    @Json(name = "followed")
    var blogFollowed: Boolean? = null,
    @Json(name = "avatar_shape")
    var avatarShape: String? = null,
    @Json(name = "added_text")
    var addedText: String? = null,
    @Json(name = "post_id")
    var postId: String? = null,
    @Json(name = "reblog_parent_blog_name")
    var reblogParentBlogName: String? = null,
    @Json(name = "reply_text")
    var reply_text: String? = null,
    @Json(name = "formatting")
    var formatting: List<TextFormat>? = null,
    @Json(name = "can_block")
    var can_block: Boolean? = null,
    @Json(name = "post_attribution_type")
    var post_attribution_type: String? = null,
    @Json(name = "post_attribution_type_name")
    var post_attribution_type_name: String? = null,
    @Json(name = "photo_url")
    var photo_url: String? = null,
    @Json(name = "photo_width")
    var photo_width: Int? = null,
    @Json(name = "photo_height")
    var photo_height: Int? = null
) {

    // TODO: To and from SuperNoteJson

    constructor(note: Like) : this(Like.KEY)
    constructor(note: Reblog) : this(Reblog.KEY)
    constructor(note: Posted) : this(Posted.KEY)
    constructor(note: Reply) : this(Reply.KEY)
    constructor(note: Attribution) : this(Attribution.KEY)

    fun toLike(): Like = Like()
    fun toReblog(): Reblog = Reblog()
    fun toPosted(): Posted = Posted()
    fun toReply(): Reply = Reply()
    fun toAttribution(): Attribution = Attribution()

}
