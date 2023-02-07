package com.example.home_1_android_4.ui.fragments.anime.detail

import com.example.home_1_android_4.base.BaseViewModel
import com.example.home_1_android_4.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {
    fun fetchAnimeById(id: Int) = repository.fetchAnimeById(id)
}