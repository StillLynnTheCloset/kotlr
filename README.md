[![version](https://img.shields.io/static/v1?label=Version&message=0.10.0&color=brightgreen)]()
[![Build Status](https://travis-ci.com/stilllynnthecloset/kotlr.svg?branch=develop)](https://travis-ci.com/stilllynnthecloset/kotlr)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

# Kotlr

It's a portmanteau of Kotlin and Tumblr, [real original, I know...](https://www.reddit.com/r/mAndroidDev/comments/iunvxu/konichiwa/)

Kotlr is a Kotlin library for interacting with the Tumblr(V2) API.
The library is written in pure Kotlin, but does currently have
dependencies on Java libraries, so for the time being, using it is
restricted to the JVM.

## Goals ##

### Create a full API client for Tumblr ###
Implement the entire public API (V2).

### Use typesafe and idiomatic Kotlin
This means that every response, and every object within those responses,
will be represented by a class which will have typed properties for every
possible field that the API has ever returned.

### Support the new 'blocks' post type, aka the Neue Post Format or NPF.
Safely query posts with `npf=true`.

### Provide any functionality needed to interact with the Tumblr API straightforwardly.

Currently, this only includes getting OAuth keys.

## Priorities of Development

1. ~~Add support for all GET request/response types.~~
2. ~~Improve documentation.~~
3. ~~Improve test coverage and make tests more targeted~~.
4. ~~Add support for requests using other HTTP verbs.~~
5. Add support for multi-part form uploads. After this, Kotlr will support all the Tumblr API which will mark version 1.0.0
6. Clean up the API by: restricting visibility, reducing optional and default values, ~~limiting mutability, and enforcing stricter types~~.
7. Create extension library to improve ease of use on Android.
8. Create PoC Android App.
9. ~~Make use of Coroutines to better define blocking api calls.~~
10. Improve error messages/exceptions.
11. Find/make/port pure Kotlin libraries to replace existing JVM bound dependencies.
12. Become completely Kotlin multiplatform.
13. Performance improvements and bug fixes, etc.

Development Blog [Here](https://kotlr-development.tumblr.com/)

Please use Kotlr responsibly and follow the
[Tumblr api agreement](https://www.tumblr.com/docs/en/api_agreement).

### *Kotlr is NOT maintained by/built by/associated with/endorsed by Tumblr in any way!* ###

## How To Use Kotlr ##

First, you'll need a Tumblr API token and secret. Get those by registering an
app [here](https://www.tumblr.com/oauth/apps).

Then you'll need to add Kotlr to you project's dependencies.

This requires setting up your own access token to GitHub and then adding some code to your gradle build files.
See [here](https://docs.github.com/en/free-pro-team@latest/packages/using-github-packages-with-your-projects-ecosystem/configuring-gradle-for-use-with-github-packages) for more info on setting up your token.

### Add Dependencies ###
#### Gradle (build.gradle) ####

Add
```groovy
maven("https://maven.pkg.github.com/StillLynnTheCloset/kotlr") {
    credentials {
        username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
    }
}
```
to your project's `repositories` block.

Then add
```groovy
implementation 'com.stilllynnthecloset:kotlr:0.10.0'
```
to your module's `dependencies` block.

#### Gradle (build.gradle.kts) ####

Add
```kotlin
maven("https://maven.pkg.github.com/StillLynnTheCloset/kotlr") {
    credentials {
        username = (project.findProperty("gpr.user") ?: System.getenv("USERNAME")).toString()
        password = (project.findProperty("gpr.key") ?: System.getenv("TOKEN")).toString()
    }
}
```
to your project's `repositories` block.

Then add
```kotlin
implementation("com.stilllynnthecloset:kotlr:0.10.0")
```
to your module's `dependencies` block.

### Write Code ###
#### Auth Example ####

```kotlin
// Kotlr also makes the process of getting OAuth keys easy.
fun oAuthExample() = runBlocking {

    println("Enter your consumer key:")
    val apiKey: String = Scanner(System.`in`).nextLine()

    println("Enter your consumer secret:")
    val apiSecret: String = Scanner(System.`in`).nextLine()

    // Create an authentication flow.
    val flow = OAuthFlow(TumblrAppKey(apiKey, apiSecret))

    // Get the request url, you'll have to open this in a browser or webview.
    // It will then ask you to login to Tumblr and authorize your app to access your account.
    // Since we aren't using a web based application, the callbackUrl doesn't really matter, so let's
    // just make it example.com.
    val requestUrl: String = flow.getRequestUrl("example.com")

    // We'll just print this to the console, so you can copy and paste it.
    println("Open this url in your browser and sign in")
    println(requestUrl)

    // Once you've signed in and been redirected, copy that new url from
    // the browser and drop it into the console.
    println("Enter the url you were re-directed to:")
    val redirectedUrl: String = Scanner(System.`in`).nextLine()

    // Now we just parse that url and use it to complete the authentication process.
    val userKey: TumblrUserKey = flow.parseResponseUrl(redirectedUrl)
    println(userKey.toString())

    // Print out information about the newly logged-in user.
    println(getApi(userKey).getUserInfo())
}
```

#### Usage Examples ####

```kotlin
// A simple example of how to get the url of a user's most recently liked post.
fun minimalExampleExplained() = runBlocking {
    // Class for holding API keys and secrets.
    // You can get your API key and secret from https://www.tumblr.com/oauth/apps and clicking on "Register Application"
    // They will be called "OAuth Consumer Key" and "Secret Key"
    // User key and user secret have to be acquired through OAuth, see the `oAuthExample` to find how to get them.
    val key = TumblrUserKey("apiKey", "apiSecret", "userKey", "userSecret")

    // The client which performs all requests, this is similar to Jumblr's `JumblrClient`.
    val service = getApi(key)

    // Perform the request.
    val response = service.getBlogLikes(identifier = "kotlr-development")

    // Check out any of the meta information that Tumblr returns such as HTTP success codes.
    val meta: ResponseMetaInfo? = response?.meta
    println(meta)

    // Get the main meat of the response.
    val body: ResponseBlogLikes.Body? = response?.getBody()

    // And now we can access Tumblr's actual response, which in this case is composed of
    // a list of some liked posts, a count of the total number of liked posts, and potentially
    // a map of RequestLinks which can encode some generic actions that Tumblr thinks you
    // might like to perform based on the content of this request.
    val totalLikedPosts: Long? = body?.totalLiked
    println(totalLikedPosts)
    val requestLinks: RequestLinks? = body?.links
    println(requestLinks)
    val postUrl: String? = body?.posts?.firstOrNull()?.postUrl
    println(postUrl)
}
```

or, the same example without the fluff:

```kotlin
fun minimalExample() = runBlocking {
    println(
        getApi(TumblrUserKey("apiKey", "apiSecret", "userKey", "userSecret"))
            .getBlogLikes(identifier = "kotlr-development")
            ?.getBody()
            ?.posts
            ?.firstOrNull()
            ?.postUrl
    )
}
```

## Version History ##

### Version 0.10.0 ###

#### Breaking Changes ####

* Refactor the request APIs to fully separate user facing interfaces and implementation classes

#### New Functionality ####

* Add support for `PostContent` and related `PollAnswer` and `PollSettings`
* Add support for `Notification.SpamReported`
* Add support for `ImageContent.caption`
* Add support for `ImageContent.clickThrough`
* Add support for `RequestQueryParameters.tumblelog`
* Add support for `Post.filteredReason`
* Add support for `Post.postLinks`
* Add support for `Post.interactabilityReblog`
* Add support for `ResponseBlogQueue.state`
* Add support for `Media.video`
* Add support for `Interactability.NoOne`
* Add support for `ResponseBlogBlocks.alreadyBlocked`
* Add support for `Blog.tumblrMartAccessories`
* Add support for `Notification.UserMention`

#### Deprecated Functionality ####

N/A

#### Minor Changes ####

* Separate the codebase into two modules: one that implements the library, and one to be a place to demonstrate functionality.
* Improve documentation
* Fully enforce trailing commas

### 0.9.1 ###

#### Breaking Changes ####

N/A

#### New Functionality ####

N/A

#### Deprecated Functionality ####

N/A

#### Minor Changes ####

* Separated post statuses `Queue` and `Queued`

### 0.9.0 ###

#### Breaking Changes ####

* Change the package name to `com.stilllynnthecloset.kotlr`
* Kotlr now only supports NPF posts, all support for legacy post types has been removed.
* Change the signature of the `POST /blog/*` requests to match other POST requests.
* Add stricter validation on API query parameters.

#### New Functionality ####

* Add support for `Post.genesisPostId`.
* Add support for `Post.isPinned`.
* Add support for `Post.recommendationReason` being either a string or an object.
* Add support for `GET/POST/DELETE /user/filtered_content`.
* Add support for `GET/POST/DELETE /blog/blocks`.
* Add support for `GET /blog/notifications`.
* Add support for `CreateNew/ReblogPostBody.date/isPrivate/slug`.
* Add support for `ReblogPostBody.excludeTrailItems`.
* Add support for `Blog.timezone`.
* Add support for `Blog.timezoneOffset`.
* Add support for `Post.State.Unapproved`.
* Add support for `POST /blog/posts/queue/shuffle`.
* Add support for `POST /blog/posts/queue/reorder`.
* Add support for `GET /tagged`.

#### Deprecated Functionality ####

* Tumblr has marked `RowBlockLayout.rows` as deprecated.

#### Minor Changes ####

* Improve error messages when parsing a response from Tumblr fails.
* Update some dependencies.

### 0.8.3 ###

#### Breaking Changes ####

* Changed my username, so the repo is now hosted at [github.com/StillLynnTheCloset/kotlr](https://github.com/StillLynnTheCloset/kotlr).
* Change the signatures of like/unlike post to use a post body and return a response object.
* Change the signatures of follow/unfollow blog to use a post body and return a response object.

#### New Functionality ####

* Add support for `BlockPost.askingAvatar`.
* Add support for `AnswerPost.askingAvatar`.
* Add support for `LinkAttribution.urlRedirect`.

#### Minor Changes ####

* Make `AskBlockLayout.attribution` more strictly typed to just `BlogAttribution`.
* Update some dependencies.

### 0.8.2 ###

#### Breaking Changes ####
  * None.

#### New Functionality ####

  * None.

#### Minor Changes ####

  * Update dependency resolution system.

### 0.8.1 ###

#### Breaking Changes ####
  * None.

#### New Functionality ####

  * Add support for `RequestQueryParameters.beforeId`.
  * Add support for `Post.recommendationReason`.
  * Add support for `Post.dismissal`.
  * Add support for `Post.serveId`.

#### Minor Changes ####

  * Update readme to show how to add new dependency from GitHub.
  * Update dependency resolution system.
  * Move publishing configuration into `build.gradle.kts`.
  * Actually use `Moshi.failOnUnknown()` during unit tests.

### 0.8.0 ###

#### Breaking Changes ####
  * Update `PhotoContent.exif` to use `ExifData` instead of a `Map`.
  * Update request links to be strongly typed with new classes `RequestLinks` and `RequestQueryParameters`.
  * Update `VideoContent.metadata` to use `VideoMetadata` instead of `Any`.
  * Update `Post.objectType` to be a new `ObjectType` enum.
  * Remove `Post.totalPosts` this seems to have been an old copy/paste mistake.
  * Update `SubmissionTerms.acceptedTypes` to use camelCase and be strongly typed.

#### New Functionality ####

  * Add support for `getPostNotes` API.
  * Add support for `getBlogFollowedBy` API.
  * Add support for many new properties of `ExifData`.

#### Minor Changes ####

  * Add a number of functions that can be easily called from a `fun main()` to perform integration tests.
  * Add a TON of documentation comments.
  * Fix a lot of style warnings.
  * Start using trailing commas everywhere that makes sense.
  * Update Moshi dependency.
  * Start using Shimo for testing.
  * Add ability to output debug info in the Moshi adapter factory.
  * Use `Moshi.failOnUnknown()` during unit tests.

### 0.7.3 ###

  * Test GitHub publish changes.

### 0.7.2 ###

  * Update to Kotlin 1.4 and Gradle 6.6.1.
  * Enable strict API warnings and fix all new warnings (in non-generated code).
  * Update to use the maven-publish plugin and publish to GitHub instead of Bitbucket.
  * Add support for alpha in `Color`.
  * Add support for `Post.isBlurredImages`.
  * Slightly improve documentation.

### 0.7.1 ###

  * Improve handling of re-serializing unknown sub-types.
  * Deprecate the `SizeTextFormat` type.
  * Add support for `SmallTextFormat`, intended to replace `SizeTextFormat`.
  * Add support for `BlockPost.isBlurredImages`.
  * Add support for `BlockPost.originalType`.
  * Add support for `Blog.asksAllowMedia`.
  * Add support for `TextContent.indentLevel`.
  * Add support for `ImageContent.exif`.
  * Slightly improve documentation.

### 0.7.0 ###

  * Switch from using amalgamation types to using a modified version of PolymorphicJsonAdapterFactory.
  * Complete rework of testing system, now samples are stored in separate files and fully tested.
  * Add improved support for various properties that can return as either a list of objects or a single object.
  * Add support for Tumblr's new `id_string` property, even though it is unnecessary for languages with 64-bit longs.
  * Add a Markdown post format.
  * Add the `truncateAfter` property to `CondensedBlockLayout` and deprecate the `blocks` property.
  * Remove the `PostId` class, this should just use a `BlockPost` with only an ID.
  * Add test samples from both the legacy documentation and the NPF documentation.
  * Many small changes.

### 0.6.3 ###

  * Add amalgamation types back in when constructing the amalgamation from a specific type.

### 0.6.2 ###

  * Fix issue when trying to store `Post` classes in Room database.
  * Expose a new helper function `Moshi.Builder.addKotlrTypes` to easily add Kotlr data types' adapters to your own instance of Moshi.

### 0.6.1 ###

  * Add JsonAdapter for `Color`.

### 0.6.0 ###

  * Only fail on unknown JSON properties when `getApi` is called with `debug = true`.
  * Add support for `Blog.avatar` property, this is a list of `Media` objects.
  * Add support for `Post.parentPostId`.
  * Add support for `Post.parentBlogUUID`.

### 0.5.0 ###

  * Add a bunch of new requests including:
    * Create new post (NPF and Legacy post types).
    * Edit post (NPF and Legacy post types).
    * Reblog post (NPF and Legacy post types).
    * Get Post.
    * Follow Blog.
    * Unfollow Blog.
    * Like Post.
    * Unlike Post.
  * Use more `val`s instead of `var`s.
  * Add an object to all API responses containing Tumblr's rate limit headers.
    * Now every API call will tell you how many requests you have left in the hour and in the day.
  * Add support for `Post.objectType`.
  * Add support for `Post.type`.
  * Add support for `Post.blogUUID`.
  * Add support for `Media.cropped`.
  * Add support for `Media.hasOriginalDimensions`.
  * Add support for `Media.colors`.
  * Add support for `TextContent.SubType.Indented`.

### <= 0.4.0 ###

  * Lots of cool stuff.

## Credits ##
* API Documentation - [Tumblr](https://github.com/tumblr/docs)
* Kotlin - [Jet Brains](https://kotlinlang.org/)
* HTTP - [OkHTTP](https://github.com/square/okhttp)
* ReST API Client - [Retrofit](https://github.com/square/retrofit)
* JSON Serialization - [Moshi](https://github.com/square/moshi)
* OAuth - [SignPost](https://github.com/mttkay/signpost)
* Continuous Integration - [Travis](https://travis-ci.com/)
* Hosting - [Github](https://github.com/)

This \[application/service] uses the Tumblr application programming interface but is not endorsed or certified by Tumblr, Inc. All the Tumblr logos and trademarks displayed on this \[application/service] are the property of Tumblr, Inc.
