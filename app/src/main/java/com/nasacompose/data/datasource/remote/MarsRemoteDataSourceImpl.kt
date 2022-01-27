package com.nasacompose.data.datasource.remote

import com.nasacompose.base.utils.Resource
import com.nasacompose.data.model.response.PhotoResponseModel

interface MarsRemoteDataSourceImpl {

    suspend fun fetchCuriosityPhotos(): Resource<PhotoResponseModel>
    suspend fun fetchOpportunityPhotos(): Resource<PhotoResponseModel>
    suspend fun fetchSpiritPhotos(): Resource<PhotoResponseModel>

}