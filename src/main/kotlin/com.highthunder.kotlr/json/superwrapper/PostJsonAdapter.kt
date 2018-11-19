package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.BlockPost
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.legacy.*
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * PostJsonAdapter - An adapter to help Moshi convert [SuperPostJson] objects to and
 * from individual subclasses of [Post].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class PostJsonAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toPost(input: SuperPostJson?): Post {
        return when (input?.type) {
            Post.Type.Answer -> input.toAnswerPost()
            Post.Type.Audio -> input.toAudioPost()
            Post.Type.Chat -> input.toChatPost()
            Post.Type.Link -> input.toLinkPost()
            Post.Type.Photo -> input.toPhotoPost()
            Post.Type.Quote -> input.toQuotePost()
            Post.Type.Text -> input.toTextPost()
            Post.Type.Video -> input.toVideoPost()
            Post.Type.Block -> input.toBlockPost()
            null -> throw JsonDataException("Post or type was null: $input")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromPost(input: Post): SuperPostJson? {
        return when (input) {
            is AnswerPost -> SuperPostJson(input)
            is AudioPost -> SuperPostJson(input)
            is ChatPost -> SuperPostJson(input)
            is LinkPost -> SuperPostJson(input)
            is PhotoPost -> SuperPostJson(input)
            is QuotePost -> SuperPostJson(input)
            is TextPost -> SuperPostJson(input)
            is VideoPost -> SuperPostJson(input)
            is BlockPost -> SuperPostJson(input)
            else -> throw JsonDataException("Post was not of expected type : $input")
        }
    }

}
