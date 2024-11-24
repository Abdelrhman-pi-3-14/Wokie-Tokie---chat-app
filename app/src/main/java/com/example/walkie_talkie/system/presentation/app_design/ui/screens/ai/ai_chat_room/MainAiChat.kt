package com.example.walkie_talkie.system.presentation.app_design.ui.screens.ai.ai_chat_room

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.send_ic
import com.example.walkie_talkie.system.presentation.app_design.ui.componant.messages.AiInPut
import com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel.AiViewModel
import com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel.MessageList
import com.example.walkie_talkie.theme.black
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.darkBlue3
import com.example.walkie_talkie.theme.lightBlue

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainAiChat(navController: NavController) {

    val message = remember { mutableStateOf("") }
    val aiViewModel = AiViewModel()
    val messageList by aiViewModel.messageListState.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .windowInsetsPadding(WindowInsets.ime) ,
        topBar = {
            Surface(
                modifier = Modifier
                    .shadow(
                        elevation = 100.dp ,
                        ambientColor = black ,
                        spotColor = black
                    )
                    .background(darkBlue3)
                    .fillMaxWidth() ,
               shape = RoundedCornerShape(bottomStart = 30.dp , bottomEnd = 30.dp)
            ) {
                ChatWikiTokiScreen(navController = navController)
            }
        } ,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(id = R.drawable.chat_wallpaper) ,
                        alignment = Alignment.Center ,
                        contentScale = ContentScale.Crop
                    )
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val (messages , chatBox , sendButton) = createRefs()

                    MessageList(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 60.dp , bottom = 48.dp)
                        .constrainAs(messages) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(chatBox.top , margin = 16.dp)
                        } , messageList = messageList)

                    AiInPut(
                        message = message ,
                        onMessageSend = {
                            aiViewModel.onMessageSend(message.value)
                            message.value = ""
                        } ,
                        modifier = Modifier.constrainAs(chatBox) {
                            bottom.linkTo(parent.bottom , margin = 32.dp)
                            start.linkTo(parent.start)
                            end.linkTo(sendButton.start)
                        }
                    )

                    Button(
                        onClick = {
                            aiViewModel.onMessageSend(message.value)
                            message.value = ""

                        } ,
                        modifier = Modifier
                            .size(50.dp)
                            .constrainAs(sendButton) {
                                bottom.linkTo(parent.bottom , margin = 32.dp)
                                end.linkTo(parent.end , margin = 8.dp)
                            } ,
                        colors = ButtonDefaults.buttonColors(
                            lightBlue
                        ) ,
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(send_ic) ,
                            tint = darkBlue2 ,
                            modifier = Modifier
                                .requiredSize(30.dp) ,
                            contentDescription = null
                        )


                    }
                }
            }
        }
    )
}







