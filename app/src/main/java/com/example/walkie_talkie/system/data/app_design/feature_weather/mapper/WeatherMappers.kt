package com.example.walkie_talkie.system.data.app_design.feature_weather.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeatherDTO.WeatherDataDto
import com.example.walkie_talkie.system.domain.feature_weather.WeatherData
import com.example.walkie_talkie.system.domain.feature_weather.WeatherInfo
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class Index(
    val index: Int ,
    val data: WeatherData
)


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int , List<WeatherData>> {
    return time.mapIndexed { index , time ->
        val temperature = temperature[index]
        val weatherCode = weather_code[index]
        val windSpeed = wind_speed_10m[index]
        Index(
            index = index ,
            data = WeatherData(
                time = LocalDateTime.parse(time , DateTimeFormatter.ISO_DATE_TIME) ,
                temperature = temperature ,
                weatherType = WeatherType.fromWMO(weatherCode) ,
            )
        )
    }.groupBy {
        it.index / 24

    }.mapValues {
        it.value.map { it.data }
    }
}

/*

fun WeatherDataDto.WeatherInfo() : WeatherInfo{

}*/
