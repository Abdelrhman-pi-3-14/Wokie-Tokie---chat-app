package com.example.walkie_talkie.system.app_design.presentation.navigation

sealed class Screen(val route: String) {

    /* ------------------- Main Pages ------------------- */
    data object MainScreen : Screen("main_screen")
    data object Chats : Screen("chats")
    data object PrivateChat : Screen("private_chat")
    data object Channels : Screen("groups")
    data object Status : Screen("stories")
    data object Ai : Screen("ai")

    /* ------------------- User & Chat Details ------------------- */
    data object UserInfo : Screen("user_info")
    data object UserMedia : Screen("user_media")
    data object LockedChats : Screen("locked_chats")

    /* ------------------- Collections ------------------- */
    data object Fav : Screen("favorite")
    data object Arch : Screen("archive")

    /* ------------------- Settings & Preferences ------------------- */
    data object Settings : Screen("settings")
    data object Themes : Screen("themes")
    data object Privacy : Screen("privacy")
    data object Notifications : Screen("notifications")
    data object AiSetting : Screen("ai_setting")

    /* ------------------- App Info & Support ------------------- */
    data object Updates : Screen("updates")
    data object Help : Screen("help")
    data object Error : Screen("error")

    /* ------------------- Authentication ------------------- */
    data object AuthScreen1 : Screen("auth_screen_1")
    data object AuthScreen2 : Screen("auth_screen_2")
    data object AuthScreen3 : Screen("auth_screen_3")
    data object Login : Screen("login")
    data object Signup : Screen("signup")
    data object ForgotPassword : Screen("forgot_password")
    data object Verification : Screen("verification")

    /* ------------------- Navigation Graph Roots ------------------- */
    data object HomeGraph : Screen("home_graph")
    data object ChatGraph : Screen("chat_graph")
    data object SettingsGraph : Screen("settings_graph")
    data object MenuGraph : Screen("menu_graph")
    data object AuthenticationGraph : Screen("authentication_graph")
    data object UsersGraph : Screen("users_graph")
    data object AiGraph : Screen("ai_graph")
}
