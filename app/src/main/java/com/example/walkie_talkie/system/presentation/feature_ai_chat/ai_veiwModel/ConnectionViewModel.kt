/*
package com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel

import NetworkState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walkie_talkie.system.data.app_design.feature_ai_chat.repository.Connection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConnectionViewModel(val connection: Connection) : ViewModel() {


    private val _isNetworkAvailable = MutableStateFlow<NetworkState>(NetworkState.Unavailable)
    val isNetworkAvailable: MutableStateFlow<NetworkState> = _isNetworkAvailable


    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                connection.observe().collect { networkState ->
                    _isNetworkAvailable.value = networkState
                }
            }
        }
    }
}
*/



