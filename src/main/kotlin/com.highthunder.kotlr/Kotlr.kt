package com.highthunder.kotlr

import com.highthunder.kotlr.json.response.BlogLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.response.UserDashboardWrapperJsonAdapter
import com.highthunder.kotlr.json.response.UserInfoWrapperJsonAdapter
import com.highthunder.kotlr.json.response.UserLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.superwrapper.*
import com.highthunder.kotlr.json.wrapper.*
import com.squareup.moshi.Moshi

object Kotlr {

    fun getMoshi(): Moshi {
        val step1: Moshi = Moshi
                .Builder()
                .add(ContentJsonAdapter())
                .add(AttributionJsonAdapter())
                .add(FormatJsonAdapter())
                .add(LayoutJsonAdapter())
                .add(DisplayModeJsonAdapter())
                .add(NoteJsonAdapter())
                .build()
        val step2: Moshi = step1
                .newBuilder()
                .add(VideoJsonAdapter(step1))
                .build()
        val step3: Moshi = step2
                .newBuilder()
                .add(PostJsonAdapter())
                .add(MediaWrapperJsonAdapter(step2))
                .add(ThemeWrapperJsonAdapter(step2))
                .add(PlayerWrapperJsonAdapter(step2))
                .add(ContentWrapperJsonAdapter(step2))
                .build()
        return step3.newBuilder()
                .add(BlogLikesWrapperJsonAdapter(step3))
                .add(UserInfoWrapperJsonAdapter(step3))
                .add(UserDashboardWrapperJsonAdapter(step3))
                .add(UserLikesWrapperJsonAdapter(step3))
                .build()
    }

}
