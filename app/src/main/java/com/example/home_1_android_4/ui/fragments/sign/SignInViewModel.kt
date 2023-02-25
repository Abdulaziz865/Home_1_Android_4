package com.example.home_1_android_4.ui.fragments.sign

import com.example.home_1_android_4.base.BaseViewModel
import com.example.home_1_android_4.data.models.auth.AuthModel
import com.example.home_1_android_4.data.repositories.PostUserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: PostUserDataRepository
) : BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}