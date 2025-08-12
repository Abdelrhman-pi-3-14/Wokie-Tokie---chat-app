package com.example.walkie_talkie.system.app_design.presentation.ui.screens.home.chats

data class ChatsData(
    val id: Long,
    val name: String,
    val image: Int,
    val lastMessage: String,
    val unreadCount: Int,
    val isOnline: Boolean,
    val time: String,
    val seen: Boolean,
    val sent : Boolean
)