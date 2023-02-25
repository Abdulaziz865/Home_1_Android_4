package com.example.home_1_android_4.data.remote.apiservices

import com.example.home_1_android_4.data.models.manga.MangaData
import com.example.home_1_android_4.data.models.manga.MangaResponce
import com.example.home_1_android_4.data.models.manga.detail.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit : Int,
        @Query("page[offset]") offset : Int
    ): MangaResponce<MangaData>

    @GET("edge/manga/{id}")
    suspend fun fetchMangaById(
        @Path("id") id: Int
    ): MangaDetail
}