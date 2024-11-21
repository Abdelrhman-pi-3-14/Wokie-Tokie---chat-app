package com.example.walkie_talkie.system.infrastructure

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModelProvider
import com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel.ConnectionViewModel

class ConnectionBroadCast : BroadcastReceiver() {
    override fun onReceive(context: Context? , intent: Intent?) {
        if (intent?.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val isConnected = context?.let { isConnected(it) }
            val connectionViewModel =
                ViewModelProvider.AndroidViewModelFactory.getInstance(context?.applicationContext as Application)
                    .create(ConnectionViewModel::class.java)
            connectionViewModel.isConnected(isConnected!!)

        }
    }
}

