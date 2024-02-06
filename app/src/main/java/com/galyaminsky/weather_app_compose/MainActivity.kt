package com.galyaminsky.weather_app_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.galyaminsky.weather_app_compose.screens.MainScreen


const val API_KEY = "eb001e1861e842a699b120840221012"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
