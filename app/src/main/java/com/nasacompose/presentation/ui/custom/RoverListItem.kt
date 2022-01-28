package com.nasacompose.presentation.ui.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.nasacompose.data.model.response.PhotoDetailResponseModel
import com.nasacompose.data.model.ui.RoverCameraUiState
import com.nasacompose.data.model.ui.RoverDetailUiState
import com.nasacompose.data.model.ui.RoverInfoUiState
import com.nasacompose.presentation.ui.custom.CustomDialogUI
import com.nasacompose.presentation.ui.custom.LoadRoverPhoto
import com.nasacompose.presentation.ui.custom.LoadRoverText

@Composable
fun RoverListItem(
    curiosity: RoverInfoUiState
) {

    val openDialog = remember { mutableStateOf(false)}

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