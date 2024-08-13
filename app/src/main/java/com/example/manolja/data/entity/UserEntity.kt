package com.example.manolja.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val uuid: String,
    val nickname: String,
    val exp: Int
)