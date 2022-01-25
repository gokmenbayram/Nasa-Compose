package com.nasacompose.di

import com.nasacompose.BuildConfig
import com.nasacompose.network.service.NasaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()


    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): NasaService {
        return retrofit.create()
    }
}