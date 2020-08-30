package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.BlogTheme
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

/**
 * ThemeWrapperJsonAdapter - An adapter to help Moshi convert [ThemeWrapper] objects to and
 * from either a single [BlogTheme] object, or a list of them.
 *
 * @author highthunder
 * @since 2018-11-04
 * @version 1.0.0
 */
internal class ThemeWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<ThemeWrapper>() {

    private val themeAdapter: JsonAdapter<BlogTheme?> =
        moshi.adapter(BlogTheme::class.java, kotlin.collections.emptySet(), null)

    private val listOfThemeAdapter: JsonAdapter<List<BlogTheme>> =
        moshi.adapter<List<BlogTheme>>(
            Types.newParameterizedType(List::class.java, BlogTheme::class.java),
            kotlin.collections.emptySet(),
            null
        )

    @FromJson
    override fun fromJson(reader: JsonReader): ThemeWrapper {
        return when (reader.peek()) {
            BEGIN_ARRAY -> ThemeWrapper(listOfThemes = listOfThemeAdapter.fromJson(reader))
            BEGIN_OBJECT -> ThemeWrapper(singleTheme = themeAdapter.fromJson(reader))
            NULL -> ThemeWrapper()
            else -> throw JsonDataException("Expected a field of type List or BlogTheme but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: ThemeWrapper?) {
        if (value?.singleTheme != null) {
            themeAdapter.toJson(writer, value.singleTheme)
        } else {
            listOfThemeAdapter.toJson(writer, value?.listOfThemes ?: listOf())
        }
    }
}
