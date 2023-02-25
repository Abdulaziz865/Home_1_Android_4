package com.example.home_1_android_4.data.repositories

import com.example.home_1_android_4.base.BaseRepository
import com.example.home_1_android_4.data.models.auth.AuthModel
import com.example.home_1_android_4.data.remote.apiservices.SignInApiService
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val apiService: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        apiService.postAuthDataUser(authModel)
    }
}