package com.nasacompose.presentation.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import coil.compose.rememberImagePainter
import com.nasacompose.data.model.ui.RoverCamera
import com.nasacompose.data.model.ui.RoverCameraUiState
import com.nasacompose.presentation.ui.theme.Gray

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
                    .background(Gray),
                horizontalArrangement = Arrangement.SpaceAround) {
                TextButton(onClick = {
                    openDialogCustom.value = false
                }) {
                    Text(
                        "Kapat",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun FilterDialog(
    openFilterDialog: MutableState<Boolean>,
    cameraSelected: (String) -> Unit
) {

    val filterOption = listOf(RoverCamera.FHAZ.filterName, RoverCamera.RHAZ.filterName)

    var (selectedFilterName, onOptionSelected) = remember { mutableStateOf(filterOption[0]) }

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(10.dp, 5.dp, 10.dp, 10.dp)
            .wrapContentHeight(),
        elevation = 8.dp,

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 5.dp),
             horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Column {
                filterOption.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedFilterName),
                                onClick = { onOptionSelected(text) }
                            )
                            .padding(horizontal = 16.dp)
                    ) {
                        RadioButton(
                            selected = (text == selectedFilterName),
                            modifier = Modifier.padding(all = Dp(value = 8F)),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        Text(
                            text = text,
                            modifier = Modifier.padding(all = Dp(value = 8F))
                        )
                    }
                }
            }
            OutlinedButton(
                onClick = {
                    cameraSelected(selectedFilterName)
                    openFilterDialog.value = false
                }) {
                Text("Filtrele",
                color = Gray)
            }
        }
    }
}







