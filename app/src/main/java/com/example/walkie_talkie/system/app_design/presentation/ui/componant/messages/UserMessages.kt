package com.example.walkie_talkie.system.app_design.presentation.ui.componant.messages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.feature_ai_chat.data.remote.MessageData
import com.example.walkie_talkie.theme.darkGreen
import com.example.walkie_talkie.theme.darkPurple
import com.example.walkie_talkie.theme.lightBlue
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserMessages(
    messageContent: MessageData
) {
    messageContent.sendingDate = LocalDate.now()

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .widthIn(min = 150.dp , max = 200.dp)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 30.dp ,
                        bottomStart = 30.dp ,
                        topStart = 30.dp
                    )
                ) ,
            colors = CardDefaults.cardColors(containerColor = lightBlue)
        ) {
            Column(
                verticalArrangement = Arrangement.Top ,
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Text(
                    text = messageContent.text ,
                    fontSize = 20.sp ,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(16.dp , 16.dp , 16.dp , 0.dp) ,
                    color = Color.White

                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.End ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp) ,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = messageContent.sendingTime ,
                        color = darkPurple
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (messageContent.isSent && !messageContent.isDelivered && !messageContent.isSeen) {
                                R.drawable.done_ic
                            } else {
                                R.drawable.done_all_ic
                            }
                        ) ,
                        contentDescription = null ,
                        tint = if (messageContent.isSeen) darkGreen else Color.Gray ,
                        modifier = Modifier
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                }
                Spacer(modifier = Modifier.height(8.dp))
            }


        }


    }

}



