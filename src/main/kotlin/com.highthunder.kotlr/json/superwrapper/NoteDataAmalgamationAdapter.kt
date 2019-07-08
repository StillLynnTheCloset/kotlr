package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.AttributionNote
import com.highthunder.kotlr.types.LikeNote
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.PostedNote
import com.highthunder.kotlr.types.ReblogNote
import com.highthunder.kotlr.types.ReplyNote
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * NoteDataAmalgamationAdapter - An adapter to help Moshi convert [NoteDataAmalgamation] objects to and
 * from individual subclasses of [NoteData].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class NoteDataAmalgamationAdapter {
    @FromJson
    fun toNote(input: NoteDataAmalgamation?): NoteData {
        return when (input?.type) {
            LikeNote.KEY -> input.toLike()
            ReblogNote.KEY -> input.toReblog()
            PostedNote.KEY -> input.toPosted()
            ReplyNote.KEY -> input.toReply()
            AttributionNote.KEY -> input.toAttribution()
            else -> throw JsonDataException("Expected a field of type NoteDataAmalgamation but got $input")
        }
    }

    @ToJson
    fun fromNote(input: NoteData): NoteDataAmalgamation? {
        return when (input) {
            is LikeNote -> NoteDataAmalgamation(input)
            is ReblogNote -> NoteDataAmalgamation(input)
            is PostedNote -> NoteDataAmalgamation(input)
            is ReplyNote -> NoteDataAmalgamation(input)
            is AttributionNote -> NoteDataAmalgamation(input)
        }
    }
}
