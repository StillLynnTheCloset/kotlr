package com.stilllynnthecloset.kotlr

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.stilllynnthecloset.kotlr.json.response.blog.BlogAvatarWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogBlocksWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogDraftsWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogFollowedByWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogFollowersWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogFollowingWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogInfoWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogLikesWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogNotificationsWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogPostsWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogQueueWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.blog.BlogSubmissionsWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.polls.PollsResultsWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.post.BlogPostNotesWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.post.BlogPostWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.post.CreatePostWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.post.PostsTaggedWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserDashboardWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserFilteredContentWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserFollowWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserFollowingWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserInfoWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserLikeWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.response.user.UserLikesWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.AttributionWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.ColorsJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.ContentWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.MediaWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.RecommendationReasonWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.ThemeWrapperJsonAdapter
import com.stilllynnthecloset.kotlr.json.wrapper.UserJsonAdapter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal object KotlrJsonAdapterFactory : JsonAdapter.Factory {
    private var printDebug: Boolean = false

    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        val adapter = if (type is ParameterizedType) {
            if (printDebug) {
                val types = type.actualTypeArguments.map { it.typeName }
                println("Checking for adapter for parameterized type $type with types $types")
            }
            if (type.rawType.typeName == "com.stilllynnthecloset.kotlr.response.WrapperInterface") {
                when (type.actualTypeArguments.firstOrNull()?.typeName) {
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogAvatar\$Body" ->
                        BlogAvatarWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogDrafts\$Body" ->
                        BlogDraftsWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowedBy\$Body" ->
                        BlogFollowedByWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowers\$Body" ->
                        BlogFollowersWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogFollowing\$Body" ->
                        BlogFollowingWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogInfo\$Body" ->
                        BlogInfoWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogLikes\$Body" ->
                        BlogLikesWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogPosts\$Body" ->
                        BlogPostsWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogQueue\$Body" ->
                        BlogQueueWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogSubmissions\$Body" ->
                        BlogSubmissionsWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogBlocks\$Body" ->
                        BlogBlocksWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.blog.ResponseBlogNotifications\$Body" ->
                        BlogNotificationsWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserInfo\$Body" ->
                        UserInfoWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserDashboard\$Body" ->
                        UserDashboardWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLikes\$Body" ->
                        UserLikesWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserLike\$Body" ->
                        UserLikeWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollow\$Body" ->
                        UserFollowWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFollowing\$Body" ->
                        UserFollowingWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.user.ResponseUserFilteredContent\$Body" ->
                        UserFilteredContentWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.post.ResponsePostsTagged\$Body" ->
                        PostsTaggedWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.post.ResponseCreatePost\$Body" ->
                        CreatePostWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.post.ResponseBlogPostNotes\$Body" ->
                        BlogPostNotesWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.response.type.polls.ResponsePollsResults\$Body" ->
                        PollsResultsWrapperJsonAdapter(moshi)
                    "com.stilllynnthecloset.kotlr.types.Post" ->
                        BlogPostWrapperJsonAdapter(moshi)
                    else -> null
                }
            } else {
                null
            }
        } else {
            if (printDebug) {
                println("Checking for adapter for ${type.typeName}")
            }
            when (type.typeName) {
                "com.stilllynnthecloset.kotlr.types.Colors" -> ColorsJsonAdapter(moshi)
                "com.stilllynnthecloset.kotlr.types.User" -> UserJsonAdapter(moshi)
                "com.stilllynnthecloset.kotlr.json.wrapper.MediaWrapper" -> MediaWrapperJsonAdapter(moshi)
                "com.stilllynnthecloset.kotlr.json.wrapper.AttributionWrapper" -> AttributionWrapperJsonAdapter(moshi)
                "com.stilllynnthecloset.kotlr.json.wrapper.ThemeWrapper" -> ThemeWrapperJsonAdapter(moshi)
                "com.stilllynnthecloset.kotlr.json.wrapper.ContentWrapper" -> ContentWrapperJsonAdapter(moshi)
                "com.stilllynnthecloset.kotlr.json.wrapper.RecommendationReasonWrapper" -> {
                    RecommendationReasonWrapperJsonAdapter(moshi)
                }
                else -> null
            }
        }

        if (printDebug) {
            println("Returning adapter $adapter")
        }
        return adapter
    }
}
