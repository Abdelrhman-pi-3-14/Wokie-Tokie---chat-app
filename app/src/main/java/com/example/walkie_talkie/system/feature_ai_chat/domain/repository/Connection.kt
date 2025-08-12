package com.example.walkie_talkie.system.feature_ai_chat.domain.repository

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

