package com.nasacompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nasacompose.base.utils.Resource
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.response.PhotoResponseModel
import com.nasacompose.network.service.NasaService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val marsRemote: NasaService
): MarsRepositoryImpl {

    override fun fetchRoverInfo(): Flow<PagingData<PhotoDetailResponseModel>> {
        return Pager(
            PagingConfig(
                pageSize = 25
            )) {
               MarsRemoteDataSource(marsRemote)
            }.flow
    }
}