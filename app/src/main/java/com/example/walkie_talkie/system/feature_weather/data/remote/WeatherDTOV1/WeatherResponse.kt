package com.example.walkie_talkie.system.feature_weather.data.remote.WeatherDTOV1

data class WeatherResponse(
    val city : String ,
    val temp :Main,
    val weather : List<Weather>
)


