package com.highthunder.kotlr

import com.github.scribejava.core.model.Response

/**
 * KotlrParsingException - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */

class KotlrParsingException : KotlrException {

    constructor(message: String) : super(message)

    constructor(response: Response) : super(response)

}
