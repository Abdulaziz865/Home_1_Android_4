package com.example.home_1_android_4.data.models.manga

import com.google.gson.annotations.SerializedName

data class MangaData(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)