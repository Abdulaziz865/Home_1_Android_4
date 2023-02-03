package com.example.home_1_android_4.ui.fragments.first

import androidx.lifecycle.ViewModel
import com.example.home_1_android_4.data.repository.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repositories: AnimeRepositories) :
    ViewModel() {
    fun getAnimeScene() = repositories.getAnime()
}