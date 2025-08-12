package com.example.walkie_talkie.system.private_chat.ui

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walkie_talkie.R
import com.example.walkie_talkie.theme.Purple80
import com.example.walkie_talkie.theme.PurpleGrey40
import com.example.walkie_talkie.theme.darkGreen
import com.example.walkie_talkie.ui_thames.DarkColorScheme.lightBlue
import com.example.walkie_talkie.ui_thames.digital

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun ChatCard(
    imageURL: String? ,
    userName: String ,
    lastMessage: String ,
    currentTime: String ,
    imageOnClick: () -> Unit ,
    cardOnClick: () -> Unit ,
    isSeen: Boolean ,
    isDelivered: Boolean ,
    isSent: Boolean ,
    newMessage: Boolean
) {
    val isSeenState = remember { mutableStateOf(isSeen) }
    val isDeliveredState = remember { mutableStateOf(isDelivered) }
    val isSentState = remember { mutableStateOf(isSent) }

    // Box container to replace Card
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { cardOnClick() }
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    clip = true
                    alpha = 0.6f
                    renderEffect = RenderEffect
                        .createBlurEffect(25f , 25f , Shader.TileMode.MIRROR)
                        .asComposeRenderEffect()
                }
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.7f) ,
                            Color.White.copy(alpha = 0.7f)
                        ) ,
                        startY = 0f ,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawRect(Color.Black.copy(alpha = 0.1f))
                        drawRect(gradient , blendMode = BlendMode.Lighten)
                    }
                }
                .background(Color.White.copy(alpha = 0.1f))
        )

        // Content layer - using Row instead of ConstraintLayout for simplicity
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile image
            Image(
                painter = painterResource(id = R.drawable.female_profile) ,
                contentDescription = "Profile image" ,
                modifier = Modifier
                    .clickable { imageOnClick() }
                    .size(90.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Text content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = userName ,
                        modifier = Modifier.weight(1f) ,
                        fontWeight = FontWeight.Bold ,
                        fontSize = 20.sp ,
                        overflow = TextOverflow.Ellipsis ,
                        maxLines = 1 ,
                        color = Color.White

                    )

                    Text(
                        text = currentTime ,
                        fontSize = 18.sp ,
                        fontStyle = FontStyle.Italic ,
                        fontFamily = digital ,
                        color = if (newMessage) darkGreen else Purple80
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Message content
                Text(
                    text = lastMessage ,
                    fontSize = 18.sp ,
                    overflow = TextOverflow.Ellipsis ,
                    maxLines = 2 ,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Status indicator
                Box(modifier = Modifier.fillMaxWidth()) {
                    if (newMessage) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.seen_ic) ,
                            contentDescription = "New message" ,
                            modifier = Modifier.size(15.dp) ,
                            tint = lightBlue
                        )
                    } else {
                        when {
                            isSentState.value -> Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.done_ic) ,
                                contentDescription = "Sent" ,
                                modifier = Modifier.size(15.dp) ,
                                tint = PurpleGrey40
                            )

                            isDeliveredState.value -> Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.done_all_ic) ,
                                contentDescription = "Delivered" ,
                                modifier = Modifier.size(15.dp) ,
                                tint = PurpleGrey40
                            )

                            isSeenState.value -> Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.done_all_ic) ,
                                contentDescription = "Seen" ,
                                modifier = Modifier.size(15.dp) ,
                                tint = darkGreen
                            )
                        }
                    }
                }
            }
        }
    }
}

/*@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun ChatCard2(
    imageURL: String?,
    userName: String,
    lastMessage: String,
    currentTime: String,
    imageOnClick: () -> Unit,
    cardOnClick: () -> Unit,
    isSeen: Boolean,
    isDelivered: Boolean,
    isSent: Boolean,
    newMessage: Boolean
) {
    var isSeen = remember { mutableStateOf(isSeen) }
    var isDelivered = remember { mutableStateOf(isDelivered) }
    var isSent = remember { mutableStateOf(isSent) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(16.dp, top = 12.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable { cardOnClick() },
        shape = MaterialTheme.shapes.medium
    ) {
        // Box to separate background and content
        Box(modifier = Modifier.fillMaxSize()) {
            // Blurry background layer
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .graphicsLayer {
                        alpha = 0.6f
                        clip = true
                        renderEffect = RenderEffect
                            .createBlurEffect(30f, 30f, Shader.TileMode.CLAMP)
                            .asComposeRenderEffect()
                    }
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.1f),
                                Color.White.copy(alpha = 0.1f)
                            ),
                            startY = 0f,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    }
            )

            // Content layer (not blurred)
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (image, name, content, time, seenIcon) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.female_profile),
                    contentDescription = "image",
                    modifier = Modifier
                        .clickable { imageOnClick() }
                        .height(100.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start, margin = 16.dp)
                            bottom.linkTo(parent.bottom)
                        }
                )
                Text(
                    text = userName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 24.dp)
                        .constrainAs(name) {
                            top.linkTo(parent.top, margin = 24.dp)
                            start.linkTo(image.end, margin = 16.dp)
                        },
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = lastMessage,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 24.dp)
                        .constrainAs(content) {
                            top.linkTo(name.bottom, margin = 10.dp)
                            start.linkTo(seenIcon.end, margin = 10.dp)
                        },
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = currentTime,
                    modifier = Modifier
                        .constrainAs(time) {
                            top.linkTo(parent.top, margin = 24.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        },
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = digital,
                    overflow = TextOverflow.Ellipsis,
                    color = if (newMessage) darkGreen else Color.Gray
                )

                if (newMessage) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.seen_ic),
                        contentDescription = "seen",
                        modifier = Modifier
                            .constrainAs(seenIcon) {
                                top.linkTo(parent.top, margin = 10.dp)
                                start.linkTo(image.end, margin = 16.dp)
                                end.linkTo(content.start, margin = 16.dp)
                                bottom.linkTo(parent.bottom, margin = 10.dp)
                            }
                            .size(15.dp),
                        tint = lightBlue
                    )
                } else {
                    when {
                        isSent.value -> {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.done_ic),
                                contentDescription = "sent",
                                modifier = Modifier
                                    .size(15.dp)
                                    .constrainAs(seenIcon) {
                                        top.linkTo(parent.top, margin = 10.dp)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(content.start)
                                        start.linkTo(image.end, margin = 10.dp)
                                    },
                                tint = PurpleGrey40
                            )
                        }
                        isDelivered.value -> {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.done_all_ic),
                                contentDescription = "delivered",
                                modifier = Modifier
                                    .size(15.dp)
                                    .constrainAs(seenIcon) {
                                        top.linkTo(parent.top, margin = 10.dp)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(content.start)
                                        start.linkTo(image.end, margin = 10.dp)
                                    },
                                tint = PurpleGrey40
                            )
                        }
                        isSeen.value -> {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.done_all_ic),
                                contentDescription = "seen",
                                modifier = Modifier
                                    .size(15.dp)
                                    .constrainAs(seenIcon) {
                                        top.linkTo(parent.top, margin = 10.dp)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(content.start)
                                        start.linkTo(image.end, margin = 10.dp)
                                    },
                                tint = darkGreen
                            )
                        }
                    }
                }
            }
        }
    }
}*/

