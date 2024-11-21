package com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeatherDTOV1

data class WeatherResponse(
    val city : String ,
    val temp :Main,
    val weather : List<Weather>
)


