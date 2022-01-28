package com.nasacompose.presentation.ui.curiosity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.nasacompose.R
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.ui.RoverInfoUiState
import com.nasacompose.presentation.ui.custom.*
import com.nasacompose.presentation.viewmodel.curiosity.CuriosityViewModel

@Preview
@Composable
fun CuriosityScreen(
    viewModel: CuriosityViewModel = hiltViewModel()
) {

    val lazyCuriosityRoverInfo = viewModel.fetchCuriosityRoverInfo().collectAsLazyPagingItems()

    LazyColumn {
        items(lazyCuriosityRoverInfo.itemCount) { index ->
            lazyCuriosityRoverInfo[index]?.let {
                CuriosityRoverInfoItem(it)
            }
        }

        lazyCuriosityRoverInfo.apply {
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
                    val e = lazyCuriosityRoverInfo.loadState.refresh as LoadState.Error
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

@Composable
fun CuriosityRoverInfoItem(item: PhotoDetailResponseModel) {

    val openBottomSheet = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_filter),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(25.dp)
                .padding(top = 5.dp)
                .clip(RoundedCornerShape(corner = CornerSize(13.dp)))
                .clickable {
                     openBottomSheet.value = true
                }
        )

        RoverListItem(RoverInfoUiState(
            camera = item.camera,
            imageUrl = item.img_src,
            rover = item.rover
        ))
    }
}