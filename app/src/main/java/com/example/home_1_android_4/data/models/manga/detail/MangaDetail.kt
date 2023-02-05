package com.example.home_1_android_4.data.models.manga.detail

import com.example.home_1_android_4.data.models.manga.MangaData
import com.google.gson.annotations.SerializedName

data class MangaDetail(
    @SerializedName("data")
    val data: MangaData
)