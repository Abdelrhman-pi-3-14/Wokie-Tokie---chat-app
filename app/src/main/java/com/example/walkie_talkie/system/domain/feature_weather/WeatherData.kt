package com.example.walkie_talkie.system.domain.feature_weather

import java.time.LocalDateTime

data class WeatherData (
    val time: LocalDateTime ,
    val temperature: Double,
    val weatherType: WeatherType,
)