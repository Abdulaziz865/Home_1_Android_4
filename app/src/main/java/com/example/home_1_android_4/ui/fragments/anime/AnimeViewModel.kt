package com.example.home_1_android_4.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.home_1_android_4.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repositories: AnimeRepository) :
    ViewModel() {
    fun getAnimeScene() = repositories.getAnime()
}