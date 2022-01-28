package com.nasacompose.presentation.ui.curiosity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.nasacompose.R
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.model.ui.RoverCameraUiState
import com.nasacompose.data.model.ui.RoverInfoUiState
import com.nasacompose.presentation.ui.custom.*
import com.nasacompose.presentation.viewmodel.curiosity.CuriosityViewModel

@Preview
@Composable
fun CuriosityScreen(
    viewModel: CuriosityViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        CuriosityRoverFilter()
        CuriosityRoverInfoList(curiosityRoverInfoList = viewModel.curiosityRoverInfoList.collectAsLazyPagingItems())
    }
}

@Composable
fun CuriosityRoverFilter() {

    var openFilterDialog = remember { mutableStateOf(false)}

    Image(
        painter = painterResource(R.drawable.ic_filter),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(25.dp)
            .padding(top = 5.dp)
            .clip(RoundedCornerShape(corner = CornerSize(13.dp)))
            .clickable {
                openFilterDialog.value = true
            }
    )

    if (openFilterDialog.value) {
        Dialog(onDismissRequest = { openFilterDialog.value = false}) {
            FilterDialog(
                openFilterDialog = openFilterDialog,
                cameraSelected = {
                    Log.i("Selekted", "$it")
                })
        }
    }
}

@Composable
fun CuriosityRoverInfoList(curiosityRoverInfoList: LazyPagingItems<RoverInfoDetailResponseModel>) {
    LazyColumn {
        items(curiosityRoverInfoList.itemCount) { index ->
            curiosityRoverInfoList[index]?.let {
                RoverListItem(
                    RoverInfoUiState(
                        camera = it.camera,
                        imageUrl = it.img_src,
                        rover = it.rover
                    )
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