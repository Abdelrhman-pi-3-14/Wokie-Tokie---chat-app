package com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeatherDTO

import com.squareup.moshi.Json

data class WeatherDataDto(
    @field:Json(name = "apparent_temperature") val apparent_temperature: List<Double> ,
    @field:Json(name = "dew_point_2m") val dew_point_2m: List<Double> ,
    @field:Json(name = "precipitation") val precipitation: List<Double> ,
    @field:Json(name = "precipitation_probability") val precipitation_probability: List<Int> ,
    @field:Json(name = "rain") val rain: List<Double> ,
    @field:Json(name = "snow") val snow: List<Double> ,
    @field:Json(name = "temperature") val temperature: List<Double> ,
    @field:Json(name = "relative_humidity_2m") val relative_humidity_2m: List<Int> ,
    @field:Json(name = "temperature_2m") val temperature_2m: List<Double> ,
    @field:Json(name = "time") val time: List<String> ,
    @field:Json(name = "weather_code") val weather_code: List<Int> ,
    @field:Json(name = "wind_speed_10m") val wind_speed_10m: List<Double> ,
    @field:Json(name = "wind_speed_120m") val wind_speed_120m: List<Double> ,
    @field:Json(name = "wind_speed_80m") val wind_speed_80m: List<Double>
)