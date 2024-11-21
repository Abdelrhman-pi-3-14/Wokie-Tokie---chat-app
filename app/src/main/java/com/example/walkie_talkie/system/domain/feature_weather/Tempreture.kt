package com.example.walkie_talkie.system.domain.feature_weather

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.theme.digital


// get the temperature from the API
@Composable
fun GetTemperature(temp: String , onClicked: () -> Unit)  {
    Text(
        text = "$temp C°",
        fontSize = 20.sp,
        maxLines = 1,
        color = lightBlue,
        fontFamily = digital,
        modifier = Modifier.clickable {
            onClicked()
        }
    )
}

@Composable
fun GetTemperature(temp: String)  {
    Text(
        text = "$temp C°",
        fontSize = 20.sp,
        maxLines = 1,
        color = lightBlue,
        fontFamily = digital,

    )
}

