package com.example.walkie_talkie.system.app_design.presentation.ui.componant.messages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.app_design.presentation.ui.componant.woki_toki_screen.status_bar.currentTime
import com.example.walkie_talkie.system.feature_ai_chat.data.remote.MessageData
import com.example.walkie_talkie.theme.darkPurple
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.theme.lightPurple
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun UserReplyMessage(
    messageContent: MessageData = MessageData(
        user = "user" ,
        text = "Hello from midgard and i just want to say that i do love you" ,
        isSent = true ,
        isDelivered = true ,
        isSeen = true ,
        isFav = false ,
        sendingTime = currentTime() ,
        sendingDate = LocalDate.now()
    )
) {

    val date = LocalDate.now()

    Card(
        modifier = Modifier
            .widthIn(min = 50.dp , max = 250.dp)
            .heightIn(min = 90.dp , max = .500.dp)
            .clip(RoundedCornerShape(bottomEnd = 30.dp , bottomStart = 30.dp , topStart = 30.dp)) ,
        colors = CardDefaults.cardColors(containerColor = lightPurple)
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (message , seen , time , isFav) = createRefs()



            Text(
                text = messageContent.text ,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp , bottom = 24.dp , start = 8.dp , end = 8.dp)
                    .constrainAs(message) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    } , color = Color.White

            )

            Icon(
                imageVector = ImageVector.vectorResource(
                    if (messageContent.isSent && !messageContent.isDelivered && !messageContent.isSeen) {
                        R.drawable.done_ic
                    } else {
                        R.drawable.done_all_ic
                    }
                ) ,
                contentDescription = null ,
                tint = if (messageContent.isSeen) lightBlue else Color.Gray ,
                modifier = Modifier
                    .size(15.dp)
                    .constrainAs(seen) {
                        bottom.linkTo(parent.bottom , margin = 8.dp)
                        end.linkTo(parent.end , margin = 16.dp)
                    }
            )

            Text(
                text = messageContent.sendingTime ,
                modifier = Modifier.constrainAs(time) {
                    bottom.linkTo(parent.bottom , margin = 6.dp)
                    end.linkTo(seen.start , margin = 16.dp)
                } , color = darkPurple
            )
            //messageContent.sendingDate = LocalDate.now()

        }
    }
}