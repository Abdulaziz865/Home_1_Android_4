package com.example.home_1_android_4.ui.fragments.manga

import com.example.home_1_android_4.base.BaseViewModel
import com.example.home_1_android_4.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {
    fun fetchManga() = repository.fetchManga()
}