package com.nasacompose.presentation.viewmodel.home

import com.nasacompose.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class HomeViewModel: BaseViewModel() {

    fun createLog() {
        println("Hello World")
    }
}