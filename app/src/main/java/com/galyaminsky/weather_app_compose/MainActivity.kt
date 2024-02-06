package com.galyaminsky.weather_app_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.galyaminsky.weather_app_compose.screens.MainCard
import com.galyaminsky.weather_app_compose.screens.TabLayout


const val API_KEY = "eb001e1861e842a699b120840221012"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Image(
                painter = painterResource(id = R.drawable.back_1),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.8f),
                contentScale = ContentScale.Crop
            )
            Column() {
                MainCard()
                TabLayout()
            }
        }
    }
}
