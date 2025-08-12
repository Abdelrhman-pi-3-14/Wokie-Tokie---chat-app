package com.example.walkie_talkie.system.feature_ai_chat.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.walkie_talkie.system.app_design.presentation.ui.componant.messages.FriendMessage
import com.example.walkie_talkie.system.app_design.presentation.ui.componant.messages.UserMessages
import com.example.walkie_talkie.system.feature_ai_chat.data.remote.MessageData


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MessageList(
    modifier: Modifier ,
    messageList: List<MessageData> ,
) {




    LazyColumn(
        verticalArrangement = Arrangement.Bottom ,
        modifier = modifier ,
        reverseLayout = true
    ) {
        items(messageList.reversed()) { message ->
            if (message.user == "user") {
                Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.CenterEnd) {
                    UserMessages(messageContent = message)
                }
            } else if (message.user == "model") {
                Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.CenterStart) {
                    FriendMessage(messageContent = message)
                }
            }
        }
    }
}



