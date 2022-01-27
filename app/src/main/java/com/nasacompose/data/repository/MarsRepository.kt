package com.nasacompose.data.repository

import com.nasacompose.base.utils.Resource
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.response.PhotoResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsRemote: MarsRemoteDataSource
): MarsRepositoryImpl {

    override fun fetchCuriosityPhotos(): Flow<Resource<PhotoResponseModel>> {
        return flow {
            emit(marsRemote.fetchCuriosityPhotos())
        }.onStart {
            emit(Resource.Loading())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchOpportunityPhotos(): Flow<Resource<PhotoResponseModel>> {
        return flow {
            emit(marsRemote.fetchOpportunityPhotos())
        }.onStart {
            emit(Resource.Loading())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchSpiritPhotos(): Flow<Resource<PhotoResponseModel>> {
        return flow {
            emit(marsRemote.fetchSpiritPhotos())
        }.onStart {
            emit(Resource.Loading())
        }.flowOn(Dispatchers.IO)
    }
}