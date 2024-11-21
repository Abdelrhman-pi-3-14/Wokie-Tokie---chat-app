package com.example.walkie_talkie.system.presentation.app_design.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


// the navigation graph
@Composable
fun NestedNavigationGraph(navController: NavHostController , isLoggedIn: Boolean) {

    NavHost(
        navController = navController ,
        startDestination = if (isLoggedIn) Screen.Home_graph.route else Screen.Authentication.route
    ) {
        Home(navController = navController)
        Menu(navController = navController)
        AiScreen(navController = navController)
        Settings(navController = navController)
        Auth(navController = navController)
        //   Friends(navController = navController)

    }

}



