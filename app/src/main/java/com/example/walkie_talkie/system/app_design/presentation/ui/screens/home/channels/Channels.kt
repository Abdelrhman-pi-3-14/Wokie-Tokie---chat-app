package com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.channels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.system.app_design.presentation.navigation.Screen
import com.example.walkie_talkie.system.private_chat.ui.ChatCard
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.black
import com.example.walkie_talkie.ui_thames.DarkColorScheme.darkBlue2
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.DarkColorScheme.midPurple
import com.example.walkie_talkie.ui_thames.digital

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun ChannelsScreen(navController: NavController) {
    val background: Brush = Brush.verticalGradient(
        colors = listOf(
            black ,
            black ,
            darkBlue2 ,
            midPurple ,
            lightBlue
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(background)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (chats , newChannelButton ) = createRefs()




            LazyColumn(
                modifier = Modifier
                    .constrainAs(chats) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxSize()
            ) {
                item {
                    // Card 1: New message (blue dot)
                    ChatCard(
                        imageURL = "",
                        userName = "Emily Johnson",
                        lastMessage = "Are we still meeting tomorrow?",
                        currentTime = "09:15 AM",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = false,
                        isDelivered = false,
                        isSent = false,
                        newMessage = true
                    )

                    // Card 2: Sent status (single gray tick)
                    ChatCard(
                        imageURL = "",
                        userName = "Michael Chen",
                        lastMessage = "Sent you the design files",
                        currentTime = "Yesterday",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = false,
                        isDelivered = false,
                        isSent = true,
                        newMessage = false
                    )

                    // Card 3: Delivered status (double gray ticks)
                    ChatCard(
                        imageURL = "",
                        userName = "Sarah Williams",
                        lastMessage = "Thanks for your help!",
                        currentTime = "10:30 PM",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = false,
                        isDelivered = true,
                        isSent = false,
                        newMessage = false
                    )

                    // Card 4: Seen status (double green ticks)
                    ChatCard(
                        imageURL = "",
                        userName = "David Miller",
                        lastMessage = "Meeting moved to 3 PM",
                        currentTime = "11:45 AM",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = true,
                        isDelivered = false,
                        isSent = false,
                        newMessage = false
                    )

                    // Card 5: Long text overflow test
                    ChatCard(
                        imageURL = "",
                        userName = "Alexandra Rodriguez Sanchez",
                        lastMessage = "This is a very long message that should test text overflow capabilities in the UI component",
                        currentTime = "08:00 AM",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = false,
                        isDelivered = true,
                        isSent = false,
                        newMessage = false
                    )

                    // Card 6: New message with special characters
                    ChatCard(
                        imageURL = "",
                        userName = "Mohammed Al-Fayed",
                        lastMessage = "مرحبا! كيف حالك؟",
                        currentTime = "12:30 PM",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = false,
                        isDelivered = false,
                        isSent = false,
                        newMessage = true
                    )

                    // Card 7: Different time color (old message)
                    ChatCard(
                        imageURL = "",
                        userName = "Jennifer Kim",
                        lastMessage = "Did you see the latest update?",
                        currentTime = "Last week",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = true,
                        isDelivered = false,
                        isSent = false,
                        newMessage = false
                    )

                    // Card 8: All status false (no icon)
                    ChatCard(
                        imageURL = "",
                        userName = "Robert Taylor",
                        lastMessage = "Call me when you're free",
                        currentTime = "06:20 PM",
                        imageOnClick = {  },
                        cardOnClick = { navController.navigate(Screen.Chats.route) },
                        isSeen = false,
                        isDelivered = false,
                        isSent = false,
                        newMessage = false
                    )
                }            }








            Button(
                onClick = { } ,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .constrainAs(newChannelButton) {
                        bottom.linkTo(parent.bottom , margin = 24.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    } , colors = ButtonDefaults.buttonColors(
                    darkBlue
                ) , shape = RectangleShape
            ) { Text(
                text = "ADD CHANNEL" ,
                color = lightBlue ,
                modifier = Modifier,
                fontFamily = digital ,
                fontSize = 24.sp
            )
            }

        }
    }


}

