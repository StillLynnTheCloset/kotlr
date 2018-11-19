package com.highthunder.kotlr

import com.highthunder.kotlr.json.response.blog.*
import com.highthunder.kotlr.json.response.user.UserDashboardWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserFollowingWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserInfoWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.superwrapper.*
import com.highthunder.kotlr.json.wrapper.*
import com.squareup.moshi.Moshi

/**
 * TODO: Documentation
 */
internal fun moshi(): Moshi {
    val step1: Moshi = Moshi
        .Builder()
        .add(ContentAmalgamationAdapter())
        .add(AttributionAmalgamationAdapter())
        .add(TextFormatAmalgamationAdapter())
        .add(BlockLayoutAmalgamationAdapter())
        .add(DisplayModeAmalgamationAdapter())
        .add(NoteDataAmalgamationAdapter())
        .build()
    val step2: Moshi = step1
        .newBuilder()
        .add(ColorsJsonAdapter(step1))
        .add(VideoJsonAdapter(step1))
        .add(UserJsonAdapter(step1))
        .build()
    val step3: Moshi = step2
        .newBuilder()
        .add(PostAmalgamationAdapter())
        .add(MediaWrapperJsonAdapter(step2))
        .add(ThemeWrapperJsonAdapter(step2))
        .add(PlayerWrapperJsonAdapter(step2))
        .add(ContentWrapperJsonAdapter(step2))
        .build()
    return step3.newBuilder()
        .add(BlogAvatarWrapperJsonAdapter(step3))
        .add(BlogDraftsWrapperJsonAdapter(step3))
        .add(BlogFollowersWrapperJsonAdapter(step3))
        .add(BlogFollowingWrapperJsonAdapter(step3))
        .add(BlogInfoWrapperJsonAdapter(step3))
        .add(BlogLikesWrapperJsonAdapter(step3))
        .add(BlogPostsWrapperJsonAdapter(step3))
        .add(BlogQueueWrapperJsonAdapter(step3))
        .add(BlogSubmissionsWrapperJsonAdapter(step3))
        .add(UserInfoWrapperJsonAdapter(step3))
        .add(UserDashboardWrapperJsonAdapter(step3))
        .add(UserLikesWrapperJsonAdapter(step3))
        .add(UserFollowingWrapperJsonAdapter(step3))
        .build()
}