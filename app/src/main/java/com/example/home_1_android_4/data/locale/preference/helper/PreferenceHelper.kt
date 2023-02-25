package com.example.home_1_android_4.data.locale.preference.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val preferenceHelper: SharedPreferences =
        context.getSharedPreferences("userStatus", Context.MODE_PRIVATE)

    operator fun invoke() = preferenceHelper
}