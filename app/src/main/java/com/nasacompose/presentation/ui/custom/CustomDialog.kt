package com.nasacompose.presentation.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import com.nasacompose.data.model.ui.RoverCameraUiState
import com.nasacompose.presentation.ui.theme.Purple500

@Composable
fun CustomDialogUI(modifier: Modifier = Modifier, openDialogCustom: MutableState<Boolean>, camera: RoverCameraUiState){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .background(Color.White)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Image(
                painter = rememberImagePainter(camera.roverImageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(150.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(13.dp))),
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = camera.name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h3,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = camera.fullName,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.body1
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(Purple500),
                horizontalArrangement = Arrangement.SpaceAround) {
                TextButton(onClick = {
                    openDialogCustom.value = false
                }) {
                    Text(
                        "Kapat",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}