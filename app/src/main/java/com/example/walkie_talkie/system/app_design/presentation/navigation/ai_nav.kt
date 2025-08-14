package com.example.walkie_talkie.system.app_design.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.walkie_talkie.system.feature_ai_chat.presentation.ui.MainAiChat

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.AiScreen(navController: NavController) {
    navigation(
        startDestination = Screen.Ai.route ,
        route = Screen.AiGraph.route
    ) {
        composable(Screen.Ai.route) {
            MainAiChat(navController)
        }
    }
}