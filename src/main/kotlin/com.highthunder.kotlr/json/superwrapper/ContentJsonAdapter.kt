package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.*
import com.highthunder.kotlr.types.content.PostContent.*
import com.squareup.moshi.*

/**
 * ContentJsonAdapter - An adapter to help Moshi convert [SuperContentJson] objects to and
 * from individual subclasses of [PostContent].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class ContentJsonAdapter {

    @FromJson
    fun toContent(input: SuperContentJson): PostContent {
        return when (input.type) {
            AudioContent.KEY -> input.toAudioContent()
            ImageContent.KEY -> input.toImageContent()
            LinkContent.KEY -> input.toLinkContent()
            TextContent.KEY -> input.toTextContent()
            VideoContent.KEY -> input.toVideoContent()
            else -> throw JsonDataException("Expected a field of type SuperContentJson but got $input")
        }
    }

    @ToJson
    fun fromContent(input: PostContent): SuperContentJson {
        return when (input) {
            is AudioContent -> SuperContentJson(input)
            is ImageContent -> SuperContentJson(input)
            is LinkContent -> SuperContentJson(input)
            is TextContent -> SuperContentJson(input)
            is VideoContent -> SuperContentJson(input)
        }
    }

}
