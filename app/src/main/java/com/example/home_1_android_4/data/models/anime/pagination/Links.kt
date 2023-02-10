package com.example.home_1_android_4.data.models.anime.pagination

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("first")
    val first: String = "",
    @SerializedName("next")
    val next: String?,
    @SerializedName("last")
    val last: String = ""
)