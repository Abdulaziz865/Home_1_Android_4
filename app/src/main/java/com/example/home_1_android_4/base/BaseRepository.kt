package com.example.home_1_android_4.base

import androidx.lifecycle.liveData
import com.example.home_1_android_4.utils.Resource

abstract class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: Exception) {
            emit(Resource.Failure(null ,ioException.localizedMessage ?: "Что-то пошло не так..."))
        }
    }
}