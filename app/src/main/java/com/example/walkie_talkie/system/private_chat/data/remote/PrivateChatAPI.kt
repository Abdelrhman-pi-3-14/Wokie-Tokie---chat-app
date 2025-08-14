package com.example.walkie_talkie.system.private_chat.data.remote

import com.example.walkie_talkie.system.common.NetworkResponse
import com.example.walkie_talkie.system.private_chat.data.models.MessageDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface PrivateChatAPI{
    @POST("sendMessage")
    suspend fun sendMessage(@Body message: String)

    @GET("message")
    suspend fun getMessage(): NetworkResponse<List<MessageDTO>>
}