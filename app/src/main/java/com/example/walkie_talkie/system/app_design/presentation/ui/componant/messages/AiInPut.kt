package com.example.walkie_talkie.system.app_design.presentation.ui.componant.messages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R.drawable.emoji
import com.example.walkie_talkie.theme.black
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue


@Composable
fun AiInPut(message: MutableState<String> , onMessageSend: (String) -> Unit , modifier: Modifier) {


    TextField(
        value = message.value ,
        onValueChange = {
            message.value = it
        } ,
        enabled = true ,
        modifier = modifier
            .wrapContentHeight()
            .width(330.dp)
            .shadow(
                elevation = 10.dp ,
                shape = RoundedCornerShape(50.dp) ,
                ambientColor = black ,
                spotColor = black
            )
            .scrollable(
                state = rememberScrollState() ,
                orientation = Orientation.Vertical
            )
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 2.dp ,
                color = lightBlue ,
                shape = RoundedCornerShape(50.dp)
            ) ,
        placeholder = {
            Text(text = "Type something......." , style = TextStyle(color = Color.Gray))
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
        singleLine = false ,

        textStyle = TextStyle(
            color = Color.White ,
            fontSize = 18.sp ,
        ) ,

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done) ,
        keyboardActions = KeyboardActions(onDone = {
            onMessageSend(message.value)
            message.value = ""
        }) ,
        leadingIcon = {
            Row( // Wrap in a Row if necessary
                modifier = Modifier.padding(start = 16.dp) , // Apply padding to the Row
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(emoji) ,
                    modifier = Modifier
                        .clickable {

                        } ,
                    contentDescription = "Search" ,
                )
            }
        } ,

        )

}