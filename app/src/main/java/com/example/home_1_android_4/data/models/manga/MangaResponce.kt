package com.example.home_1_android_4.data.models.manga

import com.google.gson.annotations.SerializedName

data class MangaResponce<T>(
    @SerializedName("data")
    val data: List<T>
)