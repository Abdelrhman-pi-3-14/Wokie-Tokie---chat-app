package com.example.walkie_talkie.system.presentation.feature_weather.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walkie_talkie.system.common.Constants
import com.example.walkie_talkie.system.common.NetworkResponse
import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.RetrofitInstance
import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.RetrofitInstance.weatherApi2
import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeatherApi2
import com.example.walkie_talkie.system.data.app_design.feature_weather.remote.WeathreDTOV2.WeatherInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel : ViewModel() {
    private val weatherApi: WeatherApi2 = RetrofitInstance.weatherApi2
    private val _weatherData = MutableLiveData<NetworkResponse<WeatherInfo>>()
    val weatherData: LiveData<NetworkResponse<WeatherInfo>> = _weatherData

    fun GetData(city: String) {
        _weatherData.postValue(NetworkResponse.Loading)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val response =
                        weatherApi.getCurrentWeather(city = city , apiKey = Constants.API_KEY2)
                    if (response.isSuccessful) {
                        response.body()?.let {
                            _weatherData.postValue(NetworkResponse.Success(it))
                            Log.i("api" , response.body().toString())
                        }
                    } else {
                        _weatherData.value = NetworkResponse.Error("Error loading weather data")
                    }
                } catch (e: Exception) {
                    _weatherData.postValue(NetworkResponse.Error(e.message ?: "An error occurred"))
                }
            }
        }
    }
}

