package com.highthunder.kotlr

import com.highthunder.kotlr.response.type.user.ResponseUserInfo
import retrofit2.http.GET

interface KotlrRetrofitService {
    @GET("user/info")
    suspend fun getUserInfo(): ResponseUserInfo.Response
}
