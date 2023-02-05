package com.example.home_1_android_4.data.repositories

import com.example.home_1_android_4.base.BaseRepository
import com.example.home_1_android_4.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(private val mangaApiService: MangaApiService) :
    BaseRepository() {

    fun getManga() = doRequest {
        mangaApiService.fetchManga()
    }

    fun getSingleManga(id: Int) = doRequest {
        mangaApiService.fetchMangaById(id)
    }
}