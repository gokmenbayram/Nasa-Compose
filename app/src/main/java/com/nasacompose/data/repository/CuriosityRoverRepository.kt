package com.nasacompose.data.repository

import androidx.paging.*
import com.nasacompose.data.datasource.local.MarsLocalDataSource
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import java.lang.Exception
import javax.inject.Inject

class CuriosityRoverRepository @Inject constructor(
    private val remote: MarsRemoteDataSource,
    private val local: MarsLocalDataSource
): PagingSource<Int, RoverInfoDetailResponseModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RoverInfoDetailResponseModel> {

        return try {
            val nextPage = params.key ?: 1

            val response = remote.fetchCuriosityInfo(nextPage)

            val roverInfoDetail = response.body()?.photos ?: emptyList()

            LoadResult.Page(
                data = roverInfoDetail,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        } catch (ex: Exception) {
            return LoadResult.Error(ex)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RoverInfoDetailResponseModel>): Int? {
        return state.anchorPosition
    }

    fun deleteFavoriteRover(roverId: Int): Int {
        return local.deleteFavoriteRover(roverId)
    }

    fun insertFavoriteRover(favoriteRover: FavoriteRover) {
        return local.insertFavoriteRover(favoriteRover)
    }
}