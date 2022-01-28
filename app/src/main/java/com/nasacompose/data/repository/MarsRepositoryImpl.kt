package com.nasacompose.data.repository

import androidx.paging.PagingData
import com.nasacompose.base.utils.Resource
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.response.PhotoResponseModel
import kotlinx.coroutines.flow.Flow

interface MarsRepositoryImpl {
    fun fetchRoverInfo(): Flow<PagingData<PhotoDetailResponseModel>>
}