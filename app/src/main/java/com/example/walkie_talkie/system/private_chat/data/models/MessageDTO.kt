package com.example.walkie_talkie.system.private_chat.data.models

data class MessageDTO(
    val id: Int,
    val chatId: Int,
    val sender: SenderDTO,
    val content: String,
    val timestamp: String,
    val seen: Boolean
)
