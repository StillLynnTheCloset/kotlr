package com.stilllynnthecloset.kotlr.json.wrapper

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
import com.squareup.moshi.JsonReader.Token.NULL
import com.squareup.moshi.JsonReader.Token.STRING
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.stilllynnthecloset.kotlr.KotlrJsonAdapterFactory
import com.stilllynnthecloset.kotlr.adapter
import com.stilllynnthecloset.kotlr.types.RecommendationReason

/**
 * RecommendationReasonWrapperJsonAdapter - An adapter to help Moshi convert [RecommendationReasonWrapper] objects to and
 * from either a [RecommendationReason] object, or a [String].
 *
 * @author StillLynnTheCloset
 * @since 2021-05-29
 */
internal class RecommendationReasonWrapperJsonAdapter(moshi: Moshi) : JsonAdapter<RecommendationReasonWrapper>() {
    private val recommendationAdapter: JsonAdapter<RecommendationReason?> =
        moshi.nextAdapter(KotlrJsonAdapterFactory, RecommendationReason::class.java, emptySet())

    private val stringAdapter: JsonAdapter<String> = moshi.adapter()

    @FromJson
    override fun fromJson(reader: JsonReader): RecommendationReasonWrapper? {
        return when (reader.peek()) {
            BEGIN_OBJECT -> RecommendationReasonWrapper(recommendationObject = recommendationAdapter.fromJson(reader))
            STRING -> RecommendationReasonWrapper(recommendationString = stringAdapter.fromJson(reader))
            NULL -> null
            else -> {
                throw JsonDataException(
                    "Expected a field of type RecommendationReason or String but got ${reader.peek()}",
                )
            }
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: RecommendationReasonWrapper?) {
        when {
            value == null -> recommendationAdapter.toJson(writer, null)
            value.recommendationObject != null -> recommendationAdapter.toJson(writer, value.recommendationObject)
            value.recommendationString != null -> recommendationAdapter.toJson(writer, value.recommendationObject)
            else -> recommendationAdapter.toJson(writer, null)
        }
    }
}
