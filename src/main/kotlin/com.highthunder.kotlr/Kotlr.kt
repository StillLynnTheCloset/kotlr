package com.highthunder.kotlr

import com.highthunder.kotlr.json.qualifier.HexColorJsonAdapter
import com.highthunder.kotlr.json.qualifier.HexColorOctothorpeJsonAdapter
import com.highthunder.kotlr.json.superwrapper.AttributionAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.BlockLayoutAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.ContentAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.DisplayModeAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.NoteDataAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.PostAmalgamationAdapter
import com.highthunder.kotlr.json.superwrapper.TextFormatAmalgamationAdapter
import com.squareup.moshi.Moshi

/**
 * Get an instance of the Moshi JSON parser that is setup to parse all of our data types.
 *
 * This is broken up into four steps because some adapters depend on the existence of
 * other adapters.
 */
internal val moshi: Moshi by lazy {
    return@lazy Moshi
        .Builder()
        .add(ContentAmalgamationAdapter())
        .add(AttributionAmalgamationAdapter())
        .add(TextFormatAmalgamationAdapter())
        .add(BlockLayoutAmalgamationAdapter())
        .add(DisplayModeAmalgamationAdapter())
        .add(NoteDataAmalgamationAdapter())
        .add(HexColorJsonAdapter())
        .add(HexColorOctothorpeJsonAdapter())
        .add(PostAmalgamationAdapter())
        .add(KotlrJsonAdapterFactory())
        .build()
}
