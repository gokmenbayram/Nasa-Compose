package com.nasacompose.data.datasource.remote

import com.nasacompose.data.model.response.RoverInfoResponseModel
import retrofit2.Response

interface MarsRemoteDataSourceImpl {

    suspend fun fetchCuriosityInfo(page: Int): Response<RoverInfoResponseModel>
    suspend fun fetchOpportunityInfo(page: Int): Response<RoverInfoResponseModel>
    suspend fun fetchSpiritInfo(page: Int): Response<RoverInfoResponseModel>
}