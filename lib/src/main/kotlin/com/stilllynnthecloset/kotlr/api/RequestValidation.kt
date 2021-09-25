package com.stilllynnthecloset.kotlr.api

internal fun validateBlogIdentifier(blogIdentifier: String) {
    require(blogIdentifier.isNotBlank()) { "Blog identifiers must not be blank." }
}

internal fun validatePostId(postId: Long?) {
    require(postId == null || postId >= 0) { "Post ids must not be less than 0." }
}

internal fun validatePagingLimit(limit: Int?) {
    require(limit == null || limit in 1..50) { "Paging limit must be in the range [1,50]." }
}

internal fun validatePagingOffset(offset: Long?) {
    require(offset == null || offset >= 0) { "Paging offset must be non-negative." }
}

internal fun validatePageNumber(pageNumber: Int?) {
    require(pageNumber == null || pageNumber >= 0) { "Page number must be non-negative." }
}

internal fun validateReblogKey(reblogKey: String?) {
    require(reblogKey == null || reblogKey.isNotBlank()) { "Reblog key must not be blank." }
}

internal fun validateReblogsAndNotes(reblogFields: Boolean?, notesHistory: Boolean?) {
    require(reblogFields == null || notesHistory == null || reblogFields xor notesHistory) {
        "Only one of reblog fields or notes history can be provided."
    }
}

internal fun validateUrlAndEmail(url: String?, email: String?) {
    require((url.isNullOrBlank()) xor (email.isNullOrBlank())) { "Only one of url or email can be provided." }
}

internal fun validateTag(tag: String?) {
    require(tag == null || tag.isNotBlank()) { "Tags must not be blank." }
}

internal fun validateContentFilter(contentFilter: String?) {
    require(contentFilter == null || contentFilter.isNotBlank()) {
        "Content filters must not be blank."
    }
    require(contentFilter == null || contentFilter.length <= 250) {
        "Content filters must not be more than 250 characters in length."
    }
}

internal fun validateTimestamp(timestamp: Long?) {
    // TODO: Decide if there is any reasonable validation for times.
}

private val validAvatarSizes = listOf(16, 24, 30, 40, 48, 64, 96, 128, 512)
internal fun validateAvatarSize(size: Int?) {
    require(size == null || size in validAvatarSizes) { "Size must be one of $validAvatarSizes." }
}
