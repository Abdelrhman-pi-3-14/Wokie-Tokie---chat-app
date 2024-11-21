package com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConnectionViewModel : ViewModel() {
    private val _isConnected = MutableLiveData<Boolean>()
    val isConnected: LiveData<Boolean> = _isConnected


    fun isConnected(isConnect: Boolean) {
        _isConnected.value = isConnect
    }
}