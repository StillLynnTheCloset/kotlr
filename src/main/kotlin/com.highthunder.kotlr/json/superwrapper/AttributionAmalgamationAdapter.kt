package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.Attribution
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

/**
 * AttributionAmalgamationAdapter - An adapter to help Moshi convert [AttributionAmalgamation] objects to and
 * from individual subclasses of [Attribution].
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
internal class AttributionAmalgamationAdapter {

    /**
     *  TODO: Documentation
     */
    @FromJson
    fun toAttribution(input: AttributionAmalgamation?): Attribution {
        return when (input?.type) {
            Attribution.Post.KEY -> input.toPostAttribution()
            Attribution.Link.KEY -> input.toLinkAttribution()
            Attribution.Blog.KEY -> input.toBlogAttribution()
            Attribution.App.KEY -> input.toAppAttribution()
            else -> throw JsonDataException("Expected a field of type AttributionAmalgamation but got $input")
        }
    }

    /**
     *  TODO: Documentation
     */
    @ToJson
    fun fromAttribution(input: Attribution): AttributionAmalgamation? {
        return when (input) {
            is Attribution.Post -> AttributionAmalgamation(input)
            is Attribution.Link -> AttributionAmalgamation(input)
            is Attribution.Blog -> AttributionAmalgamation(input)
            is Attribution.App -> AttributionAmalgamation(input)
        }
    }

}
