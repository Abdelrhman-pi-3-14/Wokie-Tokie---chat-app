package com.example.walkie_talkie.system.domain.feature_weather

import coil.map.Mapper

data class WeatherInfo (
    val weatherDataPerDay: Map <Int , List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
