package com.highthunder.kotlr

import com.highthunder.kotlr.types.AttributionNote
import com.highthunder.kotlr.types.BlockPost
import com.highthunder.kotlr.types.Blog
import com.highthunder.kotlr.types.BlogTheme
import com.highthunder.kotlr.types.Colors
import com.highthunder.kotlr.types.LikeNote
import com.highthunder.kotlr.types.Media
import com.highthunder.kotlr.types.PostedNote
import com.highthunder.kotlr.types.ReblogData
import com.highthunder.kotlr.types.ReblogNote
import com.highthunder.kotlr.types.RecommendationReason
import com.highthunder.kotlr.types.ReplyNote
import com.highthunder.kotlr.types.RequestLink
import com.highthunder.kotlr.types.RequestLinks
import com.highthunder.kotlr.types.RequestQueryParameters
import com.highthunder.kotlr.types.SubmissionTerms
import com.highthunder.kotlr.types.Tag
import com.highthunder.kotlr.types.Trail
import com.highthunder.kotlr.types.User
import com.highthunder.kotlr.types.VideoMetadata
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
import com.highthunder.kotlr.types.legacy.AnswerPost
import com.highthunder.kotlr.types.legacy.AudioPost
import com.highthunder.kotlr.types.legacy.ChatPost
import com.highthunder.kotlr.types.legacy.Dialogue
import com.highthunder.kotlr.types.legacy.ExifData
import com.highthunder.kotlr.types.legacy.LinkPost
import com.highthunder.kotlr.types.legacy.Photo
import com.highthunder.kotlr.types.legacy.PhotoPost
import com.highthunder.kotlr.types.legacy.PhotoSize
import com.highthunder.kotlr.types.legacy.QuotePost
import com.highthunder.kotlr.types.legacy.TextPost
import com.highthunder.kotlr.types.legacy.Video
import com.highthunder.kotlr.types.legacy.VideoPost
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
        println(AnswerPost().toString())
        println(AudioPost().toString())
        println(ChatPost().toString())
        println(LinkPost().toString())
        println(PhotoPost().toString())
        println(QuotePost().toString())
        println(TextPost().toString())
        println(VideoPost().toString())
        println(Dialogue().toString())
        println(ExifData().toString())
        println(Photo().toString())
        println(PhotoSize().toString())
        println(Video().toString())
        println(VideoMetadata().toString())
        println(YoutubeVideoMetadata().toString())
        println(BlockPost().toString())
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
    }
}
