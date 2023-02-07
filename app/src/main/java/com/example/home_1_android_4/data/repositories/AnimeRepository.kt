package com.example.home_1_android_4.data.repositories

import com.example.home_1_android_4.base.BaseRepository
import com.example.home_1_android_4.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApiService: AnimeApiService) :
    BaseRepository() {

    fun fetchAnime() = doRequest {
        animeApiService.fetchAnime()
    }

    fun fetchAnimeById(id: Int) = doRequest {
        animeApiService.fetchAnimeById(id)
    }
}