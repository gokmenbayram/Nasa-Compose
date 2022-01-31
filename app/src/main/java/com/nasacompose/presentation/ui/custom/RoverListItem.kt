package com.nasacompose.presentation.ui.custom

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.nasacompose.R
import com.nasacompose.data.model.local.FavoriteRover
import com.nasacompose.data.model.ui.RoverCameraUiState
import com.nasacompose.data.model.ui.RoverDetailUiState
import com.nasacompose.data.model.ui.RoverInfoUiState

@Composable
fun RoverListItem(
    curiosity: RoverInfoUiState,
    addToFavorite: (roverId: Int, isFavorite: Boolean, favoriteRover: FavoriteRover) -> Unit
) {

    val openDialog = remember { mutableStateOf(false)}

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Card(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
                .clickable {
                    openDialog.value = true
                },
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            Row {
                LoadRoverPhoto(imageUrl = curiosity.imageUrl)
                LoadRoverText(
                    RoverDetailUiState(
                        curiosity.rover.name,
                        curiosity.rover.launch_date,
                        curiosity.rover.landing_date,
                        curiosity.rover.status
                    )
                )
                /*FavIcon(curiosity.isFavorite) { isFavorite ->
                    addToFavorite(curiosity.roverId, isFavorite, FavoriteRover(
                        roverId = curiosity.roverId,
                        cameraName = curiosity.camera.name,
                        cameraFullName = curiosity.camera.full_name,
                        status = curiosity.rover.status,
                        landingDate = curiosity.rover.landing_date,
                        launchDate = curiosity.rover.launch_date,
                        imageUrl = curiosity.imageUrl
                    ))
                }*/
            }
        }

        if (openDialog.value) {
            Dialog(onDismissRequest = { openDialog.value = false}) {
                CustomDialogUI(
                    openDialogCustom = openDialog,
                    camera = RoverCameraUiState(
                        curiosity.camera.id,
                        curiosity.imageUrl,
                        curiosity.camera.name,
                        curiosity.camera.rover_id,
                        curiosity.camera.full_name

                    ))
            }
        }
    }
}

@Composable
fun FavIcon(isFavorite: Boolean, favorite: (isFavorite: Boolean) -> Unit) {

    var isFavorite by remember {
        mutableStateOf(isFavorite)
    }

    IconButton(
        onClick = {
            isFavorite = !isFavorite
            favorite(isFavorite)
        }
    ) {
        Image(
            painter = painterResource(
                id = if (isFavorite) {
                    R.drawable.ic_fav
                } else {
                    R.drawable.ic_un_fav
                }
            ),
            contentDescription = ""
        )
    }
}

/*@Composable
fun RoverListComponent(curiosityList: List<PhotoDetailResponseModel>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)) {
        items(
            items = curiosityList,
            itemContent = {
                RoverListItem(curiosity = RoverInfoUiState(
                    camera = it.camera,
                    imageUrl = it.img_src,
                    rover = it.rover
                )
                )
            }
        )
    }
}*/