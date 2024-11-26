package com.example.walkie_talkie.system.data.app_design.feature_ai_chat.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch


sealed interface NetworkState {
    data object Available : NetworkState
    data object Unavailable : NetworkState
    data object Losing : NetworkState
    data object Lost : NetworkState
}

interface NetworkStateProvider {
    fun observe(): Flow<NetworkState>

}


class Connection(context: Context) : NetworkStateProvider {
    private var connectionManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    /*
        fun checkConnection() {
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




        private val networkCallback = object : android.net.ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                val capabilities = connectionManager.getNetworkCapabilities(network)
                if (capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true) {

                }
            }

            override fun onCapabilitiesChanged(
                network: Network ,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network , networkCapabilities)
            }

            override fun onUnavailable() {
                super.onUnavailable()

            }


            override fun onLost(network: Network) {
                super.onLost(network)

            }

        }
    */

    override fun observe(): Flow<NetworkState> {
        return callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    launch {
                        send(NetworkState.Available)
                    }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    launch {
                        send(NetworkState.Lost)
                    }
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    launch {
                        send(NetworkState.Unavailable)
                    }
                }

                override fun onLosing(network: Network , maxMsToLive: Int) {
                    super.onLosing(network , maxMsToLive)
                    launch {
                        send(NetworkState.Losing)
                    }
                }
            }

            connectionManager.registerDefaultNetworkCallback(callback)
            awaitClose {
                connectionManager.unregisterNetworkCallback(callback)
            }

        }.distinctUntilChanged()
    }
}

