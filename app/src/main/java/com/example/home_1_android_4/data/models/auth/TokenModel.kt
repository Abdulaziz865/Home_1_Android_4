package com.example.home_1_android_4.data.models.auth

import com.google.gson.annotations.SerializedName

data class TokenModel(

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,
)