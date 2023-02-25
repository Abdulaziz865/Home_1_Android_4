package com.example.home_1_android_4.base

import com.example.home_1_android_4.utils.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {

    protected open fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: Exception) {
            emit(Resource.Failure(ioException.localizedMessage ?: "Что-то пошло не так..."))
        }
    }
}