[![version](https://img.shields.io/static/v1?label=Version&message=0.6.0&color=brightgreen)]()
[![Build Status](https://travis-ci.com/highthunder/kotlr.svg?branch=master)](https://travis-ci.com/highthunder/kotlr)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

# Kotlr

Its a portmanteau of Kotlin and Tumblr

Kotlr is a Kotlin library for interacting with the Tumblr(V2) API.
The library is written in pure Kotlin, but does currently have
dependencies on Java libraries, so, for the time being, it's use is
restricted to the JVM.

### Goals ###

* Create a full API client for Tumblr
* Use typesafe and idiomatic Kotlin

   This means that every response, and every object within those responses,
   will be represented by a class which will have typed properties for every
   possible field that the API can return.
* Support the original (legacy) post format
* Support the new 'blocks' post type, aka the Neue Post Format or NPF.
* Provide any functionality needed to interact with
the Tumblr API, such as APIs to acquire OAuth keys in a
(hopefully) straightforward manner.

The priorities of development right now are:

1. ~~Add support for all GET request/response types.~~
2. Improve documentation.
3. Improve test coverage and make tests more targeted.
4. Add support for requests using other HTTP verbs.
5. Add support for mutlipart form uploads. After this Kotlr will support all of the Tumblr API which will mark version 1.0.0
6. Clean up the API by: restricting visibility, reducing optional and default values, limiting mutablity, and enforcing stricter types.
7. Create extension library to improve ease of use on Android.
8. Create PoC Android App.
9. ~~Make use of Coroutines to better define blocking api calls.~~
10. Improve error messages/exceptions.
11. Find/make/port pure Kotlin libraries to replace existing JVM bound dependencies.
12. Performance improvements and bug fixes, etc.

Development Blog [Here](https://kotlr-development.tumblr.com/)

Please use Kotlr responsibly and follow the
[Tumblr api agreement](https://www.tumblr.com/docs/en/api_agreement).

### Kotlr is NOT maintained by/built by/associated with/endorsed by Tumblr in any way! ###

### How To Use Kotlr ###

First, you'll need a Tumblr API token and secret. Get those by registering an
app [here](https://www.tumblr.com/oauth/apps).

Then you'll need to add Kotlr to you project's dependencies.

##### Gradle (build.gradle) #####

Add
```groovey
maven { url 'https://api.bitbucket.org/2.0/repositories/teamhighthunder/highthundermavenrepository/src/releases' }
```
to your project's `repositories` block.

Then add
```groovy
implementation 'com.highthunder:kotlr:0.3.0'
```
to your module's `dependencies` block.

##### Gradle (build.gradle.kts) #####

Add
```kotlin
maven(url = "https://api.bitbucket.org/2.0/repositories/teamhighthunder/highthundermavenrepository/src/releases")
```
to your project's `repositories` block.

Then add
```kotlin
implementation("com.highthunder:kotlr:0.4.0")
```
to your module's `dependencies` block.

##### Auth Example #####

```kotlin
suspend fun oAuthExample() {
    // Kotlr also makes the process of getting OAuth and XAuth keys easy.

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
    val requestUrl: String? = flow.getRequestUrl("example.com")

    // We'll just print this to the console so you can copy and paste it.
    println("Open this url in your browser and sign in")
    println(requestUrl)

    // Once you've signed in and been redirected, copy that new url from
    // the browser and drop it into the console.
    println("Enter the url you were re-directed to:")
    val redirectedUrl: String = Scanner(System.`in`).nextLine()

    // Now we just parse that url and use it to complete the authentication process.
    val userKey: TumblrUserKey = flow.parseResponseUrl(redirectedUrl)
    println(userKey.toString())

    // Print out information about the newly logged in user.
    println(getApi(userKey).getUserInfo())
}
```

#### Examples ####

```kotlin
suspend fun minimalExampleExplained() {
    // Class for holding API keys and secrets. Get this from one of the auth mechanisms.
    val key = TumblrUserKey("apiKey", "apiSecret", "userKey", "userSecret")

    // The client which performs all requests, this is similar to Jumblr's `JumblrClient`.
    val service = getApi(key)

    // Perform the request.
    val response = service.getBlogLikes(identifier = "kotlr-development")

    // Check out any of the meta information that Tumblr returns such as HTTP success codes.
    val meta: ResponseMetaInfo? = response?.meta

    // Get the main meat of the response.
    val body: ResponseBlogLikes.Body? = response?.getBody()

    // And now we can access Tumblr's actual response, which in this case is composed of
    // a list of some liked posts, a count of the total number of liked posts, and potentially
    // a map of RequestLinks which can encode some generic actions that Tumblr thinks you
    // might like to perform based on the content of this request.
    val totalLikedPosts: Long? = body?.totalLiked
    val requestLinks: Map<String, RequestLink>? = body?.links
    val postUrl: String? = body?.posts?.firstOrNull()?.postUrl
}
```

or, the same example without the fluff:

```kotlin
suspend fun minimalExample() {
    val postUrl: String? = getApi(SampleUserKey)
        .getBlogLikes(identifier = "kotlr-development")
        ?.getBody()
        ?.posts
        ?.firstOrNull()
        ?.postUrl
}
```

### Version History ###

#### 0.6.0 ####

  * Only fail on unknown JSON properties when `getApi` is called with `debug = true`
  * Add support for Blog.avatar property, this is a list of `Media` objects
  * Add support for Post.parentPostId
  * Add support for Post.parentBlogUUID

#### 0.5.0 ####

  * Add a bunch of new requests including:
    * Create new post (NPF and Legacy post types)
    * Edit post (NPF and Legacy post types)
    * Reblog post (NPF and Legacy post types)
    * Get Post
    * Follow Blog
    * Unfollow Blog
    * Like Post
    * Unlike Post
  * Use more `val`s instead of `var`s
  * Add an object to all API responses containing Tumblr's rate limit headers
    * Now every API call will tell you how many requests you have left in the hour and in the day.
  * Add support for Post.objectType
  * Add support for Post.type
  * Add support for Post.blogUUID
  * Add support for Media.cropped
  * Add support for Media.hasOriginalDimensions
  * Add support for Media.colors
  * Add support for TextContent.SubType.Indented

#### <= 0.4.0 ####

  * Lots of cool stuff

### Credits ###
* API Documentation - [Tumblr](https://github.com/tumblr/docs)
* Kotlin - [Jet Brains](https://kotlinlang.org/)
* HTTP - [OkHTTP](https://github.com/square/okhttp)
* ReST API Client - [Retrofit](https://github.com/square/retrofit)
* JSON Serialization - [Moshi](https://github.com/square/moshi)
* OAuth - [SignPost](https://github.com/mttkay/signpost)
* Continuous Integration - [Travis](https://travis-ci.com/)


This [application/service] uses the Tumblr application programming interface but is not endorsed or certified by Tumblr, Inc. All of the Tumblr logos and trademarks displayed on this [application/service] are the property of Tumblr, Inc.
