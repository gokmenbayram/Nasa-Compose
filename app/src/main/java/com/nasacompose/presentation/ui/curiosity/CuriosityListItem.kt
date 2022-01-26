package com.nasacompose.presentation.ui.curiosity

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.nasacompose.data.model.ui.RoverDetailUiState
import com.nasacompose.presentation.ui.custom.LoadRoverPhoto
import com.nasacompose.presentation.ui.custom.LoadRoverText

@Composable
fun CuriosityListItem(
    curiosity: PhotoDetailResponseModel,
    clickedItem: () -> Unit) {

    //val openDialog = remember { mutableStateOf(true)}

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                clickedItem()
            },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            LoadRoverPhoto(imageUrl = curiosity.img_src)
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
}