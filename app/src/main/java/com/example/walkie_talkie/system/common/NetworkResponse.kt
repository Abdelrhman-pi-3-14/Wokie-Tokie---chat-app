package com.example.walkie_talkie.system.common

sealed class NetworkResponse<out T> {
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Error(val message: String) : NetworkResponse<Nothing>()
    data object Loading : NetworkResponse<Nothing>()


}