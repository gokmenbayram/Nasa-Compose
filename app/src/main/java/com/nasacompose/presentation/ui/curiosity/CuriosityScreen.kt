package com.nasacompose.presentation.ui.curiosity

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nasacompose.R
import com.nasacompose.presentation.ui.custom.RoverListComponent
import com.nasacompose.presentation.ui.loading.LoadingComponent
import com.nasacompose.presentation.viewmodel.curiosity.CuriosityViewModel

@Preview
@Composable
fun CuriosityScreen(
    viewModel: CuriosityViewModel = hiltViewModel()
) {
    val openBottomSheet = remember { mutableStateOf(false) }

    val curiosityInfo by viewModel.curiosityInfo.collectAsState()

    curiosityInfo?.let {
        if (curiosityInfo.isNotEmpty()) {
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
                RoverListComponent(curiosityInfo)
            }
        }
    } ?: LoadingComponent()
}