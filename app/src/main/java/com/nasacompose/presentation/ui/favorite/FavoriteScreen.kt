package com.nasacompose.presentation.ui.favorite

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nasacompose.R
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