package com.example.walkie_talkie.system.feature_ai_chat.data.remote

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.walkie_talkie.system.app_design.presentation.ui.componant.woki_toki_screen.status_bar.currentTime
import java.time.LocalDate

data class MessageData @RequiresApi(Build.VERSION_CODES.O) constructor(
    val user: String ,
    val text: String ,
    val isSent: Boolean ,
    val isDelivered: Boolean ,
    val isSeen: Boolean ,
    var isFav: Boolean ,
    val sendingTime: String = currentTime() ,
    val bitmap: Bitmap? = null ,
    var sendingDate: LocalDate
)






