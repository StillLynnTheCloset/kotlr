package com.highthunder.kotlr.json.wrapper

import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.User
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * UserJsonAdapter - A custom adapter to help Moshi parse [User] objects.
 *
 * This is necessary because depending on the circumstances, the [User.following] property can either be a boolean
 * representing if you are following that user, or an int of the number of blogs that this user follows.
 *
 * @author highthunder
 * @since 2018-11-10
 * @version 1.0.0
 */
internal class UserJsonAdapter(moshi: Moshi) : JsonAdapter<User>() {
    private val options: JsonReader.Options =
        JsonReader.Options.of("blogs", "name", "following", "url", "updated", "likes", "default_post_format")

    private val nullableListOfBlogAdapter: JsonAdapter<List<Blog>?> =
        moshi.adapter(
            Types.newParameterizedType(List::class.java, Blog::class.java),
            emptySet(),
            "blogs"
        )

    private val nullableStringAdapter: JsonAdapter<String?> =
        moshi.adapter(String::class.java, emptySet(), "name")

    private val nullableIntAdapter: JsonAdapter<Int?> =
        moshi.adapter(Int::class.javaObjectType, emptySet(), "totalFollowing")

    private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
        moshi.adapter(Boolean::class.javaObjectType, emptySet(), "isUserFollowed")

    private val nullableLongAdapter: JsonAdapter<Long?> =
        moshi.adapter(Long::class.javaObjectType, emptySet(), "updated")

    private val nullablePostFormatAdapter: JsonAdapter<Post.PostFormat?> =
        moshi.adapter(Post.PostFormat::class.java, emptySet(), "defaultPostFormat")

    override fun toString(): String = "GeneratedJsonAdapter(User)"

    @FromJson
    override fun fromJson(reader: JsonReader): User {
        var blogs: List<Blog>? = null
        var blogsSet = false
        var name: String? = null
        var nameSet = false
        var totalFollowing: Int? = null
        var totalFollowingSet = false
        var isUserFollowed: Boolean? = null
        var isUserFollowedSet = false
        var url: String? = null
        var urlSet = false
        var updated: Long? = null
        var updatedSet = false
        var likes: Int? = null
        var likesSet = false
        var defaultPostFormat: Post.PostFormat? = null
        var defaultPostFormatSet = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> {
                    blogs = nullableListOfBlogAdapter.fromJson(reader)
                    blogsSet = true
                }
                1 -> {
                    name = nullableStringAdapter.fromJson(reader)
                    nameSet = true
                }
                2 -> {
                    if (reader.peek() == JsonReader.Token.NUMBER) {
                        totalFollowing = nullableIntAdapter.fromJson(reader)
                        totalFollowingSet = true
                    } else {
                        isUserFollowed = nullableBooleanAdapter.fromJson(reader)
                        isUserFollowedSet = true
                    }
                }
                3 -> {
                    url = nullableStringAdapter.fromJson(reader)
                    urlSet = true
                }
                4 -> {
                    updated = nullableLongAdapter.fromJson(reader)
                    updatedSet = true
                }
                5 -> {
                    likes = nullableIntAdapter.fromJson(reader)
                    likesSet = true
                }
                6 -> {
                    defaultPostFormat = nullablePostFormatAdapter.fromJson(reader)
                    defaultPostFormatSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = User()
        result = result.copy(
            blogs = if (blogsSet) blogs else result.blogs,
            name = if (nameSet) name else result.name,
            totalFollowing = if (totalFollowingSet) totalFollowing else result.totalFollowing,
            isUserFollowed = if (isUserFollowedSet) isUserFollowed else result.isUserFollowed,
            url = if (urlSet) url else result.url,
            updated = if (updatedSet) updated else result.updated,
            likes = if (likesSet) likes else result.likes,
            defaultPostFormat = if (defaultPostFormatSet) defaultPostFormat else result.defaultPostFormat
        )
        return result
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: User?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("blogs")
        nullableListOfBlogAdapter.toJson(writer, value.blogs)
        writer.name("name")
        nullableStringAdapter.toJson(writer, value.name)
        if (value.totalFollowing != null) {
            writer.name("following")
            nullableIntAdapter.toJson(writer, value.totalFollowing)
        } else {
            writer.name("following")
            nullableBooleanAdapter.toJson(writer, value.isUserFollowed)
        }
        writer.name("url")
        nullableStringAdapter.toJson(writer, value.url)
        writer.name("updated")
        nullableLongAdapter.toJson(writer, value.updated)
        writer.name("likes")
        nullableIntAdapter.toJson(writer, value.likes)
        writer.name("default_post_format")
        nullablePostFormatAdapter.toJson(writer, value.defaultPostFormat)
        writer.endObject()
    }
}
