package com.nasacompose.presentation.viewmodel.curiosity

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.datasource.local.MarsLocalDataSource
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.repository.CuriosityRoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CuriosityViewModel @Inject constructor(
    private val remote: MarsRemoteDataSource,
    private val local: MarsLocalDataSource,
    private val curiosityRoverRepository: CuriosityRoverRepository
): BaseViewModel() {

    val curiosityRoverInfoList: Flow<PagingData<RoverInfoDetailResponseModel>> = Pager(
        PagingConfig(
            pageSize = 25
        )
    ) {
        CuriosityRoverRepository(remote, local)
    }.flow


    fun insertFavoriteRover(favoriteRover: FavoriteRover) {
        curiosityRoverRepository.insertFavoriteRover(favoriteRover)
    }

    fun deleteFavoriteRover(roverId: Int) {
        curiosityRoverRepository.deleteFavoriteRover(roverId)
    }
}