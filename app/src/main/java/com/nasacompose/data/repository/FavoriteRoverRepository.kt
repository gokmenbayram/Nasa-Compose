package com.nasacompose.data.repository

import com.nasacompose.data.datasource.local.MarsLocalDataSource
import com.nasacompose.data.model.local.FavoriteRover
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRoverRepository @Inject constructor(
    private val local: MarsLocalDataSource
) {

     fun getFavoriteRovers(): Flow<List<FavoriteRover>> {
        return local.getFavoriteRovers()
    }

    fun deleteFavoriteRover(roverId: Int): Int {
        return local.deleteFavoriteRover(roverId)
    }

    fun insertFavoriteRover(favoriteRover: FavoriteRover) {
        return local.insertFavoriteRover(favoriteRover)
    }
}