package com.example.walkie_talkie.system.presentation.feature_ai_chat.ai_veiwModel

import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walkie_talkie.system.common.Constants.GEMINI_API_KEY
import com.example.walkie_talkie.system.common.NetworkResponse
import com.example.walkie_talkie.system.domain.feature_ai_chat.MessageData
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

class AiViewModel() : ViewModel() {

    private val generativeModel: GenerativeModel = GenerativeModel(
        "gemini-pro" ,
        GEMINI_API_KEY ,
    )

    val messageList by lazy {
        mutableListOf<MessageData>()
    }

    private val _messageList = MutableStateFlow<List<MessageData>>(emptyList())
    val messageListState: StateFlow<List<MessageData>> = _messageList.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun onMessageSend(message: String) {
        viewModelScope.launch {
            try {
                val chat = generativeModel.startChat()
                val userMessage = MessageData(
                    "user" ,
                    message ,
                    isSent = true ,
                    isDelivered = true ,
                    isSeen = true ,
                    isFav = false ,
                    sendingDate = LocalDate.now() ,
                )
                messageList.add(userMessage)
                _messageList.value += userMessage
                val response = chat.sendMessage(message)
                NetworkResponse.Success(response)
                withContext(Dispatchers.IO) {
                    val modelMessage = MessageData(
                        "model" ,
                        response.text.toString() ,
                        isSent = true ,
                        isDelivered = true ,
                        isSeen = true ,
                        isFav = false ,
                        sendingDate = LocalDate.now()
                    )
                    messageList.add(modelMessage)
                    _messageList.value += modelMessage
                    Log.i("gemini" , "response form gemini : ${response.text.toString()}")
                }
            } catch (e: Exception) {
                NetworkResponse.Error(e.message.toString())
            }


        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun onMessageWithImage(message: String , image: Bitmap) {
        viewModelScope.launch {
            try {
                val chat = generativeModel.startChat()
                val userMessage = MessageData(
                    "user" ,
                    message ,
                    isSent = true ,
                    isDelivered = true ,
                    isSeen = true ,
                    isFav = false ,
                    bitmap = image ,
                    sendingDate = LocalDate.now() ,
                )
                messageList.add(userMessage)
                _messageList.value += userMessage
                val response = chat.sendMessage(message)
                NetworkResponse.Success(response)
                withContext(Dispatchers.IO) {
                    val modelMessage = MessageData(
                        "model" ,
                        response.text.toString() ,
                        isSent = true ,
                        isDelivered = true ,
                        isSeen = true ,
                        isFav = false ,
                        sendingDate = LocalDate.now()
                    )
                    messageList.add(modelMessage)
                    _messageList.value += modelMessage
                    Log.i("gemini" , "response form gemini : ${response.text.toString()}")
                }
            } catch (e: Exception) {
                NetworkResponse.Error(e.message.toString())
            }
        }
    }
}







