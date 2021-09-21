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
import com.stilllynnthecloset.kotlr.adapter
import com.stilllynnthecloset.kotlr.listAdapter
import com.stilllynnthecloset.kotlr.types.content.Attribution

/**
 * AttributionWrapperJsonAdapter - An adapter to help Moshi convert [AttributionWrapper] objects to and
 * from either a single [Attribution] object, or a list of them.
 *
 * @author highthunder
 * @since 2020-03-21
 */
internal class AttributionWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<AttributionWrapper>() {

    private val attributionAdapter: JsonAdapter<Attribution?> = moshi.adapter()

    private val listOfAttributionAdapter: JsonAdapter<List<Attribution>> = moshi.listAdapter()

    @FromJson
    override fun fromJson(reader: JsonReader): AttributionWrapper? {
        return when (reader.peek()) {
            BEGIN_ARRAY -> AttributionWrapper(listAttribution = listOfAttributionAdapter.fromJson(reader).orEmpty())
            BEGIN_OBJECT -> AttributionWrapper(singleAttribution = attributionAdapter.fromJson(reader))
            NULL -> null
            else -> throw JsonDataException("Expected a field of type List or Attribution but got ${reader.peek()}")
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: AttributionWrapper?) {
        when {
            value == null -> attributionAdapter.toJson(writer, null)
            value.singleAttribution != null -> attributionAdapter.toJson(writer, value.singleAttribution)
            value.listAttribution.isNotEmpty() -> listOfAttributionAdapter.toJson(writer, value.listAttribution)
            else -> attributionAdapter.toJson(writer, null)
        }
    }
}
