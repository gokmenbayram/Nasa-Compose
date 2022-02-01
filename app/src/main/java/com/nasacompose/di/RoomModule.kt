package com.nasacompose.di

import androidx.room.Room
import com.nasacompose.Application.Companion.context
import com.nasacompose.db.service.NasaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase() = Room.databaseBuilder(
        context,
        NasaDatabase::class.java,
        "Nasa.db")
        .allowMainThreadQueries()
        .build()


    @Provides
    @Singleton
    fun provideNasaRoomService(database: NasaDatabase) = database.nasaDaoService()
        
}