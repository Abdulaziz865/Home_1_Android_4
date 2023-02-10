package com.example.home_1_android_4.ui.fragments.anime

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.home_1_android_4.base.BaseViewModel
import com.example.home_1_android_4.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {
    fun fetchAnime() = repository.fetchAnime().cachedIn(viewModelScope)
}