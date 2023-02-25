package com.example.home_1_android_4.data.models.auth

import com.google.gson.annotations.SerializedName

data class AuthModel(

    @SerializedName("grant_type")
    val grant_type: String,

    @SerializedName("username")
    val email: String,

    @SerializedName("password")
    val password: String
)