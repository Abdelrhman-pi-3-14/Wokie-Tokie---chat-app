package com.example.walkie_talkie.system.feature_weather.domain.entities

data class WeatherInfoDomain (
    val weatherDataPerDay: Map <Int , List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
