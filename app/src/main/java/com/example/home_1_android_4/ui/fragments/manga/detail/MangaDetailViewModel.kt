package com.example.home_1_android_4.ui.fragments.manga.detail

import com.example.home_1_android_4.base.BaseViewModel
import com.example.home_1_android_4.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {
    fun fetchMangaById(id: Int) = repository.fetchMangaById(id)
}