package com.nasacompose.db.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nasacompose.data.model.local.FavoriteRover
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NasaRoomService {

    @Query("SELECT * FROM FavoriteRover")
    abstract fun getFavoriteRovers(): Flow<List<FavoriteRover>>

    @Query("Delete FROM FavoriteRover WHERE roverId = :roverId")
    abstract fun deleteFavoriteRover(roverId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFavoriteRover(favoriteRover: FavoriteRover): Long
}