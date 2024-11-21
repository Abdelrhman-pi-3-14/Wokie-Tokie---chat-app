package com.example.walkie_talkie.system.infrastructure

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun isConnected(context: Context): Boolean {
    val connectivityManger =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManger.getNetworkCapabilities(
        connectivityManger.activeNetwork
    )
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        ?: false
}