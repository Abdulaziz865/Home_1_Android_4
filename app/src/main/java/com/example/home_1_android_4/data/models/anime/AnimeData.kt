package com.example.home_1_android_4.data.models.anime

import com.google.gson.annotations.SerializedName

data class AnimeData(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = ""
)