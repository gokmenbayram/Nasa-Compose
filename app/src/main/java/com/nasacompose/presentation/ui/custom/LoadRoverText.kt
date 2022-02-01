package com.nasacompose.presentation.ui.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nasacompose.data.model.ui.RoverDetailUiState


@Composable
fun LoadRoverText(
    roverDetailInfo: RoverDetailUiState,
) {
    Column {
        Text(
            text = "Araç Adı: ${roverDetailInfo.name}",
            modifier = Modifier.padding(3.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Fırlatma Tarihi: ${roverDetailInfo.launchDate}",
            modifier = Modifier.padding(3.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Text(
            text = "İniş Tarihi: ${roverDetailInfo.landingDate}",
            modifier = Modifier.padding(3.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Durumu: ${roverDetailInfo.status}",
            modifier = Modifier.padding(3.dp),
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}