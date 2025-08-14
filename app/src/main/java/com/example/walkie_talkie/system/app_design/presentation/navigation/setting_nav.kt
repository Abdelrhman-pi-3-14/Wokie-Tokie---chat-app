package com.example.walkie_talkie.system.app_design.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.Settings(navController: NavController) {
    navigation(

        startDestination = Screen.Settings.route ,
        Screen.SettingsGraph.route ,
    ) {

        composable(Screen.Privacy.route) {

        }

        composable(Screen.Notifications.route) {

        }

        composable(Screen.Updates.route) {

        }

        composable(Screen.Help.route) {

        }


        composable(Screen.AiSetting.route) {

        }
    }
}