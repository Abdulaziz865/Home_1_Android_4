package com.example.home_1_android_4.data.models.anime.detail

import com.example.home_1_android_4.data.models.anime.AnimeData
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: AnimeData
)