package com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.walkie_talkie.system.domain.feature_ai_chat.MessageData
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.messages.FriendMessage
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.messages.UserMessages


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MessageList(
    modifier: Modifier ,
    messageList: List<MessageData> ,
) {

    LazyColumn(
        verticalArrangement = Arrangement.Top ,
        modifier = modifier ,
    ) {
        items(messageList) { message ->
            if (message.user == "user") {
                Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.CenterEnd) {
                    UserMessages(messageContent = message)
                }
            } else if (message.user == "model") {
                Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.CenterStart) {
                    FriendMessage(messageContent = message )
                }
            }
        }
    }
}



