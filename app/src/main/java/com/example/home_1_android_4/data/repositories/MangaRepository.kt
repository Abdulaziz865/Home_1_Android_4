package com.example.home_1_android_4.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.home_1_android_4.base.BaseRepository
import com.example.home_1_android_4.data.remote.apiservices.MangaApiService
import com.example.home_1_android_4.data.remote.pagingsourses.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(private val mangaApiService: MangaApiService) :
    BaseRepository() {

    fun fetchManga()= Pager(
        PagingConfig(pageSize = 20 , initialLoadSize = 10)
    ) {
        MangaPagingSource(mangaApiService)
    }.liveData

    fun fetchMangaById(id: Int) = doRequest {
        mangaApiService.fetchMangaById(id)
    }
}