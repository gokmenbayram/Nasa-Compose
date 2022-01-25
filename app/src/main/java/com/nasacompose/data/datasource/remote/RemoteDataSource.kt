package com.nasacompose.data.datasource.remote

import com.nasacompose.base.utils.Resource
import com.nasacompose.base.utils.getResult
import com.nasacompose.data.model.response.PhotoResponseModel
import com.nasacompose.network.service.NasaService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val remote: NasaService
): RemoteDataSourceImpl {

    override suspend fun fetchCuriosityPhotos(): Resource<PhotoResponseModel> {
        return getResult {
            remote.fetchCuriosityPhotos()
        }
    }

    override suspend fun fetchOpportunityPhotos(): Resource<PhotoResponseModel> {
        return getResult {
            remote.fetchOpportunityPhotos()
        }
    }

    override suspend fun fetchSpiritPhotos(): Resource<PhotoResponseModel> {
        return getResult {
            remote.fetchSpiritPhotos()
        }
    }
}