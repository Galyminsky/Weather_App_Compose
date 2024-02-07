@file:OptIn(ExperimentalPagerApi::class)

package com.galyaminsky.weather_app_compose.screens

import android.app.LauncherActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.galyaminsky.weather_app_compose.R
import com.galyaminsky.weather_app_compose.data.WeatherModel
import com.galyaminsky.weather_app_compose.ui.theme.Purple40
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {

    Column(
        modifier = Modifier
            .padding(10.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Purple40
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp, start = 8.dp),
                        text = "20 Jun 2024 13:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/night/122.png",
                        contentDescription = "im_2",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(end = 8.dp, top = 8.dp)

                    )
                }
                Text(
                    text = "Lisakovsk",
                    style = TextStyle(fontSize = 25.sp),
                    color = Color.White
                )
                Text(
                    text = "-17°",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.White
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {


                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = "im_search",
                            tint = Color.White
                        )
                    }


                    Text(
                        text = "23° / 12°",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )

                    IconButton(onClick = {


                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sync),
                            contentDescription = "im_sync",
                            tint = Color.White

                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TabLayout() {

    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(pos[tabIndex])
                )
            },
            containerColor = Purple40,
            contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text, color = Color.White)
                    }
                )
            }
        }

        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(
                    listOf(WeatherModel (
                        city = "Lisakovsk",
                        time = "13:00",
                        currentTemp = "-17°",
                        condition = "Sunny",
                        icon = "//cdn.weatherapi.com/weather/64x64/night/122.png",
                        "",
                        "",
                        ""
                    ),
                        WeatherModel (
                            city = "Lisakovsk",
                            time = "20 Jun 2024 13:00",
                            currentTemp = "",
                            condition = "Sunny",
                            icon = "//cdn.weatherapi.com/weather/64x64/night/122.png",
                            "26°",
                            "17°",
                            "dfgdfg"
                        ))

                ) {
                    _, item ->
                    ListItem(item)
                }

            }
        }
    }
}