package com.nasacompose.presentation.viewmodel.curiosity

import androidx.paging.PagingData
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.repository.MarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CuriosityViewModel @Inject constructor(
    private val marsRepository: MarsRepository
): BaseViewModel() {

    fun fetchCuriosityRoverInfo(): Flow<PagingData<PhotoDetailResponseModel>> {
        return marsRepository.fetchRoverInfo()
    }
}