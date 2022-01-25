package com.nasacompose.network.service

import com.nasacompose.BuildConfig
import com.nasacompose.data.model.response.PhotoResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NasaService {

    @GET("rovers/curiosity/photos")
    suspend fun fetchCuriosityPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>


    @GET("$ROVERS$OPPORTUNITY$PHOTOS")
    suspend fun fetchOpportunityPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>


    @GET("$ROVERS$SPIRIT$PHOTOS")
    suspend fun fetchSpiritPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<PhotoResponseModel>


    companion object {
        private const val ROVERS = "rovers/"
        private const val PHOTOS = "photos"

        private const val CURIOSITY = "${ROVERS}curiosity/$PHOTOS"
        private const val OPPORTUNITY = "opportunity/"
        private const val SPIRIT = "spirit/"
    }
}