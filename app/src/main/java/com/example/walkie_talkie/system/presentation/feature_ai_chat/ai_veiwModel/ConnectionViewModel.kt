package com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConnectionViewModel() : ViewModel() {

    private val _isNetworkAvailable = MutableLiveData<Boolean>()
    val isNetworkAvailable: LiveData<Boolean> = _isNetworkAvailable

    fun setIsNetworkAvailable(isNetworkAvailable: Boolean) {
        _isNetworkAvailable.value = isNetworkAvailable
    }
}



