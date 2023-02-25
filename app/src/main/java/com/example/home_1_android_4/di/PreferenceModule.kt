package com.example.home_1_android_4.di

import android.content.Context
import com.example.home_1_android_4.data.locale.preference.helper.PreferenceHelper
import com.example.home_1_android_4.data.locale.preference.userdata.UserPreferencesData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context) =
        PreferenceHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferencesHelper: PreferenceHelper) =
        UserPreferencesData(preferencesHelper)
}