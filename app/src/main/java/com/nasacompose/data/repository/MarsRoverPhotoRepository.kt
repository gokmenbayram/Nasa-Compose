package com.nasacompose.data.repository

import com.nasacompose.base.utils.Resource
import com.nasacompose.data.datasource.remote.RemoteDataSource
import com.nasacompose.data.model.response.PhotoResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MarsRoverPhotoRepository @Inject constructor(
    private val remote: RemoteDataSource
): MarsRoverPhotoRepositoryImpl {

    override suspend fun fetchCuriosityPhotos(): Flow<Resource<PhotoResponseModel>> {
        return flow {
            emit(remote.fetchCuriosityPhotos())
        }.onStart {
            emit(Resource.Loading())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchOpportunityPhotos(): Flow<Resource<PhotoResponseModel>> {
        return flow {
            emit(remote.fetchOpportunityPhotos())
        }.onStart {
            emit(Resource.Loading())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchSpiritPhotos(): Flow<Resource<PhotoResponseModel>> {
        return flow {
            emit(remote.fetchSpiritPhotos())
        }.onStart {
            emit(Resource.Loading())
        }.flowOn(Dispatchers.IO)
    }
}