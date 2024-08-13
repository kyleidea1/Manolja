package com.example.manolja.data.database

import RecordEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.manolja.data.dao.RecordDao
import com.example.manolja.data.dao.UserDao
import com.example.manolja.data.entity.UserEntity

@Database(entities = [UserEntity::class, RecordEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun recordDao(): RecordDao
}
