package com.example.walkie_talkie.system

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.walkie_talkie.system.app_design.presentation.navigation.NestedNavigationGraph

@Composable
fun MyApp(){
    val navController = rememberNavController()
    val isLoggedIn = true
NestedNavigationGraph(
    navController = navController,
    isLoggedIn = isLoggedIn
)
}