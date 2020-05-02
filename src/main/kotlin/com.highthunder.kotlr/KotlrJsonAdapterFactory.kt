package com.highthunder.kotlr

import com.highthunder.kotlr.json.response.blog.BlogAvatarWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogDraftsWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogFollowersWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogFollowingWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogInfoWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogPostsWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogQueueWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogSubmissionsWrapperJsonAdapter
import com.highthunder.kotlr.json.response.post.CreatePostWrapperJsonAdapter
import com.highthunder.kotlr.json.response.post.PostsPostWrapperJsonAdapter
import com.highthunder.kotlr.json.response.post.PostsTaggedWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserDashboardWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserFollowingWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserInfoWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.AttributionWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.ColorsJsonAdapter
import com.highthunder.kotlr.json.wrapper.ContentWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.MediaWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.PlayerWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.ThemeWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.UserJsonAdapter
import com.highthunder.kotlr.json.wrapper.VideoJsonAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class KotlrJsonAdapterFactory : JsonAdapter.Factory {
    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        return if (type is ParameterizedType) {
            if (type.rawType.typeName == "com.highthunder.kotlr.response.WrapperInterface") {
                when (type.actualTypeArguments.firstOrNull()?.typeName) {
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogAvatar\$Body" ->
                        BlogAvatarWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogDrafts\$Body" ->
                        BlogDraftsWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogFollowers\$Body" ->
                        BlogFollowersWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogFollowing\$Body" ->
                        BlogFollowingWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogInfo\$Body" ->
                        BlogInfoWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogLikes\$Body" ->
                        BlogLikesWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogPosts\$Body" ->
                        BlogPostsWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogQueue\$Body" ->
                        BlogQueueWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.blog.ResponseBlogSubmissions\$Body" ->
                        BlogSubmissionsWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.user.ResponseUserInfo\$Body" ->
                        UserInfoWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.user.ResponseUserDashboard\$Body" ->
                        UserDashboardWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.user.ResponseUserLikes\$Body" ->
                        UserLikesWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.user.ResponseUserFollowing\$Body" ->
                        UserFollowingWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.post.ResponsePostsTagged\$Body" ->
                        PostsTaggedWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.response.type.post.ResponseCreatePost\$Body" ->
                        CreatePostWrapperJsonAdapter(moshi)
                    "com.highthunder.kotlr.types.Post" ->
                        PostsPostWrapperJsonAdapter(moshi)
                    else -> null
                }
            } else {
                null
            }
        } else {
            when (type.typeName) {
                "com.highthunder.kotlr.types.Colors" -> ColorsJsonAdapter(moshi)
                "com.highthunder.kotlr.types.legacy.Video" -> VideoJsonAdapter(moshi)
                "com.highthunder.kotlr.types.User" -> UserJsonAdapter(moshi)
                "com.highthunder.kotlr.json.wrapper.MediaWrapper" -> MediaWrapperJsonAdapter(moshi)
                "com.highthunder.kotlr.json.wrapper.AttributionWrapper" -> AttributionWrapperJsonAdapter(moshi)
                "com.highthunder.kotlr.json.wrapper.ThemeWrapper" -> ThemeWrapperJsonAdapter(moshi)
                "com.highthunder.kotlr.json.wrapper.PlayerWrapper" -> PlayerWrapperJsonAdapter(moshi)
                "com.highthunder.kotlr.json.wrapper.ContentWrapper" -> ContentWrapperJsonAdapter(moshi)
                else -> null
            }
        }
    }
}
