package com.nasacompose.network.service

import com.nasacompose.BuildConfig
import com.nasacompose.data.model.response.RoverInfoResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaService {


    @GET("rovers/curiosity/photos")
    suspend fun fetchCuriosityRoverInfo(
        @Query("page") page: Int,
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<RoverInfoResponseModel>

    @GET("rovers/opportunity/photos")
    suspend fun fetchOpportunityInfo(
        @Query("page") page: Int,
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<RoverInfoResponseModel>


    @GET("rovers/spirit/photos")
    suspend fun fetchSpiritInfo(
        @Query("page") page: Int,
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<RoverInfoResponseModel>


    @GET(FILTER)
    suspend fun filterRover(
        @Path("roverName") roverName: String,
        @Query("camera") camera: String,
        @Query("page") page: Int,
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key: String = BuildConfig.API_KEY
    ): Response<RoverInfoResponseModel>


    companion object {
        private const val roverName = "roverName"
        private const val FILTER = "rovers/{$roverName}/photos"
    }
}