package com.example.home_1_android_4.utils

sealed class Resource<T>(
    var data: T? = null,
    var message: String
) {
    class Loading<T>(data: T? = null, message: String = "") : Resource<T>(null, "")

    class Success<T>(data: T, message: String = "") : Resource<T>(data, message)

    class Failure<T>(data: T?, message: String = "") : Resource<T>(data, message)
}