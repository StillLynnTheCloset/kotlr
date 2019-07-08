package com.highthunder.kotlr.json.superwrapper

import com.highthunder.kotlr.types.content.AppAttribution
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlogAttribution
import com.highthunder.kotlr.types.content.LinkAttribution
import com.highthunder.kotlr.types.content.PostAttribution
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
    @FromJson
    fun toAttribution(input: AttributionAmalgamation?): Attribution {
        return when (input?.type) {
            PostAttribution.KEY -> input.toPostAttribution()
            LinkAttribution.KEY -> input.toLinkAttribution()
            BlogAttribution.KEY -> input.toBlogAttribution()
            AppAttribution.KEY -> input.toAppAttribution()
            else -> throw JsonDataException("Expected a field of type AttributionAmalgamation but got $input")
        }
    }

    @ToJson
    fun fromAttribution(input: Attribution): AttributionAmalgamation? {
        return when (input) {
            is PostAttribution -> AttributionAmalgamation(input)
            is LinkAttribution -> AttributionAmalgamation(input)
            is BlogAttribution -> AttributionAmalgamation(input)
            is AppAttribution -> AttributionAmalgamation(input)
        }
    }
}
