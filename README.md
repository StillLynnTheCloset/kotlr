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
   possible field that the API can return. All requests to the API will
   likewise be backed by classes which clearly document any and all availible
   parameters as well as enforcing any restrictions on the requests, such
   as maximum values or mutually exclusive parameters.
* Support the original (legacy) post format
* Support the new 'blocks' post type, aka the Neue Post Format or NPF.
* Provide any functionality needed to interact with
the Tumblr API, such as APIs to acquire OAuth/XAuth keys in a
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
11. Find/make/port pure Kotlin libraries to replace existing dependencies.
12. Performance improvements and bug fixes, etc.

Development Blog [Here](https://kotlr-development.tumblr.com/)

Please use Kotlr responsibly and follow the
[Tumblr api agreement](https://www.tumblr.com/docs/en/api_agreement).

### Kotlr is NOT maintained by/built by/associated with/endorsed by Tumblr in any way! ###

### How To Use Kotlr ###

There is currently no artifact repository for Gradle/Maven/etc so
for now just clone this repo, run `./gradlew jar`, and then copy
`$project_dir/build/libs/kotlr-$version.jar` into your project's libraries.

You'll need a Tumblr API token and secret. Get those by registering an
app [here](https://www.tumblr.com/oauth/apps).


#### Examples ####

```kotlin
fun minimalExampleExplained() {

    // Class for holding API keys and secrets. Get this from one of the auth mechanisms.
    val key = TumblrUserKey("apiKey", "apiSecret", "userKey", "userSecret")

    // The client which performs all requests, this is similar to Jumblr's `JumblrClient`.
    val client = KotlrAuthenticatedClient(key)

    // All request parameters are strongly typed and any constraints imposed by Tumblr's API, such as
    // required or mutually exclusive parameters, are enforced by the constructor.
    // In this case, only the blog identifier is required.
    val request = RequestBlogLikes(identifier = "kotlr-development")

    // Actually perform the request and get our data from Tumblr.
    // Kotlr offers both `process` and `processBlocking`, the former is a suspending function for use in
    // coroutines, and the latter is not.
    val response: TumblrResponse<ResponseBlogLikes.Body> = client.processBlocking(request)

    // Check out any of the meta information that Tumblr returns such as HTTP success codes.
    val meta: ResponseMetaInfo? = response.meta

    // Get the main meat of the response.
    val body: ResponseBlogLikes.Body = response.getBodyOrThrow()

    // And now we can access Tumblr's actual response, which in this case is composed of
    // a list of some liked posts, a count of the total number of liked posts, and potentially
    // a map of RequestLinks which can encode some generic actions that Tumblr thinks you
    // might like to perform based on the content of this request.
    val totalLikedPosts: Long? = body.totalLiked
    val requestLinks: Map<String, RequestLink>? = body.links
    val postUrl: String? = body.posts?.firstOrNull()?.postUrl

}
```

or, the same example without the fluff:

```kotlin
fun minimalExample() {
    val postUrl: String? = KotlrAuthenticatedClient(SampleUserKey)
        .processBlocking(RequestBlogLikes(identifier = "kotlr-development"))
        .getBodyOrThrow()
        .posts
        ?.firstOrNull()
        ?.postUrl
}
```

##### Auth Examples #####

```kotlin
fun oAuthExample() {
    // Kotlr also makes the process of getting OAuth and XAuth keys easy.

    // Create an authentication flow.
    val flow = OAuthFlow()

    // Get the request url, you'll have to open this in a browser or webview.
    // It will then ask you to login to Tumblr and authorize your app to access your account.
    // Since we aren't using a web based application, the callbackUrl doesn't really matter, so let's
    // just make it example.com.
    val requestUrl: String? = flow.getRequestUrl(SampleAppKey, "example.com")

    // We'll just print this to the console so you can copy and paste it.
    System.out.println(requestUrl)

    // Once you've signed in and been redirected, copy that new url from
    // the browser and drop it into the console.
    val redirectedUrl: String = Scanner(System.`in`).nextLine()

    // Now we just parse that url and use it to complete the authentication process.
    val userKey: TumblrUserKey = flow.parseResponseUrl(redirectedUrl)
    System.out.println(userKey.toString())

}
```

```kotlin
fun xAuthExample() {
    // If you can get Tumblr to give you access to the XAuth API, logging in is even easier!
    val userKey: TumblrUserKey = XAuthFlow().getUserKey(SampleAppKey, "example@example.com", "hunter2")
    System.out.println(userKey.toString())
}
```

### Credits ###
* API Documentation - [Tumblr](https://github.com/tumblr/docs)
* Kotlin - [Jet Brains](https://kotlinlang.org/)
* JSON Serialization - [Moshi](https://github.com/square/moshi)
* OAuth - [Scribe](https://github.com/scribejava/scribejava)
* Continuous Integration - [Travis](https://travis-ci.com/)
