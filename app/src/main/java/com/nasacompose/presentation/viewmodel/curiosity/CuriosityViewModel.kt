package com.nasacompose.presentation.viewmodel.curiosity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.response.PhotoResponseModel
import com.nasacompose.data.repository.MarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CuriosityViewModel @Inject constructor(
    private val marsRepository: MarsRepository
): BaseViewModel() {

    private val a = MutableStateFlow<PhotoResponseModel?>(null)

    private val _curiosityInfo = MutableStateFlow(ArrayList<PhotoDetailResponseModel>())
    val curiosityInfo: StateFlow<ArrayList<PhotoDetailResponseModel>> get() = _curiosityInfo

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                combine(
                    marsRepository.fetchCuriosityPhotos()
                ) {
                    PhotoResponseModel(
                        it[0].data!!.photos
                    )
                }.collect {
                    _curiosityInfo.value = it.photos
                }
            }
        }
    }
}