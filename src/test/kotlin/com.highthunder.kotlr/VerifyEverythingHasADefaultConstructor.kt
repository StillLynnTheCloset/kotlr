package com.highthunder.kotlr

import com.highthunder.kotlr.types.AnsweredAskNotification
import com.highthunder.kotlr.types.AskNotification
import com.highthunder.kotlr.types.AttributionNote
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.BlogTheme
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.ConversationalNoteNotification
import com.highthunder.kotlr.types.ExifData
import com.highthunder.kotlr.types.FollowerNotification
import com.highthunder.kotlr.types.LikeNote
import com.highthunder.kotlr.types.LikeNotification
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.MentionInPostNotification
import com.highthunder.kotlr.types.MentionInReplyNotification
import com.highthunder.kotlr.types.NewGroupBlogMemberNotification
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.PostAppealAcceptedNotification
import com.highthunder.kotlr.types.PostAppealRejectedNotification
import com.highthunder.kotlr.types.PostAttributionNotification
import com.highthunder.kotlr.types.PostFlaggedNotification
import com.highthunder.kotlr.types.PostedNote
import com.highthunder.kotlr.types.ReblogData
import com.highthunder.kotlr.types.ReblogNote
import com.highthunder.kotlr.types.ReblogWithContentNotification
import com.highthunder.kotlr.types.ReblogWithoutContentNotification
import com.highthunder.kotlr.types.RecommendationReason
import com.highthunder.kotlr.types.ReplyNote
import com.highthunder.kotlr.types.ReplyNotification
import com.highthunder.kotlr.types.RequestLink
import com.highthunder.kotlr.types.RequestLinks
import com.highthunder.kotlr.types.RequestQueryParameters
import com.highthunder.kotlr.types.SubmissionTerms
import com.highthunder.kotlr.types.Tag
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.UnknownNotification
import com.highthunder.kotlr.types.User
import com.highthunder.kotlr.types.VideoMetadata
import com.highthunder.kotlr.types.WhatYouMissedNotification
import com.highthunder.kotlr.types.YoutubeVideoMetadata
import com.highthunder.kotlr.types.content.AppAttribution
import com.highthunder.kotlr.types.content.AskBlockLayout
import com.highthunder.kotlr.types.content.AudioContent
import com.highthunder.kotlr.types.content.BlogAttribution
import com.highthunder.kotlr.types.content.BoldTextFormat
import com.highthunder.kotlr.types.content.ColorTextFormat
import com.highthunder.kotlr.types.content.CondensedBlockLayout
import com.highthunder.kotlr.types.content.ImageContent
import com.highthunder.kotlr.types.content.ItalicTextFormat
import com.highthunder.kotlr.types.content.LinkAttribution
import com.highthunder.kotlr.types.content.LinkContent
import com.highthunder.kotlr.types.content.LinkTextFormat
import com.highthunder.kotlr.types.content.MentionTextFormat
import com.highthunder.kotlr.types.content.PostAttribution
import com.highthunder.kotlr.types.content.RowBlockLayout
import com.highthunder.kotlr.types.content.SizeTextFormat
import com.highthunder.kotlr.types.content.StrikeThroughTextFormat
import com.highthunder.kotlr.types.content.TextContent
import com.highthunder.kotlr.types.content.VerticalBlockLayout
import com.highthunder.kotlr.types.content.VideoContent
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
        println(UnknownNotification().toString())
    }
}
