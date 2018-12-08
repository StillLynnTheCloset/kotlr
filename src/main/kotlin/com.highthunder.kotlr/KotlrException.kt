package com.highthunder.kotlr

import com.github.scribejava.core.model.Response

/**
 * KotlrException - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
open class KotlrException : RuntimeException {

    constructor(message: String)

    constructor(response: Response)

}
