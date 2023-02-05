package com.example.home_1_android_4.data.remote.apiservices

import com.example.home_1_android_4.data.models.manga.MangaData
import com.example.home_1_android_4.data.models.manga.MangaResponce
import com.example.home_1_android_4.data.models.manga.detail.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(): MangaResponce<MangaData>

    @GET("manga/{id}")
    suspend fun fetchMangaById(
        @Path("id") id: Int
    ): MangaDetail
}