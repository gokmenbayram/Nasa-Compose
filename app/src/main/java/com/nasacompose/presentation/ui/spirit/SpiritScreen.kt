package com.nasacompose.presentation.ui.spirit

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberImagePainter
import com.nasacompose.R
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.model.ui.RoverInfoUiState
import com.nasacompose.presentation.ui.curiosity.curiosityViewModel
import com.nasacompose.presentation.ui.custom.ErrorItem
import com.nasacompose.presentation.ui.custom.LoadingItem
import com.nasacompose.presentation.ui.custom.LoadingView
import com.nasacompose.presentation.ui.custom.RoverListItem
import com.nasacompose.presentation.viewmodel.spirit.SpiritViewModel

lateinit var spiritViewModel: SpiritViewModel

@Preview
@Composable
fun SpiritScreen(
    viewModel: SpiritViewModel = hiltViewModel()
) {

    spiritViewModel = viewModel

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        SpiritRoverFilter()
        SpiritRoverInfoList(spiritRoverInfoList = viewModel.spiritRoverInfoList.collectAsLazyPagingItems())
    }
}

@Composable
fun SpiritRoverFilter() {
    Image(
        painter = painterResource(R.drawable.ic_filter),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(25.dp)
            .padding(top = 5.dp)
            .clip(RoundedCornerShape(corner = CornerSize(13.dp)))
    )
}

@Composable
fun SpiritRoverInfoList(spiritRoverInfoList: LazyPagingItems<RoverInfoDetailResponseModel>) {
    LazyColumn(
        modifier = Modifier.padding(top = 5.dp)
    ) {
        items(spiritRoverInfoList.itemCount) { index ->
            spiritRoverInfoList[index]?.let {
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

        spiritRoverInfoList.apply {
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
                    val e = spiritRoverInfoList.loadState.refresh as LoadState.Error
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

    if (isFavorite) {
        //spiritViewModel.insertFavoriteRover(favoriteRover)
    } else {
        //spiritViewModel.deleteFavoriteRover(roverId)
    }
}