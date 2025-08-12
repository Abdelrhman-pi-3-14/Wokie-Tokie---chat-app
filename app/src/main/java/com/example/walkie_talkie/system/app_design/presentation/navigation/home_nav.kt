package com.example.walkie_talkie.system.app_design.presentation.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.app_design.presentation.ui.componant.errors.ErrorScreen
import com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.HomeScreen
import com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.channels.ChannelsScreen
import com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.status.StatusScreen


@RequiresApi(Build.VERSION_CODES.S)
fun NavGraphBuilder.Home(navController: NavController) {
    navigation(
        startDestination = Screen.MainScreen.route ,
        route = Screen.Home_graph.route
    ) {
        composable(Screen.MainScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.Chats.route) {
            Chat(navController)
        }
        composable(Screen.Status.route) {
            StatusScreen(navController)
        }
        composable(Screen.Channels.route) {
            ChannelsScreen(navController)

        }
        composable(Screen.Error.route) {
            ErrorScreen(navController , "Error: Unknown route")
        }
    }
}

