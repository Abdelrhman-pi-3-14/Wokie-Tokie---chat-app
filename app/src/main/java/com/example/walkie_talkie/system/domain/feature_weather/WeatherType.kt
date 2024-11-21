package com.example.walkie_talkie.system.domain.feature_weather
import androidx.annotation.DrawableRes
import com.example.walkie_talkie.R.drawable.ic_cloudy
import com.example.walkie_talkie.R.drawable.ic_heavysnow
import com.example.walkie_talkie.R.drawable.ic_rainshower
import com.example.walkie_talkie.R.drawable.ic_rainy
import com.example.walkie_talkie.R.drawable.ic_rainythunder
import com.example.walkie_talkie.R.drawable.ic_snowy
import com.example.walkie_talkie.R.drawable.ic_snowyrainy
import com.example.walkie_talkie.R.drawable.ic_sunny
import com.example.walkie_talkie.R.drawable.ic_sunnycloudy
import com.example.walkie_talkie.R.drawable.ic_thunder
import com.example.walkie_talkie.R.drawable.ic_very_cloudy


sealed class WeatherType(
    val weatherDesc: String ,
    @DrawableRes val iconRes: Int
) {
    data object ClearSky : WeatherType(
        weatherDesc = "Clear sky" ,
        iconRes = ic_sunny
    )

    data object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear" ,
        iconRes = ic_cloudy
    )

    data object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy" ,
        iconRes = ic_sunnycloudy
    )

    data object Overcast : WeatherType(
        weatherDesc = "Overcast" ,
        iconRes = ic_cloudy
    )

    data object Foggy : WeatherType(
        weatherDesc = "Foggy" ,
        iconRes = ic_very_cloudy
    )

    data object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog" ,
        iconRes = ic_heavysnow
    )

    data object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle" ,
        iconRes = ic_rainshower
    )

    data object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle" ,
        iconRes = ic_rainshower
    )

    data object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle" ,
        iconRes = ic_rainshower
    )

    data object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle" ,
        iconRes = ic_snowyrainy
    )

    data object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle" ,
        iconRes = ic_snowyrainy
    )

    data object SlightRain : WeatherType(
        weatherDesc = "Slight rain" ,
        iconRes = ic_rainy
    )

    data object ModerateRain : WeatherType(
        weatherDesc = "Rainy" ,
        iconRes = ic_rainy
    )

    data object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain" ,
        iconRes = ic_rainy
    )

    data object HeavyFreezingRain : WeatherType(
        weatherDesc = "Heavy freezing rain" ,
        iconRes = ic_snowyrainy
    )

    data object SlightSnowFall : WeatherType(
        weatherDesc = "Slight snow fall" ,
        iconRes = ic_snowy
    )

    data object ModerateSnowFall : WeatherType(
        weatherDesc = "Moderate snow fall" ,
        iconRes = ic_heavysnow
    )

    data object HeavySnowFall : WeatherType(
        weatherDesc = "Heavy snow fall" ,
        iconRes = ic_heavysnow
    )

    data object SnowGrains : WeatherType(
        weatherDesc = "Snow grains" ,
        iconRes = ic_heavysnow
    )

    data object SlightRainShowers : WeatherType(
        weatherDesc = "Slight rain showers" ,
        iconRes = ic_rainshower
    )

    data object ModerateRainShowers : WeatherType(
        weatherDesc = "Moderate rain showers" ,
        iconRes = ic_rainshower
    )

    data object ViolentRainShowers : WeatherType(
        weatherDesc = "Violent rain showers" ,
        iconRes = ic_rainshower
    )

    data object SlightSnowShowers : WeatherType(
        weatherDesc = "Light snow showers" ,
        iconRes = ic_snowy
    )

    data object HeavySnowShowers : WeatherType(
        weatherDesc = "Heavy snow showers" ,
        iconRes = ic_snowy
    )

    data object ModerateThunderstorm : WeatherType(
        weatherDesc = "Moderate thunderstorm" ,
        iconRes = ic_thunder
    )

    data object SlightHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with slight hail" ,
        iconRes = ic_rainythunder
    )

    object HeavyHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy hail" ,
        iconRes = ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}