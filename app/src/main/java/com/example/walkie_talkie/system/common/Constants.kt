package com.example.walkie_talkie.system.common

object Constants {

    const val  WEB_SOCKET_BASE_URL ="ws://192.168.1.6:8000/private/chat/"
    const val BASE_URL2 = "https://api.weatherapi.com"
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val BASE_WS_URL = "\"ws://10.0.2.2:8000/ws\""
    fun getPrivateChatUrl(senderId: String, receiverId: String): String {
        return "$BASE_WS_URL/private/chat/$senderId/$receiverId/"
    }

    fun getGroupChatUrl(roomName: String): String {
        return "$BASE_WS_URL/group/chat/$roomName/"
    }
    const val API_KEY = "f07651ca028ab237906878cb0c879291"
    const val API_KEY2 = "2454e096ee46458ab0a220906241511"
   const val GEMINI_API_KEY = "AIzaSyD124gQWjmBtrhxDlLr2TNYfqhvHIq3l4g"
}