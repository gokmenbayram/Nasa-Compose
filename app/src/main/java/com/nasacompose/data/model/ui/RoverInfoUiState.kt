package com.nasacompose.data.model.ui

import com.nasacompose.data.model.response.CameraResponseModel
import com.nasacompose.data.model.response.RoverResponseModel

data class RoverInfoUiState(
    val camera: CameraResponseModel,
    val imageUrl : String,
    val rover: RoverResponseModel
)
