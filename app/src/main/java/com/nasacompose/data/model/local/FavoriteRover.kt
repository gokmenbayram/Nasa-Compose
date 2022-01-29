package com.nasacompose.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteRover")
data class FavoriteRover(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val roverId: Int? = null,
    val cameraName: String? = null,
    val cameraFullName: String? = null,
    val status: String? = null,
    val landingDate: String? = null,
    val launchDate: String? = null,
    val imageUrl: String? = null
)
