package com.highthunder.kotlr

import org.intellij.lang.annotations.Language

object TumblrNpfSamples {
    // https://www.tumblr.com/docs/npf#post-identification
    @Language("json")
    val postIdentification: String = """
{
    "id": 1234567891234567,
    "blog": {
        "Standard API Short Blog Info object": "goes here"
    }
}
    """

    // https://www.tumblr.com/docs/npf#content-blocks
    @Language("json")
    val contentBlocks1: String = """
{
    "id": 1234,
    "blog": {
        "Standard API Short Blog Info object": "goes here"
    },
    "content": []
}
    """

    // https://www.tumblr.com/docs/npf#content-blocks
    @Language("json")
    val contentBlocks2: String = """
{
    "content": [
        {
            "type": "text",
            "text": "Hello world!"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-blocks
    @Language("json")
    val contentBlocks3: String = """
{
    "content": [
        {
            "type": "text",
            "text": "Hello world!"
        },
        {
            "type": "text",
            "text": "This is a second paragraph below the first."
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#media-objects
    @Language("json")
    val mediaObjects: String = """
{
    "url": "https://69.media.tumblr.com/path/to/image.jpg",
    "type": "image/jpg",
    "width": 540,
    "height": 405
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-text
    @Language("json")
    val contentBlockTypeText: String = """
{
    "content": [
        {
            "type": "text",
            "text": "Hello world!"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#special-note-leading-and-trailing-empty-text-blocks
    @Language("json")
    val contentBlockTypeText_leadingTrailingEmptyBlocks_before: String = """
{
    "content": [
        {
            "type": "text",
            "text": ""
        },
        {
            "type": "text",
            "text": "ello!"
        },
        {
            "type": "text",
            "text": ""
        },
        {
            "type": "text",
            "text": "my name is cyle!"
        },
        {
            "type": "text",
            "text": ""
        },
        {
            "type": "text",
            "text": ""
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#special-note-leading-and-trailing-empty-text-blocks
    @Language("json")
    val contentBlockTypeText_leadingTrailingEmptyBlocks_after: String = """
{
    "content": [
        {
            "type": "text",
            "text": "ello!"
        },
        {
            "type": "text",
            "text": ""
        },
        {
            "type": "text",
            "text": "my name is cyle!"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#text-block-basic-subtypes
    // TODO: Correct extra trailing ","
    @Language("json")
    val contentBlockTypeText_subtypes1: String = """
{
    "content": [
        {
            "type": "text",
            "text": "It's like Ben Franklin always said:"
        },
        {
            "type": "text",
            "subtype": "quote",
            "text": "Genius without education is like silver in the mine.",
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#text-block-basic-subtypes
    @Language("json")
    val contentBlockTypeText_subtypes2: String = """
{
    "content": [
        {
            "type": "text",
            "subtype": "heading1",
            "text": "New Post Forms Manifesto"
        },
        {
            "type": "text",
            "text": "There comes a moment in every company's life that they must redefine the rules..."
        },
        {
            "type": "text",
            "text": "We can choose to embrace this moment courageously, or we may choose to cower in fear."
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#text-block-basic-subtypes
    @Language("json")
    val contentBlockTypeText_subtypes3: String = """
{
    "content": [
        {
            "type": "text",
            "subtype": "heading2",
            "text": "what a great conversation"
        },
        {
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
        },
        {
            "type": "text",
            "subtype": "chat",
            "text": "oli: i'm oli",
            "formatting": [
                {
                    "start": 0,
                    "end": 3,
                    "type": "bold"
                }
            ]
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#text-block-subtype-list-item
    // TODO: Correct missing ","
    @Language("json")
    val contentBlockTypeText_subtypes4: String = """
{
    "content": [
        {
            "type": "text",
            "subtype": "heading1",
            "text": "Sward's Shopping List"
        },
        {
            "type": "text",
            "subtype": "ordered-list-item",
            "text": "Sword"
        },
        {
            "type": "text",
            "subtype": "ordered-list-item",
            "text": "Candy"
        },
        {
            "type": "text",
            "text": "But especially don't forget:"
        }
        {
            "type": "text",
            "subtype": "unordered-list-item",
            "text": "Death, which is uncountable on this list."
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#inline-formatting-within-a-text-block
    @Language("json")
    val contentBlockTypeText_formatting1: String = """
{
    "type": "text",
    "text": "supercalifragilisticexpialidocious",
    "formatting": [
        {
            "start": 0,
            "end": 20,
            "type": "bold"
        },
        {
            "start": 9,
            "end": 34,
            "type": "italic"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#inline-format-types-bold-italic-strikethrough
    @Language("json")
    val contentBlockTypeText_formatting2: String = """
{
    "type": "text",
    "text": "some bold and italic text",
    "formatting": [
        {
            "start": 5,
            "end": 9,
            "type": "bold"
        },
        {
            "start": 14,
            "end": 20,
            "type": "italic"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#inline-format-type-link
    @Language("json")
    val contentBlockTypeText_formatting3: String = """
{
    "type": "text",
    "text": "Found this link for you",
    "formatting": [
        {
            "start": 6,
            "end": 10,
            "type": "link",
            "url": "https://www.nasa.gov"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#inline-format-type-mention
    // TODO: Fix trailing ","
    @Language("json")
    val contentBlockTypeText_formatting4: String = """
{
    "type": "text",
    "text": "Shout out to @david",
    "formatting": [
        {
            "start": 13,
            "end": 19,
            "type": "mention",
            "blog": {
                "uuid": "t:123456abcdf",
                "name": "david",
                "url": "https://davidslog.com/",
            }
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#inline-format-type-color
    @Language("json")
    val contentBlockTypeText_formatting5: String = """
{
    "type": "text",
    "text": "Celebrate Pride Month",
    "formatting": [
        {
            "start": 10,
            "end": 15,
            "type": "color",
            "hex": "#ff492f"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-image
    @Language("json")
    val contentBlockTypeImage1: String = """
{
    "content": [
        {
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
            ],
            "alt_text": "Sonic the Hedgehog and friends"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-image
    @Language("json")
    val contentBlockTypeImage2: String = """
{
    "content": [
        {
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
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-image
    @Language("json")
    val contentBlockTypeImage3: String = """
{
    "content": [
        {
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
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#gif-posters
    @Language("json")
    val contentBlockTypeImage_gifPosters: String = """
{
    "content": [
        {
            "type": "image",
            "media": [
                {
                    "type": "image/gif",
                    "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.gif",
                    "width": 500,
                    "height": 400,
                    "poster": {
                        "type": "image/jpeg",
                        "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                        "width": 500,
                        "height": 400
                    }
                }
            ]
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-link
    @Language("json")
    val contentBlockTypeLink1: String = """
{
    "content": {
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
    }
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-link
    @Language("json")
    val contentBlockTypeLink2: String = """
{
    "content": {
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
    }
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-audio
    @Language("json")
    val contentBlockTypeAudio1: String = """
{
    "content": [
        {
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
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-audio
    // TODO: Fix unescaped html
    @Language("json")
    val contentBlockTypeAudio2: String = """
{
    "content": [
        {
            "type": "audio",
            "provider": "soundcloud",
            "title": "Mouth Sounds",
            "artist": "neilcic",
            "url": "https://soundcloud.com/neilcic/mouth-sounds",
            "embed_html": "<iframe width="100%" height="450" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/146805680&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>",
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
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-video
    @Language("json")
    val contentBlockTypeVideo1: String = """
{
    "content": [
        {
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
                    "url": "https://66.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame1.jpg",
                    "width": 200,
                    "height": 125
                },
                {
                    "type": "image/jpeg",
                    "url": "https://66.media.tumblr.com/previews/tumblr_nshp8oVOnV1rg0s9xo1_filmstrip_frame2.jpg",
                    "width": 200,
                    "height": 125
                }
            ],
            "can_autoplay_on_cellular": true
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#content-block-type-video
    // TODO: Fix unescaped html
    @Language("json")
    val contentBlockTypeVideo2: String = """
{
    "content": [
        {
            "type": "video",
            "provider": "youtube",
            "url": "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            "embed_html": "<iframe width="560" height="315" src="https://www.youtube.com/embed/dQw4w9WgXcQ" frameborder="0" allowfullscreen></iframe>",
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
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#layout-block-type-rows
    @Language("json")
    val layoutBlockTypeRows1: String = """
{
    "content": [
        {
            "type": "image",
            "media": [
                {
                    "type": "image/jpeg",
                    "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                    "width": 1280,
                    "height": 1073
                }
            ]
        },
        {
            "type": "image",
            "media": [
                {
                    "type": "image/jpeg",
                    "url": "http://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_1280.jpg",
                    "width": 1280,
                    "height": 1073
                }
            ]
        },
        {
            "type": "text",
            "text": "This is a paragraph underneath two images."
        }
    ],
    "layout": [
        {
            "type": "rows",
            "display": [
                {"blocks": [0, 1]},
                {"blocks": [2]}
            ]
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#layout-block-type-rows
    @Language("json")
    val layoutBlockTypeRows2: String = """
{
    "content": [
        {
            "type": "text",
            "text": "Cool pics of Tambler HQ"
        },
        {
            "type": "image",
            "media": []
        },
        {
            "type": "image",
            "media": []
        },
        {
            "type": "text",
            "text": "Everybody loves working at tambler."
        },
        {
            "type": "image",
            "media": []
        },
        {
            "type": "image",
            "media": []
        },
        {
            "type": "image",
            "media": []
        },
        {
            "type": "text",
            "text": "and that's all she wrote, folks!"
        }
    ],
    "layout": [
        {
            "type": "rows",
            "display": [
                {"blocks": [0]},
                {"blocks": [1, 2]},
                {"blocks": [3]},
                {"blocks": [4, 5, 6]},
                {"blocks": [7]}
            ]
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#layout-block-type-rows
    @Language("json")
    val layoutBlockTypeRows3: String = """
{
    "content": [
        {
            "type": "image",
            "media": []
        },
        {
            "type": "image",
            "media": []
        },
        {
            "type": "image",
            "media": []
        }
    ],
    "layout": [
        {
            "type": "rows",
            "display": [
                {"blocks": [2, 0, 1]}
            ]
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#layout-block-display-mode-carousel
    // TODO: Fix top level key
    @Language("json")
    val layoutBlockTypeRows_displayModeCarousel: String = """
"layout": [
    {
        "type": "rows",
        "display": [
            {"blocks": [0]}, // Single block, full-width
            {"blocks": [1, 2]}, // Two blocks, each weighted at 50% (e.g. a photoset)
            {"blocks": [3]},
            {"blocks": [4, 5, 6], "mode": {"type": "carousel"}}, // Carousel with three full-width blocks (see "Carousel Display Mode" below)
            {"blocks": [7]}
        ]
    }
]
    """

    // https://www.tumblr.com/docs/npf#layout-block-type-condensed
    // TODO: Fix top level key
    @Language("json")
    val layoutBlockTypeCondensed1: String = """
"layout": [
    {
        "type": "condensed",
        "truncate_after": 1
    }
]
    """

    // https://www.tumblr.com/docs/npf#layout-block-type-condensed
    // TODO: Fix top level key
    @Language("json")
    val layoutBlockTypeCondensed2: String = """
"layout": [
    {
        "type": "condensed",
        "truncate_after": 3,
        "blocks": [0, 1, 2, 3]
    }
]
    """

    // https://www.tumblr.com/docs/npf#layout-block-type-ask
    // TODO: Fix top level key
    @Language("json")
    val layoutBlockTypeAsk: String = """
"layout": [
    {
        "type": "ask",
        "blocks": [0, 1],
        "attribution": {
            "type": "blog",
            "url": "https://cyle.tumblr.com",
            "blog": {
                "Standard API Short Blog Info object": "goes here, for @cyle's blog"
            }
        }
    }
]
    """

    // https://www.tumblr.com/docs/npf#reblog-trail
    // TODO: Fix trailing ","
    @Language("json")
    val reblogTrail: String = """
{
    "trail": [
        {
            "post": {
                "id": "1234",
            },
            "blog": {
                "Standard API Short Blog Info object": "goes here"
            },
            "content": [
                {
                    "type": "text",
                    "text": "this is the root Post"
                }
            ],
            "layout": []
        },
        {
            "post": {
                "id": "3456",
            },
            "blog": {
                "Standard API Short Blog Info object": "goes here"
            },
            "content": [
                {
                    "type": "text",
                    "text": "this is the parent Post"
                },
                {
                    "type": "text",
                    "text": "this is another text block in the parent Post"
                },
            ],
            "layout": [
                {
                    "type": "rows",
                    "rows": [
                        [1, 0]
                    ]
                }
            ]
        }
    ],
    "content": [
        {
            "type": "text",
            "text": "lol, this is the content i am adding in my reblog of the parent Post"
        }
    ]
}
    """

    // https://www.tumblr.com/docs/npf#broken-trail-items
    // TODO: Fix top level key
    @Language("json")
    val reblogTrail_brokenTrailItems: String = """
"trail": [
    {
        "broken_blog_name": "old-broken-blog",
        "content": [
            {
                "type": "text",
                "text": "this is the root Post, which is broken"
            }
        ],
        "layout": []
    },
    {
        "broken_blog_name": "another-broken-blog",
        "content": [
            {
                "type": "text",
                "text": "this is the parent Post, which is also broken"
            },
            {
                "type": "text",
                "text": "this is another text block in the broken parent Post"
            },
        ],
        "layout": []
    }
]
    """

    // https://www.tumblr.com/docs/npf#attribution-type-post
    @Language("json")
    val attributionTypePost: String = """
{
    "type": "image",
    "media": [
        {
            "type": "image/gif",
            "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.gif",
            "width": 500,
            "height": 400
        }
    ],
    "attribution": {
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
    }
}
    """

    // https://www.tumblr.com/docs/npf#attribution-type-link
    @Language("json")
    val attributionTypeLink: String = """
{
    "type": "image",
    "media": [
        {
            "type": "image/jpg",
            "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
            "width": 1280,
            "height": 800
        }
    ],
    "attribution": {
        "type": "link",
        "url": "http://shahkashani.com/"
    }
}
    """

    // https://www.tumblr.com/docs/npf#attribution-type-blog
    // TODO: Fix trailing ","
    @Language("json")
    val attributionTypeBlog: String = """
{
    "content": [
        {
            "type": "text",
            "text": "This is an ask to @cyle from @randerson"
        },
        {
            "type": "text",
            "text": "This is another block in an ask to @cyle from @randerson"
        },
        {
            "type": "text",
            "text": "This is my response to the ask from @randerson!"
        },
    ],
    "layout": [
        {
            "type": "ask",
            "blocks": [0, 1],
            "attribution": {
                "type": "blog",
                "url": "https://randerson.tumblr.com",
                "blog": {
                    "Standard API Short Blog Info object": "goes here, for @randerson's blog"
                }
            }
        }
    ]
}

    """

    // https://www.tumblr.com/docs/npf#attribution-type-app
    // TODO: Remove illegal comment
    @Language("json")
    val attributionTypeApp: String = """
{
    "content": [
        {
            "type": "video",
            "provider": "instagram",
            "url": "https://www.instagram.com/p/BVZyxTklQWX/",
            "embed_html": "...",
            "media": {
                "url": "https://scontent.cdninstagram.com/t50.2886-16/19229730_166472833892337_5147282940048179200_n.mp4",
                "width": 480,
                "height": 480
            },
            "poster": [
                {
                    "type": "image/jpeg",
                    "url": "https://69.media.tumblr.com/b06fe71cc4ab47e93749df060ff54a90/tumblr_nshp8oVOnV1rg0s9xo1_500.jpg",
                    "width": 500,
                    "height": 400
                }
            ],
            "attribution": {
                "type": "app",
                "url": "https://www.instagram.com/p/BVZyxTklQWX/",
                "app_name": "Instagram",
                "display_text": "tibbythecorgi - Very Cute", // or "Listen on Bandcamp" for audio
                "logo": {
                    "url": "https://scontent.cdninstagram.com/path/to/logo.jpg",
                    "type": "image/jpeg",
                    "width": 64,
                    "height": 64
                }
            }
        }
    ]
}
    """
}
