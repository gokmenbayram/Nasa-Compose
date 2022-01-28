package com.nasacompose.presentation.viewmodel.spirit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.repository.MarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SpiritViewModel @Inject constructor(
    private val marsRepository: MarsRepository
): BaseViewModel() {

    private val _spiritInfo = MutableLiveData<ArrayList<PhotoDetailResponseModel>>()
    val spiritInfo: LiveData<ArrayList<PhotoDetailResponseModel>> get() = _spiritInfo

}