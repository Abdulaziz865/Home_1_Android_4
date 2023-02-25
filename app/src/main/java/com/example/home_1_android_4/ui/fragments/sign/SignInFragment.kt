package com.example.home_1_android_4.ui.fragments.sign

import com.example.home_1_android_4.base.BaseFragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_1_android_4.R
import com.example.home_1_android_4.data.locale.preference.userdata.UserPreferencesData
import com.example.home_1_android_4.data.models.auth.AuthModel
import com.example.home_1_android_4.databinding.FragmentSignInBinding
import com.example.home_1_android_4.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()
    @Inject
    lateinit var userPreferencesData: UserPreferencesData

    override fun setupSubscribes() = with(binding) {

        binding.btnNext.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).subscribe(
                onFailure = { toast("Fail aajajajaj!!!") },
                onSuccess = {
                    userPreferencesData.apply {
                        isAuthorized = true
                        accessToken = accessToken
                        refreshToken = refreshToken
                    }
                    toast("Error")
                    requireActivity().findNavController(R.id.nav_host_fragment)
                        .navigate(R.id.action_signInFlowFragment_to_homeFlowFragment)
                }
            )
        }
    }
}