package com.example.tweesty.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweesty.model.TweetListItem
import com.example.tweesty.repository.TweestyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsModel @Inject constructor(
    private val repository: TweestyRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweet: StateFlow<List<TweetListItem>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "islam"
            repository.getTweets(category)
        }
    }

}