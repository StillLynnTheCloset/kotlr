package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.NoteData.*
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * NoteJsonAdapter - An adapter to help Moshi convert [SuperNoteJson] objects to and
 * from individual subclasses of [NoteData].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class NoteJsonAdapter {

    /**
     * TODO: Documentation
     */
    @FromJson
    fun toNote(input: SuperNoteJson?): NoteData {
        return when (input?.type) {
            Like.KEY -> input.toLike()
            Reblog.KEY -> input.toReblog()
            Posted.KEY -> input.toPosted()
            Reply.KEY -> input.toReply()
            Attribution.KEY -> input.toAttribution()
            else -> throw JsonDataException("Expected a field of type SuperNoteJson but got $input")
        }
    }

    /**
     * TODO: Documentation
     */
    @ToJson
    fun fromNote(input: NoteData): SuperNoteJson? {
        return when (input) {
            is Like -> SuperNoteJson(input)
            is Reblog -> SuperNoteJson(input)
            is Posted -> SuperNoteJson(input)
            is Reply -> SuperNoteJson(input)
            is Attribution -> SuperNoteJson(input)
        }
    }

}
