package com.nasacompose.presentation.viewmodel.spirit

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.repository.SpiritRoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SpiritViewModel @Inject constructor(
    private val remote: MarsRemoteDataSource
): BaseViewModel() {

    var isFilterRequest: Boolean = false
    var filterRequestData: Pair<String?, String?> = Pair(null,null)

    val spiritRoverInfoList: Flow<PagingData<RoverInfoDetailResponseModel>> = Pager(
        PagingConfig(
            pageSize = 25
        )
    ) {
        SpiritRoverRepository(remote, isFilterRequest, filterRequestData)
    }.flow

}