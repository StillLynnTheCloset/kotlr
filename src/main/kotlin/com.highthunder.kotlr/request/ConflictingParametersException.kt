package com.highthunder.kotlr.request

import java.lang.Exception

/**
 * ConflictingParametersException - TODO: Documentation
 *
 * @author highthunder
 * @since 10/27/18
 * @version 1.0.0
 */
class ConflictingParametersException : Exception {
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
    constructor(message: String, cause: Throwable) : super(message, cause)
}
