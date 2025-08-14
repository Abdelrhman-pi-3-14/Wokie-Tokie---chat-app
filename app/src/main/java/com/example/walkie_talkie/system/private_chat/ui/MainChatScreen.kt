package com.example.walkie_talkie.system.private_chat.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.chat_wallpaper
import com.example.walkie_talkie.R.drawable.emoji
import com.example.walkie_talkie.R.drawable.female_profile
import com.example.walkie_talkie.R.drawable.mic_ic
import com.example.walkie_talkie.R.drawable.send_ic
import com.example.walkie_talkie.system.feature_ai_chat.presentation.ui.ChatWikiTokiScreen
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.darkBlue2
import com.example.walkie_talkie.theme.lightBlue


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainChatScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.ime) ,
        topBar = {
            Surface(
                modifier = Modifier
                    .background(darkBlue2) ,
                shape = RoundedCornerShape(bottomStart = 50.dp , bottomEnd = 50.dp)
            ) {
                ChatWikiTokiScreen(navController , "user 2" , female_profile)
            }
        } ,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .paint(
                        painter = painterResource(id = chat_wallpaper) ,
                        alignment = Alignment.Center ,
                        contentScale = ContentScale.Crop
                    )
            ) {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (messages , chatBox , sendButton) = createRefs()
                    var isActive by remember { mutableStateOf(false) }
                    var text by remember { mutableStateOf("") }
                    var width = if (isActive) 270.dp else 300.dp
                    var buttonSize = if (isActive) 70.dp else 50.dp
                    if (text != "") {
                        isActive = true
                    }
                    if (text == "") {
                        isActive = false
                    }


                    TextField(
                        value = text ,
                        onValueChange = {
                            text = it
                        } ,
                        enabled = true ,
                        modifier = Modifier
                            .wrapContentHeight()
                            .width(300.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .border(
                                width = 1.dp ,
                                color = lightBlue ,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .constrainAs(chatBox) {
                                bottom.linkTo(parent.bottom , margin = 32.dp)
                                start.linkTo(parent.start)
                                end.linkTo(sendButton.start)
                            } ,
                        placeholder = {
                            Text(text = "Message" , style = TextStyle(color = Color.Gray))
                        } ,
                        maxLines = 50 ,
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = lightBlue ,
                            unfocusedTextColor = lightBlue ,
                            focusedContainerColor = darkBlue ,
                            unfocusedContainerColor = darkBlue ,
                            focusedIndicatorColor = darkBlue ,
                            unfocusedIndicatorColor = darkBlue ,
                            cursorColor = lightBlue
                        ) ,
                        singleLine = true ,

                        textStyle = TextStyle(
                            color = Color.White ,
                            fontSize = 20.sp ,
                        ) , keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done) ,
                        keyboardActions = KeyboardActions(onDone = {

                        }) ,
                        leadingIcon = {
                            Image(
                                imageVector = ImageVector.vectorResource(emoji) ,
                                modifier = Modifier.clickable {
                                } ,
                                contentDescription = "Search" ,
                            )
                        } ,
                        trailingIcon = {
                            if (text.isEmpty()) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.camera_ic) ,
                                    modifier = Modifier.clickable {
                                    } ,
                                    contentDescription = "Search" ,
                                    tint = Color.Gray
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.attach_ic) ,
                                    modifier = Modifier
                                        .padding(end = 64.dp)
                                        .clickable {
                                        } ,
                                    contentDescription = "Search" , tint = Color.Gray
                                )
                            }

                        }
                    )


                    Button(
                        onClick = { } ,
                        modifier = Modifier
                            .size(60.dp)
                            .constrainAs(sendButton) {
                                bottom.linkTo(parent.bottom , margin = 32.dp)
                                end.linkTo(parent.end , margin = 16.dp)
                            } ,
                        colors = ButtonDefaults.buttonColors(
                            lightBlue
                        ) ,
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(
                                if (isActive) send_ic else mic_ic
                            ) ,
                            tint = darkBlue2 ,
                            modifier = Modifier
                                .size(50.dp)
                                .scale(2.5f) ,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}






