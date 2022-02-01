package com.nasacompose.presentation.viewmodel.favorite

import androidx.lifecycle.viewModelScope
import com.nasacompose.base.viewmodel.BaseViewModel
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.repository.FavoriteRoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteRoverRepository: FavoriteRoverRepository
): BaseViewModel() {


    private val _favoriteState = MutableStateFlow(listOf(FavoriteRover()))
    val favoriteState: StateFlow<List<FavoriteRover>> get() = _favoriteState


    fun getFavoriteRover() {
        viewModelScope.launch {
            favoriteRoverRepository.getFavoriteRovers().collect {
                _favoriteState.value = it
            }
        }
    }
}