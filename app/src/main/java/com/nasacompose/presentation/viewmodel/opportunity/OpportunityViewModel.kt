package com.nasacompose.presentation.viewmodel.opportunity

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
class OpportunityViewModel @Inject constructor(
    private val marsRepository: MarsRepository
): BaseViewModel() {

    private val _opportunityInfo = MutableLiveData<ArrayList<PhotoDetailResponseModel>>()
    val opportunityInfo: LiveData<ArrayList<PhotoDetailResponseModel>> get() = _opportunityInfo


}