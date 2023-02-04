package com.example.home_1_android_4.data.remote.apiservices

import com.example.home_1_android_4.data.models.AnimeData
import com.example.home_1_android_4.data.models.AnimeResponce
import com.example.home_1_android_4.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): AnimeResponce<AnimeData>

    @GET("anime/{id}")
    suspend fun fetchAnimeById(
        @Path("id") id: Int
    ): AnimeDetail
}