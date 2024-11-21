package com.example.walkie_talkie.system.presentation.app_design.ui.componant.messages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.walkie_talkie.R
import com.example.walkie_talkie.R.drawable.emoji
import com.example.walkie_talkie.theme.black
import com.example.walkie_talkie.theme.darkBlue
import com.example.walkie_talkie.theme.lightBlue


@Composable
fun InPut(message: MutableState<String> ,onMessageSend : (String) -> Unit , modifier: Modifier) {


    TextField(value = message.value ,
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
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp ,
                color = lightBlue ,
                shape = RoundedCornerShape(50.dp)
            ) ,
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
            Image(
                imageVector = ImageVector.vectorResource(emoji) ,
                modifier = Modifier
                    .clickable {
                } ,
                contentDescription = "Search" ,
            )
        } ,
        trailingIcon = {
            if (message.value.isEmpty()) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.camera_ic) ,
                    modifier = Modifier.clickable {
                    } ,
                    contentDescription = "Search" ,
                    tint = Color.Gray
                )
            }
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.attach_ic) ,
                    modifier = Modifier
                        .padding(end = if (message.value.isEmpty()) 64.dp else 16.dp)
                        .clickable {
                        } ,
                    contentDescription = "Search" , tint = Color.Gray
                )


        }
    )

}