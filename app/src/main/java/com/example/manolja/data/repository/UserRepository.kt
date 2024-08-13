package com.example.manolja.data.repository

import com.example.manolja.data.dao.UserDao
import com.example.manolja.data.entity.UserEntity
import java.util.UUID

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getUserById(uuid: String): UserEntity? {
        return userDao.getUserByUuid(uuid)
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }

    suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }
}
