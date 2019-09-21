package com.highthunder.kotlr.exception

import com.github.scribejava.core.model.Response

/**
 * KotlrNetworkException - TODO: Documentation
 *
 * @author highthunder
 * @since 10/23/18
 * @version 1.0.0
 */
class KotlrNetworkException : KotlrException {

    constructor(message: String) : super(message)

    constructor(response: Response) : super(response)
}
