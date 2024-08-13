package com.example.manolja.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val memberNo: Int = 0,
    val nickname: String,
    val uuid: String,
    val level: Int,
    val exp: Int,
    val day: Int
)