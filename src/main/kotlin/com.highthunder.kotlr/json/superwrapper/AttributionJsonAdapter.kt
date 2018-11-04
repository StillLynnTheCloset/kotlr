package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.Attribution
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * AttributionJsonAdapter - An adapter to help Moshi convert [SuperAttributionJson] objects to and
 * from individual subclasses of [Attribution].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
class AttributionJsonAdapter {

    @FromJson
    fun toAttribution(input: SuperAttributionJson?): Attribution {
        return when (input?.type) {
            Attribution.Post.KEY -> input.toPostAttribution()
            Attribution.Link.KEY -> input.toLinkAttribution()
            Attribution.Blog.KEY -> input.toBlogAttribution()
            Attribution.App.KEY -> input.toAppAttribution()
            else -> throw JsonDataException("Expected a field of type SuperAttributionJson but got $input")
        }
    }

    @ToJson
    fun fromAttribution(input: Attribution): SuperAttributionJson? {
        return when (input) {
            is Attribution.Post -> SuperAttributionJson(input)
            is Attribution.Link -> SuperAttributionJson(input)
            is Attribution.Blog -> SuperAttributionJson(input)
            is Attribution.App -> SuperAttributionJson(input)
        }
    }

}
