package com.example.walkie_talkie.system.app_design.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.chats.ChatsScreen
import com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.chats.chat_room.ProfileInfo


@RequiresApi(Build.VERSION_CODES.S)
fun NavGraphBuilder.Chat(navController: NavController) {
    navigation(
        startDestination = Screen.MainScreen.route ,
        route = Screen.Chat_graph.route
    ) {
        composable(Screen.MainScreen.route) {
            ChatsScreen(navController)
        }

        composable(Screen.UserInfo.route) {
            ProfileInfo()
        }
        composable(Screen.UserMedia.route) {  }
    }
}