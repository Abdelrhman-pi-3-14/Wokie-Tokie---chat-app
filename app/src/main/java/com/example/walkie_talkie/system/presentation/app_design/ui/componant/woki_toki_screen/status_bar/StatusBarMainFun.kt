package com.example.walkie_talkie.system.presentation.app_design.ui.componant.woki_toki_screen.status_bar


import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.signal_ic
import com.example.walkie_talkie.system.common.NetworkResponse
import com.example.walkie_talkie.system.domain.feature_weather.GetTemperature
import com.example.walkie_talkie.system.domain.feature_weather.weatherIcon
import com.example.walkie_talkie.system.presentation.feature_weather.viewModel.WeatherViewModel
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital
import kotlinx.coroutines.delay

// the function that will set the status bar with onClick parameter

@Composable
fun StatusBar(
    modifier: Modifier ,
    backGround: Color ,
    onClicked: () -> Unit ,
) {

    var currentTime by remember { mutableStateOf(currentTime()) }
    val textWidth by remember { mutableFloatStateOf(0f) }
    var animationTarget by remember { mutableFloatStateOf(1000f) }
    val viewModel: WeatherViewModel = viewModel()
    val weatherResult by viewModel.weatherData.observeAsState()





    LaunchedEffect(key1 = textWidth) {
        animationTarget = -textWidth
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = currentTime()
            delay(1000)
        }
    }

    Row(
        horizontalArrangement = Arrangement.End ,
        verticalAlignment = Alignment.Top ,
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp)
            .background(color = backGround)
    ) {
        Text(
            text = currentTime ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier.padding(start = 24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = ImageVector.vectorResource(signal_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.weight(1F))

        Spacer(modifier = Modifier.width(8.dp))


        when (val result = weatherResult) {
            is NetworkResponse.Success -> {
                Image(
                    imageVector = ImageVector.vectorResource(
                        id = weatherIcon(
                            result.data.current.condition.code
                        )
                    ) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .clickable {
                            onClicked()
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                GetTemperature(
                    temp = result.data.current.temp_c,
                    onClicked
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = result.data.location.region + " , " + result.data.location.country ,
                    color = lightBlue ,
                    fontSize = 20.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(end = 24.dp)
                        .width(70.dp)
                        .clickable {
                            onClicked()
                        }
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately ,
                            initialDelayMillis = 0 ,
                            velocity = 30.dp ,
                            iterations = Int.MAX_VALUE
                        )
                )
            }

            is NetworkResponse.Loading -> {

                CircularProgressIndicator(
                    color = lightBlue ,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(24.dp))
                CircularProgressIndicator(
                    color = lightBlue ,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(24.dp))
                CircularProgressIndicator(
                    color = lightBlue ,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(24.dp))

            }

            is NetworkResponse.Error -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.error_ic) ,
                    contentDescription = null ,
                    tint = lightBlue ,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                GetTemperature(temp = "0",onClicked)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Error loading weather data" ,
                    color = lightBlue ,
                    fontSize = 20.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(end = 24.dp)
                        .width(70.dp)
                        .clickable {
                            onClicked()
                        }
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately ,
                            initialDelayMillis = 0 ,
                            velocity = 20.dp ,
                            iterations = Int.MAX_VALUE
                        )
                )
            }

            else -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.cloud_ic) ,
                    contentDescription = null ,
                    tint = lightBlue ,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                        .clickable {
                            onClicked()
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                GetTemperature(temp = "--",onClicked)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Click to get weather data from any where" ,
                    color = lightBlue ,
                    fontSize = 20.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(end = 24.dp)
                        .width(70.dp)
                        .clickable {
                            onClicked()
                        }
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately ,
                            initialDelayMillis = 0 ,
                            velocity = 30.dp ,
                            iterations = Int.MAX_VALUE
                        )
                )
            }
        }
    }
}


// the function that will set the status bar without onClick parameter
@Composable
fun StatusBar(
    modifier: Modifier ,
    backGround: Color ,
) {

    var currentTime by remember { mutableStateOf(currentTime()) }
    var textWidth by remember { mutableFloatStateOf(0f) }
    var animationTarget by remember { mutableFloatStateOf(1000f) }
    val viewModel: WeatherViewModel = viewModel()
    val weatherResult by viewModel.weatherData.observeAsState()



    LaunchedEffect(key1 = textWidth) {
        animationTarget = -textWidth
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = currentTime()
            delay(1000)
        }
    }

    Row(
        horizontalArrangement = Arrangement.End ,
        verticalAlignment = Alignment.Top ,
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp)
            .background(color = backGround)
    ) {
        Text(
            text = currentTime ,
            color = lightBlue ,
            fontSize = 20.sp ,
            fontFamily = digital ,
            modifier = Modifier.padding(start = 24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = ImageVector.vectorResource(signal_ic) ,
            contentDescription = null ,
            tint = lightBlue ,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)

        )
        Spacer(modifier = Modifier.weight(1F))
        when (val result = weatherResult) {
            is NetworkResponse.Success -> {
                Image(
                    imageVector = ImageVector.vectorResource(
                        id = weatherIcon(
                            result.data.current.condition.code
                        )
                    ) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                GetTemperature(
                    temp = result.data.current.temp_c
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = result.data.location.region + " , " + result.data.location.country ,
                    color = lightBlue ,
                    fontSize = 20.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(end = 24.dp)
                        .width(70.dp)
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately ,
                            initialDelayMillis = 0 ,
                            velocity = 30.dp ,
                            iterations = Int.MAX_VALUE
                        )
                )
            }

            is NetworkResponse.Loading -> {

                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    color = lightBlue ,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    color = lightBlue ,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    color = lightBlue ,
                    modifier = Modifier.size(20.dp)
                )
            }

            is NetworkResponse.Error -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.error_ic) ,
                    contentDescription = null ,
                    tint = lightBlue ,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                GetTemperature(temp = "0")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Error loading weather data" ,
                    color = lightBlue ,
                    fontSize = 20.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(end = 24.dp)
                        .width(70.dp)
                        .clickable {
                        }
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately ,
                            initialDelayMillis = 0 ,
                            velocity = 20.dp ,
                            iterations = Int.MAX_VALUE
                        )
                )
            }

            else -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.cloud_ic) ,
                    contentDescription = null ,
                    tint = lightBlue ,
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                GetTemperature(temp = "--")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Click to get weather data from any where" ,
                    color = lightBlue ,
                    fontSize = 20.sp ,
                    fontFamily = digital ,
                    modifier = Modifier
                        .height(20.dp)
                        .padding(end = 24.dp)
                        .width(70.dp)
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately ,
                            initialDelayMillis = 0 ,
                            velocity = 30.dp ,
                            iterations = Int.MAX_VALUE
                        )
                )
            }
        }

    }
}




