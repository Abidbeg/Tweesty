package com.example.tweesty.repository

import com.example.tweesty.api.TweetsyApi
import com.example.tweesty.model.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweestyRepository @Inject constructor(private val tweesty: TweetsyApi) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _category

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories() {
        val response = tweesty.getCategory()
        if (response.isSuccessful && response.body() != null) {
            _category.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweesty.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}