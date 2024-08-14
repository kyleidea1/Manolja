package com.example.manolja.domain

data class Message(
    val sender: String = "",
    val text: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val isCurrentUser: Boolean = false
)