package com.highthunder.kotlr.response

import com.squareup.moshi.JsonClass
import okhttp3.Headers

/**
 * RateLimitMetaData - Every response from the Tumblr API includes metadata about the current state of your
 * api token's rate limiting in the headers. This object parses and stores that data.
 *
 *
 * From Tumblr's documentation: https://www.tumblr.com/docs/en/api/v2#rate-limits
 * Usage of the Tumblr API is rate limited in a few ways, but we respond with a 429 Limit Exceeded response whenever a
 * consumer hits one of these limits. There is a global rate limit for all usage of the API per consumer,
 * as well as a few per-feature rate limits, such as how many posts you can make per day. The error message or
 * headers you receive with the 429 Limit Exceeded response should indicate what limit you've hit.
 *
 * These rate limits include:
 *
 * 300 API calls per minute, per IP address.
 * 18,000 API calls per hour, per IP address.
 * 432,000 API calls per day, per IP address.
 * 1,000 API calls per hour, per consumer key.
 * 5,000 API calls per day, per consumer key.
 * 250 new posts (including reblogs) per day, per user.
 * 150 images uploaded per day, per user.
 * 200 follows per day, per user.
 * 1,000 likes per day, per user.
 * 10 new blogs per day, per user.
 * 10 videos uploaded per day, per user.
 * 5 minutes of total video uploaded per day, per user.
 *
 * Note that these rate limits are based on the Tumblr servers' internal clocks and that the daily limits are per calendar day.
 *
 * There are also overall limits to a few specific actions, including:
 *
 * A blog can only follow 5,000 other blogs at a time.
 * A blog can only have 300 queued posts at a time.
 * You can only filter up to 1,000 tags at a time.
 *
 * @param dailyLimit The total number of requests your API key can make per 24 hour period.
 * @param dailyRemaining The number of requests that your API key has remaining in this 24 hour period.
 * @param timeUntilDailyReset The number of seconds until your API key's current 24 hour period resets.
 * @param hourlyLimit The total number of requests your API key can make per 1 hour period.
 * @param hourlyRemaining The number of requests that your API key has remaining in this 1 hour period.
 * @param timeUntilHourlyReset The number of seconds until your API key's current 1 hour period resets.
 */
@JsonClass(generateAdapter = true)
public data class RateLimitMetaData constructor(
    val dailyLimit: Long?,
    val dailyRemaining: Long?,
    val timeUntilDailyReset: Long?,
    val hourlyLimit: Long?,
    val hourlyRemaining: Long?,
    val timeUntilHourlyReset: Long?
) {
    private companion object {
        private const val DAILY_LIMIT_HEADER: String = "X-Ratelimit-Perday-Limit"
        private const val DAILY_REMAINING_HEADER: String = "X-Ratelimit-Perday-Remaining"
        private const val DAILY_RESET_HEADER: String = "X-Ratelimit-Perday-Reset"
        private const val HOURLY_LIMIT_HEADER: String = "X-Ratelimit-Perhour-Limit"
        private const val HOURLY_REMAINING_HEADER: String = "X-Ratelimit-Perhour-Remaining"
        private const val HOURLY_RESET_HEADER: String = "X-Ratelimit-Perhour-Reset"
    }

    internal constructor(header: Headers) : this(
        header[DAILY_LIMIT_HEADER]?.toLongOrNull(),
        header[DAILY_REMAINING_HEADER]?.toLongOrNull(),
        header[DAILY_RESET_HEADER]?.toLongOrNull(),
        header[HOURLY_LIMIT_HEADER]?.toLongOrNull(),
        header[HOURLY_REMAINING_HEADER]?.toLongOrNull(),
        header[HOURLY_RESET_HEADER]?.toLongOrNull()
    )
}
