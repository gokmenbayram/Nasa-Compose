package com.nasacompose.data.repository

import com.nasacompose.base.utils.Resource
import com.nasacompose.data.model.response.PhotoResponseModel
import kotlinx.coroutines.flow.Flow

interface MarsRepositoryImpl {

    fun fetchCuriosityPhotos(): Flow<Resource<PhotoResponseModel>>
    suspend fun fetchOpportunityPhotos(): Flow<Resource<PhotoResponseModel>>
    suspend fun fetchSpiritPhotos(): Flow<Resource<PhotoResponseModel>>
}