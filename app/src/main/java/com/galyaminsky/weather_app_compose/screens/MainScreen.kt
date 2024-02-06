package com.galyaminsky.weather_app_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.galyaminsky.weather_app_compose.R

@Preview(showBackground = true)
@Composable
fun MainScreen () {
        Image(
            painter = painterResource(id = R.drawable.back_1),
            contentDescription = "image",
            modifier = Modifier.fillMaxSize()
                .alpha(0.8f),
            contentScale = ContentScale.Crop
        )
}