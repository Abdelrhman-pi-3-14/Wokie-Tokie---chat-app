package com.example.walkie_talkie.system.private_chat.data.remote

import android.util.Log
import com.example.walkie_talkie.system.common.Constants.WEB_SOCKET_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class ChatWebSocketListener : WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
        Log.d("WebSocket", "✅ Connected to server")
        webSocket.send("{\"content\":\"Hello from Android\"}")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        Log.d("WebSocket", "📩 Received: $text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        Log.d("WebSocket", "📩 Received bytes: ${bytes.hex()}")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        Log.d("WebSocket", "🔌 Closing: $code / $reason")
        webSocket.close(1000, null)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.e("WebSocket", "❌ Error: ${t.message}", t)
    }
}

fun connectToServer(senderId: String, receiverId: String) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("$WEB_SOCKET_BASE_URL$senderId/$receiverId/")
        .build()

    client.newWebSocket(request, ChatWebSocketListener())
    client.dispatcher.executorService.isShutdown
}
