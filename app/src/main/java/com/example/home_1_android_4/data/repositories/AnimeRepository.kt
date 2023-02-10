package com.example.home_1_android_4.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.home_1_android_4.base.BaseRepository
import com.example.home_1_android_4.data.remote.apiservices.AnimeApiService
import com.example.home_1_android_4.data.remote.pagingsourses.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApiService: AnimeApiService) :
    BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(pageSize = 20 , initialLoadSize = 10)
    ) {
        AnimePagingSource(animeApiService)
    }.liveData

    fun fetchAnimeById(id: Int) = doRequest {
        animeApiService.fetchAnimeById(id = id)
    }
}