package com.example.manolja.data

data class Message(
    val sender: String = "",
    val text: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val isCurrentUser: Boolean = false
)