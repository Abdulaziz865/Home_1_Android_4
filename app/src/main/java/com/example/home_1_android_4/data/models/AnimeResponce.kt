package com.example.home_1_android_4.data.models

import com.google.gson.annotations.SerializedName

data class AnimeResponce<T>(
    @SerializedName("data")
    val data: List<T>
)