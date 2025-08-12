package com.example.walkie_talkie.system.feature_weather.data.remote

import com.example.walkie_talkie.system.common.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit Instance for weather
object RetrofitInstance {
    private fun getInstance1(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun getInstance2(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi2: WeatherApi2 = getInstance2().create(WeatherApi2::class.java)
    val weatherApi: WeatherApi1 = getInstance1().create(WeatherApi1::class.java)
}
