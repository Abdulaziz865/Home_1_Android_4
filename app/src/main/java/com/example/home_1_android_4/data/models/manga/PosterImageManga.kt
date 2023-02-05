package com.example.home_1_android_4.data.models.manga

import com.google.gson.annotations.SerializedName

data class PosterImageManga(
    @SerializedName("small")
    val small: String = "",
    @SerializedName("original")
    val original: String = "",
    @SerializedName("large")
    val large: String = "",
    @SerializedName("tiny")
    val tiny: String = "",
    @SerializedName("medium")
    val medium: String = ""
)