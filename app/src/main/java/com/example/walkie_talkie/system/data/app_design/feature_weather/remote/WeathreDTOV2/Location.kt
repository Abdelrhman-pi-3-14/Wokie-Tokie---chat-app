package com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeathreDTOV2

data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
)