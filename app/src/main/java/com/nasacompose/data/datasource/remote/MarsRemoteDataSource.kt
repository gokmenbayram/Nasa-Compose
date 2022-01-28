package com.nasacompose.data.datasource.remote

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nasacompose.base.utils.Resource
import com.nasacompose.base.utils.getResult
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.response.PhotoResponseModel
import com.nasacompose.data.repository.MarsRepository
import com.nasacompose.network.service.NasaService
import java.lang.Exception
import javax.inject.Inject

class MarsRemoteDataSource @Inject constructor(
    private val remote: NasaService
): MarsRemoteDataSourceImpl, PagingSource<Int, PhotoDetailResponseModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoDetailResponseModel> {

        return try {
            val nextPage = params.key ?: 1
            val response = remote.fetchCuriosityPhotos(nextPage)

            val roverPhotoList = response.body()?.photos ?: emptyList()

            LoadResult.Page(
                data = roverPhotoList,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        } catch (ex: Exception) {
            return LoadResult.Error(ex)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PhotoDetailResponseModel>): Int? {
        return state.anchorPosition
    }
}