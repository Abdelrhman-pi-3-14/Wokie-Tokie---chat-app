package com.example.walkie_talkie.system.presentation.app_design.ui.componant.messages

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TypingIndicator() {
    val dotAlpha = remember { mutableStateOf<Float>(1f) }
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f ,
        targetValue = 0f ,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 700 ,
                easing = LinearEasing
            ) ,
            repeatMode = RepeatMode.Reverse
        ) , label = ""
    )

    Row(
        modifier = Modifier.padding(8.dp) ,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(3) {
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .background(Color.Gray.copy(alpha = dotAlpha.value) , CircleShape)
            )
        }
    }
}