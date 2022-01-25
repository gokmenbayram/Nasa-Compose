package com.nasacompose.data.model.response

data class RoverResponseModel(
    val id: Int,
    val name: String,
    val landing_date: String,
    val launch_date: String,
    val status: String
)
