package com.example.home_1_android_4.di

import com.example.home_1_android_4.data.remote.RetrofitClient
import com.example.home_1_android_4.data.remote.apiservices.AnimeApiService
import com.example.home_1_android_4.data.remote.apiservices.MangaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService() = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient): AnimeApiService =
        retrofitClient.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient): MangaApiService =
        retrofitClient.provideMangaApiService()

    @Singleton
    @Provides
    fun provideSignInApiService(retrofitClient: RetrofitClient) =
        retrofitClient.providerSignInApiService()
}
