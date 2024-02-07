package com.galyaminsky.weather_app_compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.galyaminsky.weather_app_compose.ui.theme.Purple40

@Preview(showBackground = true)
@Composable
fun ListItem() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Purple40
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        shape = RoundedCornerShape(10.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "12:00"
                )
                Text(
                    text = "Sunny",
                    color = Color.White
                )

            }
            Text(
                text = "23° / 12°",
                color = Color.White,
                style = TextStyle(fontSize = 25.sp)
            )
            AsyncImage(
                model = "https://cdn.weatherapi.com/weather/64x64/night/122.png",
                contentDescription = "im_3",
                modifier = Modifier
                    .size(35.dp)
                    .padding(8.dp)

            )
        }
    }
}