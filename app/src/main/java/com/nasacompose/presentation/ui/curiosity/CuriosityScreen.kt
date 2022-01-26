package com.nasacompose.presentation.ui.curiosity

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.presentation.ui.loading.LoadingComponent
import com.nasacompose.presentation.viewmodel.curiosity.CuriosityViewModel



@Preview
@Composable
fun CuriosityScreen(
    viewModel: CuriosityViewModel = hiltViewModel()
) {

    var count = 0

    viewModel.fetchCuriosityPhotos()

    if (count == 0) {
        val curiosityPhotos by viewModel.curiosityPhotos.observeAsState(initial = emptyList())

        curiosityPhotos?.let {
            if (curiosityPhotos.isNotEmpty()) {
                CuriosityListComponent(curiosityPhotos)
                Log.i("DataControl", "Size: ${curiosityPhotos.size}")
            }
        } ?: LoadingComponent()

        count += 1
    }
}


@Composable
fun CuriosityListComponent(curiosityList: List<PhotoDetailResponseModel>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)) {
        items(
            items = curiosityList,
            itemContent = {
                CuriosityListItem(curiosity = it) {

                }
            }
        )
    }
}