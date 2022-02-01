package com.nasacompose.presentation.ui.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nasacompose.presentation.viewmodel.favorite.FavoriteViewModel

@Preview
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    viewModel.getFavoriteRover()

    val viewState by viewModel.favoriteState.collectAsState()


    if (viewState.isEmpty()) {
        NoFavoriteRovers()
    } else {

    }
}


@Composable
fun NoFavoriteRovers() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(text = "Favori Araç Eklemediniz.")

    }
}