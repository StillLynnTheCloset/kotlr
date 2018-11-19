package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.NoteData.*
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
class NoteDataAmalgamationAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toNote(input: NoteDataAmalgamation?): NoteData {
        return when (input?.type) {
            Like.KEY -> input.toLike()
            Reblog.KEY -> input.toReblog()
            Posted.KEY -> input.toPosted()
            Reply.KEY -> input.toReply()
            Attribution.KEY -> input.toAttribution()
            else -> throw JsonDataException("Expected a field of type NoteDataAmalgamation but got $input")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromNote(input: NoteData): NoteDataAmalgamation? {
        return when (input) {
            is Like -> NoteDataAmalgamation(input)
            is Reblog -> NoteDataAmalgamation(input)
            is Posted -> NoteDataAmalgamation(input)
            is Reply -> NoteDataAmalgamation(input)
            is Attribution -> NoteDataAmalgamation(input)
        }
    }

}
