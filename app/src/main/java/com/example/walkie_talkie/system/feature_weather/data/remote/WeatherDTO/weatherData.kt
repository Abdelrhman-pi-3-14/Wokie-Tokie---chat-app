package com.example.walkie_talkie.system.feature_weather.data.remote.WeatherDTO

import com.squareup.moshi.Json

data class weatherData(
    @field:Json(name = "hourly")
    val WeatherData: WeatherDataDto
)