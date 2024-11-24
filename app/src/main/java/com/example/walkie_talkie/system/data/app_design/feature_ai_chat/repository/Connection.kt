package com.example.walkie_talkie.system.data.app_design.feature_ai_chat.repository

import android.content.Context
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData
import com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel.ConnectionViewModel

class Connection(context: Context , private val connectionViewModel : ConnectionViewModel) : LiveData<Boolean>() {

    private fun checkConnection() {

        val network = connectionManager.activeNetwork

        if (network == null) {
            postValue(false)
        }
        val requestBuilder = NetworkRequest.Builder().apply {
            addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
        }.build()
        connectionManager.registerNetworkCallback(requestBuilder , networkCallback)
    }


    override fun onActive() {
        super.onActive()
        checkConnection()
    }

    override fun onInactive() {
        super.onInactive()
        connectionManager.unregisterNetworkCallback(networkCallback)
    }


    private var connectionManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as android.net.ConnectivityManager

    private val networkCallback = object : android.net.ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
            connectionViewModel.setIsNetworkAvailable(true)
        }

        override fun onCapabilitiesChanged(
            network: Network ,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network , networkCapabilities)
        }

        override fun onUnavailable() {
            super.onUnavailable()
            postValue(false)
            connectionViewModel.setIsNetworkAvailable(false)
        }


        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
            connectionViewModel.setIsNetworkAvailable(false)
        }

    }


}

