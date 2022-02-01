package com.nasacompose.presentation.ui.opportunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.nasacompose.R
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.model.response.RoverInfoDetailResponseModel
import com.nasacompose.data.model.ui.RoverInfoUiState
import com.nasacompose.presentation.ui.custom.ErrorItem
import com.nasacompose.presentation.ui.custom.LoadingItem
import com.nasacompose.presentation.ui.custom.LoadingView
import com.nasacompose.presentation.ui.custom.RoverListItem
import com.nasacompose.presentation.viewmodel.opportunity.OpportunityViewModel

lateinit var opportunityViewModel: OpportunityViewModel

@Preview
@Composable
fun OpportunityScreen(
    viewModel: OpportunityViewModel = hiltViewModel()
) {

    opportunityViewModel = viewModel

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        OpportunityRoverInfoList(opportunityRoverInfoList = viewModel.opportunityRoverInfoList.collectAsLazyPagingItems())
    }
}

@Composable
fun OpportunityRoverInfoList(opportunityRoverInfoList: LazyPagingItems<RoverInfoDetailResponseModel>) {
    LazyColumn {
        items(opportunityRoverInfoList.itemCount) { index ->
            opportunityRoverInfoList[index]?.let {
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

        opportunityRoverInfoList.apply {
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
                    val e = opportunityRoverInfoList.loadState.refresh as LoadState.Error
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
        //opportunityViewModel.insertFavoriteRover(favoriteRover)
    } else {
        //opportunityViewModel.deleteFavoriteRover(roverId)
    }
}