package com.nasacompose.db.service

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nasacompose.data.model.local.FavoriteRover

@Database(
    entities = [
        FavoriteRover::class
    ], version = 2, exportSchema = false
)
abstract class NasaDatabase: RoomDatabase() {
    abstract fun nasaDaoService(): NasaRoomService
}