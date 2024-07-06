package com.example.tweesty.model


import com.google.gson.annotations.SerializedName

data class TweetListItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("text")
    val text: String
)