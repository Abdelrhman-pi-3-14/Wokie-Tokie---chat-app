package com.example.walkie_talkie.system.feature_weather.data.remote


import com.example.walkie_talkie.system.feature_weather.data.remote.WeatherDTOV1.WeatherResponse
import com.example.walkie_talkie.system.feature_weather.data.remote.WeathreDTOV2.WeatherInfo
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



