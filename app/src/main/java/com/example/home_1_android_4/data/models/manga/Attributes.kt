package com.example.home_1_android_4.data.models.manga

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("posterImage")
    val posterImageManga: PosterImageManga,
    @SerializedName("titles")
    val titles: Titles
)