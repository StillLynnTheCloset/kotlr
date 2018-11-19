package com.highthunder.kotlr

/**
 * Sample - A bunch of sample json objects to test parsing.
 *
 * TODO: Simplify the samples to limit what is being tested.
 *
 * @author highthunder
 * @since 10/20/18
 * @version 1.0.0
 */
@Suppress("SpellCheckingInspection")
object Sample {

    // region Attribution samples

    const val postAttribution: String = """{
        "type": "post",
        "url": "http://www.davidslog.com/153957802620/five-years-of-working-with-this-awesome-girl",
        "post": {
            "id": 1234567890
        },
        "blog": {
            "uuid": "t:123456abcdf",
            "name": "david",
            "url": "https://davidslog.com/"
        }
    }"""

    const val linkAttribution: String = """{
        "type": "link",
        "url": "http://shahkashani.com/"
    }"""

    const val blogAttribution: String = """{
        "type": "blog",
        "blog": {
            "uuid": "t:123456abcdf",
            "name": "david",
            "url": "https://davidslog.com/"
        }
    }"""

    const val appAttribution: String = """{
        "type": "app",
        "url": "https://www.instagram.com/p/BVZyxTklQWX/",
        "app_name": "Instagram",
        "display_text": "tibbythecorgi - Very Cute",
        "logo": {
            "url": "https://scontent.cdninstagram.com/path/to/logo.jpg",
            "type": "image/jpeg",
            "width": 64,
            "height": 64
        }
    }"""

    // endregion

    // region Block Content samples

    const val audioContentTumblr: String = """{
        "type": "audio",
        "provider": "tumblr",
        "title": "Track Title",
        "artist": "Track Artist",
        "album": "Track Album",
        "media": {
            "type": "audio/mp3",
            "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp3"
        },
        "poster": [
            {
                "type": "image/jpeg",
                "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                "width": 500,
                "height": 400
            }
        ]
    }"""

    const val audioContentSoundCloud: String = """{
        "type": "audio",
        "provider": "soundcloud",
        "title": "Mouth Sounds",
        "artist": "neilcic",
        "url": "https://soundcloud.com/neilcic/mouth-sounds",
        "embed_html": "<iframe width=\"100%\" height=\"450\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true\"></iframe>",
        "embed_url": "https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true",
        "media": {
            "type": "audio/mp3",
            "url": "https://soundcloud.com/neilcic/mouth-sounds.mp3"
        },
        "poster": [
            {
                "type": "image/jpeg",
                "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                "width": 500,
                "height": 400
            }
        ]
    }"""

    const val imageContent: String = """{
        "type": "image",
        "media": [
            {
                "type": "image/jpeg",
                "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                "width": 1280,
                "height": 1073
            },
            {
                "type": "image/jpeg",
                "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_540.jpg",
                "width": 540,
                "height": 400
            },
            {
                "type": "image/jpeg",
                "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_250.jpg",
                "width": 250,
                "height": 150
            }
        ]
    }"""

    const val imageContentFeedback: String = """{
        "type": "image",
        "media": [
            {
                "type": "image/gif",
                "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_250.gif",
                "width": 250,
                "height": 200
            }
        ],
        "feedback_token": "abcdef123456"
    }"""

    const val imageContentColors: String = """{
        "type": "image",
        "media": [
            {
                "type": "image/jpeg",
                "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                "width": 1280,
                "height": 1073
            }
        ],
        "colors": {
            "c0": "a24615",
            "c1": "ff7c00"
        }
    }"""

    const val linkContentCreate: String = """{
        "type": "link",
        "url": "https://www.nytimes.com/2017/06/15/us/politics/secrecy-surrounding-senate-health-bill-raises-alarms-in-both-parties.html",
        "title": "Secrecy Surrounding Senate Health Bill Raises Alarms in Both Parties",
        "description": "Senate leaders are writing legislation to repeal and replace the Affordable Care Act without a single hearing on the bill and without an open drafting session.",
        "author": "Thomas Kaplan and Robert Pear",
        "poster": [
            {
                "url": "https://static01.nyt.com/images/2017/06/15/us/politics/15dchealth-2/15dchealth-2-facebookJumbo.jpg",
                "type": "image/jpeg",
                "width": 1050,
                "height": 549
            }
        ]
    }"""

    const val linkContentRead: String = """{
        "type": "link",
        "url": "http://t.umblr.com/redirect?stuff-here",
        "display_url": "https://www.nytimes.com/2017/06/15/us/politics/secrecy-surrounding-senate-health-bill-raises-alarms-in-both-parties.html",
        "title": "Secrecy Surrounding Senate Health Bill Raises Alarms in Both Parties",
        "description": "Senate leaders are writing legislation to repeal and replace the Affordable Care Act without a single hearing on the bill and without an open drafting session.",
        "author": "Thomas Kaplan and Robert Pear",
        "site_name": "nytimes.com",
        "poster": [
            {
                "url": "https://static01.nyt.com/images/2017/06/15/us/politics/15dchealth-2/15dchealth-2-facebookJumbo.jpg",
                "type": "image/jpeg",
                "width": 1050,
                "height": 549
            }
        ]
    }"""

    const val textContentSimple: String = """{
        "type": "text",
        "text": "Hello world!"
    }"""

    const val videoContentTumblr: String = """{
        "type": "video",
        "media": {
            "type": "video/mp4",
            "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp4",
            "height": 640,
            "width": 480,
            "hd": false
        },
        "poster": [
            {
                "type": "image/jpeg",
                "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                "width": 500,
                "height": 400
            }
        ],
        "filmstrip": [
            {
                "type": "image/jpeg",
                "url": "https://78.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame1.jpg",
                "width": 200,
                "height": 125
            },
            {
                "type": "image/jpeg",
                "url": "https://78.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame2.jpg",
                "width": 200,
                "height": 125
            }
        ],
        "can_autoplay_on_cellular": true
    }"""

    const val videoContentYoutube: String = """{
        "type": "video",
        "provider": "youtube",
        "url": "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
        "embed_html": "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" frameborder=\"0\" allowfullscreen></iframe>",
        "embed_url": "https://www.youtube.com/embed/dQw4w9WgXcQ",
        "metadata": {
            "id": "dQw4w9WgXcQ"
        },
        "poster": [
            {
                "type": "image/jpeg",
                "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                "width": 500,
                "height": 400
            }
        ]
    }"""

    const val videoContentIFrame: String = """{
        "type": "video",
        "provider": "youtube",
        "url": "https://www.youtube.com/watch?v=HgbN8doxXxg",
        "embed_url": "https://www.youtube.com/embed/HgbN8doxXxg?feature=oembed&enablejsapi=1&origin=https://safe.txmblr.com&wmode=opaque",
        "poster": [
            {
                "url": "https://i.ytimg.com/vi/HgbN8doxXxg/hqdefault.jpg",
                "type": "image/jpeg",
                "width": 480,
                "height": 360
            }
        ],
        "metadata": {
            "id": "HgbN8doxXxg"
        },
        "embed_iframe": {
            "url": "https://safe.txmblr.com/svc/embed/iframe/dominominomino/165315496890?w=540&h=304&media_id=HgbN8doxXxg#embed-5bd570c977dcd714178554",
            "width": 540,
            "height": 304
        }
    }"""

    // endregion

    // region Media Object samples

    const val mediaContentJpeg: String = """{
        "type": "image/jpg",
        "url": "https://69.media.tumblr.com/path/to/image.jpg",
        "width": 540,
        "height": 405
    }"""

    const val mediaContentMp4: String = """{
        "type": "video/mp4",
        "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1.mp4",
        "height": 640,
        "width": 480,
        "hd": false
    }"""

    const val mediaContentGif: String = """{
        "url": "https://66.media.tumblr.com/9e73932ed3c60ed972a603fb4a7e8388/tumblr_p5xbcabCUL1sd87luo1_1280.gif",
        "type": "image/gif",
        "width": 1280,
        "height": 985,
        "poster": {
            "url": "https://46.media.tumblr.com/9e73932ed3c60ed972a603fb4a7e8388/tumblr_p5xbcabCUL1sd87luo1_1280.gif",
            "type": "image/gif",
            "width": 1280,
            "height": 985
        }
    }"""

    // endregion

    // region TextContent Subtype samples

    const val textContentQuirky: String = """{
        "type": "text",
        "text": "Oh, worm?",
        "subtype": "quirky"
    }"""

    const val textContentQuote: String = """{
        "type": "text",
        "subtype": "quote",
        "text": "Genius without education is like silver in the mine."
    }"""

    const val textContentHeading1: String = """{
        "type": "text",
        "subtype": "heading1",
        "text": "New Post Forms Manifesto"
    }"""

    const val textContentHeading2: String = """{
        "type": "text",
        "subtype": "heading2",
        "text": "what a great conversation"
    }"""

    const val textContentChat: String = """{
        "type": "text",
        "subtype": "chat",
        "text": "cyle: ello",
        "formatting": [
            {
                "start": 0,
                "end": 5,
                "type": "bold"
            }
        ]
    }"""

    const val textContentOrderedList: String = """{
        "type": "text",
        "subtype": "ordered-list-item",
        "text": "Sword"
    }"""

    const val textContentUnorderedList: String = """{
        "type": "text",
        "subtype": "unordered-list-item",
        "text": "Death, which is uncountable on this list."
    }"""

    // endregion

    // region TextContent Format samples

    const val textFormatMention: String = """{
        "start": 13,
        "end": 19,
        "type": "mention",
        "blog": {
            "uuid": "t:123456abcdf",
            "name": "david",
            "url": "https://davidslog.com/"
        }
    }"""

    const val textFormatColor: String = """{
        "start": 10,
        "end": 15,
        "type": "color",
        "hex": "#ff492f"
    }"""

    const val textFormatSize: String = """{
        "start": 10,
        "end": 15,
        "type": "size",
        "size": "small"
    }"""

    // endregion

    // region BlockLayout samples

    const val layoutNull: String = """null"""

    const val layoutVertical: String = """{}"""

    const val layoutRow: String = """{
        "type": "rows",
        "rows": [
            [0, 1],
            [2]
        ]
    }"""

    const val layoutRowDisplayMode: String = """{
        "type": "rows",
        "display": [
            {"blocks": [0]},
            {"blocks": [1, 2]},
            {"blocks": [3]},
            {"blocks": [4, 5, 6], "mode": {"type": "carousel"}},
            {"blocks": [7]}
        ]
    }"""

    const val layoutCondensed: String = """{
        "type": "condensed",
        "blocks": [0, 1, 2, 3]
    }"""

    const val layoutAsk: String = """{
        "type": "ask",
        "blocks": [0, 1],
        "attribution": {
            "type": "blog",
            "blog": {
                "uuid": "t:VGOv4YpZHWy_2AUO1NlIMA"
            }
        }
    }"""

    // endregion

    // region Display Mode samples

    const val displayModeWeighted: String = """{"blocks": [1, 2]}"""

    const val displayModeCarousel: String = """{"blocks": [4, 5, 6], "mode": {"type": "carousel"}}"""

    // endregion

    // region Legacy Post samples

    const val answerPost: String = """{
        "type": "answer",
        "blog_name": "beachLover9000",
        "blog": {
            "name": "beachLover9000",
            "title": "I love beaches",
            "description": "<p>Beaches are amazing</p>",
            "url": "https://beachLover9000.tumblr.com/",
            "uuid": "t:s56df4g81eag65as1",
            "updated": 1540337956
        },
        "id": 194564825344,
        "post_url": "https://beachLover9000/post/194564825344/what-is-your-favorite-beach",
        "slug": "what-is-your-favorite-beach",
        "date": "2019-08-23 23:59:16 GMT",
        "timestamp": 1540337956,
        "state": "published",
        "format": "html",
        "reblog_key": "jawuseZL",
        "tags": [],
        "short_url": "https://tmblr.co/Z0mD6d6422yw1W",
        "summary": "What is your favorite beach?",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "note_count": 2,
        "asking_name": "Anonymous",
        "asking_url": null,
        "question": "What is your favorite beach?",
        "answer": "<p>All</p>",
        "reblog": {
            "comment": "<p>All</p>",
            "tree_html": ""
        },
        "trail": [
            {
                "blog": {
                    "name": "beachLover9000",
                    "active": true,
                    "theme": {
                        "header_full_width": 540,
                        "header_full_height": 540,
                        "header_focus_width": 540,
                        "header_focus_height": 304,
                        "avatar_shape": "square",
                        "background_color": "#FDF1FF",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "0,540,304,0",
                        "header_image": "https://static.tumblr.com/44f37aaaa0d15479612189456165166677be89886/vemwgq3/ZcQpdyrj6/tumblr_static_.gif",
                        "header_image_focused": "https://static.tumblr.com/33934493318864513587891324e96a7a4819/vemwgq3/Qqhpdyrja/tumblr_static_tumblr_static__focused_v3.jpg",
                        "header_image_scaled": "https://static.tumblr.com/44f37a560681238421358677be89886/vemwgq3/ZcQpdyrj6/tumblr_static__2048_v2.gif",
                        "header_stretch": true,
                        "link_color": "#FF5555",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": false,
                        "show_title": true,
                        "title_color": "#FFA1EF",
                        "title_font": "Brutal Type",
                        "title_font_weight": "bold"
                    },
                    "share_likes": false,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "194564825344"
                },
                "content_raw": "<p>All</p>",
                "content": "<p>All</p>",
                "is_current_item": true,
                "is_root_item": true
            }
        ],
        "can_like": false,
        "can_reblog": false,
        "can_send_in_message": true,
        "can_reply": false,
        "display_avatar": true
    }"""

    const val answerPostWithAbstract: String = """{
        "type": "answer",
        "asking_name": "Anonymous",
        "asking_url": null,
        "question": "ukIuGYR_Jcdm60j7Nb95dg",
        "answer": "ukIuGYR_Jcdm60j7Nb95dg",
        "answer_abstract": "ukIuGYR_Jcdm60j7Nb95dg",
        "trail": [
            {
                "blog": {
                    "name": "creeptastically",
                    "active": true,
                    "theme": {
                        "header_full_width": 1280,
                        "header_full_height": 427,
                        "header_focus_width": 760,
                        "header_focus_height": 427,
                        "avatar_shape": "square",
                        "background_color": "#529ECC",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "0,1280,427,520",
                        "header_image": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "header_image_focused": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "header_image_scaled": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "header_stretch": true,
                        "link_color": "#f30505",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#000000",
                        "title_font": "Quadrat",
                        "title_font_weight": "bold"
                    },
                    "share_likes": true,
                    "share_following": true,
                    "can_be_followed": true
                },
                "post": {
                    "id": "7894561234987"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "ukIuGYR_Jcdm60j7Nb95dg",
                "content_abstract": "ukIuGYR_Jcdm60j7Nb95dg",
                "is_current_item": true,
                "is_root_item": true
            }
        ],
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val audioPost: String = """{
        "type": "audio",
        "id": 321654687987,
        "note_count": 1436,
        "source_url": "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/7894561423346879",
        "source_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "artist": "ukIuGYR_Jcdm60j7Nb95dg",
        "track_name": ":-(",
        "album_art": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.png",
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "player": "ukIuGYR_Jcdm60j7Nb95dg",
        "embed": "ukIuGYR_Jcdm60j7Nb95dg",
        "plays": 1876,
        "audio_url": "https://a.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.mp3",
        "audio_source_url": "https://a.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.mp3",
        "audio_type": "tumblr",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val audioPostWithTrack: String = """{
        "type": "audio",
        "artist": "ukIuGYR_Jcdm60j7Nb95dg",
        "album": "ukIuGYR_Jcdm60j7Nb95dg",
        "year": 2011,
        "track": "7",
        "track_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "player": "ukIuGYR_Jcdm60j7Nb95dg",
        "embed": "ukIuGYR_Jcdm60j7Nb95dg",
        "plays": 574,
        "audio_url": "https://www.tumblr.com/audio_file/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg",
        "audio_source_url": "https://www.tumblr.com/audio_file/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg",
        "audio_type": "tumblr",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val audioPostWithProvider: String = """{
        "type": "audio",
        "note_count": 0,
        "source_url": "ukIuGYR_Jcdm60j7Nb95dg&m=1",
        "source_title": "open.spotify.com",
        "artist": "ukIuGYR_Jcdm60j7Nb95dg",
        "album": "ukIuGYR_Jcdm60j7Nb95dg",
        "track_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "album_art": "https://i.scdn.co/image/ukIuGYR_Jcdm60j7Nb95dg",
        "player": "ukIuGYR_Jcdm60j7Nb95dg",
        "embed": "ukIuGYR_Jcdm60j7Nb95dg",
        "plays": 0,
        "audio_url": "https://open.spotify.com/track/ukIuGYR_Jcdm60j7Nb95dg",
        "audio_source_url": "https://open.spotify.com/track/ukIuGYR_Jcdm60j7Nb95dg",
        "provider_uri": "spotify:track:ukIuGYR_Jcdm60j7Nb95dg?si=ukIuGYR_Jcdm60j7Nb95dg",
        "is_external": true,
        "audio_type": "spotify",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val audioPostWithTrackOf: String = """{
        "type": "audio",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "id": 7894564546546,
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-03-08 01:42:47 GMT",
        "timestamp": 1520473367,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 1196,
        "source_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
        "source_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "artist": "ukIuGYR_Jcdm60j7Nb95dg",
        "album": "ukIuGYR_Jcdm60j7Nb95dg",
        "track": "12 of 13",
        "track_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "album_art": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.jpg",
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "player": "ukIuGYR_Jcdm60j7Nb95dg",
        "embed": "ukIuGYR_Jcdm60j7Nb95dg",
        "plays": 9378,
        "audio_url": "https://www.tumblr.com/audio_file/ukIuGYR_Jcdm60j7Nb95dg/987546202131546/ukIuGYR_Jcdm60j7Nb95dg",
        "audio_source_url": "https://www.tumblr.com/audio_file/ukIuGYR_Jcdm60j7Nb95dg/879845613213/ukIuGYR_Jcdm60j7Nb95dg",
        "audio_type": "tumblr",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val audioPostWithExternal: String = """{
        "type": "audio",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg | ",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1540661415
        },
        "id": 89456168789,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/32165498798/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-10-27 15:55:13 GMT",
        "timestamp": 1540655713,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [
            "ukIuGYR_Jcdm60j7Nb95dg"
        ],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": true,
        "note_count": 6,
        "source_url": "http://ukIuGYR_Jcdm60j7Nb95dg.bandcamp.com/track/ukIuGYR_Jcdm60j7Nb95dg",
        "source_title": "Bandcamp",
        "artist": "ukIuGYR_Jcdm60j7Nb95dg",
        "album": "ukIuGYR_Jcdm60j7Nb95dg",
        "track_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "album_art": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.jpg",
        "caption": "",
        "reblog": {
            "comment": "",
            "tree_html": ""
        },
        "trail": [],
        "player": "ukIuGYR_Jcdm60j7Nb95dg",
        "embed": "ukIuGYR_Jcdm60j7Nb95dg",
        "plays": 0,
        "audio_url": "https://bandcamp.com/stream_redirect?enc=mp3-ukIuGYR_Jcdm60j7Nb95dg",
        "audio_source_url": "https://bandcamp.com/stream_redirect?enc=mp3-ukIuGYR_Jcdm60j7Nb95dg",
        "is_external": true,
        "audio_type": "bandcamp",
        "liked_timestamp": 1540662016,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val chatPost: String = """{
        "type": "chat",
        "source_url": "http://smokeypsd-games.tumblr.com/post/178680488283/the-rise-of-netflix-competitors-has-pushed",
        "source_title": "smokeypsd-games",
        "title": null,
        "body": "<p><a href=\"http://themadcapmathematician.tumblr.com/post/179031097048/the-rise-of-netflix-competitors-has-pushed\" class=\"tumblr_blog\">themadcapmathematician</a>:</p>\n<blockquote>\n<p><a href=\"http://love-the-weirdo-in-the-closet.tumblr.com/post/179030975164/the-rise-of-netflix-competitors-has-pushed\" class=\"tumblr_blog\">love-the-weirdo-in-the-closet</a>:</p>\n\n<blockquote>\n<p><a href=\"https://therealfeedback.tumblr.com/post/179026826664/the-rise-of-netflix-competitors-has-pushed\" class=\"tumblr_blog\">therealfeedback</a>:</p>\n<blockquote>\n<p><a href=\"https://racistspiderman.tumblr.com/post/178732171741/the-rise-of-netflix-competitors-has-pushed\" class=\"tumblr_blog\">racistspiderman</a>:</p>\n<blockquote>\n<p><a href=\"http://demon-princess-serina.tumblr.com/post/178684691298/the-rise-of-netflix-competitors-has-pushed\" class=\"tumblr_blog\">demon-princess-serina</a>:</p>\n<blockquote>\n<p><a href=\"http://smokeypsd-games.tumblr.com/post/178680488283/the-rise-of-netflix-competitors-has-pushed\" class=\"tumblr_blog\">smokeypsd-games</a>:</p>\n<blockquote><p data-npf=\"{&quot;type&quot;:&quot;link&quot;,&quot;url&quot;:&quot;https://t.umblr.com/redirect?z=https%3A%2F%2Fmotherboard.vice.com%2Fen_us%2Farticle%2Fd3q45v%2Fbittorrent-usage-increases-netflix-streaming-sites&amp;t=M2U4OWFjY2Y2OWY2ODU4OTg0N2FkZThlMTNhZDllMmI0MWQxODAxOSw3NWRhNDQ3ODA1MzhiNWY0NjFjYmNhZjQ1N2JiMDIyNmY4YTdlMjRj&quot;,&quot;display_url&quot;:&quot;https://motherboard.vice.com/en_us/article/d3q45v/bittorrent-usage-increases-netflix-streaming-sites&quot;,&quot;title&quot;:&quot;The Rise of Netflix Competitors Has Pushed Consumers Back Toward Piracy&quot;,&quot;description&quot;:&quot;BitTorrent usage has bounced back because there's too many streaming services, and too much exclusive content. &quot;,&quot;site_name&quot;:&quot;Motherboard&quot;,&quot;poster&quot;:[{&quot;url&quot;:&quot;https://66.media.tumblr.com/69a4c9065ac0b3208f8a5d5088a820a9/tumblr_pfzwwpOPWP1qh6p70_540.jpg&quot;,&quot;type&quot;:&quot;image/jpeg&quot;,&quot;width&quot;:1200,&quot;height&quot;:675}]}\" class=\"npf_link\"><a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fmotherboard.vice.com%2Fen_us%2Farticle%2Fd3q45v%2Fbittorrent-usage-increases-netflix-streaming-sites&amp;t=M2U4OWFjY2Y2OWY2ODU4OTg0N2FkZThlMTNhZDllMmI0MWQxODAxOSw3NWRhNDQ3ODA1MzhiNWY0NjFjYmNhZjQ1N2JiMDIyNmY4YTdlMjRj\">The Rise of Netflix Competitors Has Pushed Consumers Back Toward Piracy</a></p></blockquote>\n<p>You know, it’s almost like that was the fucking problem in the first place you stupid bastards</p>\n</blockquote>\n<p>the absolute need for every online video platform to become just like cable tv despite the fact their success comes from not being like cable tv is just overwhelming </p>\n</blockquote>\n<p><b>Netflix:</b> Alright guys, we have a fantastic model going! Piracy is down, subscriptions are up, everyone’s making money with these contracts for your show’s streaming rights, and viewers are getting a ton of great content they enjoy. Everybody wins!</p>\n<p><b>Morons: </b>But what if we had our own streaming service just for our content?</p>\n<p><b>Netflix:</b> …I mean in-theory that would work at first, but if everyone’s content was suddenly 100% exclusive and you have to get a dozen subscriptions to a dozen proprietary streaming services just to watch three shows, that defeats a lot of the val–</p>\n<p><b>Morons: </b>And we could charge more than Netflix and Hulu too! We could make even more money!</p>\n<p><b>Netflix:</b> Well at a certain point you’re going to start charging more than people are willing to pay and you’ll start losing more money than you’ll gain. We’ve been doing this since 1997 so we have a pretty good idea of–</p>\n<p><b>Morons: *</b>create streaming sites for every single fucking studio that all charge more money than their content is worth, saturating the market with too many options, almost all of which have too little content to justify their price*</p>\n<p><b>Consumers: </b>Yeah fuck this</p>\n<p><b>Morons: </b>I knew streaming was a dead-end. It never could’ve worked</p>\n<p><b>Netflix:</b> But we were making money! It <i>was </i>working before you fuckers killed the goose laying golden eggs! <br/></p>\n<p><b>Morons:</b> Yeah, but when we wanted more money, it stopped working, and we’re too good at business to make bad decisions, so clearly it was streaming itself that wasn’t working. It’s not our fault the goose couldn’t keep laying eggs after we ate it!<br/></p>\n<p><b>Netflix:</b> What the fuck is wrong with you people<br/></p>\n</blockquote>\n<p>Everything is wrong with people</p>\n</blockquote>\n\n<p>The free market?? Sabotaging itself??? More likely than you’d think</p>\n</blockquote>"
    }"""

    const val chat2Post: String = """ {
        "blog_name": "david",
        "id": 5845345725,
        "post_url": "http:\/\/www.davidslog.com\/5845345725\/if-youre-okay-with-it-destroying-tumblr",
        "type": "chat",
        "date": "2011-05-25 22:32:00 GMT",
        "timestamp": 1306362720,
        "format": "html",
        "reblog_key": "wlxAsElf",
        "tags": [],
        "note_count": 114,
        "title": null,
        "body": "David: http://staff.tumblr.com/post/5845153911
            [draft] Topherchris: are you freaking serious\r\n
            David: If you're okay with it - I'd love to :)\r\n
            Topherchris: i'm okay with it, if you're okay with
            it destroying tumblr",
        "dialogue": [
            {
               "label": "David:",
               "name": "David",
               "phrase": "http://staff.tumblr.com/post/5845153911 [draft]\r"
            },
            {
               "label": "Topherchris:",
               "name": "Topherchris",
               "phrase": "are you freaking serious\r"
            },
            {
               "label": "David:",
               "name": "David",
               "phrase": "If you're okay with it - I'd love to :)"
            },
            {
               "label": "Topherchris:",
               "name": "Topherchris",
               "phrase": "i'm okay with it, if you're okay with it
                  destroying tumblr"
            }
        ]
     }"""

    const val linkPost: String = """{
        "type": "link",
        "source_url": "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/78945612313/ukIuGYR_Jcdm60j7Nb95dg",
        "source_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "title": null,
        "body": "ukIuGYR_Jcdm60j7Nb95dg"
    }"""

    const val linkPostWithImage: String = """{
        "type": "link",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1540830820
        },
        "id": 564871621687,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/8975612324879/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-10-29 15:24:59 GMT",
        "timestamp": 1540826699,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [
            "ukIuGYR_Jcdm60j7Nb95dg"
        ],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg-x",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": true,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 249,
        "source_url": "https://t.umblr.com/redirect?ukIuGYR_Jcdm60j7Nb95dg%3D&b=t%ukIuGYR_Jcdm60j7Nb95dg&m=1",
        "source_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "title": "ukIuGYR_Jcdm60j7Nb95dg",
        "url": "https://www.ukIuGYR_Jcdm60j7Nb95dg/",
        "link_image": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
        "link_image_dimensions": {
            "width": 540,
            "height": 440
        },
        "link_author": "ukIuGYR_Jcdm60j7Nb95dg",
        "excerpt": "ukIuGYR_Jcdm60j7Nb95dg.",
        "publisher": "ukIuGYR_Jcdm60j7Nb95dg.com",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                    "width": 702,
                    "height": 572
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "width": 702,
                        "height": 572
                    }
                ]
            }
        ],
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val linkPostWithAuthor: String = """{
        "type": "link",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg-pV7aA3g",
            "updated": 1540851820
        },
        "id": 789456123132,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/987654321/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-10-29 16:19:43 GMT",
        "timestamp": 1540829983,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg-3j",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": true,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 29546,
        "source_url": "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/5498751654665/ukIuGYR_Jcdm60j7Nb95dg",
        "source_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "title": "ukIuGYR_Jcdm60j7Nb95dg",
        "url": "https://www.facebook.com/donate/ukIuGYR_Jcdm60j7Nb95dg/",
        "link_author": null,
        "excerpt": "ukIuGYR_Jcdm60j7Nb95dg",
        "publisher": "facebook.com",
        "description": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val photoPost: String = """{
        "type": "photo",
        "source_url": "https://t.umblr.com/redirect?z=http%3A%2F%2Fwww.reddit.com%2Fr%2Fdataisbeautiful%2Fcomments%2F9pu4z7%2Fmega_millions_is_over_1b_howeveroc%2F&t=ZDE3NzdlY2M0ZGU4OTNhYjEzMDkzZDM1MDk2NWE3MTI3YzQ1MDE2NSwxNzkyNDc4MDg2NzI%3D&b=t%3AqKP_MzQNzxfHBZSnuZVbuQ&p=http%3A%2F%2Fdatarep.tumblr.com%2Fpost%2F179247808672%2Fmega-millions-is-over-1b-however&m=1",
        "source_title": "reddit.com",
        "caption": "<p>Mega Millions is over ${'$'}1B! However&hellip;</p>",
        "image_permalink": "http://datarep.tumblr.com/image/179247808672",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_1280.png",
                    "width": 1280,
                    "height": 848
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_1280.png",
                        "width": 1280,
                        "height": 848
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_640.png",
                        "width": 640,
                        "height": 424
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_540.png",
                        "width": 540,
                        "height": 358
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_500.png",
                        "width": 500,
                        "height": 331
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_400.png",
                        "width": 400,
                        "height": 265
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_250.png",
                        "width": 250,
                        "height": 166
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_100.png",
                        "width": 100,
                        "height": 66
                    },
                    {
                        "url": "https://66.media.tumblr.com/639f8b209994d4804a4d23b3fc8b9421/tumblr_pgwmocTnPl1sq2igro1_75sq.png",
                        "width": 75,
                        "height": 75
                    }
                ]
            }
        ]
    }"""

    const val photoPostWithLinkUrl: String = """{
        "type": "photo",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1540618012
        },
        "id": 45687984231,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/987654321/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2017-02-04 04:03:28 GMT",
        "timestamp": 1486181008,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": true,
        "note_count": 2,
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "ukIuGYR_Jcdm60j7Nb95dg",
            "tree_html": ""
        },
        "link_url": "https://www.instagram.com/p/ukIuGYR_Jcdm60j7Nb95dg/",
        "image_permalink": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/image/ukIuGYR_Jcdm60j7Nb95dg",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                    "width": 1080,
                    "height": 1350
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "width": 1080,
                        "height": 1350
                    }
                ]
            }
        ],
        "liked_timestamp": 1486216757,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val photoPostWithLayout: String = """{
        "type": "photo",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:LZuak_bb6qg9zrSHdWC9Gg",
            "updated": 1540658836
        },
        "id": 789456123,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/987654321/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2017-08-15 02:21:27 GMT",
        "timestamp": 1502763687,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [
            "ukIuGYR_Jcdm60j7Nb95dg"
        ],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg️",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": true,
        "note_count": 11,
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "photoset_layout": "2",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                    "width": 719,
                    "height": 1028
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "width": 719,
                        "height": 1028
                    }
                ]
            },
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                    "width": 719,
                    "height": 1280
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.jpg",
                        "width": 719,
                        "height": 1280
                    }
                ]
            }
        ],
        "liked_timestamp": 1502837700,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val photoPostWithPanorama: String = """{
        "type": "photo",
        "blog_name": "datarep",
        "blog": {
            "name": "datarep",
            "title": "Visual Data",
            "description": "Data representations, information graphics, charts, maps and graphs. Mainly from /r/dataisbeautiful",
            "url": "http://datarep.tumblr.com/",
            "uuid": "t:qKP_MzQNzxfHBZSnuZVbuQ",
            "updated": 1541179215
        },
        "id": 179382026534,
        "post_url": "http://datarep.tumblr.com/post/179382026534/sleeping-patterns-during-the-first-four-months-of",
        "slug": "sleeping-patterns-during-the-first-four-months-of",
        "date": "2018-10-24 12:56:18 GMT",
        "timestamp": 1540385778,
        "state": "published",
        "format": "html",
        "reblog_key": "D9zUkcyf",
        "tags": [
            "data",
            "sleeping"
        ],
        "short_url": "https://tmblr.co/ZgYZIs2d4084c",
        "summary": "Sleeping patterns during the first four months of life.",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 69,
        "source_url": "https://t.umblr.com/redirect?z=http%3A%2F%2Fwww.reddit.com%2Fr%2Fdataisbeautiful%2Fcomments%2F9qunqc%2Fsleeping_patterns_during_the_first_four_months_of%2F&t=ZmZhYmMxMjkwMGFmMTFmOWQxYzRmYTE3MmU4ZTg4ZDk4OTkyYzFjYywxNzkzODIwMjY1MzQ%3D&b=t%3AqKP_MzQNzxfHBZSnuZVbuQ&p=http%3A%2F%2Fdatarep.tumblr.com%2Fpost%2F179382026534%2Fsleeping-patterns-during-the-first-four-months-of&m=1",
        "source_title": "reddit.com",
        "caption": "<p>Sleeping patterns during the first four months of life.</p>",
        "reblog": {
            "comment": "<p>Sleeping patterns during the first four months of life.</p>",
            "tree_html": ""
        },
        "trail": [
            {
                "blog": {
                    "name": "datarep",
                    "active": true,
                    "theme": {
                        "header_full_width": 818,
                        "header_full_height": 481,
                        "header_focus_width": 818,
                        "header_focus_height": 460,
                        "avatar_shape": "square",
                        "background_color": "#FAFAFA",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "10,818,470,0",
                        "header_image": "https://static.tumblr.com/aee15331c8db1b9a29a96a1d0bec6599/umfg5uh/op0nl7786/tumblr_static_1fzk9pfrgn7ococs4s4gcskc4.png",
                        "header_image_focused": "https://static.tumblr.com/aee15331c8db1b9a29a96a1d0bec6599/umfg5uh/dzEnl7787/tumblr_static_tumblr_static_1fzk9pfrgn7ococs4s4gcskc4_focused_v3.png",
                        "header_image_scaled": "https://static.tumblr.com/aee15331c8db1b9a29a96a1d0bec6599/umfg5uh/op0nl7786/tumblr_static_1fzk9pfrgn7ococs4s4gcskc4_2048_v2.png",
                        "header_stretch": true,
                        "link_color": "#529ECC",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#444444",
                        "title_font": "Gibson",
                        "title_font_weight": "bold"
                    },
                    "share_likes": false,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "179382026534"
                },
                "content_raw": "<p>Sleeping patterns during the first four months of life.</p>",
                "content": "<p>Sleeping patterns during the first four months of life.</p>",
                "is_current_item": true,
                "is_root_item": true
            }
        ],
        "image_permalink": "http://datarep.tumblr.com/image/179382026534",
        "is_panorama": true,
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_1280.jpg",
                    "width": 1280,
                    "height": 280
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_1280.jpg",
                        "width": 1280,
                        "height": 280
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_640.jpg",
                        "width": 640,
                        "height": 140
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_540.jpg",
                        "width": 540,
                        "height": 118
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_500.jpg",
                        "width": 500,
                        "height": 109
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_400.jpg",
                        "width": 400,
                        "height": 87
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_250.jpg",
                        "width": 250,
                        "height": 55
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_100.jpg",
                        "width": 100,
                        "height": 22
                    },
                    {
                        "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_75sq.jpg",
                        "width": 75,
                        "height": 75
                    }
                ],
                "panorama_size": {
                    "url": "https://66.media.tumblr.com/2356606a219b34c72d9f5d281099d0bd/tumblr_ph3hwgMeWV1sq2igro1_500h.jpg",
                    "width": 2288,
                    "height": 500
                }
            }
        ],
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val photoPostWithCaptionAbstract: String = """{
        "type": "photo",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1541173159
        },
        "id": 1879812564,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/78945616203/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-10-23 00:53:32 GMT",
        "timestamp": 1540256012,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [
            "ukIuGYR_Jcdm60j7Nb95dg"
        ],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg-UxO",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 53,
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "caption_abstract": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "ukIuGYR_Jcdm60j7Nb95dg",
            "tree_html": ""
        },
        "image_permalink": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/image/789789456123",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.png",
                    "width": 1280,
                    "height": 838
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg.png",
                        "width": 1280,
                        "height": 838
                    }
                ]
            }
        ],
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val quotePost: String = """{
        "blog_name": "museumsandstuff",
        "id": 4742980381,
        "post_url": "http:\/\/museumsandstuff.tumblr.com\/post\/4742980381",
        "type": "quote",
        "date": "2011-04-19 08:52:34 GMT",
        "timestamp": 1303203154,
        "format": "html",
        "reblog_key": "KLA85e6c",
        "tags": [],
        "note_count": 23,
        "source_url": "http:\/\/museumtwo.blogspot.com\/2011\/04\/guest-post-convivial-museum-photo-essay.html",
        "source_title": "museumtwo.blogspot.com",
        "text": "Why do visitors still report discomfort, confusion, elitism, exclusion?",
        "source": "<a href=\"http:\/\/museumtwo.blogspot.com\/2011\/04\/guest-post-convivial-museum-photo-essay.html\"target=\"_blank\">Museum 2.0: Guest Post: The Convivial Museum Photo Essay<\/a> (via <a href=\"http:\/\/www.joshrobinson.org\/\"target=\"_blank\">joshrobinsonblog<\/a>)"
     }"""

    const val textPost: String = """{
        "type": "text",
        "title": null,
        "body": "<p>DM: The room is filling with water it’s getting hard to breathe.</p>\n<p>Barbarian: I’m rolling brute strength.</p>\n<p>DM: You can’t roll brute strength to breathe!</p>\n<p>Barbarian: d20!</p>"
    }"""

    const val textPostWithAbstract: String = """{
        "type": "text",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1540659751
        },
        "id": 1564812315498,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/15647894531124/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2017-06-22 05:44:51 GMT",
        "timestamp": 1498110291,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [
            "ukIuGYR_Jcdm60j7Nb95dg"
        ],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": true,
        "note_count": 2,
        "title": "bleh",
        "body": "ukIuGYR_Jcdm60j7Nb95dg",
        "body_abstract": "<p>&nbsp;dfasdf</p>",
        "reblog": {
            "comment": "ukIuGYR_Jcdm60j7Nb95dg",
            "tree_html": ""
        },
        "liked_timestamp": 1498136029,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val videoPost: String = """{
        "type": "video",
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "video_url": "https://ve.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.mp4",
        "html5_capable": true,
        "thumbnail_url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.jpg",
        "thumbnail_width": 640,
        "thumbnail_height": 640,
        "duration": 58,
        "player": [
            {
                "width": 250,
                "embed_code": "ukIuGYR_Jcdm60j7Nb95dg"
            },
            {
                "width": 400,
                "embed_code": "ukIuGYR_Jcdm60j7Nb95dg"
                },
            {
                "width": 500,
                "embed_code": "ukIuGYR_Jcdm60j7Nb95dg"
            }
        ],
        "video_type": "tumblr"
    }"""

    const val videoPostWithPermaLink: String = """{
        "type": "video",
        "permalink_url": "https://instagram.com/p/ukIuGYR_Jcdm60j7Nb95dg",
        "html5_capable": true,
        "thumbnail_url": "https://ukIuGYR_Jcdm60j7Nb95dg-ukIuGYR_Jcdm60j7Nb95dg.cdninstagram.com/vp/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/e15/s480x480/ukIuGYR_Jcdm60j7Nb95dg.jpg",
        "thumbnail_width": 480,
        "thumbnail_height": 480,
        "player": [
            {
                "width": 250,
                "embed_code": "ukIuGYR_Jcdm60j7Nb95dg"
            },
            {
                "width": 400,
                "embed_code": "ukIuGYR_Jcdm60j7Nb95dg"
            },
            {
                "width": 500,
                "embed_code": "ukIuGYR_Jcdm60j7Nb95dg"
            }
        ],
        "video_type": "instagram"
    }"""

    const val videoPostWithFloatDuration: String = """{
        "type": "video",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1541203515
        },
        "id": 48489784616,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/15481231546/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "the-very-odd-one-this-goddamn-website-had-me",
        "date": "2018-10-09 12:45:21 GMT",
        "timestamp": 1539089121,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": true,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 110752,
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "trail": [
            {
                "blog": {
                    "name": "ukIuGYR_Jcdm60j7Nb95dg",
                    "active": true,
                    "theme": {
                        "avatar_shape": "circle",
                        "background_color": "#6AA48E",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "",
                        "header_image": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/2w3x95b/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_filename.jpg",
                        "header_image_focused": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/2w3x95b/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_filename_2048_v2.jpg",
                        "header_image_scaled": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/2w3x95b/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_filename_2048_v2.jpg",
                        "header_stretch": true,
                        "link_color": "#CCB6DB",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#000000",
                        "title_font": "Clearface FS",
                        "title_font_weight": "regular"
                    },
                    "share_likes": true,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "156781324579816"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "ukIuGYR_Jcdm60j7Nb95dg"
            }
        ],
        "video_url": "https://v.tumblr.com/tumblr_ukIuGYR_Jcdm60j7Nb95dg.mov",
        "html5_capable": true,
        "thumbnail_url": "https://66.media.tumblr.com/tumblr_ukIuGYR_Jcdm60j7Nb95dg_frame1.jpg",
        "thumbnail_width": 510,
        "thumbnail_height": 380,
        "duration": 105.22999999999999,
        "player": [
            {
                "width": 250,
                "embed_code": "\n<video  id='embed-ukIuGYR_Jcdm60j7Nb95dg' class='crt-video crt-skin-default' width='250' height='186' poster='https://66.media.tumblr.com/vukIuGYR_Jcdm60j7Nb95dg.jpg' preload='none' muted data-crt-video data-crt-options='{\"autoheight\":null,\"duration\":105.22999999999999,\"hdUrl\":false,\"filmstrip\":false}' >\n    <source src=\"https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/video_file/t:ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg\" type=\"video/mp4\">\n</video>\n"
            },
            {
                "width": 400,
                "embed_code": "\n<video  id='embed-ukIuGYR_Jcdm60j7Nb95dg' class='crt-video crt-skin-default' width='400' height='298' poster='https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.jpg' preload='none' muted data-crt-video data-crt-options='{\"autoheight\":null,\"duration\":105.22999999999999,\"hdUrl\":false,\"filmstrip\":false}' >\n    <source src=\"https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/video_file/t:ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg\" type=\"video/mp4\">\n</video>\n"
            },
            {
                "width": 500,
                "embed_code": "\n<video  id='embed-ukIuGYR_Jcdm60j7Nb95dg' class='crt-video crt-skin-default' width='500' height='373' poster='https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg.jpg' preload='none' muted data-crt-video data-crt-options='{\"autoheight\":null,\"duration\":105.22999999999999,\"hdUrl\":false,\"filmstrip\":false}' >\n    <source src=\"https://vukIuGYR_Jcdm60j7Nb95dg.tumblr.com/video_file/t:ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg\" type=\"video/mp4\">\n</video>\n"
            }
        ],
        "video_type": "tumblr",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": false,
        "display_avatar": true
    }"""

    const val videoPostWithBooleanEmbed: String = """{
        "type": "video",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://backwardsorbust.tumblr.com/",
            "uuid": "t:LZuak_bb6qg9zrSHdWC9Gg",
            "updated": 1541203515
        },
        "id": 156181231549817,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/5618168161581/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-09-11 01:38:57 GMT",
        "timestamp": 1536629937,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 101,
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "trail": [
            {
                "blog": {
                    "name": "ukIuGYR_Jcdm60j7Nb95dg",
                    "active": true,
                    "theme": {
                        "header_full_width": 3840,
                        "header_full_height": 2160,
                        "header_focus_width": 2048,
                        "header_focus_height": 1151,
                        "avatar_shape": "circle",
                        "background_color": "#444444",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "15,3812,2144,27",
                        "header_image": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/jqh0jvp/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_wx4o37035ao8kokow4wscgwc.png",
                        "header_image_focused": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/jqh0jvp/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_tumblr_static_wx4o37035ao8kokow4wscgwc_focused_v3.png",
                        "header_image_scaled": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/jqh0jvp/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_wx4o37035ao8kokow4wscgwc_2048_v2.png",
                        "header_stretch": true,
                        "link_color": "#888888",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#FFFFFF",
                        "title_font": "Gibson",
                        "title_font_weight": "bold"
                    },
                    "share_likes": false,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "156861518454654"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "vukIuGYR_Jcdm60j7Nb95dg",
                "is_root_item": true
            }
        ],
        "html5_capable": false,
        "player": [
            {
                "width": 250,
                "embed_code": false
            },
            {
                "width": 400,
                "embed_code": false
            },
            {
                "width": 500,
                "embed_code": false
            }
        ],
        "video_type": "youtube",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val videoPostWithVideoObject: String = """{
        "type": "video",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1540854523
        },
        "id": 11456151650392,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/1795187456165192/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-10-28 16:27:53 GMT",
        "timestamp": 1540744073,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 677,
        "source_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/178948/ukIuGYR_Jcdm60j7Nb95dg",
        "source_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "trail": [
            {
                "blog": {
                    "name": "ukIuGYR_Jcdm60j7Nb95dg",
                    "active": true,
                    "theme": {
                        "header_full_width": 1072,
                        "header_full_height": 1072,
                        "header_focus_width": 1057,
                        "header_focus_height": 595,
                        "avatar_shape": "circle",
                        "background_color": "#86b2bb",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "238,1064,833,7",
                        "header_image": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_dr3ouqgjqeos04ko84o44o44g.jpg",
                        "header_image_focused": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_tumblr_static_dr3ouqgjqeos04ko84o44o44g_focused_v3.jpg",
                        "header_image_scaled": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_dr3ouqgjqeos04ko84o44o44g_2048_v2.jpg",
                        "header_stretch": true,
                        "link_color": "#B55354",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#915b5b",
                        "title_font": "Square Serif",
                        "title_font_weight": "bold"
                    },
                    "share_likes": false,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "175645181213027"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "ukIuGYR_Jcdm60j7Nb95dg",
                "is_root_item": true
            },
            {
                "blog": {
                    "name": "ukIuGYR_Jcdm60j7Nb95dg",
                    "active": true,
                    "theme": {
                        "avatar_shape": "square",
                        "background_color": "#976531",
                        "body_font": "Helvetica Neue",
                        "header_bounds": 0,
                        "header_image": "https://assets.tumblr.com/images/default_header/optica_pattern_07.png?_v=ukIuGYR_Jcdm60j7Nb95dg",
                        "header_image_focused": "https://assets.tumblr.com/images/default_header/optica_pattern_07.png?_v=ukIuGYR_Jcdm60j7Nb95dg",
                        "header_image_scaled": "https://assets.tumblr.com/images/default_header/optica_pattern_07.png?_v=ukIuGYR_Jcdm60j7Nb95dg",
                        "header_stretch": true,
                        "link_color": "#19143F",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": false,
                        "show_title": true,
                        "title_color": "#444444",
                        "title_font": "Gibson",
                        "title_font_weight": "bold"
                    },
                    "share_likes": true,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "11566812606853"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "ukIuGYR_Jcdm60j7Nb95dg"
            }
        ],
        "permalink_url": "https://www.youtube.com/watch?v=fD2briZ6fB0",
        "html5_capable": true,
        "video": {
            "youtube": {
                "video_id": "fD2briZ6fB0",
                "width": 540,
                "height": 304
            }
        },
        "thumbnail_url": "https://i.ytimg.com/vi/fD2briZ6fB0/hqdefault.jpg",
        "thumbnail_width": 480,
        "thumbnail_height": 360,
        "player": [
            {
                "width": 250,
                "embed_code": "<iframe width=\"250\" height=\"141\"  id=\"youtube_iframe\" src=\"https://www.youtube.com/embed/fD2briZ6fB0?feature=oembed&amp;enablejsapi=1&amp;origin=https://safe.txmblr.com&amp;wmode=opaque\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
            },
            {
                "width": 400,
                "embed_code": "<iframe width=\"400\" height=\"225\"  id=\"youtube_iframe\" src=\"https://www.youtube.com/embed/fD2briZ6fB0?feature=oembed&amp;enablejsapi=1&amp;origin=https://safe.txmblr.com&amp;wmode=opaque\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
            },
            {
                "width": 500,
                "embed_code": "<iframe width=\"500\" height=\"281\"  id=\"youtube_iframe\" src=\"https://www.youtube.com/embed/fD2briZ6fB0?feature=oembed&amp;enablejsapi=1&amp;origin=https://safe.txmblr.com&amp;wmode=opaque\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"
            }
        ],
        "video_type": "youtube",
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    const val submission: String = """{
        "type": "photo",
        "blog_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "blog": {
            "name": "ukIuGYR_Jcdm60j7Nb95dg",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
            "updated": 1540632097
        },
        "id": 45645651680,
        "post_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2016-06-15 00:25:10 GMT",
        "timestamp": 1465950310,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [
            "Submit anonymously",
            "submission"
        ],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "ukIuGYR_Jcdm60j7Nb95dg",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": false,
        "is_anonymous": true,
        "is_submission": true,
        "liked": true,
        "note_count": 1818,
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "ukIuGYR_Jcdm60j7Nb95dg",
            "tree_html": ""
        },
        "trail": [
            {
                "blog": {
                    "name": "ukIuGYR_Jcdm60j7Nb95dg",
                    "active": true,
                    "theme": {
                        "header_full_width": 500,
                        "header_full_height": 332,
                        "header_focus_width": 402,
                        "header_focus_height": 226,
                        "avatar_shape": "square",
                        "background_color": "#b69494",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "72,448,298,46",
                        "header_image": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_6m6n0jc42xoggc04ksscgoc4w.jpg",
                        "header_image_focused": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_tumblr_static_6m6n0jc42xoggc04ksscgoc4w_focused_v3.jpg",
                        "header_image_scaled": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/tumblr_static_6m6n0jc42xoggc04ksscgoc4w_2048_v2.jpg",
                        "header_stretch": true,
                        "link_color": "#529ECC",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#222222",
                        "title_font": "Capita",
                        "title_font_weight": "bold"
                    },
                    "share_likes": false,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "14545618181180"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "ukIuGYR_Jcdm60j7Nb95dg",
                "is_current_item": true,
                "is_root_item": true
            }
        ],
        "image_permalink": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/image/561511681651",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg_1280.jpg",
                    "width": 1280,
                    "height": 1920
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_ukIuGYR_Jcdm60j7Nb95dg_1280.jpg",
                        "width": 1280,
                        "height": 1920
                    }
                ],
                "exif": {
                    "Camera": "Canon EOS 1100D",
                    "ISO": 640,
                    "Aperture": "f/3.5",
                    "Exposure": "1/40th",
                    "FocalLength": "18mm"
                }
            }
        ],
        "liked_timestamp": 1472612059,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    // endregion

    // region Legacy Data samples

    const val video: String = """{
        "width": 250,
        "embed_code": "\n<video  id='embed-5bcb5ea040f41385581651' class='crt-video crt-skin-default' width='250' height='250' poster='https://66.media.tumblr.com/tumblr_p4mr3kD1fq1wpsbbh_smart1.jpg' preload='none' muted data-crt-video data-crt-options='{\"autoheight\":null,\"duration\":58,\"hdUrl\":false,\"filmstrip\":{\"url\":\"https://78.media.tumblr.com/previews/tumblr_p4mr3kD1fq1wpsbbh_filmstrip.jpg\",\"width\":\"200\",\"height\":\"200\"}}' >\n    <source src=\"https://backwardsorbust.tumblr.com/video_file/t:LZuak_bb6qg9zrSHdWC9Gg/179243838952/tumblr_p4mr3kD1fq1wpsbbh/480\" type=\"video/mp4\">\n</video>\n"
    }"""

    const val photoWithExit: String = """{
        "caption": "",
        "original_size": {
            "url": "https://66.media.tumblr.com/foto_1280.jpg",
            "width": 1280,
            "height": 1707
        },
        "alt_sizes": [
            {
                "url": "https://66.media.tumblr.com/foto_1280.jpg",
                "width": 1280,
                "height": 1707
            },
            {
                "url": "https://66.media.tumblr.com/foto_640.jpg",
                "width": 640,
                "height": 853
            },
            {
                "url": "https://66.media.tumblr.com/foto_540.jpg",
                "width": 540,
                "height": 720
            },
            {
                "url": "https://66.media.tumblr.com/foto_500.jpg",
                "width": 500,
                "height": 667
            },
            {
                "url": "https://66.media.tumblr.com/foto_400.jpg",
                "width": 400,
                "height": 533
            },
            {
                "url": "https://66.media.tumblr.com/foto_250.jpg",
                "width": 250,
                "height": 333
            },
            {
                "url": "https://66.media.tumblr.com/foto_100.jpg",
                "width": 100,
                "height": 133
            },
            {
                "url": "https://66.media.tumblr.com/foto_75sq.jpg",
                "width": 75,
                "height": 75
            }
        ],
        "exif": {
            "Camera": "Google Pixel 5XL",
            "ISO": 94,
            "Aperture": "f/2",
            "Exposure": "1/30th",
            "FocalLength": "3mm"
        }
    }"""

    // endregion

    // region User samples

    const val userOther: String = """{
        "following": 263,
        "default_post_format": "html",
        "name": "derekg",
        "likes": 606,
        "blogs": [
          {
           "name": "derekg",
           "title": "Derek Gottfrid",
           "url": "http://derekg.org/",
           "tweet": "auto",
           "primary": true,
           "followers": 33004929
          }
        ]
    }"""

    const val userSelf: String = """{
        "name": "kotlr-development",
        "likes": 202,
        "following": 28,
        "default_post_format": "html",
        "blogs": [
            {
                "admin": true,
                "ask": true,
                "ask_anon": true,
                "ask_page_title": "kotlr-development",
                "can_send_fan_mail": true,
                "can_submit": true,
                "can_subscribe": false,
                "description": "kotlr-development",
                "drafts": 0,
                "facebook": "N",
                "facebook_opengraph_enabled": "N",
                "followed": false,
                "followers": 12,
                "is_blocked_from_primary": false,
                "is_nsfw": false,
                "messages": 2,
                "name": "kotlr-development",
                "posts": 47,
                "primary": true,
                "queue": 0,
                "share_likes": false,
                "submission_page_title": "Submit a post",
                "submission_terms": {
                    "accepted_types": [
                        "text",
                        "photo",
                        "quote",
                        "link",
                        "video"
                    ],
                    "tags": [],
                    "title": "Submit a post",
                    "guidelines": ""
                },
                "subscribed": false,
                "title": "kotlr-development",
                "total_posts": 47,
                "tweet": "N",
                "twitter_enabled": false,
                "twitter_send": false,
                "type": "public",
                "updated": 1540056911,
                "url": "https://kotlr-development-dev.tumblr.com/",
                "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg"
            },
            {
                "admin": true,
                "ask": false,
                "ask_anon": false,
                "ask_page_title": "Ask me anything",
                "can_send_fan_mail": true,
                "can_subscribe": true,
                "description": "kotlr-development",
                "drafts": 0,
                "facebook": "N",
                "facebook_opengraph_enabled": "N",
                "followed": true,
                "followers": 6,
                "is_blocked_from_primary": false,
                "is_nsfw": false,
                "messages": 0,
                "name": "kotlr-development",
                "posts": 42,
                "primary": false,
                "queue": 0,
                "share_likes": false,
                "subscribed": false,
                "title": "kotlr-development",
                "total_posts": 42,
                "tweet": "N",
                "twitter_enabled": false,
                "twitter_send": false,
                "type": "public",
                "updated": 1523968892,
                "url": "https://kotlr-development.tumblr.com/",
                "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg"
            },
            {
                "admin": true,
                "ask": true,
                "ask_anon": true,
                "ask_page_title": "kotlr-development",
                "can_send_fan_mail": true,
                "can_subscribe": true,
                "description": "",
                "drafts": 0,
                "facebook": "N",
                "facebook_opengraph_enabled": "N",
                "followed": true,
                "followers": 1,
                "is_blocked_from_primary": false,
                "is_nsfw": false,
                "messages": 0,
                "name": "kotlr-development",
                "posts": 3,
                "primary": false,
                "queue": 0,
                "share_likes": false,
                "subscribed": false,
                "title": "kotlr-development",
                "total_posts": 3,
                "tweet": "N",
                "twitter_enabled": false,
                "twitter_send": false,
                "type": "public",
                "updated": 1465158142,
                "url": "https://kotlr-development.tumblr.com/",
                "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg"
            }
        ]
    }"""

    // endregion

    // region Blog samples

    const val blogOther: String = """ {
      "ask": true,
      "ask_anon": true,
      "ask_page_title": "kotlr-development",
      "can_subscribe": false,
      "description": "kotlr-development",
      "is_nsfw": false,
      "name": "kotlr-development",
      "posts": 243905,
      "share_likes": false,
      "submission_page_title": "kotlr-development",
      "subscribed": false,
      "title": "kotlr-development",
      "total_posts": 243905,
      "updated": 1540324906,
      "url": "http://kotlr-development.tumblr.com/",
      "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
      "is_optout_ads": true
    }"""

    const val blogSubmission: String = """{
      "ask": true,
      "ask_anon": true,
      "ask_page_title": "kotlr-development",
      "can_send_fan_mail": true,
      "can_submit": true,
      "can_subscribe": true,
      "description": "kotlr-development",
      "followed": true,
      "is_blocked_from_primary": false,
      "is_nsfw": false,
      "name": "kotlr-development",
      "posts": 15111,
      "share_likes": false,
      "submission_page_title": "kotlr-development",
      "submission_terms": {
        "accepted_types": [
          "text",
          "photo",
          "quote",
          "link",
          "video"
        ],
        "tags": [
          "submission"
        ],
        "title": "kotlr-development",
        "guidelines": ""
      },
      "subscribed": false,
      "title": "kotlr-development",
      "total_posts": 15111,
      "updated": 1540324883,
      "url": "https://kotlr-development.tumblr.com/",
      "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
      "is_optout_ads": true
    }"""

    const val blogNsfw: String = """{
      "ask": true,
      "ask_anon": true,
      "ask_page_title": "kotlr-development",
      "can_send_fan_mail": false,
      "can_submit": true,
      "can_subscribe": false,
      "description": "kotlr-development",
      "followed": false,
      "is_blocked_from_primary": false,
      "is_nsfw": true,
      "name": "kotlr-development",
      "posts": 57618,
      "share_likes": false,
      "submission_page_title": "kotlr-development",
      "submission_terms": {
        "accepted_types": [
          "photo",
          "link",
          "video"
        ],
        "tags": [
          "please post"
        ],
        "title": "kotlr-development",
        "guidelines": "kotlr-development"
      },
      "subscribed": false,
      "title": "kotlr-development",
      "total_posts": 57618,
      "updated": 1540324079,
      "url": "https://kotlr-development.tumblr.com/",
      "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
      "is_optout_ads": true
    }"""

    const val blogAuth: String = """{
      "ask": true,
      "ask_anon": true,
      "ask_page_title": "kotlr-development",
      "can_send_fan_mail": true,
      "can_submit": true,
      "can_subscribe": true,
      "description": "kotlr-development",
      "followed": true,
      "is_blocked_from_primary": false,
      "is_nsfw": false,
      "name": "kotlr-development",
      "posts": 243905,
      "share_likes": false,
      "submission_page_title": "Submit a post",
      "submission_terms": {
        "accepted_types": [
          "text",
          "photo",
          "quote",
          "link",
          "video"
        ],
        "tags": [],
        "title": "Submit a post",
        "guidelines": ""
      },
      "subscribed": false,
      "title": "kotlr-development",
      "total_posts": 243905,
      "updated": 1540324906,
      "url": "http://kotlr-development.tumblr.com/",
      "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
      "is_optout_ads": true
    }"""

    const val blogSelf: String = """{
      "admin": true,
      "ask": true,
      "ask_anon": true,
      "ask_page_title": "Ask me anything",
      "can_send_fan_mail": true,
      "can_submit": true,
      "can_subscribe": false,
      "description": "Kotlr",
      "drafts": 0,
      "facebook": "N",
      "facebook_opengraph_enabled": "N",
      "followed": false,
      "followers": 0,
      "is_blocked_from_primary": false,
      "is_nsfw": false,
      "messages": 2,
      "name": "kotlr-development",
      "posts": 47,
      "primary": true,
      "queue": 0,
      "share_likes": false,
      "submission_page_title": "Submit a post",
      "submission_terms": {
        "accepted_types": [
          "text",
          "photo",
          "quote",
          "link",
          "video"
        ],
        "tags": [],
        "title": "Submit a post",
        "guidelines": ""
      },
      "subscribed": false,
      "title": "Kotlr",
      "total_posts": 0,
      "tweet": "N",
      "twitter_enabled": false,
      "twitter_send": false,
      "type": "public",
      "updated": 1540056911,
      "url": "https://kotlr-development.tumblr.com/",
      "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
      "is_optout_ads": true
    }"""

    // endregion

    // region Neue Post Format samples

    const val npfAnouncementPost: String = """{
        "type": "blocks",
        "blog_name": "engineering",
        "blog": {
            "name": "engineering",
            "title": "Tumblr Engineering",
            "description": "Dispatches from the intrepid tinkerers behind technology at Tumblr.",
            "url": "https://engineering.tumblr.com/",
            "uuid": "t:CwoihvyyOxn8Mk5TUS0KDg",
            "updated": 1539793245
        },
        "id": 179149527679,
        "post_url": "https://engineering.tumblr.com/post/179149527679/new-public-api-and-neue-post-format-documentation",
        "slug": "new-public-api-and-neue-post-format-documentation",
        "date": "2018-10-17 16:20:44 GMT",
        "timestamp": 1539793244,
        "state": "published",
        "reblog_key": "vo5snebR",
        "tags": [
            "tumblr themes",
            "customize",
            "npf",
            "neue post format"
        ],
        "short_url": "https://tmblr.co/ZI3nWx2cs9Df-",
        "summary": "New Public API and Neue Post Format Documentation",
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": true,
        "note_count": 151,
        "trail": [
            {
                "content": [
                    {
                        "type": "text",
                        "text": "New Public API and Neue Post Format Documentation",
                        "subtype": "heading1"
                    },
                    {
                        "type": "text",
                        "text": "We’re abnormally jazzed to announce some significant updates to our public API and its documentation:",
                        "formatting": [
                            {
                                "type": "italic",
                                "start": 6,
                                "end": 23
                            }
                        ]
                    },
                    {
                        "type": "text",
                        "text": "Our Tumblr API documentation has moved to Github in Markdown format. It also includes a few new things here and there, like a section on newer and better Blog Unique Identifiers.",
                        "subtype": "unordered-list-item",
                        "formatting": [
                            {
                                "type": "link",
                                "start": 29,
                                "end": 48,
                                "url": "https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&b=t%3At91ETabjoxGIfSw_95N-SQ&p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&m=1"
                            },
                            {
                                "type": "link",
                                "start": 154,
                                "end": 177,
                                "url": "https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23blog-unique-identifiers&t=NTUyZGQ4NTRlYTk2MjdlZGU3ZDg1ZTUwYzhlZmQzZDliMTBiMjRjZixYNmdkeGkyOA%3D%3D&b=t%3At91ETabjoxGIfSw_95N-SQ&p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&m=1"
                            }
                        ]
                    },
                    {
                        "type": "text",
                        "text": "The Neue Post Format is now available for use via the Tumblr API when consuming or creating posts! You can now make posts using a JSON specification that’s easier to use than HTML and will be more extensible moving forward as we build new ways of posting.",
                        "subtype": "unordered-list-item",
                        "formatting": [
                            {
                                "type": "link",
                                "start": 4,
                                "end": 20,
                                "url": "https://engineering.tumblr.com/post/164826109535/building-the-tumblr-neue-post-format"
                            }
                        ]
                    },
                    {
                        "type": "text",
                        "text": "The new public documentation on Github now includes the JSON specification of the Neue Post Format to help you consume NPF and create Posts using NPF. We aren’t currently planning to deprecate the “Legacy” posting flows (yet), but at some point in the future we won’t be able to guarantee that HTML posts will look as intended on all devices and platforms.",
                        "subtype": "unordered-list-item",
                        "formatting": [
                            {
                                "type": "link",
                                "start": 56,
                                "end": 98,
                                "url": "https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fnpf-spec.md&t=ZDMxNjI1NTA5NzhmMGU3Y2E4NGI2NGQ4MTUwYmU3YjkzOGZiZGMxMyxYNmdkeGkyOA%3D%3D&b=t%3At91ETabjoxGIfSw_95N-SQ&p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&m=1"
                            }
                        ]
                    },
                    {
                        "type": "text",
                        "text": "Work on the Neue Post Format is ongoing here at Tumblr as we make the posting experience better, more streamlined, and more exciting; any changes we make will be documented in our new public docs on Github. Watch our new public doc repository to find out when these changes happen! ",
                        "subtype": "unordered-list-item",
                        "formatting": [
                            {
                                "type": "link",
                                "start": 176,
                                "end": 205,
                                "url": "https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&b=t%3At91ETabjoxGIfSw_95N-SQ&p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&m=1"
                            },
                            {
                                "type": "link",
                                "start": 207,
                                "end": 281,
                                "url": "https://t.umblr.com/redirect?z=https%3A%2F%2Fhelp.github.com%2Farticles%2Fwatching-and-unwatching-repositories%2F&t=NTM0NzUwZDkxOTExN2ZhMzUyOGJkMjU2YTUxOTEyZDlhMDAzNzM1MixYNmdkeGkyOA%3D%3D&b=t%3At91ETabjoxGIfSw_95N-SQ&p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&m=1"
                            }
                        ]
                    },
                    {
                        "type": "text",
                        "text": "You can pass along the query parameter ?npf=true to any Tumblr API endpoint that returns Posts to return those Posts in the Neue Post Format rather than the legacy Post format.",
                        "subtype": "unordered-list-item",
                        "formatting": []
                    },
                    {
                        "type": "text",
                        "text": "To get started with our public API, register your own OAuth application and try using one of our Official API Clients! If you have any questions, please hit us up.",
                        "formatting": [
                            {
                                "type": "link",
                                "start": 36,
                                "end": 71,
                                "url": "https://www.tumblr.com/oauth/apps"
                            },
                            {
                                "type": "link",
                                "start": 76,
                                "end": 117,
                                "url": "https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23official-tumblr-api-client-libraries&t=MGYyOTg0MjI5MzlmYjlkZDcwYTRiYWI0ODA1ZTEzNTgxOTJlMjQzZSxYNmdkeGkyOA%3D%3D&b=t%3At91ETabjoxGIfSw_95N-SQ&p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&m=1"
                            },
                            {
                                "type": "link",
                                "start": 153,
                                "end": 162,
                                "url": "https://www.tumblr.com/support"
                            }
                        ]
                    }
                ],
                "layout": [],
                "post": {
                    "id": "179080448939"
                },
                "blog": {
                    "name": "engineering",
                    "title": "Tumblr Engineering",
                    "description": "Dispatches from the intrepid tinkerers behind technology at Tumblr.",
                    "url": "https://engineering.tumblr.com/",
                    "uuid": "t:CwoihvyyOxn8Mk5TUS0KDg",
                    "updated": 1539793245,
                    "subscribed": false,
                    "can_subscribe": true,
                    "followed": true,
                    "active": true
                }
            }
        ],
        "content": [
            {
                "type": "text",
                "text": "Heads up that we also added a new option to the Theme Customize page that’ll enable us to help keep Neue Post Format content looking great on your blog! If you’re someone with a custom theme and you want to retain full control of your blog’s look and style, then feel free to turn this off.",
                "formatting": [
                    {
                        "type": "bold",
                        "start": 0,
                        "end": 152
                    },
                    {
                        "type": "link",
                        "start": 44,
                        "end": 68,
                        "url": "https://www.tumblr.com/customize"
                    }
                ]
            },
            {
                "type": "image",
                "media": [
                    {
                        "url": "https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_500.png",
                        "type": "image/png",
                        "width": 500,
                        "height": 420
                    },
                    {
                        "url": "https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_400.png",
                        "type": "image/png",
                        "width": 400,
                        "height": 336
                    },
                    {
                        "url": "https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_250.png",
                        "type": "image/png",
                        "width": 250,
                        "height": 210
                    },
                    {
                        "url": "https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_100.png",
                        "type": "image/png",
                        "width": 100,
                        "height": 84
                    },
                    {
                        "url": "https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_75sq.png",
                        "type": "image/png",
                        "width": 75,
                        "height": 75
                    }
                ]
            }
        ],
        "layout": [],
        "liked_timestamp": 1539817301,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": true,
        "display_avatar": true
    }"""

    // endregion

    // region Full Response samples

    const val blogLikesResponseGood: String = """{
        "meta": {
            "status": 200,
            "msg": "OK"
        },
        "response": {
            "liked_posts": [
                {
                    "type": "text",
                    "blog_name": "engineering",
                    "blog": {
                        "name": "engineering",
                        "title": "Tumblr Engineering",
                        "description": "Dispatches from the intrepid tinkerers behind technology at Tumblr.",
                        "url": "https://engineering.tumblr.com/",
                        "uuid": "t:CwoihvyyOxn8Mk5TUS0KDg",
                        "updated": 1539793245
                    },
                    "id": 179149527679,
                    "post_url": "https://engineering.tumblr.com/post/179149527679/new-public-api-and-neue-post-format-documentation",
                    "slug": "new-public-api-and-neue-post-format-documentation",
                    "date": "2018-10-17 16:20:44 GMT",
                    "timestamp": 1539793244,
                    "state": "published",
                    "format": "html",
                    "reblog_key": "vo5snebR",
                    "tags": [
                        "tumblr themes",
                        "customize",
                        "npf",
                        "neue post format"
                    ],
                    "short_url": "https://tmblr.co/ZI3nWx2cs9Df-",
                    "summary": "New Public API and Neue Post Format Documentation",
                    "is_blocks_post_format": false,
                    "recommended_source": null,
                    "recommended_color": null,
                    "followed": true,
                    "liked": true,
                    "note_count": 147,
                    "title": null,
                    "body": "<p><a href=\"https://engineering.tumblr.com/post/179080448939/new-public-api-and-neue-post-format-documentation\" class=\"tumblr_blog\">engineering</a>:</p><blockquote>\n<h1>New Public API and Neue Post Format Documentation</h1>\n<p>We’re <span class=\"npf_color_chandler\"><i>abnormally jazzed</i></span> to announce some significant updates to our public API and its documentation:</p>\n<ul><li>Our Tumblr API documentation <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">has moved to Github</a> in Markdown format. It also includes a few new things here and there, like a section on newer and better <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23blog-unique-identifiers&amp;t=NTUyZGQ4NTRlYTk2MjdlZGU3ZDg1ZTUwYzhlZmQzZDliMTBiMjRjZixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Blog Unique Identifiers</a>.</li>\n<li>The <a href=\"https://engineering.tumblr.com/post/164826109535/building-the-tumblr-neue-post-format\">Neue Post Format</a> is now available for use via the Tumblr API when consuming or creating posts! You can now make posts using a JSON specification that’s easier to use than HTML and will be more extensible moving forward as we build new ways of posting.</li>\n<li>The new public documentation on Github now includes the <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fnpf-spec.md&amp;t=ZDMxNjI1NTA5NzhmMGU3Y2E4NGI2NGQ4MTUwYmU3YjkzOGZiZGMxMyxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">JSON specification of the Neue Post Format</a> to help you consume NPF and create Posts using NPF. We aren’t currently planning to deprecate the “Legacy” posting flows (yet), but at some point in the future we won’t be able to guarantee that HTML posts will look as intended on all devices and platforms.</li>\n<li>Work on the Neue Post Format is ongoing here at Tumblr as we make the posting experience better, more streamlined, and more exciting; any changes we make will be documented in <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">our new public docs on Github</a>. <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fhelp.github.com%2Farticles%2Fwatching-and-unwatching-repositories%2F&amp;t=NTM0NzUwZDkxOTExN2ZhMzUyOGJkMjU2YTUxOTEyZDlhMDAzNzM1MixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Watch our new public doc repository to find out when these changes happen!</a>\n</li>\n<li>You can pass along the query parameter <span class=\"npf_color_ross\">?npf=true</span> to any Tumblr API endpoint that returns Posts to return those Posts in the Neue Post Format rather than the legacy Post format.</li>\n</ul><p>To get started with our public API, <a href=\"https://www.tumblr.com/oauth/apps\">register your own OAuth application</a> and <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23official-tumblr-api-client-libraries&amp;t=MGYyOTg0MjI5MzlmYjlkZDcwYTRiYWI0ODA1ZTEzNTgxOTJlMjQzZSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">try using one of our Official API Clients</a>! If you have any questions, please <a href=\"https://www.tumblr.com/support\">hit us up</a>.</p>\n</blockquote>\n<p><b>Heads up that we also added a new option to <a href=\"https://www.tumblr.com/customize\">the Theme Customize page</a> that’ll enable us to help keep Neue Post Format content looking great on your blog!</b> If you’re someone with a custom theme and you want to retain full control of your blog’s look and style, then feel free to turn this off.</p><figure class=\"tmblr-full\" data-orig-height=\"420\" data-orig-width=\"500\"><img src=\"https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_540.png\" data-orig-height=\"420\" data-orig-width=\"500\"/></figure>",
                    "reblog": {
                        "comment": "<p><p><b>Heads up that we also added a new option to <a href=\"https://www.tumblr.com/customize\">the Theme Customize page</a> that’ll enable us to help keep Neue Post Format content looking great on your blog!</b> If you’re someone with a custom theme and you want to retain full control of your blog’s look and style, then feel free to turn this off.</p><figure class=\"tmblr-full\" data-orig-height=\"420\" data-orig-width=\"500\"><img src=\"https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_540.png\" data-orig-height=\"420\" data-orig-width=\"500\"></figure></p>",
                        "tree_html": "<p><a href=\"https://engineering.tumblr.com/post/179080448939/new-public-api-and-neue-post-format-documentation\" class=\"tumblr_blog\">engineering</a>:</p>\n<blockquote>\n<h1>New Public API and Neue Post Format Documentation</h1>\n<p>We’re <span class=\"npf_color_chandler\"><i>abnormally jazzed</i></span> to announce some significant updates to our public API and its documentation:</p>\n<ul>\n<li>Our Tumblr API documentation <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">has moved to Github</a> in Markdown format. It also includes a few new things here and there, like a section on newer and better <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23blog-unique-identifiers&amp;t=NTUyZGQ4NTRlYTk2MjdlZGU3ZDg1ZTUwYzhlZmQzZDliMTBiMjRjZixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Blog Unique Identifiers</a>.</li>\n<li>The <a href=\"https://engineering.tumblr.com/post/164826109535/building-the-tumblr-neue-post-format\">Neue Post Format</a> is now available for use via the Tumblr API when consuming or creating posts! You can now make posts using a JSON specification that’s easier to use than HTML and will be more extensible moving forward as we build new ways of posting.</li>\n<li>The new public documentation on Github now includes the <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fnpf-spec.md&amp;t=ZDMxNjI1NTA5NzhmMGU3Y2E4NGI2NGQ4MTUwYmU3YjkzOGZiZGMxMyxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">JSON specification of the Neue Post Format</a> to help you consume NPF and create Posts using NPF. We aren’t currently planning to deprecate the “Legacy” posting flows (yet), but at some point in the future we won’t be able to guarantee that HTML posts will look as intended on all devices and platforms.</li>\n<li>Work on the Neue Post Format is ongoing here at Tumblr as we make the posting experience better, more streamlined, and more exciting; any changes we make will be documented in <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">our new public docs on Github</a>. <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fhelp.github.com%2Farticles%2Fwatching-and-unwatching-repositories%2F&amp;t=NTM0NzUwZDkxOTExN2ZhMzUyOGJkMjU2YTUxOTEyZDlhMDAzNzM1MixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Watch our new public doc repository to find out when these changes happen!</a>\n</li>\n<li>You can pass along the query parameter <span class=\"npf_color_ross\">?npf=true</span> to any Tumblr API endpoint that returns Posts to return those Posts in the Neue Post Format rather than the legacy Post format.</li>\n</ul>\n<p>To get started with our public API, <a href=\"https://www.tumblr.com/oauth/apps\">register your own OAuth application</a> and <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23official-tumblr-api-client-libraries&amp;t=MGYyOTg0MjI5MzlmYjlkZDcwYTRiYWI0ODA1ZTEzNTgxOTJlMjQzZSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">try using one of our Official API Clients</a>! If you have any questions, please <a href=\"https://www.tumblr.com/support\">hit us up</a>.</p>\n</blockquote>"
                    },
                    "trail": [
                        {
                            "blog": {
                                "name": "engineering",
                                "active": true,
                                "theme": {
                                    "avatar_shape": "circle",
                                    "background_color": "#529ECC",
                                    "body_font": "Helvetica Neue",
                                    "header_bounds": 0,
                                    "header_image": "https://static.tumblr.com/d78a5bdf0d88a1faa030a65e968b31cb/ehm1tdz/NN6o5a2ft/tumblr_static_4guy50qh7e048880gk4sw0w0s.png",
                                    "header_image_focused": "https://static.tumblr.com/d78a5bdf0d88a1faa030a65e968b31cb/ehm1tdz/NN6o5a2ft/tumblr_static_4guy50qh7e048880gk4sw0w0s_2048_v2.png",
                                    "header_image_scaled": "https://static.tumblr.com/d78a5bdf0d88a1faa030a65e968b31cb/ehm1tdz/NN6o5a2ft/tumblr_static_4guy50qh7e048880gk4sw0w0s_2048_v2.png",
                                    "header_stretch": false,
                                    "link_color": "#ffffff",
                                    "show_avatar": false,
                                    "show_description": true,
                                    "show_header_image": true,
                                    "show_title": false,
                                    "title_color": "#FFFFFF",
                                    "title_font": "Gibson",
                                    "title_font_weight": "bold"
                                },
                                "share_likes": false,
                                "share_following": false,
                                "can_be_followed": true
                            },
                            "post": {
                                "id": "179080448939"
                            },
                            "content_raw": "<p><h1>New Public API and Neue Post Format Documentation</h1>\n<p>We’re <span class=\"npf_color_chandler\"><i>abnormally jazzed</i></span> to announce some significant updates to our public API and its documentation:</p>\n<ul><li>Our Tumblr API documentation <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">has moved to Github</a> in Markdown format. It also includes a few new things here and there, like a section on newer and better <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23blog-unique-identifiers&amp;t=NTUyZGQ4NTRlYTk2MjdlZGU3ZDg1ZTUwYzhlZmQzZDliMTBiMjRjZixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Blog Unique Identifiers</a>.</li>\n<li>The <a href=\"https://engineering.tumblr.com/post/164826109535/building-the-tumblr-neue-post-format\">Neue Post Format</a> is now available for use via the Tumblr API when consuming or creating posts! You can now make posts using a JSON specification that’s easier to use than HTML and will be more extensible moving forward as we build new ways of posting.</li>\n<li>The new public documentation on Github now includes the <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fnpf-spec.md&amp;t=ZDMxNjI1NTA5NzhmMGU3Y2E4NGI2NGQ4MTUwYmU3YjkzOGZiZGMxMyxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">JSON specification of the Neue Post Format</a> to help you consume NPF and create Posts using NPF. We aren’t currently planning to deprecate the “Legacy” posting flows (yet), but at some point in the future we won’t be able to guarantee that HTML posts will look as intended on all devices and platforms.</li>\n<li>Work on the Neue Post Format is ongoing here at Tumblr as we make the posting experience better, more streamlined, and more exciting; any changes we make will be documented in <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">our new public docs on Github</a>. <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fhelp.github.com%2Farticles%2Fwatching-and-unwatching-repositories%2F&amp;t=NTM0NzUwZDkxOTExN2ZhMzUyOGJkMjU2YTUxOTEyZDlhMDAzNzM1MixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Watch our new public doc repository to find out when these changes happen!</a>\n</li>\n<li>You can pass along the query parameter <span class=\"npf_color_ross\">?npf=true</span> to any Tumblr API endpoint that returns Posts to return those Posts in the Neue Post Format rather than the legacy Post format.</li>\n</ul><p>To get started with our public API, <a href=\"https://www.tumblr.com/oauth/apps\">register your own OAuth application</a> and <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23official-tumblr-api-client-libraries&amp;t=MGYyOTg0MjI5MzlmYjlkZDcwYTRiYWI0ODA1ZTEzNTgxOTJlMjQzZSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">try using one of our Official API Clients</a>! If you have any questions, please <a href=\"https://www.tumblr.com/support\">hit us up</a>.</p></p>",
                            "content": "<p><h1>New Public API and Neue Post Format Documentation</h1>\n<p>We&rsquo;re <span class=\"npf_color_chandler\"><i>abnormally jazzed</i></span> to announce some significant updates to our public API and its documentation:</p>\n<ul><li>Our Tumblr API documentation <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">has moved to Github</a> in Markdown format. It also includes a few new things here and there, like a section on newer and better <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23blog-unique-identifiers&amp;t=NTUyZGQ4NTRlYTk2MjdlZGU3ZDg1ZTUwYzhlZmQzZDliMTBiMjRjZixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Blog Unique Identifiers</a>.</li>\n<li>The <a href=\"https://engineering.tumblr.com/post/164826109535/building-the-tumblr-neue-post-format\">Neue Post Format</a> is now available for use via the Tumblr API when consuming or creating posts! You can now make posts using a JSON specification that&rsquo;s easier to use than HTML and will be more extensible moving forward as we build new ways of posting.</li>\n<li>The new public documentation on Github now includes the <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fnpf-spec.md&amp;t=ZDMxNjI1NTA5NzhmMGU3Y2E4NGI2NGQ4MTUwYmU3YjkzOGZiZGMxMyxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">JSON specification of the Neue Post Format</a> to help you consume NPF and create Posts using NPF. We aren&rsquo;t currently planning to deprecate the &ldquo;Legacy&rdquo; posting flows (yet), but at some point in the future we won&rsquo;t be able to guarantee that HTML posts will look as intended on all devices and platforms.</li>\n<li>Work on the Neue Post Format is ongoing here at Tumblr as we make the posting experience better, more streamlined, and more exciting; any changes we make will be documented in <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs&amp;t=YWMzYjk3ZDQ0ZTg5YjdkNjk2NWI5NDM5ZWJhMGI2ZmU1NmU4ZTU1NSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">our new public docs on Github</a>. <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fhelp.github.com%2Farticles%2Fwatching-and-unwatching-repositories%2F&amp;t=NTM0NzUwZDkxOTExN2ZhMzUyOGJkMjU2YTUxOTEyZDlhMDAzNzM1MixYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">Watch our new public doc repository to find out when these changes happen!</a>\n</li>\n<li>You can pass along the query parameter <span class=\"npf_color_ross\">?npf=true</span> to any Tumblr API endpoint that returns Posts to return those Posts in the Neue Post Format rather than the legacy Post format.</li>\n</ul><p>To get started with our public API, <a href=\"https://www.tumblr.com/oauth/apps\">register your own OAuth application</a> and <a href=\"https://t.umblr.com/redirect?z=https%3A%2F%2Fgithub.com%2Ftumblr%2Fdocs%2Fblob%2Fmaster%2Fapi.md%23official-tumblr-api-client-libraries&amp;t=MGYyOTg0MjI5MzlmYjlkZDcwYTRiYWI0ODA1ZTEzNTgxOTJlMjQzZSxYNmdkeGkyOA%3D%3D&amp;b=t%3At91ETabjoxGIfSw_95N-SQ&amp;p=https%3A%2F%2Fcyle-test-private-3.tumblr.com%2Fpost%2F179080395015%2Fnew-public-api-and-neue-post-format-documentation&amp;m=1\">try using one of our Official API Clients</a>! If you have any questions, please <a href=\"https://www.tumblr.com/support\">hit us up</a>.</p></p>",
                            "is_root_item": true
                        },
                        {
                            "blog": {
                                "name": "engineering",
                                "active": true,
                                "theme": {
                                    "avatar_shape": "circle",
                                    "background_color": "#529ECC",
                                    "body_font": "Helvetica Neue",
                                    "header_bounds": 0,
                                    "header_image": "https://static.tumblr.com/d78a5bdf0d88a1faa030a65e968b31cb/ehm1tdz/NN6o5a2ft/tumblr_static_4guy50qh7e048880gk4sw0w0s.png",
                                    "header_image_focused": "https://static.tumblr.com/d78a5bdf0d88a1faa030a65e968b31cb/ehm1tdz/NN6o5a2ft/tumblr_static_4guy50qh7e048880gk4sw0w0s_2048_v2.png",
                                    "header_image_scaled": "https://static.tumblr.com/d78a5bdf0d88a1faa030a65e968b31cb/ehm1tdz/NN6o5a2ft/tumblr_static_4guy50qh7e048880gk4sw0w0s_2048_v2.png",
                                    "header_stretch": false,
                                    "link_color": "#ffffff",
                                    "show_avatar": false,
                                    "show_description": true,
                                    "show_header_image": true,
                                    "show_title": false,
                                    "title_color": "#FFFFFF",
                                    "title_font": "Gibson",
                                    "title_font_weight": "bold"
                                },
                                "share_likes": false,
                                "share_following": false,
                                "can_be_followed": true
                            },
                            "post": {
                                "id": "179149527679"
                            },
                            "content_raw": "<p><p><b>Heads up that we also added a new option to <a href=\"https://www.tumblr.com/customize\">the Theme Customize page</a> that’ll enable us to help keep Neue Post Format content looking great on your blog!</b> If you’re someone with a custom theme and you want to retain full control of your blog’s look and style, then feel free to turn this off.</p><figure class=\"tmblr-full\" data-orig-height=\"420\" data-orig-width=\"500\"><img src=\"https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_540.png\" data-orig-height=\"420\" data-orig-width=\"500\"></figure></p>",
                            "content": "<p><p><b>Heads up that we also added a new option to <a href=\"https://www.tumblr.com/customize\">the Theme Customize page</a> that&rsquo;ll enable us to help keep Neue Post Format content looking great on your blog!</b> If you&rsquo;re someone with a custom theme and you want to retain full control of your blog&rsquo;s look and style, then feel free to turn this off.</p><figure class=\"tmblr-full\"><img src=\"https://66.media.tumblr.com/3b604c8cc19b8b4544ed4e303a583b40/tumblr_inline_pgr31bcG3D1qzyw0r_540.png\" class=\"\"/></figure></p>",
                            "is_current_item": true
                        }
                    ],
                    "liked_timestamp": 1539817301,
                    "can_like": true,
                    "can_reblog": true,
                    "can_send_in_message": true,
                    "can_reply": true,
                    "display_avatar": true
                }
            ],
            "liked_count": 202,
            "_links": {
                "next": {
                    "href": "/v2/blog/kotlr-development.tumblr.com/likes?limit=1&before=1539817301",
                    "method": "GET",
                    "query_params": {
                        "limit": "1",
                        "before": "1539817301"
                    }
                },
                "prev": {
                    "href": "/v2/blog/kotlr-development.tumblr.com/likes?limit=1&after=1539817301",
                    "method": "GET",
                    "query_params": {
                        "limit": "1",
                        "after": "1539817301"
                    }
                }
            }
        }
    }"""

    const val blogLikesUnauthorized: String = """{
        "meta": {
            "status": 403,
            "msg": "Forbidden"
        },
        "response": "Not authorized."
    }"""

    const val dashUnauthorized: String = """{
        "meta": {
            "status": 401,
            "msg": "Unauthorized"
        },
        "response": [],
        "errors": [
            {
                "title": "Unauthorized",
                "code": 1016,
                "detail": "Unable to authorize"
            }
        ]
    }"""

    // endregion

    // region Note samples

    const val postWithNotesData: String = """{
        "type": "quote",
        "blog_name": "yourplayersaidwhat",
        "blog": {
            "name": "yourplayersaidwhat",
            "title": "Stuff My Players Say",
            "description": "The wonderful wit, witticism, and weirdness of tabletop gamers.<br /><br />\n<!--<strong>Update: The ask and submit boxes are CLOSED until August 14! See <a href=\"https://yourplayersaidwhat.tumblr.com/post/176721050778/mod-post-submit-ask-boxes-closed-through\">this post</a> for details.</strong><br /><br />-->\n\nNeed help submitting a quote? <a href=\"http://yourplayersaidwhat.tumblr.com/tagged/how+to+submit\">Check our FAQs!</a>\n<br /><br />\n\nWant advice on how to run a game, play a game, or find a game? Try the <a href=\"http://rpg.stackexchange.com\">RPG Stack Exchange</a>, <a href=\"http://lfglistings.tumblr.com\">@lfglistings</a>, and <a href=\"https://roll20.net/\">Roll20</a>!<br /><br />\n\n\nNew reader? Bored and looking for a laugh? Check out a \n<a href=\"http://yourplayersaidwhat.tumblr.com/random\">random quote!</a>",
            "url": "https://yourplayersaidwhat.tumblr.com/",
            "uuid": "t:37p-R809YkHFQpJN2UUw4g",
            "updated": 1541224307
        },
        "id": 179710586172,
        "post_url": "https://yourplayersaidwhat.tumblr.com/post/179710586172/a-pile-of-rats-is-hardly-the-worst-thing-were",
        "slug": "a-pile-of-rats-is-hardly-the-worst-thing-were",
        "date": "2018-11-03 05:51:47 GMT",
        "timestamp": 1541224307,
        "state": "published",
        "format": "html",
        "reblog_key": "c61ysWN6",
        "tags": [
            "dnd",
            "submission",
            "why npcs hate pcs"
        ],
        "short_url": "https://tmblr.co/ZHegNss2dNbUqy",
        "summary": "a pile of rats is hardly the worst thing we’re going to leave here tonight",
        "is_blocks_post_format": false,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "post_author": "nightsmaren",
        "post_author_is_adult": false,
        "is_submission": true,
        "liked": false,
        "note_count": 96,
        "text": "a pile of rats is hardly the worst thing we’re going to leave here tonight",
        "source": "our ratman thief",
        "reblog": {
            "comment": "<p>our ratman thief</p>",
            "tree_html": ""
        },
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "notes": [
            {
                "type": "like",
                "timestamp": 1541225157,
                "blog_name": "all-things-fandomstuck",
                "blog_uuid": "t:KewseyAE9ywZrqPNt5Cw7g",
                "blog_url": "http://all-things-fandomstuck.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "reblog",
                "timestamp": 1541225148,
                "blog_name": "emomfr",
                "blog_uuid": "t:jSs9hmuFGzerv6MB7yx8SA",
                "blog_url": "http://emomfr.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle",
                "post_id": "179710864782",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541225143,
                "blog_name": "emomfr",
                "blog_uuid": "t:jSs9hmuFGzerv6MB7yx8SA",
                "blog_url": "http://emomfr.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541225129,
                "blog_name": "makhortheeight",
                "blog_uuid": "t:v0kkIVoRwFAcLd5uclxKnA",
                "blog_url": "https://makhortheeight.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541225127,
                "blog_name": "crazynimbat",
                "blog_uuid": "t:qrj9JJlJOw_1kU7EpZO5KQ",
                "blog_url": "https://crazynimbat.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541225120,
                "blog_name": "watchhowfasticansummonthefandoms",
                "blog_uuid": "t:pg2S1fbdFG1StFPRQLe4pQ",
                "blog_url": "https://watchhowfasticansummonthefandoms.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541225115,
                "blog_name": "mcbacondaddy",
                "blog_uuid": "t:2ltPH9dTs_V0ru8zRt6y4g",
                "blog_url": "https://mcbacondaddy.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541225101,
                "blog_name": "transcendent-acedia",
                "blog_uuid": "t:gUy5YGeFQQOB6PLKiDtiZw",
                "blog_url": "https://transcendent-acedia.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "reblog",
                "timestamp": 1541225099,
                "blog_name": "unluckypunk13",
                "blog_uuid": "t:2Vqapwo3p4bICFxRkPrvKQ",
                "blog_url": "http://unluckypunk13.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle",
                "post_id": "179710851668",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541225095,
                "blog_name": "unluckypunk13",
                "blog_uuid": "t:2Vqapwo3p4bICFxRkPrvKQ",
                "blog_url": "http://unluckypunk13.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541225072,
                "blog_name": "askgearhoof",
                "blog_uuid": "t:Ol5IYmUlAnADo-RkKBAjGw",
                "blog_url": "https://askgearhoof.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541225071,
                "blog_name": "aromanticanakinskywalker",
                "blog_uuid": "t:0T1MM65D2d37BcpTaTIBTQ",
                "blog_url": "http://aromanticanakinskywalker.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541225063,
                "blog_name": "princesscandypatrol",
                "blog_uuid": "t:3374jaHxRleV_48F3OhZpQ",
                "blog_url": "https://princesscandypatrol.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541225063,
                "blog_name": "arrrowxx",
                "blog_uuid": "t:LWeVFIq_HE8E_B0vblkNOw",
                "blog_url": "http://arrrowxx.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541225053,
                "blog_name": "baconpancaakes",
                "blog_uuid": "t:UF5Dp73zz98e9DxDMlpObg",
                "blog_url": "https://baconpancaakes.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541225022,
                "blog_name": "mori-hime-chan",
                "blog_uuid": "t:NKKLT8uVwyxhT0iIwZKGlg",
                "blog_url": "https://mori-hime-chan.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541225009,
                "blog_name": "calcifiedtreefrog",
                "blog_uuid": "t:68xUXL1ZDu5ltfheqBTjug",
                "blog_url": "https://calcifiedtreefrog.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "reblog",
                "timestamp": 1541224971,
                "blog_name": "do-you-hear-the-people-fuck",
                "blog_uuid": "t:hYSKeGvOn1XBCjgDDnK4fQ",
                "blog_url": "http://do-you-hear-the-people-fuck.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle",
                "post_id": "179710810943",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541224968,
                "blog_name": "themajesticpotabro",
                "blog_uuid": "t:XFCfxKeUqeLSsVcsBUjT4w",
                "blog_url": "https://themajesticpotabro.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224966,
                "blog_name": "motherofth0usands",
                "blog_uuid": "t:ZEKsehLuASLMCySNeAF4xw",
                "blog_url": "http://motherofth0usands.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224953,
                "blog_name": "foulwitchperfection",
                "blog_uuid": "t:XGR2zSDwN1WYoLpHI_jbwA",
                "blog_url": "https://foulwitchperfection.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224926,
                "blog_name": "dragonfly-the-twink",
                "blog_uuid": "t:RN9FErYu0lJ1dXTvWMpCDw",
                "blog_url": "https://dragonfly-the-twink.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224915,
                "blog_name": "lazyemisfandomtrash",
                "blog_uuid": "t:XAyq3bjfYrG4JjxRCNeqkA",
                "blog_url": "https://lazyemisfandomtrash.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "reblog",
                "timestamp": 1541224898,
                "blog_name": "therandomduck",
                "blog_uuid": "t:M-J6Z4CiKwkTIjrZob8HDA",
                "blog_url": "http://therandomduck.tumblr.com/",
                "followed": false,
                "avatar_shape": "square",
                "post_id": "179710786102",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541224897,
                "blog_name": "therandomduck",
                "blog_uuid": "t:M-J6Z4CiKwkTIjrZob8HDA",
                "blog_url": "http://therandomduck.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224892,
                "blog_name": "dracninja",
                "blog_uuid": "t:CGzmPESBlxcYvs4e0iMW0w",
                "blog_url": "https://dracninja.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224868,
                "blog_name": "dekubits",
                "blog_uuid": "t:2lYwqdCGJGA7qAEBI_PkfQ",
                "blog_url": "http://dekubits.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224850,
                "blog_name": "disabledwarrior",
                "blog_uuid": "t:4hUSuXAbsX4ewQAqH55AFw",
                "blog_url": "http://disabledwarrior.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224848,
                "blog_name": "mcwolfy",
                "blog_uuid": "t:tzjJDbY7VCi_z4YeSxyqnQ",
                "blog_url": "http://mcwolfy.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "reblog",
                "timestamp": 1541224833,
                "blog_name": "spycopoth",
                "blog_uuid": "t:7IslimI9WwJeoqI4ONZfdw",
                "blog_url": "http://spycopoth.tumblr.com/",
                "followed": false,
                "avatar_shape": "square",
                "post_id": "179710761975",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541224831,
                "blog_name": "spycopoth",
                "blog_uuid": "t:7IslimI9WwJeoqI4ONZfdw",
                "blog_url": "http://spycopoth.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224811,
                "blog_name": "mian-jy-ism",
                "blog_uuid": "t:zou3Pv7R5had9b1nPBnqRA",
                "blog_url": "https://mian-jy-ism.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "reblog",
                "timestamp": 1541224802,
                "blog_name": "catfeeshq",
                "blog_uuid": "t:Y8SaVAwDNYJJEQAbgAFsPA",
                "blog_url": "http://catfeeshq.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle",
                "post_id": "179710751509",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541224796,
                "blog_name": "catfeeshq",
                "blog_uuid": "t:Y8SaVAwDNYJJEQAbgAFsPA",
                "blog_url": "http://catfeeshq.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224791,
                "blog_name": "deegandungeons",
                "blog_uuid": "t:e-6iJMrNAg3B0NoLEGjZEA",
                "blog_url": "https://deegandungeons.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224754,
                "blog_name": "ladysaladpuddin",
                "blog_uuid": "t:rNfZYJ-c5rYLsF0c4YAWPg",
                "blog_url": "http://ladysaladpuddin.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224745,
                "blog_name": "yetanotherwrittingblog",
                "blog_uuid": "t:GECGEBR2z8bl7z6hE11jjQ",
                "blog_url": "https://yetanotherwrittingblog.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224709,
                "blog_name": "skeletalweird0",
                "blog_uuid": "t:WGMyDdumEe8arBD04ZKx1g",
                "blog_url": "https://skeletalweird0.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224706,
                "blog_name": "soraskingdomkey",
                "blog_uuid": "t:8ps0GDsrG3I0T_ob5djwdQ",
                "blog_url": "https://soraskingdomkey.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224667,
                "blog_name": "cowboypunkcolt",
                "blog_uuid": "t:x89r1-OscbZHk3zCmELinQ",
                "blog_url": "http://cowboypunkcolt.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "reblog",
                "timestamp": 1541224665,
                "blog_name": "taco-that-is-half-eaten",
                "blog_uuid": "t:Se_7PyKkir96kSG_4ZxKoQ",
                "blog_url": "https://taco-that-is-half-eaten.tumblr.com/",
                "followed": false,
                "avatar_shape": "square",
                "post_id": "179710707779",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541224663,
                "blog_name": "himinfluff",
                "blog_uuid": "t:hSMfbEZlxXBCMnpyQ99G5Q",
                "blog_url": "https://himinfluff.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224659,
                "blog_name": "taco-that-is-half-eaten",
                "blog_uuid": "t:Se_7PyKkir96kSG_4ZxKoQ",
                "blog_url": "https://taco-that-is-half-eaten.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224654,
                "blog_name": "antivertigo",
                "blog_uuid": "t:o4x2bV9NSeQumrMXZ5oiTg",
                "blog_url": "http://antivertigo.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224649,
                "blog_name": "electricjudgement",
                "blog_uuid": "t:T_kMoNTM37fLkzMoV3M_jA",
                "blog_url": "http://electricjudgement.tumblr.com/",
                "followed": false,
                "avatar_shape": "square"
            },
            {
                "type": "like",
                "timestamp": 1541224647,
                "blog_name": "malslany",
                "blog_uuid": "t:N0TVTwbWCBJcUN56nTSFxQ",
                "blog_url": "http://malslany.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "like",
                "timestamp": 1541224640,
                "blog_name": "kehito",
                "blog_uuid": "t:hLVstwB6QKJPx6NhZM9D4A",
                "blog_url": "https://kehito.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            },
            {
                "type": "reblog",
                "timestamp": 1541224634,
                "blog_name": "carmilla-hollis-22",
                "blog_uuid": "t:l_4whGQ5XMcYzZSEWLroag",
                "blog_url": "http://carmilla-hollis-22.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle",
                "post_id": "179710697906",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "reblog",
                "timestamp": 1541224633,
                "blog_name": "lucifers-demonic-breast-milk",
                "blog_uuid": "t:TL1xqz3DT7b7AoSloO21Gg",
                "blog_url": "https://lucifers-demonic-breast-milk.tumblr.com/",
                "followed": false,
                "avatar_shape": "square",
                "post_id": "179710697614",
                "reblog_parent_blog_name": "yourplayersaidwhat"
            },
            {
                "type": "like",
                "timestamp": 1541224630,
                "blog_name": "carmilla-hollis-22",
                "blog_uuid": "t:l_4whGQ5XMcYzZSEWLroag",
                "blog_url": "http://carmilla-hollis-22.tumblr.com/",
                "followed": false,
                "avatar_shape": "circle"
            }
        ],
        "can_reply": true,
        "display_avatar": true
    }"""

    const val postWithReblogData: String = """{
        "type": "photo",
        "blog_name": "kotlr-development",
        "blog": {
            "name": "kotlr-development",
            "title": "ukIuGYR_Jcdm60j7Nb95dg",
            "description": "ukIuGYR_Jcdm60j7Nb95dg",
            "url": "http://kotlr-development.tumblr.com/",
            "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg-8dg",
            "updated": 1541218656
        },
        "id": 179708498104,
        "post_url": "http://kotlr-development.tumblr.com/post/179708498104/ukIuGYR_Jcdm60j7Nb95dg",
        "slug": "ukIuGYR_Jcdm60j7Nb95dg",
        "date": "2018-11-03 04:17:36 GMT",
        "timestamp": 1541218656,
        "state": "published",
        "format": "html",
        "reblog_key": "ukIuGYR_Jcdm60j7Nb95dg",
        "tags": [],
        "short_url": "https://tmblr.co/ukIuGYR_Jcdm60j7Nb95dg",
        "summary": "",
        "is_blocks_post_format": true,
        "recommended_source": null,
        "recommended_color": null,
        "followed": true,
        "liked": false,
        "note_count": 18111,
        "source_url": "https://kotlr-development.tumblr.com/post/179695024238",
        "source_title": "kotlr-development",
        "caption": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblog": {
            "comment": "",
            "tree_html": "ukIuGYR_Jcdm60j7Nb95dg"
        },
        "trail": [
            {
                "blog": {
                    "name": "kotlr-development",
                    "active": true,
                    "theme": {
                        "header_full_width": 905,
                        "header_full_height": 1280,
                        "header_focus_width": 905,
                        "header_focus_height": 509,
                        "avatar_shape": "circle",
                        "background_color": "#FFA444",
                        "body_font": "Helvetica Neue",
                        "header_bounds": "420,905,929,0",
                        "header_image": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/yTWphj55j/tumblr_static_.jpg",
                        "header_image_focused": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/KFMphj55l/tumblr_static_tumblr_static__focused_v3.jpg",
                        "header_image_scaled": "https://static.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/ukIuGYR_Jcdm60j7Nb95dg/yTWphj55j/tumblr_static__2048_v2.jpg",
                        "header_stretch": true,
                        "link_color": "#234357",
                        "show_avatar": true,
                        "show_description": true,
                        "show_header_image": true,
                        "show_title": true,
                        "title_color": "#000000",
                        "title_font": "Gibson",
                        "title_font_weight": "regular"
                    },
                    "share_likes": false,
                    "share_following": false,
                    "can_be_followed": true
                },
                "post": {
                    "id": "179695024238"
                },
                "content_raw": "ukIuGYR_Jcdm60j7Nb95dg",
                "content": "ukIuGYR_Jcdm60j7Nb95dg",
                "is_root_item": true
            }
        ],
        "photoset_layout": "1",
        "photos": [
            {
                "caption": "",
                "original_size": {
                    "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_phl0r1VvkB1wo3df8o1_1280.png",
                    "width": 1278,
                    "height": 797
                },
                "alt_sizes": [
                    {
                        "url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_phl0r1VvkB1wo3df8o1_1280.png",
                        "width": 1278,
                        "height": 797
                    }
                ]
            }
        ],
        "reblogged_from_id": 179708440402,
        "reblogged_from_url": "http://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/179708440402",
        "reblogged_from_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblogged_from_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblogged_from_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "reblogged_from_can_message": true,
        "reblogged_from_following": false,
        "reblogged_root_id": "78942513841564",
        "reblogged_root_url": "https://ukIuGYR_Jcdm60j7Nb95dg.tumblr.com/post/44564815165161",
        "reblogged_root_name": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblogged_root_title": "ukIuGYR_Jcdm60j7Nb95dg",
        "reblogged_root_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "reblogged_root_can_message": true,
        "reblogged_root_following": false,
        "can_like": true,
        "can_reblog": true,
        "can_send_in_message": true,
        "can_reply": false,
        "display_avatar": true
    }"""

    const val noteWithFormatting: String = """{
        "type": "reply",
        "timestamp": 1541254204,
        "blog_name": "kotlr-development",
        "blog_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "blog_url": "http://kotlr-development.tumblr.com/",
        "followed": false,
        "avatar_shape": "square",
        "reply_text": "ukIuGYR_Jcdm60j7Nb95dg",
        "formatting": [
            {
                "type": "mention",
                "start": 0,
                "end": 13,
                "blog": {
                    "name": "kotlr-development",
                    "url": "http://kotlr-development.tumblr.com/",
                    "uuid": "t:ukIuGYR_Jcdm60j7Nb95dg"
                }
            }
        ],
        "can_block": true
    }"""

    const val noteReblogWithAddedText: String = """{
        "type": "reblog",
        "timestamp": 1541254415,
        "blog_name": "kotlr-development",
        "blog_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "blog_url": "https://kotlr-development.tumblr.com/",
        "followed": false,
        "avatar_shape": "square",
        "added_text": "ukIuGYR_Jcdm60j7Nb95dg",
        "post_id": "17974864546569",
        "reblog_parent_blog_name": "kotlr-development",
        "can_block": true
    }"""

    const val noteWithResponseText: String = """{
        "type": "reply",
        "timestamp": 1541238046,
        "blog_name": "kotlr-development",
        "blog_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "blog_url": "http://kotlr-development.tumblr.com/",
        "followed": false,
        "avatar_shape": "square",
        "reply_text": "ukIuGYR_Jcdm60j7Nb95dg",
        "formatting": [],
        "can_block": true
    }"""

    const val notePosted: String = """{
        "type": "posted",
        "timestamp": 1541183549,
        "blog_name": "kotlr-development",
        "blog_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg-Q",
        "blog_url": "http://kotlr-development.tumblr.com/",
        "followed": true,
        "avatar_shape": "circle"
    }"""

    const val noteLike: String = """{
        "type": "like",
        "timestamp": 1541225157,
        "blog_name": "kotlr-development",
        "blog_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "blog_url": "http://kotlr-development.tumblr.com/",
        "followed": false,
        "avatar_shape": "circle"
    }"""

    const val notePostAttribution: String = """{
        "type": "post_attribution",
        "timestamp": 1541121830,
        "blog_name": "kotlr-development",
        "blog_uuid": "t:ukIuGYR_Jcdm60j7Nb95dg",
        "blog_url": "https://kotlr-development.tumblr.com/",
        "followed": false,
        "avatar_shape": "square",
        "post_id": "177893552649",
        "post_attribution_type": "gif",
        "post_attribution_type_name": "GIF",
        "photo_url": "https://66.media.tumblr.com/ukIuGYR_Jcdm60j7Nb95dg/tumblr_pfqccrjucr1wrh47eo4_500.gif",
        "photo_width": 500,
        "photo_height": 225
    }"""

    // endregion

}
