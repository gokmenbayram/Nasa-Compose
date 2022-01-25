package com.nasacompose.presentation.viewmodel.curiosity

import androidx.lifecycle.viewModelScope
import com.nasacompose.base.viewmodel.BaseViewModel
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

    fun fetchCuriosityPhotos() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                marsRoverPhotoRepo.fetchCuriosityPhotos().collect {
                    val data = it.data
                }
            }
        }
    }
}