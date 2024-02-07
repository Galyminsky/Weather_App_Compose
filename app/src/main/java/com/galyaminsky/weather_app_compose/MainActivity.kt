package com.galyaminsky.weather_app_compose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.galyaminsky.weather_app_compose.screens.MainCard
import com.galyaminsky.weather_app_compose.screens.TabLayout


const val API_KEY = "eb001e1861e842a699b120840221012"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getData("Lisakovsk", this)
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
private fun getData (city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY&q=$city&days=3&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest (
        Request.Method.GET,
        url,
        {
            response ->
        Log.d("MyLog", "Response: $response")
        },
        {
            error ->
            Log.d("MyLog", "Error: $error")
        }
    )
    queue.add(sRequest)
}
