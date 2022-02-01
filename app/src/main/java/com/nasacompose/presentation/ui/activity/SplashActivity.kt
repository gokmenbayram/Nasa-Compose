package com.nasacompose.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasacompose.R
import com.nasacompose.presentation.ui.theme.Light
import com.nasacompose.presentation.ui.theme.NasaComposeTheme


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaComposeTheme {
                Surface(color = Light) {
                    SplashScreen()
                    navigateToMainActivity()
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}

@Preview
@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_mars),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(140.dp)
                .padding(top = 5.dp)
                .clip(RoundedCornerShape(corner = CornerSize(13.dp)))
        )
    }
}
