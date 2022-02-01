package com.nasacompose.data.datasource.local

import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.db.service.NasaRoomService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarsLocalDataSource @Inject constructor(
    private val roomService: NasaRoomService
): MarsLocalDataSourceImpl {

    override fun getFavoriteRovers(): Flow<List<FavoriteRover>> {
        return roomService.getFavoriteRovers()
    }

    override fun insertFavoriteRover(favoriteRover: FavoriteRover) {
        roomService.insertFavoriteRover(favoriteRover)
    }

    override fun deleteFavoriteRover(roverId: Int): Int {
        return roomService.deleteFavoriteRover(roverId)
    }
}