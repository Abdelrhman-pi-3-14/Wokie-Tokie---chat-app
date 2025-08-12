package com.example.walkie_talkie.system.feature_weather.domain.entities

fun weatherIcon(code: Int): Int {
    return when (code) {
        1000 -> WeatherType.ClearSky.iconRes
        1003 -> WeatherType.MainlyClear.iconRes
        1006 -> WeatherType.PartlyCloudy.iconRes
        1009 -> WeatherType.Overcast.iconRes
        1135 -> WeatherType.Foggy.iconRes
        1147 -> WeatherType.DepositingRimeFog.iconRes
        1153 -> WeatherType.LightDrizzle.iconRes
        53 -> WeatherType.ModerateDrizzle.iconRes
        55 -> WeatherType.DenseDrizzle.iconRes
        1168 -> WeatherType.LightFreezingDrizzle.iconRes
        1171 -> WeatherType.DenseFreezingDrizzle.iconRes
        1183 -> WeatherType.SlightRain.iconRes
        1186 -> WeatherType.ModerateRain.iconRes
        1192 -> WeatherType.HeavyRain.iconRes
        1198 -> WeatherType.LightFreezingDrizzle.iconRes
        1201 -> WeatherType.HeavyFreezingRain.iconRes
        1213 -> WeatherType.SlightSnowFall.iconRes
        1219 , 1216 -> WeatherType.ModerateSnowFall.iconRes
        1225 -> WeatherType.HeavySnowFall.iconRes
        77 -> WeatherType.SnowGrains.iconRes
        1246 , 1249 , 1240 -> WeatherType.SlightRainShowers.iconRes
        1243 -> WeatherType.ModerateRainShowers.iconRes
        1252 -> WeatherType.ViolentRainShowers.iconRes
        1255 -> WeatherType.SlightSnowShowers.iconRes
        1258 -> WeatherType.HeavySnowShowers.iconRes
        1273 , 1279 -> WeatherType.SlightHailThunderstorm.iconRes
        1087 , 1282 , 1276 -> WeatherType.HeavyHailThunderstorm.iconRes
        else -> WeatherType.ClearSky.iconRes
    }
}


