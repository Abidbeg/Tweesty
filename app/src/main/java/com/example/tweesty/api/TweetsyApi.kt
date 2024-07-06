package com.example.tweesty.api

import com.example.tweesty.model.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {

    @GET("/v3/b/66759fb7acd3cb34a85b01dd?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") categoty: String): Response<List<TweetListItem>>

    @GET("/v3/b/66759fb7acd3cb34a85b01dd?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategory(): Response<List<String>>
}