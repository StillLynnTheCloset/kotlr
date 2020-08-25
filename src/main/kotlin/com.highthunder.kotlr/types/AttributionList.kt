package com.highthunder.kotlr.types

import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.ImageContent

/**
 * AttributionList - An abstraction of a list of attribution objects because sometimes Tumblr returns a single object and sometimes
 * they return a list of objects. This abstract class hides the fact that there is an underlying class that helps Moshi
 * parse both of these scenarios into a list of objects.
 *
 * This is needed because sometimes [ImageContent] will return either the key-value-pair:
 * "attribution": { ... attribution object ... }
 * or the key-value-pair:
 * "attribution": [ { ... attribution object ... }, { ... attribution object ... } ]
 * depending on the content.
 *
 */
public abstract class AttributionList : List<Attribution>
