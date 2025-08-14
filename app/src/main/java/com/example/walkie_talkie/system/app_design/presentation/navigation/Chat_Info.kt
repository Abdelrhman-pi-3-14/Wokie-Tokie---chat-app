package com.example.walkie_talkie.system.app_design.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.private_chat.ui.ProfileInfo
import com.example.walkie_talkie.system.private_chat.ui.MainChatScreen


@RequiresApi(Build.VERSION_CODES.S)
fun NavGraphBuilder.Chat(navController: NavController) {
    navigation(
        startDestination = Screen.MainScreen.route ,
        route = Screen.ChatGraph.route
    ) {
        composable(Screen.UserInfo.route) { ProfileInfo(navController) }
        composable(Screen.PrivateChat.route ) { MainChatScreen(navController) }
        composable(Screen.UserMedia.route) {

        }
    }
}