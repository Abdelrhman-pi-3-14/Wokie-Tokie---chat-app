package com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeatherDTO

import com.squareup.moshi.Json

data class weatherData(
    @field:Json(name = "hourly")
    val WeatherData: WeatherDataDto
)