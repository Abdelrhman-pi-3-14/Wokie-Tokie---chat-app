package com.example.walkie_talkie.system.data.app_design.feature_weather.remote

import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeatherDTOV1.WeatherResponse
import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeathreDTOV2.WeatherInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi1 {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String ,
        @Query("appid") apiKey : String,
        @Query("units") units : String = "metric"
    ): Response<WeatherResponse>
}

interface WeatherApi2 {
    @GET("/v1/current.json")
    suspend fun getCurrentWeather(
        @Query("q") city: String ,
        @Query("key") apiKey : String,
    ): Response<WeatherInfo>
}



