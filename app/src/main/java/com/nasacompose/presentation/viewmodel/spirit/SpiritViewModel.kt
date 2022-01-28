package com.nasacompose.presentation.viewmodel.spirit

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.repository.CuriosityRoverRepository
import com.nasacompose.data.repository.SpiritRoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SpiritViewModel @Inject constructor(
    private val remote: MarsRemoteDataSource
): BaseViewModel() {

    val spiritRoverInfoList: Flow<PagingData<RoverInfoDetailResponseModel>> = Pager(
        PagingConfig(
            pageSize = 25
        )
    ) {
        SpiritRoverRepository(remote)
    }.flow

}