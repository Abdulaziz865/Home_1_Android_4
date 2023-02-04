package com.example.home_1_android_4.data.repository

import androidx.lifecycle.liveData
import com.example.home_1_android_4.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApiService: AnimeApiService) {

    fun getAnime() = liveData {
        emit(animeApiService.fetchAnime())
    }

    fun getSingleAnime(id: Int) = liveData {
        emit(animeApiService.fetchAnimeById(id))
    }
}