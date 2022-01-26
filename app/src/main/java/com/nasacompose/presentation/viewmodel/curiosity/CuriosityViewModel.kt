package com.nasacompose.presentation.viewmodel.curiosity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.response.PhotoResponseModel
import com.nasacompose.data.repository.MarsRoverPhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CuriosityViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepository
): BaseViewModel() {

    private val _curiosityPhotos = MutableLiveData<ArrayList<PhotoDetailResponseModel>>()
    val curiosityPhotos: LiveData<ArrayList<PhotoDetailResponseModel>> get() = _curiosityPhotos

    fun fetchCuriosityPhotos() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                marsRoverPhotoRepo.fetchCuriosityPhotos().collect {
                    _curiosityPhotos.postValue(it.data?.photos)
                }
            }
        }
    }
}