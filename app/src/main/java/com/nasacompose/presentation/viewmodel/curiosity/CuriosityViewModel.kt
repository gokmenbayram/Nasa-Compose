package com.nasacompose.presentation.viewmodel.curiosity

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.repository.CuriosityRoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CuriosityViewModel @Inject constructor(
    private val remote: MarsRemoteDataSource
): BaseViewModel() {

    val curiosityRoverInfoList: Flow<PagingData<RoverInfoDetailResponseModel>> = Pager(
        PagingConfig(
            pageSize = 25
        )
    ) {
        CuriosityRoverRepository(remote)
    }.flow
}