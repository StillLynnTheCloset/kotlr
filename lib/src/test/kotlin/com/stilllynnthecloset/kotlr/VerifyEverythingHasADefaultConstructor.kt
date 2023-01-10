package com.stilllynnthecloset.kotlr

import com.stilllynnthecloset.kotlr.types.AnsweredAskNotification
import com.stilllynnthecloset.kotlr.types.AskNotification
import com.stilllynnthecloset.kotlr.types.AttributionNote
import com.stilllynnthecloset.kotlr.types.Blog
import com.stilllynnthecloset.kotlr.types.BlogAccessories
import com.stilllynnthecloset.kotlr.types.BlogTheme
import com.stilllynnthecloset.kotlr.types.ClickThrough
import com.stilllynnthecloset.kotlr.types.Colors
import com.stilllynnthecloset.kotlr.types.ConversationalNoteNotification
import com.stilllynnthecloset.kotlr.types.ExifData
import com.stilllynnthecloset.kotlr.types.FilteredReason
import com.stilllynnthecloset.kotlr.types.FollowerNotification
import com.stilllynnthecloset.kotlr.types.LikeNote
import com.stilllynnthecloset.kotlr.types.LikeNotification
import com.stilllynnthecloset.kotlr.types.Media
import com.stilllynnthecloset.kotlr.types.MentionInPostNotification
import com.stilllynnthecloset.kotlr.types.MentionInReplyNotification
import com.stilllynnthecloset.kotlr.types.NewGroupBlogMemberNotification
import com.stilllynnthecloset.kotlr.types.Post
import com.stilllynnthecloset.kotlr.types.PostAppealAcceptedNotification
import com.stilllynnthecloset.kotlr.types.PostAppealRejectedNotification
import com.stilllynnthecloset.kotlr.types.PostAttributionNotification
import com.stilllynnthecloset.kotlr.types.PostFlaggedNotification
import com.stilllynnthecloset.kotlr.types.PostedNote
import com.stilllynnthecloset.kotlr.types.ReblogData
import com.stilllynnthecloset.kotlr.types.ReblogNote
import com.stilllynnthecloset.kotlr.types.ReblogWithContentNotification
import com.stilllynnthecloset.kotlr.types.ReblogWithoutContentNotification
import com.stilllynnthecloset.kotlr.types.RecommendationReason
import com.stilllynnthecloset.kotlr.types.ReplyNote
import com.stilllynnthecloset.kotlr.types.ReplyNotification
import com.stilllynnthecloset.kotlr.types.RequestLink
import com.stilllynnthecloset.kotlr.types.RequestLinks
import com.stilllynnthecloset.kotlr.types.RequestQueryParameters
import com.stilllynnthecloset.kotlr.types.SpamReportedNotification
import com.stilllynnthecloset.kotlr.types.SubmissionTerms
import com.stilllynnthecloset.kotlr.types.Tag
import com.stilllynnthecloset.kotlr.types.Trail
import com.stilllynnthecloset.kotlr.types.UnknownNotification
import com.stilllynnthecloset.kotlr.types.User
import com.stilllynnthecloset.kotlr.types.UserMentionNotification
import com.stilllynnthecloset.kotlr.types.VideoMetadata
import com.stilllynnthecloset.kotlr.types.WhatYouMissedNotification
import com.stilllynnthecloset.kotlr.types.YoutubeVideoMetadata
import com.stilllynnthecloset.kotlr.types.content.AppAttribution
import com.stilllynnthecloset.kotlr.types.content.AskBlockLayout
import com.stilllynnthecloset.kotlr.types.content.AudioContent
import com.stilllynnthecloset.kotlr.types.content.BlogAttribution
import com.stilllynnthecloset.kotlr.types.content.BoldTextFormat
import com.stilllynnthecloset.kotlr.types.content.ColorTextFormat
import com.stilllynnthecloset.kotlr.types.content.CondensedBlockLayout
import com.stilllynnthecloset.kotlr.types.content.ImageContent
import com.stilllynnthecloset.kotlr.types.content.ItalicTextFormat
import com.stilllynnthecloset.kotlr.types.content.LinkAttribution
import com.stilllynnthecloset.kotlr.types.content.LinkContent
import com.stilllynnthecloset.kotlr.types.content.LinkTextFormat
import com.stilllynnthecloset.kotlr.types.content.MentionTextFormat
import com.stilllynnthecloset.kotlr.types.content.PostAttribution
import com.stilllynnthecloset.kotlr.types.content.RowBlockLayout
import com.stilllynnthecloset.kotlr.types.content.SizeTextFormat
import com.stilllynnthecloset.kotlr.types.content.StrikeThroughTextFormat
import com.stilllynnthecloset.kotlr.types.content.TextContent
import com.stilllynnthecloset.kotlr.types.content.VerticalBlockLayout
import com.stilllynnthecloset.kotlr.types.content.VideoContent
import org.junit.Test

/**
 * In the past I have forgotten to add default values for new fields.
 * This test will prevent that from happening. Assuming that I remember to add tests for new classes...
 */
internal class VerifyEverythingHasADefaultConstructor {
    @Test
    internal fun constructEverything() {
        println(PostAttribution().toString())
        println(LinkAttribution().toString())
        println(BlogAttribution().toString())
        println(AppAttribution().toString())
        println(VerticalBlockLayout().toString())
        println(RowBlockLayout().toString())
        println(RowBlockLayout.Display().toString())
        println(RowBlockLayout.Display.Mode.Weighted().toString())
        println(RowBlockLayout.Display.Mode.Carousel().toString())
        println(CondensedBlockLayout().toString())
        println(AskBlockLayout().toString())
        println(AudioContent().toString())
        println(ImageContent().toString())
        println(LinkContent().toString())
        println(TextContent().toString())
        println(VideoContent().toString())
        println(BoldTextFormat().toString())
        println(ItalicTextFormat().toString())
        println(StrikeThroughTextFormat().toString())
        println(LinkTextFormat().toString())
        println(MentionTextFormat().toString())
        println(ColorTextFormat().toString())
        println(SizeTextFormat().toString())
        println(ExifData().toString())
        println(VideoMetadata().toString())
        println(YoutubeVideoMetadata().toString())
        println(Post().toString())
        println(Blog().toString())
        println(BlogTheme().toString())
        println(Colors().toString())
        println(Media().toString())
        println(ReblogData().toString())
        println(RequestLink().toString())
        println(RequestLinks().toString())
        println(RequestQueryParameters().toString())
        println(SubmissionTerms().toString())
        println(Tag().toString())
        println(Trail().toString())
        println(User().toString())
        println(LikeNote().toString())
        println(PostedNote().toString())
        println(ReblogNote().toString())
        println(ReplyNote().toString())
        println(AttributionNote().toString())
        println(RecommendationReason().toString())
        println(LikeNotification().toString())
        println(ReplyNotification().toString())
        println(FollowerNotification().toString())
        println(MentionInReplyNotification().toString())
        println(MentionInPostNotification().toString())
        println(ReblogWithoutContentNotification().toString())
        println(ReblogWithContentNotification().toString())
        println(AskNotification().toString())
        println(AnsweredAskNotification().toString())
        println(NewGroupBlogMemberNotification().toString())
        println(PostAttributionNotification().toString())
        println(PostFlaggedNotification().toString())
        println(PostAppealAcceptedNotification().toString())
        println(PostAppealRejectedNotification().toString())
        println(WhatYouMissedNotification().toString())
        println(ConversationalNoteNotification().toString())
        println(SpamReportedNotification().toString())
        println(UserMentionNotification().toString())
        println(UnknownNotification().toString())
        println(ClickThrough().toString())
        println(FilteredReason().toString())
        println(BlogAccessories().toString())
    }
}
