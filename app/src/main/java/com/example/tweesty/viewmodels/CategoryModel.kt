package com.example.tweesty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweesty.repository.TweestyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryModel @Inject constructor(private val repository: TweestyRepository) : ViewModel() {

    val category: StateFlow<List<String>>
        get() = repository.category

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}