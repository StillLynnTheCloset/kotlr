package com.stilllynnthecloset.kotlr.json.wrapper

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
import com.stilllynnthecloset.kotlr.types.BlogTheme

/**
 * ThemeWrapperJsonAdapter - An adapter to help Moshi convert [ThemeWrapper] objects to and
 * from either a single [BlogTheme] object, or a list of them.
 *
 * @author StillLynnTheCloset
 * @since 2018-11-04
 */
internal class ThemeWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<ThemeWrapper>() {

    private val themeAdapter: JsonAdapter<BlogTheme?> =
        moshi.adapter(BlogTheme::class.java, emptySet(), null)

    private val listOfThemeAdapter: JsonAdapter<List<BlogTheme>> =
        moshi.adapter(
            Types.newParameterizedType(List::class.java, BlogTheme::class.java),
            emptySet(),
            null,
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
