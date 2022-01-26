package com.nasacompose.presentation.ui.curiosity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.nasacompose.R
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.presentation.ui.custom.BottomSheet
import com.nasacompose.presentation.ui.loading.LoadingComponent
import com.nasacompose.presentation.viewmodel.curiosity.CuriosityViewModel



@ExperimentalMaterialApi
@Preview
@Composable
fun CuriosityScreen(
    viewModel: CuriosityViewModel = hiltViewModel()
) {

    val openBottomSheet = remember { mutableStateOf(false) }

    var count = 0

    viewModel.fetchCuriosityPhotos()

    if (count == 0) {
        val curiosityPhotos by viewModel.curiosityPhotos.observeAsState(initial = emptyList())

        curiosityPhotos?.let {
            if (curiosityPhotos.isNotEmpty()) {
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
                    CuriosityListComponent(curiosityPhotos)
                }
                Log.i("DataControl", "Size: ${curiosityPhotos.size}")
            }
        } ?: LoadingComponent()
    }

    if (openBottomSheet.value) {
        BottomSheet()
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