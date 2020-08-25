package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.VideoContent

/**
 * MediaList - An abstraction of a list of media objects because sometimes Tumblr returns a single object and sometimes
 * they return a list of objects. This abstract class hides the fact that there is an underlying class that helps Moshi
 * parse both of these scenarios into a list of objects.
 *
 * This is needed because sometimes [VideoContent] will return either the key-value-pair:
 * "filmstrip": { ... media object ... }
 * or the key-value-pair:
 * "filmstrip": [ { ... media object ... }, { ... media object ... } ]
 * depending on the content.
 *
 */
public abstract class MediaList : List<Media>
