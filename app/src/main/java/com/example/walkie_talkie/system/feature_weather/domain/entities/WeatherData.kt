package com.example.walkie_talkie.system.feature_weather.domain.entities

import java.time.LocalDateTime

data class WeatherData (
    val time: LocalDateTime ,
    val temperature: Double,
    val weatherType: WeatherType,
)