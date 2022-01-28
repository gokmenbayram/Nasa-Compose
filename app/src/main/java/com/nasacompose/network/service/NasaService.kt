package com.nasacompose.network.service

import com.nasacompose.BuildConfig
import com.nasacompose.data.model.response.PhotoResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {

    @GET("rovers/curiosity/photos")
    suspend fun fetchCuriosityPhot(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>


    @GET("rovers/opportunity/photos")
    suspend fun fetchOpportunityPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>


    @GET("rovers/spirit/photos")
    suspend fun fetchSpiritPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>


    @GET("rovers/curiosity/photos")
    suspend fun fetchCuriosityPhotos(
        @Query("page") page: Int,
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>

}