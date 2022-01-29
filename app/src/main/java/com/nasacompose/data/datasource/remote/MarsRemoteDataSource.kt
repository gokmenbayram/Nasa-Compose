package com.nasacompose.data.datasource.remote

import com.nasacompose.data.model.response.RoverInfoResponseModel
import com.nasacompose.network.service.NasaService
import retrofit2.Response
import javax.inject.Inject

class MarsRemoteDataSource @Inject constructor(
    private val remote: NasaService
): MarsRemoteDataSourceImpl {

    override suspend fun fetchCuriosityInfo(page: Int): Response<RoverInfoResponseModel> {
        return remote.fetchCuriosityRoverInfo(page)
    }

    override suspend fun fetchOpportunityInfo(page: Int): Response<RoverInfoResponseModel> {
        return remote.fetchOpportunityInfo(page)
    }

    override suspend fun fetchSpiritInfo(page: Int): Response<RoverInfoResponseModel> {
        return remote.fetchSpiritInfo(page)
    }

    override suspend fun filterRover(roverName: String, camera: String, page: Int): Response<RoverInfoResponseModel> {
        return remote.filterRover(roverName, camera, page)
    }
}