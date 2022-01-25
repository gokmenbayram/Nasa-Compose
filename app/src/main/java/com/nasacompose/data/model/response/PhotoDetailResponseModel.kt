package com.nasacompose.data.model.response

data class PhotoDetailResponseModel(
    val id: Int,
    val sol: Int,
    val camera: CameraResponseModel,
    val img_src: String,
    val earth_date: String,
    val rover: RoverResponseModel
)
