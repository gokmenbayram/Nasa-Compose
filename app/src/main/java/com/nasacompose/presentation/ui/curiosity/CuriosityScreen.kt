package com.nasacompose.presentation.ui.curiosity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.model.ui.RoverInfoUiState
import com.nasacompose.presentation.ui.custom.*
import com.nasacompose.presentation.viewmodel.curiosity.CuriosityViewModel


@Preview
@Composable
fun CuriosityScreen(
    viewModel: CuriosityViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
        horizontalAlignment = Alignment.End
    ) {
        CuriosityRoverInfoList(curiosityRoverInfoList = viewModel.curiosityRoverInfoList.collectAsLazyPagingItems())
    }
}

@Composable
fun CuriosityRoverInfoList(curiosityRoverInfoList: LazyPagingItems<RoverInfoDetailResponseModel>) {
    LazyColumn {
        items(curiosityRoverInfoList.itemCount) { index ->
            curiosityRoverInfoList[index]?.let {
                RoverListItem(
                    RoverInfoUiState(
                        roverId = it.id,
                        camera = it.camera,
                        imageUrl = it.img_src,
                        rover = it.rover
                    ),
                    ::isFavorite
                 )
            }
        }

        curiosityRoverInfoList.apply {
            when {
                loadState.refresh is LoadState.Loading -> { // Data is loaded for the first time
                    item {
                        LoadingView(modifier = Modifier.fillParentMaxSize())
                    }
                }
                loadState.append is LoadState.Loading -> {
                    item {
                        LoadingItem()
                    }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = curiosityRoverInfoList.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}


private fun isFavorite(roverId: Int, isFavorite: Boolean, favoriteRover: FavoriteRover) {

    /*if (isFavorite) {
        curiosityViewModel.insertFavoriteRover(favoriteRover)
    } else {
        curiosityViewModel.deleteFavoriteRover(roverId)
    }*/
}