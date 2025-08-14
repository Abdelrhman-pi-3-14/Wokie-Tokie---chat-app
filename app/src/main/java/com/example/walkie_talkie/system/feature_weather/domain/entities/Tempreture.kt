package com.example.walkie_talkie.system.feature_weather.domain.entities

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.ui_thames.DarkColorScheme.greenLight
import com.example.walkie_talkie.ui_thames.digital


// get the temperature from the API
@Composable
fun GetTemperature(temp: String , onClicked: () -> Unit)  {
    Text(
        text = "$temp C°",
        fontSize = 15.sp,
        maxLines = 1,
        color = greenLight,
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
        fontSize = 15.sp,
        maxLines = 1,
        color = greenLight,
        fontFamily = digital,

    )
}

