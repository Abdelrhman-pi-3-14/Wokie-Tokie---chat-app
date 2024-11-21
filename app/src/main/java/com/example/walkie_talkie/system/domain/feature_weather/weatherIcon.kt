package com.example.walkie_talkie.system.domain.feature_weather

import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.ClearSky
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.DenseDrizzle
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.DenseFreezingDrizzle
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.DepositingRimeFog
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.Foggy
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.HeavyFreezingRain
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.HeavyHailThunderstorm
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.HeavyRain
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.HeavySnowFall
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.HeavySnowShowers
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.LightDrizzle
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.LightFreezingDrizzle
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.MainlyClear
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.ModerateDrizzle
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.ModerateRain
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.ModerateRainShowers
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.ModerateSnowFall
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.Overcast
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.PartlyCloudy
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.SlightHailThunderstorm
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.SlightRain
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.SlightRainShowers
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.SlightSnowFall
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.SlightSnowShowers
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.SnowGrains
import com.example.walkie_talkie.system.domain.feature_weather.WeatherType.ViolentRainShowers
/*

fun weatherIcon(condition: Condition): Int {
    when (condition.text) {
        "Clear" -> return WeatherType.ClearSky.iconRes
        "Partly cloudy" -> return WeatherType.MainlyClear.iconRes
        "Partly cloudy" -> return WeatherType.PartlyCloudy.iconRes
        "Overcast" -> return WeatherType.Overcast.iconRes
        WeatherType.Foggy.weatherDesc -> return WeatherType.Foggy.iconRes
        WeatherType.DepositingRimeFog.weatherDesc -> return WeatherType.DepositingRimeFog.iconRes
        WeatherType.LightDrizzle.weatherDesc -> return WeatherType.LightDrizzle.iconRes
        WeatherType.ModerateDrizzle.weatherDesc -> return WeatherType.ModerateDrizzle.iconRes
        WeatherType.DenseDrizzle.weatherDesc -> return WeatherType.DenseDrizzle.iconRes
        WeatherType.LightFreezingDrizzle.weatherDesc -> return WeatherType.LightFreezingDrizzle.iconRes
        WeatherType.DenseFreezingDrizzle.weatherDesc -> return WeatherType.DenseFreezingDrizzle.iconRes
        WeatherType.SlightRain.weatherDesc -> return WeatherType.SlightRain.iconRes
        WeatherType.ModerateRain.weatherDesc -> return WeatherType.ModerateRain.iconRes
        WeatherType.HeavyRain.weatherDesc -> return WeatherType.HeavyRain.iconRes
        WeatherType.HeavyFreezingRain.weatherDesc -> return WeatherType.HeavyFreezingRain.iconRes
        WeatherType.SlightSnowFall.weatherDesc -> return WeatherType.SlightSnowFall.iconRes
        WeatherType.ModerateSnowFall.weatherDesc -> return WeatherType.ModerateSnowFall.iconRes
        WeatherType.HeavySnowFall.weatherDesc -> return WeatherType.HeavySnowFall.iconRes
        WeatherType.SnowGrains.weatherDesc -> return WeatherType.SnowGrains.iconRes
        WeatherType.SlightRainShowers.weatherDesc -> WeatherType.SlightRainShowers.iconRes
        WeatherType.DepositingRimeFog.weatherDesc -> return WeatherType.DepositingRimeFog.iconRes
        WeatherType.ViolentRainShowers.weatherDesc -> return WeatherType.ViolentRainShowers.iconRes
        WeatherType.SlightSnowShowers.weatherDesc -> WeatherType.SlightSnowShowers.iconRes
        WeatherType.HeavySnowShowers.weatherDesc -> return WeatherType.HeavySnowShowers.iconRes
        WeatherType.ModerateThunderstorm.weatherDesc -> return WeatherType.ModerateThunderstorm.iconRes
        WeatherType.SlightHailThunderstorm.weatherDesc -> return WeatherType.SlightHailThunderstorm.iconRes
        WeatherType.HeavyHailThunderstorm.weatherDesc -> return WeatherType.HeavyHailThunderstorm.iconRes
    }
    return R.drawable.ic_sunny
}
*/


fun weatherIcon(code: Int): Int {
    return when (code) {
        1000 -> ClearSky.iconRes
        1003 -> MainlyClear.iconRes
        1006 -> PartlyCloudy.iconRes
        1009 -> Overcast.iconRes
        1135 -> Foggy.iconRes
        1147 -> DepositingRimeFog.iconRes
        1153 -> LightDrizzle.iconRes
        53 -> ModerateDrizzle.iconRes
        55 -> DenseDrizzle.iconRes
        1168 -> LightFreezingDrizzle.iconRes
        1171 -> DenseFreezingDrizzle.iconRes
        1183 -> SlightRain.iconRes
        1186 -> ModerateRain.iconRes
        1192 -> HeavyRain.iconRes
        1198 -> LightFreezingDrizzle.iconRes
        1201 -> HeavyFreezingRain.iconRes
        1213 -> SlightSnowFall.iconRes
        1219 , 1216 -> ModerateSnowFall.iconRes
        1225 -> HeavySnowFall.iconRes
        77 -> SnowGrains.iconRes
        1246 , 1249 , 1240 -> SlightRainShowers.iconRes
        1243 -> ModerateRainShowers.iconRes
        1252 -> ViolentRainShowers.iconRes
        1255 -> SlightSnowShowers.iconRes
        1258 -> HeavySnowShowers.iconRes
        1273 , 1279 -> SlightHailThunderstorm.iconRes
        1087 , 1282 , 1276 -> HeavyHailThunderstorm.iconRes
        else -> ClearSky.iconRes
    }
}


