package com.nasacompose.data.datasource.local

import com.nasacompose.data.model.local.FavoriteRover
import kotlinx.coroutines.flow.Flow

interface MarsLocalDataSourceImpl {

    fun getFavoriteRovers(): Flow<List<FavoriteRover>>
    fun insertFavoriteRover(favoriteRover: FavoriteRover)
    fun deleteFavoriteRover(roverId: Int): Int
}