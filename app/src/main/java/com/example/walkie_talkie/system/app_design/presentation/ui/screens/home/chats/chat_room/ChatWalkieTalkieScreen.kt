package com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.chats.chat_room

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.system.app_design.presentation.navigation.Screen
import com.example.walkie_talkie.system.app_design.presentation.ui.componant.woki_toki_screen.status_bar.StatusBar
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue
import com.example.walkie_talkie.ui_thames.digital


@Composable
fun ChatWalkieTalkieScreen(image: Int , userName: String , navController: NavController) {
    var show = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .background(darkBlue)
    ) {
        var isActive = false
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (statusBar , backIcon , userProfile , name , typing , online , moreIcon) = createRefs()

            StatusBar(
                modifier = Modifier.constrainAs(statusBar) {
                    top.linkTo(parent.top , margin = 10.dp)
                    start.linkTo(parent.start , margin = 8.dp)
                    end.linkTo(parent.end , margin = 8.dp)
                } ,
                backGround = darkBlue
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.back_ic) ,
                contentDescription = null ,
                modifier = Modifier
                    .constrainAs(backIcon) {
                        top.linkTo(statusBar.bottom , margin = 32.dp)
                        start.linkTo(parent.start , margin = 16.dp)
                    }
                    .clickable {
                        navController.popBackStack()
                    } , tint = lightBlue

            )
            Image(
                painter = painterResource(id = image) ,
                contentDescription = "user profile" ,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .aspectRatio(1f)
                    .clickable(enabled = true , onClick = {
                        navController.navigate(Screen.UserInfo.route)
                    })
                    .constrainAs(userProfile) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        start.linkTo(backIcon.end , margin = 16.dp)
                    }
            )

            Text(
                text = userName ,
                color = lightBlue ,
                overflow = TextOverflow.Ellipsis ,
                maxLines = 1 ,
                fontFamily = digital ,
                fontSize = 20.sp ,
                modifier = Modifier
                    .constrainAs(name) {
                        top.linkTo(statusBar.bottom , margin = 24.dp)
                        start.linkTo(userProfile.end , margin = 16.dp)
                    }
                    .width(200.dp) ,
            )
            Text(
                text = "typing..." ,
                color = lightBlue ,
                style = TextStyle(fontWeight = FontWeight.Bold) ,
                fontSize = 16.sp ,
                modifier = Modifier.constrainAs(typing) {
                    top.linkTo(name.bottom , margin = 8.dp)
                    start.linkTo(userProfile.end , margin = 16.dp)
                } ,
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.seen_ic) ,
                contentDescription = null ,
                tint = if (isActive) Green else Red ,
                modifier = Modifier
                    .border(1.dp , lightBlue , CircleShape)
                    .constrainAs(online) {
                        top.linkTo(statusBar.bottom , margin = 16.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }

            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.more_ic) ,
                contentDescription = null ,
                tint = lightBlue ,
                modifier = Modifier
                    .constrainAs(moreIcon) {
                        top.linkTo(online.bottom , margin = 16.dp)
                        end.linkTo(parent.end , margin = 24.dp)
                    }
                    .clickable {

                    }
            )
        }
    }
}

