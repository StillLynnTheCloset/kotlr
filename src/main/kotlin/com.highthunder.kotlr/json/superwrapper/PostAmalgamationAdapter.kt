package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.BlockPost
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.legacy.AnswerPost
import com.highthunder.kotlr.types.legacy.AudioPost
import com.highthunder.kotlr.types.legacy.ChatPost
import com.highthunder.kotlr.types.legacy.LinkPost
import com.highthunder.kotlr.types.legacy.PhotoPost
import com.highthunder.kotlr.types.legacy.QuotePost
import com.highthunder.kotlr.types.legacy.TextPost
import com.highthunder.kotlr.types.legacy.VideoPost
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * PostAmalgamationAdapter - An adapter to help Moshi convert [PostAmalgamation] objects to and
 * from individual subclasses of [Post].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class PostAmalgamationAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toPost(input: PostAmalgamation?): Post {
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
            null -> throw JsonDataException("Post or type was invalid: $input")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromPost(input: Post): PostAmalgamation? {
        return when (input) {
            is AnswerPost -> PostAmalgamation(input)
            is AudioPost -> PostAmalgamation(input)
            is ChatPost -> PostAmalgamation(input)
            is LinkPost -> PostAmalgamation(input)
            is PhotoPost -> PostAmalgamation(input)
            is QuotePost -> PostAmalgamation(input)
            is TextPost -> PostAmalgamation(input)
            is VideoPost -> PostAmalgamation(input)
            is BlockPost -> PostAmalgamation(input)
            else -> throw JsonDataException("Post was not of expected type : $input")
        }
    }
}
