package com.nasacompose.data.repository

import androidx.paging.*
import com.nasacompose.data.datasource.remote.MarsRemoteDataSource
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.model.response.RoverInfoResponseModel
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class SpiritRoverRepository @Inject constructor(
    private val remote: MarsRemoteDataSource,
    private val isFilterRequest: Boolean,
    private val filterRequestData: Pair<String?, String?>
): PagingSource<Int, RoverInfoDetailResponseModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RoverInfoDetailResponseModel> {

        var response: Response<RoverInfoResponseModel>? = null

        return try {
            val nextPage = params.key ?: 1

            response = if (isFilterRequest) {
                remote.filterRover(
                    roverName = filterRequestData.first!!,
                    camera = filterRequestData.second!!,
                    page = nextPage
                )
            } else {
                remote.fetchSpiritInfo(nextPage)
            }

            val roverPhotoList = response?.body()?.photos ?: emptyList()

            LoadResult.Page(
                data = roverPhotoList,
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
}